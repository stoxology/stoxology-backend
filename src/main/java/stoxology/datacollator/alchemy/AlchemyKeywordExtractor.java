package stoxology.datacollator.alchemy;

import stoxology.datacollator.WebExtractor;

import com.fasterxml.jackson.databind.ObjectMapper;

public class AlchemyKeywordExtractor {
	public static final String API_KEY = "4bfcda315cafac05e00c8eeddb4a2b2b034584d2";
	
	public boolean extractUrlKeywords(String apiUrl) {
		
		String data = WebExtractor.getUrlData(apiUrl);
		
		// TODO: Change data into model.
		
		return true;
	}
	
	
}
