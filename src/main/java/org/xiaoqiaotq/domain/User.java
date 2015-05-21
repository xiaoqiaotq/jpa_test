package org.xiaoqiaotq.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * author: xiaoqiaotq@gmail.com
 * date  : 2015/5/12.
 */
@Entity
public class User {
    @Id
    @GeneratedValue
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Embedded
    private Address address;

    @ElementCollection
    @CollectionTable(name = "person_has_emails")
    private Set<String> emails;

    @OneToOne
    @JoinColumn(name="abcd",referencedColumnName="nick_name")
    private Dog dog1;

    public List<CarBrands> getBrands() {
        return brands;
    }

    public Dog getDog1() {
        return dog1;
    }

    public void setDog1(Dog dog1) {
        this.dog1 = dog1;
    }

    public void setBrands(List<CarBrands> brands) {
        this.brands = brands;
    }

    public Set<String> getEmails() {
        return emails;
    }

    public void setEmails(Set<String> emails) {
        this.emails = emails;
    }

    @ElementCollection(targetClass = CarBrands.class)
    @Enumerated(EnumType.STRING)
    @JoinColumn
    private List<CarBrands> brands;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    public static enum CarBrands {
        FORD, FIAT, SUZUKI
    }
}
