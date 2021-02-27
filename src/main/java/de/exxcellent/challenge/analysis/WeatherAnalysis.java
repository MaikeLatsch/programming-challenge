package de.exxcellent.challenge.analysis;

import de.exxcellent.challenge.reader.WeatherReader;
import de.exxcellent.challenge.reader.DataUnit;

import java.io.FileNotFoundException;

/**
 * Can analyse weather data from a file 
 * 
 * @author Maike Latsch
 */
public class WeatherAnalysis extends DataUnitAnalysis {
	
	/**
	 * Returns the day number with the minimum temperature difference from the given file
	 * 
	 * @param filename with weather data
	 * @return String The day number with the minimum temperature difference
	 */
	public String getDayWithSmallestTemperatureSpread(String filename) {
		
		// weatherReader can generate a list of weather data units from a csv file
		WeatherReader weatherReader;
		
		// try to open the file
		try {
			weatherReader = new WeatherReader(filename);
		}catch(FileNotFoundException e) {
			return "";
		}
		
		// get day with minimum difference of temperature
		DataUnit resultDataUnit = getDataUnitWithMinDiff(weatherReader.getData());
		
		// return the day number with the minimum temperature difference
		return resultDataUnit.getDataName();
		
		
	}
}
