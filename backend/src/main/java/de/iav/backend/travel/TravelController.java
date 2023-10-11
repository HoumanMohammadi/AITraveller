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

    @GetMapping("/{id}")
    public List<Travel> getAllTravelsById(@PathVariable String id){
        return travelService.getTravelByUserId(id);
    }

    @PostMapping
    public TravelWithoutIdDTO createTravel(@RequestBody NewTravelDTO newTravelDTO) {
        //APIResponse apiResponse= chatGPTClient.getChatSuggestion(apiRequest);
        return travelService.saveTravel(newTravelDTO);
    }

    @PutMapping("/{id}")
    public Travel updateTravel(@PathVariable String id, @RequestBody Travel travel){
        return travelService.updateTravel(id, travel);
    }

    @DeleteMapping("/{id}")
    public void deleteTravel(@PathVariable String id){
        travelService.deleteTravelById(id);
    }
}
