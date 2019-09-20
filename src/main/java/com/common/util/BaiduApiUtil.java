
package com.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.CharEncoding;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

/**
 * 百度API
 *
 * @author chenjun
 * @date 2018/8/28
 * @since V1.44
 */
public class BaiduApiUtil {

    /**
     * 地理编码：免费配额30万次/天
     */
//    private static final String MAP_URL = "http://api.map.baidu.com/geocoder/v2/?";
//    private static final String MAP_KEY = "GCYVWNOmlkzQc6McvQ12AzxS8bINxQZG";
    /**
     * 地理编码：免费配额0.6万次/天
     */
    private static final String MAP_URL = "http://api.map.baidu.com/geocoding/v3/?";
    private static final String MAP_KEY = "ghaT7ubFg90ObXtb50IF9QLpSBfqrfR3";

    /**
     * 获取地址精确经纬度
     *
     * @param originalAddress 待获取经纬度的地址
     * @return 经纬度map或者null
     */
    public static Map preciseGeocoder(String originalAddress) {
        Map map = geocoder(originalAddress);
        if(map != null){
            // 位置的附加信息，是否精确查找。1为精确查找，即准确打点；0为不精确，即模糊打点（模糊打点无法保证准确度，不建议使用）。
            JSONObject result = (JSONObject)map.get("result");
            Integer precise = result.getInteger("precise");
            if (precise == 1) {
                return map;
            }
        }
        return null;
    }

    /**
     * 获取地址模糊经纬度
     *
     * @param originalAddress 待获取经纬度的地址
     * @return 经纬度map或者null
     */
    public static Map geocoder(String originalAddress) {
        if (StringUtils.isEmpty(originalAddress)) {
            return null;
        }
        try {
            // 将URL编码一下，因为访问的时候地址是中文的，所以转码一下，否则失败
            String address = URLEncoder.encode(originalAddress, CharEncoding.UTF_8);
            StringBuilder sb = new StringBuilder();
            // 拼接访问百度web接口的URL
            sb.append(MAP_URL + "address=");
            sb.append(address);
            sb.append("&output=json&ak=");
            sb.append(MAP_KEY);

            URL url = new URL(sb.toString());
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(6000);
            connection.setReadTimeout(6000);
            InputStream is = connection.getInputStream();
            String resultStr = IOUtils.toString(is);
            Map<String, Object> map = JSON.parseObject(resultStr, Map.class);
            if (null != map) {
                Integer status = (Integer) map.get("status");
                if (status == 0) {
                    return map;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        preciseGeocoder("财富港");
    }
}
