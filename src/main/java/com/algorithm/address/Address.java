package com.algorithm.address;

import lombok.Data;

/**
 * 地址类
 *
 * @author chenjun
 * @date 2019/1/7
 * @since V1.0.0
 */
@Data
public class Address {

    /**
     * 地址
     */
    private String address;
    /**
     * 经度
     */
    private Double longitude;
    /**
     * 纬度
     */
    private Double latitude;

}
