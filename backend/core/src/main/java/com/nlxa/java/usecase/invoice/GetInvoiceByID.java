package com.nlxa.java.usecase.invoice;

import com.nlxa.java.dto.invoice.GetInvoiceByIdRequest;
import com.nlxa.java.dto.invoice.GetInvoiceByIdRequest;
import com.nlxa.java.dto.invoice.InvoiceResponse;
import com.nlxa.java.error.RequestException;
import com.nlxa.java.invoice.InvoiceBusiness;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class GetInvoiceByID {

    private InvoiceBusiness invoiceBusiness;

    @Autowired
    public GetInvoiceByID(InvoiceBusiness invoiceBusiness) {
        this.invoiceBusiness = invoiceBusiness;
    }

    public InvoiceResponse execute(GetInvoiceByIdRequest request){
        log.info("Call to: GetInvoiceByID.execute()");
        InvoiceResponse response = null;
        String verifyInfo = verifyRequestInfo(request);
        if (verifyInfo.equals("")) {
            response = this.invoiceBusiness.getByID(request);
        } else {
            log.error("Error in: GetInvoiceByID.execute() -> Verify if th information is complete");
            throw new RequestException(verifyInfo, "Error in: GetInvoiceByID.execute() -> Verify if th information is complete");
        }
        return response;
    }


    private String verifyRequestInfo(GetInvoiceByIdRequest request){
        log.info("Call to: InvoiceBusiness.verifyRequestInfo()");
        String result = "";
        if (request == null || request.getInvoice_id() == null){
            log.warn("Warn: The request or the request info is null");
            result = "Warn: The request or the request info is null";
        } else if (request.getInvoice_id().equals("")) {
            log.warn("Warn: The request info is empty");
            result = "Warn: The request info is empty";
        }
        return result;
    }
}
