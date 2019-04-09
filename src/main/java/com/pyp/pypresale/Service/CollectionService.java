package com.pyp.pypresale.Service;

import com.pyp.pypresale.Utils.Result;

/**
 * @author kangjian
 * @date 2019/4/3 23:47
 */
public interface CollectionService {

    //查看当前用户的收藏商品
    Result findCollectionGoods(Integer userID);

    //收藏商品
    Result collectionOfGood(Integer userID,Integer goodID);

    //取消收藏商品
    Result cancelGoodOfCollection(Integer userID,Integer goodID);
}
