package com.cg.multiclient.model;

 

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;

 

/**
 * A CustomerDetails.
 */
@Entity
@Table(name = "customer")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Customer implements Serializable {

 

    private static final long serialVersionUID = 1L;

 

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

 

    @NotNull
    @Column(name = "phone", nullable = false)
    private String phone;

 

    @NotNull
    @Column(name = "address_line_1", nullable = false)
    private String addressLine1;

 

    @Column(name = "address_line_2")
    private String addressLine2;

 

    @NotNull
    @Column(name = "city", nullable = false)
    private String city;

 

    @NotNull
    @Column(name = "country", nullable = false)
    private String country;

 

    public Long getId() {
        return id;
    }

 

    public void setId(Long id) {
        this.id = id;
    }

 

    public Customer id(Long id) {
        this.id = id;
        return this;
    }

 

    
    public String getPhone() {
        return this.phone;
    }

 

    public Customer phone(String phone) {
        this.phone = phone;
        return this;
    }

 

    public void setPhone(String phone) {
        this.phone = phone;
    }

 

    public String getAddressLine1() {
        return this.addressLine1;
    }

 

    public Customer addressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
        return this;
    }

 

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

 

    public String getAddressLine2() {
        return this.addressLine2;
    }

 

    public Customer addressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
        return this;
    }

 

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

 

    public String getCity() {
        return this.city;
    }

 

    public Customer city(String city) {
        this.city = city;
        return this;
    }

 

    public void setCity(String city) {
        this.city = city;
    }

 

    public String getCountry() {
        return this.country;
    }

 

    public Customer country(String country) {
        this.country = country;
        return this;
    }

 

    public void setCountry(String country) {
        this.country = country;
    }

 

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Customer)) {
            return false;
        }
        return id != null && id.equals(((Customer) o).id);
    }

 

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

 

    @Override
    public String toString() {
        return "CustomerDetails{" +
            "id=" + getId() +
            ", phone='" + getPhone() + "'" +
            ", addressLine1='" + getAddressLine1() + "'" +
            ", addressLine2='" + getAddressLine2() + "'" +
            ", city='" + getCity() + "'" +
            ", country='" + getCountry() + "'" +
            "}";
    }
}