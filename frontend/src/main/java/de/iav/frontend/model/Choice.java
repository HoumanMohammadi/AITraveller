package de.iav.frontend.model;

public record Choice(
        int index,
        Message message,
        String finish_reason
) {
}
