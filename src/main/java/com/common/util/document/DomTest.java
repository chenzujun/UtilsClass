package com.common.util.document;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomTest {
	
	public static void main(String[] args) {
//		1.创建解析工厂：
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
//		2.指定DocumentBuilder
		DocumentBuilder db;
//		3.从文件构造一个Document,因为XML文件中已经指定了编码，所以这里不必了
		Document xmlDoc;
		try {
			db = factory.newDocumentBuilder();
			xmlDoc = db.parse(new File("D:\\coreconfig.xml"));
			
//			得到Document的根
			Element root = xmlDoc.getDocumentElement();
//			"CrmWebBase", "crmWebBaseURL"
			Element node = null;
			NodeList servletList = root.getElementsByTagName("config");
			for (int i = 0; i < servletList.getLength(); i++) {
				Element nodetmp = (Element)servletList.item(i);
				String id = nodetmp.getAttribute("id");
				if (id.equals("CrmInterface")){
					node = nodetmp;
					break;
				}
			}
			
			
			NodeList paraList = node.getElementsByTagName("parameter");
			for (int j = 0; j < paraList.getLength(); j++) {
				Element para = (Element)paraList.item(j);
				String name = para.getAttribute("name");
				String value = para.getAttribute("value");
				System.out.println(name+"="+value);
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
