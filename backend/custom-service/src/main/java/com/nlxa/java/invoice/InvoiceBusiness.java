package com.nlxa.java.invoice;

import com.nlxa.java.domain.Invoice;
import com.nlxa.java.dto.invoice.*;
import com.nlxa.java.error.RequestException;
import com.nlxa.java.jpa.InvoiceJPAComponent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class InvoiceBusiness {

    private InvoiceJPAComponent invoiceJPAComponent;

    @Autowired
    public InvoiceBusiness(InvoiceJPAComponent invoiceJPAComponent){
        this.invoiceJPAComponent = invoiceJPAComponent;
    }

    public InvoiceListResponse getAllInvoices(){
        log.info("Call to: InvoiceBusiness.getAllInvoices()");
        InvoiceListResponse response = null;
        try {
            response = new InvoiceListResponse();
            List<Invoice> invoices = this.invoiceJPAComponent.getAll();

            for (Invoice invoiceAux : invoices){
                response.getInvoiceResponseList().add(new InvoiceResponse(invoiceAux));
            }
        } catch (Exception e) {
            log.error("Error in: InvoiceBusiness.getAllInvoices() -> Verify that the connection is correct");
        }

        return response;
    }

    public InvoiceResponse getByID(GetInvoiceByIdRequest request){
        log.info("Call to: InvoiceBusiness.getByID()");
        InvoiceResponse response = null;
        try{
            Invoice invoice = this.invoiceJPAComponent.getById(request.getInvoice_id());
            response = new InvoiceResponse(invoice);
        } catch (RequestException e){
            log.error("Error in: InvoiceBusiness.getByID()", e);
            throw e;
        } catch (Exception e) {
            log.error("Error in: InvoiceBusiness.getByID() -> Verify that the connection is correct");
            throw new RequestException("Error in: InvoiceBusiness.getByID()", e.getMessage());
        }
        return response;
    }

    public InvoiceResponse addInvoice(AddInvoiceRequest request){
        log.info("Call to: InvoiceBusiness.addInvoice()");
        InvoiceResponse response = null;
        try {
            Invoice invoice = this.invoiceJPAComponent.save(new Invoice(request));
            response = new InvoiceResponse(invoice);
        } catch (Exception e) {
            log.error("Error in: InvoiceBusiness.addInvoice() -> Verify that the connection is correct");
        }
        return response;
    }

    public void deleteInvoice(DeleteInvoiceRequest request){
        log.info("Call to: InvoiceBusiness.deleteInvoice()");
        try {
            this.invoiceJPAComponent.delete(new Invoice(request));
        } catch (Exception e) {
            log.error("Error in: InvoiceBusiness.deleteInvoice() -> Verify that the connection is correct");
        }
    }

    public InvoiceResponse updateInvoice(UpdateInvoiceRequest request){
        log.info("Call to: InvoiceBusiness.updateInvoice()");
        InvoiceResponse response = null;
        try {
            Invoice invoice = this.invoiceJPAComponent.update(new Invoice(request));
            response = new InvoiceResponse(invoice);
        } catch (Exception e) {
            log.error("Error in: InvoiceBusiness.updateInvoice() -> Verify that the connection is correct");
        }
        return response;
    }
}
