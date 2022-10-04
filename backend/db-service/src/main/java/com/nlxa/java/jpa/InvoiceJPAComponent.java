package com.nlxa.java.jpa;

import com.nlxa.java.domain.Invoice;
import com.nlxa.java.error.RequestException;
import com.nlxa.java.impl.InvoiceImpl;
import com.nlxa.java.repository.InvoiceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class InvoiceJPAComponent implements InvoiceImpl {

    private InvoiceRepository invoiceRepository;

    @Autowired
    public InvoiceJPAComponent(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public List<Invoice> getAll() {
        log.info("Call to: InvoiceJPAComponent.getAll()");
        List<Invoice> response = null;
        try {
            response = this.invoiceRepository.findAll();
        } catch (Exception e){
            log.error("Error in: InvoiceJPAComponent.getAll() -> " + e.getMessage(), e);
        }
        return response;
    }

    @Override
    public Invoice getById(String s) {
        log.info("Call to: InvoiceJPAComponent.getById()");
        Invoice response = null;
        try {
            response = this.invoiceRepository.findById(s).orElse(null); //como es un optional le ponemos que retorne uno o nulo
        } catch (Exception e){
            log.error("Error in: InvoiceJPAComponent.getById() -> " + e.getMessage(), e);
            throw new RequestException("Error in: InvoiceJPAComponent.getById()", e.getMessage());
        }
        return response;
    }

    @Override
    public Invoice save(Invoice type) {
        log.info("Call to: InvoiceJPAComponent.save()");
        Invoice response = null;
        try {
            response = this.invoiceRepository.save(type);
        } catch (Exception e){
            log.error("Error in: InvoiceJPAComponent.save() -> " + e.getMessage(), e);
        }
        return response;
    }

    @Override
    public Invoice update(Invoice type) {
        log.info("Call to: InvoiceJPAComponent.update()");
        Invoice response = null;
        try {
            response = this.invoiceRepository.save(type);
        } catch (Exception e){
            log.error("Error in: InvoiceJPAComponent.update() -> " + e.getMessage(), e);
        }
        return response;
    }

    @Override
    public void delete(Invoice type) {
        log.info("Call to: InvoiceJPAComponent.delete()");
        try {
            this.invoiceRepository.delete(type);
        } catch (Exception e){
            log.error("Error in: InvoiceJPAComponent.delete() -> " + e.getMessage(), e);
        }
    }

    @Override
    public void deleteById(String s) {
        log.info("Call to: InvoiceJPAComponent.deleteById()");
        try {
            this.invoiceRepository.deleteById(s);
        } catch (Exception e){
            log.error("Error in: InvoiceJPAComponent.delete() -> " + e.getMessage(), e);
        }
    }

    @Override
    public Boolean verifyValueID(String invoice_id) {
        return null;
    }
}
