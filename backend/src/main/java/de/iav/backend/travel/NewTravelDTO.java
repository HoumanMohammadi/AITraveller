package de.iav.backend.travel;

import de.iav.backend.gptApiCommunication.QuestionerAnswers;
import de.iav.backend.user.User;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewTravelDTO {

    String travelSuggestion;
    User user;
    LocalDateTime localDateTime;
    QuestionerAnswers questionerAnswers;

    public void setUser(User user) {
        this.user = user;
    }
}
