package com.transactions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

@EnableAsync
@Component
public class HunterTrans {

    private Logger logger = LoggerFactory.getLogger(HunterTrans.class);

    public void transaction() {
        asyncTask("async fail");
    }

    @Async
    public void asyncTask(String keyword) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            logger.error("wrong");
            //logger
            //error tracking
        }
        logger.info(keyword);
    }

}
