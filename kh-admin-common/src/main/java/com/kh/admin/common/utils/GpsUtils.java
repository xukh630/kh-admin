package com.kh.admin.common.utils;

/**
 * 类GpsUtils.java的实现描述：Gps工具类
 * 
 * @author chunwei.ccw 2015年3月27日 下午9:23:25
 */
public class GpsUtils {

    private static double EARTH_RADIUS = 6378.137;

    private static double rad(double d) {
        return d * Math.PI / 180.0;
    }

    /**
     * 获取两个gps坐标间的距离
     * 
     * @param lat1
     * @param lng1
     * @param lat2
     * @param lng2
     * @return
     */
    public static double getDistance(double lng1, double lat1, double lng2, double lat2) {
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lng1) - rad(lng2);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) + Math.cos(radLat1) * Math.cos(radLat2)
                                           * Math.pow(Math.sin(b / 2), 2)));
        //Math.round(s * 100) / 100;
        return s * EARTH_RADIUS ;
    }
}
