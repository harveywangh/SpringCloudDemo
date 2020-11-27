package com.example.kaidun.film.dao.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.kaidun.film.controller.vo.DescribeActorsRespVo;
import com.example.kaidun.film.dao.entity.MoocActorT;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.kaidun.film.dao.entity.MoocFilmActorT;

/**
 * <p>
 * 演员表 Mapper 接口
 * </p>
 *
 * @author harvey
 * @since 2020-11-18
 */
public interface MoocActorTMapper extends BaseMapper<MoocActorT> {

    IPage<DescribeActorsRespVo> selectActors(Page<DescribeActorsRespVo> page);

}
