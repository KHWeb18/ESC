package com.esc.khweb.controller;

import com.esc.khweb.controller.request.CommentRequest;
import com.esc.khweb.controller.request.ReplyRequest;
import com.esc.khweb.entity.Comment;
import com.esc.khweb.entity.CommentReply;
import com.esc.khweb.entity.CommentReport;
import com.esc.khweb.service.CommentReplyService;
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
@RequestMapping("/reply")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class CommentReplyController {

    @Autowired
    private CommentReplyService service;

    @PostMapping("/register/{commentNo}")
    public ResponseEntity<Void> Register(@PathVariable Long commentNo,
                                         @Validated @RequestBody ReplyRequest replyRequest) throws Exception{
        replyRequest.setCommentNo(commentNo);
        service.registerReply(replyRequest);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/lists/{commentNo}")
    public ResponseEntity<List<CommentReply>> getLists(@PathVariable("commentNo") Long commentNo) throws Exception {

        return new ResponseEntity<List<CommentReply>>(service.getRepliesOfComment(commentNo),HttpStatus.OK);
    }

    @PutMapping("/{replyNo}")
    public ResponseEntity<Void> modify(@PathVariable("replyNo") Long replyNo,
                                       @RequestBody ReplyRequest replyRequest) throws Exception {

        List<CommentReply> replyList = service.findByReplyNo(replyNo);
        CommentReply replyRead = replyList.get(0);
        service.modify(replyRead, replyRequest);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
