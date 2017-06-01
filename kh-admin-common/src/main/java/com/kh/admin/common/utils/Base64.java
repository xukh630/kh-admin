package com.kh.admin.common.utils;

import sun.misc.BASE64Decoder;

public class Base64 {

    // 将 s 进行 BASE64 编码
    public static String getBASE64(String s) {
        if (s == null) return null;
        return (new sun.misc.BASE64Encoder()).encode(s.getBytes());
    }

    // 将 s 进行 BASE64 编码
    public static String getBASE64(byte[] bytes) {
        if (bytes == null) return null;
        return (new sun.misc.BASE64Encoder()).encode(bytes);
    }

    // 将 BASE64 编码的字符串 s 进行解码
    public static String getFromBASE64(String s) {
        if (s == null) return null;
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            byte[] bytes = decoder.decodeBuffer(s);
            return new String(bytes);
        } catch (Exception e) {
            return null;
        }
    }
    

 
    public static byte[] getFromBASE64Bytes(String s) {
        if (s == null) return null;
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            return decoder.decodeBuffer(s);
        } catch (Exception e) {
            return null;
        }
    }
}
