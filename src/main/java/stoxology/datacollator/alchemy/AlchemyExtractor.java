package stoxology.datacollator.alchemy;

import java.io.IOException;

import stoxology.datacollator.WebExtractor;
import stoxology.datacollator.alchemy.domain.keyword.AlchemyKeyword;
import stoxology.datacollator.alchemy.domain.sentiment.AlchemySentiment;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AlchemyExtractor {
	public static final String API_KEY = "4bfcda315cafac05e00c8eeddb4a2b2b034584d2";
	public static final String RANKED_KEYWORDS = "http://gateway-a.watsonplatform.net/calls/url/URLGetRankedKeywords";
	public static final String SENTIMENT = "http://gateway-a.watsonplatform.net/calls/url/URLGetTextSentiment";
	public static final String FULL_RANKED_KEYWORDS = RANKED_KEYWORDS + "?apikey=" + API_KEY + "&outputMode=json&url=%s";
	public static final String FULL_SENTIMENT = SENTIMENT + "?apikey=" + API_KEY + "&outputMode=json&url=%s";

	public String extractAll(String url) {
		String keywordData = WebExtractor.getUrlData(String.format(FULL_RANKED_KEYWORDS, url));
		String sentimentData = WebExtractor.getUrlData(String.format(FULL_SENTIMENT, url));
		

		AlchemyKeyword alchemyData = convertToObject(AlchemyKeyword.class, keywordData);
		AlchemySentiment alchemySentiment = convertToObject(AlchemySentiment.class, sentimentData);
		
		// TODO: Put this together.
		
		return "ok";
	}
	
	public String extractUrlKeywords(String url) {
		
		String data = WebExtractor.getUrlData(String.format(FULL_RANKED_KEYWORDS, url));
		System.out.println(data);
		
		AlchemyKeyword alchemyData = convertToObject(AlchemyKeyword.class, data);
		
		if (alchemyData == null) {
			return "Failed.";
		}

		saveDataToFile(data);
		
		return "OK";
	}
	
	public String extractSentiment(String url) {
		String data = WebExtractor.getUrlData(String.format(FULL_SENTIMENT, url));
		System.out.println(data);
		
		AlchemySentiment alchemySentiment = convertToObject(AlchemySentiment.class, data);
		
		if (alchemySentiment == null) {
			return "failed";
		}
		
		saveDataToFile(data);
		
		return data;
	}


	private <T> T convertToObject(Class<T> clazz,
			String data) {
		T model = null;
		 
		ObjectMapper mapper = new ObjectMapper();
		try {
			model = mapper.readValue(data, clazz);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return model;
	}
	
	
	private boolean saveDataToFile(String data) {
		
		
		
		// TODO:
		return true;
	}
}
