package com.esc.khweb.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@ToString
public class Administrator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "row_no")
    private  Long rowNo;

    @Column(name = "member_no")
    private Long memberNo;

    @Column(length = 32 ,nullable = true)
    private String auth;

    public  Administrator (Long memberNo , String auth) {

        this.memberNo = memberNo;
        this.auth = auth;
    }
}
