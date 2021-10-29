package com.esc.khweb.controller;

import com.esc.khweb.controller.request.NoticeRequest;
import com.esc.khweb.entity.Notice;
import com.esc.khweb.service.NoticeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/notice")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
@Slf4j
public class NoticeController {

    @Autowired
    NoticeService service;

    @PostMapping("/register")
    public ResponseEntity<Void> NoticeRegister(@Validated @RequestBody Notice notice) throws Exception{

        service.NoticeRegister(notice);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/uploadImg/{name}/{randomNumToString}")
    @ResponseBody
    public String requestUploadFile(@RequestParam("fileList") List<MultipartFile> fileList , @PathVariable("name") String name , @PathVariable("randomNumToString") String randomNumToString )
    {

        System.out.println("name = " +name );
        log.info("requestUploadFile(): " + fileList);

        try {
            // 결국 저장되는 위치가 images/사진파일명.확장자
            // images/아이디/사진파일명.확장자

            for (MultipartFile multipartFile : fileList) {
                log.info("requestUploadFile(): Make File");
                FileOutputStream writer = new FileOutputStream("C:\\proj\\ESC\\frontend\\src\\assets\\게시판/"+randomNumToString+name+"의"+multipartFile.getOriginalFilename());
                writer.write(multipartFile.getBytes());
                writer.close();


            }


        } catch (Exception e) {
            return "Upload Fail!!!";
        }

        log.info("requestUploadFile(): Success!!!");

        return "success!";
    }
        @PostMapping("/getNoitceList")
        public ResponseEntity<List<Notice>> getNoitceList () throws  Exception {

        List<Notice> list = service.getNoitceList();
        Collections.reverse(list);
        return  new ResponseEntity<>(list,HttpStatus.OK);
        }

        @PostMapping("/viewcount/{boardNo}")
        public ResponseEntity<Void> viewcount (@PathVariable("boardNo") Long boardNo) throws  Exception {

        service.viewcount(boardNo);

        return  new ResponseEntity<>(HttpStatus.OK);
        }

    @PostMapping("/titleSearchList/{search}")
    public ResponseEntity<List<Notice>>titleSearchList (@PathVariable("search") String search) throws  Exception {

        List<Notice> list = service.titleSearchList(search);
        Collections.reverse(list);
        return new ResponseEntity<>(list,HttpStatus.OK);
    }




    @PostMapping("/memberIdSearchList/{search}")
    public ResponseEntity<List<Notice>>memberIdSearchList (@PathVariable("search") String search) throws  Exception {

        List<Notice> list = service.memberIdSearchList(search);
        Collections.reverse(list);
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @PostMapping("/getNotice/{boardNo}")
    public ResponseEntity<Notice> getNotice(@PathVariable("boardNo")Long boardNo) throws  Exception {

        Optional<Notice> notice = service.getNotice(boardNo);

        Notice notice1 = notice.get();

        return  new ResponseEntity<>(notice1, HttpStatus.OK);
    }

    @PostMapping("/noticeModify/{boardNo}")
    public ResponseEntity<Void> noticeModify (@PathVariable("boardNo") Long boardNo, @Validated @RequestBody NoticeRequest noticeRequest) throws  Exception {

        service.noticeModify(boardNo,noticeRequest);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
