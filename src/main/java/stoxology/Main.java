package stoxology;

import java.io.PrintWriter;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

import stoxology.datacollator.DataRetrieval;
import stoxology.datacollator.twitterapi.TwitterDataRetrievalImpl;
import stoxology.datacollator.twitterapi.entities.TwitterDataExtract;
import stoxology.datacollator.alchemy.AlchemyExtractor;
import stoxology.datacollator.alchemy.entities.KeywordResult;

@SpringBootApplication
@Configuration
public class Main {

	public static void main(String[] args) {

		SpringApplication.run(Main.class, args);

		DataRetrieval twitterDataRet = new TwitterDataRetrievalImpl();
		AlchemyExtractor alcExtract = new AlchemyExtractor();
		List<TwitterDataExtract> twitterData = twitterDataRet.GetData();
		
		for(TwitterDataExtract tde : twitterData)
		{
			for (String url : tde.getUrlsOfInterest())
			{
				KeywordResult keywordResult = alcExtract.extractAll(url);
				
				if (keywordResult == null)				
					continue;				
				
				tde.getKeywordResults().add(keywordResult);
			}
		}
		
		ObjectMapper mapper = new ObjectMapper();
        try {
            String jsonResult = mapper.writeValueAsString(twitterData);
            PrintWriter out = new PrintWriter("TwitterJSONData.txt");
            out.println(jsonResult);
            out.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }               
	}

	@Bean
	public AlchemyExtractor createAlchemyKeywordExtractor() {
		return new AlchemyExtractor();
	}
}
