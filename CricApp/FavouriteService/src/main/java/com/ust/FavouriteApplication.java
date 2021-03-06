package com.ust;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class FavouriteApplication {

	public static void main(String[] args) {
		SpringApplication.run(FavouriteApplication.class,args);

	}
	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}

}
