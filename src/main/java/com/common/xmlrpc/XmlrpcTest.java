package com.common.xmlrpc;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

public class XmlrpcTest {
	public static void main(String[] args) throws MalformedURLException {
		XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL("http://10.10.10.7:8099/RPC2"));
        XmlRpcClient client = new XmlRpcClient();
        client.setConfig(config);
        // 根据不同的python函数形式，构造参数
        // 两个整形参数
        //Object[] params = new Object[] {new Integer(1), new Integer(2)};
        
        // 单个字符串参数
        Object[] params = new Object[1];
        String str = "";
        for (int i = 0; i < 1000; i++) {
        	str += "\"female\":[{\"A01\",\"B02\"},{\"A02\",\"B03\"},{\"A03\",\"B01\"},{\"A04\",\"B05\"}],\"male\":[{\"B01\",\"A02\"},{\"B02\",\"A03\"},{\"B03\",\"A01\"},{\"B04\",\"A05\"}]";
		}
        
        params[0]=str;
        
//        {{"num":"A01","type":1},{"num":"A02","type":3},{"num":"A04","type":2}}
//
//        {"female":[{"A01","B02"},{"A02","B03"},{"A03","B01"},{"A04","B05"}],"male":[{"B01","A02"},{"B02","A03"},{"B03","A01"},{"B04","A05"}]}


        System.out.println(str.length());
        // 无参数
//        Object[] params = null;
        try {
            // 返回的结果是字符串类型，强制转换res为String类型
            String res = (String) client.execute("get_hello", params);
            System.out.println(res);
        } catch (XmlRpcException e11) {
            e11.printStackTrace();
        }
	}
}
