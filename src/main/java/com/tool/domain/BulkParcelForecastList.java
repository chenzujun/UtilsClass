package com.tool.domain;

import lombok.Data;

import java.util.List;


@Data
public class BulkParcelForecastList {
    /**
     * 平台：FB4_AIR
     */
    private String platform;

    private String orderNo;

    private List<BulkParcelForecast> packageList;
}