package com.pyp.pypresale.Service.ServiceImp;

import com.pyp.pypresale.Entity.Good;
import com.pyp.pypresale.Entity.Orders;
import com.pyp.pypresale.Entity.User;
import com.pyp.pypresale.Enums.ResultEnum;
import com.pyp.pypresale.Repository.GoodRepository;
import com.pyp.pypresale.Repository.OrderRepository;
import com.pyp.pypresale.Repository.UserRepository;
import com.pyp.pypresale.Service.GoodService;
import com.pyp.pypresale.Utils.Result;
import com.pyp.pypresale.Utils.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author kangjian
 * @date 2019/4/3 23:50
 */
@Slf4j
@Service
public class GoodServiceImp implements GoodService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GoodRepository goodRepository;

    @Autowired
    private OrderRepository orderRepository;



    //购买商品
    //***************************************将订单存进数据库中出现BUG!!********************************************
    //***************************************已修复,避免使用MySQL关键字.例:order ***********************************
    @Transactional
    @Override
    public Result buyGood(Integer goodID) {

        if (goodRepository.existsByGoodIDAndSaleingNot(goodID,1)){
            return ResultUtils.error(ResultEnum.BUY_IS_FAIL);//购买失败! 此商品已不在售.
        }

        goodRepository.updateGoodIDIsNotSaleing(goodID);//将商品从'在售'变成'不在售'

        Subject subject=SecurityUtils.getSubject();
        String studentID= (String) subject.getPrincipal();//拿到当前登录的用户学号
        User user = userRepository.findByStudentID(studentID);//拿到当前登录的用户的所有信息

        Orders orders =new Orders();//新建订单
        orders.setUserID(user.getUserID());
        orders.setGoodID(goodID);


        log.info("将订单存进数据库中,前");
        orderRepository.saveAndFlush(orders);//将订单存进数据库中

        log.info("订单生成成功. 订单号为 ["+ orders.getOrderID()+"]");

        return ResultUtils.success(ResultEnum.BUY_GOOD_SUCCESS);//购买商品成功
    }


    //发布商品
    @Transactional
    @Override
    public Result releaseGood(Good good) {

        //判断输入是否为空
        if (good.getTitle().isEmpty()){
            return ResultUtils.error(ResultEnum.RELEASE_GOOD_IS_FAIL_TITLE_IS_EMPTY);//发布失败! 商品标题不能为空
        }else if (good.getPrice()==0){
            return ResultUtils.error(ResultEnum.RELEASE_GOOD_IS_FAIL_PRICE_IS_EMPTY);//发布失败! 商品价格不能为0
        }

        //拿到当前登录的用户
        Subject subject=SecurityUtils.getSubject();
        String studentID= (String) subject.getPrincipal();
        User user=userRepository.findByStudentID(studentID);

        good.setUserID(user.getUserID());
        good.setSaleing(1);

        goodRepository.save(good);

        log.info("用户 ["+user.getUsername()+"] :发布 标题为<"+good.getTitle()+"> 的商品成功.");

        return ResultUtils.success(ResultEnum.RELEASE_GOOD_SUCCESS);//发布商品成功
    }


    //删除自己发布的商品
    @Transactional
    @Override
    public Result deleteGood(Integer goodID) {

        //拿到当前登录的用户
        Subject subject=SecurityUtils.getSubject();
        String studentID= (String) subject.getPrincipal();
        User user=userRepository.findByStudentID(studentID);

        if (goodRepository.deleteGoodById(goodID,user.getUserID())!=0){
            return ResultUtils.success(ResultEnum.DELETE_GOOD_IS_SUCCESS);//删除商品成功
        }
        return ResultUtils.error(100,"删除失败");//删除商品成功
    }


    //查找自己发布的商品
    @Override
    public Result findSelfGoods() {

        //拿到当前登录的用户
        Subject subject=SecurityUtils.getSubject();
        String studentID= (String) subject.getPrincipal();
        User user=userRepository.findByStudentID(studentID);

        List<Good> goods=goodRepository.findAllByUserID(user.getUserID());

        return ResultUtils.success(goods,ResultEnum.FIND_SELFGOODS_IS_SUCCESS);//查看自己的商品成功
    }


    //修改商品信息
    @Transactional
    @Override
    public  Result alterGoodInformation(String title,String text,float price,String type,Integer goodID){
        if (title.isEmpty()){
            return ResultUtils.error(ResultEnum.UPDATE_GOOD_IS_FAIL_TITLE_IS_EMPTY);//修改失败! 商品标题不能为空
        }else if (price==0){
            return ResultUtils.error(ResultEnum.UPDATE_GOOD_IS_FAIL_PRICE_IS_EMPTY);//修改失败! 商品价格不能为0
        }

        goodRepository.alterGoodInformation(title,text,price,type,goodID);//修改商品信息
        return ResultUtils.success(ResultEnum.UPDATE_GOOD_SUCCESS);//修改商品成功
    }
}
