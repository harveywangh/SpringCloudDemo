package com.example.kaidun.utils.common.vo;

import com.example.kaidun.utils.exception.CommonServiceException;
import lombok.Data;

/**
 * @author: Administrator
 * @date: 2020/11/16 13:15
 * @description:
 */
@Data
public class BaseResponseVo<M> {

    private Integer code;//业务编号
    private String message;//提示信息
    private M data;//业务数据返回值集合

    private BaseResponseVo() {
    }//不允许实例


    //成功无参数
    public static BaseResponseVo success() {
        BaseResponseVo responseVo = new BaseResponseVo();
        responseVo.setCode(200);
        responseVo.setMessage("");
//        responseVo.setData(null);
        return responseVo;
    }

    //成功有参数
    public static <M> BaseResponseVo success(M data) {
        BaseResponseVo responseVo = new BaseResponseVo();
        responseVo.setCode(200);
        responseVo.setMessage("");
        responseVo.setData(data);
        return responseVo;
    }


    //出现业务异常--无参数集合
    public static <M> BaseResponseVo serviceException(CommonServiceException e) {
        BaseResponseVo responseVo = new BaseResponseVo();
        responseVo.setCode(e.getCode());
        responseVo.setMessage(e.getMessage());

        return responseVo;
    }

    //未登录异常
    public static <M> BaseResponseVo noLogin() {
        BaseResponseVo responseVo = new BaseResponseVo();
        responseVo.setCode(401);
        responseVo.setMessage("用户请登录");
        return responseVo;
    }



}
