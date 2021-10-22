package com.esc.khweb.controller;

import com.esc.khweb.controller.request.CommentRequest;
import com.esc.khweb.service.CommentService;
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
}
