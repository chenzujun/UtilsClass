package com.tool;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.common.util.HttpUtils;
import com.tool.domain.BulkParcelForecastList;
import com.tool.domain.MD5Util;
import com.tool.domain.PacketEventDTO;
import org.apache.commons.lang3.StringUtils;

/**
 * @author chenjun
 * @date 2021/5/17
 * @since V1.0.0
 */
public class GsdpBulkOrder {

    public static void main(String[] args) {
        String json =String.format( "{\"platform\":\"FB4_AIR\",\"orderNo\":\"%s\",\"packageList\":[{\"deliveryPeople\":{\"name\":\"asdfasdf\",\"phone\":\"2342342343\",\"mobile\":\"2342342343\",\"country\":\"CN\",\"province\":\"广东省\",\"city\":\"深圳市\",\"district\":\"龙岗区\",\"streetAddress\":\"asdfsdf\"},\"merchant\":{\"name\":\"测试\",\"phone\":\"18520830431\",\"mobile\":\"18520830431\",\"country\":\"CN\",\"province\":\"广东省\",\"city\":\"深圳市\",\"district\":\"龙岗区\",\"streetAddress\":\"asdfsdf\",\"normalAddr\":true},\"customerCode\":\"900002\",\"customerCodeType\":\"5\",\"orderNo\":\"%s\",\"trackingNumber\":\"%s\",\"dataSource\":\"FB4\",\"reservationTime\":\"2019-11-21 15:15:19.0\",\"businessType\":\"FB4_AIR\"},{\"deliveryPeople\":{\"name\":\"asdfasdf\",\"phone\":\"18520830431\",\"mobile\":\"18520830431\",\"country\":\"CN\",\"province\":\"广东省\",\"city\":\"深圳市\",\"district\":\"龙岗区\",\"streetAddress\":\"asdfsdf\"},\"merchant\":{\"name\":\"asdfasdf\",\"phone\":\"18520830431\",\"mobile\":\"18520830431\",\"country\":\"CN\",\"province\":\"广东省\",\"city\":\"深圳市\",\"district\":\"龙岗区\",\"streetAddress\":\"asdfsdf\",\"normalAddr\":true},\"customerCode\":\"900002\",\"customerCodeType\":\"5\",\"orderNo\":\"%s\",\"trackingNumber\":\"%s\",\"dataSource\":\"FB4\",\"reservationTime\":\"2019-11-21 15:15:19.0\",\"businessType\":\"FB4_AIR\"}]}",
                "TESTIC63",
                "TESTIC63","TEST600063",
                "TESTIC63","TEST600064");

        String dataDigest ="DFKLJDSHJ253SD2";
//        String requestUrl ="http://daily-idms2-gateway.wt.cainiao.com/gateway/DEFAULT";
//        String requestUrl ="http://pre-idms2-gateway.wt.cainiao.com/gateway/DEFAULT";
        String requestUrl ="http://idms2-gateway.wt.cainiao.com/gateway/DEFAULT";
        PacketEventDTO packetEventDTO = new PacketEventDTO();
        packetEventDTO.setCpCode("FB4");
        packetEventDTO.setMessageType("ADD_CLT_BULK_SUB_ORDER");
        BulkParcelForecastList data = JSON.parseObject(json, BulkParcelForecastList.class);
        String formatJsonData = JSON.toJSONString(data);
        packetEventDTO.setData(formatJsonData);
        packetEventDTO.setDataDigest(MD5Util.Md5Base64(formatJsonData + dataDigest));

        System.out.println(verify(formatJsonData, packetEventDTO.getDataDigest(), dataDigest));
        String result = HttpUtils.postJson(requestUrl, JSON.toJSONString(packetEventDTO));
        System.out.println("请求结果："+result);
    }

    public static boolean verify(String logisticsInterface, String dataDigest, String digest) {
        if (StringUtils.isAnyBlank(logisticsInterface, dataDigest)) {
            return false;
        }
        String verificationStr = MD5Util.Md5Base64(logisticsInterface + digest);
        dataDigest = dataDigest.replaceAll(" ", "+");
        return StringUtils.equals(verificationStr, dataDigest);
    }
}
