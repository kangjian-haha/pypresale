package com.pyp.pypresale.Service;

import com.pyp.pypresale.Utils.Result;
import com.pyp.pypresale.Entity.User;

public interface UserService {

    //修改用户自己的基本信息
    Result alterUserInformation(String username,String sex,String telephone);

    //用户注销登录
    Result logout();

    //




}
