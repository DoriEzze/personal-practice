package com.accenture.practice.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "InvoiceLine")
@Data
public class InvoiceLine {

    @Id
    @Column(name = "InvoiceLineId")
    private Long invoiceLineId;

    @Column(name = "InvoiceId")
    private Long invoiceId;

    @Column(name = "TrackId")
    private Long trackId;

    @Column(name = "UnitPrice")
    private Float unitPrice;

    @Column(name = "Quantity")
    private Long quantity;
}
