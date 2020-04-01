package com.common;


import java.io.Serializable;
import java.util.*;


public class ResponseMessage implements Serializable {

    private static final long serialVersionUID = -9045630311510413293L;

    /**
     * 请求结果标识
     */
    private String flag;

    /**
     * 国际化配置 key
     */
    private String code;

    /**
     * 返回的信息
     */
    private String message;

    /**
     * 任何传入页面的数据对象
     */
    private Map<String, Object> dataMap;

    public ResponseMessage(Builder builder) {
        this.flag = builder.flag;
        this.code = builder.code;
        this.message = builder.message;
        this.dataMap = builder.data;
    }

    public static class Builder {

        private String flag;
        private String code;
        private String message;
        private Map<String, Object> data;

        public Builder() {
        }

        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder setData(Map<String, Object> data) {
            this.data = data;
            return this;
        }

        public Builder success() {
            this.code = ResponseCodeConstants.CODE_SUCCESS;
            this.flag = ResponseCodeConstants.FLAG_SUCCESS;
            return this;
        }

        public Builder fail(String code) {
            this.flag = ResponseCodeConstants.FLAG_FAILURE;
            this.code = code;
            return this;
        }

        /**
         * 返回response 对象,不支持多语言
         *
         * @return 响应对象
         */
        public ResponseMessage build() {
            return  new ResponseMessage(this);
        }

    }

    @Override
    public String toString() {
        return "ResponseMessage{" +
                "flag='" + flag + '\'' +
                ", code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", dataMap=" + dataMap +
                '}';
    }
}
