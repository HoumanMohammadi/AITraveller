package de.iav.backend.travel;

import de.iav.backend.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TravelRepository extends MongoRepository<Travel, String> {


    List<Travel> findTravelByUser(Optional<User> user);
}
