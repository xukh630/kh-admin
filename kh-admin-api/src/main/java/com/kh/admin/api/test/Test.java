package com.kh.admin.api.test;

/**
 * Created by Administrator on 2017/2/15.
 */
public class Test {

  /*  public static void main(String[] args) {
        Integer time = Integer.valueOf(new DateTime(20170101).toString("yyyyMMdd"));
        System.out.println(time);
    }*/

    /*public static void main(String[] args) {
        Long s = 1494172800000l;
        SimpleDateFormat l = new SimpleDateFormat("yyyyMMdd");
        System.out.println(l.format(s));
    }*/

    /*public static void main(String[] args) {
        FileType fileType = FileType.PAY_SUCCESS_FILE;

        int value = fileType.value();

        System.out.println(value);
    }*/

   /* public static void main(String[] args) {
        long a = DateUtil.getNow();
        int b = DateUtil.getNowDate();
        String c = DateUtil.getNowDateFormat();
        String d = DateUtil.getNowDateStr();
        String e = DateUtil.getNowDateTimeStr();
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);

        String hHmmss = DateTime.now().toString("yyyyMMddHHmmss");
        System.out.println(hHmmss);
        System.out.println(Integer.valueOf("030101"));
    }*/

    public static void main(String[] args) {
        String a = "20170526090437";
        String b = "20170526000000";

        System.out.println(Long.valueOf(a) - Long.valueOf(b));
    }
}
