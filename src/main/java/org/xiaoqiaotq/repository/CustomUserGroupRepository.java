package org.xiaoqiaotq.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.xiaoqiaotq.domain.CustomUserGroup;
import org.xiaoqiaotq.domain.User;

import java.util.List;

/**
 * author: xiaoqiaotq@gmail.com
 * date  : 2015/5/19.
 */
@Repository
public interface CustomUserGroupRepository extends JpaRepository<CustomUserGroup,Long>,JpaSpecificationExecutor<CustomUserGroup>{
    @Query("select u from CustomUserGroup c join c.users u where c.id=?1")
    public List<User> findUsers(Long id);

    @Query("select u from CustomUserGroup c join c.users u  ")
    public List<User> findUsers2(Pageable id);

    @Query("select u from CustomUserGroup c join c.users u where c.id=?1")
    public Page<User> findUsers3(Long id,Pageable pageable);
    @Query("select u from CustomUserGroup c join c.users u where c.id=?1")
    public Page<User> findUsers4(Long id,Pageable pageable,Specification specification);
}
