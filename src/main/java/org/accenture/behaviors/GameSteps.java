package org.accenture.behaviors;

import org.accenture.entities.responses.AcceptContractResponse;
import org.accenture.entities.responses.WaypointsResponse;
import org.accenture.entities.responses.NavigateShipResponse;
import org.accenture.entities.responses.RegisterNewAgentResponse;

import java.util.List;

public interface GameSteps {
    RegisterNewAgentResponse registerNewAgent();
    AcceptContractResponse acceptContract();
    List<WaypointsResponse> listWaypoints();
    NavigateShipResponse navigateShip();
}
