package com.meli.controller;

import com.meli.service.ShipServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UiController {

    private final ShipServices shipServices = new ShipServices();

    @GetMapping("/repair-bay")
    public String getRepairBay(Model model) {
        String damagedSystem = shipServices.getDamagedSystem();
        String code = ShipServices.SYSTEM_CODES.get(damagedSystem);
        model.addAttribute("systemCode", code);
        return "RepairBay";
    }
}
