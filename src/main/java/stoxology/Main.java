package stoxology;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import stoxology.datacollator.alchemy.AlchemyExtractor;

@SpringBootApplication
@Configuration
public class Main {

	 public static void main(String[] args) {
	        SpringApplication.run(Main.class, args);
	    }
	 
	 @Bean
	 public AlchemyExtractor createAlchemyKeywordExtractor() {
		 return new AlchemyExtractor();
	 }
}
