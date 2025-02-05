package com.meli.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.meli.service.ShipServices;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/")
public class RestController {

    @Autowired
    private ShipServices shipServices;

    @Operation(
            summary = "Get the status of the damaged system",
            description = "Returns the currently damaged system as a JSON string",
            tags = {"Ship Status"},
            security = @SecurityRequirement(name = "basicAuth")
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful response", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @GetMapping("/status")
    public ResponseEntity<String> getStatus() {
        return ResponseEntity.ok("{\"damaged_system\": \"" + shipServices.getDamagedSystem() + "\"}");
    }

    @Operation(
            summary = "Set the damaged system",
            description = "Updates the currently damaged system",
            tags = {"Ship Management"},
            security = @SecurityRequirement(name = "basicAuth")
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Damaged system updated", content = @Content),
            @ApiResponse(responseCode = "400", description = "Invalid system name", content = @Content),
            @ApiResponse(responseCode = "409", description = "System already damaged", content = @Content)
    })
    @PostMapping("/set-damage")
    public ResponseEntity<String> setDamagedSystem(@RequestParam String system) {
        shipServices.setDamagedSystem(system);
        return ResponseEntity.ok("Damaged system set to: " + system);
    }

    @Operation(
            summary = "Teapot Easter Egg",
            description = "Returns HTTP status 418 (I'm a teapot)",
            tags = {"Fun"}
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "418", description = "I'm a teapot", content = @Content)
    })
    @PostMapping("/teapot")
    public ResponseEntity<Void> handleTeapot() {
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
    }
}
