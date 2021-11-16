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
    private  Long rowNo;

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



}
