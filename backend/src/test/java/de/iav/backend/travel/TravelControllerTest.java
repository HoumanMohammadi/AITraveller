package de.iav.backend.travel;

import com.fasterxml.jackson.databind.ObjectMapper;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
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
        travelRepository.deleteAll();
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
        NewTravelDTO invalidTravel = new NewTravelDTO();

        String jsonRequest = objectMapper.writeValueAsString(invalidTravel);

        mockMvc.perform(post(BASE_URL)
                        .contentType("application/json")
                        .content(jsonRequest))
                .andExpect(status().isBadRequest());
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
    void updateTravel_shouldReturn404_whenStudentDoesntExist() throws Exception {
        String THIS_ID_DOES_NOT_EXIST = "THIS_ID_DOES_NOT_EXIST";
        String travelThatDoesNotExist = """
        {
            "travelSuggestion": "Updated Berlin",
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
        """;

        mockMvc.perform(put(BASE_URL+"/"+THIS_ID_DOES_NOT_EXIST)
                .contentType("application/json")
                        .content(travelThatDoesNotExist))
                .andExpect(status().isNotFound());
    }

    @Test
    @DirtiesContext
    void updateTravel_shouldReturnNotFoundForInvalidId() throws Exception {

        String jsonRequest = """
        {
            "travelSuggestion": "Updated Berlin",
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
        """;


        mockMvc.perform(MockMvcRequestBuilders.put(BASE_URL + "/invalidId")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }
    @Test
    @DirtiesContext
    void deleteTravel_shouldReturnNotFoundForInvalidId() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.delete(BASE_URL + "/invalidId"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    @DirtiesContext
    void deleteTravel_shouldReturnSuccessForValidId() throws Exception {

        Travel createdTravel = travelService.saveTravel(newTravelDTO1);

        mockMvc.perform(MockMvcRequestBuilders.delete(BASE_URL + "/" + createdTravel.getId()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Travel with id " + createdTravel.getId() + " deleted successfully"));
    }
}