package com.example.apis.film.api;

import com.example.apis.film.vo.DescribeFilmRespVo;
import com.example.kaidun.utils.common.vo.BaseResponseVo;
import com.example.kaidun.utils.exception.CommonServiceException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author: Administrator
 * @date: 2020/11/25 15:27
 * @description: Film提供的公共接口服务
 */
public interface FilmFeignApis {



    /**
     * 对外暴露的接口服务
     *
     * @param filmId
     * @return
     *
     *
     * @throws CommonServiceException
     */
    @RequestMapping(value = "/films/{filmId}", method = RequestMethod.GET)
    BaseResponseVo<DescribeFilmRespVo> describeFilmById(@PathVariable("filmId") String filmId) throws CommonServiceException;



}
