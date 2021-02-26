package de.exxcellent.challenge.reader;

/**
 * @author Maike Latsch
 *
 */
public class WeatherDay implements DataUnit {
	
	// Day as the name of data unit
	private String day;
	
	// maximum temperature of the day as second attribute
	private int maxTemp;
	
	// minimum temperature of the day as second attribute
	private int minTemp;
	
	public WeatherDay( String day, int maxTemp, int minTemp) {
		this.day = day;
		this.maxTemp = maxTemp;
		this.minTemp = minTemp;
	}

	@Override
	public String getDataName() {
		// return the day as name of data unit
		return day;
	}

	@Override
	public int getFirstAttribute() {
		// return the maximum temperature of the day
		return maxTemp;
	}

	@Override
	public int getSecondAttribute() {
		// return the minimum temperature of the day
		return minTemp;
	}

}
