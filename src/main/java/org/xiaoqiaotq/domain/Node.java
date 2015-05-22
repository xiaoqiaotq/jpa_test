package org.xiaoqiaotq.domain;


import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "tree")
public class Node {
    @Id
    @GeneratedValue
    private Integer id;

    @OneToMany
    @OrderColumn
    @JoinColumn(name = "parent_id")
    private List<Node> children = new LinkedList<>();
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id", insertable = false, updatable = false)
    private Node parent;
}