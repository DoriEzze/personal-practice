package org.accenture.services;

import lombok.Setter;
import org.accenture.behaviors.HttpClient;

@Setter
public class HardCodedClientWrapper implements HttpClient {

    private String token;

    @Override
    public String get(String url) {
        return url;
    }

    @Override
    public String post(String url, String body) {
        return url;
    }
}
