package com.example.kaidun.film.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.kaidun.film.controller.vo.AddFilmInfoReqVo;
import com.example.kaidun.film.controller.vo.DescribeActorsRespVo;
import com.example.apis.film.vo.DescribeFilmRespVo;
import com.example.kaidun.utils.common.vo.BasePageVo;
import com.example.kaidun.utils.exception.CommonServiceException;

/**
 * @author: Administrator
 * @date: 2020/11/18 13:51
 * @description:
 */
public interface FilmsService {

    IPage<DescribeActorsRespVo> actorList(BasePageVo basePageVo) throws CommonServiceException;


    DescribeFilmRespVo describeFilmById(String filmId) throws CommonServiceException;

    void addFilmInfo(AddFilmInfoReqVo saveFilmVo) throws CommonServiceException;
}
