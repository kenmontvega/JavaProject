package com.nlxa.java.jpa;

import com.nlxa.java.domain.Product;
import com.nlxa.java.error.RequestException;
import com.nlxa.java.impl.ProductImpl;
import com.nlxa.java.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class ProductJPAComponent implements ProductImpl {

    private ProductRepository productRepository;

    @Autowired
    public ProductJPAComponent(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAll() {
        log.info("Call to: ProductJPAComponent.getAll()");
        List<Product> response = null;
        try {
            response = this.productRepository.findAll();
        } catch (Exception e){
            log.error("Error in: ProductJPAComponent.getAll() -> " + e.getMessage(), e);
        }
        return response;
    }

    @Override
    public Product getById(String s) {
        log.info("Call to: ProductJPAComponent.getById()");
        Product response = null;
        try {
            response = this.productRepository.findById(s).orElse(null); //como es un optional le ponemos que retorne uno o nulo
        } catch (Exception e){
            log.error("Error in: ProductJPAComponent.getById() -> " + e.getMessage(), e);
            throw new RequestException("Error in: ProductJPAComponent.getById()", e.getMessage());
        }
        return response;
    }

    @Override
    public Product save(Product type) {
        log.info("Call to: ProductJPAComponent.save()");
        Product response = null;
        try {
            response = this.productRepository.save(type);
        } catch (Exception e){
            log.error("Error in: ProductJPAComponent.save() -> " + e.getMessage(), e);
        }
        return response;
    }

    @Override
    public Product update(Product type) {
        log.info("Call to: ProductJPAComponent.update()");
        Product response = null;
        try {
            response = this.productRepository.save(type);
        } catch (Exception e){
            log.error("Error in: ProductJPAComponent.update() -> " + e.getMessage(), e);
        }
        return response;
    }

    @Override
    public void delete(Product type) {
        log.info("Call to: ProductJPAComponent.delete()");
        try {
            this.productRepository.delete(type);
        } catch (Exception e){
            log.error("Error in: ProductJPAComponent.delete() -> " + e.getMessage(), e);
        }
    }

    @Override
    public void deleteById(String s) {
        log.info("Call to: ProductJPAComponent.deleteById()");
        try {
            this.productRepository.deleteById(s);
        } catch (Exception e){
            log.error("Error in: ProductJPAComponent.delete() -> " + e.getMessage(), e);
        }
    }

    @Override
    public Boolean verifyValueID(String product_id) {
        return null;
    }
}
