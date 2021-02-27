package de.exxcellent.challenge.analysis;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import de.exxcellent.challenge.reader.*;

/**
 * Test cases for FootballAnalysis
 * 
 * @author Maike Latsch
 */
class FootballAnalysisTest {
	
	private FootballAnalysis footballAnalysis = new FootballAnalysis();

	/**
	 * Test method for {@link de.exxcellent.challenge.analysis.FootballAnalysis#getTeamWithSmallestGoalSpread(java.lang.String)}.
	 */
	@Test
	void testGetTeamWithSmallestGoalSpreadTestFile() {
		// get team with smallest goal spread
		String result = footballAnalysis.getTeamWithSmallestGoalSpread("src/main/resources/de/exxcellent/challenge/footballTest.csv");
		assertEquals("Liverpool", result);
	}
	
	/**
	 * Test method for {@link de.exxcellent.challenge.analysis.FootballAnalysis#getTeamWithSmallestGoalSpread(java.lang.String)}.
	 */
	@Test
	void testGetTeamWithSmallestGoalSpread() {
		// get team with smallest goal spread
		String result = footballAnalysis.getTeamWithSmallestGoalSpread("src/main/resources/de/exxcellent/challenge/football.csv");
		assertEquals("Aston_Villa", result);
	}	

	/**
	 * Test method for {@link de.exxcellent.challenge.analysis.DataUnitAnalysis#getDataUnitWithMinDiff(java.util.ArrayList)}.
	 */
	@Test
	void testGetDataUnitWithMinDiff() {
		
		//create data unit list with two minimal differences
		ArrayList<DataUnit> dataUnitList = new ArrayList<DataUnit>();
		dataUnitList.add(new FootballTeam("Arsenal", 100, 10));
		dataUnitList.add(new FootballTeam("min", 70, 65));
		dataUnitList.add(new FootballTeam("sameMin", 60, 55));
		dataUnitList.add(new FootballTeam("Real", 10, 80));
			
		DataUnit result = footballAnalysis.getDataUnitWithMinDiff(dataUnitList);
		assertEquals("min", result.getDataName());
	}

}
