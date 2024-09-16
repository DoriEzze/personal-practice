package org.accenture.services;

import com.fasterxml.jackson.core.type.TypeReference;
import org.accenture.behaviors.HttpClient;
import org.accenture.entities.Survey;
import org.accenture.entities.responses.*;
import org.accenture.behaviors.GameSteps;
import org.accenture.utils.Mapper;

import java.util.List;

public class GameStepsService implements GameSteps {
    private final Mapper mapper = new Mapper();
    private final HttpClient httpClient = new HardCodedClientWrapper();

    @Override
    public RegisterNewAgentResponse registerNewAgent() {
        String response = httpClient.post("/register-endpoint", "");
        return this.mapper.deserializeResponse(response, new TypeReference<RegisterNewAgentResponse>() {});
    }

    @Override
    public AcceptContractResponse acceptContract(String contractId) {
        String response = httpClient.post("/accept-endpoint", "");
        return this.mapper.deserializeResponse(response, new TypeReference<AcceptContractResponse>() {});
    }

    @Override
    public List<WaypointsResponse> listWaypoints(String systemSymbol) {
        String response = httpClient.get("/list-endpoint");
        return this.mapper.deserializeResponse(response, new TypeReference<List<WaypointsResponse>>() {});
    }

    @Override
    public NavigateShipResponse navigateShip(String shipSymbol, String waypointSymbol) {
        String response = httpClient.post("/navigate-endpoint", "");
        return this.mapper.deserializeResponse(response, new TypeReference<NavigateShipResponse>() {});
    }

    @Override
    public RefuelShipResponse refuelShip(String shipSymbol) {
        String response = httpClient.post("/refuel-endpoint", "");
        return this.mapper.deserializeResponse(response, new TypeReference<RefuelShipResponse>() {});
    }

    @Override
    public CreateSurveyResponse createSurvey(String shipSymbol) {
        String response = httpClient.post("/survey-endpoint", "");
        return this.mapper.deserializeResponse(response, new TypeReference<CreateSurveyResponse>() {});
    }

    @Override
    public ExtractResourceWithSurveyResponse extractResourceWithSurvey(String shipSymbol, Survey survey) {
        String response = httpClient.post("/extract-endpoint", "");
        return this.mapper.deserializeResponse(response, new TypeReference<ExtractResourceWithSurveyResponse>() {});
    }

    @Override
    public FulfillContractResponse fulfillContract(String contractId) {
        String response = httpClient.post("/fulfill-endpoint", "");
        return this.mapper.deserializeResponse(response, new TypeReference<FulfillContractResponse>() {});
    }
}
