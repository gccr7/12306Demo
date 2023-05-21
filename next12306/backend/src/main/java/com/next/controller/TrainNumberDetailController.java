package com.next.controller;

import com.next.common.JsonData;
import com.next.dto.TrainNumberDetailDto;
import com.next.model.TrainNumber;
import com.next.model.TrainNumberDetail;
import com.next.model.TrainStation;
import com.next.param.TrainNumberDetailParam;
import com.next.service.TrainNumberDetailService;
import com.next.service.TrainNumberService;
import com.next.service.TrainStationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequestMapping("/admin/train/numberDetail")
@Controller
public class TrainNumberDetailController {

    @Resource
    private TrainNumberDetailService trainNumberDetailService;
    @Resource
    private TrainStationService trainStationService;
    @Resource
    private TrainNumberService trainNumberService;

    @RequestMapping("/list.page")
    public ModelAndView page() {
        return new ModelAndView("trainNumberDetail");
    }

    @RequestMapping("/list.json")
    @ResponseBody
    public JsonData list() {
        List<TrainNumberDetail> numberDetails = trainNumberDetailService.getAll();

        List<TrainStation> trainStations = trainStationService.getAll();
        Map<Integer, String> map = trainStations.stream().collect(Collectors.toMap(TrainStation::getId, TrainStation::getName));

        List<TrainNumber> numbers = trainNumberService.getAll();
        Map<Integer, String> numberMap = numbers.stream().collect(Collectors.toMap(TrainNumber::getId, TrainNumber::getName));

        List<TrainNumberDetailDto> detailDtos = numberDetails.stream().map(details -> {
            TrainNumberDetailDto detailDto = new TrainNumberDetailDto();
            detailDto.setId(details.getId());
            detailDto.setFromStationId(details.getFromStationId());
            detailDto.setToStationId(details.getToStationId());
            detailDto.setFromStation(map.get(details.getFromStationId()));
            detailDto.setToStation(map.get(details.getToStationId()));
            detailDto.setFromCityId(details.getToCityId());
            detailDto.setToCityId(details.getToCityId());
            detailDto.setTrainNumberId(details.getTrainNumberId());
            detailDto.setTrainNumber(numberMap.get(details.getTrainNumberId()));
            detailDto.setStationIndex(details.getStationIndex());
            detailDto.setRelativeMinute(details.getRelativeMinute());
            detailDto.setWaitMinute(details.getWaitMinute());
            detailDto.setMoney(details.getMoney());


            return detailDto;

        }).collect(Collectors.toList());


        return JsonData.success(detailDtos);
    }

    @RequestMapping("/save.json")
    @ResponseBody
    public JsonData save(TrainNumberDetailParam param) {
        trainNumberDetailService.save(param);
        return JsonData.success();
    }

    @RequestMapping("/delete.json")
    @ResponseBody
    public JsonData delete(@RequestParam("id") Integer id) {
        trainNumberDetailService.delete(id);
        return JsonData.success();
    }
}
