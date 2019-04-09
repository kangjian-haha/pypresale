package com.pyp.pypresale.Service.ServiceImp;

import com.pyp.pypresale.Utils.PatternUtils;
import com.pyp.pypresale.Utils.Result;
import com.pyp.pypresale.Entity.User;
import com.pyp.pypresale.Enums.ResultEnum;
import com.pyp.pypresale.Repository.UserRepository;
import com.pyp.pypresale.Service.UserService;
import com.pyp.pypresale.Utils.ResultUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;


    public String test(){
        String studentID= (String) SecurityUtils.getSubject().getPrincipal();
        User user=userRepository.findByStudentID(studentID);
        return user.getUsername();
    }


    //修改用户自己的基本信息
    @Transactional//事务管理
    @Override
    public Result alterUserInformation(String username,String sex,String telephone) {//User user
        //获得当前用户学号
        String studentID= (String) SecurityUtils.getSubject().getPrincipal();

        if (username.isEmpty()){//判断用户名是否为空
            return ResultUtils.error(ResultEnum.UPDATE_FAIL_USERNAME_IS_NOT_EMPTY);//修改失败! 用户名不能为空
        }else if (!telephone.isEmpty()){//如果电话不为空,则判断电话号码是否规范
            if (!PatternUtils.patternTelephone(telephone)){
                return ResultUtils.error(ResultEnum.UPDATE_FAIL_TELEPHONE_IS_NOT_STANDARD);//修改失败! 请规范输入手机号码
            }
        }

        if(userRepository.existsByUsernameAndStudentIDNot(username,studentID)){//判断(除了本人外)是否已存在这个用户名
            return ResultUtils.error(ResultEnum.UPDATE_FAIL_USERNAME_IS_EXISTS);//修改失败!此用户名已存在.
        }else if (userRepository.existsByTelephoneAndStudentIDNot(telephone,studentID)){//判断(除了本人外)是否已存在这个电话
            return ResultUtils.error(ResultEnum.UPDATE_FAIL_TELEPHONE_IS_EXISTS);//修改失败!此电话已存在.
        }



        if (!telephone.isEmpty()){
             userRepository.alterUserInformation(username,sex,telephone,studentID);//更新信息
        }else if (telephone.isEmpty()){
            userRepository.alterUserInformationNoTel(username,sex,studentID);//更新信息
        }

        User user=userRepository.findByStudentID(studentID);

        return ResultUtils.success(user,ResultEnum.UPDATE_USER_IS_SUCCESS);//修改用户信息成功
    }


    //用户注销登录
    @Override
    public Result logout() {
        Subject subject=SecurityUtils.getSubject();
        subject.logout();
        return ResultUtils.success(ResultEnum.LOGOUT_IS_SUCCESS);
    }
}
