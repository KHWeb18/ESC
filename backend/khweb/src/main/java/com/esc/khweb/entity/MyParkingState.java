package com.esc.khweb.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@ToString
public class MyParkingState {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "row_no")
    private Long rowNo;

    @Column(name = "member_no")
    private Long memberNo;

    @Column(length = 32)
    private String paymethod;

    @Column(length = 32)
    private String lng;

    @Column(length = 32)
    private String holiStart1;

    @Column(length = 32)
    private String holiEnd;

    @Column(length = 32)
    private String adminiNm;

    @Column(length = 32)
    private String addr1;

    @Column(length = 32)
    private String addr2;

    @Column(length = 32)
    private String operatingday;

    @Column(length = 32)
    private String monthPay;

    @Column(length = 32)
    private String lat;

    @Column(length = 64)
    private String call1;

    @Column(length = 32)
    private String parkingNum;

    @Column(length = 32)
    private String basicsTime;

    @Column(length = 32)
    private String basicsPay;

    @Column(length = 32)
    private String kind1;

    @Column(length = 32)
    private String parkingNm;

    @Column(length = 32)
    private String ParkingType;

    @Column(length = 32)
    private String addtimeUnit;

    @Column(length = 32)
    private String addpayUnit;

    @Column(length = 32)
    private String satStart;

    @Column(length = 32)
    private String satEnd;


    @Column(length = 32)
    private String weekStart;

    @Column(length = 32)
    private String weekEnd;

//    public MyParkingState (Long memberNo, String paymethod, String lng, String holiStart1, String holiEnd, String adminiNm, String addr1, String addr2,
//                          String operatingday, String monthPay, String lat, String call1, String parkingNum, String basicsTime, String basicsPay, String kind1,
//                          String parkingNm, String ParkingType, String addtimeUnit, String addpayUnit, String satStart, String satEnd, String weekStart, String weekEnd) {
//
//        this.memberNo = memberNo;
//        this.paymethod = paymethod;
//        this.holiStart1 = holiStart1;
//        this.holiEnd = holiEnd;
//        this.lat = lat;
//        this.lng = lng;
//        this.adminiNm = adminiNm;
//        this.addr1 = addr1;
//        this.addr2 = addr2;
//        this.operatingday = operatingday;
//        this.monthPay = monthPay;
//        this.call1 = call1;
//        this.parkingNum = parkingNum;
//        this.basicsTime = basicsTime;
//        this.basicsPay = basicsPay;
//        this.kind1 = kind1;
//        this.parkingNm = parkingNm;
//        this.ParkingType = ParkingType;
//        this.addtimeUnit = addtimeUnit;
//        this.addpayUnit = addpayUnit;
//        this.satStart = satStart;
//        this.satEnd = satEnd;
//        this.weekStart = weekStart;
//        this.weekEnd = weekEnd;
//
//    }

}