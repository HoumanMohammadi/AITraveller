package de.iav.frontend.model;

import java.util.List;

public record QuestionerAnswers(
        int age,
        List<String>coTraveller,
        String livingCity,
        boolean disability,
        int travelDuration,
        List<String> activity,
        String season,
        List<String> meansOfTravel,
        List<String> travelPurpose,
        List<String> destinationContinent
) {
}
