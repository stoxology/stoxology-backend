package stoxology;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import stoxology.datacollator.DataRetrieval;
import stoxology.datacollator.twitterapi.TwitterDataRetrievalImpl;
import stoxology.datacollator.twitterapi.entities.Entities;
import stoxology.datacollator.twitterapi.entities.Example;
import stoxology.datacollator.twitterapi.entities.TwitterDataExtract;
import stoxology.datacollator.alchemy.AlchemyExtractor;

@SpringBootApplication
@Configuration
public class Main {

	public static void main(String[] args) {

		SpringApplication.run(Main.class, args);

		DataRetrieval twitterDataRet = new TwitterDataRetrievalImpl();
		//Example[] twitterData = twitterDataRet.GetData();
		List<TwitterDataExtract> tde = twitterDataRet.GetData();
	}

	@Bean
	public AlchemyExtractor createAlchemyKeywordExtractor() {
		return new AlchemyExtractor();
	}
}
