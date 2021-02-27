/**
 * 
 */
package de.exxcellent.challenge.reader;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * Test cases for WeatherReader
 * 
 * @author Maike Latsch
 */
class WeatherReaderTest {
	
	private WeatherReader weatherReader;

	@BeforeEach
	void setUp() {
		try {
			weatherReader = new WeatherReader("src/main/resources/de/exxcellent/challenge/weatherTest.csv");
		}catch(FileNotFoundException e) {
			fail("test file not found");
		}
	}

	/**
	 * Test method for {@link de.exxcellent.challenge.reader.WeatherReader#getData()}.
	 */
	@Test
	void testGetData() {
		ArrayList<DataUnit> expected = new ArrayList<DataUnit>();
		ArrayList<DataUnit> actual = weatherReader.getData();
		
		expected.add(new WeatherDay("1",88,59));
		expected.add(new WeatherDay("2",79,63));
		
		for(int i = 0; i < expected.size(); i++) {
			assertTrue(expected.get(i).isEqual(actual.get(i)));
		}

	}

	/**
	 * Test method for {@link de.exxcellent.challenge.reader.WeatherReader#WeatherReader(java.lang.String)}.
	 */
	@Test
	void testWeatherReader() {
		try {
			weatherReader = new WeatherReader("file/does/not/exist");
			fail("expected exception does not occur");
		}catch(FileNotFoundException e) {
			assertTrue(true); // exception occured
		}
	}


	/**
	 * Test method for {@link de.exxcellent.challenge.reader.CsvReader#getNextLineSplitAtComma()}.
	 */
	@Test
	void testGetNextLineSplitAtComma() {
		
		// skip first line
		weatherReader.getNextLineSplitAtComma();
		
		ArrayList<String[]> expected = new ArrayList<String[]>();
		ArrayList<String[]> result = new ArrayList<String[]>();
		
		String[] attributes1 = {"1","88","59","74","53.8","0","280","9.6","270","17","1.6","93","23","1004.5"};
		expected.add(attributes1);
		
		String[] attributes2 = {""};
		expected.add(attributes2);
		
		String[] attributes3 = {"2","79","63","71","46.5","0","330","8.7","340","23","3.3","70","28","1004.5"};
		expected.add(attributes3);
		
		String[] attributes4 = {"3"};
		expected.add(attributes4);
		
		for(int i = 0; i < expected.size(); i++) {
			String[] actual = weatherReader.getNextLineSplitAtComma();
			result.add(actual);
		}
		
		for(int i = 0; i < expected.size(); i++) {
			for(int j = 0; j < expected.get(i).length; j++) {
				assertEquals(expected.get(i)[j], result.get(i)[j]);
			}
		}
	}

}
