package de.iav.backend.travel;

import de.iav.backend.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TravelRepository extends MongoRepository<Travel, String> {


    List<Travel> findTravelByUser(Optional<User> user);

    List<Travel> findTravelsByUser_Id(String id);

    Optional<Travel> findTravelById(String id);

    }

