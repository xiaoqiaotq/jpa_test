package org.xiaoqiaotq.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * 自定义用户分组
 * author: xiaoqiaotq@gmail.com
 * date  : 2015/5/19.
 */
@Entity
public class CustomUserGroup {
    @Id
    @GeneratedValue
    private Long id;

    private String groupName;

    @ManyToMany(cascade ={CascadeType.PERSIST,CascadeType.MERGE})
    private Set<User> users;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
