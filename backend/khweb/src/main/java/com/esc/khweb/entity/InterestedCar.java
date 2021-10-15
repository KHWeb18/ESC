package com.esc.khweb.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@ToString
public class InterestedCar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "interested_car_no")
    private  Long interestedCarNo;

    @Column(name = "member_no")
    private Long memberNo;

    @Column(length = 200, nullable = false)
    private  String car;
}
