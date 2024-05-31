package org.accenture.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.accenture.entities.responses.ResponseBody;

public class Mapper {
    private final ObjectMapper mapper;

    public Mapper() {
        this.mapper = new ObjectMapper();
        this.mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        this.mapper.registerModule(new JavaTimeModule());
    }

    public <T> T deserializeResponse(String response, Class<T> classType) throws JsonProcessingException {
        ResponseBody body = this.mapper.readValue(response, ResponseBody.class);
        if (body.getError() != null) {
            throw new Error(body.getError().getMessage());
        }
        return this.mapper.convertValue(body.getData(), classType);
    }
}
