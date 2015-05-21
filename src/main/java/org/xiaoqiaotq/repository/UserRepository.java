package org.xiaoqiaotq.repository;

import org.springframework.data.repository.CrudRepository;
import org.xiaoqiaotq.domain.User;

/**
 * author: xiaoqiaotq@gmail.com
 * date  : 2015/5/19.
 */
public interface UserRepository  extends CrudRepository<User,Long>{
}
