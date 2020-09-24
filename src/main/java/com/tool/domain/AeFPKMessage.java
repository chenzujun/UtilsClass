package com.tool.domain;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Getter
@Setter
@XmlRootElement(name = "request")
public class AeFPKMessage implements Serializable {

    private static final long serialVersionUID = 768653273480677715L;
    /**
     * 容器号
     */
    private String bigBagID;
    /**
     * 揽收交接单号
     */
    private String logisticsHandOver;
    /**
     * 大包运单号
     */
    private String trackingNumber;
    /**
     * 时区
     */
    private int timeZone;
    /**
     * 揽收时间
     */
    private String opTime;
    /**
     * CP code
     */
    private String operator;
    /**
     * 操作联系人
     */
    private String operatorContact;
    /**
     * 作业结果代码 1. 违禁品-重新获取运单 2. 超重
     */
    private String opCode;
    /**
     * 物流详情描述
     */
    private String trackingDescription;
}