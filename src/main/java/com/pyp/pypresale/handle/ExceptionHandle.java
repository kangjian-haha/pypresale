package com.pyp.pypresale.handle;

import com.pyp.pypresale.Entity.Result;
import com.pyp.pypresale.Enums.ResultEnum;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class ExceptionHandle {


    @ExceptionHandler(value = Exception.class)
    public Result userExcetion(Exception e){
        Result result=new Result();
        result.setCode(ResultEnum.RETURN_ERROR.getCode());
        result.setMeg(e.getMessage());
        return result;
    }
}
