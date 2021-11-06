package com.esc.khweb.repository;

import com.esc.khweb.entity.Board;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface BoardRepository extends JpaRepository<Board,Long>  {



    @Transactional
    @Modifying
    @Query("UPDATE Board b set b.viewcount = b.viewcount +1 where b.boardNo = :boardNo")
    void viewcount( Long boardNo);

    @Transactional
    @Modifying
    @Query("UPDATE Board b set b.good = b.good +1 where b.boardNo = :boardNo")
    void goodCount( Long boardNo);

    @Transactional
    @Modifying
    @Query("UPDATE Board b set b.bad = b.bad +1 where b.boardNo = :boardNo")
    void badCount( Long boardNo);

    @Transactional
    @Modifying
    @Query("UPDATE Board b set b.report = :reportWord where b.boardNo = :boardNo")
    void report( Long boardNo,String reportWord);


    @Transactional
    @Modifying
    @Query("UPDATE Board b set b.title = :title where b.boardNo = :boardNo")
    void boardModifyAtTitle(String title, Long boardNo);

    @Transactional
    @Modifying
    @Query("UPDATE Board b set b.content = :content where b.boardNo = :boardNo")
    void boardModifyAtcontent(String content, Long boardNo);

    @Transactional
    @Modifying
    @Query("UPDATE Board b set b.img = :img where b.boardNo = :boardNo")
    void boardModifyAtimg(String img, Long boardNo);


    @Query("select t from Board t where t.category = :target")
    List<Board> getTargetList(String target);

    @Query("select t from Board t where t.title = :search")
    List<Board> titleSearchList(String search);

    @Query("select t from Board t where t.memberId = :search")
    List<Board> memberIdSearchList(String search);

    @Query("select t from Board t where t.report = :report")
    List<Board> getReportedBoardList(String report);

    // 내 게시물 조회 예시
    List<Board> findByMemberId(String memberId);




}
