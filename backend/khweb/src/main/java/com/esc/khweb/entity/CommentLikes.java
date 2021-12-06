package com.esc.khweb.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "CommentLikes")
@NoArgsConstructor
@Data
public class CommentLikes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = true)
    private Long likeNo;

    @Column(nullable = true)
    private Long commentNo;

    @Column(nullable = true)
    private String memberId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
    @CreationTimestamp
    private Date regDate;

    public CommentLikes(Long likeNo, Long commentNo, String memberId){
        this.likeNo = likeNo;
        this.commentNo = commentNo;
        this.memberId = memberId;
    }
}
