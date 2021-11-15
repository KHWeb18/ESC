package com.esc.khweb.entity;

import com.esc.khweb.controller.request.MemberRequest;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

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
    @Column(length = 64, nullable = false)
    private String status ="활동가능";


    @OneToMany(cascade =  CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "member_no")
    private Set<InterestedCar> interestedCarList  = new HashSet<InterestedCar>();

    @OneToMany(cascade =  CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "member_no")
    private Set<LikeBoard> likeBoardList  = new HashSet<LikeBoard>();

    @OneToMany(cascade =  CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "member_no")
    private Set<HateBoard> hateBoardList  = new HashSet<HateBoard>();

    @OneToMany(cascade =  CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "member_no")
    private Set<Administrator> MemberAuthList  = new HashSet<Administrator>();

    @OneToMany(cascade =  CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "member_no")
    private Set<MyChargingState> MyChargingStateList = new HashSet<MyChargingState>();

    @OneToMany(cascade =  CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "member_no")
    private Set<MyParkingState> MyParkingStateList = new HashSet<MyParkingState>();




    public Member (String memberId, String memberPw, String name,
                   String email , String memberCar, Date memberBirthDay ) {
        this.memberId = memberId;
        this.memberPw = memberPw;
        this.name = name;
        this.email = email;
        this.memberCar = memberCar;
        this.memberBirthDay = memberBirthDay;
    }
    /*
    public void updateMember(Long memberNo, MemberRequest memberRequest){
        this.memberId = memberRequest.getMemberId();
        this.memberPw = memberRequest.getMemberPw();
        this.name = memberRequest.getName();
        this.email = memberRequest.getEmail();
        this.memberCar = memberRequest.getMemberCar();
    }
     */

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private LocalDateTime lastModifiedDate;
}
