package com.blb.comment.util;

/**
 * 响应状态枚举
 */
public enum ResponseStatus {

    OK(200,"请求成功"),
    INTERNAL_ERROR(500000,"内部错误"),
    LOGIN_ERROR(500001,"账号或密码错误"),
    BUSINESS_ERROR(500002,"业务错误"),
    AUTHORITY_ERROR(500003,"授权错误"),
    AUTHENTICATE_ERROR(403,"验证错误，需要登录");

    //响应代码
    private Integer code;
    //响应信息
    private String message;

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    ResponseStatus(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}


