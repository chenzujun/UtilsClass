package com.tool;

import com.alibaba.fastjson.JSON;
import com.common.util.HttpUtils;
import com.common.util.JaxBeanAndXmlConvertUtils;
import com.common.util.Md5Utils;
import com.tool.domain.AeFPKMessage;
import com.tool.domain.AeMessage;
import org.apache.commons.lang.StringEscapeUtils;

import java.io.*;

public class CltRabbitMqHttp {


    public static void main(String[] args) throws Exception {
        resend();
    }

    public static void resend() throws Exception{
        //String utl = "http://pds-asm:pds-asm@环境:15672/api/exchanges/虚拟主机/交换器/publish";
//        final String URL = "http://pms:pms123456@10.104.6.78:15672/api/exchanges/pms/PMS_X_PICKUP_HANDOVER_CALLBACK_INFO/publish";
        final String URL = "http://mq_pds:p18y10m12s@172.16.5.42:15672/api/exchanges/fpx-pms/PMS_X_PICKUP_HANDOVER_CALLBACK_INFO/publish";
        // LP00409335831736	HO1788703225458029	2020-09-24 11:24:01	伍玉平	4PX0000851774
        String path ="E:\\temp\\output.txt";

        BufferedReader br = null;
        try {
            br=new BufferedReader(new InputStreamReader(new FileInputStream(path),"UTF-8"));
            String s;
            int i = 0;
            while ((s = br.readLine()) != null) {
                AeMessage ins = getAeMessage(s);
                String payload = JSON.toJSONString(ins);
                payload = StringEscapeUtils.escapeJava(payload);

                String body = "{\"vhost\":\"fpx-pms\",\"name\":\"amq.default\",\"properties\":{\"delivery_mode\":1,\"headers\":{}},\"routing_key\":\"PMS_R_PICKUP_HANDOVER_CALLBACK_INFO\",\"delivery_mode\":\"1\",\"payload\":\"" + payload + "\",\"headers\":{},\"props\":{},\"payload_encoding\":\"string\"}";

                String result = HttpUtils.postTextplain(URL, body);
                System.out.println(result);
//                System.out.println(body);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static AeMessage getAeMessage(String s){
        String[] arr = s.split("\t");
        System.out.println(arr[0]+ " | " + arr[3]);

        AeMessage aeMessage = new AeMessage();
        aeMessage.setMsgType("CAINIAO_GLOBAL_PICKUP_HANDOVER_ORDER_CALLBACK");

        AeFPKMessage ls = new AeFPKMessage();
        ls.setBigBagID(arr[0]);
        ls.setLogisticsHandOver(arr[1]);
        ls.setOpCode("0");
        ls.setOpTime(arr[2]);
        ls.setOperator("4PX-CLT");
        ls.setOperatorContact(arr[3]);
        ls.setTimeZone(8);
        ls.setTrackingNumber(arr[4]);
        String secretKey = "DFKLJDSHJ253SD2";
        String msgDataStr = JaxBeanAndXmlConvertUtils.bean2Xml(ls);
        aeMessage.setDataDigest(Md5Utils.encodeMd5Digest(msgDataStr + secretKey));
        aeMessage.setBizNo(arr[0]);
        aeMessage.setLogisticsInterface(msgDataStr);
        aeMessage.setTrackingNumber(arr[4]);
        aeMessage.setEventType("PICKUP_HANDOVER");
        aeMessage.setOgCode("Tran_Store_13423762");

        return aeMessage;
    }

}
