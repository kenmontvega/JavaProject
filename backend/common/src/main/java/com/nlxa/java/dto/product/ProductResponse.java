package com.nlxa.java.dto.product;

import com.nlxa.java.domain.Product;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Slf4j
@Data
public class ProductResponse implements Serializable {

    private String productId;
    private String name;
    private String description;
    private float prize;
    private int quantity;

    public ProductResponse() {
    }

    public ProductResponse(Product product){ toProductResponse(product);}

    public void toProductResponse(Product product) {
        setProductId(product.getProduct_id());
        setName(product.getName());
        setDescription(product.getDescription());
        setPrize(product.getPrize());
        setQuantity(product.getQuantity());
    }
}
