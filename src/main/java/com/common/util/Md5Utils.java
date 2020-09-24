package com.common.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


@Slf4j
public class Md5Utils {

    private static final int HEX_WIDTH = 16;

    private static final char[] DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /**
     * md5编码,16进制,16位
     *
     * @param source 需要编码的字符串
     * @return 编码后字符串
     */
    public static String md5(String source) {

        try {
            byte[] byteString = source.getBytes(StandardCharsets.UTF_8);
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(byteString);
            byte[] digestString = md.digest();
            StringBuilder hexString = new StringBuilder();
            for (int i = 0; i < HEX_WIDTH; i++) {
                byte digestByte = digestString[i];
                char[] dc = new char[2];
                dc[0] = DIGITS[(digestByte >>> 4) & 0X0F];
                dc[1] = DIGITS[digestByte & 0X0F];
                hexString.append(new String(dc));
            }
            return hexString.toString();
        } catch (Exception e) {
            log.error("字符串md5异常", e);
        }
        return "";
    }

    /**
     * 字符串通过md5编码
     *
     * @param source 需要编码的字符串
     * @return 编码后的字符串
     */
    private static byte[] digest(String source) {

        byte[] result = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(source.getBytes(StandardCharsets.UTF_8));
            result = md.digest();
        } catch (NoSuchAlgorithmException e) {
            log.error("数据hash异常", e);
        }
        return result;
    }

    /**
     * 字符串md5生成hash字节码编码
     *
     * @param source string hash code
     * @return 编码后的字符串
     */
    public static String encodeMd5Digest(String source) {
        return Base64.encodeBase64String(digest(source));
    }

}