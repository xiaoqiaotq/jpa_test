package org.xiaoqiaotq.domain;

import javax.persistence.Embeddable;

/**
 * author: xiaoqiaotq@gmail.com
 * date  : 2015/5/12.
 */
@Embeddable
public class Address {
    //区
    private String district;
    //街道
    private String street;
    //邮编
    private int postcode;

    public Address() {
    }

    public Address(String district, String street, int postcode) {

        this.district = district;
        this.street = street;
        this.postcode = postcode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }
}
