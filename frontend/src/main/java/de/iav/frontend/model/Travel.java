package de.iav.frontend.model;

import java.time.LocalDateTime;

public record Travel(
        String id,
        APIResponse travelSuggestion,
        User user,
        LocalDateTime localDateTime,
        QuestionerAnswers questionerAnswers
) {
}
