package com.pyp.pypresale.Controller;

import com.pyp.pypresale.Service.ServiceImp.UserServiceImp;
import com.pyp.pypresale.Utils.Result;
import com.pyp.pypresale.Utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserServiceImp userServiceImp;

    //测试-当前登录的是谁
    @GetMapping(value = "/test")
    public String test(){
        return userServiceImp.test();
    }


    //用户注销登录
    @GetMapping(value = "/logout")
    public Result logout(){
        return userServiceImp.logout();
    }


    //修改用户自己的基本信息
    @PostMapping(value = "/alterUserInformation")
    public Result alterUserInformation(String username,String sex,String telephone){
        return userServiceImp.alterUserInformation(username,sex,telephone);
    }




}
