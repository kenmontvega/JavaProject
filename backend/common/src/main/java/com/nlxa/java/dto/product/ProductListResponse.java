package com.nlxa.java.dto.product;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Data
public class ProductListResponse implements Serializable {

    private List<ProductResponse> productResponseList;

    public ProductListResponse() {
        this.productResponseList = new ArrayList<>();
    }

    public ProductListResponse(List<ProductResponse> productResponses) {
        this.productResponseList = productResponses;
    }

}
