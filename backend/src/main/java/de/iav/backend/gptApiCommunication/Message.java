package de.iav.backend.gptApiCommunication;

public class Message {

    String role;
    String content;

    public Message(String role, String content) {
        this.role = role;
        this.content = content;
    }

    public Message() {
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
