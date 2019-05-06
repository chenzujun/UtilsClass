package com.common.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * @author chenjun
 * @date 2018/5/4
 */
public class RegexTest {
    /**
     * 白名单原则
     * @param str
     * @return
     * @throws PatternSyntaxException
     */
    public static String StringFilter(String str) throws PatternSyntaxException {
        String regEx ="[!@#$%&?~^*a-zA-Z0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            sb.append(m.group());
        }
        return sb.toString();
    }

    /**
     * 匹配元素
     * @return
     */
    public static String getMatcher() {
        String source = "<currentCPResCode>DISTRIBUTOR_13438311</currentCPResCode>";
        String result = "";
        Pattern pattern = Pattern.compile("<currentCPResCode>(.*)</currentCPResCode>");
        Matcher matcher = pattern.matcher(source);
        while (matcher.find()) {
            result = matcher.group(1);
        }
        return result;
    }

    public static void main(String[] args) {
//        String str = "*adCVs*34_a _09_b5*[/435^?……{}【】。，；’“‘”？";
//        System.out.println(str);
//        System.out.println(StringFilter(str));

        System.out.println(getMatcher());
    }
}
