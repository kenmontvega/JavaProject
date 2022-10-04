package com.nlxa.java.domain;

import com.nlxa.java.dto.product.AddProductRequest;
import com.nlxa.java.dto.product.DeleteProductRequest;
import com.nlxa.java.dto.product.UpdateProductRequest;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "product")
public class Product implements Serializable {

    @Id
    @Column(name = "product_id")
    @GeneratedValue(generator = "ID")
    @GenericGenerator(
            name = "ID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String product_id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "prize")
    private float prize;
    @Column(name = "quantity")
    private int quantity;

    public Product() {}

    public Product(AddProductRequest request) {
        this.product_id = "";
        this.name = request.getDescription();
        this.description = request.getDescription();
        this.prize = request.getPrize();
        this.quantity = request.getQuantity();
    }

    public Product(DeleteProductRequest request) {
        this.product_id = request.getProductId();
    }

    public Product(UpdateProductRequest request) {
        this.product_id = request.getProductId();
        this.name = request.getDescription();
        this.description = request.getDescription();
        this.prize = request.getPrize();
        this.quantity = request.getQuantity();
    }
}
