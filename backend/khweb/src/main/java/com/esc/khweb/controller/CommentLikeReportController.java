package com.esc.khweb.controller;

import com.esc.khweb.controller.request.CommentLikeRequest;
import com.esc.khweb.controller.request.CommentReportRequest;
import com.esc.khweb.controller.request.CommentRequest;
import com.esc.khweb.entity.CommentLikes;
import com.esc.khweb.service.CommentLikeService;
import com.esc.khweb.service.CommentReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/comment")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class CommentLikeReportController {

    @Autowired
    private CommentLikeService commentLikeService;

    @Autowired
    private CommentReportService commentReportService;

    @PostMapping("/like/{commentNo}")
    public ResponseEntity<Void> RegisterLike(@PathVariable Long commentNo,
                                         @Validated @RequestBody CommentLikeRequest commentLikeRequest)
            throws Exception{

        commentLikeRequest.setCommentNo(commentNo);
        commentLikeService.registerLike(commentLikeRequest);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/report/{commentNo}")
    public ResponseEntity<Void> RegisterReport(@PathVariable Long commentNo,
                                             @Validated @RequestBody CommentReportRequest commentReportRequest)
            throws Exception{

        commentReportRequest.setCommentNo(commentNo);
        commentReportService.registerReport(commentReportRequest);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/like/lists/{commentNo}")
    public ResponseEntity<List<CommentLikes>> getLists(@PathVariable("commentNo") Long commentNo) throws Exception {

        return new ResponseEntity<List<CommentLikes>>(commentLikeService.getLikesOfComment(commentNo),HttpStatus.OK);
    }

    @DeleteMapping("/like/delete/{commentNo}/{memberId}")
    public ResponseEntity<Void> deleteLike(@PathVariable("commentNo") Long commentNo, @PathVariable("memberId")
                                       String memberId) throws Exception{
        commentLikeService.deleteByCommentNoAndMemberId(commentNo, memberId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/like/check/{commentNo}/{memberId}")
    public ResponseEntity<Boolean> checkMemberDuplicate(@PathVariable("commentNo") Long commentNo,
                                                     @PathVariable("memberId") String memberId) throws Exception{
        Boolean containsMember = commentLikeService.checkMemberDuplicate(commentNo, memberId);

        return new ResponseEntity<Boolean>(containsMember, HttpStatus.OK);
    }

    @GetMapping("/report/check/{commentNo}/{memberId}")
    public ResponseEntity<Boolean> checkReportDuplicate(@PathVariable("commentNo") Long commentNo,
                                                        @PathVariable("memberId") String memberId) throws Exception{
        Boolean containsMember = commentReportService.checkMemberDuplicate(commentNo, memberId);

        return new ResponseEntity<Boolean>(containsMember, HttpStatus.OK);
    }
}
