package org.accenture.services;

import lombok.Setter;
import org.accenture.behaviors.HttpClient;

@Setter
public class HardCodedClientWrapper implements HttpClient {

    private String token;

    @Override
    public String get(String url) {
        return "{\"data\": [{\"symbol\": \"TEST-123\"}], \"error\": null}";
    }

    @Override
    public String post(String url, String body) {
        return "{\"data\": {\"token\": \"1234567890\", \"contract\": {\"accepted\": true}, \"fuel\": {\"consumed\": {\"amount\": 10}}, \"nav\": {\"route\": {\"arrival\": \"2019-08-24T14:15:22Z\"}}}, \"error\": null}";
    }
}
