package com.esc.khweb.repository;


import com.esc.khweb.entity.CommentLikes;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentLikeRepository extends CrudRepository<CommentLikes, Long> {

    @Query("select l from CommentLikes l where l.commentNo = :commentNo")
    public List<CommentLikes> getLikesOfComment(Long commentNo);
}
