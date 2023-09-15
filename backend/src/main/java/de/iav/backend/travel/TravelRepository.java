package de.iav.backend.travel;

import de.iav.backend.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TravelRepository extends MongoRepository<Travel, String> {


    default Optional<Travel> findTravelByUser(Optional<User> user) {
        return user.flatMap(u -> findById(u.getId()));
    }

    default void deleteTravel(Optional<Travel> travel){
        travel.ifPresent(t -> findById(t.id));
    }
}
