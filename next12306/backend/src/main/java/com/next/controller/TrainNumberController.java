package com.next.controller;

import com.next.common.JsonData;
import com.next.dto.TrainNumberDto;
import com.next.model.TrainNumber;
import com.next.model.TrainStation;
import com.next.param.TrainNumberParam;
import com.next.service.TrainNumberService;
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
@RequestMapping("/admin/train/number")
public class TrainNumberController {

    @Resource
    private TrainNumberService trainNumberService;
    @Resource
    private TrainStationService trainStationService;

    @RequestMapping("/list.page")
    public ModelAndView page() {
        return new ModelAndView("trainNumber");
    }

    @RequestMapping("/list.json")
    @ResponseBody
    public JsonData list() {
        List<TrainNumber> trainNumbers = trainNumberService.getAll();
        List<TrainStation> trainStations = trainStationService.getAll();
        Map<Integer, String> map = trainStations.stream().collect(Collectors.toMap(TrainStation::getId, TrainStation::getName));
        List<TrainNumberDto> dtoList = trainNumbers.stream().map(trainNumber ->

        {
            TrainNumberDto trainNumberDto = new TrainNumberDto();
            trainNumberDto.setId(trainNumber.getId());
            trainNumberDto.setFromStationId(trainNumber.getFromStationId());
            trainNumberDto.setToStationId(trainNumber.getToStationId());
            trainNumberDto.setFromStation(map.get(trainNumber.getFromStationId()));
            trainNumberDto.setToStation(map.get(trainNumber.getToStationId()));
            trainNumberDto.setFromCityId(trainNumber.getToCityId());
            trainNumberDto.setToCityId(trainNumber.getToCityId());
            trainNumberDto.setName(trainNumber.getName());
            trainNumberDto.setTrainType(trainNumber.getTrainType());
            trainNumberDto.setType(trainNumber.getType());
            trainNumberDto.setSeatNum(trainNumber.getSeatNum());
            return trainNumberDto;
        }).collect(Collectors.toList());

        return JsonData.success(dtoList);
    }

    @RequestMapping("/save.json")
    @ResponseBody
    public JsonData save(TrainNumberParam param) {
        trainNumberService.save(param);


        return JsonData.success();
    }

    @RequestMapping("/update.json")
    @ResponseBody

    public JsonData update(TrainNumberParam param) {
        trainNumberService.update(param);

        return JsonData.success();
    }
}
