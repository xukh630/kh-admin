 package com.kh.admin.common.utils;

 import net.sourceforge.pinyin4j.PinyinHelper;
 import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
 import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
 import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
 import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
 import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
 import org.slf4j.Logger;
 import org.slf4j.LoggerFactory;

 public class PingYinUtil
 {
   private static final Logger logger = LoggerFactory.getLogger(PingYinUtil.class);

   public static String getPingYin(String inputString)
   {
     HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
     format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
     format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
     format.setVCharType(HanyuPinyinVCharType.WITH_V);

     char[] input = inputString.trim().toCharArray();
     String output = "";
     try
     {
       for (int i = 0; i < input.length; i++)
         if (Character.toString(input[i]).matches("[\\u4E00-\\u9FA5]+")) {
           String[] temp = PinyinHelper.toHanyuPinyinStringArray(input[i], format);
           output = output + temp[0];
         } else {
           output = output + Character.toString(input[i]);
         }
     }
     catch (BadHanyuPinyinOutputFormatCombination e) {
       logger.error(e.toString());
     }
     return output;
   }

   public static String getFirstSpell(String chinese)
   {
     StringBuffer pybf = new StringBuffer();
     char[] arr = chinese.toCharArray();
     HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
     defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
     defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
     for (int i = 0; i < arr.length; i++) {
       if (arr[i] > '')
         try {
           String[] temp = PinyinHelper.toHanyuPinyinStringArray(arr[i], defaultFormat);
           if (temp != null)
             pybf.append(temp[0].charAt(0));
         }
         catch (BadHanyuPinyinOutputFormatCombination e) {
           logger.error(e.toString());
         }
       else {
         pybf.append(arr[i]);
       }
     }
     return pybf.toString().replaceAll("\\W", "").trim();
   }

   public static String getFullSpell(String chinese)
   {
     StringBuffer pybf = new StringBuffer();
     char[] arr = chinese.toCharArray();
     HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
     defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
     defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
     for (int i = 0; i < arr.length; i++) {
       if (arr[i] > '')
         try {
           pybf.append(PinyinHelper.toHanyuPinyinStringArray(arr[i], defaultFormat)[0]);
         } catch (BadHanyuPinyinOutputFormatCombination e) {
           logger.error(e.toString());
         }
       else {
         pybf.append(arr[i]);
       }
     }
     return pybf.toString();
   }

   //首字母转小写
   public static String toLowerCaseFirstOne(String s){
     if(Character.isLowerCase(s.charAt(0)))
       return s;
     else
       return (new StringBuffer()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
   }

   //首字母转大写
   public static String toUpperCaseFirstOne(String s){
     if(Character.isUpperCase(s.charAt(0)))
       return s;
     else
       return (new StringBuffer()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
   }

   public static void main(String[] as)
   {
   }
 }
