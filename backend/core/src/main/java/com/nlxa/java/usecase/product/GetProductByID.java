package com.nlxa.java.usecase.product;

import com.nlxa.java.dto.product.GetProductByIdRequest;
import com.nlxa.java.dto.product.ProductResponse;
import com.nlxa.java.error.RequestException;
import com.nlxa.java.product.ProductBusiness;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class GetProductByID {

    private ProductBusiness productBusiness;

    @Autowired
    public GetProductByID(ProductBusiness productBusiness) {
        this.productBusiness = productBusiness;
    }

    public ProductResponse execute(GetProductByIdRequest request){
        log.info("Call to: GetProductByID.execute()");
        ProductResponse response = null;
        String verifyInfo = verifyRequestInfo(request);
        if (verifyInfo.equals("")) {
            response = this.productBusiness.getByID(request);
        } else {
            log.error("Error in: GetProductByID.execute() -> Verify if th information is complete");
            throw new RequestException(verifyInfo, "Error in: GetProductByID.execute() -> Verify if th information is complete");
        }
        return response;
    }


    private String verifyRequestInfo(GetProductByIdRequest request){
        log.info("Call to: ProductBusiness.verifyRequestInfo()");
        String result = "";
        if (request == null || request.getProduct_id() == null){
            log.warn("Warn: The request or the request info is null");
            result = "Warn: The request or the request info is null";
        } else if (request.getProduct_id().equals("")) {
            log.warn("Warn: The request info is empty");
            result = "Warn: The request info is empty";
        }
        return result;
    }
}
