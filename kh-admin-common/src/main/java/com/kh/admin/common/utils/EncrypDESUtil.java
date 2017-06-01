package com.kh.admin.common.utils;

import java.nio.charset.Charset;

/**
 * 类EncrypDESUtil.java的实现描述：DES加密解密,加密和解密秘钥sKey一致
 * 
 * @author wb-yejian 2015年12月30日 下午8:38:12
 */
public class EncrypDESUtil {

    /**
     * 加密
     * 
     * @param srcStr
     * @param sKey
     * @return
     * @throws Exception
     */
    public static String encrypt(String srcStr, Charset charset, String sKey) {

        byte[] src = srcStr.getBytes(charset);
        byte[] buf = EncrypDES.encrypt(src, sKey);
        return EncrypAES.parseByte2HexStr(buf);
    }

    /**
     * 解密
     * 
     * @param hexStr
     * @param sKey
     * @return
     * @throws Exception
     */
    public static String decrypt(String hexStr, Charset charset, String sKey) throws Exception {
        byte[] src = EncrypAES.parseHexStr2Byte(hexStr);
        byte[] buf = EncrypDES.decrypt(src, sKey);
        return new String(buf, charset);
    }

}
