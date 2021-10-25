package com.esc.khweb.repository;


import com.esc.khweb.entity.CommentLikes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface CommentLikeRepository extends JpaRepository<CommentLikes, Long> {

    @Query("select l from CommentLikes l where l.commentNo = :commentNo")
    public List<CommentLikes> getLikesOfComment(Long commentNo);

    @Transactional
    @Modifying
    @Query(value = "delete from CommentLikes where commentNo =:commentNo and memberId =:memberId")
    void deleteByCommentNoAndMemberId(@Param("commentNo")Long commentNo, @Param("memberId")String memberId);
}
