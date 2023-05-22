package com.next.controller;

import com.next.common.JsonData;
import com.next.param.GenerateTicketParam;
import com.next.service.TrainSeatService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
@RequestMapping("/admin/train/seat")
public class TrainSeatController {

    @Resource
    private TrainSeatService trainSeatService;

    @RequestMapping("list.page")
    public ModelAndView page() {
        return new ModelAndView("trainSeat");
    }

    @RequestMapping("/search.json")
    @ResponseBody
    public JsonData search() {

        return JsonData.success();
    }

    @RequestMapping("/generate.json")
    @ResponseBody
    public JsonData generate(GenerateTicketParam param) {
        trainSeatService.generate(param);
        return JsonData.success();
    }
}
