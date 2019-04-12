package com.pyp.pypresale.Service.ServiceImp;

import com.pyp.pypresale.Entity.Collection;
import com.pyp.pypresale.Entity.Good;
import com.pyp.pypresale.Entity.User;
import com.pyp.pypresale.Enums.ResultEnum;
import com.pyp.pypresale.Repository.CollectionRepository;
import com.pyp.pypresale.Repository.GoodRepository;
import com.pyp.pypresale.Repository.UserRepository;
import com.pyp.pypresale.Service.CollectionService;
import com.pyp.pypresale.Utils.Result;
import com.pyp.pypresale.Utils.ResultUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kangjian
 * @date 2019/4/3 23:50
 */
@Service
public class CollectionServiceImp implements CollectionService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CollectionRepository collectionRepository;

    @Autowired
    private GoodRepository goodRepository;

    //收藏商品
    @Transactional
    @Override
    public Result collectionOfGood(Integer goodID) {

        //拿到当前登录的用户
        Subject subject=SecurityUtils.getSubject();
        String studentID= (String) subject.getPrincipal();
        User user=userRepository.findByStudentID(studentID);


        Collection collection=new Collection();
        collection.setUserID(user.getUserID());
        collection.setGoodID(goodID);
        collectionRepository.saveAndFlush(collection);
        return ResultUtils.success(ResultEnum.COLLECTION_GOOD_IS_SUCCESS);//收藏商品成功
    }



    //取消收藏商品
    @Transactional
    @Override
    public Result cancelGoodOfCollection(Integer goodID) {

        //拿到当前登录的用户
        Subject subject=SecurityUtils.getSubject();
        String studentID= (String) subject.getPrincipal();
        User user=userRepository.findByStudentID(studentID);


        if (collectionRepository.cancelGoodOfCollection(user.getUserID(),goodID)!=0){
            return ResultUtils.success(ResultEnum.NOT_COLLECTION_GOOD_IS_SUCCESS);//取消收藏商品成功
        }
        return ResultUtils.success(ResultEnum.NOT_COLLECTION_GOOD_IS_FAIL);//取消收藏商品失败
    }

    //查看当前用户的收藏商品
    @Override
    public Result findCollectionGoods() {

        //拿到当前登录的用户
        Subject subject=SecurityUtils.getSubject();
        String studentID= (String) subject.getPrincipal();
        User user=userRepository.findByStudentID(studentID);
        List<Good> goods=collectionRepository.findCollectionsByUserID(user.getUserID());

        return ResultUtils.success(goods,ResultEnum.FIND_COLLECTION_GOOD_IS_SUCCESS);//查看当前用户的收藏商品,成功

    }

}
