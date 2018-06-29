package com.vrubizha.eduspace.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "address")
public class Address implements Serializable {

    private int addressId;
    private String country;
    private String region;
    private String city;
    private String district;
    private String street;
    private String zipCode;
    private Set<Student> students;

    public Address() {
    }

    public Address(int addressId, String country, String region, String city, String district,
                   String street, String zipCode, Set<Student> students) {
        this.addressId = addressId;
        this.country = country;
        this.region = region;
        this.city = city;
        this.district = district;
        this.street = street;
        this.zipCode = zipCode;
        this.students = students;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_id")
    public int getAddressId() {
        return addressId;
    }
    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    @Column(name = "country")
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    @Column(name = "region")
    public String getRegion() {
        return region;
    }
    public void setRegion(String region) {
        this.region = region;
    }

    @Column(name = "city")
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    @Column(name = "district")
    public String getDistrict() {
        return district;
    }
    public void setDistrict(String district) {
        this.district = district;
    }

    @Column(name = "street")
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }

    @Column(name = "zipCode")
    public String getZipCode() {
        return zipCode;
    }
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }



    @OneToMany(fetch = FetchType.LAZY, mappedBy = "address")
    @Column(nullable = false)
    @JsonIgnore
    public Set<Student> getStudents() {
        return students;
    }
    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return getAddressId() == address.getAddressId() &&
                Objects.equals(getCountry(), address.getCountry()) &&
                Objects.equals(getRegion(), address.getRegion()) &&
                Objects.equals(getCity(), address.getCity()) &&
                Objects.equals(getDistrict(), address.getDistrict()) &&
                Objects.equals(getStreet(), address.getStreet()) &&
                Objects.equals(getZipCode(), address.getZipCode()) &&
                Objects.equals(getStudents(), address.getStudents());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getAddressId(), getCountry(), getRegion(), getCity(), getDistrict(), getStreet(), getZipCode(), getStudents());
    }
}
