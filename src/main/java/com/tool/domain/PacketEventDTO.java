package com.tool.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class PacketEventDTO implements Serializable {
    private static final long serialVersionUID = -547825327903350679L;

    private String cpCode;
    /**
     * 消息类型
     */
    private String messageType;
    /**
     * 验签密钥
     */
    private String dataDigest;
    /**
     * 数据
     */
    private String data;

}