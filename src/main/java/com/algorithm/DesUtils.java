package com.algorithm;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;

public class DesUtils {

    private static final String AESTYPE = "AES/ECB/PKCS5Padding";
    public static final String KEYSTR = "yunhu!@#1crm.com";

    public static String AES_Encrypt(String keyStr, String plainText) {
        if (StringUtils.isBlank(plainText))
            return null;
        byte[] encrypt = null;
        try {
            Key key = generateKey(keyStr);
            Cipher cipher = Cipher.getInstance(AESTYPE);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            encrypt = cipher.doFinal(plainText.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new String(Base64.encodeBase64(encrypt));
    }

    public static String AES_Decrypt(String keyStr, String encryptData) {
        if (StringUtils.isBlank(encryptData))
            return null;
        byte[] decrypt = null;
        try {
            Key key = generateKey(keyStr);
            Cipher cipher = Cipher.getInstance(AESTYPE);
            cipher.init(Cipher.DECRYPT_MODE, key);
            decrypt = cipher.doFinal(Base64.decodeBase64(encryptData.getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new String(decrypt).trim();
    }

    private static Key generateKey(String key) throws Exception {
        try {
            SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "AES");
            return keySpec;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

    }

    public static void main(String[] args) {
        System.out.println(DesUtils.AES_Encrypt(DesUtils.KEYSTR, "{\"id\":\"1\",\"mobile\":\"151012145412\"}"));
        System.out.println(DesUtils.AES_Decrypt(DesUtils.KEYSTR, "qPNL2W6ghycJeVUianVNSNI95GyOyK+r3wqncWBplt/xqvNkQfB2KfuBiXUJmH2x"));
    }
}
