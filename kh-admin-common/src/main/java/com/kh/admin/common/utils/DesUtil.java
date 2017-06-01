package com.kh.admin.common.utils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.security.SecureRandom;

/**
 * Copyright 2007 GuangZhou Cotel Co. Ltd. All right reserved. DES加密解密类.
 * 
 * @author <a href="mailto:xiexingxing1121@126.com"
 *         mce_href="mailto:xiexingxing1121@126.com">AmigoXie</a>
 * @version 1.0 Creation date: 2007-7-31 - 上午11:59:28
 */
public class DesUtil {
	/** 加密、解密key. */
	private static final String PASSWORD_CRYPT_KEY = "kEHrDooxWHCWtfeSxvDvgqZq";
	/** 加密算法,可用 DES,DESede,Blowfish. */
	private final static String ALGORITHM = "DES";
	private final static String DES_CBC = "DES/CBC/PKCS5Padding";

	/**
	 * 对用DES加密过的数据进行解密.
	 */
	public final static String encrypt(String data) {
		return encrypt(data, PASSWORD_CRYPT_KEY);
	}

	public final static String encrypt(String data, String key) {
		try {
			return byte2hex(des(Cipher.ENCRYPT_MODE, ALGORITHM,
					data.getBytes(), key.getBytes()));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public final static String encryptCBC(String data) {
		return encryptCBC(data, PASSWORD_CRYPT_KEY);
	}

	public final static String encryptCBC(String data, String key) {
		try {
			return byte2hex(des(Cipher.ENCRYPT_MODE, DES_CBC,
					data.getBytes(), key.getBytes()));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 对数据进行DES加密.
	 */
	public final static String decrypt(String data) {
		return decrypt(data, PASSWORD_CRYPT_KEY);
	}

	public final static String decryptCBC(String data) {
		return decryptCBC(data, PASSWORD_CRYPT_KEY);
	}

	public final static String decrypt(String data, String key) {
		try {
			return new String(des(Cipher.DECRYPT_MODE, ALGORITHM,
					hex2byte(data.getBytes()), key.getBytes()));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public final static String decryptCBC(String data, String key) {
		try {
			return new String(des(Cipher.DECRYPT_MODE, DES_CBC,
					hex2byte(data.getBytes()), key.getBytes()));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private static byte[] des(int mode, String type, byte[] data, byte[] key)
			throws Exception {
		// 从原始密匙数据创建一个DESKeySpec对象
		DESKeySpec dks = new DESKeySpec(key);
		// 创建一个密匙工厂，然后用它把DESKeySpec对象转换成
		// 一个SecretKey对象
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
		SecretKey securekey = keyFactory.generateSecret(dks);
		// Cipher对象实际完成解密操作
		Cipher cipher = Cipher.getInstance(type);
		if (DES_CBC.equals(type)) {
			IvParameterSpec ivps = new IvParameterSpec(key);
			cipher.init(mode, securekey, ivps);
		} else {
			SecureRandom sr = new SecureRandom();
			cipher.init(mode, securekey, sr);
		}
		return cipher.doFinal(data);
	}
 

	public static byte[] hex2byte(byte[] b) {
		if ((b.length % 2) != 0)
			throw new IllegalArgumentException("长度不是偶数");
		byte[] b2 = new byte[b.length / 2];
		for (int n = 0; n < b.length; n += 2) {
			String item = new String(b, n, 2);
			b2[n / 2] = (byte) Integer.parseInt(item, 16);
		}
		return b2;
	}

	public static String byte2hex(byte[] b) {
		StringBuilder hs = new StringBuilder();
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			stmp = (Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1)
				hs.append("0").append(stmp);
			else
				hs.append(stmp);
		}
		return hs.toString().toUpperCase();
	}

}
