package com.pyp.pypresale.Controller;

import com.pyp.pypresale.Service.ServiceImp.CollectionServiceImp;
import com.pyp.pypresale.Utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kangjian
 * @date 2019/4/10 20:55
 */
@RestController
@RequestMapping(value = "/collection")
public class CollectionController {

    @Autowired
    private CollectionServiceImp collectionServiceImp;

    //收藏商品
    @PostMapping(value = "/collectionOfGood")
    public Result collectionOfGood(Integer goodID) {
        return collectionServiceImp.collectionOfGood(goodID);
    }


    //取消收藏商品
    @PostMapping(value = "/cancelGoodOfCollection")
    public Result cancelGoodOfCollection(Integer goodID) {
        return collectionServiceImp.cancelGoodOfCollection(goodID);
    }

    //查看当前用户的收藏商品
    @PostMapping(value = "/findCollectionGoods")
    public Result findCollectionGoods() {
        return collectionServiceImp.findCollectionGoods();
    }


}
