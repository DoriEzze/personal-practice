package com.meli.service;

import com.meli.exceptions.InvalidSystemException;
import com.meli.exceptions.SystemAlreadyDamagedException;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ShipServices {

    public static final Map<String, String> SYSTEM_CODES = Map.of(
            "navigation", "NAV-01",
            "communications", "COM-02",
            "life_support", "LIFE-03",
            "engines", "ENG-04",
            "deflector_shield", "SHLD-05"
    );

    private String damagedSystem;

    public ShipServices () {
        this.damagedSystem = "navigation";
    }

    public String getDamagedSystem() {
        return damagedSystem;
    }

    public HttpEntity<String> setDamagedSystem(String system) {
        if (this.damagedSystem.equals(system)) {
            throw new SystemAlreadyDamagedException("System is already damaged");
        }
        if (!SYSTEM_CODES.containsKey(system)) {
            throw new InvalidSystemException("Invalid system name");
        }
        this.damagedSystem = system;
        return ResponseEntity.ok("Damaged system set to: " + system);
    }
}