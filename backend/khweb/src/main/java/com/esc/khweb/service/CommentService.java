package com.esc.khweb.service;

import com.esc.khweb.controller.request.CommentRequest;


public interface CommentService {
    public void register(CommentRequest commentRequest) throws Exception;
}
