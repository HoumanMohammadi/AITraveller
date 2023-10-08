package de.iav.backend.gptApiCommunication;

import org.springframework.context.annotation.ComponentScan;

import java.util.List;
public class ChatGPTAPIRequest {
    private String model;
    private List<Message> messages;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
