package stoxology.datacollator.alchemy.entities;

public class CombinedKeywordSentiment {
	private Keyword keyword;
	private Result result;
	
	public CombinedKeywordSentiment() {
		
	}
	
	public CombinedKeywordSentiment(Keyword keyword, Result result) {
		this.keyword = keyword;
		this.result = result;
	}

	public Keyword getKeyword() {
		return keyword;
	}

	public void setKeyword(Keyword keyword) {
		this.keyword = keyword;
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}
}
