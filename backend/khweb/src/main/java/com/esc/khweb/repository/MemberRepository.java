package com.esc.khweb.repository;

import com.esc.khweb.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
        import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query("select i.memberId from Member i where i.email = :email")
    List FindByUserId(String email);

    @Query("select i from Member i where i.memberId = :memberId")
    Optional<Member> FindBymemberImp(String memberId);

    @Query("select i.memberNo from Member i where i.memberId = :memberId")
    Long findByMemberNo(String memberId);

    @Query("select i.status from Member i where i.memberId = :memberId")
    String findByMemberStatus(String memberId);

    @Transactional
    @Modifying
    @Query("UPDATE Member b set b.status = :status where b.memberNo = :memberNo")
    void IDban(Long memberNo, String status);

    @Transactional
    @Modifying
    @Query("UPDATE Member b set b.status = :status where b.memberNo = :memberNo")
    void jailbreak(Long memberNo, String status);

}
