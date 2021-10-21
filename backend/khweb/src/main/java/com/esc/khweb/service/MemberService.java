package com.esc.khweb.service;

import com.esc.khweb.controller.request.MemberRequest;
import com.esc.khweb.entity.Member;

import java.util.List;
import java.util.Optional;

public interface MemberService {

    public  void memberRegister (Member member) throws  Exception;

    public List<Member> FindById(String email) throws  Exception;

    public Optional<Member> FindBymemberImp(String memberId) throws  Exception;

    public  boolean IdMatchedBirthday (MemberRequest memberRequest) throws  Exception ;

    public List<Member> getMeberList() throws  Exception;

    public void deleteMember (Long memberNo)throws  Exception;

}
