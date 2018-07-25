package com.common.util;

import com.google.gson.Gson;

/**
 * @author chenjun
 * @date 2018/7/25
 * @since V1.0.0
 */
public class JsonUtil {

    private static class SingletonHolder {
        private static final Gson INSTANCE = new Gson();
    }

    private JsonUtil (){}

    public static final Gson getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public static String toJson(Object obj) {
        return getInstance().toJson(obj);
    }
}
