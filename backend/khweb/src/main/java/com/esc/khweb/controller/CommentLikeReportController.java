package com.esc.khweb.controller;

import com.esc.khweb.controller.request.CommentLikeRequest;
import com.esc.khweb.controller.request.CommentRequest;
import com.esc.khweb.service.CommentLikeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/comment")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class CommentLikeReportController {

    @Autowired
    private CommentLikeService commentLikeService;

    @PostMapping("/like/{commentNo}")
    public ResponseEntity<Void> Register(@PathVariable Long commentNo,
                                         @Validated @RequestBody CommentLikeRequest commentLikeRequest)
            throws Exception{

        commentLikeRequest.setCommentNo(commentNo);
        commentLikeService.registerLike(commentLikeRequest);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
