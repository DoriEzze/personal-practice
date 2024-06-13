package org.accenture.behaviors;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.accenture.entities.responses.RegisterNewAgentResponse;

public interface IGameSteps {
    RegisterNewAgentResponse registerNewAgent() throws JsonProcessingException;
}
