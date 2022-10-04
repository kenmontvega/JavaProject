package com.nlxa.java.controller;

import com.nlxa.java.dto.product.*;
import com.nlxa.java.error.RequestException;
import com.nlxa.java.usecase.product.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.Future;

@Slf4j
@RestController
@RequestMapping(value = "/product")
public class ProductController {

    private GetAllProducts getAllProducts;
    private GetProductByID getProductByID;
    private AddProduct addProduct;
    private DeleteProduct deleteProduct;
    private UpdateProduct updateProduct;

    @Autowired
    public ProductController(GetAllProducts getAllProducts,
                             GetProductByID getProductByID,
                             AddProduct addProduct,
                             DeleteProduct deleteProduct,
                             UpdateProduct updateProduct){
        this.getAllProducts = getAllProducts;
        this.getProductByID = getProductByID;
        this.addProduct = addProduct;
        this.deleteProduct = deleteProduct;
        this.updateProduct = updateProduct;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<ProductListResponse> getAllProducts() {
        log.info("Call to: ProductController.getAllProducts()");
        ProductListResponse response = null;
        try {
            Future<ProductListResponse> result =this.getAllProducts.execute();
            response = result.get();
        } catch (Exception e){
            log.error("Error in: ProductController.getAllProducts()", e);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/byId")
    public ProductResponse getProductByID(@RequestBody GetProductByIdRequest request) {
        log.info("Call to: ProductController.getProductByID()");
        ProductResponse response = null;
        try {
            response = this.getProductByID.execute(request);
        } catch (RequestException  e){
            log.error("Error in: ProductController.getProductByID() ->", e);
            throw e;
        } catch (Exception e){
            log.error("Error in: ProductController.getProductByID() ->", e);
            throw new RequestException(e.getCause().getMessage(), "Error in: ProductController.getProductByID()");
        }
        return response;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<ProductResponse> addProduct(@RequestBody AddProductRequest request){
        log.info("Call to: ProductController.addProduct()");
        ProductResponse response = null;
        try {
            Future<ProductResponse> result = this.addProduct.execute(request);
            response = result.get();
        }
        catch (Exception e){
            log.error("Error in: ProductController.addProduct()", e);
        }
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<ProductResponse> deleteProduct(@RequestBody DeleteProductRequest request){
        log.info("Call to: ProductController.deleteProduct()");
        try {
            this.deleteProduct.execute(request);
        }
        catch (Exception e){
            log.error("Error in: ProductController.deleteProduct()", e);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/update")
    public ResponseEntity<ProductResponse> updateProduct(@RequestBody UpdateProductRequest request){
        log.info("Call to: ProductController.updateProduct()");
        ProductResponse response = null;
        try {
            Future<ProductResponse> result = this.updateProduct.execute(request);
            response = result.get();
        }
        catch (Exception e){
            log.error("Error in: ProductController.updateProduct()", e);
        }
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
