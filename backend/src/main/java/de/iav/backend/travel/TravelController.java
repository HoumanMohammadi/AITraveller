package de.iav.backend.travel;

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

    @GetMapping("/{userId}")
    public List<TravelWithoutIdDTO> getAllTravelsByUserId(@PathVariable String userId){
        return travelService.getTravelByUserId(userId);
    }

    @PostMapping
    public TravelWithoutIdDTO createTravel(@RequestBody NewTravelDTO newTravelDTO) {
        //APIResponse apiResponse= chatGPTClient.getChatSuggestion(apiRequest);
        return travelService.saveTravel(newTravelDTO);
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
