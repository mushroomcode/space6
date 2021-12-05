package com.HunterListeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 *  Request 监听者初始化，监听Request的创建和销毁
 */
@WebListener
// web Listener 定义一个Listener 监听者,初始化的时候
public class FoodListener implements ServletRequestListener {

    private static Logger logger = LoggerFactory.getLogger(FoodListener.class);

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        System.out.println("============= 监听者被摧毁 ===============");
//        logger.info("============= 监听者被摧毁 ===============");
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        System.out.println("============= 监听者 初始化 ===============");
//        logger.info("============= 监听者 初始化 ===============");
    }
}
