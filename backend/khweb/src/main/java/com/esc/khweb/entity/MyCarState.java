package com.esc.khweb.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@ToString
public class MyCarState {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "row_no")
    private  Long rowNo;
    @Column(name = "member_no")
    private Long memberNo;
    @Column(length = 32 ,nullable = false)
    private String brand;
    @Column(length = 32 ,nullable = false)
    private String carType;
    @Column(length = 32 ,nullable = false)
    private String personnel;
    @Column(length = 32 ,nullable = true)
    private String speed;
    @Column(length = 32 ,nullable = true)
    private String charge;
    @Column(length = 32 ,nullable = false)
    private String battery;
    @Column(length = 32 ,nullable = false)
    private String subsidy;

    public MyCarState (Long memberNo, String brand, String carType ,String personnel, String speed, String charge, String battery, String subsidy) {
        this.memberNo = memberNo;
        this.brand = brand;
        this.carType = carType;
        this.personnel = personnel;
        this.speed = speed;
        this.charge = charge;
        this.battery = battery;
        this.subsidy= subsidy;


    }

}


