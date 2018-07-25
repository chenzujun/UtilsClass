package com.common.util;

import com.google.gson.Gson;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.*;


public class HttpUtils {

    private static final Logger logger = LoggerFactory.getLogger(HttpUtils.class);

    private static HttpClient httpClient;
    private static PoolingHttpClientConnectionManager cm;
    private static RequestConfig requestConfig;
    //失败重连
    private static HttpRequestRetryHandler requestRetryHandler;

    static {
        cm = new PoolingHttpClientConnectionManager();
        // Increase max total connection to 200
        cm.setMaxTotal(200);
        // Increase default max connection per route to 20
        cm.setDefaultMaxPerRoute(20);
        // 设置超时30秒
        requestConfig = RequestConfig.custom()
                .setSocketTimeout(30000)
                .setConnectTimeout(30000)
                .setConnectionRequestTimeout(30000)
                .build();

        requestRetryHandler = new HttpRequestRetryHandler() {
            @Override
            public boolean retryRequest(IOException exception, int executionCount,
                                        HttpContext context) {
                //失败重连大于3次就放弃
                if (executionCount > 3) {
                    logger.error("Maximum tries reached for client http pool");
                    return false;
                }
                if (exception instanceof org.apache.http.NoHttpResponseException) {
                    logger.error("No response from server on " + executionCount + " call");
                    return true;
                }
                return false;
            }
        };
        httpClient = HttpClients.custom().setRetryHandler(requestRetryHandler).setConnectionManager(cm).setDefaultRequestConfig
                (requestConfig).build();
    }

    /**
     * http client get request
     *
     * @param url
     * @return
     */
    public static String get(String url) {
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = null;
        try {
            response = (CloseableHttpResponse) httpClient.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == 200) {
                return EntityUtils.toString(response.getEntity());
            } else {
                logger.error("访问路径：" + url);
            }

        } catch (IOException e) {
            logger.error("调用失败：" + e.getMessage(), e);
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * http client post request
     *
     * @param url
     * @param params
     * @param @see   org.springframework.http.MediaType
     * @return
     */
    public static String post(String url, Map<String, String> params)  {
        HttpPost httpPost = new HttpPost(url);
        if (params != null) {
            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
            Set<String> keySet = params.keySet();
            for (String key : keySet) {
                nvps.add(new BasicNameValuePair(key, params.get(key)));
            }

            try {
                httpPost.setEntity(new UrlEncodedFormEntity(nvps, "UTF-8"));
            } catch (UnsupportedEncodingException e1) {
                e1.printStackTrace();
            }
        }

        CloseableHttpResponse response = null;
        try {
            response = (CloseableHttpResponse) httpClient.execute(httpPost);
            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity httpEntity = response.getEntity();
                return EntityUtils.toString(httpEntity);
            } else {
                logger.error("访问路径：" + url);
            }

        } catch (IOException e) {
            logger.error("调用失败：" + e.getMessage(), e);
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * http client post request
     *
     * @param url
     * @param params
     * @param @see   org.springframework.http.MediaType
     * @return
     */
    public static String post(String url, Map<String, String> params, String encode)  {
        HttpPost httpPost = new HttpPost(url);
        if (params != null) {
            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
            Set<String> keySet = params.keySet();
            for (String key : keySet) {
                nvps.add(new BasicNameValuePair(key, params.get(key)));
            }

            try {
                httpPost.setEntity(new UrlEncodedFormEntity(nvps, "UTF-8"));
            } catch (UnsupportedEncodingException e1) {
                e1.printStackTrace();
            }
        }

        CloseableHttpResponse response = null;
        try {
            response = (CloseableHttpResponse) httpClient.execute(httpPost);
            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity httpEntity = response.getEntity();
                if (StringUtils.isEmpty(encode)) {
                    return EntityUtils.toString(httpEntity);
                } else {
                    return new String(EntityUtils.toString(httpEntity).getBytes("ISO-8859-1"), encode);
                }
            } else {
                logger.info("访问路径：" + url);
            }

        } catch (IOException e) {
            logger.error("调用失败：" + e.getMessage(), e);
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 向请求添加头域
     *
     * @param request 请求对象
     * @param headers 头域map
     * @return 添加头域后的请求对象
     */
    private static HttpRequestBase setHeaders(HttpRequestBase request, Map<String, String> headers) {
        Iterator<String> keyIterator = headers.keySet().iterator();
        String key = null;

        while (keyIterator.hasNext()) {
            key = keyIterator.next();
            request.addHeader(key, headers.get(key));
        }

        return request;
    }

    public static String postJson(String url, Object params) {
        HttpPost httpPost = new HttpPost(url);
        httpPost.addHeader("Content-Type", "application/json");
        if (params != null) {
            Gson gson = new Gson();
            String paramStr = gson.toJson(params);
            httpPost.setEntity(new StringEntity(paramStr, Charset.forName("UTF-8")));
        }

        try {
            CloseableHttpResponse response = (CloseableHttpResponse)httpClient.execute(httpPost);
            Throwable var4 = null;
            String var5 = null;
            try {
                if (response.getStatusLine().getStatusCode() != 200) {
                    logger.error("请求失败URL:{} , StatusCode:{}", new Object[]{url, response.getStatusLine().getStatusCode()});
                }

                var5 = EntityUtils.toString(response.getEntity());
            } catch (Throwable var15) {
                var4 = var15;
            } finally {
                if (response != null) {
                    if (var4 != null) {
                        try {
                            response.close();
                        } catch (Throwable var14) {
                            var4.addSuppressed(var14);
                        }
                    } else {
                        response.close();
                    }
                }

            }
            return var5;
        } catch (Exception var17) {
            logger.error("请求异常：" + var17.getMessage(), var17);
            return null;
        }
    }

}
