package de.iav.frontend.gptApiCommunication;

import java.util.List;

public record APIResponse(
        String id,
        String model,
        List<Choice>choices
) {
}
