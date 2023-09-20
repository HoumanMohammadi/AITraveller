package de.iav.frontend.gptApiCommunication;

public record Choice(
        int index,
        Message message,
        String finish_reason
) {
}
