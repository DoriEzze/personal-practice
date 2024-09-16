package org.accenture.behaviors;

import org.accenture.entities.Survey;
import org.accenture.entities.responses.*;

import java.util.List;

public interface GameSteps {
    RegisterNewAgentResponse registerNewAgent();
    AcceptContractResponse acceptContract(String contractId);
    List<WaypointsResponse> listWaypoints(String systemSymbol);
    NavigateShipResponse navigateShip(String shipSymbol, String waypointSymbol);
    RefuelShipResponse refuelShip(String shipSymbol);
    CreateSurveyResponse createSurvey(String shipSymbol);
    ExtractResourceWithSurveyResponse extractResourceWithSurvey(String shipSymbol, Survey survey);
    FulfillContractResponse fulfillContract(String contractId);
}
