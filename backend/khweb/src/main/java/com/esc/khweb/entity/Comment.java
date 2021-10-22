package com.esc.khweb.entity;

import com.esc.khweb.controller.request.CommentRequest;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Comment")
@NoArgsConstructor
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long commentNo;

    @Column(nullable = false)
    private Long boardNo;

    @Column(nullable = false)
    private String memberId;

    @Column(nullable = false)
    private String content;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
    @CreationTimestamp
    private Date regDate;

    public Comment(Long commentNo, Long boardNo, String memberId, String content, Date regDate){
        this.commentNo = commentNo;
        this.boardNo = boardNo;
        this.memberId = memberId;
        this.content = content;
        this.regDate = regDate;
    }

    public void updateComment(CommentRequest commentRequest){
        this.memberId = commentRequest.getMemberId();
        this.content = commentRequest.getContent();
    }
}
