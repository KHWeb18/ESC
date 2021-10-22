package com.esc.khweb.service;

import com.esc.khweb.controller.request.CommentRequest;
import com.esc.khweb.entity.Comment;

import java.util.List;


public interface CommentService {
    public void register(CommentRequest commentRequest) throws Exception;
    public List<Comment> getCommentsOfBoard(Long boardNo) throws Exception;
    public List<Comment> findByCommentNo(Long commentNo) throws Exception;
    public void modify(Comment comment, CommentRequest commentRequest) throws Exception;
}
