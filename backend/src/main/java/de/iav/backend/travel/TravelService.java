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
    public List<Travel> getAllTravels(){
        return travelRepository.findAll();
    }
    public List<Travel> getTravelByUserId(String id){
        return travelRepository.findTravelsByUser_Id(id);
    }
    public Travel getAllTravelByUser(Optional<User> user) {
        return travelRepository.findTravelByUser(user);
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
        travelRepository.deleteById(id);
    }
    public void deleteTravel(Travel travel){
        travelRepository.delete(travel);
    }
    public Travel updateTravel(String id, Travel travelToUpdate) {
        travelRepository.findById(id).orElseThrow(() -> new TravelNotFoundException(id));
        Travel updatedTravel = travelToUpdate.withId(id);
        return travelRepository.save(updatedTravel);
    }
}
