package com.nlxa.java.dto.invoice;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Slf4j
@Data
public class UpdateInvoiceRequest implements Serializable {

    private String invoice_id;
    private String amount;
    private String status;
    private String client_id;

    public UpdateInvoiceRequest() {
    }

    public UpdateInvoiceRequest(String invoice_id, String amount, String status, String client_id) {
        this.invoice_id = invoice_id;
        this.amount = amount;
        this.status = status;
        this.client_id = client_id;
    }
}
