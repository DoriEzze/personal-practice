package com.accenture.practice.controller;

import com.accenture.practice.models.Album;
import com.accenture.practice.models.Invoice;
import com.accenture.practice.repositories.AlbumRepository;
import com.accenture.practice.repositories.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SimpleController {
    @Value("${spring.application.name}")
    String appName;

    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    InvoiceRepository invoiceRepository;

    @GetMapping("/")
    public String homePage(Model model) {
        //Compruebo que esté trayendo bien el dato de la DB.
        Album album = albumRepository.findById(1L).get();
        Invoice invoice = invoiceRepository.findById(1L).get();
        model.addAttribute("appName", invoice.getInvoiceDate());
        return "home";
    }
}
