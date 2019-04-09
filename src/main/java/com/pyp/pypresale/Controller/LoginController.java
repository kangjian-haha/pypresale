package com.pyp.pypresale.Controller;

import com.pyp.pypresale.Entity.User;
import com.pyp.pypresale.Service.ServiceImp.LoginServiceImp;
import com.pyp.pypresale.Utils.Result;
import com.pyp.pypresale.Utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author kangjian
 * @date 2019/4/3 11:06
 */

@RestController
@RequestMapping(value = "/guest")
public class LoginController {

    @Autowired
    private LoginServiceImp loginServiceImp;


    //访问主页
    @GetMapping(value = "/index")
    public Result index() {
        return ResultUtils.error(676767,"主页尚未做..");
    }

    //游客注册
    @PostMapping(value = "/register")
    public Result register(User user) {
        return loginServiceImp.register(user);
    }

    //游客登录
    @PostMapping(value = "/login")
    public Result login(String studentID, String password) {
        return loginServiceImp.login(studentID, password);
    }

    //搜索商品
    @GetMapping(value = "/searchForGoods")
    public Result searchForGoods(String keyword) {
        return loginServiceImp.searchForGoods(keyword);
    }

    //查看分类商品
    @GetMapping(value = "/typeOfGoods")
    public Result typeOfGoods(String type) {
        return loginServiceImp.typeOfGoods(type);
    }

    //查看商品详情
    @GetMapping(value = "/viewGoodDetails")
    public Result viewGoodDetails(Integer goodID) {
        return loginServiceImp.viewGoodDetails(goodID);
    }

    //查找所有的商品
    @GetMapping(value = "/allOfGoods")
    public Result allOfGoods() {
        return loginServiceImp.allOfGoods();
    }

    //未登录
    @RequestMapping(value = "/notLogin")
    public Result notLogin() {
        return loginServiceImp.notLogin();
    }



}
