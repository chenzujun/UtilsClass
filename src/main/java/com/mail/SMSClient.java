package com.mail;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.codec.digest.DigestUtils;

import com.alibaba.fastjson.JSONObject;

public class SMSClient {

    private static final String ACCOUNT_SID = "bc1797e42fa849ef992543a83edc38ea";
    private static final String TOKEN = "cf6ef5178fba4922aad65ea1d6664990";
    private static final String URL = "https://api.miaodiyun.com/20150822/industrySMS/sendSMS";

    public static void sendSMS(String phone, String content) {
        sendMiaoDiSms(ACCOUNT_SID, TOKEN, phone, content, URL);
    }

    public static String sendMiaoDiSms(String accountSid, String token,
            String phone, String smsContent, String url) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestamp = sdf.format(new Date());
        String sig = DigestUtils.md5Hex(accountSid + token + timestamp);
        String body = "accountSid=" + accountSid + "&to=" + phone
                + "&smsContent=" + smsContent + "&timestamp=" + timestamp
                + "&sig=" + sig + "&respDataType=" + "json";

        String result = "";
        try {
            OutputStreamWriter out = null;
            BufferedReader in = null;
            URL realUrl = new URL(url);
            URLConnection conn = realUrl.openConnection();
            // 设置连接参数
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(20000);
            // 提交数据
            out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
            out.write(body);
            out.flush();
            // 读取返回数据
            in = new BufferedReader(new InputStreamReader(
                    conn.getInputStream(), "UTF-8"));
            String line = "";
            boolean firstLine = true; // 读第一行不加换行符
            while ((line = in.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                } else {
                    result += "\r\n";
                }
                result += line;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("result==" + result);
        JSONObject jsStr = JSONObject.parseObject(result);
        String respCode = jsStr.getString("respCode");
        String jieguoString = null;
        if (respCode.equals("00000")) {
            jieguoString = "0";
        } else {
            jieguoString = respCode;
        }
        return jieguoString;
    }
    
    public static void main(String[] args) {
//        sendSMS("18101610431", String.format("【云呼】%s", "自定义短信模式"));
    }
}
