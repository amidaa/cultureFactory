package com.first.group.logback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BlogAction {
    //定义一个全局的记录器，通过LoggerFactory获取
    private final static Logger logger = LoggerFactory.getLogger(BlogAction.class);
    /**
     * @param args
     */
    public static void main(String[] args) {
        logger.info("logback 成功了");
        logger.error("logback 成功了");
        logger.error("logback error了");
        logger.debug("logback 成功了");
    }
}
