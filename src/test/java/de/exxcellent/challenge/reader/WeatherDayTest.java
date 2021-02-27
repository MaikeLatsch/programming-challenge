package de.exxcellent.challenge.reader;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test cases for WeatherDay
 * 
 * @author Maike Latsch
 *
 */
class WeatherDayTest {
	private WeatherDay weatherDay = null;

	
    @BeforeEach
    void setUp() {
		weatherDay = new WeatherDay("1", 90, 60);
    }

	/**
	 * Test method for {@link de.exxcellent.challenge.reader.WeatherDay#WeatherDay(java.lang.String, int, int)}.
	 */
	@Test
	void testWeatherDay() {
		assertNotNull(weatherDay);
	}

	/**
	 * Test method for {@link de.exxcellent.challenge.reader.WeatherDay#getDataName()}.
	 */
	@Test
	void testGetDataName() {
		assertEquals("1", weatherDay.getDataName());
	}

	/**
	 * Test method for {@link de.exxcellent.challenge.reader.WeatherDay#getFirstAttribute()}.
	 */
	@Test
	void testGetFirstAttribute() {
		assertEquals(90, weatherDay.getFirstAttribute());
	}

	/**
	 * Test method for {@link de.exxcellent.challenge.reader.WeatherDay#getSecondAttribute()}.
	 */
	@Test
	void testGetSecondAttribute() {
		assertEquals(60, weatherDay.getSecondAttribute());
	}

	/**
	 * Test method for {@link de.exxcellent.challenge.reader.WeatherDay#isEqual(de.exxcellent.challenge.reader.WeatherDay)}.
	 */
	@Test
	void testIsEqual() {
		WeatherDay same = new WeatherDay("1", 90, 60);
		WeatherDay otherName = new WeatherDay("2", 90, 60);
		WeatherDay otherMaxTemp = new WeatherDay( "1", 100, 60);
		WeatherDay otherMinTemp = new WeatherDay("1", 90, 30);
		
		assertTrue(weatherDay.isEqual(same));
		assertFalse(weatherDay.isEqual(otherName));
		assertFalse(weatherDay.isEqual(otherMaxTemp));
		assertFalse(weatherDay.isEqual(otherMinTemp));

	}
}
