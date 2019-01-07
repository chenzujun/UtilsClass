package com.algorithm.address;

/**
 * 有效范围验证
 *
 * @author chenjun
 * @date 2019/1/7
 * @since V1.0.0
 */
public class RangeUtils {

    public static void main(String[] args) {
        Address address1 = new Address();
        address1.setLatitude(22.7260864703);
        address1.setLongitude(114.2208498987);
        Address address2 = new Address();
        address2.setLatitude(22.7258870000);
        address2.setLongitude(114.2211090000);

        System.out.println(isInCircle(address1, address2, 50));
    }

    /**
     * 根据经纬度获取两点之间的距离
     *
     * @param n1
     * @param n2
     * @param radius
     * @return
     */
    public static boolean isInCircle(Address n1 ,Address n2, double radius) {
        //地球半径 （千米）
        final double EARTH_RADIUS = 6378.137;
        double radLat1 = rad(n1.getLatitude() != null ? n1.getLatitude().doubleValue() : 0);
        double radLat2 = rad(n2.getLatitude() != null ? n2.getLatitude().doubleValue() : 0);
        double radLon1 = rad(n1.getLongitude() != null ? n1.getLongitude().doubleValue() : 0);
        double radLon2 = rad(n2.getLongitude() != null ? n2.getLongitude().doubleValue() : 0);
        //两点之间的差值
        double jdDistance = radLat1 - radLat2;
        double wdDistance = radLon1 - radLon2;
        double distance = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(jdDistance / 2), 2) +
                Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(wdDistance / 2), 2)));
        distance = distance * EARTH_RADIUS;
        distance = Math.round(distance * 10000d) / 10000d;
        //将计算出来的距离千米转为米
        distance = distance * 1000;
        //判断一个点是否在圆形区域内
        if (distance > radius) {
            return false;
        }
        return true;
    }


    /**
     * 将角度换算为弧度
     *
     * @param d 角度
     * @return 弧度
     */
    private static double rad(double d) {
        return d * Math.PI / 180.0;
    }

}
