package de.exxcellent.challenge.reader;

/**
 * This is a unit of the required weather data of one day.
 * It contains the day of the month as name attribute and the maximum and minimum temperature of the day. 
 * 
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
	
	@Override
	public boolean isEqual(DataUnit other) {
		// return true if all attributes are equal
		return (
				other.getDataName().equals(this.day) &&
				other.getFirstAttribute() == this.maxTemp &&
				other.getSecondAttribute() == this.minTemp
				);
	}


}
