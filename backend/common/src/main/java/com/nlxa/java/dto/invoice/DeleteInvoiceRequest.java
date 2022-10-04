package com.nlxa.java.dto.invoice;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Slf4j
@Data
public class DeleteInvoiceRequest implements Serializable {

    private String invoice_id;

    public DeleteInvoiceRequest() {
    }

    public DeleteInvoiceRequest(String invoice_id) {
        this.invoice_id = invoice_id;
    }
}
