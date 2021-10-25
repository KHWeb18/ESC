package com.esc.khweb.controller.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@NoArgsConstructor
public class CommentLikeRequest {
    private Long likeNo;
    private Long commentNo;
    private String memberId;
}
