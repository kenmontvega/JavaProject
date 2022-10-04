package com.nlxa.java.dto.invoice;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Data
public class InvoiceListResponse implements Serializable {

    private List<InvoiceResponse> invoiceResponseList;

    public InvoiceListResponse() {
        this.invoiceResponseList = new ArrayList<>();
    }

    public InvoiceListResponse(List<InvoiceResponse> invoiceResponseList) {
        this.invoiceResponseList = invoiceResponseList;
    }

}
