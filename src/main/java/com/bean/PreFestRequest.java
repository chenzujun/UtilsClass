package com.bean;

import lombok.Data;

/**
 * 换号请求
 *
 * @author chenjun
 * @date 2018/7/25
 * @since V1.0.0
 */
@Data
public class PreFestRequest extends GenerateNumberRequest {
    private static final long serialVersionUID = -3017109745525150878L;
    private String dateDelivery;
    private String isTransitCoverRequired;
    private String transitCoverAmount;
    private String specification;
    private String deliveryType;
    private String selfPickUpCode;
    private String selfPickUpAddress;
    private String plateNumber;
}
