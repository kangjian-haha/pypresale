package com.pyp.pypresale.Utils;

import com.pyp.pypresale.Entity.Result;
import com.pyp.pypresale.Enums.ResultEnum;
/*
* 返回格式模板
* */
public class ResultUtils {

    //处理有对象参数的成功
    public static Result success(Object object,ResultEnum resultEnum){
        Result result=new Result();
        result.setCode(resultEnum.getCode());
        result.setMeg(resultEnum.getMsg());
        result.setData(object);
        return result;
    }
    //处理无对象参数的成功
    public static  Result success(){
        return success(null,ResultEnum.RETURN_TRUE);
    }

    //处理与数据库有冲突的错误
    public static Result error(ResultEnum resultEnum){
        Result result=new Result();
        result.setCode(resultEnum.getCode());
        result.setMeg(resultEnum.getMsg());
        return result;
    }
    //处理与表单有冲突的错误
    public static Result error(Integer code,String msg){
        Result result=new Result();
        result.setCode(code);
        result.setMeg(msg);
        return result;
    }



}
