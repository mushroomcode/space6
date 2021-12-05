package com.Controller;

import com.DiffBean.HunterCarParam;
import com.Servicers.HunterFoodServicer;
import com.transactions.HunterTrans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

@Controller
@RequestMapping("/index")
public class HunterController {

    @Autowired
    private HunterTrans hunterTrans;

    @Autowired
    private HunterFoodServicer servicer;

    @Autowired
    private ApplicationContext context;

    @Autowired
    private HunterCarParam param;

    //
    @RequestMapping("/hello")
    @ResponseBody
    public String Hello() {
        long start = System.currentTimeMillis();
        hunterTrans.transaction();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        return "sleep";
    }

    @RequestMapping("/hello2")
    @ResponseBody
    public String Hello2(HttpServletRequest servletRequest) {
        Enumeration<String> headerNames = servletRequest.getHeaderNames();
        long start = System.currentTimeMillis();
        hunterTrans.asyncTask("async success");
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        return "sleep";
    }

    @RequestMapping("/hunterCarsList")
    @ResponseBody
    public List<HunterCarParam> HunterTreeNode() {
        List<HunterCarParam> retList = new ArrayList<>();
        HunterCarParam hunterCarParam = new HunterCarParam();
//        hunterCarParam.setCarBranch("Honda");
//        hunterCarParam.setCarName("civic 11th");
//        hunterCarParam.setCarType("Sedan");
        retList.add(hunterCarParam);
        return retList;
    }

    @GetMapping(value = "/hunterFood")
    @ResponseBody
    public String hunterFood(HttpServletRequest request, HttpServletResponse response, @RequestParam("foodName") String foodName,
                             @RequestParam("energy") String energy) {
        servicer.addFood(foodName, energy);
        return "获取:" + foodName;
    }

    @GetMapping(value = "/hunterCar")
    @ResponseBody
    public String hunterCars(HttpServletRequest request, HttpServletResponse response) {
//        servicer.addFood(foodName, energy);
//        return "获取:" + foodName;
//        AnnotationConfigApplicationContext configApplicationContext;

//        HunterCarParam hunterCarParam = context.getBean(HunterCarParam.class);
        return param.getCarType();
    }

}
