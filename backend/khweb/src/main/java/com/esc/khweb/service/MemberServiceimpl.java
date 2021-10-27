package com.esc.khweb.service;

import com.esc.khweb.controller.request.MemberRequest;
import com.esc.khweb.entity.HateBoard;
import com.esc.khweb.entity.LikeBoard;
import com.esc.khweb.entity.Member;
import com.esc.khweb.repository.HateBoardRepository;
import com.esc.khweb.repository.LikeBoardRepository;
import com.esc.khweb.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class MemberServiceimpl implements MemberService {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    LikeBoardRepository likeBoardRepository;

    @Autowired
    HateBoardRepository hateBoardRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void memberRegister(Member member) throws Exception {
        //비번 암호화 하기
        String encodedPassword = passwordEncoder.encode(member.getMemberPw());

        member.setMemberPw(encodedPassword);

        memberRepository.save(member);
    }

    @Override
    public List<Member> FindById(String email) throws Exception {

        return memberRepository.FindByUserId(email);
    }

    @Override
    public Optional<Member> FindBymemberImp(String memberId) throws Exception {
        return memberRepository.FindBymemberImp(memberId);
    }

    @Override
    public boolean IdMatchedBirthday(MemberRequest memberRequest) throws Exception {
        Optional<Member> member = memberRepository.FindBymemberImp(memberRequest.getMemberId());
        Member member1 = member.get();

        DateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = member1.getMemberBirthDay();
        String memberBirthday = sdFormat.format(date1);

        DateFormat sdFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        Date date2 = memberRequest.getMaybeBirthday();
        String maybBirthday = sdFormat1.format(date2);


        System.out.println("memberBirthday = " + memberBirthday + "maybBirthday =" + maybBirthday);
        if (memberBirthday.equals(maybBirthday)) {
            return true;

        } else {
            return false;
        }
    }

    @Override
    public List<Member> getMeberList() throws Exception {
        return memberRepository.findAll();
    }

    @Override
    public void deleteMember(Long memberNo) throws Exception {
        memberRepository.deleteById(memberNo);
    }

    @Override
    public Boolean login(MemberRequest memberRequest) throws Exception {

        Optional<Member> maybeMember = memberRepository.FindBymemberImp(memberRequest.getMemberId());
        if (maybeMember == null) {
            log.info("login(): 그런 사람 없다.");
            return false;
        }

        Member loginMember = maybeMember.get();

        if (!passwordEncoder.matches(memberRequest.getMemberPw(), loginMember.getMemberPw())) {
            log.info("login(): 비밀번호 잘못 입력하였습니다.");
            return false;
        }

        return true;
    }

    @Override
    public Long findByMemberNo(MemberRequest memberRequest) throws Exception {
        String memberId = memberRequest.getMemberId();
        return memberRepository.findByMemberNo(memberId);
    }

    @Override
    public String addLikeBoard(Long boardNo, MemberRequest memberRequest) throws Exception {
        String result = "이글은 이미 추천하셧습니다.";
        String result2 = "추천되었습니다.";
        ArrayList likeBoards = likeBoardRepository.findByBoardNo(memberRequest.getMemberNo());
        System.out.println(likeBoards);
        System.out.println("boardNo:" + boardNo);
        System.out.println(likeBoards.indexOf(boardNo));


        if (likeBoards.indexOf(boardNo) >= 0) {
            return result;
        } else if (likeBoards.indexOf(boardNo) < 0) {
            LikeBoard likeBoard = new LikeBoard(memberRequest.getMemberNo(), boardNo);
            likeBoardRepository.save(likeBoard);
            return result2;
        }
        return "알수없는오류발견";
    }

    @Override
    public String addHateBoard(Long boardNo, MemberRequest memberRequest) throws Exception {
        String result = "이글은 이미 비추하셧습니다.";
        String result2 = "비추되었습니다.";
        ArrayList hateBoards = hateBoardRepository.findByBoardNo(memberRequest.getMemberNo());
        System.out.println(hateBoards);
        System.out.println("boardNo:" + boardNo);
        System.out.println(hateBoards.indexOf(boardNo));


        if (hateBoards.indexOf(boardNo) >= 0) {
            return result;
        } else if (hateBoards.indexOf(boardNo) < 0) {
            HateBoard hateBoard = new HateBoard(memberRequest.getMemberNo(), boardNo);
            hateBoardRepository.save(hateBoard);
            return result2;
        }

        return "알수없는오류발견";
    }


    @Override
    public Optional<Member> findByMemberInfo(Long memberNo) throws Exception {
        return memberRepository.findById(memberNo);
    }
}

