package net.javaguides.springboot;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Spring Boot Rest APi Documentation",
				description = "Spring Boot Rest APi Documentation",
				version= "v1.08",
				contact = @Contact(
						name = "Bakhtawar Changezi",
						email = "bakhtawarChangezi@gmail.com",
						url = "https://github.com/BakhtawarChangezi"

				),
				license = @License(
						name = "Apache 2.0",
						url = "https://www.BakhtawarChangezi/license"
				)

		),
		externalDocs = @ExternalDocumentation(
				description = "Spring boot user Management Docuementation",
				url = "https://github.com/BakhtawarChangezi/user_management.html"
		)

)
public class SpringbootRestfulwebservicesApplication {

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRestfulwebservicesApplication.class, args);
	}



}
