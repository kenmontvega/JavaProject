package com.nlxa.java.dto.product;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Slf4j
@Data
public class DeleteProductRequest implements Serializable {

    private String productId;

    public DeleteProductRequest() {
    }

    public DeleteProductRequest(String productId) {
        this.productId = productId;
    }
}
