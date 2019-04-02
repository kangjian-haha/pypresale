package com.pyp.pypresale.Enums;

import lombok.Getter;

/*
* 返回信息枚举
* */
@Getter
public enum ResultEnum {
    /**
     * 成功信息
     */

    RETURN_TRUE(200,"成功"),
    REGISTER_IS_TRUE(200,"注册成功"),

    /**
     * 失败信息
     */
    ID_IS_EXISTS(100,"错误!学号已注册"),
    RETURN_ERROR(201,"未知错误"),
    RETURN_NULL(400,"输入错误"),

    ;

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {

        this.code = code;
        this.msg = msg;
    }
}
