package de.iav.frontend.model;

import java.util.List;

public record APIResponse(
        String id,
        String model,
        List<Choice>choices
) {
}
