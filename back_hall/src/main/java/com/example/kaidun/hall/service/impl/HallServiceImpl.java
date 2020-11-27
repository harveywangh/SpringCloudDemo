package com.example.kaidun.hall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.apis.film.vo.DescribeFilmRespVo;
import com.example.kaidun.hall.apis.FilmFeignApi;
import com.example.kaidun.hall.controller.vo.DescHallsRepsVo;
import com.example.kaidun.hall.controller.vo.DescHallsReqVo;
import com.example.kaidun.hall.controller.vo.SaveHallsReqVo;
import com.example.kaidun.hall.dao.entity.MoocFieldT;
import com.example.kaidun.hall.dao.entity.MoocHallFilmInfoT;
import com.example.kaidun.hall.dao.mapper.MoocFieldTMapper;
import com.example.kaidun.hall.dao.mapper.MoocHallFilmInfoTMapper;
import com.example.kaidun.hall.service.HallService;
import com.example.kaidun.utils.common.vo.BaseResponseVo;
import com.example.kaidun.utils.exception.CommonServiceException;
import com.example.kaidun.utils.tools.ToolUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author: Administrator
 * @date: 2020/11/19 15:55
 * @description:
 */

@Service
public class HallServiceImpl implements HallService {

    @Resource
    private MoocFieldTMapper fieldTMapper;

    @Resource
    private MoocHallFilmInfoTMapper hallFilmInfoTMapper;

    @Autowired
    private RestTemplate restTemplate;

    @Resource
    private FilmFeignApi filmFeignApi;

    @Override
    public IPage<DescHallsRepsVo> descHalls(DescHallsReqVo descHallsReqVo) throws CommonServiceException {
        Page<DescHallsReqVo> page = new Page<>(descHallsReqVo.getNowPage(), descHallsReqVo.getPageSize());
//2中写法
        //        IPage<DescHallsRepsVo> iPage = fieldTMapper.selecthalls(page, descHallsReqVo.getCinemaId());
        QueryWrapper wrapper = new QueryWrapper();
        if (ToolUtils.strIsNotNul(descHallsReqVo.getCinemaId())) {
            wrapper.eq("cinema_id", descHallsReqVo.getCinemaId());
        }
        IPage<DescHallsRepsVo> iPage = fieldTMapper.selecthalls(page, wrapper);
        return iPage;
    }


    @Override
    @Transactional
    public void saveHalls(SaveHallsReqVo addHallVoReq) throws CommonServiceException {
        try {
            //播放厅列表数据
            MoocFieldT moocFieldT = new MoocFieldT();
            moocFieldT.setCinemaId(ToolUtils.str2Int(addHallVoReq.getCinemaId()));
            moocFieldT.setFilmId(ToolUtils.str2Int(addHallVoReq.getFilmId()));
            moocFieldT.setBeginTime(addHallVoReq.getBeginTime());
            moocFieldT.setEndTime(addHallVoReq.getEndTime());
            moocFieldT.setHallId(ToolUtils.str2Int(addHallVoReq.getHallTypeId()));
            moocFieldT.setHallName(addHallVoReq.getHallName());
            moocFieldT.setPrice(ToolUtils.str2Int(addHallVoReq.getFilmPrice()));
            fieldTMapper.insert(moocFieldT);

            MoocHallFilmInfoT moocHallFilmInfoT = selectObjById(addHallVoReq.getFilmId());
            //播放厅对应的影片数据，影片缓存数据，缓存李有一份
            hallFilmInfoTMapper.insert(moocHallFilmInfoT);
        } catch (Exception e) {
            throw new CommonServiceException(500, e.getMessage());
        }

    }




//    @Autowired
//    private LoadBalancerClient eurakeClient;
    //播放厅对应的影片数据
//    public MoocHallFilmInfoT selectObjById(String filmId) {
//
////        ServiceInstance choose = eurakeClient.choose("film-service");
////        String host = choose.getHost();
////        int port = choose.getPort();
//
//        String uri = "/films/"+filmId;
//        String url = "http://film-service" + uri ;
//
//        //JSONObject ?
//        JSONObject baseResponseVoJson = restTemplate.getForObject(url,JSONObject.class);
////        baseResponseVoJson.get("data");
//        JSONObject dataJson = baseResponseVoJson.getJSONObject("data");
//
//        MoocHallFilmInfoT hallFilmInfoT = new MoocHallFilmInfoT();
//
//        hallFilmInfoT.setFilmId(dataJson.getInteger("filmId"));
//        hallFilmInfoT.setFilmName(dataJson.getString("filmName"));
//        hallFilmInfoT.setFilmLength(dataJson.getString("filmLength"));
//        hallFilmInfoT.setFilmCats(dataJson.getString("filmCats"));
//        hallFilmInfoT.setActors(dataJson.getString("actors"));
//        hallFilmInfoT.setImgAddress(dataJson.getString("imgAddress"));
//        return hallFilmInfoT;
//    }


    public MoocHallFilmInfoT selectObjById(String filmId) throws CommonServiceException {
        BaseResponseVo<DescribeFilmRespVo> baseResponseVo = filmFeignApi.describeFilmById(filmId);
        DescribeFilmRespVo filmResult = baseResponseVo.getData();
        if(filmResult == null || ToolUtils.strIsNull(filmResult.getFilmId())){
            throw new CommonServiceException(404,"抱歉,未能找到对应电影信息。filmId : "+filmId);
        }
        MoocHallFilmInfoT hallFilmInfoT = new MoocHallFilmInfoT();
        hallFilmInfoT.setFilmId(ToolUtils.str2Int(filmResult.getFilmId()));
        hallFilmInfoT.setFilmName(filmResult.getFilmName());
        hallFilmInfoT.setFilmLength(filmResult.getFilmLength());
        hallFilmInfoT.setFilmCats(filmResult.getFilmCats());
        hallFilmInfoT.setActors(filmResult.getActors());
        hallFilmInfoT.setImgAddress(filmResult.getImgAddress());
        return hallFilmInfoT;
    }


}
