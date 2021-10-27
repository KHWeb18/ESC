package com.esc.khweb.repository;

import com.esc.khweb.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
        import org.springframework.data.repository.query.Param;

        import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query("select i.memberId from Member i where i.email = :email")
    List FindByUserId(String email);

    @Query("select i from Member i where i.memberId = :memberId")
    Optional<Member> FindBymemberImp(String memberId);

    @Query("select i.memberNo from Member i where i.memberId = :memberId")
    Long findByMemberNo(String memberId);


}
