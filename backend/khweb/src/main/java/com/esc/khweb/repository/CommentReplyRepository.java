package com.esc.khweb.repository;

import com.esc.khweb.entity.CommentReply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface CommentReplyRepository extends JpaRepository<CommentReply, Long> {

    @Query("select r from CommentReply r where r.commentNo = :commentNo")
    public List<CommentReply> getRepliesOfComment(Long commentNo);

    @Query("select r from CommentReply r where r.replyNo = :replyNo")
    public List<CommentReply> findByReplyNo(Long replyNo);


    @Transactional
    @Modifying
    @Query(value = "delete from CommentReply where commentNo =:comment_no")
    void deleteByCommentNo(@Param("comment_no")Long comment_no);
}
