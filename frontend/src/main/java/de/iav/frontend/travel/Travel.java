package de.iav.frontend.travel;

import de.iav.frontend.gptApiCommunication.APIResponse;
import de.iav.frontend.gptApiCommunication.QuestionerAnswers;
import de.iav.frontend.user.User;

import java.time.LocalDateTime;

public record Travel(
        String id,
        APIResponse travelSuggestion,
        User user,
        LocalDateTime localDateTime,
        QuestionerAnswers questionerAnswers
) {
}