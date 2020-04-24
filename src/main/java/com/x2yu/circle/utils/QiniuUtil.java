package com.x2yu.circle.utils;

import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;

/**
 * @Author: x2yu
 * @Date: 2020/4/24 22:44
 * @Describe：七牛云相关
 */
public class QiniuUtil {

    //设置好账号的ACCESS_KEY和SECRET_KEY
    final static String ACCESS_KEY = "m2rdez-aOujaQaM1HmaNbpWUpvk-13M54Mgy2xoN";
    final static String SECRET_KEY = "OJHnZShFo41aBXyxsAkAZHuCl1mHsUFTx7pcLdyM";
    //要上传的空间
    final static String BUCKET_NAME = "pic-circle";

    public static String getUploadToken(){

        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        StringMap putPolicy = new StringMap();
        putPolicy.put("returnBody", "{\"key\":\"$(key)\",\"hash\":\"$(etag)\",\"bucket\":\"$(bucket)\",\"fsize\":$(fsize)}");
        long expireSeconds = 3600;
        String upToken = auth.uploadToken(BUCKET_NAME, null, expireSeconds, putPolicy);
        return upToken;
    }
}
