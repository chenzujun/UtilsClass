package com.tool.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class BulkParcelForecast implements Serializable {
    /**
     *业务类型 AE
     */
    public String businessType;
    /**
     * 客户编码
     */
    public String customerCode;
    /**
     *  客户编码类型(1:CRM客户;2:xms客户;3:旺旺ID)
     */
    public String customerCodeType;
    /**
     * 客户标识 0:老客户; 1:新客户
     */
    public String customerMark;
    /**
     * 数据来源 XMS
     */
    public String dataSource;
    /**
     * 所有托寄物，以逗号分隔
     */
    public String goodsName;
    /**
     * 订单号
     */
    public String orderNo;
    /**
     * 下单时间 实际保存系统接收时间
     */
    public String orderTime;
    /**
     * 数量
     */
    public Integer quantity;
    /**
     * 总价
     */
    public Double totalPrice;
    /**
     * 运单号
     */
    public String trackingNumber;
    /**
     * 重量
     */
    public Double weight;
    /**
     * 交货人信息
     */
    public BulkParcelForecast.DeliveryPeople deliveryPeople;
    /**
     * 发件人信息
     */
    public BulkParcelForecast.Merchant merchant;

    public static class DeliveryPeople implements Serializable {
        public String name;
        public String phone;
        public String mobile;
        public String country;
        public String province;
        public String city;
        public String district;
        public String streetAddress;
        public String normalAddr;
        public DeliveryPeople() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getDistrict() {
            return district;
        }

        public void setDistrict(String district) {
            this.district = district;
        }

        public String getStreetAddress() {
            return streetAddress;
        }

        public void setStreetAddress(String streetAddress) {
            this.streetAddress = streetAddress;
        }

        public String getNormalAddr() {
            return normalAddr;
        }

        public void setNormalAddr(String normalAddr) {
            this.normalAddr = normalAddr;
        }
    }
    public static class Merchant implements Serializable {
        public String merchantId;
        public String name;
        public String phone;
        public String mobile;
        public String sendAddr;
        public Merchant() {
        }

        public String getMerchantId() {
            return merchantId;
        }

        public void setMerchantId(String merchantId) {
            this.merchantId = merchantId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getSendAddr() {
            return sendAddr;
        }

        public void setSendAddr(String sendAddr) {
            this.sendAddr = sendAddr;
        }
    }
}
