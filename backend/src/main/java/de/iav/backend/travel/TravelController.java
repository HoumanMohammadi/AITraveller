package de.iav.backend.travel;

import de.iav.backend.gptApiCommunication.ChatGPTClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/aitraveller/travels")
public class TravelController {

    private final TravelService travelService;
    @Autowired
    private final ChatGPTClient chatGPTClient;

    public TravelController(TravelService travelService, ChatGPTClient chatGPTClient) {
        this.travelService = travelService;
        this.chatGPTClient = chatGPTClient;
    }

    @GetMapping("/{id}")
    public Optional<Travel> getAllTravelsById(@PathVariable String id){
        return travelService.getTravelById(id);
    }

    @PostMapping
    public Travel createTravel(@RequestBody Travel travel) {
        //APIResponse apiResponse= chatGPTClient.getChatSuggestion(apiRequest);
        travelService.saveTravel(travel);
        return travel;
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
