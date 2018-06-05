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

    public static void main(String[] args) {
        String str = "*adCVs*34_a _09_b5*[/435^?……{}【】。，；’“‘”？";
        System.out.println(str);
        System.out.println(StringFilter(str));
    }
}
