package de.iav.backend.travel;

import de.iav.backend.exception.InvalidRequestException;
import de.iav.backend.exception.TravelNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/aitraveller/travels")
public class TravelController {

    private final TravelService travelService;

    public TravelController(TravelService travelService) {
        this.travelService = travelService;
    }

    @GetMapping
    public List<TravelWithoutIdDTO> getAllTravels(){
        return travelService.getAllTravels();
    }

    @GetMapping("/{userId}")
    public List<TravelWithoutIdDTO> getAllTravelsByUserId(@PathVariable String userId){
        return travelService.getTravelByUserId(userId);
    }

    @PostMapping
    public ResponseEntity<Travel> createTravel(@RequestBody NewTravelDTO newTravelDTO) {
        try {
            Travel createdTravel = travelService.saveTravel(newTravelDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdTravel);
        } catch (InvalidRequestException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }



    @PutMapping("/{id}")
    public ResponseEntity<?> updateTravel(@PathVariable String id, @RequestBody NewTravelDTO newTravelDTO) {
        try {
            TravelWithoutIdDTO updatedTravel = travelService.updateTravel(id, newTravelDTO);
            return ResponseEntity.ok(updatedTravel);
        } catch (TravelNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Travel with id " + id + " not found");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTravel(@PathVariable String id) {
        try {
            travelService.deleteTravelById(id);
            return ResponseEntity.ok("Travel with id " + id + " deleted successfully");
        } catch (TravelNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Travel with id " + id + " not found");
        }
    }

}
