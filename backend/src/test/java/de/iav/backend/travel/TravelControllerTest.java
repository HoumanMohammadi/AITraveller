package de.iav.backend.travel;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.iav.backend.gptApiCommunication.QuestionerAnswers;
import de.iav.backend.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@SpringBootTest
@AutoConfigureMockMvc
class TravelControllerTest {

    @Autowired
    private MockMvc mockMvc;
    private final static String BASE_URL = "/api/aitraveller/travels";
    private final ObjectMapper objectMapper = new ObjectMapper();
    QuestionerAnswers questionerAnswers = new QuestionerAnswers();
    LocalDateTime localDateTime = LocalDateTime.now();
    User user = new User("userId", "username","lastname", "email", "password", "role");
    NewTravelDTO newTravelDTO1 = new NewTravelDTO("Berlin",user, localDateTime, questionerAnswers);
    NewTravelDTO newTravelDTO2 = new NewTravelDTO("Munich",user, localDateTime, questionerAnswers);

    @BeforeEach
    void insertTestTravels() throws Exception{
        mockMvc.perform(post(BASE_URL)
                .contentType("application.json")
                .content(objectMapper.writeValueAsString(newTravelDTO1))
        );
        mockMvc.perform(post(BASE_URL)
                .contentType("application.json")
                .content(objectMapper.writeValueAsString(newTravelDTO2))
        );
    }

    @Test
    void getAllTravelsByUserId_shouldReturnTwoEntry_whenTwoFittingEntriesExists() throws Exception  {
        mockMvc.perform(get(BASE_URL + "/"+ user.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("[0].destination").value("Berlin"))
                .andExpect(jsonPath("[1].destination").value("Munich"));
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