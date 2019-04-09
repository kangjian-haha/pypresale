package com.pyp.pypresale.Exception;

import com.pyp.pypresale.Enums.ResultEnum;
import lombok.Data;

@Data
public class UserException extends RuntimeException {

    private Integer code;//自己建的一个错误码,默认的Exception只有Message

    /**
     * 构造方法: 把枚举类写进UserException中
     * @param resultEnum
     */
    public UserException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code=resultEnum.getCode();
    }


}
