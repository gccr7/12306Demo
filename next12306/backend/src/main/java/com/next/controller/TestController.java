package com.next.controller;

import com.next.common.JsonData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @RequestMapping("/test1")
    @ResponseBody
    public JsonData test() {
        return  JsonData.success();
    }
}
