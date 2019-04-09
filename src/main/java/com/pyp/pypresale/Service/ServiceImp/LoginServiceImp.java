package com.pyp.pypresale.Service.ServiceImp;

import com.pyp.pypresale.Entity.Good;
import com.pyp.pypresale.Entity.User;
import com.pyp.pypresale.Enums.ResultEnum;
import com.pyp.pypresale.Repository.GoodRepository;
import com.pyp.pypresale.Repository.UserRepository;
import com.pyp.pypresale.Service.LoginService;
import com.pyp.pypresale.Utils.PatternUtils;
import com.pyp.pypresale.Utils.Result;
import com.pyp.pypresale.Utils.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author kangjian
 * @date 2019/4/3 11:42
 */

@Slf4j
@Service
public class LoginServiceImp implements LoginService {

    @Autowired
    private UserRepository userRepository;//访问数据库User表

    @Autowired
    private GoodRepository goodRepository;//访问数据库Good表


    //访问主页
    @Override
    public Result index() {
        return null;
    }

    //游客注册
    @Override
    public Result register(User user) {

        //判断输入是否为空
        if (user.getUsername().isEmpty()){
            return ResultUtils.error(ResultEnum.USERNAME_IS_NOT_EMPTY);//注册失败! 用户名不能为空
        }else if (user.getStudentID().isEmpty()){
            return ResultUtils.error(ResultEnum.STUDENTID_IS_NOT_EMPTY);//注册失败! 学号不能为空
        }else if (user.getPassword().isEmpty()){
            return ResultUtils.error(ResultEnum.PASSWORD_IS_NOT_EMPTY);//注册失败! 密码不能为空
        }


        //编写正则表达式 验证手机号码格式是否正确
        if (!user.getTelephone().isEmpty()){
            if (!PatternUtils.patternTelephone(user.getTelephone())) {// 电话号码是否与正则表达式相匹配
                return ResultUtils.error(ResultEnum.TELEPHONE_IS_NOT_STANDARD);//注册失败! 请规范输入手机号码
            }
        }


        if(userRepository.existsByUsername(user.getUsername())){
            return ResultUtils.error(ResultEnum.USERNAME_IS_EXISTS);//注册失败!此用户名已注册
        }else if (userRepository.existsByStudentID(user.getStudentID())){
            return ResultUtils.error(ResultEnum.STUDENTID_IS_EXISTS);//注册失败!此学号已注册
        }else if (userRepository.existsByTelephone(user.getTelephone())){
            return ResultUtils.error(ResultEnum.TELEPHONE_IS_EXISTS);//注册失败!此电话已注册
        }

        Md5Hash md5Hash=new Md5Hash(user.getPassword(),user.getStudentID(),5);//(明文密码,盐,加密次数)
        user.setPassword(md5Hash.toString());
        user.setRole("user");
        userRepository.save(user);
        log.info("用户 ["+user.getUsername()+"] 注册成功!");
        return ResultUtils.success(ResultEnum.REGISTER_IS_SUCCESS);//注册成功
    }

    //游客登录
    @Override
    public Result login(String studentID, String password) {
        //从SecurityUtils里面建个subject
        Subject subject=SecurityUtils.getSubject();
        // 在认证提交前准备 token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken(studentID, password);

        // 执行认证登陆
        subject.login(token);

        return ResultUtils.success(ResultEnum.LOGIN_IS_SUCCESS);//登录成功
    }

    //搜索商品
    @Override
    public Result searchForGoods(String keyword) {
        List<Good> goods1=goodRepository.findSearchForGoods(keyword);
        return ResultUtils.success(goods1,ResultEnum.SEARCH_IS_SUCCESS);//搜索商品成功
    }

    //查看分类商品
    @Override
    public Result typeOfGoods(String type) {
        List<Good> goods=goodRepository.findTypeOfGoods(type);//查看分类商品(1.办公用品 2.电器 3.衣服 4.其他)
        return ResultUtils.success(goods,ResultEnum.SEARCH_IS_SUCCESS);//搜索商品成功
    }

    //查看商品详情
    @Override
    public Result viewGoodDetails(Integer goodID) {
        Good good=goodRepository.findViewGoodDetails(goodID);
        return ResultUtils.success(good,ResultEnum.SEARCH_IS_SUCCESS);//查看商品详情成功
    }

    //查找所有的商品
    @Override
    public Result allOfGoods() {
        List<Good> goods=goodRepository.findAllOfGoods();
        return ResultUtils.success(goods,ResultEnum.SEARCH_IS_SUCCESS);//查找全部在售商品成功
    }

    //未登录
    @Override
    public Result notLogin() {
        return ResultUtils.error(ResultEnum.NOT_LOGIN);//提示未登录
    }
}
