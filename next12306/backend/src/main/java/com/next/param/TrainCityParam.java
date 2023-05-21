package com.next.param;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
@Getter
@Setter
@ToString
public class TrainCityParam {
    private Integer id;

    @NotBlank(message = "城市名称不为空")
    @Length(min = 2,max = 20,message = "城市名称长度不小于2或者不大于20个字")
    private String name;

}
