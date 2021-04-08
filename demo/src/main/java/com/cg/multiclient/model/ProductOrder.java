package com.cg.multiclient.model;

 

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

 

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import io.swagger.annotations.ApiModelProperty;

 

/**
 * A ProductOrder.
 */
@Entity
@Table(name = "product_order")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class ProductOrder implements Serializable {

 

    private static final long serialVersionUID = 1L;

 
    @ApiModelProperty(notes = "Id of the Product Order", name="id", required=true, value="Order Id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

 
    @ApiModelProperty(notes = "Quantitiy of the order", name="id", required=true, value="Order Quantity")
    @NotNull
    @Min(value = 0)
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

 
    @ApiModelProperty(notes = "Total Price Of the Order", name="id", required=true, value="Total Price")
    @NotNull
    @Column(name = "total_price", precision = 21, scale = 2, nullable = false)
    private double totalPrice;

 

    
    public ProductOrder(Long id, @NotNull @Min(0) Integer quantity, @NotNull double totalPrice) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
	}



	public ProductOrder() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Long getId() {
        return id;
    }

 

    public void setId(Long id) {
        this.id = id;
    }

 

    public ProductOrder id(Long id) {
        this.id = id;
        return this;
    }

 

    public Integer getQuantity() {
        return this.quantity;
    }

 

    public ProductOrder quantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

 

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

 

    public double getTotalPrice() {
        return this.totalPrice;
    }

 

    public ProductOrder totalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
        return this;
    }

 

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

 

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ProductOrder)) {
            return false;
        }
        return id != null && id.equals(((ProductOrder) o).id);
    }

 

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

 

    @Override
    public String toString() {
        return "ProductOrder{" +
            "id=" + getId() +
            ", quantity=" + getQuantity() +
            ", totalPrice=" + getTotalPrice() +
            "}";
    }
}