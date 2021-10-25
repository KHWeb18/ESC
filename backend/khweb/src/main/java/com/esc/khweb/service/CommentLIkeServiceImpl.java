package com.esc.khweb.service;

import com.esc.khweb.controller.request.CommentLikeRequest;
import com.esc.khweb.entity.CommentLikes;
import com.esc.khweb.repository.CommentLikeRepository;
import com.esc.khweb.repository.CommentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CommentLIkeServiceImpl implements CommentLikeService {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private CommentLikeRepository commentLikeRepository;

    @Override
    public void registerLike(CommentLikeRequest commentLikeRequest) throws Exception {
        CommentLikes commentLikes = new CommentLikes(commentLikeRequest.getLikeNo(), commentLikeRequest.getCommentNo(),
                commentLikeRequest.getMemberId());

        commentLikeRepository.save(commentLikes);
    }

    @Override
    public List<CommentLikes> getLikesOfComment(Long commentNo) throws Exception {
        return commentLikeRepository.getLikesOfComment(commentNo);
    }
}
