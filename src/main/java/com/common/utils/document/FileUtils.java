package com.common.utils.document;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class FileUtils {

	public static void readPropFile(String path) {
		InputStream is = FileUtils.class.getClassLoader().getResourceAsStream(path);
		Properties p = new Properties();
		
		try {
			p.load(is);
			
			System.out.println(p.getProperty("test"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		readPropFile("test.properties");
	}
}
