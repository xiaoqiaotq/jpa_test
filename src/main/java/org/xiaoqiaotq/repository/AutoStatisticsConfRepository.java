package org.xiaoqiaotq.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.xiaoqiaotq.domain.AutoStatisticsConf;

/**
 * author: xiaoqiaotq@gmail.com
 * date  : 2015/6/17.
 */
@Repository
public interface AutoStatisticsConfRepository extends JpaRepository<AutoStatisticsConf,Integer> {
}
