package com.pyp.pypresale.Service;

import com.pyp.pypresale.Entity.User;
import com.pyp.pypresale.Utils.Result;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author kangjian
 * @date 2019/4/3 11:42
 */
public interface LoginService {

    /**
     * 游客模块
     */

    //访问主页
    Result index();

    //游客注册
    Result register(User user);

    //游客登录
    Result login(String studentID,String password);

    //搜索商品
    Result searchForGoods(@RequestParam("keyword") String keyword);

    //查看分类商品
    Result typeOfGoods(@RequestParam("type") String type);

    //查看商品详情
    Result viewGoodDetails(@RequestParam("goodID") Integer goodID);

    //查找所有的商品
    Result allOfGoods();

    //未登录
    Result notLogin();


}
