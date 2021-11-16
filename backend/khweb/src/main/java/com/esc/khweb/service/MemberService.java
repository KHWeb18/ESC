package com.esc.khweb.service;

import com.esc.khweb.controller.request.MemberRequest;
import com.esc.khweb.controller.request.MyChargingStateRequest;
import com.esc.khweb.entity.Board;
import com.esc.khweb.entity.Member;
import com.esc.khweb.entity.MyChargingState;
import com.esc.khweb.entity.MyParkingState;

import java.util.List;
import java.util.Optional;

public interface MemberService {

    public  void memberRegister (Member member) throws  Exception;

    public List<Member> FindById(String email) throws  Exception;

    public Optional<Member> FindBymemberImp(String memberId) throws  Exception;

    public  boolean IdMatchedBirthday (MemberRequest memberRequest) throws  Exception ;

    public List<Member> getMeberList() throws  Exception;

    public void deleteMember (Long memberNo)throws  Exception;

    public Boolean login(MemberRequest memberRequest) throws  Exception ;

    public Long  findByMemberNo(MemberRequest memberRequest) throws  Exception;

    public  String addLikeBoard(Long boardNo,  MemberRequest memberRequest) throws  Exception;

    public  String  addHateBoard (Long boardNo, MemberRequest memberRequest) throws  Exception;

    public  Optional<Member> findByMemberInfo(Long memberNo) throws  Exception ;

    public  void GETMemberAuth (Long memberNo) throws  Exception ;

    public  String getAuth(Long memberNo) throws  Exception;

    public  void IDban (Long memberNo) throws  Exception;

    public  void jailbreak (Long memberNo) throws  Exception ;

    public  String findByMemberStatus(MemberRequest memberRequest) throws  Exception;

    public List<Member> findALLByNo(Long memberNo) throws  Exception;

    public List<Member> findALLByName(String name) throws  Exception;

    public List<Member> findALLById(String memberId) throws  Exception;

    public void delete(Long memberNo) throws Exception;

    public void modify(Long memberNo, MemberRequest memberRequest) throws Exception;

    public String addMyState(Long memberNo, MyChargingStateRequest myChargingStateRequest);

    public  String addMyParkingState(Long memberNo , MyParkingState myParkingState) throws  Exception;

    public List<MyChargingState> findByMemberNo(Long memberNo) throws Exception;

    public List<MyParkingState> getMyParkingState (Long memberNo) throws  Exception;

}
