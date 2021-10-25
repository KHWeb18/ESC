package com.esc.khweb.service;

import com.esc.khweb.controller.request.CommentLikeRequest;
import com.esc.khweb.entity.CommentLikes;

import java.util.List;

public interface CommentLikeService {
    public void registerLike(CommentLikeRequest commentLikeRequest) throws Exception;
    public List<CommentLikes> getLikesOfComment(Long commentNo) throws Exception;
}
