package com.tool.domain;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class AeMessage implements Serializable {

    private static final long serialVersionUID = -6558784407723731017L;
    /**
     * 请求签名
     */
    @JSONField(name = "msgEncrypt")
    private String dataDigest;
    /**
     * 请求报文
     */
    @JSONField(name = "msgData")
    private String logisticsInterface;
    /**
     * 消息类型
     */
    private String msgType;
    /**
     * 业务唯一编号
     */
    @JSONField(name = "logisticsOrderCode")
    private String bizNo;
    /**
     * 运单号
     */
    private String trackingNumber;
    /**
     * 上游系统记录数据请求方
     */
    private String source = "PDS";
    /**
     * 仓库编码
     */
    private String ogCode;
    /**
     * xms 用于映射msgType 和 eventType 关系
     */
    private String eventType;
}