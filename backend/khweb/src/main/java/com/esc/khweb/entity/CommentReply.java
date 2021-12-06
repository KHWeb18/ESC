package com.esc.khweb.entity;

import com.esc.khweb.controller.request.CommentRequest;
import com.esc.khweb.controller.request.ReplyRequest;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "CommentReply")
@NoArgsConstructor
@Data
public class CommentReply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long replyNo;

    @Column(nullable = true)
    private Long commentNo;

    @Column(nullable = false)
    private String memberId;

    @Column(nullable = false)
    private String content;

    @Column(columnDefinition = "boolean default false")
    private Boolean isDeleted;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
    @CreationTimestamp
    private Date regDate;

    public CommentReply(Long commentNo, String memberId, String content){
        this.commentNo = commentNo;
        this.memberId = memberId;
        this.content = content;
    }

    public void updateReply(ReplyRequest replyRequest){
        this.memberId = replyRequest.getMemberId();
        this.isDeleted = replyRequest.getIsDeleted();
    }

    public void deleteReply(ReplyRequest replyRequest){
        this.memberId = replyRequest.getMemberId();
        this.isDeleted = replyRequest.getIsDeleted();
    }
}
