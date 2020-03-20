

package com.tool.domain;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Pkg implements Serializable {

    private static final long serialVersionUID = -7783798332104156746L;
    /**
     * shippingNo
     */
    private String shippingNo;
    /**
     * packageCode
     */
    private String packageCode;
    private String status;
    /**
     * 操作记录：状态对应的操作记录，如客户签收对应的操作记录（客户签收、ATL签收、非正常客户签收、到达自提点签收）
     */
    private String operationRecord;
    private String issueFlag;
    /**
     * 异常类型
     */
    private String issueType;
    /**
     * 异常原因类型
     */
    private String issueReason;
    /**
     * 备注
     */
    private String remark;
    private String msg_type;
    private String dataTime;
    /**
     * 文案
     */
    private String description;
    //操作人
    private String operator;
    //验证码
    private String authCode;
    //库位号
    private String locationCode;
    //入柜时间
    private String inBoxTime;
    //逾期时间
    private String expireTime;
    //柜子号
    private String boxNo;
    //出柜方式
    private String outBoxType;
    //业务类型
    private String busType;
    //派送次数
    private int deliverTimes;
    //派送方式(1.19 猫超自提件客户签收异常需要根据派送方式做判断)
    private String deliveryType;
    private transient String clientId;
    //客户
    private String platform;
    //是否付附加费
    private String isAdditionalFee;
    //操作时间
    private Date operationTime;
    //自提订单单号(PPO开头)
    private String gppOrderCode;
    //地址属性
    private String addressAttribute;
    //外部物流单号
    private String logisticsCode;
    //仓库code
    private String warehouseCode;
    //cp资源code
    private String logisticProviderId;
    //操作类型
    private String opCode;
    //渠道
    private String channel;
    /**
     * 服务商单号
     */
    private String spNumber;
    /**
     * 异常原因
     */
    private String issueDescription;
    /**
     * 地域:香港 台湾 澳洲等
     */
    private String areaCode;
    /**
     * 仓库名称
     */
    private String warehouseName;
    /**
     * 操作员联系方式
     */
    private String operatorContactWay;
    /**
     * 异常备注
     */
    private String issueRemark;
    /**
     * 自提点简称
     * @return
     */
    private String picupAddr;

    private Date receiveTime;
}
