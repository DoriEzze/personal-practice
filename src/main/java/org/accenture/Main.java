package org.accenture;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.accenture.entities.responses.RegisterNewAgentResponse;
import org.accenture.entities.responses.ResponseBody;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        String agentName = "TQ-" + (int) (Math.random() * 10000000);
        HttpResponse<String> spacetradersResponse = Unirest.post("https://api.spacetraders.io/v2/register")
            .header("Content-Type", "application/json")
            .header("Accept", "application/json")
            .body("{\n  \"faction\": \"COSMIC\",\n  \"symbol\": \"" + agentName + "\"}")
            .asString();

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.registerModule(new JavaTimeModule());
        ResponseBody body = mapper.readValue(spacetradersResponse.getBody(), ResponseBody.class);
        if (body.getError() != null) {
            throw new Error(body.getError().getMessage());
        }
        RegisterNewAgentResponse newAgent = mapper.convertValue(body.getData(), RegisterNewAgentResponse.class);
        System.out.println("Token: " + newAgent.getToken());
    }
}