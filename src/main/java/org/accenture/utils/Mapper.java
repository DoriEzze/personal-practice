package org.accenture.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.accenture.entities.responses.ResponseBody;
import org.accenture.exceptions.SpaceTradersApiException;

public class Mapper {
    private final ObjectMapper mapper;

    public Mapper() {
        this.mapper = new ObjectMapper();
        this.mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        this.mapper.registerModule(new JavaTimeModule());
    }

    public <T> T deserializeResponse(String response, TypeReference<T> classType) {
        try {
            ResponseBody body = this.mapper.readValue(response, ResponseBody.class);
            if (body.getError() != null) {
                throw new SpaceTradersApiException(body.getError());
            }
            return this.mapper.convertValue(body.getData(), classType);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
