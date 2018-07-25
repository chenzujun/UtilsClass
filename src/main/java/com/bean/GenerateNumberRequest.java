package com.bean;

import lombok.Data;

/**
 * @author chenjun
 * @date 2018/7/25
 * @since V1.0.0
 */
@Data
public class GenerateNumberRequest extends BaseRequest {
    private static final long serialVersionUID = 7870231191820659526L;
    private String customerCode;
    private String provider;
    private String shipperId;
    private String shipperCompanyName;
    private String shipperName;
    private String shipperStateOrProvince;
    private String shipperCity;
    private String shipperCounty;
    private String shipperStreet;
    private String shipperPostCode;
    private String shipperEmail;
    private String shipperPhone;
    private String shipperCountryCode;
    private String invoiceUrl;
    private String consigneeIdNumber;
    private String consigneeTaxNumber;
    private String consigneeName;
    private String consigneeFirstName;
    private String consigneeLastName;
    private String consigneeCompanyName;
    private String consigneeStateOrProvince;
    private String consigneeCity;
    private String consigneeCounty;
    private String consigneeStreet;
    private String consigneePostalCode;
    private String consigneePhone;
    private String consigneeEmail;
    private String consigneeCountryCode;
    private String goodsName;
    private String type;
    private String value;
    private String weight;
    private String quantity;
    private String productCode;
    private String countryCode;
    private String orderSequence;
    private String description;
    private String shipperExportTax_flag;
    private String childNumber;
    private String barCode;
    private String insurFlag;
    private String chargeCode;
    private String trackingNumber;
    private String dateLodgedPeriod;
    private String dateLodged;
    private String senderAccount;
    private String payerAccount;
    private String currencyCode;
    private String token;
    private String consigneeHouseNo;
    private String shipperHouseNo;
    private Double length;
    private Double height;
    private Double width;
    private String serverCodeType;
    private String isZWC;
    private Integer collectionVal;
    private Double collectionMoney;
    private String insurType;
    private String insurValue;
//    private CommonInfo channelPro;
//    private Producer producer;
//    private List<GenerateSkuInfo> skus;
    private String invoiceDate;
    private String reasonForExport;
//    private List<GeneratePackageInfo> packages;
    private String specialServiceType;
    private String serialNum;
//    private List<ShipmentInfo> ShipmentInfoList;
    private String consigneeTranslationAddressLine1;
    private String consigneeTranslationAddressLine2;
}
