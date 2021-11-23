package com.esc.khweb.service;

import com.esc.khweb.controller.request.CommentReportRequest;
import com.esc.khweb.entity.Comment;
import com.esc.khweb.entity.CommentLikes;
import com.esc.khweb.entity.CommentReport;
import com.esc.khweb.repository.CommentReportRepository;
import com.esc.khweb.repository.CommentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class CommentReportServiceImpl implements CommentReportService{

    @Autowired
    private CommentReportRepository commentReportRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public void registerReport(CommentReportRequest commentReportRequest) throws Exception {
        CommentReport commentReport = new CommentReport(commentReportRequest.getReportNo(),
                commentReportRequest.getCommentNo(), commentReportRequest.getMemberId());

        commentReportRepository.save(commentReport);
    }

    @Override
    public List<CommentReport> getReportsOfComment(Long commentNo) throws Exception {
        return commentReportRepository.getReportsOfComment(commentNo);
    }

    @Override
    public void deleteByCommentNoAndMemberId(Long commentNo, String memberId) throws Exception {
        commentReportRepository.deleteByCommentNoAndMemberId(commentNo, memberId);
    }

    @Override
    public Boolean checkMemberDuplicate(Long commentNo, String memberId) throws Exception {
        Optional<CommentReport> maybeMember = commentReportRepository.findByCommentNoAndMemberId(commentNo, memberId);

        return maybeMember.isPresent();
    }
    @Override
    public List<Comment> getReportedCommentNoList() throws Exception {

        List<CommentReport> list = commentReportRepository.findAll();
        List<Comment> list2 = new ArrayList<>();
        for(int i = 0; i< list.toArray().length; i++ ){
            Long IdNo = list.get(i).getCommentNo();
            System.out.println("IdNo:"+IdNo);
           Optional<Comment>  maybeReportedComment = commentRepository.findById(IdNo);
           Comment comment = maybeReportedComment.get();
            list2.add(comment);

        }

        return list2;
    }

    @Override
    public void reportedCommentDelete(Long commentNo) throws Exception {

        Optional<CommentReport> commentReport  =commentReportRepository.findByEntity(commentNo);
        CommentReport commentReport1 = commentReport.get();
        commentReportRepository.delete(commentReport1);
    }
}
