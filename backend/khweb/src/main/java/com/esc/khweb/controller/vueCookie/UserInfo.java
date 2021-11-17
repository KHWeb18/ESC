package com.esc.khweb.controller.vueCookie;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class UserInfo {

    private String memberId;
    private Long memberNo;
    private String status;
    private String email;
    private String name;
    private String memberCar;
    private Date memberBirthDay;
    private Date regDate;
}
