package com.pyp.pypresale.Service.ServiceImp;

import com.pyp.pypresale.Entity.Result;
import com.pyp.pypresale.Entity.User;
import com.pyp.pypresale.Enums.ResultEnum;
import com.pyp.pypresale.Repository.UserRepository;
import com.pyp.pypresale.Service.UserService;
import com.pyp.pypresale.Utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;

    //普通用户功能
    /**
     * 用户注册
     * @return
     */
    @Override
    @Transactional//事务管理
    public Result userRegister(User user) {
        if (userRepository.existsById(user.getStudentID()))
            return ResultUtils.error(ResultEnum.ID_IS_EXISTS);
        else
            return ResultUtils.success(userRepository.save(user),ResultEnum.REGISTER_IS_TRUE);
    }

    /**
     * 用户登录
     * @return
     */
    @Override
    public Result userLogin() {
        return null;
    }


    //管理员功能

    /**
     * 查找所有用户
     * @return
     */
    @Override
    public Result findAllOfUsers() {
        return null;
    }

    /**
     * 查找单个用户
     * @return
     */
    @Override
    public Result findOneOfUser() {
        return null;
    }
}
