package com.nlxa.java.dto.invoice;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Slf4j
@Data
public class AddInvoiceRequest implements Serializable {

    private String amount;
    private String status;
    private String client_id;

    public AddInvoiceRequest() {
    }

    public AddInvoiceRequest(String amount, String status, String client_id) {
        this.amount = amount;
        this.status = status;
        this.client_id = client_id;
    }
}
