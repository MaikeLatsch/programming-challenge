package de.exxcellent.challenge.reader;

/**
 * This is a unit of the required football data of one team.
 * It contains the team name and the goals and the goals allowed. 
 * 
 * @author Maike Latsch
 *
 */
public class FootballTeam implements DataUnit {
	
	// name of the football team
	private String name;
	
	// goals 
	private int goals;
	
	// goalsAllowed
	private int goalsAllowed;
	
	public FootballTeam( String name, int goals, int goalsAllowed) {
		this.name = name;
		this.goals = goals;
		this.goalsAllowed = goalsAllowed;
	}

	@Override
	public String getDataName() {
		// return the football team name
		return name;
	}

	@Override
	public int getFirstAttribute() {
		// return the number of goals
		return goals;
	}

	@Override
	public int getSecondAttribute() {
		// return the number of allowed goals
		return goalsAllowed;
	}
	
	@Override
	public boolean isEqual(DataUnit other) {
		// return true if all attributes are equal
		return (
				other.getDataName().equals(this.name) &&
				other.getFirstAttribute() == this.goals &&
				other.getSecondAttribute() == this.goalsAllowed
				);
	}


}
