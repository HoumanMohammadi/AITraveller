package de.iav.frontend.model;

public record Choices(
        int index,
        Message message,
        String finish_reason
) {
}
