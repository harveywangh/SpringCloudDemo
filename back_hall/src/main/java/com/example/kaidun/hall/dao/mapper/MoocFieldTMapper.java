package com.example.kaidun.hall.dao.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.kaidun.hall.controller.vo.DescHallsRepsVo;
import com.example.kaidun.hall.controller.vo.DescHallsReqVo;
import com.example.kaidun.hall.dao.entity.MoocFieldT;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 放映场次表 Mapper 接口
 * </p>
 *
 * @author harvey
 * @since 2020-11-19
 */
public interface MoocFieldTMapper extends BaseMapper<MoocFieldT> {

//    IPage<DescHallsRepsVo> selecthalls(Page<DescHallsRepsVo> page,@Param("cinemaId") String cinemaId)

    IPage<DescHallsRepsVo> selecthalls(Page<DescHallsReqVo> page, @Param("ew") QueryWrapper wrapper);

}
