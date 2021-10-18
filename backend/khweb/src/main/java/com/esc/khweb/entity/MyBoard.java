package com.esc.khweb.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@ToString
public class MyBoard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "my_board")
    private  Long myBoard;

    @Column(name = "member_no")
    private Long memberNo;

    @Column(length = 3000, nullable = false)
    private  Integer boardNo;
}
