package com.esc.khweb.controller.request;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@NoArgsConstructor
public class MyParkingStateRequest {


    private  String paymethod;
    private  String holiStart1;
    private  String holiEnd;
    private  String lat;
    private  String lng;
    private  String adminiNm;
    private  String addr1;
    private  String addr2;
    private  String operatingday;
    private  String monthPay;
    private  String call1;
    private  String parkingNum;
    private  String basicsTime;
    private  String kind1;
    private  String addtimeUnit;
    private  String parkingNm;
    private  String ParkingType;
    private  String basicsPay;
    private  String addpayUnit;
    private  String satStart;
    private  String satEnd;
    private  String weekStart;
    private  String weekEnd;

}
