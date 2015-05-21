package org.xiaoqiaotq.domain;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * author: xiaoqiaotq@gmail.com
 * date  : 2015/5/12.
 */
@Entity
public class Teacher extends User {
    @OneToMany
    private List<Student> students;
}
