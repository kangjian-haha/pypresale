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

    RETURN_SUCCESS(200,"成功"),//默认成功

    REGISTER_IS_SUCCESS(200,"注册成功"),
    LOGIN_IS_SUCCESS(200,"登陆成功"),
    LOGOUT_IS_SUCCESS(200,"注销登录成功"),

    UPDATE_USER_IS_SUCCESS(200,"修改用户信息成功"),

    SEARCH_IS_SUCCESS(200,"搜索商品成功"),

    BUY_GOOD_SUCCESS(200,"购买商品成功"),

    RELEASE_GOOD_SUCCESS(200,"发布商品成功"),

    UPDATE_GOOD_SUCCESS(200,"修改商品成功"),

    DELETE_GOOD_IS_SUCCESS(200,"删除商品成功"),

    FIND_SELFGOODS_IS_SUCCESS(200,"查看自己的商品成功"),

    COLLECTION_GOOD_IS_SUCCESS(200,"收藏商品成功"),

    NOT_COLLECTION_GOOD_IS_SUCCESS(200,"取消收藏商品成功"),

    FIND_COLLECTION_GOOD_IS_SUCCESS(200,"查看当前用户的收藏商品,成功"),


    /**
     * 失败信息
     */

    USERNAME_IS_NOT_EMPTY(100,"注册失败! 用户名不能为空"),
    STUDENTID_IS_NOT_EMPTY(100,"注册失败! 学号不能为空"),
    PASSWORD_IS_NOT_EMPTY(100,"注册失败! 密码不能为空"),

    TELEPHONE_IS_NOT_STANDARD(100,"注册失败! 请规范输入手机号码"),

    USERNAME_IS_EXISTS(100,"注册失败! 此用户名已注册."),
    STUDENTID_IS_EXISTS(100,"注册失败! 此学号已注册."),
    TELEPHONE_IS_EXISTS(100,"注册失败! 此电话已注册."),


    UPDATE_FAIL_USERNAME_IS_NOT_EMPTY(100,"修改失败! 用户名不能为空"),
    UPDATE_FAIL_TELEPHONE_IS_NOT_STANDARD(100,"修改失败! 请规范输入手机号码"),
    UPDATE_FAIL_USERNAME_IS_EXISTS(100,"修改失败! 此用户名已存在."),
    UPDATE_FAIL_TELEPHONE_IS_EXISTS(100,"修改失败! 此电话已存在."),

    RELEASE_GOOD_IS_FAIL_TITLE_IS_EMPTY(100,"发布失败! 商品标题不能为空"),
    RELEASE_GOOD_IS_FAIL_PRICE_IS_EMPTY(100,"发布失败! 商品价格不能为0"),

    UPDATE_GOOD_IS_FAIL_TITLE_IS_EMPTY(100,"修改失败! 商品标题不能为空"),
    UPDATE_GOOD_IS_FAIL_PRICE_IS_EMPTY(100,"修改失败! 商品价格不能为0"),

    NOT_COLLECTION_GOOD_IS_FAIL(100,"取消收藏商品失败"),



    NOT_LOGIN(101,"未登录"),

    BUY_IS_FAIL(105,"购买失败! 此商品已不在售."),

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
