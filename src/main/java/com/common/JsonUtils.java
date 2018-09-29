package com.common;


import com.alibaba.fastjson.JSONObject;
import com.bean.FastJsonBean;

/**
 * 封装json处理
 *
 * @author chenjun
 * @date 2018/9/28
 * @since V1.0.0
 */
public class JsonUtils {
    public static void main(String[] args) {
        FastJsonBean bean = new FastJsonBean();
        bean.setName("陈嘉上");
        bean.setAge(15);
        bean.setHiddenVal(40);
        bean.setIntegerVal(14);

        String jsonStr = JSONObject.toJSONString(bean);
        System.out.println("转换为json:" + jsonStr);

        String jsonStr2 = "{\"age2\":15,\"name\":\"陈嘉上\",\"hiddenVal\":\"45\"}";
        FastJsonBean bean2 = JSONObject.parseObject(jsonStr2, FastJsonBean.class);
        System.out.println(bean2.toString());
    }
}
