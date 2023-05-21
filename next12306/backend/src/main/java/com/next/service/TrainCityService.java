package com.next.service;

import com.next.dao.TrainCityMapper;
import com.next.model.TrainCity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TrainCityService {
    @Resource
    private TrainCityMapper trainCityMapper;

    public List<TrainCity> getAll() {
        return trainCityMapper.getAll();
    }
}
