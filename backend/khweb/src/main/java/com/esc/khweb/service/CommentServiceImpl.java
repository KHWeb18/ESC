package com.esc.khweb.service;

import com.esc.khweb.controller.request.CommentRequest;
import com.esc.khweb.entity.Comment;
import com.esc.khweb.repository.BoardRepository;
import com.esc.khweb.repository.CommentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Comment> getCommentsOfBoard(Long boardNo) throws Exception {
        return commentRepository.getCommentsOfBoard(boardNo);
    }

    @Override
    public List<Comment> findByCommentNo(Long commentNo) throws Exception {
        return commentRepository.findByCommentNo(commentNo);
    }

    @Override
    public void modify(Comment comment, CommentRequest commentRequest) throws Exception {
        comment.updateComment(commentRequest);
        commentRepository.save(comment);
    }
}
