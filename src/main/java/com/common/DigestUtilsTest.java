package com.common;


import org.apache.commons.codec.digest.DigestUtils;

public class DigestUtilsTest {

    /**
     * 生成sign：业务数据+私钥 用md5加密
     *
     * @param data
     * @return
     */
    public static String getSign(String data){
        // 对应appkey=56A496586265422397F72A9991A3F4A9
        String secretKey = "DBCD8821C9094514B653E005116CEF45";
        return DigestUtils.md5Hex(data+secretKey);
    }

    public static void main(String[] args) {
        String bizdata = "{\"locationCode\":\"kw01.01.02\",\"warehouseNumber\":\"900192225405\",\"referenceNumber\":\"\",\"appOperationTime\":1573783087854,\"userId\":\"68c837d65b294252a66707b5fccd227c\",\"userName\":\"S9614\",\"whName\":\"\",\"whCode\":\"HKG-P005\",\"siteType\":\"TRANS_WH\",\"isUniqueLocation\":false}";
        System.out.println(getSign(bizdata));
    }
}
