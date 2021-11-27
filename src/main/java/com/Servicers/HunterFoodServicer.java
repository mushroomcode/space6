package com.Servicers;

import com.Events.HunterFoodEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class HunterFoodServicer implements ApplicationEventPublisherAware {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private ApplicationEventPublisher applicationEventPublisher;

    // 发布publisher 事件
    public void addFood(String foodName, String energy) {
        HunterFoodEvent hunterFoodEvent = new HunterFoodEvent(this, foodName, energy);
//        logger.info(" 获取食物 :" + hunterFoodEvent.getFoodName());
        applicationEventPublisher.publishEvent(hunterFoodEvent);
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @EventListener
    public void addCoupon(HunterFoodEvent event) {
        logger.info(" ====获取食物==== " + event.getFoodName());
    }

}
