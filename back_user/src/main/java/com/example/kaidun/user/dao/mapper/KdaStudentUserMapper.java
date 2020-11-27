package com.example.kaidun.user.dao.mapper;

import com.example.kaidun.user.dao.entity.KdaStudentUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 学员移动登陆用户管理表 Mapper 接口
 * </p>
 *
 * @author harvey
 * @since 2020-11-17
 */
public interface KdaStudentUserMapper extends BaseMapper<KdaStudentUser> {

    public KdaStudentUser selectListInfo(@Param("pojo") KdaStudentUser pojo);

}
