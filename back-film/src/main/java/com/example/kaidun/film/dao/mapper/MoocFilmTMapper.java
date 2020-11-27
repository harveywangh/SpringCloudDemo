package com.example.kaidun.film.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.apis.film.vo.DescribeFilmRespVo;
import com.example.kaidun.film.dao.entity.MoocFilmT;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 影片主表 Mapper 接口
 * </p>
 *
 * @author harvey
 * @since 2020-11-18
 */
public interface MoocFilmTMapper extends BaseMapper<MoocFilmT> {


    DescribeFilmRespVo selectFilmById(@Param("filmId") String filmId);
}
