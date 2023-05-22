package com.next.service;
import com.next.dao.TrainNumberMapper;
import com.next.model.TrainNumber;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TrainNumberService {
    @Resource
    private TrainNumberMapper trainNumberMapper;

    public List<TrainNumber> getAll() {
        List<TrainNumber> trainNumbers = trainNumberMapper.getAll();

        return trainNumbers;

    }
}
