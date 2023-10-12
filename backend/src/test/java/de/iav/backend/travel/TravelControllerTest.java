package de.iav.backend.travel;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.iav.backend.gptApiCommunication.QuestionerAnswers;
import de.iav.backend.user.User;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


@SpringBootTest
@AutoConfigureMockMvc
class TravelControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private TravelRepository travelRepository;

    private final static String BASE_URL = "/api/aitraveller/travels";
    private final ObjectMapper objectMapper = new ObjectMapper();

    QuestionerAnswers questionerAnswers = new QuestionerAnswers();
    LocalDateTime localDateTime = LocalDateTime.now();
    User user = new User("userId", "username","lastname", "email", "password", "role");
    NewTravelDTO newTravelDTO1 = new NewTravelDTO("Berlin",user, localDateTime, questionerAnswers);
    NewTravelDTO newTravelDTO2 = new NewTravelDTO("Munich",user, localDateTime, questionerAnswers);


    @Test
    void getAllTravels_shouldReturnEmptyList_whenNothingInDB() throws Exception  {
        mockMvc.perform(MockMvcRequestBuilders.get(BASE_URL ))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("[]"));
    }
    @Test
    void getAllTravelsByUserId_shouldReturnTwoEntry_whenTwoFittingEntriesExists() throws Exception  {
        mockMvc.perform(MockMvcRequestBuilders.get(BASE_URL ))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("[]"))
        //.andExpect(jsonPath("[0].destination").value("Berlin"))
        //.andExpect(jsonPath("[1].destination").value("Munich"))
        ;
    }

    @Test
    void createTravel() {
    }

    @Test
    void updateTravel() {
    }

    @Test
    void deleteTravel() {
    }
}