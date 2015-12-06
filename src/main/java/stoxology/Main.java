package stoxology;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import stoxology.datacollator.DataRetrieval;
import stoxology.datacollator.twitterapi.TwitterDataRetrievalImpl;

@SpringBootApplication
@Configuration
public class Main {

	 public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        
        DataRetrieval twitterDataRet = new TwitterDataRetrievalImpl();
        twitterDataRet.GetData();
    }
}
