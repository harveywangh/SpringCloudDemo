package com.example.kaidun.hall.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.kaidun.hall.controller.vo.DescHallsRepsVo;
import com.example.kaidun.hall.controller.vo.DescHallsReqVo;
import com.example.kaidun.hall.controller.vo.SaveHallsReqVo;
import com.example.kaidun.hall.service.HallService;
import com.example.kaidun.utils.common.vo.BaseResponseVo;
import com.example.kaidun.utils.exception.CommonServiceException;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Map;

/**
 * @author: Administrator
 * @date: 2020/11/19 15:55
 * @description:
 */
@Slf4j
@RestController
@RequestMapping(value = "/halls")
public class HallController {

    @Resource
    private HallService hallService;

    @GetMapping(value = "/")
    public BaseResponseVo descHalls(@RequestBody DescHallsReqVo descHallsReqVo, HttpServletRequest request) throws CommonServiceException {
        System.err.println("进来没有");
        Enumeration<String> headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()){
            String headerName = headerNames.nextElement();
            log.error("descHalls headerName:{},headerValue:{}",headerName,request.getHeader(headerName));
        }
        descHallsReqVo.checkParam();
        IPage<DescHallsRepsVo> iPage = hallService.descHalls(descHallsReqVo);
        return BaseResponseVo.success(describePageResult(iPage, "halls"));
    }

    @PostMapping (value = "/hall:add")
    public BaseResponseVo saveHalls(@RequestBody SaveHallsReqVo saveHallsReqVo) throws CommonServiceException {
        saveHallsReqVo.checkParam();
        hallService.saveHalls(saveHallsReqVo);
        return BaseResponseVo.success();
    }



    private Map<String, Object> describePageResult(IPage iPage, String title) {
        Map<String, Object> resultMap = Maps.newHashMap();
        resultMap.put("totalSize", iPage.getTotal());//总数据
        resultMap.put("totalPages", iPage.getPages());//总页数
        resultMap.put("pageSize", iPage.getSize());//当前页条数
        resultMap.put("nowPage", iPage.getCurrent());//当前页数
        resultMap.put(title, iPage.getRecords());
        return resultMap;
    }


}
