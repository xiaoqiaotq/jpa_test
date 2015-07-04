package org.xiaoqiaotq.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.xiaoqiaotq.domain.StringIdEntity;

/**
 * author: xiaoqiaotq@gmail.com
 * date  : 2015/6/26.
 */
public interface StringIdEntityRepository extends JpaRepository<StringIdEntity,String> {
}
