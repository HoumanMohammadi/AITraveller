package de.iav.backend.travel;

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

    public Optional<Travel> getTravelByUserId(String id){
        return travelRepository.findById(id);
    }

    public List<Travel> getAllTravelByUser(Optional<User> user) {
        return travelRepository.findTravelByUser(user);
    }

    public void saveTravel(Travel travelToSave){
        travelRepository.save(travelToSave);
    }

}
