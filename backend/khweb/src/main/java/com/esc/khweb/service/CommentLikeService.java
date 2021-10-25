package com.esc.khweb.service;

import com.esc.khweb.controller.request.CommentLikeRequest;

public interface CommentLikeService {
    public void registerLike(CommentLikeRequest commentLikeRequest) throws Exception;
}
