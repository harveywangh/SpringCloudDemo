package com.example.kaidun.user.controller.vo;

import com.example.kaidun.utils.common.vo.BaseRequestVo;
import com.example.kaidun.utils.exception.CommonServiceException;
import com.example.kaidun.utils.tools.ToolUtils;
import lombok.Data;

/**
 * @author: Administrator
 * @date: 2020/11/16 13:28
 * @description:
 */
@Data
public class LoginRequestVo extends BaseRequestVo {

    private String password;
    private String userCode;
    private Integer areaCode;

    @Override
    public void checkParam() throws CommonServiceException {
        //TODO 验证数据合法性
        if (ToolUtils.strIsNull(userCode) || ToolUtils.strIsNull(password)) {
            throw new CommonServiceException(404, "帐号或者密码为空");
        }

    }
}
