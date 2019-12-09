package com.common.xmlrpc;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

/**
 * XML-RPC（XML-based Remote Procedure Call，基于 XML 的远程过程调用）是一种工作在互联网上的远程过程调用协议
 */
public class XmlrpcTest {

    /**
     *
     * @param args
     * @throws MalformedURLException
     */
	public static void main(String[] args) throws MalformedURLException {
		XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL("http://10.10.10.7:8099/RPC2"));
        XmlRpcClient client = new XmlRpcClient();
        client.setConfig(config);
        // 根据不同的python函数形式，构造参数
        Object[] params = new Object[1];
        String str = "{\"female\":[{\"A01\",\"B02\"},{\"A02\",\"B03\"},{\"A03\",\"B01\"},{\"A04\",\"B05\"}],\"male\":[{\"B01\",\"A02\"},{\"B02\",\"A03\"},{\"B03\",\"A01\"},{\"B04\",\"A05\"}]}";
        params[0]=str;
        try {
            // 返回的结果是字符串类型，强制转换res为String类型
            String res = (String) client.execute("get_hello", params);
            System.out.println(res);
        } catch (XmlRpcException e11) {
            e11.printStackTrace();
        }
	}
}
