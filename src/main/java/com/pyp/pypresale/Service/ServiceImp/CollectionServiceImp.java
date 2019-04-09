package com.pyp.pypresale.Service.ServiceImp;

import com.pyp.pypresale.Service.CollectionService;
import com.pyp.pypresale.Utils.Result;
import org.springframework.stereotype.Service;

/**
 * @author kangjian
 * @date 2019/4/3 23:50
 */
@Service
public class CollectionServiceImp implements CollectionService {

    //查看当前用户的收藏商品
    @Override
    public Result findCollectionGoods(Integer userID) {
        return null;
    }


    //收藏商品
    @Override
    public Result collectionOfGood(Integer userID, Integer goodID) {
        return null;
    }


    //取消收藏商品
    @Override
    public Result cancelGoodOfCollection(Integer userID, Integer goodID) {
        return null;
    }
}
