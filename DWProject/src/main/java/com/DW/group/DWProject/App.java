package com.DW.group.DWProject;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

import com.github.javafaker.Faker;
import com.github.javafaker.IdNumber;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Faker faker = new Faker(new Locale("en"));
        ArrayList<String> countries = new ArrayList<String>();
        int numberOfRecords = 700 ;
        try (
//        		FileWriter csvJoueur = new FileWriter("generateData/joueur.csv") ; 
//        		FileWriter csvEntraineur = new FileWriter("generateData/Entraineur.csv") ;
//        		FileWriter csvCountry = new FileWriter("generateData/Country.csv") ;
//        		FileWriter csvEntraineurPost = new FileWriter("generateData/EntraineurPost.csv"); // I'll get it from chatgbt like json format
//        		FileWriter csvPosition = new FileWriter("generateData/Position.csv"); // I'll get it from chatgbt like sql format
//        		FileWriter csvTeam = new FileWriter("generateData/Team.csv");
//        		FileWriter csvCity = new FileWriter("generateData/City.csv");
        		FileWriter csvStudiam = new FileWriter("generateData/Studiam.csv");
//        		FileWriter csvSeason = new FileWriter("generateData/Season.csv");
//        		FileWriter csvMatch = new FileWriter("generateData/Match.csv");
//        		FileWriter csvGoal = new FileWriter("generateData/Goal.csv");
//        		FileWriter csvCompetition = new FileWriter("generateData/Competition.csv");
//        		FileWriter csvParticiper = new FileWriter("generateData/Participer.csv");
//        		FileWriter csvSignature = new FileWriter("generateData/Signature.csv")
        				){
        	
//         	csvCountry.append("idCountry , CountryName\n");
//        	csvCity.append("idCountry , CityName , idCountry\n");
        	csvStudiam.append("idStudiam , capacity , libelle , adresse , idCity\n) ;
//        	
//         	csvSeason.append("idSeason , datedebut , datefin");
//        	csvMatch.append("idMatch , date_Time , idHomeTeam , idAwayTeam , idStudiam , idSeason");
//        	csvGoal.append("idGoal , timeGoal , ownGoal , idMatch , idButteur , idPasseur , idTypeGoal") ;
//        	
//			csvJoueur.append("idJoueur , FirstName , LastName , dob ,idCountry, idPosition\n");
//			csvEntraineur.append("idEntraineur , FirstName , LastName , dob ,idCountry , idEntraineurPost\n");
//			
//			csvTeam.append("idTeam , TeamName , LastName , idCaptain , idEntraineur\n");
//			csvCompetition.append("idComprtition , Libelle , idCountry , Prize , idSeason , idTeamWin");
//			csvParticiper.append("idParticiper , idTeam , idCompetition");
//			
//			csvSignature.append("idSign ,dateSignature , dateExpiration , Montant , idTeam , idPerson");

			for (int i = 1; i <= numberOfRecords ; i++) {
				
 				csvStudiam.append(String.format("%d,%s,%d\n" , i++ , faker.number().numberBetween(0, 100000) , faker.number().numberBetween(1, 80)));
			}
			
            System.out.println("Fake data generation complete. Check fake_data.csv");

		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
