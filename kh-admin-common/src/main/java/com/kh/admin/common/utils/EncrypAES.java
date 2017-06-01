
package com.kh.admin.common.utils;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

/**
 * @author zhongxiong.lzx AES 加密解密
 */
public class EncrypAES {

    /**
     * 加解密key
     */
    private final Key keySpec;

    /**
     * @param key 私钥 AES固定格式为128/192/256 bits.即：16/24/32bytes
     * @throws NoSuchAlgorithmException
     * @throws NoSuchPaddingException
     */
    public EncrypAES(String key){
        keySpec = new SecretKeySpec(key.getBytes(), "AES");
    }

    /**
     * 对字符串加密
     * 
     * @param str
     * @return
     * @throws InvalidKeyException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     */
    public String encryt(String str) {
        // 根据密钥，对Cipher对象进行初始化，ENCRYPT_MODE表示加密模式
        try {
            Cipher c = Cipher.getInstance("AES");
            c.init(Cipher.ENCRYPT_MODE, keySpec);

            byte[] src = str.getBytes();
            // 加密，结果保存进cipherByte
            byte[] cipherByte = c.doFinal(src);
            return parseByte2HexStr(cipherByte);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 对字符串解密
     * 
     * @param deCodeStr
     * @return
     * @throws InvalidKeyException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     */
    public String decrypt(String deCodeStr) {
        // 根据密钥，对Cipher对象进行初始化，DECRYPT_MODE表示加密模式
        try {
            if (null == deCodeStr) return null;
            byte[] buff = parseHexStr2Byte(deCodeStr);
            Cipher c;

            c = Cipher.getInstance("AES");
            c.init(Cipher.DECRYPT_MODE, keySpec);
            byte[] cipherByte = c.doFinal(buff);
            return new String(cipherByte);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        EncrypAES de1 = new EncrypAES("zhongxionglzxlzx");
        String msg = "TA_2323283844#105957#" + System.currentTimeMillis();
        String encontent = de1.encryt(msg);
        String decontent = de1.decrypt(encontent);
        System.out.println("明文是:" + msg);
        System.out.println("加密后:" + encontent);
        System.out.println("解密后:" + decontent);
    }

    /**
     * 将二进制转换成16进制 22EBCB0FE903EA689A751AE2E75A596EFC8889C044177F9D10B9295857D2DC39
     * 3C3F992DBC3245919D10A22EC470B7BC0FABAC0018AA17E2CA012C04918B016D
     * 
     * @param buf
     * @return
     */
    public static String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

    /**
     * 将16进制转换为二进制
     * 
     * @param hexStr
     * @return
     */
    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1) return null;
        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }

}
