package com.example.kaidun.utils.exception;

import lombok.Data;

/**
 * @author: Administrator
 * @date: 2020/11/16 13:19
 * @description:
 */
@Data
public class CommonServiceException extends Exception {

    private Integer code;

    private String message;

    public CommonServiceException(Integer code , String message){
        this.code = code;
        this.message = message;
    }


}
