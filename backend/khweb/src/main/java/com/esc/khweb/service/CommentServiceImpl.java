package com.esc.khweb.service;

import com.esc.khweb.controller.request.CommentRequest;
import com.esc.khweb.entity.Comment;
import com.esc.khweb.repository.BoardRepository;
import com.esc.khweb.repository.CommentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public void register(CommentRequest commentRequest) throws Exception {
        Comment commentEntity = new Comment(commentRequest.getCommentNo(), commentRequest.getBoardNo(),
                commentRequest.getMemberId(), commentRequest.getContent(), commentRequest.getRegDate());

        commentRepository.save(commentEntity);
    }
}
