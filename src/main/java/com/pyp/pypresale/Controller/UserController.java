package com.pyp.pypresale.Controller;

import com.pyp.pypresale.Entity.Result;
import com.pyp.pypresale.Entity.User;
import com.pyp.pypresale.Repository.UserRepository;

import com.pyp.pypresale.Service.ServiceImp.UserServiceImp;
import com.pyp.pypresale.Utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserServiceImp userServiceImp;


    /**
     * 功能:注册新一个用户
     * 地址:127.0.0.1:8080/userRegister
     * 参数:User user;
     *
     * 角色:user
     */
    @PostMapping("/userRegister")
    public Result userRegister(@Valid User user, BindingResult bindingResult){
        // 则写入数据库失败,并返回错误信息.并把message给到BindingResult里面
        if (bindingResult.hasErrors()){
            return ResultUtils.error(505,bindingResult.getFieldError().getDefaultMessage());
        }else
        return userServiceImp.userRegister(user);
    }


    //**************************************以下未做!!!!!!!******************************************************
    /**
     * 用户登陆
     * 127.0.0.1:8080/login
     */
    @PostMapping("/login")
    public String loginUser(
                            @RequestParam("StudentID") String studentID,
                            @RequestParam("Password") String password
    ){
        if (!userRepository.existsById(studentID)){
            return "用户不存在!";
        }
        else {
            if (password.equals(userRepository.findById(studentID).get().getPassword()))
                return "登陆成功!";
            else
                return "密码错误!";
        }
    }

    /**
     * 查询所有用户
     * 127.0.0.1:8080/findAll
     * @return
     */
    @GetMapping("/findAll")
    public List<User> findAll(){
        return userRepository.findAll();
    }



}
