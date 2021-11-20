package com.esc.khweb.service;

import com.esc.khweb.controller.request.CommentReportRequest;
import com.esc.khweb.entity.Comment;
import com.esc.khweb.entity.CommentLikes;
import com.esc.khweb.entity.CommentReport;

import java.util.List;

public interface CommentReportService {
    public void registerReport(CommentReportRequest commentReportRequest) throws Exception;
    public List<CommentReport> getReportsOfComment(Long commentNo) throws Exception;
    public void deleteByCommentNoAndMemberId(Long commentNo, String memberId)throws Exception;
    public Boolean checkMemberDuplicate(Long commentNo, String memberId)throws Exception;
    public List<Comment> getReportedCommentNoList () throws  Exception;
    public  void reportedCommentDelete(Long commentNo)throws  Exception;
}
