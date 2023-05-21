package com.next.controller;

import com.next.common.JsonData;
import com.next.dto.TrainStationDto;
import com.next.model.TrainCity;
import com.next.model.TrainStation;
import com.next.service.TrainCityService;
import com.next.service.TrainStationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin/train/station")
public class TrainStationController {
    @Resource
    private TrainCityService trainCityService;
    @Resource
    private TrainStationService trainStationService;
    @RequestMapping("/list.page")
    public ModelAndView page() {
        return new ModelAndView("trainStation");
    }

    @RequestMapping("/list.json")
    @ResponseBody
    public JsonData list() {
        List<TrainStation> trainStationList = trainStationService.getAll();
        List<TrainCity> trainCityList = trainCityService.getAll();

        Map<Integer, String> map = trainCityList.stream().collect(Collectors.toMap(TrainCity::getId, TrainCity::getName));

        List<TrainStationDto> StationDtoList = trainStationList.stream().map(trainStation -> {
            TrainStationDto trainStationDto = new TrainStationDto();
            trainStationDto.setId(trainStation.getId());
            trainStationDto.setCityId(trainStation.getCityId());
            trainStationDto.setCityName(map.get(trainStation.getCityId()));
            trainStationDto.setName(trainStation.getName());
            return trainStationDto;

        }).collect(Collectors.toList());

        return JsonData.success(StationDtoList);
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
