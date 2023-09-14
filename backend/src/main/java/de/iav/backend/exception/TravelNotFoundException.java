package de.iav.backend.exception;

public class TravelNotFoundException extends RuntimeException {
    public TravelNotFoundException(String id) {
        super("Travel with id "+ id + " not found");
    }
}
