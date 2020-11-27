package com.example.kaidun.film.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.kaidun.film.controller.vo.AddFilmInfoReqVo;
import com.example.kaidun.film.controller.vo.DescribeActorsRespVo;
import com.example.apis.film.vo.DescribeFilmRespVo;
import com.example.kaidun.film.service.FilmsService;
import com.example.kaidun.utils.common.vo.BasePageVo;
import com.example.kaidun.utils.common.vo.BaseResponseVo;
import com.example.kaidun.utils.exception.CommonServiceException;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author: Administrator
 * @date: 2020/11/18 13:41
 * @description:
 */
@Slf4j
@RestController
@RequestMapping(value = "/films")
public class FilmController {

    @Autowired
    FilmsService filmsService;

    @Value("${server.port}")
    Integer port;

//    @RequestMapping(value = "/actors", method = RequestMethod.POST)
    @GetMapping(value = "/actors")
    public BaseResponseVo describeActors(@RequestBody  BasePageVo basePageVo) throws CommonServiceException {
        basePageVo.checkParam();
        IPage<DescribeActorsRespVo> iPage = filmsService.actorList(basePageVo);
        return BaseResponseVo.success(describePageResult(iPage,"actors"));
    }


    @RequestMapping(value = "/{filmId}",method = RequestMethod.GET)
    public BaseResponseVo describeFilmById(@PathVariable("filmId") String filmId) throws CommonServiceException {
        DescribeFilmRespVo obj = filmsService.describeFilmById(filmId);
        if(obj==null){
            return BaseResponseVo.success();
        }
        log.error("当前调用的film端口是：" + port);
        return BaseResponseVo.success(obj);
    }

    @PostMapping(value = "/film:add")
    public BaseResponseVo addFilmInfo(@RequestBody AddFilmInfoReqVo addFilmInfoReqVo) throws CommonServiceException{
        addFilmInfoReqVo.checkParam();
        filmsService.addFilmInfo(addFilmInfoReqVo);
        return BaseResponseVo.success();
    }

    private Map<String,Object> describePageResult(IPage iPage,String title){
        Map<String, Object> resultMap = Maps.newHashMap();
        resultMap.put("totalSize", iPage.getTotal());//总数据
        resultMap.put("totalPages", iPage.getPages());//总页数
        resultMap.put("pageSize", iPage.getSize());//当前页条数
        resultMap.put("nowPage", iPage.getCurrent());//当前页数
        resultMap.put("actors", iPage.getRecords());
        return resultMap;
    }

}
