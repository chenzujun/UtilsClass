/**
 *
 */
package com.tool.domain;

import java.io.Serializable;

/**
 * @author sumy
 * desc:copy from pkg
 * @date 2018-05-02
 */
public class MaochaoPushEvent implements Serializable {

    /**
     * 消息类型
     */
    private String msg_type;
    /**
     * 事件类型
     */
    private String eventCode;
    /**
     * 来源CP编号
     */
    private String logisticProviderId;
    /**
     * 请求签名
     */
    private String dataDigest;
    /**
     * 目的方编码（可选，如不填使用该msg_type默认目的方）
     */
    private String to_code;
    /**
     * 事件类型是GTMS时值为Lastmile对象；事件类型是TRACE时，值为List<TracesElement>
     */
    private Object data;
    /**
     * LP号
     */
    private String orderNo;
    /**
     * 服务商单号
     */
    private String trackingNumber;
    /**
     * 4PL请求报文
     */
    private String logisticsInterface;

    public String getLogisticsInterface() {
        return logisticsInterface;
    }

    public void setLogisticsInterface(String logisticsInterface) {
        this.logisticsInterface = logisticsInterface;
    }

    public String getLogisticProviderId() {
        return logisticProviderId;
    }

    public void setLogisticProviderId(String logisticProviderId) {
        this.logisticProviderId = logisticProviderId;
    }

    public String getDataDigest() {
        return dataDigest;
    }

    public void setDataDigest(String dataDigest) {
        this.dataDigest = dataDigest;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getMsg_type() {
        return msg_type;
    }

    public void setMsg_type(String msg_type) {
        this.msg_type = msg_type;
    }

    public String getEventCode() {
        return eventCode;
    }

    public void setEventCode(String eventCode) {
        this.eventCode = eventCode;
    }

    public String getTo_code() {
        return to_code;
    }

    public void setTo_code(String to_code) {
        this.to_code = to_code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
