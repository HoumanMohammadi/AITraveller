package de.iav.backend.travel;


import de.iav.backend.gptApiCommunication.ChatGPTResponse;
import de.iav.backend.gptApiCommunication.QuestionerAnswers;
import de.iav.backend.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TravelWithoutIdDTO{
        String travelSuggestion;
        User user;
        LocalDateTime localDateTime;
        QuestionerAnswers questionerAnswers;

        public Travel getTravelWithoutId(){
            return new Travel(this.travelSuggestion, this.user, this.localDateTime, this.questionerAnswers);
        }

        public String getTravelSuggestion() {
                return travelSuggestion;
        }

        public User getUser() {
                return user;
        }

        public LocalDateTime getLocalDateTime() {
                return localDateTime;
        }

        public QuestionerAnswers getQuestionerAnswers() {
                return questionerAnswers;
        }
}
