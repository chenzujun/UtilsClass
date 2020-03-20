
package com.tool.domain;


import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * XmlDateAdapter 适配器的使用
 *
 * @author kaka
 * @date 2017-09-26
 * @since v1.1.0
 */
public class XmlDateAdapter extends XmlAdapter<String, Date> {

    public static final String STANDARD = "yyyy-MM-dd HH:mm:ss";

    /**
     * 日期格式转换
     */
    private static final ThreadLocal<SimpleDateFormat> SIMPLE_DATE_FORMAT_THREAD_LOCAL = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat(STANDARD);
        }
    };

    @Override
    public Date unmarshal(String v) throws Exception {
        return SIMPLE_DATE_FORMAT_THREAD_LOCAL.get().parse(v);
    }

    @Override
    public String marshal(Date v) throws Exception {
        return SIMPLE_DATE_FORMAT_THREAD_LOCAL.get().format(v);
    }
}
