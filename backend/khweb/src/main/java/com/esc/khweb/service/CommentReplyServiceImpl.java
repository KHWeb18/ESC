package com.esc.khweb.service;

import com.esc.khweb.controller.request.ReplyRequest;
import com.esc.khweb.entity.CommentReply;
import com.esc.khweb.repository.CommentReplyRepository;
import com.esc.khweb.repository.CommentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CommentReplyServiceImpl implements CommentReplyService{

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private CommentReplyRepository commentReplyRepository;
    @Override
    public void registerReply(ReplyRequest replyRequest) throws Exception {
        CommentReply replyEntity = new CommentReply(replyRequest.getCommentNo(), replyRequest.getMemberId(),
                replyRequest.getContent());

        commentReplyRepository.save(replyEntity);
    }

    @Override
    public List<CommentReply> getRepliesOfComment(Long commentNo) throws Exception {
        return commentReplyRepository.getRepliesOfComment(commentNo);
    }

    @Override
    public List<CommentReply> findByReplyNo(Long replyNo) throws Exception {
        return commentReplyRepository.findByReplyNo(replyNo);
    }

    @Override
    public void modify(CommentReply commentReply, ReplyRequest replyRequest) throws Exception {
        commentReply.updateReply(replyRequest);
        commentReplyRepository.save(commentReply);
    }
}
