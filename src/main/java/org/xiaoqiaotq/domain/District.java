package org.xiaoqiaotq.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * 地区
 * author: xiaoqiaotq@gmail.com
 * date  : 2015/5/25.
 */
@Entity
public class District extends Node1<District>{
    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private boolean hasMoney;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date date=new Date();
    public boolean isHasMoney() {
        return hasMoney;
    }

    public void setHasMoney(boolean hasMoney) {
        this.hasMoney = hasMoney;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "District{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
