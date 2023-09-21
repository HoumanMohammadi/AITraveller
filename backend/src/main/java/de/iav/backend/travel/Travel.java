package de.iav.backend.travel;

import de.iav.backend.gptApiCommunication.QuestionerAnswers;
import de.iav.backend.gptApiCommunication.ChatGPTResponse;
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
    ChatGPTResponse chatGPTResponse;
    @DBRef
    User user;
    LocalDateTime localDateTime;
    QuestionerAnswers questionerAnswers;

    public Travel(ChatGPTResponse chatGPTResponse, User user, LocalDateTime localDateTime, QuestionerAnswers questionerAnswers) {
        this.chatGPTResponse = chatGPTResponse;
        this.user=user;
        this.localDateTime=localDateTime;
        this.questionerAnswers=questionerAnswers;
    }


    public Travel withId(String newId) {
        return new Travel(newId, this.chatGPTResponse, this.user, this.localDateTime, this.questionerAnswers);
    }
}
