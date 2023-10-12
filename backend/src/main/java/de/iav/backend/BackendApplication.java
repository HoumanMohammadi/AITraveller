package de.iav.backend;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import de.iav.backend.gptApiCommunication.ChatGPTAPIRequest;
import de.iav.backend.gptApiCommunication.TransformQuestionerToText;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class BackendApplication {

	@Bean
	public ObjectMapper objectMapper() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		System.out.println("JavaTimeModule registered!");
		return mapper;
	}


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
