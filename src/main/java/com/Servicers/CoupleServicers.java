package com.Servicers;

import com.Events.HunterFoodEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class CoupleServicers  {

    private Logger logger = LoggerFactory.getLogger(CoupleServicers.class);

    @EventListener
    public void addCoupon(HunterFoodEvent event) {
        logger.info(" ====获取食物==== " + event.getFoodName());
    }

}
