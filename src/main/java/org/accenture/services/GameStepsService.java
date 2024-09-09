package org.accenture.services;

import com.fasterxml.jackson.core.type.TypeReference;
import org.accenture.behaviors.HttpClient;
import org.accenture.entities.responses.AcceptContractResponse;
import org.accenture.entities.responses.WaypointsResponse;
import org.accenture.entities.responses.NavigateShipResponse;
import org.accenture.entities.responses.RegisterNewAgentResponse;
import org.accenture.behaviors.GameSteps;
import org.accenture.utils.Mapper;

import java.util.List;

public class GameStepsService implements GameSteps {
    private final Mapper mapper = new Mapper();
    private final HttpClient httpClient = new HardCodedClientWrapper();

    @Override
    public RegisterNewAgentResponse registerNewAgent() {
        String response = httpClient.post("{\"data\":{\"token\":\"1234567890\"},\"error\":null}", "");
        return this.mapper.deserializeResponse(response, new TypeReference<RegisterNewAgentResponse>() {});
    }

    @Override
    public AcceptContractResponse acceptContract() {
        String response = httpClient.post("{\"data\": {\"contract\": {\"accepted\": true}},\"error\": null}", "");
        return this.mapper.deserializeResponse(response, new TypeReference<AcceptContractResponse>() {});
    }

    @Override
    public List<WaypointsResponse> listWaypoints() {
        String response = httpClient.get("{\"data\": [{\"symbol\": \"string\"}],\"error\": null}");
        return this.mapper.deserializeResponse(response, new TypeReference<List<WaypointsResponse>>() {});
    }

    @Override
    public NavigateShipResponse navigateShip() {
        String response = httpClient.post("{\"data\": {\"fuel\": {\"consumed\": {\"amount\": 10}},\"nav\": {\"route\": {\"arrival\": \"2019-08-24T14:15:22Z\"}}},\"error\": null}", "");
        return this.mapper.deserializeResponse(response, new TypeReference<NavigateShipResponse>() {});
    }
}
