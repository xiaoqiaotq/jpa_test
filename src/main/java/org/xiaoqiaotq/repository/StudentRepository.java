package org.xiaoqiaotq.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.xiaoqiaotq.domain.Student;

/**
 * author: xiaoqiaotq@gmail.com
 * date  : 2015/5/19.
 */
@Repository
public interface StudentRepository extends CrudRepository<Student,Long> {
}
