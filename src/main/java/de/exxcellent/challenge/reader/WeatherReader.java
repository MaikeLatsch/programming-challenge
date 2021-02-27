package de.exxcellent.challenge.reader;

import java.util.ArrayList;
import java.io.FileNotFoundException;

/**
 * This class can read csv files with weather data and provides a list of data units as weather days.
 * Each weather day has the day number, the maximum temperature and the minimum temperature.
 * 
 * @author Maike Latsch
 */
public class WeatherReader extends CsvReader {
	
	/**
	 * Constructor of WeatherReader
	 * @param filename
	 * @throws FileNotFoundException
	 */
	public WeatherReader(String filename) throws FileNotFoundException {
		super(filename);
	}

	@Override
	public ArrayList<DataUnit> getData() {
		
		// list of weather days
		ArrayList<DataUnit> weatherMonth = new ArrayList<DataUnit>();
		
		// helper data unit and attributes
		WeatherDay weatherDay;
		String day = "";
		int maxTemp = 0;
		int minTemp = 0;
		
		// read the headline and return null if this is empty
		if ( this.getNextLineSplitAtComma() == null) {
			return null;
		}
		
		// read second line
		String[] lineAttributes = this.getNextLineSplitAtComma();
		
		// go through the lines and add weatherDay units to the list
		while (lineAttributes != null) {
			
			// continue if empty line
			if (lineAttributes.length >= 3) {
				
				// helper to create weatherDay
				day = lineAttributes[0];
				maxTemp = Integer.parseInt(lineAttributes[1]);
				minTemp = Integer.parseInt(lineAttributes[2]);
				
				// create weatherDay
				weatherDay = new WeatherDay(day, maxTemp, minTemp);
				
				// add weatherDay to list weatherDays
				weatherMonth.add(weatherDay);
			}
			
			// get next split line
			lineAttributes = this.getNextLineSplitAtComma();
		}
		
		// return the list of all weatherDay units
		return weatherMonth;
	}

}
