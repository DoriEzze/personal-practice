package org.accenture;

import org.accenture.behaviors.GameSteps;
import org.accenture.entities.responses.AcceptContractResponse;
import org.accenture.entities.responses.NavigateShipResponse;
import org.accenture.entities.responses.RegisterNewAgentResponse;
import org.accenture.entities.responses.WaypointsResponse;
import org.accenture.services.GameStepsService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        GameSteps gameSteps = new GameStepsService();
        RegisterNewAgentResponse newAgent = gameSteps.registerNewAgent();
        System.out.println("Token: " + newAgent.getToken());
        AcceptContractResponse acceptContract = gameSteps.acceptContract();
        if (acceptContract.getContract().isAccepted()) {
            System.out.println("Contract accepted");
            List<WaypointsResponse> listWaypoints = gameSteps.listWaypoints();
            System.out.println("Asteroid Symbol: " + listWaypoints.get(0).getSymbol());
            NavigateShipResponse navigateShip = gameSteps.navigateShip();
            System.out.println("Arrival time: " + navigateShip.getNav().getRoute().getArrival());
        } else {
            System.out.println("Contract not accepted");
        }

    }
}