package com.example.kaidun.utils.common.vo;

import com.example.kaidun.utils.exception.CommonServiceException;

/**
 * @author: Administrator
 * @date: 2020/11/16 13:14
 * @description:
 */
public abstract class BaseRequestVo {

    public abstract void checkParam() throws  CommonServiceException;



}
