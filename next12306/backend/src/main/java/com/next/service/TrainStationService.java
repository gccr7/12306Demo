package com.next.service;

import com.next.dao.TrainStationMapper;
import com.next.model.TrainStation;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TrainStationService {
    @Resource
    private TrainStationMapper trainStationMapper;

    public List<TrainStation> getAll() {
        List<TrainStation> trainStations = trainStationMapper.getAll();

        return trainStations;
    }
}
