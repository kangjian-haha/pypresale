package com.pyp.pypresale.Service;

import com.pyp.pypresale.Entity.Result;
import com.pyp.pypresale.Entity.User;

public interface UserService {
    //普通用户功能
    Result userRegister(User user);//用户注册
    Result userLogin();//用户登录

    //管理员功能
    Result findAllOfUsers();//查找所有用户
    Result findOneOfUser();//查找单个用户



}
