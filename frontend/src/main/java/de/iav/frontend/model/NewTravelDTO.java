package de.iav.frontend.model;

import java.time.LocalDateTime;

public record NewTravelDTO(
        String travelSuggestion,
        User user,
        LocalDateTime localDateTime,
        QuestionerAnswers questionerAnswers
) {
}

