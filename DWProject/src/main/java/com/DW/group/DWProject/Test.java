package com.DW.group.DWProject;
//
//import java.text.SimpleDateFormat;
//import java.util.Locale;
//
//import com.github.javafaker.Faker;
//
//public class Test {
//
//	public static void main(String[] args) {
//		
////		Faker faker = new Faker(new Locale("en"));
////		System.out.println(java.util.concurrent.TimeUnit.DAYS);
//// 		System.out.println(faker.date().birthday().toString());
//// 		System.out.println(faker.date().birthday(0, 4));
////  		System.out.println(faker.date().past(180 , java.util.concurrent.TimeUnit.DAYS));
//// 		System.out.println(faker.number().numberBetween(2000 , 7000000));
//// 		System.out.println(faker.address().fullAddress());
//// 		System.out.println(  new SimpleDateFormat("MM").format(faker.date().birthday()).getClass().getName() );
//// 		int j = 0 ;
//// 		while (j <= 16) {
////			System.out.println(j +" mmm");
////			j++;
////			
////		}
//// 		System.out.println(faker.random().nextInt(2000));
//		
//	}
//
//}
import java.io.FileWriter;
import java.io.IOException;


public class Test {
    public static void main(String[] args) {
        // Number of teams
        int numberOfTeams = 20;

        // Number of matches each team plays against others (home and away)
        int matchesPerTeam = 2 * (numberOfTeams - 1);

        // Number of matchdays
        int numberOfMatchdays = 38;

        try (FileWriter csvMatches = new FileWriter("newGenerateData/GeneratedMatches.csv")) {
            // Writing header to CSV file
        	csvMatches.append("MatchID,HomeTeam,AwayTeam,Matchday\n");

            // Generate matches
            int matchID = 1;
            for (int matchday = 1; matchday <= numberOfMatchdays; matchday++) {
                for (int homeTeam = 1; homeTeam <= numberOfTeams; homeTeam++) {
                    for (int awayTeam = 1; awayTeam <= numberOfTeams; awayTeam++) {
                        if (homeTeam != awayTeam) {
                            // Writing data to CSV
                            csvMatches.append(matchID + "," + homeTeam + "," + awayTeam + "," + matchday + "\n");
                            matchID++;

                            // Break if each team has played the required number of matches per matchday
                            if (matchID > matchday * matchesPerTeam) {
                                break;
                            }
                        }
                    }

                    // Break if each team has played the required number of matches overall
                    if (matchID > numberOfMatchdays * matchesPerTeam) {
                        break;
                    }
                }
            }

            System.out.println("CSV file with generated matches has been created successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

