package org.xiaoqiaotq.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * author: xiaoqiaotq@gmail.com
 * date  : 2015/5/12.
 */
@Entity
public class Student implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    private  String name;
    @OneToMany(cascade = CascadeType.PERSIST)
    private Set<Dog> dogs;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    public Set<Dog> getDogs() {
        return dogs;
    }

    public void setDogs(Set<Dog> dogs) {
        this.dogs = dogs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
