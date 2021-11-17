package com.esc.khweb.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@ToString
public class MyChargingState {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "row_no")
    private  Long rowNo;
    @Column(name = "member_no")
    private Long memberNo;
    @Column(length = 32 ,nullable = false)
    private String statNm;
    @Column(length = 32 ,nullable = false)
    private String chgerType;
    @Column(length = 32 ,nullable = false)
    private String addr;
    @Column(length = 32 ,nullable = false)
    private String lat;
    @Column(length = 32 ,nullable = false)
    private String lng;
    @Column(length = 32 ,nullable = false)
    private String useTime;
    @Column(length = 32 ,nullable = false)
    private String busiCall;

    public MyChargingState (Long memberNo, String statNm, String chgerType ,String addr, String lat, String lng, String useTime, String busiCall) {
        this.memberNo = memberNo;
        this.statNm = statNm;
        this.chgerType = chgerType;
        this.addr = addr;
        this.lat = lat;
        this.lng = lng;
        this.useTime = useTime;
        this.busiCall= busiCall;


    }

}
