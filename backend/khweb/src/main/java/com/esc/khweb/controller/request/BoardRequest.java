package com.esc.khweb.controller.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@NoArgsConstructor
public class BoardRequest {

    private String memberId;
    private String title;
    private String content;
    private String img;
    private String category;
}
