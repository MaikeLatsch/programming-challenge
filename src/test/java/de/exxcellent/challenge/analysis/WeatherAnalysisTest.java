package de.exxcellent.challenge.analysis;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import de.exxcellent.challenge.reader.*;

/**
 * Test cases for WeatherAnalysis
 * 
 * @author Maike Latsch
 */
class WeatherAnalysisTest {

	private WeatherAnalysis weatherAnalysis = new WeatherAnalysis();

	/**
	 * Test method for {@link de.exxcellent.challenge.analysis.WeatherAnalysis#getDayWithSmallestTemperatureSpread(java.lang.String)}.
	 * with weatherTest.csv
	 */
	@Test
	void testGetDayWithSmallestTemperatureSpreadTestFile() {
		// get day with smallest temperature spread from weatherTest.csv
		String result = weatherAnalysis.getDayWithSmallestTemperatureSpread("src/main/resources/de/exxcellent/challenge/weatherTest.csv");
		assertEquals("2", result);
	}
	
	/**
	 * Test method for {@link de.exxcellent.challenge.analysis.WeatherAnalysis#getDayWithSmallestTemperatureSpread(java.lang.String)}.
	 * with weather.csv
	 */
	@Test
	void testGetDayWithSmallestTemperatureSpread() {
		// get day with smallest temperature spread from weatherTest.csv
		String result = weatherAnalysis.getDayWithSmallestTemperatureSpread("src/main/resources/de/exxcellent/challenge/weather.csv");
		assertEquals("14", result);
	}	

	/**
	 * Test method for {@link de.exxcellent.challenge.analysis.DataUnitAnalysis#getDataUnitWithMinDiff(java.util.ArrayList)}.
	 */
	@Test
	void testGetDataUnitWithMinDiff() {
		
		//create data unit list with two minimal differences
		ArrayList<DataUnit> dataUnitList = new ArrayList<DataUnit>();
		dataUnitList.add(new WeatherDay("1", 100, 10));
		dataUnitList.add(new WeatherDay("min", 70, 65));
		dataUnitList.add(new WeatherDay("sameMin", 60, 55));
		
		DataUnit result = weatherAnalysis.getDataUnitWithMinDiff(dataUnitList);
		assertEquals("min", result.getDataName());
	}

}
