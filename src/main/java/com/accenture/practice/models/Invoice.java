package com.accenture.practice.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "Invoice")
@Data
public class Invoice {
    @Id
    @Column(name = "InvoiceId")
    private Long invoiceId;

    @Column(name = "CustomerId")
    private Long customerId;

    @Column(name = "InvoiceDate")
    private LocalDateTime dateObject;
    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    //Sigo trabajando en cómo ajustar bien el formato de fecha

    @Column(name = "BillingAddress")
    private String billingAddress;

    @Column(name = "BillingCity")
    private String billingCity;

    @Column(name = "BillingState")
    private String billingState;

    @Column(name = "BillingCountry")
    private String billingCountry;

    @Column(name = "BillingPostalCode")
    private String billingPostalCode;

    @Column(name = "Total")
    private Float total;
}
