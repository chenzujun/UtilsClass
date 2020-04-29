package com.common.log;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * https://logging.apache.org/log4j/2.x/index.html
 */
public class Log4j2Test {
    private static Logger logger = LogManager.getLogger(Log4j2Test.class.getName());
    
    public static void main(String[] args){
        logger.error("Hello Log4j 2");

        logger.trace("trace level");
        logger.debug("debug level");
        logger.info("info level");
        logger.warn("warn level");
        logger.error("error level");
    }
}
