package org.accenture.exceptions;

import org.accenture.entities.Error;

public class SpaceTradersApiException extends RuntimeException {
    private final String statusCode;

    public SpaceTradersApiException(Error error) {
        super(error.getMessage());
        this.statusCode = error.getCode();
    }

    @Override
    public String toString() {
        String message = super.toString();
        message += "\n\tStatus Code: " + this.statusCode + "\n";
        return message;
    }
}
