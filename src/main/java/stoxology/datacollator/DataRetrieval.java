package stoxology.datacollator;

import java.util.List;

import stoxology.datacollator.twitterapi.entities.TwitterDataExtract;

public interface DataRetrieval {
	
	/**
	 * Retrieve raw data from the data source 
	 * ToDo: not really a generic return type, change in future
	 */
	public List<TwitterDataExtract> GetData();

}
