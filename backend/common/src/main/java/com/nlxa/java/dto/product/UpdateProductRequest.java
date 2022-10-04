package com.nlxa.java.dto.product;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Slf4j
@Data
public class UpdateProductRequest implements Serializable {

    private String productId;
    private String name;
    private String description;
    private float prize;
    private int quantity;

    public UpdateProductRequest() {
    }

    public UpdateProductRequest(String productId, String name, String description, float prize, int quantity) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.prize = prize;
        this.quantity = quantity;
    }
}
