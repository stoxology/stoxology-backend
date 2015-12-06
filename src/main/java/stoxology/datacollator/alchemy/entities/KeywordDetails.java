package stoxology.datacollator.alchemy.entities;

public class KeywordDetails {
	private String keyword;
	private Double relevanceScore;
	private Double sentimentScore;
	private String type;

	public KeywordDetails() {

	}

	public KeywordDetails(String keyword, Double relevanceScore, Double sentimentScore, String type) {
		this.keyword = keyword;
		this.relevanceScore = relevanceScore;
		this.sentimentScore = sentimentScore;
		this.type = type;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Double getRelevanceScore() {
		return relevanceScore;
	}

	public void setRelevanceScore(Double relevanceScore) {
		this.relevanceScore = relevanceScore;
	}

	public Double getSentimentScore() {
		return sentimentScore;
	}

	public void setSentimentScore(Double sentimentScore) {
		this.sentimentScore = sentimentScore;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
