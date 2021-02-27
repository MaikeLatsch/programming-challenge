package de.exxcellent.challenge.analysis;

import java.util.ArrayList;
import de.exxcellent.challenge.reader.DataUnit;

/**
 * Analysis list of DataUnits to get the dataUnit with the minimum difference of attributes
 * 
 * @author Maike Latsch
 */
public class DataUnitAnalysis {
	
	/**
	 * return the absolute difference of given numbers
	 * 
	 * @param dataUnit The DataUnit with the two attributes
	 * @return absolute difference of attributes
	 */
	private int getAbsoluteDifference(DataUnit dataUnit) {
		
		// difference of both attributes
		int diff = dataUnit.getSecondAttribute() - dataUnit.getFirstAttribute();
		
		// return the absolute difference of given numbers
		return Math.abs(diff);
	}
	
	/**
	 * returns the dataUnit with the minimum difference of attributes
	 * 
	 * @param dataUnitList List of dataUnits
	 * @return dataUnit with the minimum difference of attributes
	 */
	protected DataUnit getDataUnitWithMinDiff(ArrayList<DataUnit> dataUnitList) {
		
		// check empty list before get first element
		if (dataUnitList == null) {
			return null;
		}
		// get first element and difference of attributes
		DataUnit result = dataUnitList.get(0);
		int minDiff = this.getAbsoluteDifference(result);
		
		// loop helper
		int currentDiff;
		
		// check each list element for minimum difference of attributes
		for(DataUnit dataUnit: dataUnitList) {
			currentDiff = this.getAbsoluteDifference(dataUnit);
			if ( currentDiff < minDiff) {
				// set new minimum
				result = dataUnit;
				minDiff = currentDiff;
			}
		}
		
		return result;
	}
}
