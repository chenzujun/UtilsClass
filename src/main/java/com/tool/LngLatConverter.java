/***********************************************************************************
 * Copyright (c) 2005-2020.  FPX and/or its affiliates. All rights reserved. Use,  *
 * Copy is subject to authorized license.                                          *
 ***********************************************************************************/

package com.tool;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 坐标转换
 * @author chenj
 */
public class LngLatConverter {


    private static double x_pi = 3.14159265358979324 * 3000.0 / 180.0;

    /**
     * 将火星坐标转变成百度坐标
     *
     * @param lngLat_gd 火星坐标（高德、腾讯地图坐标等）
     * @return 百度坐标
     */

    public static LngLat bd_encrypt(LngLat lngLat_gd) {
        double x = lngLat_gd.getLng(), y = lngLat_gd.getLat();
        double z = Math.sqrt(x * x + y * y) + 0.00002 * Math.sin(y * x_pi);
        double theta = Math.atan2(y, x) + 0.000003 * Math.cos(x * x_pi);
        return new LngLat(dataDigit(6, z * Math.cos(theta) + 0.0065), dataDigit(6, z * Math.sin(theta) + 0.006));
    }

    /**
     * 将百度坐标转变成火星坐标
     *
     * @param lngLat_bd 百度坐标（百度地图坐标）
     * @return 火星坐标(高德 、 腾讯地图等)
     */
    static LngLat bd_decrypt(LngLat lngLat_bd) {
        double x = lngLat_bd.getLng() - 0.0065, y = lngLat_bd.getLat() - 0.006;
        double z = Math.sqrt(x * x + y * y) - 0.00002 * Math.sin(y * x_pi);
        double theta = Math.atan2(y, x) - 0.000003 * Math.cos(x * x_pi);
        return new LngLat(dataDigit(6, z * Math.cos(theta)), dataDigit(6, z * Math.sin(theta)));

    }

    static double dataDigit(int digit, double in) {
        return new BigDecimal(in).setScale(6, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("C:\\Users\\chenjun01\\Desktop\\orgregion.txt")));
        String s;
        int i = 0;
        while ((s = br.readLine()) != null) {
            i++;
            String line = s.trim();
            List<LngLat> orgLngLat = JSON.parseObject(line, new TypeReference<ArrayList<LngLat>>() {
            });
            List<LngLat> newLngLat = new ArrayList<>();
            for (LngLat lngLat : orgLngLat) {
                newLngLat.add(bd_decrypt(lngLat));
            }
            System.out.println(JSON.toJSONString(newLngLat));
        }
    }

    public  static class LngLat {


        private double lng;//经度
        private double lat;//维度

        public LngLat() {
        }

        public LngLat(double longitude, double lantitude) {
            this.lng = longitude;
            this.lat = lantitude;
        }

        public double getLng() {
            return lng;
        }

        public void setLng(double lng) {
            this.lng = lng;
        }

        public double getLat() {
            return lat;
        }

        public void setLat(double lat) {
            this.lat = lat;
        }
    }


}

