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

@Entity
@Table(name = "charger_list")
@NoArgsConstructor
@Data
public class ChargerList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long chargerNo;

    @Column(nullable = true)
    private String statNm;

    @Column(nullable = false)
    private String statId;

    @Column(nullable = false)
    private String chgertypeList;

    @Column(nullable = false)
    private String addrList;

    @Column(nullable = false)
    private String latList;

    @Column(nullable = false)
    private String lngList;

}
