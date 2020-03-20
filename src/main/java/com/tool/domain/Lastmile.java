/**
 *
 */
package com.tool.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.util.Date;

/**
 * @author kaka
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "request")
public class Lastmile implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 5974728427359382197L;

    private String logisticsOrderCode;//  String(64)  物流单号

    private String gppOrderCode; //String(64) 自提订单单号(PPO开头)

    private String trackingNumber;//  String(64)  物流面单号

    private String waybillNumber;//   String(256) 提单号（进口）

    @XmlJavaTypeAdapter(XmlDateAdapter.class)
    private Date opTime;//  Time    作业时间

    private Integer timeZone;//    Int 时间时区

    private String transportType;//   String(32)  运输方式代码

    private String fromPortCode;//    String(32)  始发港

    private String toPortCode;//  String(32)  目的港

    private String operator;//    String(64)  操作人
    /**
     * v1.45 菜鸟自提柜回传派件员取回轨迹中 操作人字段
     */
    private String operatorName;//    String(64)  操作人

    private String operatorContact;// String(256) 操作人联系方式

    private String opLocation;//  String(64)  作业地点

    private String opCode;//  String(64)  作业结果代码;0为投递签收成功；1为投递失败

    private String opRemark;//    String(64)  描述信息

    private String imgUrl;//  String(64)  可以通过此字段进行图片回传 

    private String transportNo;// String(32)  航班号

    private String pickupCode;// String(64) 自提取货码

    private String locationType;// string(32) 地址属性

    private String trackingDescription;//String(256)  物流详情

    private Integer deliveriedTimes;//int(32) 投递次数（默认1）

    private String fplPickupEventCode;//自提平台事件区分

    /**
     * 站点编码
     */
    private String siteCode;

    /**
     * 行政区编码
     */
    private String administrationCode;

    /**
     * 片区编码
     */
    private String zoneCode;
    /**
     * 事件类型 IPR校验=IPR,通用回传=COMMON_UPDATE
     */
    private String infoType;
    /**
     * FINAL_DELIVERIED 最终签收；DESTORY 销毁；RETURNBACK 退回到目的国仓库
     */
    private String finalStatus;

    public String getFinalStatus() {
        return finalStatus;
    }

    public void setFinalStatus(String finalStatus) {
        this.finalStatus = finalStatus;
    }

    public String getInfoType() {
        return infoType;
    }

    public void setInfoType(String infoType) {
        this.infoType = infoType;
    }

    public String getFplPickupEventCode() {
        return fplPickupEventCode;
    }

    public void setFplPickupEventCode(String fplPickupEventCode) {
        this.fplPickupEventCode = fplPickupEventCode;
    }

    public Integer getDeliveriedTimes() {
        return deliveriedTimes;
    }

    public void setDeliveriedTimes(Integer deliveriedTimes) {
        this.deliveriedTimes = deliveriedTimes;
    }

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    public String getTrackingDescription() {
        return trackingDescription;
    }

    public void setTrackingDescription(String trackingDescription) {
        this.trackingDescription = trackingDescription;
    }

    public String getPickupCode() {
        return pickupCode;
    }

    public void setPickupCode(String pickupCode) {
        this.pickupCode = pickupCode;
    }

    public String getGppOrderCode() {
        return gppOrderCode;
    }

    public void setGppOrderCode(String gppOrderCode) {
        this.gppOrderCode = gppOrderCode;
    }

    public String getLogisticsOrderCode() {
        return logisticsOrderCode;
    }

    public void setLogisticsOrderCode(String logisticsOrderCode) {
        this.logisticsOrderCode = logisticsOrderCode;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getWaybillNumber() {
        return waybillNumber;
    }

    public void setWaybillNumber(String waybillNumber) {
        this.waybillNumber = waybillNumber;
    }

    public Date getOpTime() {
        return opTime;
    }

    public void setOpTime(Date opTime) {
        this.opTime = opTime;
    }

    public Integer getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(Integer timeZone) {
        this.timeZone = timeZone;
    }

    public String getTransportType() {
        return transportType;
    }

    public void setTransportType(String transportType) {
        this.transportType = transportType;
    }

    public String getFromPortCode() {
        return fromPortCode;
    }

    public void setFromPortCode(String fromPortCode) {
        this.fromPortCode = fromPortCode;
    }

    public String getToPortCode() {
        return toPortCode;
    }

    public void setToPortCode(String toPortCode) {
        this.toPortCode = toPortCode;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getOperatorContact() {
        return operatorContact;
    }

    public void setOperatorContact(String operatorContact) {
        this.operatorContact = operatorContact;
    }

    public String getOpLocation() {
        return opLocation;
    }

    public void setOpLocation(String opLocation) {
        this.opLocation = opLocation;
    }

    public String getOpCode() {
        return opCode;
    }

    public void setOpCode(String opCode) {
        this.opCode = opCode;
    }

    public String getOpRemark() {
        return opRemark;
    }

    public void setOpRemark(String opRemark) {
        this.opRemark = opRemark;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTransportNo() {
        return transportNo;
    }

    public void setTransportNo(String transportNo) {
        this.transportNo = transportNo;
    }

    public String getSiteCode() {
        return siteCode;
    }

    public void setSiteCode(String siteCode) {
        this.siteCode = siteCode;
    }

    public String getAdministrationCode() {
        return administrationCode;
    }

    public void setAdministrationCode(String administrationCode) {
        this.administrationCode = administrationCode;
    }

    public String getZoneCode() {
        return zoneCode;
    }

    public void setZoneCode(String zoneCode) {
        this.zoneCode = zoneCode;
    }
}
