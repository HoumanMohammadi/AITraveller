package de.iav.backend.travel;

import de.iav.backend.exception.TravelNotFoundException;
import de.iav.backend.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TravelService {

    private final TravelRepository travelRepository;
    public List<TravelWithoutIdDTO> getAllTravels(){
        return travelRepository.findAll()
                .stream()
                .map(travel -> TravelWithoutIdDTO.builder()
                        .questionerAnswers(travel.questionerAnswers)
                        .travelSuggestion(travel.travelSuggestion)
                        .localDateTime(travel.localDateTime)
                        .user(travel.user)
                        .build())
                .toList();
    }

    public List<TravelWithoutIdDTO> getTravelByUserId(String id){
        return travelRepository.findTravelsByUser_Id(id)
                .stream()
                .map(travel -> TravelWithoutIdDTO.builder()
                        .questionerAnswers(travel.questionerAnswers)
                        .travelSuggestion(travel.travelSuggestion)
                        .localDateTime(travel.localDateTime)
                        .user(travel.user)
                        .build())
                .toList();
    }
    public List<TravelWithoutIdDTO> getAllTravelsByUser(Optional<User> user) {
        return travelRepository.findTravelByUser(user)
                .stream()
                .map(travel -> TravelWithoutIdDTO.builder()
                        .questionerAnswers(travel.questionerAnswers)
                        .travelSuggestion(travel.travelSuggestion)
                        .localDateTime(travel.localDateTime)
                        .user(travel.user)
                        .build())
                .toList();
    }
    public TravelWithoutIdDTO saveTravel(NewTravelDTO newTravelDTO) {
        Travel travel = Travel.builder()
                .questionerAnswers(newTravelDTO.questionerAnswers)
                .travelSuggestion(newTravelDTO.travelSuggestion)
                .localDateTime(newTravelDTO.localDateTime)
                .user(newTravelDTO.user)
                .build();
        Travel travelToSave = travelRepository.save(travel);

        return TravelWithoutIdDTO.builder()
                .questionerAnswers(travelToSave.questionerAnswers)
                .travelSuggestion(travelToSave.travelSuggestion)
                .localDateTime(travelToSave.localDateTime)
                .user(travelToSave.user)
                .build();
    }

    public void deleteTravelById(String id){
        Travel travelToDelete = travelRepository
                .findTravelById(id)
                .orElseThrow(()-> new TravelNotFoundException(id));
        travelRepository.delete(travelToDelete);
    }

    public TravelWithoutIdDTO updateTravel(String id, NewTravelDTO updateTravelDto) {
        Travel travel= travelRepository
                .findTravelById(id)
                        .orElseThrow(()-> new TravelNotFoundException(id));

        travel.setTravelSuggestion(updateTravelDto.travelSuggestion);
        travel.setUser(updateTravelDto.user);
        travel.setQuestionerAnswers(updateTravelDto.questionerAnswers);
        travel.setLocalDateTime(updateTravelDto.localDateTime);

        Travel savedTravel = travelRepository.save(travel);

        return TravelWithoutIdDTO.builder()
                .travelSuggestion(savedTravel.travelSuggestion)
                .questionerAnswers(savedTravel.questionerAnswers)
                .localDateTime(savedTravel.localDateTime)
                .user(savedTravel.user)
                .build();
    }
}
