package de.iav.backend.travel;


import de.iav.backend.gptApiCommunication.APIResponse;
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
        APIResponse apiResponse;
        User user;
        LocalDateTime localDateTime;
        QuestionerAnswers questionerAnswers;

        public Travel getTravelWithoutId(){
            return new Travel(this.apiResponse, this.user, this.localDateTime, this.questionerAnswers);
        }

}
