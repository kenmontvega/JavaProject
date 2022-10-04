package com.nlxa.java.dto.product;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Slf4j
@Data
public class AddProductRequest implements Serializable {

    private String name;
    private String description;
    private float prize;
    private int quantity;

    private AddProductRequest(){}

    private AddProductRequest(String name, String description, float prize, int quantity) {
        this.name = name;
        this.description = description;
        this.prize = prize;
        this.quantity = quantity;
    }
}
