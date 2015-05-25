package org.xiaoqiaotq.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.xiaoqiaotq.domain.District;

/**
 * author: xiaoqiaotq@gmail.com
 * date  : 2015/5/25.
 */
@Repository
public interface DistrictRepository extends JpaRepository<District,Integer>{
    @Query("from District d where d.parent is null")
    District findRoot();
//    @Modifying
//    @Query("update District d set d.hasMoney=!hasMoney where d.id=?1")
//    void toggleBoolean(int id);
}
