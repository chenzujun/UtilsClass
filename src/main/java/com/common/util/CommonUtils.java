package com.common.util;

import org.apache.commons.beanutils.PropertyUtilsBean;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

public class CommonUtils {

	/**
	 * 是否能访问指定URL
	 *
	 * @param urlStr
	 * @return
	 */
	public static boolean access(String urlStr) {
		boolean result = false;
		if (org.apache.commons.lang.StringUtils.isBlank(urlStr))
			return result;
		if(!StringUtils.startsWith(urlStr.toLowerCase(), "http://")){
			urlStr = "http://" + urlStr;
		}
		try {
			URL url = new URL(urlStr);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			int reponseCode = connection.getResponseCode();
			if (reponseCode == HttpURLConnection.HTTP_OK ||
					reponseCode == HttpURLConnection.HTTP_MOVED_TEMP) {
				result = true;
			}
		} catch (Exception e) {
			return false;
		}
		return result;
	}

	/**
	 * 将数组objects组成以分隔符separator 相隔的字符串
	 * @param objects
	 * @param separator
	 * @return
	 */
	public static String join(Object[] objects,String separator){
		if(objects == null || objects.length < 1){
			return null;
		}
		if(separator == null){
			return null;
		}
		StringBuffer sb = new StringBuffer();
		for(int i = 0;i<objects.length;i++){
			sb.append(objects[i]);
			if(i < (objects.length -1)){
				sb.append(separator);
			}
		}
		return sb.toString();
	}

	/**
	 * 把JavaBean转换成map
	 * @param bean
	 * @return
	 * @throws IntrospectionException
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	public static Map<String, Object> convertBean(Object bean) throws IntrospectionException,
			IllegalAccessException, InvocationTargetException, NoSuchMethodException{
		Class<? extends Object> type = bean.getClass();
		Map<String, Object> returnMap = new HashMap<String, Object>();
		BeanInfo beanInfo = Introspector.getBeanInfo(type);

		PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
		PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean();
		for (int i = 0; i < propertyDescriptors.length; i++) {
			PropertyDescriptor descriptor = propertyDescriptors[i];
			String propertyName = descriptor.getName();
			if (!propertyName.equals("class")) {
				returnMap.put(propertyName, propertyUtilsBean.getNestedProperty(bean, propertyName));
			}
		}
		return returnMap;
	}

	/**
	 * 获取客户端IP(穿透CDN与代理)
	 *
	 * @param request
	 * @return
	 */
	public static String getRealRemoteIp(HttpServletRequest request) {
		String ipAddress = request.getHeader("Cdn-Src-Ip");
		request.setAttribute("Cdn_Src_Ip", ipAddress == null ? "null" : ipAddress);
		if(StringUtils.isBlank(ipAddress) ||  "unknown".equalsIgnoreCase(ipAddress)){
			ipAddress = request.getHeader("x-forwarded-for");
			request.setAttribute("x_forwarded_for", ipAddress == null ? "null" : ipAddress);
		}
		if (ipAddress == null || ipAddress.length() == 0
				|| "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("Proxy-Client-IP");
		}
		if (ipAddress == null || ipAddress.length() == 0
				|| "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ipAddress == null || ipAddress.length() == 0
				|| "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getRemoteAddr();
			if (ipAddress.equals("127.0.0.1")
					|| ipAddress.equals("0:0:0:0:0:0:0:1")) {
				// 根据网卡取本机配置的IP
				InetAddress inet = null;
				try {
					inet = InetAddress.getLocalHost();
				} catch (UnknownHostException e) {
					e.printStackTrace();
				}
				ipAddress = inet.getHostAddress();
			}
		}
		if (StringUtils.isBlank(ipAddress) || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getRemoteAddr();
			request.setAttribute("RemoteAddr", ipAddress == null ? "null" : ipAddress);
		}
		// 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
		// "***.***.***.***".length()
		if (ipAddress != null && ipAddress.length() > 15) {
			if (ipAddress.indexOf(",") > 0) {
				ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
			}
		}
		return ipAddress;
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println(access("www.baidu.com"));
	}
}