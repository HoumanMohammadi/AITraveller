package de.iav.backend.travel;

import de.iav.backend.exception.TravelNotFoundException;
import de.iav.backend.user.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TravelService {

    private final TravelRepository travelRepository;

    public TravelService(TravelRepository travelRepository) {
        this.travelRepository = travelRepository;
    }

    public List<Travel> getAllTravels(){
        return travelRepository.findAll();
    }

    public Optional<Travel> getTravelById(String id){
        return travelRepository.findById(id);
    }

    public Optional<Travel> getAllTravelByUser(Optional<User> user) {
        return travelRepository.findTravelByUser(user);
    }

    public void saveTravel(Travel travelToSave){
        travelRepository.save(travelToSave);
    }

    public void deleteTravelById(String id){
        travelRepository.deleteById(id);
    }

    public void deleteTravel(Optional<Travel> travel){
        travelRepository.deleteTravel(travel);
    }

    public Travel updateTravel(String id, Travel travelToUpdate) {
        travelRepository.findById(id).orElseThrow(() -> new TravelNotFoundException(id));
        Travel updatedTravel = travelToUpdate.withId(id);
        return travelRepository.save(updatedTravel);
    }
}
