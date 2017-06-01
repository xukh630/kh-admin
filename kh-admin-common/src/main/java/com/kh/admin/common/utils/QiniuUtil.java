/**
 * Copyright (c) 2016, 791650277@qq.com(Mr.kiwi) All Rights Reserved.
 */
package com.kh.admin.common.utils;

import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * 项目：liquidator-platform-openapi
 * 包名：com.fshows.liquidator.platform.openapi.common.utils
 * 功能：
 * 时间：2016-09-19 8:41
 * 作者：Mr.Kiwi
 */
public class QiniuUtil {

    private static final Logger logger = LoggerFactory.getLogger(QiniuUtil.class);

    //设置好账号的ACCESS_KEY和SECRET_KEY
    final static String ACCESS_KEY = ResourceUtil.getSystem("qiniu.access.key");
    final static String SECRET_KEY = ResourceUtil.getSystem("qiniu.secret.key");
    //要上传的空间
    final static String bucketname = ResourceUtil.getSystem("qiniu.bucket.name");

    // 覆盖上传
    public static String getUpToken(String key) {
        //密钥配置
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        //<bucket>:<key>，表示只允许用户上传指定key的文件。在这种格式下文件默认允许“修改”，已存在同名资源则会被本次覆盖。
        return auth.uploadToken(bucketname, key);
    }

    /**
     * 上传指定文件
     *
     * @param key      上传后文件名
     * @param filePath 要上传的文件名称
     * @throws IOException
     */
    public static void upload(String key, String filePath) throws IOException {
        try {
            Configuration config = new Configuration(Zone.autoZone());
            //创建上传对象
            UploadManager uploadManager = new UploadManager(config);
            //调用put方法上传，这里指定的key和上传策略中的key要一致
            Response res = uploadManager.put(filePath, key, getUpToken(key));

        } catch (QiniuException e) {
            Response r = e.response;
            try {
                //响应的文本信息
                logger.error("七牛上传文件时出现异常：e = {}", r.bodyString());
            } catch (QiniuException e1) {
                //ignore
            }
        }
    }

    /**
     * 上传指定文件
     *
     * @param key 上传后文件名
     * @param is  要上传的文件流
     * @throws IOException
     */
    public static void uploadByIs(String key, InputStream is) throws IOException {
        try {
            Configuration config = new Configuration(Zone.autoZone());
            //创建上传对象
            UploadManager uploadManager = new UploadManager(config);
            //调用put方法上传，这里指定的key和上传策略中的key要一致
            Response res = uploadManager.put(is, key, getUpToken(key), null, null);

        } catch (QiniuException e) {
            Response r = e.response;
            try {
                //响应的文本信息
                logger.error("七牛上传文件时出现异常：e = {}", r.bodyString());
            } catch (QiniuException e1) {
                //ignore
            }
        }
    }


    /**
     * 生成一个随机key前缀(目前14位)
     * 20160809104636
     * 14位日期
     *
     * @return
     */
    public static String createKeyPrefix() {
        StringBuffer sb = new StringBuffer();
        // 获得时间字符串
        sb.append(DateUtil.getNowDateTimeStr());

        return sb.toString();
    }

    /**
     * 获得下载地址
     *
     * @param key
     * @return
     */
    public static String download(String key) {

        //密钥配置
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        //构造私有空间需要生成的下载的链接
        String URL = ResourceUtil.getSystem("qiniu.access.url") + key;

        //调用privateDownloadUrl方法生成下载链接,第二个参数可以设置Token的过期时间
        return auth.privateDownloadUrl(URL, 3600);

    }

    public static void main(String[] args) {

        //        try {
        //            upload("/liquidator/finance/12.csv", "C:\\Users\\Administrator\\Desktop\\12.csv", "liquidator-test");
        //        } catch (IOException e) {
        //            e.printStackTrace();
        //        }


        System.err.println(download("/liquidator/finance/12.csv"));
    }


}
