package com.pyp.pypresale.Utils;

import com.pyp.pypresale.Enums.ResultEnum;
/*
* 返回格式模板
* */
public class ResultUtils {


    /**
     * *************************************成功****************************************
     */
    //处理有对象参数的成功
    public static Result success(Object object,ResultEnum resultEnum){
        Result result=new Result();
        result.setCode(resultEnum.getCode());
        result.setMsg(resultEnum.getMsg());
        result.setData(object);
        return result;
    }

    public static  Result success(ResultEnum resultEnum){
        return success(null,resultEnum);
    }

    //处理无对象参数的成功
    //默认成功(无参)
    public static  Result success(){
        return success(null,ResultEnum.RETURN_SUCCESS);
    }


    /**
     * *************************************错误****************************************
     */

    //处理与数据库有冲突的错误
    public static Result error(ResultEnum resultEnum){
        Result result=new Result();
        result.setCode(resultEnum.getCode());
        result.setMsg(resultEnum.getMsg());
        return result;
    }

    //返回异常类抛出的信息
    public static Result error(Integer code,String msg){
        Result result=new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;

    }


    //默认错误提示
    public static Result error(){
        return error(ResultEnum.RETURN_ERROR);
    }



}
