package de.exxcellent.challenge.reader;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test cases for FootballTeam
 * 
 * @author Maike Latsch
 */
class FootballTeamTest {
	private FootballTeam footballTeam = null;

	@BeforeEach
	void setUp() throws Exception {
		footballTeam = new FootballTeam("Arsenal", 79, 36);
	}

	@Test
	void testFootballTeam() {
		assertNotNull(footballTeam);
	}

	@Test
	void testGetDataName() {
		assertEquals("Arsenal", footballTeam.getDataName());
	}

	@Test
	void testGetFirstAttribute() {
		assertEquals(79, footballTeam.getFirstAttribute());
	}

	@Test
	void testGetSecondAttribute() {
		assertEquals(36, footballTeam.getSecondAttribute());
	}

	@Test
	void testIsEqual() {
		FootballTeam same = new FootballTeam("Arsenal", 79,36);
		FootballTeam otherName = new FootballTeam("Real", 79,36);
		FootballTeam otherGoals = new FootballTeam("Arsenal", 60,36);
		FootballTeam otherGoalsAllowed = new FootballTeam("Arsenal",79,50);
		
		assertTrue(footballTeam.isEqual(same));
		assertFalse(footballTeam.isEqual(otherName));
		assertFalse(footballTeam.isEqual(otherGoals));
		assertFalse(footballTeam.isEqual(otherGoalsAllowed));
	}

}
