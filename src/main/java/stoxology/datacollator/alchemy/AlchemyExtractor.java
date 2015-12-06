package stoxology.datacollator.alchemy;

import java.io.IOException;

import stoxology.datacollator.Utility;
import stoxology.datacollator.alchemy.domain.combined.AlchemyCombined;
import stoxology.datacollator.alchemy.domain.combined.Keyword;
import stoxology.datacollator.alchemy.domain.sentiment.AlchemySentiment;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AlchemyExtractor {
	public static final String API_KEY = "4bfcda315cafac05e00c8eeddb4a2b2b034584d2";
	public static final String SENTIMENT = "http://gateway-a.watsonplatform.net/calls/url/URLGetTextSentiment";
	public static final String FULL_SENTIMENT = SENTIMENT + "?apikey=" + API_KEY + "&outputMode=json&url=%s";
	public static final String FULL_COMBINED = "http://gateway-a.watsonplatform.net/calls/url/URLGetCombinedData"
			+ "?extract=keyword,doc-sentiment&apikey=" + API_KEY + "&outputMode=json&url=%s";
	public static final String FULL_TARGETED_SENTIMENT = "http://gateway-a.watsonplatform.net/calls/url/URLGetTargetedSentiment"
			+ "?apikey=" + API_KEY + "&outputMode=json&url=%s&targets=%s";

	public String extractAll(String url) {
		String data = Utility.getUrlData(String.format(FULL_COMBINED, url));

		System.out.println(data);

		AlchemyCombined alchemyData = Utility.convertToObject(AlchemyCombined.class, data);

		StringBuilder targetedWords = new StringBuilder();
		
		for (Keyword keyword : alchemyData.getKeywords()) {
			targetedWords.append(keyword.getText()).append("|");
		}
		
		String pipedWords = targetedWords.toString().substring(0, targetedWords.toString().length() - 1);
		
		String apiUrl = String.format(FULL_TARGETED_SENTIMENT, url, pipedWords);
		apiUrl = apiUrl.replace(" ", "%20");
		
		String sentimentData = Utility.getUrlData(apiUrl);
		
		return sentimentData;
		
		
		// TODO: Put this together.

//		return data;
	}

	public String extractSentiment(String url) {
		String data = Utility.getUrlData(String.format(FULL_SENTIMENT, url));
		System.out.println(data);

		AlchemySentiment alchemySentiment = Utility.convertToObject(AlchemySentiment.class, data);

		if (alchemySentiment == null) {
			return "failed";
		}

		saveDataToFile(data);

		return data;
	}


	private boolean saveDataToFile(String data) {

		// TODO:
		return true;
	}
}
