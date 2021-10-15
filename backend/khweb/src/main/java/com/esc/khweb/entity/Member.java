package com.esc.khweb.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@ToString
public class Member {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_no")
    private Long memberNo;
    @Column(length = 64,nullable = false)
    private String memberId;
    @Column(length = 256,nullable = false)
    private String memberPw;
    @Column(length = 64, nullable = false)
    private String name;
    @Column(length = 64, nullable = false)
    private String email;
    @Column(length = 64, nullable = false)
    private String memberCar;
    @Column(length = 64, nullable = false)
    private Date memberBirthDay;


    @OneToMany(cascade =  CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "member_no")
    private List<InterestedCar> interestedCarList  = new ArrayList<InterestedCar>();
/*
    @OneToMany(cascade =  CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "member_no")
    private List<MyBoard> MyBoardList = new ArrayList<MyBoard>();
*/
    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private LocalDateTime lastModifiedDate;
}
