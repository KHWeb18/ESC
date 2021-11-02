package com.esc.khweb.controller;

import com.esc.khweb.controller.vueCookie.UserInfo;
import com.esc.khweb.service.MemberService;
import com.esc.khweb.controller.request.MemberRequest;
import com.esc.khweb.entity.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/member")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
@Slf4j
public class MemberController {

        private UserInfo info;

        @Autowired
        MemberService service;



        @PostMapping("/register")
        public ResponseEntity<Void> memberRegister(@Validated @RequestBody Member member) throws Exception {
                service.memberRegister(member);

                return new ResponseEntity<Void>(HttpStatus.OK);
        }

        @PostMapping("/FindById")
        public ResponseEntity<List> FindById (@Validated @RequestBody MemberRequest memberRequest) throws  Exception {
                String email = memberRequest.getEmail();
              List result =   service.FindById(email);

                return  new ResponseEntity<>(result,HttpStatus.OK);
        }

                @PostMapping("/FindBymemberImp")
                public  ResponseEntity<Member> FindBymemberImp (@Validated @RequestBody MemberRequest memberRequest) throws  Exception {
                        try {
                                String memberId = memberRequest.getMemberId();
                                Optional<Member> member = service.FindBymemberImp(memberId);
                                Member member1 = member.get();
                                return new ResponseEntity<>(member1, HttpStatus.OK);
                        }
                catch (Exception e){

                        return  new ResponseEntity<>(null,HttpStatus.OK);
                }
        }
        @PostMapping("/IdMatchedBirthday")
        public ResponseEntity<Boolean> IdMatchedBirthday (@Validated @RequestBody MemberRequest memberRequest) throws  Exception {



                Boolean result = service.IdMatchedBirthday(memberRequest);

                return new ResponseEntity<>(result,HttpStatus.OK);
        }

        @PostMapping("/ModifyPassword")
        public ResponseEntity<Void> ModifyPassword (@Validated @RequestBody Member member) throws  Exception {

                service.memberRegister(member);

                return new ResponseEntity<Void>(HttpStatus.OK);
        }

        @PostMapping("/getMemberList")
        public ResponseEntity<List<Member>> getMeberList () throws  Exception {

                List<Member> list = service.getMeberList();

                return new ResponseEntity<>(list,HttpStatus.OK);
        }

        @DeleteMapping("/deleteMember/{memberNo}")
        public ResponseEntity<Void> deleteMember(@PathVariable("memberNo")Long memberNo) throws  Exception {

                log.info("memberNo : " + memberNo);

                service.deleteMember(memberNo);

                return new ResponseEntity<Void>(HttpStatus.OK);
        }

        @PostMapping("/login")
        public ResponseEntity<UserInfo> login (@Validated @RequestBody MemberRequest memberRequest) throws  Exception {
                 info = new UserInfo();
              Boolean isTrue = service.login(memberRequest);
              Long memberNo = service.findByMemberNo(memberRequest);
              String status = service.findByMemberStatus(memberRequest);

                if (isTrue){

                        info.setMemberId(memberRequest.getMemberId());
                        info.setMemberNo(memberNo);
                        info.setStatus(status);
                }
                else {
                        info.setMemberId(null);
                }

                return  new ResponseEntity<UserInfo>(info,HttpStatus.OK);
        }

        @PostMapping("/addLikeBoard/{boardNo}")
        public ResponseEntity<String> addLikeBoard (@PathVariable("boardNo") Long boardNo ,@Validated @RequestBody MemberRequest memberRequest) throws  Exception {
                System.out.println("memberNo:" + memberRequest.getMemberNo());

                String result = service.addLikeBoard(boardNo,memberRequest);

                return  new ResponseEntity<>(result,HttpStatus.OK);
        }

        @PostMapping("/addHateBoard/{boardNo}")
        public ResponseEntity<String> addHateBoard (@PathVariable("boardNo") Long boardNo ,@Validated @RequestBody MemberRequest memberRequest) throws  Exception {
                System.out.println("memberNo:" + memberRequest.getMemberNo());

                String result = service.addHateBoard(boardNo,memberRequest);

                return  new ResponseEntity<>(result,HttpStatus.OK);
        }

        @PostMapping("/findByMemberInfo/{memberNo}")
        public ResponseEntity<Member> findByMemberInfo (@PathVariable("memberNo")Long memberNo) throws  Exception {

                Optional<Member>  member = service.findByMemberInfo(memberNo);
                Member member1 = member.get();

                return  new ResponseEntity<>(member1,HttpStatus.OK);
        }
        @PostMapping("/getManageAuth/{memberNo}")
        public ResponseEntity<Void> GETMemberAuth (@PathVariable("memberNo")Long memberNo) throws  Exception {

                service.GETMemberAuth(memberNo);

                return new ResponseEntity<>(HttpStatus.OK);
        }
        @PostMapping("/getAuth/{memberNo}")
        public ResponseEntity<String> getAuth (@PathVariable("memberNo")Long memberNo) throws  Exception {
                try {
                        String auth = service.getAuth(memberNo);

                        return new ResponseEntity<>(auth, HttpStatus.OK);
                }
                catch (Exception e) {
                        String Empty = "일반유저";
                        return new ResponseEntity<>(Empty, HttpStatus.OK);
                }

        }

        @PostMapping("/IDban/{memberNo}")
        public ResponseEntity<Void> IDban (@PathVariable("memberNo") Long memberNo) throws  Exception {

                service.IDban(memberNo);

                return new ResponseEntity<>(HttpStatus.OK);
        }
        @PostMapping("/jailbreak/{memberNo}")
        public ResponseEntity<Void> jailbreak(@PathVariable("memberNo") Long memberNo) throws  Exception {

                service.jailbreak(memberNo);

                return new ResponseEntity<>(HttpStatus.OK);
        }
        @PostMapping("/findALLByNo/{memberNo}")
        public  ResponseEntity<List<Member>> findALLByNo (@PathVariable("memberNo") Long memberNo) throws  Exception {
                try {
                        List<Member> list = service.findALLByNo(memberNo);
                        return new ResponseEntity<>(list, HttpStatus.OK);
                }catch (Exception e){
                        return new ResponseEntity<>(null, HttpStatus.OK);
                }
        }
        @PostMapping("/findALLByName/{name}")
        public  ResponseEntity<List<Member>> findALLByName (@PathVariable("name") String name) throws  Exception {
                List<Member> list = service.findALLByName(name);

                return new ResponseEntity<>(list,HttpStatus.OK);
        }
        @PostMapping("/findALLById/{memberId}")
        public  ResponseEntity<List<Member>> findALLById (@PathVariable("memberId") String memberId) throws  Exception {
                List<Member> list = service.findALLById(memberId);

                return new ResponseEntity<>(list,HttpStatus.OK);
        }

}