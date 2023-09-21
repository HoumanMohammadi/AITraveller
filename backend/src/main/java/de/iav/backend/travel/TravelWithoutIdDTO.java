package de.iav.backend.travel;


import de.iav.backend.gptApiCommunication.ChatGPTResponse;
import de.iav.backend.gptApiCommunication.QuestionerAnswers;
import de.iav.backend.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TravelWithoutIdDTO{
        ChatGPTResponse chatGPTResponse;
        User user;
        LocalDateTime localDateTime;
        QuestionerAnswers questionerAnswers;

        public Travel getTravelWithoutId(){
            return new Travel(this.chatGPTResponse, this.user, this.localDateTime, this.questionerAnswers);
        }

}
