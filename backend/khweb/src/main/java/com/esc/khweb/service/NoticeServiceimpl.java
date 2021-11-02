package com.esc.khweb.service;

import com.esc.khweb.controller.request.NoticeRequest;
import com.esc.khweb.entity.Notice;
import com.esc.khweb.repository.NoticeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class NoticeServiceimpl  implements  NoticeService{

    @Autowired
    NoticeRepository noticeRepository ;

    @Override
    public void NoticeRegister(Notice notice) throws Exception {

        noticeRepository.save(notice);
    }

    @Override
    public List<Notice> getNoitceList() throws Exception {
        return noticeRepository.findAll();
    }

    @Override
    public void viewcount(Long boardNo) throws Exception {
        noticeRepository.viewcount(boardNo);
    }

    @Override
    public List<Notice> titleSearchList(String search) throws Exception {
        return noticeRepository.titleSearchList(search);
    }

    @Override
    public List<Notice> categorySearchList(String Search) throws Exception {
        return noticeRepository.categorySearchList(Search);
    }

    @Override
    public Optional<Notice> getNotice(Long boardNo) throws Exception {
        return noticeRepository.findById(boardNo);
    }

    @Override
    public void noticeModify(Long boardNo , NoticeRequest noticeRequest) throws Exception {
        String title = noticeRequest.getTitle();
        String content = noticeRequest.getContent();
        String img = noticeRequest.getImg();
        noticeRepository.boardModifyAtTitle(title,boardNo);
        noticeRepository.boardModifyAtcontent(content,boardNo);
        noticeRepository.boardModifyAtimg(img,boardNo);
    }

    @Override
    public void DeleteBoard(Long boardNo) throws Exception {

        noticeRepository.deleteById(boardNo);

    }
}
