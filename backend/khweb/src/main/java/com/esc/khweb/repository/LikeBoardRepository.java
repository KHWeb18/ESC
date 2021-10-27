package com.esc.khweb.repository;

import com.esc.khweb.entity.LikeBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface LikeBoardRepository extends JpaRepository<LikeBoard, Long> {

    @Query("select u.boardNo from LikeBoard u where u.memberNo = :memberNo")
    ArrayList  findByBoardNo(Long memberNo);
}
