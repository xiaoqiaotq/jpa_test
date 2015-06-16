package org.xiaoqiaotq.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * author: xiaoqiaotq@gmail.com
 * date  : 2015/6/15.
 */
@Entity
public class BankAccount {
    @Id
    @GeneratedValue
    private Integer id;

    public BankAccount(String username, int money) {
        this.username = username;
        this.money = money;
    }

    public BankAccount() {
    }

    private String username;
    private int money;

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
