package com.nlxa.java.usecase.invoice;

import com.nlxa.java.dto.invoice.DeleteInvoiceRequest;
import com.nlxa.java.invoice.InvoiceBusiness;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DeleteInvoice {

    private InvoiceBusiness invoiceBusiness;

    @Autowired
    public DeleteInvoice(InvoiceBusiness invoiceBusiness) {
        this.invoiceBusiness = invoiceBusiness;
    }

    @Async
    public void execute(DeleteInvoiceRequest request){
        log.info("Call to: DeleteInvoice.execute()");
        try {
            this.invoiceBusiness.deleteInvoice(request);
        } catch (Exception e){
            log.error("Error in: GetAllInvoices.execute()", e);
        }
    }
}
