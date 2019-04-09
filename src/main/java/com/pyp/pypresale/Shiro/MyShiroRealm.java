package com.pyp.pypresale.Shiro;

import com.pyp.pypresale.Entity.User;
import com.pyp.pypresale.Enums.ResultEnum;
import com.pyp.pypresale.Exception.UserException;
import com.pyp.pypresale.Repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author kangjian
 * @date 2019/4/4 15:47
 */
@Slf4j
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserRepository userRepository;

    //角色授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        log.info("开始身份认证...");

        String studentID= (String) SecurityUtils.getSubject().getPrincipal();//得到学号

        User user=userRepository.findByStudentID(studentID);//根据学号,拿到数据库里的User

        SimpleAuthorizationInfo simpleAuthorizationInfo=new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addRole(user.getRole());

        return simpleAuthorizationInfo;
    }


    //登录认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        log.info("开始登录认证...");
        String studentID= (String) token.getPrincipal();//应该是拿到学号的
        log.info("log 学号: "+studentID);
        String password = new String((char[])token.getCredentials());
        log.info("log 明文密码: "+password);
        Md5Hash md5Hash=new Md5Hash(password,studentID,5);//再加密为密文,用于判断当前登录密码是否正确
        User user=userRepository.findByStudentID(studentID);
        if (user==null){
            //抛出异常:用户不存在!
            throw new AuthenticationException("用户不存在!");
            //throw new UserException(ResultEnum.RETURN_ERROR);
        }else if (!user.getPassword().equals(md5Hash.toString())){
            throw new AuthenticationException("密码错误!");
        }


        //验证通过返回一个封装了用户信息的AuthenticationInfo实例即可。
        //SimpleAuthenticationInfo(用户名,密码,盐,RealmName);
        SimpleAuthenticationInfo authenticationInfo=new SimpleAuthenticationInfo(
                studentID,
                user.getPassword(),
                ByteSource.Util.bytes(studentID),
                getName()
        );


        return authenticationInfo;
    }
}
