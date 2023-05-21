package com.next.service;

import com.next.dao.TrainNumberDetailMapper;
import com.next.dao.TrainNumberMapper;
import com.next.dao.TrainStationMapper;
import com.next.model.TrainNumberDetail;
import com.next.model.TrainStation;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TrainNumberDetailService {
    @Resource
    private TrainNumberDetailMapper trainNumberDetailMapper;

    public List<TrainNumberDetail> getAll() {
        return trainNumberDetailMapper.getAll();
    }
}
