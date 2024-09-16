package org.accenture;

import org.accenture.behaviors.GameSteps;
import org.accenture.entities.responses.*;
import org.accenture.services.GameStepsService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        GameSteps gameSteps = new GameStepsService();
        RegisterNewAgentResponse newAgent = gameSteps.registerNewAgent();
        System.out.println("Token: " + newAgent.getToken());
        AcceptContractResponse acceptContract = gameSteps.acceptContract("1");
        if (acceptContract.getContract().isAccepted()) {
            System.out.println("Contract accepted");
            List<WaypointsResponse> listWaypoints = gameSteps.listWaypoints("2");
            NavigateShipResponse navigateShip = gameSteps.navigateShip("3", "4");
            RefuelShipResponse refuelShip = gameSteps.refuelShip("5");
            CreateSurveyResponse createSurvey = gameSteps.createSurvey("6");
            ExtractResourceWithSurveyResponse extractResourceWithSurvey = gameSteps.extractResourceWithSurvey("7", createSurvey.getSurveys()[0]);
            FulfillContractResponse fulfillContract = gameSteps.fulfillContract("8");
        } else {
            System.out.println("Contract not accepted");
        }

    }
}