package com.HunterListeners;

import com.Events.HunterFoodEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;

// 测试 Event 的 Listener
public class SecondHandListener implements ApplicationListener<HunterFoodEvent> {

    private Logger logger = LoggerFactory.getLogger(SecondHandListener.class);

    @Override
    public void onApplicationEvent(HunterFoodEvent hunterFoodEvent) {
        logger.info("foodName:" + hunterFoodEvent.getFoodName() + " energy:" + hunterFoodEvent.getEnergy());
    }
}
