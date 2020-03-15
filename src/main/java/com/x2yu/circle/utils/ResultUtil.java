package com.x2yu.circle.utils;

/**
 * @Author: x2yu
 * @Date: 2020/2/11 16:21
 * @Describe：返回码工具类
 */
public class ResultUtil {

    /**
     * 成功有返回
     */
    public static Result success(Object object) {
        Result result = new Result(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage());
        result.setData(object);
        return result;
    }

    /**
     *  成功无返回
     */
    public static Result success() {
        return ResultUtil.success(null);
    }

    /**
     * 参数不合法返回
     */
    public static Result paramError(Object object) {
        Result result = new Result(ResultEnum.PARAM_ERROR.getCode(), ResultEnum.PARAM_ERROR.getMessage());
        result.setData(object);
        return result;
    }

    /**
     * 参数不合法返回
     */
    public static Result paramError() {
        return new Result(ResultEnum.PARAM_ERROR.getCode(), ResultEnum.PARAM_ERROR.getMessage());
    }

    /**
     * 返回自定义状态码及msg
     */
    public static Result customResultParam(String code, String msg) {
        return new Result(code, msg);
    }


    /**
     * 数据库错误
     */
    public static Result dataBaseError() {
        return new Result(ResultEnum.DATABASE_ERROR.getCode(), ResultEnum.DATABASE_ERROR.getMessage());
    }

    /*
     * 注册成功
     * */
    public static Result registerSuccess(){
        return new Result(ResultEnum.REGISTER_SUCCESS.getCode(),ResultEnum.REGISTER_SUCCESS.getMessage());
    }

    /*
    * 注册邮箱错误
    * */
    public static Result registerEmailError(){
        return new Result(ResultEnum.REGISTER_EMAIL_ERROR.getCode(),ResultEnum.REGISTER_EMAIL_ERROR.getMessage());
    }

    /*
     * 注册邮箱错误
     * */
    public static Result registerUsernameError(){
        return new Result(ResultEnum.REGISTER_USERNAME_ERROR.getCode(),ResultEnum.REGISTER_USERNAME_ERROR.getMessage());
    }


    /*
     * 登录成功
     * */
    public static Result loginSuccess(){
        return new Result(ResultEnum.LOGIN_SUCCESS.getCode(),ResultEnum.LOGIN_SUCCESS.getMessage());
    }

    /*
     * 登录成功返回登录用户id
     * */
    public static Result loginSuccess(Integer uid){
        Result result =    new Result(ResultEnum.LOGIN_SUCCESS.getCode(),ResultEnum.LOGIN_SUCCESS.getMessage());
        result.setData(uid);
        return result;
    }


    /*
     * 错误账号
     * */
    public static Result unknownAccount(){
        return new Result(ResultEnum.UNKNOWN_ACCOUNT_ERROR.getCode(),ResultEnum.UNKNOWN_ACCOUNT_ERROR.getMessage());
    }

    /*
     * 密码错误
     * */
    public static Result incorrectPass(){
        return new Result(ResultEnum.INCORRECT_PASS_ERROR.getCode(),ResultEnum.INCORRECT_PASS_ERROR.getMessage());
    }

    /*
     * 成功登出
     * */
    public static Result logoutSuccess(){
        return new Result(ResultEnum.LOGOUT_SUCCESS.getCode(),ResultEnum.LOGOUT_SUCCESS.getMessage());
    }

    /**
     * 提交错误
     * */
    public static Result submitError(){
        return new Result(ResultEnum.SUBMIT_ERROR.getCode(),ResultEnum.SUBMIT_ERROR.getMessage());
    }

    public static Result submitError(Object object){
        Result result = new Result(ResultEnum.SUBMIT_ERROR.getCode(),ResultEnum.SUBMIT_ERROR.getMessage());
        result.setData(object);
        return result;
    }
    /**
     * @param @param  code
     * @param @param  msg
     * @param @return 设定文件
     * @return Result 返回类型, 错误返回时状态码为 9999
     * @Title: error
     * @Description: 失败方法返回
     */
    public static Result error(String code, String msg) {
        Result result = new Result(code, msg);
        return result;
    }
}
