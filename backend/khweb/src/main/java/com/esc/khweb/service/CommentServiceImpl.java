package com.esc.khweb.service;

import com.esc.khweb.controller.request.CommentRequest;
import com.esc.khweb.entity.Comment;
import com.esc.khweb.repository.BoardRepository;
import com.esc.khweb.repository.CommentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public void register(CommentRequest commentRequest) throws Exception {
        Comment commentEntity = new Comment(commentRequest.getBoardNo(), commentRequest.getMemberId(),
                commentRequest.getContent());

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

    @Override
    public void delete(Comment comment, CommentRequest commentRequest) throws Exception {
        comment.deleteComment(commentRequest);
        commentRepository.save(comment);
    }
    @Override
    public Optional<Comment> getRePortedComment(Long commentNo) throws Exception {
        return commentRepository.getRePortedComment(commentNo);
    }
}
