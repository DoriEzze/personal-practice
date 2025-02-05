package com.meli.adriftship;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.meli.controller.RestController;
import com.meli.service.ShipServices;
import org.junit.jupiter.api.Test;

import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(RestController.class)
public class ShipControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private ShipServices service;

    @Test
    void defaultStatus() throws Exception {
        this.mockMvc.perform(get("/status")).andExpect(status().isOk())
                .andExpect(content().string(containsString("navigation")));
    }
}