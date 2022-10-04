package com.nlxa.java.usecase.product;

import com.nlxa.java.config.AsyncResponse;
import com.nlxa.java.dto.product.ProductResponse;
import com.nlxa.java.dto.product.UpdateProductRequest;
import com.nlxa.java.product.ProductBusiness;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Slf4j
@Service
public class UpdateProduct {

    private ProductBusiness productBusiness;

    @Autowired
    public UpdateProduct(ProductBusiness productBusiness) {
        this.productBusiness = productBusiness;
    }

    @Async
    public Future<ProductResponse> execute(UpdateProductRequest request){
        log.info("Call to: UpdateProduct.execute()");
        AsyncResponse<ProductResponse> response = null;
        try {
            response = new AsyncResponse<>(this.productBusiness.updateProduct(request));
        } catch (Exception e){
            log.error("Error in: UpdateProduct.execute()", e);
        }
        return response;
    }
}