package com.example.kaidun.cinema.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.kaidun.cinema.controller.vo.DescCinemasRespVo;
import com.example.kaidun.cinema.controller.vo.SaveCinemasReqVo;
import com.example.kaidun.cinema.dao.entity.MoocCinemaT;
import com.example.kaidun.cinema.dao.mapper.MoocCinemaTMapper;
import com.example.kaidun.cinema.service.CinemaService;
import com.example.kaidun.utils.common.vo.BasePageVo;
import com.example.kaidun.utils.exception.CommonServiceException;
import com.example.kaidun.utils.tools.ToolUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: Administrator
 * @date: 2020/11/18 17:49
 * @description:
 */
@Slf4j
@Service
public class CinemaServiceImpl implements CinemaService {

    @Resource
    private MoocCinemaTMapper moocCinemaTMapper;

    @Override
    public IPage<DescCinemasRespVo> descCinemas(BasePageVo basePageVo) throws CommonServiceException {
        Page<BasePageVo> page = new Page<>(basePageVo.getNowPage(),basePageVo.getPageSize());


//        MoocCinemaT t = moocCinemaTMapper.selectById(1);

        IPage<DescCinemasRespVo> iPage = moocCinemaTMapper.selectCinemas(page);
        return iPage;
    }

    @Override
    public Boolean saveCinemas(SaveCinemasReqVo ReqVo) throws CommonServiceException {
        MoocCinemaT moocCinemaT = new MoocCinemaT();
//      moocCinemaT.setUuid(0);
        moocCinemaT.setCinemaName(ReqVo.getCinemaName());
        moocCinemaT.setCinemaPhone("1851111111");
        moocCinemaT.setBrandId(ToolUtils.str2Int(ReqVo.getBrandId()));
        moocCinemaT.setAreaId(ToolUtils.str2Int(ReqVo.getAreaId()));
        moocCinemaT.setHallIds(ReqVo.getHallTypeIds());
        moocCinemaT.setImgAddress(ReqVo.getCinemaImgAddress());
        moocCinemaT.setCinemaAddress(ReqVo.getCinemaImgAddress());
        moocCinemaT.setMinimumPrice(ToolUtils.str2Int(ReqVo.getCinemaPrice()));
        moocCinemaTMapper.insert(moocCinemaT);
        log.error(moocCinemaT.getUuid()+"");
        return true;
    }
}
