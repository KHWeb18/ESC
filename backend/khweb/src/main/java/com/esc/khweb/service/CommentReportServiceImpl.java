package com.esc.khweb.service;

import com.esc.khweb.controller.request.CommentReportRequest;
import com.esc.khweb.entity.CommentLikes;
import com.esc.khweb.entity.CommentReport;
import com.esc.khweb.repository.CommentReportRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class CommentReportServiceImpl implements CommentReportService{

    @Autowired
    private CommentReportRepository commentReportRepository;

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
}
