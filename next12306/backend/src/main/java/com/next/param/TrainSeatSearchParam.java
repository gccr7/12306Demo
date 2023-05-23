package com.next.param;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
public class TrainSeatSearchParam {

    private String trainNumber;

    private String ticket;

    private Integer status;

    private Integer carriageNum;

    private  Integer rowNum;

    private Integer seatNum;
}
