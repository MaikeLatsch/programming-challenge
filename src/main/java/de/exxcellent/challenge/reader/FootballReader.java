package de.exxcellent.challenge.reader;

import java.util.ArrayList;
import java.io.FileNotFoundException;

/**
 * This class can read csv files with football data and provides a list of data units as football teams.
 * Each football team has a name, the goals and allowed goals.
 * 
 * @author Maike Latsch
 */
public class FootballReader extends CsvReader {
	
	private final static int NAME_COLUMN = 0;
	private final static int GOALS_COLUMN = 5;
	private final static int GOALSALLOWED_COLUMN = 6;
	private final static int MAX_COLUMN = Math.max( NAME_COLUMN, Math.max(GOALS_COLUMN, GOALSALLOWED_COLUMN));
	
	/**
	 * Constructor of FootballReader
	 * @param filename
	 * @throws FileNotFoundException
	 */
	public FootballReader(String filename) throws FileNotFoundException {
		super(filename);
	}

	@Override
	public ArrayList<DataUnit> getData() {
		
		// list of weather days
		ArrayList<DataUnit> footballTeams = new ArrayList<DataUnit>();
		
		// helper data unit and attributes
		FootballTeam footballTeam;
		String name = "";
		int goals = 0;
		int goalsAllowed = 0;
		
		// read the headline and return null if this is empty
		if ( this.getNextLineSplitAtComma() == null) {
			return null;
		}
		
		// read second line
		String[] lineAttributes = this.getNextLineSplitAtComma();
		
		// go through the lines and add footballTeam units to the list
		while (lineAttributes != null) {
			
			// continue if empty line
			if (lineAttributes.length >= MAX_COLUMN+1) {
				
				// helper to create weatherDay
				name = lineAttributes[NAME_COLUMN];
				goals = Integer.parseInt(lineAttributes[GOALS_COLUMN]);
				goalsAllowed = Integer.parseInt(lineAttributes[GOALSALLOWED_COLUMN]);
				
				// create footballTeam
				footballTeam = new FootballTeam(name, goals, goalsAllowed);
				
				// add weatherDay to list weatherDays
				footballTeams.add(footballTeam);
			}
			
			// get next split line
			lineAttributes = this.getNextLineSplitAtComma();
		}
		
		// return the list of all weatherDay units
		return footballTeams;
	}

}
