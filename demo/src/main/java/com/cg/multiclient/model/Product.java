package com.cg.multiclient.model;

 

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import com.cg.multiclient.model.enumeration.Size;

 

/**
 * Product sold by the Online store
 */
@Entity
@Table(name = "product")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Product implements Serializable {

 

    private static final long serialVersionUID = 1L;

 

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

 

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

 

    @Column(name = "description")
    private String description;

 

    @NotNull
    @DecimalMin(value = "0")
    @Column(name = "price", precision = 21, scale = 2, nullable = false)
    private double price;

 

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "item_size", nullable = false)
    private Size itemSize;

 

    @Lob
    @Column(name = "image")
    private byte[] image;

 

    @Column(name = "image_content_type")
    private String imageContentType;

 

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = { "products" }, allowSetters = true)
    private ProductCategory productCategory;

 

    public Long getId() {
        return id;
    }

 

    public void setId(Long id) {
        this.id = id;
    }

 

    public Product id(Long id) {
        this.id = id;
        return this;
    }

 

    public String getName() {
        return this.name;
    }

 

    public Product name(String name) {
        this.name = name;
        return this;
    }

 

    public void setName(String name) {
        this.name = name;
    }

 

    public String getDescription() {
        return this.description;
    }

 

    public Product description(String description) {
        this.description = description;
        return this;
    }

 

    public void setDescription(String description) {
        this.description = description;
    }

 

    public double getPrice() {
        return this.price;
    }

 

    public Product price(double price) {
        this.price = price;
        return this;
    }

 

    public void setPrice(double price) {
        this.price = price;
    }

 

    public Size getItemSize() {
        return this.itemSize;
    }

 

    public Product itemSize(Size itemSize) {
        this.itemSize = itemSize;
        return this;
    }

 

    public void setItemSize(Size itemSize) {
        this.itemSize = itemSize;
    }

 

    public byte[] getImage() {
        return this.image;
    }

 

    public Product image(byte[] image) {
        this.image = image;
        return this;
    }

 

    public void setImage(byte[] image) {
        this.image = image;
    }

 

    public String getImageContentType() {
        return this.imageContentType;
    }

 

    public Product imageContentType(String imageContentType) {
        this.imageContentType = imageContentType;
        return this;
    }

 

    public void setImageContentType(String imageContentType) {
        this.imageContentType = imageContentType;
    }

 

    public ProductCategory getProductCategory() {
        return this.productCategory;
    }

 

    public Product productCategory(ProductCategory productCategory) {
        this.setProductCategory(productCategory);
        return this;
    }

 

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

 


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Product)) {
            return false;
        }
        return id != null && id.equals(((Product) o).id);
    }

 

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

 

    @Override
    public String toString() {
        return "Product{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", description='" + getDescription() + "'" +
            ", price=" + getPrice() +
            ", itemSize='" + getItemSize() + "'" +
            ", image='" + getImage() + "'" +
            ", imageContentType='" + getImageContentType() + "'" +
            "}";
    }
}