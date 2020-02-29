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

    REGISTER_EMAIL_ERROR("301", "邮箱已注册"),

    REGISTER_USERNAME_ERROR("302", "用户名已注册"),

    LOGIN_SUCCESS("400", "登录成功"),

    UNKNOWN_ACCOUNT_ERROR("401", "错误账号"),

    INCORRECT_PASS_ERROR("402","密码错误"),

    LOGOUT_SUCCESS("403","成功登出"),

    SUBMIT_ERROR("501","提交失败");

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
