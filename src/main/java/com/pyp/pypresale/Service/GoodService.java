package com.pyp.pypresale.Service;

import com.pyp.pypresale.Entity.Good;
import com.pyp.pypresale.Utils.Result;

/**
 * @author kangjian
 * @date 2019/4/3 23:43
 */
public interface GoodService {

    //购买商品
    Result buyGood(Integer goodID);

    //发布商品
    Result releaseGood(Good good);

    //删除自己发布的商品
    Result deleteGood(Integer goodID);

    //查找自己发布的商品
    Result findSelfGoods();

    //修改商品信息
    Result alterGoodInformation(String title,String text,float price,String type,Integer goodID);



}
