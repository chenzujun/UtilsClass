package com.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @author chenjun
 * @date 2018/7/25
 * @since V1.0.0
 */
@Data
public class BaseRequest implements Serializable  {

    private static final long serialVersionUID = -1111379611700412818L;

    private String customChannelCode;
    private String channelCode;
    private String appKey;
    private String organizationCode;
    private String channelCodeServer;
    private String orderNo;
    private String referenceNo;
}
