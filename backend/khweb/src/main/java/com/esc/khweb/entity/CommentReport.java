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
@Table(name = "CommentReport")
@NoArgsConstructor
@Data
public class CommentReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long reportNo;

    @Column(nullable = false)
    private Long commentNo;

    @Column(nullable = false)
    private String memberId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
    @CreationTimestamp
    private Date regDate;

    public CommentReport(Long likeNo, Long commentNo, String memberId){
        this.reportNo = likeNo;
        this.commentNo = commentNo;
        this.memberId = memberId;
    }
}
