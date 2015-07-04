package org.xiaoqiaotq.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * author: xiaoqiaotq@gmail.com
 * date  : 2015/6/26.
 */
@Entity
public class StringIdEntity {
    @Id
    private String id;
    private String nameee;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameee() {
        return nameee;
    }

    public void setNameee(String nameee) {
        this.nameee = nameee;
    }
}
