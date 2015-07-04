package org.xiaoqiaotq.domain.OneToMany;

import javax.persistence.*;
import java.util.Set;

/**
 * author: xiaoqiaotq@gmail.com
 * date  : 2015/7/3.
 */
@Entity
public class One {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn
    private Set<Many> manySet;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<Many> getManySet() {
        return manySet;
    }

    public void setManySet(Set<Many> manySet) {
        this.manySet = manySet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
