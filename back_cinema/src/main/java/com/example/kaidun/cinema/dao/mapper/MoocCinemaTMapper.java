package com.example.kaidun.cinema.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.kaidun.cinema.controller.vo.DescCinemasRespVo;
import com.example.kaidun.cinema.dao.entity.MoocCinemaT;
import com.example.kaidun.utils.common.vo.BasePageVo;

/**
 * <p>
 * 影院信息表 Mapper 接口
 * </p>
 *
 * @author harvey
 * @since 2020-11-18
 */
public interface MoocCinemaTMapper extends BaseMapper<MoocCinemaT> {

    IPage<DescCinemasRespVo> selectCinemas(Page<BasePageVo> page);

}
