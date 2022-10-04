package com.nlxa.java.usecase.product;

import com.nlxa.java.dto.product.DeleteProductRequest;
import com.nlxa.java.product.ProductBusiness;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DeleteProduct {

    private ProductBusiness productBusiness;

    @Autowired
    public DeleteProduct(ProductBusiness productBusiness) {
        this.productBusiness = productBusiness;
    }

    @Async
    public void execute(DeleteProductRequest request){
        log.info("Call to: DeleteProduct.execute()");
        try {
            this.productBusiness.deleteProduct(request);
        } catch (Exception e){
            log.error("Error in: GetAllProducts.execute()", e);
        }
    }
}
