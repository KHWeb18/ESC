package com.esc.khweb.repository;

import com.esc.khweb.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface BoardRepository extends JpaRepository<Board,Long> {
    @Transactional
    @Modifying
    @Query("UPDATE Board b set b.viewcount = b.viewcount +1 where b.boardNo = :boardNo")
    void viewcount( Long boardNo);
}
