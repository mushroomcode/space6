package com.DiffBean;

import java.io.Serializable;

public class HunterCarParam implements Serializable {

    private String CarType;

    private String CarBranch;

    private String CarName;

    public void setCarType(String carType) {
        CarType = carType;
    }

    public void setCarName(String carName) {
        CarName = carName;
    }

    public void setCarBranch(String carBranch) {
        CarBranch = carBranch;
    }

    public String getCarBranch() {
        return CarBranch;
    }

    public String getCarName() {
        return CarName;
    }

    public String getCarType() {
        return CarType;
    }
}
