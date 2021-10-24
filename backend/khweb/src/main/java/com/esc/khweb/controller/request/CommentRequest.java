package com.esc.khweb.controller.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Data
@Slf4j
@NoArgsConstructor
public class CommentRequest {
    private Long boardNo;
    private String memberId;
    private String content;
}
