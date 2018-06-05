package com.common.util;

import org.apache.commons.lang.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author chenjun
 * @date 2018/5/24
 */
public class ChineseAndEnglish {

    // GENERAL_PUNCTUATION 判断中文的"号
    // CJK_SYMBOLS_AND_PUNCTUATION 判断中文的。号
    // HALFWIDTH_AND_FULLWIDTH_FORMS 判断中文的，号
    /**
     * 是否是中文
     *
     * @param c
     * @return
     */
    public static boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
            return true;
        }
        return false;
    }

    public static boolean isChinese(String str) {
        String regEx = "[\\u4e00-\\u9fa5]+";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        if (m.find()){
            return true;
        } else{
            return false;
        }
    }

    /**
     * 是否是英文
     *
     * @param c
     * @return
     */
    public static boolean isEnglish(String charaString) {
        return charaString.matches("^[a-zA-Z]*");
    }

    public static boolean isEnglish2(String str) {
        if(StringUtils.isEmpty(str)){
            return true;
        }
        byte[] bytes = str.getBytes();
        // 字节长度
        System.out.println(bytes.length +"="+str.length());
        if(bytes.length == str.length()){
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(isEnglish2("robert! you smart, so happy to see you. oh 1 2 3,~(1 != 2 ) "));
        System.out.println(isEnglish2("我是黄种人！（）fafda*&&………………"));
        System.out.println(isEnglish2(null));
    }
}