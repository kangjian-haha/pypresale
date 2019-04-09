package com.pyp.pypresale.Controller;

import com.pyp.pypresale.Entity.Good;
import com.pyp.pypresale.Service.ServiceImp.GoodServiceImp;
import com.pyp.pypresale.Utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kangjian
 * @date 2019/4/6 11:24
 */
@RestController
@RequestMapping(value = "/good")
public class GoodController {

    @Autowired
    private GoodServiceImp goodServiceImp;

    //购买商品
    @PostMapping(value = "/buyGood")
    public Result buyGood(@RequestParam("goodID") Integer goodID) {
        return goodServiceImp.buyGood(goodID);
    }


    //发布商品
    @PostMapping(value = "/releaseGood")
    public Result releaseGood(Good good) {
        return goodServiceImp.releaseGood(good);//发布商品
    }


    //删除自己发布的商品
    @PostMapping(value = "/deleteGood")
    public Result deleteGood(Integer goodID) {
        return goodServiceImp.deleteGood(goodID);
    }


    //查找自己发布的商品
    @PostMapping(value = "/findSelfGoods")
    public Result findSelfGoods() {
        return goodServiceImp.findSelfGoods();
    }


}
