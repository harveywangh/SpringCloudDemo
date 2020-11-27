package com.example.kaidun.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.kaidun.user.controller.vo.LoginRequestVo;
import com.example.kaidun.user.dao.entity.KdaStudentUser;
import com.example.kaidun.user.dao.entity.MoocBackendUserT;
import com.example.kaidun.user.dao.mapper.KdaStudentUserMapper;
import com.example.kaidun.user.dao.mapper.MoocBackendUserTMapper;
import com.example.kaidun.user.service.UserService;
import com.example.kaidun.utils.exception.CommonServiceException;
import com.example.kaidun.utils.tools.MD5Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: Administrator
 * @date: 2020/11/16 15:07
 * @description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private MoocBackendUserTMapper moocBackendUserTMapper;

    @Override
    public MoocBackendUserT selectUserByLoginUser(LoginRequestVo loginRequestVo) throws CommonServiceException {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("user_name", loginRequestVo.getUserCode());
//        wrapper.eq("user_pwd", loginRequestVo.getPassword());
        MoocBackendUserT userT = moocBackendUserTMapper.selectOne(wrapper);
//        KdaStudentUser pojo = new KdaStudentUser();
//        pojo.setKsuUserCode(loginRequestVo.getUserCode());
//        KdaStudentUser userT = KdaStudentUserMapper.selectListInfo(pojo);

        if (userT == null) {
            throw new CommonServiceException(404, "用户名不存在");
        }
        if (!userT.getUserPwd().equals(MD5Util.MD5(loginRequestVo.getPassword()))) {
            throw new CommonServiceException(500, "用户密码错误11");
        }
        return userT;
    }
}
