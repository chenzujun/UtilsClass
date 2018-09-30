package com.common.codec;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.language.Metaphone;
import org.apache.commons.codec.language.RefinedSoundex;
import org.apache.commons.codec.language.Soundex;
import org.apache.commons.codec.net.URLCodec;

import java.io.UnsupportedEncodingException;

/**
 * Apache Commons家族中的Commons Codec测试
 *
 * @author chenjun
 * @date 2018/9/30
 * @since V1.0.0
 */
public class TestCodec {

    public static void main(String[] args) throws Exception {
//        testBase64();
//        testHex();
//        testMD5();
//        testSha();
//        testMetaphoneAndSoundex();
        testURLCodec();
    }

    /**
     * Base64编解码
     */
    public static void testBase64(){
        Base64 base64 = new Base64();
        String str = "AAaaa我";
        //编码
        String result = null;
        try {
            result = base64.encodeToString(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(str+"| base64 encodeToString编码结果："+result);
        //解码
        byte[] decode = base64.decode(result.getBytes());
        System.out.println(result+"| base64 decode编码结果："+new String(decode));
    }

    /**
     * Hex编码和解码
     */
    public static void testHex() throws DecoderException, UnsupportedEncodingException {
        String str = "test陈";
        /**编码*/
        String hexString = Hex.encodeHexString(str.getBytes("UTF-8"));
        System.out.println(str+"| Hex encodeHexString编码结果："+hexString);
        //先转换成char数组，第二个参数意思是是否全部转换成小写
        char[] encodeHex = Hex.encodeHex(str.getBytes(), true);
        System.out.println(str+"| Hex encodeHexString编码结果转小写："+new String(encodeHex));
        //char数组型的
        byte[] decodeHex = Hex.decodeHex(encodeHex);
        System.out.println(encodeHex+"| Hex decodeHex编码结果："+new String(decodeHex));
        byte[] decodeHex2 = Hex.decodeHex(hexString.toCharArray());
        System.out.println(hexString+"| Hex decodeHex编码结果："+new String(decodeHex2));
    }

    /**
     * MD5加密（MD5是不可逆算法，只能加密）
     */
    public static void testMD5() throws UnsupportedEncodingException {
        String str = "test陈-";
        String md5 = DigestUtils.md5Hex(str.getBytes("UTF-8"));
        System.out.println(str+"| MD5 md5Hex编码结果：" + md5);
    }

    /**
     * SHA加密算法
     */
    public static void testSha() throws UnsupportedEncodingException {
        String str = "test中国";
        String sha1Hex = DigestUtils.sha1Hex(str.getBytes("UTF-8"));
        System.out.println(str+"| sha1Hex 编码结果：" + sha1Hex);

        String sha256Hex = DigestUtils.sha256Hex(str.getBytes("UTF-8"));
        System.out.println(str+"| sha256Hex 编码结果：" + sha256Hex);

        String sha384Hex = DigestUtils.sha384Hex(str.getBytes("UTF-8"));
        System.out.println(str+"| sha384Hex 编码结果：" + sha384Hex);

        String sha512Hex = DigestUtils.sha512Hex(str.getBytes("UTF-8"));
        System.out.println(str+"| sha512Hex 编码结果：" + sha512Hex);
    }

    /**
     * Metaphone 建立出相同的key给发音相似的单字, 比 Soundex 还要准确, 但是 Metaphone 没有固定长度,
     * Soundex 则是固定第一个英文字加上3个数字. 这通常是用在类似音比对, 也可以用在 MP3 的软件开发
     * metaphone() 比 soundex() 函数更精确，因为 metaphone() 了解基本的英语发音规则
     */
    public static void testMetaphoneAndSoundex(){
        String str = "testgggggg";
        /**Metaphone没有固定长度*/
        Metaphone metaphone = new Metaphone();
        String metaphoneEncode = metaphone.encode(str);
        System.out.println(str+"| Metaphone encode 编码结果：" + metaphoneEncode);

        /**RefinedSoundex*/
        RefinedSoundex refinedSoundex = new RefinedSoundex();
        String refinedSoundexEncode = refinedSoundex.encode(str);
        System.out.println(str+"| RefinedSoundex encode 编码结果：" + refinedSoundexEncode);

        /**Soundex固定第一个英文字加上3个数字*/
        Soundex soundex = new Soundex();
        String soundexEncode = soundex.encode(str);
        System.out.println(str+"| Soundex encode 编码结果：" + soundexEncode);
    }

    /**
     * URLCodec
     *
     * @throws EncoderException
     * @throws DecoderException
     */
    public static void testURLCodec() throws EncoderException, DecoderException {
        String url = "http://baidu.com?name=你好";
        URLCodec codec = new URLCodec();
        String encode = codec.encode(url);
        System.out.println(url+"| URLCodec encode 编码结果：" + encode);
        String decode = codec.decode(encode);
        System.out.println(url+"| URLCodec decode 编码结果：" + decode);
    }
}
