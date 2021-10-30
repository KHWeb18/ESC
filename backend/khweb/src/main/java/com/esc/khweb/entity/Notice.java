package com.esc.khweb.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@ToString
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardNo;
    @Column(length = 20, nullable = false)
    private String  title;
    @Column(length = 256, nullable = false)
    private String category;
    @Column(length = 200, nullable = false)
    private String memberId;
    @Column(length = 256, nullable = true)
    private String img;
    @Column(length = 2000, nullable = false)
    private String content;
    @Column(length = 2000, nullable = false)
    private Integer viewcount = 0;
    @CreationTimestamp
    private LocalDateTime createDate;

    @UpdateTimestamp
    private LocalDateTime lastModifiedDate;

    public Notice (Long boardNo , String title , String category ,String memberId , String img , String content) {
        this.boardNo  = boardNo;
        this.title = title;
        this.category = category;
        this.memberId = memberId;
        this.img = img;
        this.content =content;
    }
}
