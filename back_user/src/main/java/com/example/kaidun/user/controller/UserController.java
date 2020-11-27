package com.example.kaidun.user.controller;

import com.example.kaidun.user.controller.vo.LoginRequestVo;
import com.example.kaidun.user.dao.entity.KdaStudentUser;
import com.example.kaidun.user.dao.entity.MoocBackendUserT;
import com.example.kaidun.user.service.UserService;
import com.example.kaidun.utils.common.vo.BaseResponseVo;
import com.example.kaidun.utils.exception.CommonServiceException;
import com.example.kaidun.utils.tools.JwtTokenUtil;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: Administrator
 * @date: 2020/11/16 13:23
 * @description:
 */


@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Resource
    UserService userService;


    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public BaseResponseVo login(@RequestBody LoginRequestVo entity) throws CommonServiceException {

        //验证帐号  密码  areacode  数据校验
        entity.checkParam();
        //查询用户信息，并且校验
        MoocBackendUserT userT = userService.selectUserByLoginUser(entity);

        JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
        //获取randomKey 6 位随机数
        String  randomKey = jwtTokenUtil.getRandomKey();
        //根据用于唯一ID和randomKey 生成token
        String token = jwtTokenUtil.generateToken(userT.getUuid().toString(),randomKey);
        Map<String,String> map = new HashMap<>();
        map.put("token",token);
        map.put("randomKey",randomKey);
        return BaseResponseVo.success(map);
    }


}
