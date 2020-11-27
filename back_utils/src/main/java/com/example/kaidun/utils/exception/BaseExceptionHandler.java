package com.example.kaidun.utils.exception;


import com.example.kaidun.utils.common.vo.BaseResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


@Slf4j
@ControllerAdvice
public class BaseExceptionHandler {

    @ExceptionHandler(CommonServiceException.class)
    @ResponseBody
    public BaseResponseVo serviceExceptionHandler(
            HttpServletRequest request , CommonServiceException e){
        log.error("CommonServiceExcepion,code:"+e.getCode()+",message:"+e.getMessage());
        return  BaseResponseVo.serviceException(e);
    }

}
