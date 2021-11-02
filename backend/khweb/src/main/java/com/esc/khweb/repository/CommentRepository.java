package com.esc.khweb.repository;

import com.esc.khweb.entity.Comment;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends CrudRepository<Comment, Long> {

    @Query("select c from Comment c where  c.boardNo = :boardNo")
    public List<Comment> getCommentsOfBoard(Long boardNo);

    @Query("select c from Comment c where c.commentNo = :commentNo")
    public List<Comment> findByCommentNo(Long commentNo);

    @Transactional
    @Modifying
    @Query(value = "delete from Comment where boardNo =:board_no")
    void deleteByBoardNo(@Param("board_no")Long board_no);

    @Query("select c from Comment c where c.commentNo = :commentNo")
    Optional<Comment> getRePortedComment(Long commentNo);
}
