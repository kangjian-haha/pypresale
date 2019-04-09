//package com.pyp.pypresale.handle;
//
//import com.pyp.pypresale.Exception.UserException;
//import com.pyp.pypresale.Utils.Result;
//import com.pyp.pypresale.Enums.ResultEnum;
//import com.pyp.pypresale.Utils.ResultUtils;
//import org.apache.shiro.authc.AuthenticationException;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseBody;
//
///**
// * 统一异常处理类
// */
//
//@ControllerAdvice
//public class ExceptionHandle {
//
//
//    @ExceptionHandler(value = Exception.class)//监听Exception类,抛出异常时,执行以下方法
//    @ResponseBody
//    public Result handle(Exception e) {
//
//        if (e instanceof UserException) {//抛出已知错误
//            UserException userException = (UserException) e;
//            return ResultUtils.error(userException.getCode(), userException.getMessage());
//        }else if (e instanceof AuthenticationException){
//            return ResultUtils.error(101,e.getMessage());
//        }else {
//            //抛出未知错误
//            return ResultUtils.error();
//
//        }
//
//    }
//}
