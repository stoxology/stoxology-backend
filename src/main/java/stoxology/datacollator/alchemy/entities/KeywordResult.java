package stoxology.datacollator.alchemy.entities;

import java.util.ArrayList;
import java.util.List;

public class KeywordResult {
	private String timestamp;
	private List<KeywordDetails> keywordDetails;

	public KeywordResult() {
		this.keywordDetails = new ArrayList<KeywordDetails>();
	}

	public KeywordResult(String timestamp, List<KeywordDetails> keywordDetails) {
		super();
		this.timestamp = timestamp;
		this.keywordDetails = keywordDetails;
	}
	
	public void addKeywordDetails(KeywordDetails details) {
		this.keywordDetails.add(details);
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public List<KeywordDetails> getKeywordDetails() {
		return keywordDetails;
	}

	public void setKeywordDetails(List<KeywordDetails> keywordDetails) {
		this.keywordDetails = keywordDetails;
	}

}
