package com.esc.khweb.repository;

import com.esc.khweb.entity.MyCarState;
import com.esc.khweb.entity.MyChargingState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MyCarStateRepository extends JpaRepository<MyCarState,Long> {

    @Query("select i from MyCarState i where i.memberNo = :memberNo")
    List<MyCarState> findByMemberall (Long memberNo);


}
