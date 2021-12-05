package com.DiffBean;

import com.Annatations.HunterValueAnno;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class HunterCarParam implements Serializable {

    @HunterValueAnno(param = "honda")
    private String CarType;

    private String CarBranch;

    private String CarName;

    public String getCarType() {
        return CarType;
    }

    //    public void setCarType(String carType) {
//        CarType = carType;
//    }
//
//    public void setCarName(String carName) {
//        CarName = carName;
//    }
//
//    public void setCarBranch(String carBranch) {
//        CarBranch = carBranch;
//    }
//
//    public String getCarBranch() {
//        return CarBranch;
//    }
//
//    public String getCarName() {
//        return CarName;
//    }
//
//    public String getCarType() {
//        return CarType;
//    }
}
