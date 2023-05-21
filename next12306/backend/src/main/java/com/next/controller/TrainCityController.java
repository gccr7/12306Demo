package com.next.controller;

import com.next.common.JsonData;
import com.next.service.TrainCityService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
@RequestMapping("/admin/train/city")
public class TrainCityController {
    @Resource
    private TrainCityService trainCityService;
    @RequestMapping("/list.page")
    public ModelAndView page() {
        return new ModelAndView("trainCity");
    }

    @RequestMapping("/list.json")
    @ResponseBody
    public JsonData list() {
        return JsonData.success(trainCityService.getAll());
    }

    @RequestMapping("/save.json")
    @ResponseBody
    public JsonData save() {
        return JsonData.success();
    }

    @RequestMapping("/update.json")
    @ResponseBody

    public JsonData update() {
        return JsonData.success();
    }

}
