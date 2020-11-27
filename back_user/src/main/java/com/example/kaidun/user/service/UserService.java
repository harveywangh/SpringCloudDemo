package com.example.kaidun.user.service;

import com.example.kaidun.user.controller.vo.LoginRequestVo;
import com.example.kaidun.user.dao.entity.KdaStudentUser;
import com.example.kaidun.user.dao.entity.MoocBackendUserT;
import com.example.kaidun.utils.exception.CommonServiceException;

/**
 * @author: Administrator
 * @date: 2020/11/16 15:07
 * @description:
 */
public interface UserService {

    public MoocBackendUserT selectUserByLoginUser(LoginRequestVo loginRequestVo) throws CommonServiceException;

}
