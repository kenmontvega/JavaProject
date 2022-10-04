package com.nlxa.java.product;

import com.nlxa.java.domain.Product;
import com.nlxa.java.dto.product.*;
import com.nlxa.java.error.RequestException;
import com.nlxa.java.jpa.ProductJPAComponent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ProductBusiness {

    private ProductJPAComponent productJPAComponent;

    @Autowired
    public ProductBusiness(ProductJPAComponent ProductJPAComponent){
        this.productJPAComponent = productJPAComponent;
    }

    public ProductListResponse getAllProducts(){
        log.info("Call to: ProductBusiness.getAllProducts()");
        ProductListResponse response = null;
        try {
            response = new ProductListResponse();
            List<Product> products = this.productJPAComponent.getAll();

            for (Product productAux : products){
                response.getProductResponseList().add(new ProductResponse(productAux));
            }
        } catch (Exception e) {
            log.error("Error in: ProductBusiness.getAllProducts() -> Verify that the connection is correct");
        }

        return response;
    }

    public ProductResponse getByID(GetProductByIdRequest request){
        log.info("Call to: ProductBusiness.getByID()");
        ProductResponse response = null;
        try{
            Product product = this.productJPAComponent.getById(request.getProduct_id());
            response = new ProductResponse(product);
        } catch (RequestException e){
            log.error("Error in: ProductBusiness.getByID()", e);
            throw e;
        } catch (Exception e) {
            log.error("Error in: ProductBusiness.getByID() -> Verify that the connection is correct");
            throw new RequestException("Error in: ProductBusiness.getByID()", e.getMessage());
        }
        return response;
    }

    public ProductResponse addProduct(AddProductRequest request){
        log.info("Call to: ProductBusiness.addProduct()");
        ProductResponse response = null;
        try {
            Product product = this.productJPAComponent.save(new Product(request));
            response = new ProductResponse(product);
        } catch (Exception e) {
            log.error("Error in: ProductBusiness.addProduct() -> Verify that the connection is correct");
        }
        return response;
    }

    public void deleteProduct(DeleteProductRequest request){
        log.info("Call to: ProductBusiness.deleteProduct()");
        try {
            this.productJPAComponent.delete(new Product(request));
        } catch (Exception e) {
            log.error("Error in: ProductBusiness.deleteProduct() -> Verify that the connection is correct");
        }
    }

    public ProductResponse updateProduct(UpdateProductRequest request){
        log.info("Call to: ProductBusiness.updateProduct()");
        ProductResponse response = null;
        try {
            Product product = this.productJPAComponent.update(new Product(request));
            response = new ProductResponse(product);
        } catch (Exception e) {
            log.error("Error in: ProductBusiness.updateProduct() -> Verify that the connection is correct");
        }
        return response;
    }
}
