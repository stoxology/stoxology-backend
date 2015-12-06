package stoxology.datacleanser;

import java.util.ArrayList;

public interface DataCleanser {

	/**
	 * Cleanse the next available data extracts using the scripts specified in the collection. 
	 * @param scriptNames A collection of Python script names to be run in sequence
	 * @return true if all ran successfully, false otherwise
	 */
	public boolean CleanseData(ArrayList<String> pythonScriptNames);
}
