package de.exxcellent.challenge.reader;

/**
 * DataUnit represents one line from the csv-file. It is a unit of data needed for subsequent calculation.
 * 
 * @author Maike Latsch
 */
public interface DataUnit {
	
	/**
	 * Returns the Name of the data unit.
	 * @return String
	 */
	public String getDataName();
	
	/**
	 * Returns the first attribute of data unit.
	 * @return int
	 */
	public int getFirstAttribute();
	
	/**
	 * Returns the second attribute of data unit.
	 * @return int
	 */
	public int getSecondAttribute();
}
