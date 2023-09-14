package de.iav.backend.travel;

import de.iav.backend.travelSuggestion.QuestionerAnswers;
import de.iav.backend.travelSuggestion.TravelSuggestion;
import de.iav.backend.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
public class Travel {

    @MongoId
    String id;
    TravelSuggestion travelSuggestion;
    @DBRef
    User user;
    LocalDateTime localDateTime;
    QuestionerAnswers questionerAnswers;

    public Travel withId(String newId) {
        return new Travel(newId, this.travelSuggestion, this.user, this.localDateTime, this.questionerAnswers);
    }
}
