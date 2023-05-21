package com.next.service;

import com.next.dao.TrainCityMapper;
import com.next.dao.TrainStationMapper;
import com.next.exception.BusinessException;
import com.next.model.TrainCity;
import com.next.model.TrainStation;
import com.next.param.TrainStationParam;
import com.next.util.BeanValidator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TrainStationService {
    @Resource
    private TrainStationMapper trainStationMapper;
    @Resource
    private TrainCityMapper trainCityMapper;


    public List<TrainStation> getAll() {
        List<TrainStation> trainStations = trainStationMapper.getAll();

        return trainStations;
    }

    public void save(TrainStationParam param) {
        BeanValidator.check(param);

        TrainCity trainCity = trainCityMapper.selectByPrimaryKey(param.getCityId());

        if (trainCity == null) {
            throw new BusinessException("站点所属城市不存在");
        }
        if (checkExist(param.getName(),param.getId(), param.getCityId())) {

            throw new BusinessException("该城市下存在相同名称站点");
        }
        TrainStation build = TrainStation.builder().name(param.getName()).cityId(param.getCityId()).build();

        trainStationMapper.insertSelective(build);


    }

    public void update(TrainStationParam param) {
        BeanValidator.check(param);

        TrainCity trainCity = trainCityMapper.selectByPrimaryKey(param.getCityId());

        if (trainCity == null) {
            throw new BusinessException("站点所属城市不存在");
        }
        if (checkExist(param.getName(),param.getId(), param.getCityId())) {

            throw new BusinessException("该城市下存在相同名称站点");
        }
        TrainStation trainStation = trainStationMapper.selectByPrimaryKey(param.getId());

        if (trainStation == null) {

            throw new BusinessException("待更新站点不存在");
        }
        TrainStation build = TrainStation.builder().id(param.getId()).name(param.getName()).cityId(param.getCityId()).build();

        trainStationMapper.updateByPrimaryKeySelective(build);

    }


    private boolean checkExist(String name,Integer stationId, Integer cityId) {


        return trainStationMapper.countByAndNameAndCityId(name, stationId, cityId)>0;
    }


}
