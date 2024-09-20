package org.accenture;

import org.accenture.behaviors.HttpClient;
import org.accenture.exceptions.SpaceTradersApiException;
import org.accenture.mocks.MockResponses;
import org.accenture.services.GameStepsService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class HttpServiceTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Mock
    private HttpClient httpClient;

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        System.setOut(new PrintStream(outputStreamCaptor));

        GameStepsService gameStepsService = new GameStepsService(httpClient);
        Field gameStepsField = Main.class.getDeclaredField("gameSteps");
        gameStepsField.setAccessible(true);
        gameStepsField.set(null, gameStepsService);
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void testMain() {
        when(httpClient.post(eq("/register-endpoint"), anyString()))
                .thenReturn(MockResponses.responseRegisterNewAgent);
        when(httpClient.post(eq("/accept-endpoint"), anyString()))
                .thenReturn(MockResponses.responseError);

        assertThrows(SpaceTradersApiException.class, () -> Main.main(new String[]{}));
        assertTrue(outputStreamCaptor.toString().contains("Token: 123"));

        verify(httpClient).post(eq("/register-endpoint"), anyString());
        verify(httpClient).post(eq("/accept-endpoint"), anyString());
    }
}
