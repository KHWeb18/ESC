package com.esc.khweb.service;

import com.esc.khweb.controller.request.NoticeRequest;
import com.esc.khweb.entity.Notice;

import java.util.List;
import java.util.Optional;

public interface NoticeService {

    public  void NoticeRegister(Notice notice) throws  Exception;

    public List<Notice> getNoitceList () throws  Exception ;

    public void viewcount(Long boardNo) throws Exception;

    public List<Notice> titleSearchList(String search) throws  Exception;

    public  List<Notice> memberIdSearchList (String Search) throws  Exception ;

    public Optional<Notice> getNotice(Long boardNo) throws  Exception ;

    public  void noticeModify (Long boardNo, NoticeRequest noticeRequest) throws  Exception ;
}
