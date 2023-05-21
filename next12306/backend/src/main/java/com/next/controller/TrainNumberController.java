package com.next.controller;

import com.next.common.JsonData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/train/number")
public class TrainNumberController {
    @RequestMapping("/list.page")
    public ModelAndView page() {
        return new ModelAndView("trainNumber");
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

    public JsonData update() {
        return JsonData.success();
    }
}
