package com.kh.admin.common.utils;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;


/**
 * Created by Administrator on 2016/8/8.
 */
public class RSASignature {
    static final String SIGN_ALGORITHMS = "SHA1withRSA";

    /**
     * 计算二进制数据的SHA1withRSA签名。
     * @param content 待签名的数据。
     * @param privateKeyPKCS8  PKCS格式的RSA私钥。
     * @return
     */
    public static byte[] signWithSha1(byte[] content, String privateKeyPKCS8) {
        Validate.notNull(content);
        Validate.notNull(privateKeyPKCS8);

        Signature sin;
        try {
            sin = Signature.getInstance(SIGN_ALGORITHMS);
            sin.initSign(decodePrivateKey(privateKeyPKCS8));
            sin.update(content);
            return sin.sign();
        } catch (Exception e) {
            throw new RuntimeException("计算SHA1withRSA签名失败。", e);
        }
    }

    /**
     * 校验二进制数据的SHA1withRSA签名。
     * @param content 待校验的数据。
     * @param sign 数据签名。
     * @param publicKeyPEM PEM格式的RSA公钥。
     * @return
     */
    public static boolean verfiyWithSha1(byte[] content, byte[] sign, String publicKeyPEM) {
        Validate.notNull(content);
        Validate.notNull(sign);
        Validate.notNull(publicKeyPEM);

        Signature sin;
        try {
            sin = Signature.getInstance(SIGN_ALGORITHMS);
            sin.initVerify(decodePublicKey(publicKeyPEM));
            sin.update(content);
            return sin.verify(sign);
        } catch (Exception e) {
            throw new RuntimeException("校验SHA1withRSA签名失败。", e);
        }
    }

    /**
     * 解码PKCS8格式的秘钥。
     */
    static PrivateKey decodePrivateKey(String privateKeyPKCS8) throws InvalidKeySpecException,
            NoSuchAlgorithmException {
        KeyFactory kf = KeyFactory.getInstance("RSA");
        privateKeyPKCS8 = StringUtils.remove(privateKeyPKCS8, "-----BEGIN PRIVATE KEY-----\n");
        privateKeyPKCS8 = StringUtils.remove(privateKeyPKCS8, "-----END PRIVATE KEY-----");
        byte[] decoded = Base64.getFromBASE64Bytes(privateKeyPKCS8);
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(decoded);
        return kf.generatePrivate(spec);
    }

    /**
     * 解码PEM格式的公钥。
     */
    static PublicKey decodePublicKey(String publiKeyPEM) throws InvalidKeySpecException, NoSuchAlgorithmException {
        KeyFactory kf = KeyFactory.getInstance("RSA");
        publiKeyPEM = StringUtils.remove(publiKeyPEM, "-----BEGIN PUBLIC KEY-----\n");
        publiKeyPEM = StringUtils.remove(publiKeyPEM, "-----END PUBLIC KEY-----");
        byte[] decoded = Base64.getFromBASE64Bytes(publiKeyPEM);
        X509EncodedKeySpec spec = new X509EncodedKeySpec(decoded);
        return kf.generatePublic(spec);
    }
}
