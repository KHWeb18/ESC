package com.esc.khweb.repository;

import com.esc.khweb.entity.CommentReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface CommentReportRepository extends JpaRepository<CommentReport, Long> {

    @Query("select l from CommentReport l where l.commentNo = :commentNo")
    public List<CommentReport> getReportsOfComment(Long commentNo);

    public Optional<CommentReport> findByCommentNoAndMemberId(Long commentNo, String memberId);

    @Transactional
    @Modifying
    @Query(value = "delete from CommentReport where commentNo =:commentNo and memberId =:memberId")
    void deleteByCommentNoAndMemberId(@Param("commentNo")Long commentNo, @Param("memberId")String memberId);
}
