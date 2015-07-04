package org.xiaoqiaotq.domain.OneToMany;

import javax.persistence.*;

/**
 * author: xiaoqiaotq@gmail.com
 * date  : 2015/7/3.
 */
@Entity
public class Many{
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    @ManyToOne
    private One one;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public One getOne() {
        return one;
    }

    public void setOne(One one) {
        this.one = one;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
