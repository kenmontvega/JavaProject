package com.nlxa.java.dto.product;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Slf4j
@Data
public class GetProductByIdRequest implements Serializable {

    private String product_id;

    public GetProductByIdRequest() {
    }
}
