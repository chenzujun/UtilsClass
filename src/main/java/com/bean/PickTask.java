package com.bean;

import lombok.Data;

/**
 * @author chenjun
 * @date 2020/10/16
 * @since V1.0.0
 */
@Data
public class PickTask {

    private String pickupTaskNo;
    private String pickupTaskUniqueCode;

    private String containerNo;
    private String logisticsOrderNo;
}
