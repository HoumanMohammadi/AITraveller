package de.iav.backend.travel;

import de.iav.backend.gptApiCommunication.QuestionerAnswers;
import de.iav.backend.gptApiCommunication.APIResponse;
import de.iav.backend.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "travels")
public class Travel {

    @MongoId
    String id;
    APIResponse apiResponse;
    @DBRef
    User user;
    LocalDateTime localDateTime;
    QuestionerAnswers questionerAnswers;

    public Travel(APIResponse apiResponse, User user, LocalDateTime localDateTime, QuestionerAnswers questionerAnswers) {
        this.apiResponse= apiResponse;
        this.user=user;
        this.localDateTime=localDateTime;
        this.questionerAnswers=questionerAnswers;
    }


    public Travel withId(String newId) {
        return new Travel(newId, this.apiResponse, this.user, this.localDateTime, this.questionerAnswers);
    }
}
