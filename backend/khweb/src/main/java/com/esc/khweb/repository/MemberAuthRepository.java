package com.esc.khweb.repository;

import com.esc.khweb.entity.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface MemberAuthRepository extends JpaRepository<Administrator, Long> {

    @Query("select i.auth from Administrator i where i.memberNo = :memberNo")
    String getAuth(Long memberNo);
}
