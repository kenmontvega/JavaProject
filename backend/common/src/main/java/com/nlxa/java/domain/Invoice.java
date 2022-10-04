package com.nlxa.java.domain;

import com.nlxa.java.dto.invoice.AddInvoiceRequest;
import com.nlxa.java.dto.invoice.DeleteInvoiceRequest;
import com.nlxa.java.dto.invoice.UpdateInvoiceRequest;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "invoice")
public class Invoice implements Serializable {

    @Id
    @Column(name = "invoice_id")
    @GeneratedValue(generator = "ID")
    @GenericGenerator(
            name = "ID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String invoice_id;
    @Column(name = "amount")
    private String amount;
    @Column(name = "status")
    private String status;
    @Column(name = "client_id")
    private String client_id;

    public Invoice() {}

    public Invoice(AddInvoiceRequest request) {
        this.invoice_id = "";
        this.amount = request.getAmount();
        this.status = request.getStatus();
        this.client_id = request.getClient_id();
    }

    public Invoice(DeleteInvoiceRequest request) {
        this.invoice_id = request.getInvoice_id();
    }

    public Invoice(UpdateInvoiceRequest request) {
        this.invoice_id = request.getInvoice_id();
        this.amount = request.getAmount();
        this.status = request.getStatus();
        this.client_id = request.getClient_id();
    }
}
