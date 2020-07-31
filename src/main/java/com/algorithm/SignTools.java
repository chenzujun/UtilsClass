package com.algorithm;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.net.URLEncoder;

/**
 * @author chenjun
 * @date 2020/7/7
 * @since V1.0.0
 */
public class SignTools {

    /**
     * 秘钥
     */
    private static final String SECRET = "secret";

    public static String getSign(String msg) {
        String sign = null;
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(SECRET.getBytes("UTF-8"), "HmacSHA256"));
            byte[] signData = mac.doFinal(msg.getBytes("UTF-8"));
            sign = URLEncoder.encode(new String(Base64.encodeBase64(signData)),"UTF-8");
            System.out.println("base64="+sign);
            System.out.println(byteArrayToHexString(signData));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sign;
    }

    public  static String byteArrayToHexString(byte[] b) {
        StringBuilder hs = new StringBuilder();
        String stmp;
        for (int n = 0; b!=null && n < b.length; n++) {
            stmp = Integer.toHexString(b[n] & 0XFF);
            if (stmp.length() == 1){
                hs.append('0');
            }
            hs.append(stmp);
        }
        return hs.toString().toLowerCase();
    }

    public static void main(String[] args) {
        System.out.println(SignTools.getSign("{\"bizEventSourceType\":\"PMS_BIZ_OP_CONTAINER_FPK\",\"bizNo\":\"1677964532720758784\",\"bizSystem\":\"AE\",\"opCode\":\"E0001\",\"opTime\":1594092487714,\"operator\":\"sumy\",\"pushEventMsgType\":\"PMS_CONTAINER_PICKUP_CALLBACK\"}"));

    }
}
