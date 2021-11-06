package com.esc.khweb.controller;

import com.esc.khweb.controller.request.CommentRequest;
import com.esc.khweb.entity.Comment;
import com.esc.khweb.entity.CommentReport;
import com.esc.khweb.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/comment")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/register/{boardNo}")
    public ResponseEntity<Void> Register(@PathVariable Long boardNo,
                                         @Validated @RequestBody CommentRequest commentRequest) throws Exception{

        commentRequest.setBoardNo(boardNo);
        commentService.register(commentRequest);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/lists/{boardNo}")
    public ResponseEntity<List<Comment>> getLists(@PathVariable("boardNo") Long boardNo) throws Exception {

        return new ResponseEntity<List<Comment>>(commentService.getCommentsOfBoard(boardNo),HttpStatus.OK);
    }

    @GetMapping("/{commentNo}")
    public ResponseEntity<Comment> read(@PathVariable("commentNo") Long commentNo) throws Exception {
        List<Comment> commentList = commentService.findByCommentNo(commentNo);
        Comment commentRead = commentList.get(0);
        return new ResponseEntity<Comment>(commentRead, HttpStatus.OK);
    }

    @PutMapping("/edit/{commentNo}")
    public ResponseEntity<Void> modify(@PathVariable("commentNo") Long commentNo,
                                       @RequestBody CommentRequest commentRequest) throws Exception {

        List<Comment> commentList = commentService.findByCommentNo(commentNo);
        Comment commentRead = commentList.get(0);
        commentService.modify(commentRead, commentRequest);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PutMapping("/delete/{commentNo}")
    public ResponseEntity<Void> delete(@PathVariable("commentNo") Long commentNo,
                                       @RequestBody CommentRequest commentRequest) throws Exception {

        List<Comment> commentList = commentService.findByCommentNo(commentNo);
        Comment commentRead = commentList.get(0);
        commentService.delete(commentRead, commentRequest);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    @PostMapping("/getRePortedComment/{commentNo}")
    public ResponseEntity<Comment> getRePortedComment(@PathVariable("commentNo")Long commentNo) throws  Exception {

        Optional<Comment> comment  = commentService.getRePortedComment(commentNo);
        Comment comment1 = comment.get();

        return new ResponseEntity<>(comment1,HttpStatus.OK);
    }
}
