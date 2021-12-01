package com.esc.khweb.controller.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@NoArgsConstructor
public class MyCarStateRequest {

    private  String brand;
    private  String carType;
    private  String personnel;
    private  String speed;
    private  String charge;
    private  String battery;
    private  String subsidy;

}
