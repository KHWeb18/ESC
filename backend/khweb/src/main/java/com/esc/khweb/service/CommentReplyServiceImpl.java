package com.esc.khweb.service;

import com.esc.khweb.controller.request.ReplyRequest;
import com.esc.khweb.entity.CommentReply;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CommentReplyServiceImpl implements CommentReplyService{
    @Override
    public void registerReply(ReplyRequest replyRequest) throws Exception {

    }

    @Override
    public List<CommentReply> getRepliesOfComment(Long commentNo) throws Exception {
        return null;
    }

    @Override
    public List<CommentReply> findByReplyNo(Long replyNo) throws Exception {
        return null;
    }

    @Override
    public void modify(CommentReply commentReply, ReplyRequest replyRequest) throws Exception {

    }
}
