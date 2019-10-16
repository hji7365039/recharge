package com.xds.recharge.common;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by jinyi on 2017/6/21.
 */
public class SysLog {
    public static final Logger logger =  LoggerFactory.getLogger(SysLog.class);
    public static void error(Exception e){
        logger.error(e.getMessage(),e);
    }
    public static void info(Object message){
        logger.info("info:{}",message);
    }
    public static void debug(Object message){
        logger.debug("debug:{}",message);
    }
}
