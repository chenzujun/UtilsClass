package com.log;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class CommonLoggingTest
{
    
    public static void main(String[] args)
    {
        Log logger = LogFactory.getLog(CommonLoggingTest.class); 
        logger.info("test");
        
    }
    
}
