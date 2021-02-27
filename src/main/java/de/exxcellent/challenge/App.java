package de.exxcellent.challenge;

import de.exxcellent.challenge.analysis.*;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {

        WeatherAnalysis weatherAnalysis = new WeatherAnalysis();
        FootballAnalysis footballAnalysis = new FootballAnalysis();

        String dayWithSmallestTempSpread = weatherAnalysis.getDayWithSmallestTemperatureSpread("src/main/resources/de/exxcellent/challenge/weather.csv");
        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);

        String teamWithSmallestGoalSpread = footballAnalysis.getTeamWithSmallestGoalSpread("src/main/resources/de/exxcellent/challenge/football.csv"); 
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);
    }
}
