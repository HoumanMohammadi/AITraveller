package de.iav.backend.gptApiCommunication;

import java.util.List;

public class ChatGPTResponse {

    String id;
    String model;
    List<Choice> choices;

    public ChatGPTResponse(String id, String model, List<Choice> choices) {
        this.id = id;
        this.model = model;
        this.choices = choices;
    }

    public ChatGPTResponse() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }
}
