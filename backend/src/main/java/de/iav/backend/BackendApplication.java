package de.iav.backend;

import de.iav.backend.gptApiCommunication.ChatGPTAPIRequest;
import de.iav.backend.gptApiCommunication.TransformQuestionerToText;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}
	@Bean
	public ChatGPTAPIRequest chatGPTAPIRequest() {
		return new ChatGPTAPIRequest();
	}
	@Bean
	public TransformQuestionerToText transformQuestionerToText(){return new TransformQuestionerToText();}

}
