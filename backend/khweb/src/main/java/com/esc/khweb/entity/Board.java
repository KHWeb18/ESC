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
public class Board {

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
    @Column(length = 200, nullable = false)
    private String report = "클린";
    @Column(length = 2000, nullable = false)
    private Integer good = 0;
    @Column(length = 2000, nullable = false)
    private Integer bad = 0;
    @Column(length = 2000, nullable = false)
    private Integer viewcount = 0;
    @CreationTimestamp
    private LocalDateTime createDate;

    @UpdateTimestamp
    private LocalDateTime lastModifiedDate;

    // 댓글
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "boardNo")
    private List<Comment> commentList = new ArrayList<Comment>();

    public  Board (String memberId, String title, String content, String img , String category) {
        this.memberId = memberId;
        this.title = title;
        this.content = content;
        this.img = img;
        this.category = category;
    }


}
