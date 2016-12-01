package com.common.util;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;


public class Config {

	static Map<String, String> config = new HashMap<String, String>();
	
	static {
		Properties prop = new Properties();
		try {
			InputStream is = Config.class.getClassLoader().getResourceAsStream("config.properties");   
            prop.load(is);
            if (is != null) {
                is.close();
            }
            Set<?> keys = prop.keySet();
            if (keys != null && keys.size() > 0) {
            	for (Object key : keys) {
            		if (prop.get(key) != null) {
            			config.put((String)key, prop.get(key).toString());
            			System.out.println("load property : " + key + " - " + prop.get(key).toString());
            		}
            	}
            }
         } catch (Exception e) {
        	 e.printStackTrace();
         }
	}
	
	public static Set<String> getConfigKeys() {
		return config.keySet();
	}
	
	public static String getConfigValue(String key) {
		return config.get(key);
	}
	
	public static String getConfigValue(String key, String defaultValue) {
		String result = config.get(key);
		if(result == null){
			return defaultValue;
		}
		return result;
	}
	
	public static int getConfigIntValue(String key) {
		try {
			return Integer.parseInt(config.get(key));
		} catch (Exception e) {
			return -1;
		}
	}
	
	public static int getConfigIntValue(String key, int defaultValue) {
		try {
			return Integer.parseInt(config.get(key));
		} catch (Exception e) {
			return defaultValue;
		}
	}
}
