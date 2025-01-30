package com.meli.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.meli.service.ShipServices;
import java.util.Map;

@Controller
@RequestMapping("/")
public class ShipController {

    @Autowired
    private ShipServices shipServices;

    @GetMapping("/status")
    @ResponseBody
    public ResponseEntity<Map<String, String>> getStatus() {
        return ResponseEntity.ok(Map.of("damaged_system", shipServices.getDamagedSystem()));
    }

    @PostMapping("/set-damage")
    public ResponseEntity<String> setDamagedSystem(@RequestParam String system) {
        return (ResponseEntity<String>) shipServices.setDamagedSystem(system);
    }

    @PostMapping("/teapot")
    public ResponseEntity<Void> handleTeapot() {
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
    }
}
