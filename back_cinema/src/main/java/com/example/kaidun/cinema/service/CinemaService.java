package com.example.kaidun.cinema.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.kaidun.cinema.controller.vo.DescCinemasRespVo;
import com.example.kaidun.cinema.controller.vo.SaveCinemasReqVo;
import com.example.kaidun.utils.common.vo.BasePageVo;
import com.example.kaidun.utils.exception.CommonServiceException;

/**
 * @author: Administrator
 * @date: 2020/11/18 17:49
 * @description:
 */


public interface CinemaService {


    public IPage<DescCinemasRespVo> descCinemas(BasePageVo basePageVo) throws CommonServiceException;

    public Boolean saveCinemas(SaveCinemasReqVo saveCinemasReqVo) throws CommonServiceException;

}
