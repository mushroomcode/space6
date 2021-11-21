package com.Controller;

import com.transactions.HunterTrans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/index")
public class HunterController {

    @Autowired
    private HunterTrans hunterTrans;

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
    public String Hello2() {
        long start = System.currentTimeMillis();
        hunterTrans.asyncTask("async success");
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        return "sleep";
    }

}
