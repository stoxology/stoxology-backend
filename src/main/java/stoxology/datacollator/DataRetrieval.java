package stoxology.datacollator;

import stoxology.datacollator.twitterapi.entities.Example;

public interface DataRetrieval {
	
	/**
	 * Retrieve raw data from the data source
	 */
	public Example[] GetData();

}
