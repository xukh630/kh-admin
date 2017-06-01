package com.kh.admin.common.utils;

import com.alibaba.common.lang.StringUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author zhongxiong.lzx
 *
 */
public final class EncrypAESUtil {

	private static final EncrypAES encrypAES = new EncrypAES("hx_62_HJN_XtEaM9");

	/**
	 * 获取多个字符串的加密结果
	 * 
	 * @param args
	 * @return
	 */
	public static String getCredentials(String... args) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < args.length; i++) {
			sb.append(args[i]);
			sb.append("#");
		}
		return encrypAES.encryt(sb.toString());
	}

	/**
	 * 取多个字符串的加密结果
	 * @return
	 */
	public static String getCredentials(List<String> list) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i));
			sb.append("#");
		}
		return encrypAES.encryt(sb.toString());
	}

	/**
	 * 解密多个字符加密结果
	 * 
	 * @param encrytStr
	 * @return
	 */
	public static String[] Credentials(String encrytStr) {
		if (StringUtil.isEmpty(encrytStr)) {
			return null;
		}
		String deCodeStr = encrypAES.decrypt(encrytStr);
		if (StringUtil.isNotEmpty(deCodeStr)) {
			return deCodeStr.split("#");
		}
		return null;
	}

	/**
	 * 解密多个字符加密结果
	 * 
	 * @param encrytStr
	 * @return
	 */
	public static Map<String, String> getCredentialsForMap(String encrytStr) {

		if (StringUtil.isEmpty(encrytStr)) {
			return null;
		}
		String deCodeStr = encrypAES.decrypt(encrytStr);
		if (StringUtil.isNotEmpty(deCodeStr)) {

			Map<String, String> map = new HashMap<String, String>();
			String[] sAttr = deCodeStr.split("#");
			for (String s : sAttr) {
				if(StringUtil.isEmpty(s))
				{
					continue;
				}
				String[] encryt = s.split("=");
				map.put(encryt[0], encryt[1]);
			}
			return map;
		}
		return null;
	}

}