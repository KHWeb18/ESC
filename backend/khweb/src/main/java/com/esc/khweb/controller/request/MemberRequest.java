package com.esc.khweb.controller.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Data
@Slf4j
@NoArgsConstructor
public class MemberRequest {

    private Long memberNo;
    private String memberId;
    private String memberPw;
    private String memberCar;
    private String name;
    private String email;
    private Date memberBirthDay;
    private Date maybeBirthday;
    private Date regDate;
}
