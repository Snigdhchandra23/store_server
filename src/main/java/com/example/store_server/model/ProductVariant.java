package com.example.store_server.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

//import org.springframework.data.elasticsearch.annotations.Document;


@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
//@Document(indexName = "product_variants")
@Table(name="product_variant")
@Entity
public class ProductVariant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer sku;
    private String name;
    private Integer price;
    private String imageUrl1;
    private String imageUrl2;
    private String imageUrl3;
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;

    public void setSku(Integer sku) {
        this.sku = sku;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setImageUrl1(String imageUrl1) {
        this.imageUrl1 = imageUrl1;
    }

    public void setImageUrl2(String imageUrl2) {
        this.imageUrl2 = imageUrl2;
    }

    public void setImageUrl3(String imageUrl3) {
        this.imageUrl3 = imageUrl3;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
