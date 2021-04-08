package com.cg.multiclient.model;

 

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

 

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

 


/**
 * A ShoppingCart.
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "shopping_cart")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

 

public class ShoppingCart implements Serializable{

 


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

 

    @NotNull
    @Column(name = "placed_date", nullable = false)
    private String placedDate;

 

    @NotNull
    @Column(name = "status", nullable = false)
    private String status;

 

    @NotNull
    @Column(name = "total_price", precision = 21, scale = 2, nullable = false)
    private double totalPrice;

 

    
    @Column(name = "payment_method", nullable = false)
    private String paymentMethod;

 


    public Long getId() {
        return id;
    }

 

    public void setId(Long id) {
        this.id = id;
    }

 

    public ShoppingCart id(Long id) {
        this.id = id;
        return this;
    }

 

    public String getPlacedDate() {
        return this.placedDate;
    }

 

    public ShoppingCart placedDate(String placedDate) {
        this.placedDate = placedDate;
        return this;
    }

 

    public void setPlacedDate(String placedDate) {
        this.placedDate = placedDate;
    }

 

    public String getStatus() {
        return this.status;
    }

 

    public ShoppingCart status(String status) {
        this.status = status;
        return this;
    }

 

    public void setStatus(String status) {
        this.status = status;
    }

 

    public double getTotalPrice() {
        return this.totalPrice;
    }

 

    public ShoppingCart totalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
        return this;
    }

 

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

 

    public String getPaymentMethod() {
        return this.paymentMethod;
    }

 

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

 

    public ShoppingCart() {
    }

 

    public ShoppingCart(@NotNull final String placedDate, @NotNull final String status, @NotNull @DecimalMin(value = "0") final double totalPrice, @NotNull final String paymentMethod, @NotNull final Customer customer) {
        this.placedDate = placedDate;
        this.status = status;
        this.totalPrice = totalPrice;
        this.paymentMethod = paymentMethod;
        //this.customer = customer;
    }

 

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ShoppingCart)) {
            return false;
        }
        return id != null && id.equals(((ShoppingCart) o).id);
    }

 

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

 

    @Override
    public String toString() {
        return "ShoppingCart{" +
            "id=" + getId() +
            ", placedDate='" + getPlacedDate() + "'" +
            ", status='" + getStatus() + "'" +
            ", totalPrice=" + getTotalPrice() +
            ", paymentMethod='" + getPaymentMethod() + "'" +
            "}";
    }
}