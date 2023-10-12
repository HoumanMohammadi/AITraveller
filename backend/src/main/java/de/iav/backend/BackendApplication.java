package de.iav.backend;

import de.iav.backend.gptApiCommunication.ChatGPTAPIRequest;
import de.iav.backend.gptApiCommunication.TransformQuestionerToText;
import de.iav.backend.travel.Travel;
import de.iav.backend.travel.TravelRepository;
import de.iav.backend.travel.TravelService;
import de.iav.backend.user.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

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
