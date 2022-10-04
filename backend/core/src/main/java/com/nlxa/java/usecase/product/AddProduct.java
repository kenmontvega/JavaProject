package com.nlxa.java.usecase.product;

import com.nlxa.java.config.AsyncResponse;
import com.nlxa.java.dto.product.AddProductRequest;
import com.nlxa.java.dto.product.ProductResponse;
import com.nlxa.java.product.ProductBusiness;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Slf4j
@Service
public class AddProduct {

    private ProductBusiness productBusiness;

    @Autowired
    public AddProduct(ProductBusiness productBusiness) {
        this.productBusiness = productBusiness;
    }

    @Async
    public Future<ProductResponse> execute(AddProductRequest request){
        log.info("Call to: AddProduct.execute()");
        AsyncResponse<ProductResponse> response = null;
        try {
            response = new AsyncResponse<>(this.productBusiness.addProduct(request));
        } catch (Exception e){
            log.error("Error in: AddProduct.execute()", e);
        }
        return response;
    }
}
