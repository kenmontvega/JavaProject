package com.nlxa.java.dto.invoice;

import com.nlxa.java.domain.Invoice;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class InvoiceResponse {

    private String invoice_id;
    private String amount;
    private String status;
    private String client_id;

    public InvoiceResponse() {
    }

    public InvoiceResponse(Invoice invoice){
        toInvoiceResponse(invoice);
    }

    public void toInvoiceResponse(Invoice invoice) {
        setInvoice_id((invoice.getInvoice_id()));
        setAmount(invoice.getAmount());
        setStatus(invoice.getStatus());
        setClient_id(invoice.getClient_id());
    }
}
