package org.xiaoqiaotq.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * author: xiaoqiaotq@gmail.com
 * date  : 2015/5/12.
 */
@Entity
public class Dog {
    @Id
    private Long id;

    @Column(name = "nick_name")
    private String nickname;

    @OneToOne(mappedBy = "dog1")
    private User user;
}
