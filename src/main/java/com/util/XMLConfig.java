package com.util;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class XMLConfig { 
	private Document configDocument = null;
	
	public XMLConfig(String conf_file) throws SAXParseException, IOException, ParserConfigurationException, SAXException {
		configDocument = getConfigDocument(conf_file);
	}

	private Document getConfigDocument(String fileName)
			throws SAXParseException, IOException,
			ParserConfigurationException, SAXException {
		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory
				.newInstance();
		DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
		InputStream in = this.getClass().getResourceAsStream(fileName);
		configDocument = docBuilder.parse(in);
		in.close();
		return configDocument;
	}

	public String getParameter(String groupId, String paraName)
			throws SAXParseException, IOException,
			ParserConfigurationException, SAXException {
		Element node = getElementFromConfigId(groupId);
		NodeList paraList = node.getElementsByTagName("parameter");
		for (int j = 0; j < paraList.getLength(); j++) {
			Element para = (Element) paraList.item(j);
			String name = para.getAttribute("name");
			String value = para.getAttribute("value");
			if (name.endsWith(paraName))
				return value;
		}
		return null;
	}

	private Element getElementFromConfigId(String groupId)
			throws SAXParseException, IOException,
			ParserConfigurationException, SAXException {
		Element rootElement = configDocument.getDocumentElement();
		NodeList servletList = rootElement.getElementsByTagName("config");
		for (int i = 0; i < servletList.getLength(); i++) {
			Element node = (Element) servletList.item(i);
			String id = node.getAttribute("id");
			if (id.equals(groupId))
				return node;
		}
		return null;
	}

	public static void main(String args[]) {

	}
}