package de.exxcellent.challenge.reader;

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.IllegalStateException;
import java.util.Scanner;

/**
 * This class can read csv files and returns a list of data units with the needed data.
 * 
 * @author Maike Latsch
 */
public abstract class CsvReader {
	
	// scanner to read the file
	private Scanner scanner;
	
	/**
	 * Init the scanner with the file from the transferred filename
	 * 
	 * @param filename Filename from the csv weather data file.
	 */
	public CsvReader(String filename) throws FileNotFoundException{
		
		File file = new File(filename);
		
		// try to open the scanner with the file
		try {
			scanner = new Scanner(file);
			
		}
		catch(FileNotFoundException e) {
			// error message, if no file found
			System.err.println("File \"" + filename + "\" not found.");
			throw e;
		}
	}
	
	/**
	 * Returns the next line of file or an empty string. In case of eof it returns null.
	 * 
	 * @return String nextLine 
	 */
	private String getNextLine() {
		
		String line = null;
		
		// try to read next line, else return null
		try {
			if (scanner.hasNextLine()) {
				line = scanner.nextLine();
			}
			else {
				scanner.close();
			}
			
		} catch(IllegalStateException e) {
			//error message, if scanner is closed
			System.err.println("Can't read next line. Scanner is closed.");
		}
		return line;
	}
	
	/**
	 * Return the list of attributes of next line. The line is split at the commas. Each attribute is a field in the csv file.
	 * 
	 * @return attributes The next line is split in the attributes.
	 */
	protected String[] getNextLineSplitAtComma() {
		
		// get next line
		String line = this.getNextLine();
		
		// if no more lines return null
		if (line == null) {
			return null;
		}
		
		// split line in attributes 
		String[] attributes = line.split(",");
		
		// returns the attributes
		return attributes;
	}
	
	/**
	 * Returns the needed file data as a data unit list
	 * @return list of data units
	 */
	public abstract ArrayList<DataUnit> getData();
	 
}
