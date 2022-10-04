package com.nlxa.java.dto.invoice;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Slf4j
@Data
public class GetInvoiceByIdRequest implements Serializable {

    private String invoice_id;

    public GetInvoiceByIdRequest() {
    }
}
