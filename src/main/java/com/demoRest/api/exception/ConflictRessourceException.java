package com.demoRest.api.exception;

public class ConflictRessourceException extends RuntimeException {
    public ConflictRessourceException(String message) {
        super(message);
    }
}
