package com.esc.khweb.controller.request;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@NoArgsConstructor
public class MyChargingStateRequest {


    private  String statNm;
    private  String chgerType;
    private  String addr;
    private  String lat;
    private  String lng;
    private  String useTime;
    private  String busiCall;

}
