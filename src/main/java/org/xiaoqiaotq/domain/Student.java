package org.xiaoqiaotq.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * author: xiaoqiaotq@gmail.com
 * date  : 2015/5/12.
 */
@Entity
public class Student  {
    @Id
    @GeneratedValue
    private Long id;
}
