package com.esc.khweb.Service;

import com.esc.khweb.controller.request.MemberRequest;
import com.esc.khweb.entity.Member;
import com.esc.khweb.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceimpl implements MemberService{

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder  passwordEncoder;
    @Override
    public void memberRegister(Member member) throws Exception {
        //비번 암호화 하기
        String encodedPassword = passwordEncoder.encode(member.getMemberPw());

        member.setMemberPw(encodedPassword);

        memberRepository.save(member);
    }

    @Override
    public List<Member> FindById(String email) throws Exception {

        return  memberRepository.FindByUserId(email);
    }

    @Override
    public Optional<Member> FindBymemberImp(String memberId) throws Exception {
        return memberRepository.FindBymemberImp(memberId);
    }

    @Override
    public boolean IdMatchedBirthday(MemberRequest memberRequest) throws Exception {
            Optional<Member> member =  memberRepository.FindBymemberImp(memberRequest.getMemberId());
            Member member1  = member.get();

        DateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 =member1.getMemberBirthDay();
        String memberBirthday = sdFormat.format(date1);

        DateFormat sdFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        Date date2 = memberRequest.getMaybeBirthday();
        String maybBirthday = sdFormat1.format(date2);


        System.out.println("memberBirthday = " + memberBirthday +"maybBirthday =" + maybBirthday);
        if(memberBirthday.equals(maybBirthday)) {
            return true;

        }
        else {
            return false;
        }
    }

    @Override
    public List<Member> getMeberList() throws Exception {
        return memberRepository.findAll();
    }
}
