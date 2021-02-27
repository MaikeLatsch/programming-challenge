/**
 * 
 */
package de.exxcellent.challenge.reader;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test cases for FootballReader
 * 
 * @author Maike Latsch
 */
class FootballReaderTest {
	
	private FootballReader footballReader;

	@BeforeEach
	void setUp(){
		try {
			footballReader = new FootballReader("src/main/resources/de/exxcellent/challenge/footballTest.csv");
		}catch(FileNotFoundException e) {
			fail("test file not found");
		}
	}

	/**
	 * Test method for {@link de.exxcellent.challenge.reader.FootballReader#getData()}.
	 */
	@Test
	void testGetData() {
		ArrayList<DataUnit> expected = new ArrayList<DataUnit>();
		ArrayList<DataUnit> actual = footballReader.getData();
		
		expected.add(new FootballTeam("Liverpool",67,30));
		expected.add(new FootballTeam("Manchester United",87,45));
		
		for(int i = 0; i < expected.size(); i++) {
			assertTrue(expected.get(i).isEqual(actual.get(i)));
		}	
	}

	/**
	 * Test method for {@link de.exxcellent.challenge.reader.FootballReader#FootballReader(java.lang.String)}.
	 */
	@Test
	void testFootballReader() {
		try {
			footballReader = new FootballReader("file/does/not/exist");
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
		footballReader.getNextLineSplitAtComma();
		
		ArrayList<String[]> expected = new ArrayList<String[]>();
		ArrayList<String[]> result = new ArrayList<String[]>();
		
		String[] attributes1 = {"Arsenal", "38"};
		expected.add(attributes1);
		
		String[] attributes2 = {"Liverpool","38","24","8","6","67","30","80"};
		expected.add(attributes2);
		
		String[] attributes3 = {""};
		expected.add(attributes3);
		
		String[] attributes4 = {"Manchester United","38","24","5","9","87","45","77"};
		expected.add(attributes4);
		
		for(int i = 0; i < expected.size(); i++) {
			String[] actual = footballReader.getNextLineSplitAtComma();
			result.add(actual);
		}
		
		for(int i = 0; i < expected.size(); i++) {
			for(int j = 0; j < expected.get(i).length; j++) {
				assertEquals(expected.get(i)[j], result.get(i)[j]);
			}
		}
	}

}
