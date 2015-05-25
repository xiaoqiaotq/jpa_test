package org.xiaoqiaotq.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * author: xiaoqiaotq@gmail.com
 * date  : 2015/5/25.
 */
@MappedSuperclass
public abstract class Node1<T> {
    @ManyToOne
    private T parent;
    @OneToMany(mappedBy = "parent")
    @OrderBy
    private Set<T> children;

    public void setParent(T parent) {
        this.parent = parent;
    }

    public Set<T> getChildren() {
        return children;
    }

    public void setChildren(Set<T> children) {
        this.children = children;
    }

    public T getParent() {
        return parent;
    }

}
