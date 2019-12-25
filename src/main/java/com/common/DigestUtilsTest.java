/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
