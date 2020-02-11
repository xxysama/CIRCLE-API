package com.x2yu.circle.utils;


/**
 * @Author: x2yu
 * @Date: 2020/2/11 16:14
 * @Describe：状态码枚举类
 */

public enum ResultEnum {

    UNKNOWN_ERROR("-1", "未知错误"),

    SUCCESS("200", "成功"),

    PARAM_ERROR("201", "参数不合法"),

    DATABASE_ERROR("202", "数据库异常"),

    REGISTER_SUCCESS("300", "注册成功"),

    REGISTER_ERROR("301", "邮箱已注册");

    private String code;
    private String message;

    ResultEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }




}
