package de.iav.backend.travel;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TravelRepository extends MongoRepository<Travel, String> {
}
