package com.tool.domain;

import java.io.Serializable;

/**
 * @author chenjun
 * @date 2020/6/11
 * @since V1.0.0
 */
public class TransferObj implements Serializable {
    private static final long serialVersionUID = 1418393038683195283L;
    private String trackingNumber;

    private RequestObj request;

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public RequestObj getRequest() {
        return request;
    }

    public void setRequest(RequestObj request) {
        this.request = request;
    }
}