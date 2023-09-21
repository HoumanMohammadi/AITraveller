package de.iav.frontend.model;

import java.time.LocalDateTime;

public record TravelWithoutIdDTO(
        ChatGPTResponse travelSuggestion,
        User user,
        LocalDateTime localDateTime,
        QuestionerAnswers questionerAnswers
) {
}
