package de.iav.backend.travel;

import de.iav.backend.apiCommunication.QuestionerAnswers;
import de.iav.backend.apiCommunication.APIResponse;
import de.iav.backend.user.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
public class Travel {

    @MongoId
    String id;
    APIResponse travelSuggestion;
    @DBRef
    User user;
    LocalDateTime localDateTime;
    QuestionerAnswers questionerAnswers;

    public Travel withId(String newId) {
        return new Travel(newId, this.travelSuggestion, this.user, this.localDateTime, this.questionerAnswers);
    }
}
