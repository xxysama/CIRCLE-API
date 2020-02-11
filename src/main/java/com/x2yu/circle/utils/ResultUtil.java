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
    * 注册错误
    * */
    public static Result registerError(){
        return new Result(ResultEnum.REGISTER_ERROR.getCode(),ResultEnum.REGISTER_ERROR.getMessage());
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
