package com.esc.khweb.repository;


import com.esc.khweb.entity.CommentLikes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface CommentLikeRepository extends JpaRepository<CommentLikes, Long> {

    @Query("select l from CommentLikes l where l.commentNo = :commentNo")
    public List<CommentLikes> getLikesOfComment(Long commentNo);

    //@Query("select l from CommentLikes l where l.commentNo =: commentNo and l.memberId =:memberId")
    public Optional<CommentLikes> findByCommentNoAndMemberId(Long commentNo, String memberId);

    @Transactional // update, delete 사용시 표기
    @Modifying     // insert, update, delete 사용시
    @Query(value = "delete from CommentLikes where commentNo =:commentNo and memberId =:memberId")
    void deleteByCommentNoAndMemberId(@Param("commentNo")Long commentNo, @Param("memberId")String memberId);
}
