package org.accenture.implementations;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.accenture.entities.responses.RegisterNewAgentResponse;
import org.accenture.interfaces.IGameSteps;
import org.accenture.utils.Mapper;

public class GameStepsImpl implements IGameSteps {
    private final Mapper mapper = new Mapper();

    @Override
    public RegisterNewAgentResponse registerNewAgent() throws JsonProcessingException {
        String response = "{\"data\":{\"token\":\" 1234567890 \"},\"error\":null}";
        return this.mapper.deserializeResponse(response, RegisterNewAgentResponse.class);
    }
}
