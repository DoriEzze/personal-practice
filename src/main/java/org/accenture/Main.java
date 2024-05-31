package org.accenture;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.accenture.entities.responses.RegisterNewAgentResponse;
import org.accenture.implementations.GameStepsImpl;
import org.accenture.interfaces.IGameSteps;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        IGameSteps gameSteps = new GameStepsImpl();
        RegisterNewAgentResponse newAgent = gameSteps.registerNewAgent();
        System.out.println("Token: " + newAgent.getToken());
    }
}