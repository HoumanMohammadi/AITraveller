package de.iav.backend.travel;

import de.iav.backend.travelSuggestion.TravelSuggestion;
import de.iav.backend.user.User;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;
import java.util.List;

public class Travel {

    @MongoId
    String id;
    TravelSuggestion travelSuggestion;
    @DBRef
    User user;
    LocalDateTime localDateTime;
    int age;
    List<String> coTraveller;
    String livingCity;
    boolean disability;
    int travelDuration;
    List<String> activity;
    String season;
    List<String> meansOfTravel;
    List<String> travelPurpose;
    List<String> destinationContinent;

}
