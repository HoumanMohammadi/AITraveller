package de.iav.backend.travel;

import de.iav.backend.gptApiCommunication.QuestionerAnswers;
import de.iav.backend.user.User;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TravelServiceTest {

    private final TravelRepository travelRepository = mock(TravelRepository.class);
    private final TravelService travelService= new TravelService(travelRepository);

    @Test
    void getTravelByUserId_whenNoTravelAvailable_thenReturnEmptyList() {
        // GIVEN
        String userId = "1";
        List<TravelWithoutIdDTO> expected = List.of();
        // WHEN
        when(travelRepository.findTravelsByUser_Id(userId)
                .stream()
                .map(travel -> TravelWithoutIdDTO.builder()
                        .questionerAnswers(travel.questionerAnswers)
                        .travelSuggestion(travel.travelSuggestion)
                        .localDateTime(travel.localDateTime)
                        .user(travel.user)
                        .build())
                .toList()).thenReturn(expected);
        List<TravelWithoutIdDTO> actual = travelService.getTravelByUserId(userId);
        // THEN
        assertEquals(expected, actual);
        verify(travelRepository).findTravelsByUser_Id(userId);
    }

    @Test
    void createTravel_whenCalled_thenSaveAndReturnTravel() {
        // GIVEN
        QuestionerAnswers questionerAnswers = new QuestionerAnswers();
        LocalDateTime localDateTime = LocalDateTime.now();
        User user = new User("userId", "username","lastname", "email", "password", "role");
        NewTravelDTO newTravelDTO = new NewTravelDTO("123", user, localDateTime, questionerAnswers);

        TravelWithoutIdDTO expected = new TravelWithoutIdDTO(
                "123",
                user,
                localDateTime,
                questionerAnswers
        );

        Travel savedTravel = new Travel(
                "generatedId",
                "123",
                user,
                localDateTime,
                questionerAnswers
        );

        when(travelRepository.save(any(Travel.class))).thenReturn(savedTravel);

        // WHEN
        Travel actual = travelService.saveTravel(newTravelDTO);

        // THEN
        assertEquals(expected.localDateTime, actual.localDateTime);
        assertEquals(expected.user, actual.user);
        assertEquals(expected.travelSuggestion, actual.travelSuggestion);
        assertEquals(expected.questionerAnswers, actual.questionerAnswers);
        verify(travelRepository).save(any(Travel.class));
    }


    @Test
    void deleteTravel() {
    }
}