package com.Events;

import org.springframework.context.ApplicationEvent;

/**
 *  普通 Event 事件， 测试用
 */
public class HunterFoodEvent extends ApplicationEvent {

    // 猎人食物类型
    private String foodName;
    // 食物能量
    private String energy;

    public void setEnergy(String energy) {
        this.energy = energy;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getEnergy() {
        return energy;
    }

    public String getFoodName() {
        return foodName;
    }

    public HunterFoodEvent(Object source, String foodName, String energy) {
        super(source);
        this.foodName = foodName;
        this.energy = energy;
    }
}
