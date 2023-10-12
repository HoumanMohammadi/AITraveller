package de.iav.backend.travel;

import de.iav.backend.exception.InvalidRequestException;
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
    public ResponseEntity<TravelWithoutIdDTO> createTravel(@RequestBody NewTravelDTO newTravelDTO) {
        try {
            TravelWithoutIdDTO createdTravel = travelService.saveTravel(newTravelDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdTravel);
        } catch (InvalidRequestException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }



    @PutMapping("/{id}")
    public TravelWithoutIdDTO updateTravel(@PathVariable String id, @RequestBody NewTravelDTO newTravelDTO){
        return travelService.updateTravel(id, newTravelDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteTravel(@PathVariable String id){
        travelService.deleteTravelById(id);
    }
}
