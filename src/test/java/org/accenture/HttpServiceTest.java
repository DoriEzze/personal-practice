package org.accenture;

import org.accenture.behaviors.HttpClient;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class HttpServiceTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Mock
    private HttpClient httpClient;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void testGet() {
        String url = "{\"data\":{\"token\":\"1234567890\"},\"error\":null}";
        String expectedResponse = "{\"data\":{\"token\":\"1234567890\"},\"error\":null}";
        when(httpClient.post(url, "")).thenReturn(expectedResponse);
        Main.main(new String[]{});
        assertTrue(outputStreamCaptor.toString().contains("Token: 1234567890"));
    }
}
