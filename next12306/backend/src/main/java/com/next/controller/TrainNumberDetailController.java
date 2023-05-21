package com.next.controller;

import com.next.common.JsonData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

public class TrainNumberDetailController {
    @RequestMapping("/list.page")
    public ModelAndView page() {
        return new ModelAndView("trainNumberDetail");
    }

    @RequestMapping("/list.json")
    @ResponseBody
    public JsonData list() {
        return JsonData.success();
    }

    @RequestMapping("/save.json")
    @ResponseBody
    public JsonData save() {
        return JsonData.success();
    }

    @RequestMapping("/update.json")
    @ResponseBody

    public JsonData delete() {
        return JsonData.success();
    }
}
