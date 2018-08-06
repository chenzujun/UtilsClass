/*
 * Copyright (c) 2005-2018. 4PX and/or its affiliates. All rights reserved. Use,Copy is subject to authorized license.
 */
package com.common.util.http;

import com.alibaba.fastjson.JSONObject;
import com.bean.ApiResponse;
import com.bean.PreFestRequest;
import com.common.util.ExcelUtils;
import com.common.util.HttpUtils;
import com.common.util.JsonUtil;
import com.common.util.document.FileProperties;
import com.grammar.thread.CommonThreadExecutor;
import org.apache.commons.collections.CollectionUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * http请求集合
 *
 * @author chenjun
 * @date 2018/7/25
 * @since V1.0.0
 */
public class HttpRequestSet {
    public static final Logger logger = LoggerFactory.getLogger(HttpRequestSet.class);

    public static final String CHANNEL_CONFIG_FILE_PATH="F:/config/channel-test.properties";
    public static final String CHANNEL_SERVICE_URL ="channel.service.url";
    public static final String CHANNEL_SERVICE_METHOD = "channel.service.method.submitFest";
    public static final String CHANNEL_SERVICE_APPKEY = "channel.service.appkey";
    private static final String EXCEL_FILE_PATH = "F:/channel.xlsx";

    public static String getChannelServiceUrl(){
        String urlPrefix = FileProperties.getMyProperty(CHANNEL_CONFIG_FILE_PATH, CHANNEL_SERVICE_URL);
        String method = FileProperties.getMyProperty(CHANNEL_CONFIG_FILE_PATH, CHANNEL_SERVICE_METHOD);
        String appkey = FileProperties.getMyProperty(CHANNEL_CONFIG_FILE_PATH, CHANNEL_SERVICE_APPKEY);
        String url = MessageFormat.format(urlPrefix, method, appkey);

        return url;
    }

    public Map<String, Object> buildParams(Row row) {
        Map<String, Object> params = new HashMap<>(5);
        // TODO
        params.put("channelCode", "711");
        params.put("orderNo", ExcelUtils.getStringValue(row, 1));
        params.put("organizationCode", "CNTPEA");

        List<PreFestRequest> list = new ArrayList<>();
        PreFestRequest pr = new PreFestRequest();
        list.add(pr);
        params.put("preFestRequests", list);

        return params;
    }

    public void requestChannel(){
        // 获取url
        String url = getChannelServiceUrl();

        // 读取参数文件
        Sheet sheet = ExcelUtils.getSheet(EXCEL_FILE_PATH);
        int sheetRows = sheet.getLastRowNum();

        // 获取指定单元格的对象引用
        for (int i = 1; i <= sheetRows; i++) {
            Row row = sheet.getRow(i);
            if (row == null) {
                continue;
            }
            // 封装参数发起请求
            Map<String, Object> params = buildParams(row);

            AsyncPost asyncPost = new AsyncPost(params, url, ExcelUtils.getStringValue(row, 1));
            CommonThreadExecutor.execute(asyncPost);
        }

    }

    class AsyncPost implements Runnable {
        private Object params;

        private String url;
        private String shippingNo;

        public AsyncPost(Object params, String url, String shippingNo) {
            this.params = params;
            this.url = url;
            this.shippingNo = shippingNo;
        }

        @Override
        public void run() {
            logger.info("上传换号系统数据：{}", JsonUtil.toJson(params));
            try {
                String result = "";
                int repeatNumber = 0;
                String errCode = "";
                do {
                    repeatNumber++;
                    result = HttpUtils.postJson(url, params);
                    ApiResponse response = JSONObject.parseObject(result, ApiResponse.class);
                    logger.info("换号系统返回结果：{}，预报次数:{},单号：{}", result, repeatNumber, shippingNo);
                    if (null == response) {
                        break;
                    }
                    if ("1".equalsIgnoreCase(JSONObject.parseObject(result).get("result").toString())) {
                        break;
                    }
                    if (CollectionUtils.isEmpty(response.getErrors())) {
                        break;
                    }
                    errCode = response.getErrors().get(0).getMessage();
                }
                while ("10001".equals(errCode) && repeatNumber < 4);
            } catch (Exception e) {
                logger.info("上传换号系统数据异常：单号：{}", shippingNo, e);
            }

        }
    }

    public static void main(String[] args) {
        HttpRequestSet srs = new HttpRequestSet();
        srs.requestChannel();
    }
}
