package org.accenture.mocks;

public class MockResponses {
    public static final String responseError = """
            {
              "error": {
                "message": "API Error",
                "code": "500"
              }
            }""";
    public static final String responseRegisterNewAgent = """
            {
              "data": {
                "token": "123"
              }
            }""";
}