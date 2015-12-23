package stoxology.datacollator.alchemy;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import stoxology.datacollator.Utility;
import stoxology.datacollator.alchemy.entities.AlchemyCombined;
import stoxology.datacollator.alchemy.entities.AlchemySentiment;
import stoxology.datacollator.alchemy.entities.AlchemyTargetedSentiment;
import stoxology.datacollator.alchemy.entities.CombinedKeywordSentiment;
import stoxology.datacollator.alchemy.entities.Keyword;
import stoxology.datacollator.alchemy.entities.KeywordDetails;
import stoxology.datacollator.alchemy.entities.KeywordResult;
import stoxology.datacollator.alchemy.entities.Result;

public class AlchemyExtractor {
	public static final String API_KEY = "4bfcda315cafac05e00c8eeddb4a2b2b034584d2";
	public static final String SENTIMENT = "http://gateway-a.watsonplatform.net/calls/url/URLGetTextSentiment";
	public static final String FULL_SENTIMENT = SENTIMENT + "?apikey=" + API_KEY + "&outputMode=json&url=%s";
	public static final String FULL_COMBINED = "http://gateway-a.watsonplatform.net/calls/url/URLGetCombinedData"
			+ "?extract=keyword,doc-sentiment,pub-date&apikey=" + API_KEY + "&outputMode=json&url=%s";
	public static final String FULL_TARGETED_SENTIMENT = "http://gateway-a.watsonplatform.net/calls/url/URLGetTargetedSentiment"
			+ "?apikey=" + API_KEY + "&outputMode=json&url=%s&targets=%s";

	public KeywordResult extractAll(String url) {
		String data = Utility.getUrlData(String.format(FULL_COMBINED, url));

		AlchemyCombined alchemyData = Utility.convertToObject(AlchemyCombined.class, data);
		StringBuilder targetedWords = new StringBuilder();

		for (Keyword keyword : alchemyData.getKeywords()) {
			targetedWords.append(keyword.getText()).append("|");
		}

		String words = targetedWords.toString();
		
		if (words.isEmpty()) return null;
		
		String pipedWords = words.substring(0, words.length() - 1);
		String apiUrl = String.format(FULL_TARGETED_SENTIMENT, url, pipedWords);
		apiUrl = apiUrl.replace(" ", "%20");

		String sentimentData = Utility.getUrlData(apiUrl);
		AlchemyTargetedSentiment targetedSentiment = Utility.convertToObject(AlchemyTargetedSentiment.class, sentimentData);

		return extractKeywordDetails(combineResults(alchemyData, targetedSentiment), alchemyData);
	}

	private KeywordResult extractKeywordDetails(List<CombinedKeywordSentiment> combined, AlchemyCombined alchemyData) {
		KeywordResult result = new KeywordResult();

		try {
			String date = alchemyData.getPublicationDate().getDate();
			date = date.replace('T', '-');
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss", Locale.UK);
			LocalDateTime localDateTime = LocalDateTime.parse(date, formatter);

			result.setTimestamp(localDateTime.toEpochSecond(ZoneOffset.UTC) + "");

			for (CombinedKeywordSentiment keywordSentiment : combined) {
				String sentimentScoreString = keywordSentiment.getResult().getSentiment().getScore();
				String keywordRelevanceScoreString = keywordSentiment.getKeyword().getRelevance();
				Double sentimentScore = 0d;
				Double keywordRelevanceScore = 0d;

				if (sentimentScoreString != null) {
					sentimentScore = Double.parseDouble(keywordSentiment.getResult().getSentiment().getScore());
				}

				if (keywordRelevanceScoreString != null) {
					keywordRelevanceScore = Double.parseDouble(keywordSentiment.getKeyword().getRelevance());
				}

				KeywordDetails detail = new KeywordDetails(keywordSentiment.getKeyword().getText(), keywordRelevanceScore, sentimentScore,
						keywordSentiment.getResult().getSentiment().getType());
				result.addKeywordDetails(detail);
			}

			return result;
		} catch (Exception e) {
			// do nothing..
		}
		
		return null;
	}

	private List<CombinedKeywordSentiment> combineResults(AlchemyCombined alchemyData, AlchemyTargetedSentiment targetedSentiment) {
		List<CombinedKeywordSentiment> combined = new ArrayList<CombinedKeywordSentiment>();
		for (Keyword keyword : alchemyData.getKeywords()) {
			for (Result result : targetedSentiment.getResults()) {
				if (keyword.getText().toLowerCase().equals(result.getText().toLowerCase())) {
					combined.add(new CombinedKeywordSentiment(keyword, result));
				}
			}
		}

		return combined;
	}

	public String extractSentiment(String url) {
		String data = Utility.getUrlData(String.format(FULL_SENTIMENT, url));
		System.out.println(data);

		AlchemySentiment alchemySentiment = Utility.convertToObject(AlchemySentiment.class, data);

		if (alchemySentiment == null) {
			return "failed";
		}

		return data;
	}
}
