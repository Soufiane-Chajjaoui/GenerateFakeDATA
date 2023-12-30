package com.DW.group.DWProject;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Random;

import com.github.javafaker.Address;
import com.github.javafaker.Faker;

public class NewData {
	public static void main(String[] args) {
		Faker faker = new Faker(new Locale("en"));

		try (FileWriter csvTeam = new FileWriter("newGenerateData/Team.csv");
				FileWriter csvStadium = new FileWriter("newGenerateData/Stadium.csv");
				FileWriter csvDateMatch = new FileWriter("newGenerateData/DateMatch.csv");
				FileWriter csvMatch = new FileWriter("newGenerateData/Match.csv");
				FileWriter csvReferee = new FileWriter("newGenerateData/Referee.csv")) {

			// Writing header to CSV file
			csvTeam.append("TeamID,TeamName,Coach\n");
			csvStadium.append("StadiumID,StadiumName,Location,Capacity\n");
			csvReferee.append("RefereeID,RefereeName,Nationality,age\n");
			csvDateMatch.append("DateID , date\n");
			csvMatch.append(
					"idMatch , HomeTeam , AwayTeam , StadiumID ,Attendance , RefereeID , DateID , GoalsHome , GoalsAway\n");

			Address address = faker.address();
			// Generating and writing data to CSV
			for (int i = 1; i <= 20; i++) {
				String teamName = faker.team().name();
//				String country = address.country();
				String coach = faker.name().fullName();

				csvTeam.append(i + "," + teamName  + "," + coach + "\n");

				String stadiumName = address.city() + " stade " + i;
				String location = address.city() + " " + address.country();
				int capacity = faker.number().numberBetween(10000, 80000);

				csvStadium.append(i + "," + stadiumName + "," + location + "," + capacity + "\n");
			}

			// Generating and writing data to CSV
			for (int i = 1; i <= 10; i++) {
				String refereeName = faker.name().fullName();
				String nationality = faker.address().country();
				int age = new Random().nextInt(22, 60);

				// Writing data to CSV
				csvReferee.append(i + "," + refereeName + "," + nationality + "," + age + "\n");
			}

			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			for (int i = 1; i <= 180; i++) {

				String dateMatch = format.format(faker.date().past(180, java.util.concurrent.TimeUnit.DAYS));
				csvDateMatch.append(i + "," + dateMatch + "\n");
			}

			ArrayList<Match> matches = new ArrayList<Match>();
			int idMatch = 1;
			int hometeam = 1;
			int awayteam = 20;
				
				for (int j = hometeam; j <= awayteam; j++) {
					for (int m = awayteam; m >= hometeam; m--) {
						if (j != m) {
							matches.add(new Match(j, m));
							csvMatch.append(idMatch + "," + j + "," + m + "," + j 
									+ "," + new Random().nextInt(20000 , 60000) + "," + new Random().nextInt(1 , 11)
									+ "," + new Random().nextInt(1 , 181)+ "," + new Random().nextInt(1,6) + "," 
									+ new Random().nextInt(1,6) + "\n");
							idMatch++;
						}
					}
				}
			System.out.println("CSV file has been created successfully!");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
