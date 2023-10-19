package de.iav.frontend.model;

import java.util.List;

public record ChatGPTResponse(
        String id,
        String model,
        List<Choices>choices
) {
}
