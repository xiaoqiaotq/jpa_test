package org.xiaoqiaotq.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * author: xiaoqiaotq@gmail.com
 * date  : 2015/5/12.
 */
@Entity
public class Dog implements Serializable{
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "nick_name")
    private String nickname;

    @OneToOne(mappedBy = "dog1")
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
