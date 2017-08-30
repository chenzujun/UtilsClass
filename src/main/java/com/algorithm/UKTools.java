package com.algorithm;

import java.security.NoSuchAlgorithmException;

import org.jasypt.util.text.BasicTextEncryptor;

public class UKTools {
	
	public static final String SYSTEM_SECRITY_PASSWORD = "UCKeFu";
	
	/**
     * Java加密包--Jasypt 加密
     * 
     * @param str
     * @return
     * @throws NoSuchAlgorithmException 
     */
    public static String encryption(String str) throws NoSuchAlgorithmException{
    	BasicTextEncryptor  textEncryptor = new BasicTextEncryptor ();
    	textEncryptor.setPassword(SYSTEM_SECRITY_PASSWORD);
    	return textEncryptor.encrypt(str);
    }
    
    /**
     * Java加密包--Jasypt 解密
     * 
     * @param str
     * @return
     * @throws NoSuchAlgorithmException 
     */
    public static String decryption(String str) throws NoSuchAlgorithmException{
    	BasicTextEncryptor  textEncryptor = new BasicTextEncryptor ();
    	textEncryptor.setPassword(SYSTEM_SECRITY_PASSWORD);
    	return textEncryptor.decrypt(str);
    }
    
    public static void main(String[] args) throws Exception {
    	System.out.println(encryption("89a6f08635827a2a6ee78c0f68d8baa1"));
		System.out.println(decryption("MCrk117WJVxj0m5fm8K4rSvrguPNeQPh9jpO/fKlMEVOKWNwD0sPON5tU3x5Ahq6"));
	}
}
