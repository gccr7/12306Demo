package com.next.controller;
import com.next.controller.TrainCityController;
import com.next.common.JsonData;
import com.next.param.TrainCityParam;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)   // junit4
@ExtendWith(SpringExtension.class)
public class TrainCityTest {
    @Autowired
    private TrainCityController trainCityController;

    @Test
    public void TrainCitySave() {
        TrainCityParam trainCityParam = TrainCityParam.builder().id(11).name("上海").build();

        JsonData save = trainCityController.save(trainCityParam);

    }
}
