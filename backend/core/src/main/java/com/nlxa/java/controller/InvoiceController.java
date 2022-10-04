package com.nlxa.java.controller;

import com.nlxa.java.dto.invoice.*;
import com.nlxa.java.error.RequestException;
import com.nlxa.java.usecase.invoice.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.Future;

@Slf4j
@RestController
@RequestMapping(value = "/invoice")
public class InvoiceController {

    private GetAllInvoices getAllInvoices;
    private GetInvoiceByID getInvoiceByID;
    private AddInvoice addInvoice;
    private DeleteInvoice deleteInvoice;
    private UpdateInvoice updateInvoice;

    @Autowired
    public InvoiceController(GetAllInvoices getAllInvoices,
                             GetInvoiceByID getInvoiceByID,
                             AddInvoice addInvoice,
                             DeleteInvoice deleteInvoice,
                             UpdateInvoice updateInvoice){
        this.getAllInvoices = getAllInvoices;
        this.getInvoiceByID = getInvoiceByID;
        this.addInvoice = addInvoice;
        this.deleteInvoice = deleteInvoice;
        this.updateInvoice = updateInvoice;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<InvoiceListResponse> getAllInvoices() {
        log.info("Call to: InvoiceController.getAllInvoices()");
        InvoiceListResponse response = null;
        try {
            Future<InvoiceListResponse> result =this.getAllInvoices.execute();
            response = result.get();
        } catch (Exception e){
            log.error("Error in: InvoiceController.getAllInvoices()", e);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/byId")
    public InvoiceResponse getInvoiceByID(@RequestBody GetInvoiceByIdRequest request) {
        log.info("Call to: InvoiceController.getInvoiceByID()");
        InvoiceResponse response = null;
        try {
            response = this.getInvoiceByID.execute(request);
        } catch (RequestException  e){
            log.error("Error in: InvoiceController.getInvoiceByID() ->", e);
            throw e;
        } catch (Exception e){
            log.error("Error in: InvoiceController.getInvoiceByID() ->", e);
            throw new RequestException(e.getCause().getMessage(), "Error in: InvoiceController.getInvoiceByID()");
        }
        return response;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<InvoiceResponse> addInvoice(@RequestBody AddInvoiceRequest request){
        log.info("Call to: InvoiceController.addInvoice()");
        InvoiceResponse response = null;
        try {
            Future<InvoiceResponse> result = this.addInvoice.execute(request);
            response = result.get();
        }
        catch (Exception e){
            log.error("Error in: InvoiceController.addInvoice()", e);
        }
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<InvoiceResponse> deleteInvoice(@RequestBody DeleteInvoiceRequest request){
        log.info("Call to: InvoiceController.deleteInvoice()");
        try {
            this.deleteInvoice.execute(request);
        }
        catch (Exception e){
            log.error("Error in: InvoiceController.deleteInvoice()", e);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/update")
    public ResponseEntity<InvoiceResponse> updateInvoice(@RequestBody UpdateInvoiceRequest request){
        log.info("Call to: InvoiceController.updateInvoice()");
        InvoiceResponse response = null;
        try {
            Future<InvoiceResponse> result = this.updateInvoice.execute(request);
            response = result.get();
        }
        catch (Exception e){
            log.error("Error in: InvoiceController.updateInvoice()", e);
        }
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
