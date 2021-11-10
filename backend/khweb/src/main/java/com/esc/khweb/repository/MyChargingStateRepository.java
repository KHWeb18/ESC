package com.esc.khweb.repository;

import com.esc.khweb.entity.Board;
import com.esc.khweb.entity.Member;
import com.esc.khweb.entity.MyChargingState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MyChargingStateRepository extends JpaRepository<MyChargingState,Long> {

    List<MyChargingState> findByMemberNo(Long memberNo);

    @Query("select j.addr from MyChargingState j where j.memberNo =:memberNo")
    List<MyChargingState> findByaddr(Long memberNo);
}
