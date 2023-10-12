package de.iav.backend.travel;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import de.iav.backend.gptApiCommunication.QuestionerAnswers;
import de.iav.backend.user.User;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class TravelControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private TravelRepository travelRepository;
    @Autowired
    private TravelService travelService;

    private final static String BASE_URL = "/api/aitraveller/travels";
    private final ObjectMapper objectMapper = new ObjectMapper();

    QuestionerAnswers questionerAnswers = new QuestionerAnswers();
    LocalDateTime localDateTime = LocalDateTime.now();
    User user = new User("userId", "username","lastname", "email", "password", "role");
    NewTravelDTO newTravelDTO1 = new NewTravelDTO("Berlin",user, localDateTime, questionerAnswers);
    NewTravelDTO newTravelDTO2 = new NewTravelDTO("Munich",user, localDateTime, questionerAnswers);

    @BeforeEach
    void setUp() {
        travelRepository.deleteAll(); // Clear the repository before each test
    }


    @Test
    void getAllTravels_shouldReturnEmptyList_whenNothingInDB() throws Exception  {
        mockMvc.perform(MockMvcRequestBuilders.get(BASE_URL ))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("[]"));
    }
    @Test
    void getAllTravelsByUserId_shouldReturnTwoEntry_whenTwoFittingEntriesExists() throws Exception  {

        travelService.saveTravel(newTravelDTO1);
        travelService.saveTravel(newTravelDTO2);

        mockMvc.perform(MockMvcRequestBuilders.get(BASE_URL+"/{userId}",user.getId()))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].travelSuggestion").value(newTravelDTO1.travelSuggestion))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].travelSuggestion").value(newTravelDTO2.travelSuggestion));
    }

    @Test
    void createTravel_shouldReturnBadRequestOnInvalidRequest() throws Exception {
        // Create an invalid travel object (e.g., missing required fields)
        NewTravelDTO invalidTravel = new NewTravelDTO();

        // Convert the invalid travel object to JSON
        String jsonRequest = objectMapper.writeValueAsString(invalidTravel);

        // Send a POST request with the invalid JSON payload
        mockMvc.perform(post(BASE_URL)
                        .contentType("application/json")
                        .content(jsonRequest))
                .andExpect(status().isBadRequest()); // Assuming you return HTTP 400 on bad request
    }
    @Test
    @DirtiesContext
    void createTravel_thenExpectStatusOKAndReturnTravelAsJSON() throws Exception {
        // Create a NewTravelDTO and set necessary values
        mockMvc.perform(MockMvcRequestBuilders.post(BASE_URL).
                contentType(MediaType.APPLICATION_JSON)
                .content("""
                        {
                            "travelSuggestion": "berlin",
                            "user": {
                                "id": "userId",
                                "firstName": "Houman",
                                "lastName": "Mo",
                                "email": "houmane.el",
                                "password": "password",
                                "role": "user"
                            },
                            "questionerAnswers": {
                                "age": 22
                            }
                        }
                        """
                ))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().json(
                        """
                        {
                            "travelSuggestion": "berlin",
                            "user": {
                                "id": "userId",
                                "firstName": "Houman",
                                "lastName": "Mo",
                                "email": "houmane.el",
                                "password": "password",
                                "role": "user"
                            },
                            "questionerAnswers": {
                                "age": 22
                            }
                        }
                        """
                ));
    }


    @Test
    @DirtiesContext
    void updateTravel() {
    }

    @Test
    void deleteTravel() {
    }
}