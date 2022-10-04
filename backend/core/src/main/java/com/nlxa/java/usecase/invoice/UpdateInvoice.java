package com.nlxa.java.usecase.invoice;

import com.nlxa.java.config.AsyncResponse;
import com.nlxa.java.dto.invoice.InvoiceResponse;
import com.nlxa.java.dto.invoice.UpdateInvoiceRequest;
import com.nlxa.java.invoice.InvoiceBusiness;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Slf4j
@Service
public class UpdateInvoice {

    private InvoiceBusiness invoiceBusiness;

    @Autowired
    public UpdateInvoice(InvoiceBusiness invoiceBusiness) {
        this.invoiceBusiness = invoiceBusiness;
    }

    @Async
    public Future<InvoiceResponse> execute(UpdateInvoiceRequest request){
        log.info("Call to: UpdateInvoice.execute()");
        AsyncResponse<InvoiceResponse> response = null;
        try {
            response = new AsyncResponse<>(this.invoiceBusiness.updateInvoice(request));
        } catch (Exception e){
            log.error("Error in: UpdateInvoice.execute()", e);
        }
        return response;
    }
}