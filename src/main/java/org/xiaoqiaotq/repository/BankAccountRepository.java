package org.xiaoqiaotq.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.xiaoqiaotq.domain.BankAccount;

/**
 * author: xiaoqiaotq@gmail.com
 * date  : 2015/6/15.
 */
@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount,Integer> {
    BankAccount findByUsername(String username);

    @Modifying()
    @Query("update BankAccount b set b.money=b.money +1 where b.id= ?1")
    void incrementMoney(Integer id);
}
