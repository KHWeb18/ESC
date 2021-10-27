package com.esc.khweb.service;

import com.esc.khweb.controller.request.ReplyRequest;
import com.esc.khweb.entity.CommentReply;

import java.util.List;

public interface CommentReplyService {
    public void registerReply(ReplyRequest replyRequest) throws Exception;
    public List<CommentReply> getRepliesOfComment(Long commentNo) throws Exception;
    public List<CommentReply> findByReplyNo(Long replyNo) throws Exception;
    public void modify(CommentReply commentReply, ReplyRequest replyRequest) throws Exception;
}
