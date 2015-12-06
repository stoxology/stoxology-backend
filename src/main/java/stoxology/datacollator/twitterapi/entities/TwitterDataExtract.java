package stoxology.datacollator.twitterapi.entities;

import java.util.ArrayList;
import java.util.List;

import stoxology.datacollator.alchemy.entities.KeywordResult;

public class TwitterDataExtract {

	private List<String> urlsOfInterest;
	private int retweetCount;
	private int favouriteCount;
	private String createdAt;
	private List<KeywordResult> keywordResults;
	
	public List<String> getUrlsOfInterest() {
		if (urlsOfInterest == null)
			urlsOfInterest = new ArrayList<String>();
		return urlsOfInterest;
	}
	public void setUrlsOfInterest(List<String> urlsOfInterest) {
		this.urlsOfInterest = urlsOfInterest;
	}
	public int getRetweetCount() {
		return retweetCount;
	}
	public void setRetweetCount(int retweetCount) {
		this.retweetCount = retweetCount;
	}
	public int getFavouriteCount() {
		return favouriteCount;
	}
	public void setFavouriteCount(int favouriteCount) {
		this.favouriteCount = favouriteCount;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}	
	public List<KeywordResult> getKeywordResults() {
		if (keywordResults == null)
			keywordResults = new ArrayList<KeywordResult>();
		return keywordResults;
	}
	public void setKeywordResults(List<KeywordResult> keywordResults) {
		this.keywordResults = keywordResults;
	}
}
