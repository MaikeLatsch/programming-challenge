package de.exxcellent.challenge.analysis;

import de.exxcellent.challenge.reader.FootballReader;
import de.exxcellent.challenge.reader.DataUnit;

import java.io.FileNotFoundException;

/**
 * Can analyse football data from a file 
 * 
 * @author Maike Latsch
 */
public class FootballAnalysis extends DataUnitAnalysis {
	
	/**
	 * Returns the name of football team with the minimum goal difference from the given file.
	 * If there are two team with the same minimal goal difference, it returns the first team.
	 * 
	 * @param filename with football data
	 * @return String The name of football team with the minimum goal difference
	 */
	public String getTeamWithSmallestGoalSpread( String filename) {
		
		// footballReader can generate a list of football data units from a csv file
		FootballReader footballReader;
		
		// try to open the file
		try {
			footballReader = new FootballReader(filename);
		}catch(FileNotFoundException e) {
			return "";
		}
		
		// get team with minimum difference of goals
		DataUnit resultDataUnit = getDataUnitWithMinDiff(footballReader.getData());
		
		// return the name of the football team with the minimum goal difference
		if (resultDataUnit != null) {
			return resultDataUnit.getDataName();
		}else {
			return "";
		}
		
		
	}
}
