package com.DW.group.DWProject;

import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;

import com.github.javafaker.Address;
import com.github.javafaker.DateAndTime;
import com.github.javafaker.Faker;
import com.github.javafaker.IdNumber;
import com.github.javafaker.Name;

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
        int primaryKeyJoueur = 1 ;
        int primaryKeyEntaineur = 1 ;
        int primaryKeyCity = 1 ;
        int primarykeyStadium = 1 ;
        int primaryKeyTeam = 1 ;
		int IdCoach = 0 ;
		int IdCaptain = 0 ;
		int idSignature = 1 ;
		int dateDebut = 1943 ;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat dateformatyear = new SimpleDateFormat("yyyy");
		
		
        try (
        		FileWriter csvJoueur = new FileWriter("generateData/joueur.csv") ; 
        		FileWriter csvEntraineur = new FileWriter("generateData/Entraineur.csv") ;
//        		FileWriter csvEntraineurPost = new FileWriter("generateData/EntraineurPost.csv"); // I'll get it from chatgbt like json format
//        		FileWriter csvPosition = new FileWriter("generateData/Position.csv"); // I'll get it from chatgbt like sql format
        		FileWriter csvTeam = new FileWriter("generateData/Team.csv");
        		FileWriter csvCity = new FileWriter("generateData/City.csv");
        		FileWriter csvStadium = new FileWriter("generateData/Stadium.csv");
        		FileWriter csvCountry = new FileWriter("generateData/Country.csv") ;
        		FileWriter csvSeason = new FileWriter("generateData/Season.csv");
//        		FileWriter csvMatch = new FileWriter("generateData/Match.csv");
//        		FileWriter csvGoal = new FileWriter("generateData/Goal.csv");
        		FileWriter csvCompetition = new FileWriter("generateData/Competition.csv");
//        		FileWriter csvParticiper = new FileWriter("generateData/Participer.csv");
        		FileWriter csvSignature = new FileWriter("generateData/Signature.csv")
        				){
        	
         	csvCountry.append("idCountry , CountryName\n");
        	csvCity.append("idCity , CityName , idCountry\n");
        	csvStadium.append("idStadium , libelle , totalPlaces ,  address , idCity\n") ;
//        	
         	csvSeason.append("idSeason , datedebut , datefin\n");
//        	csvMatch.append("idMatch , date_Time , idHomeTeam , idAwayTeam , idStadium , idCompetition , idSeason\n");
//        	csvGoal.append("idGoal , timeGoal , ownGoal , idMatch , idButteur , idPasseur , idTypeGoal\n") ;
//        	
			csvJoueur.append("idJoueur , FirstName , LastName , dob ,idCountry, idPosition\n");
			csvEntraineur.append("idEntraineur , FirstName , LastName , dob ,idCountry , idEntraineurPost\n");
//			
			csvTeam.append("idTeam , TeamName , createAt , idCaptain , idEntraineur\n");
			csvCompetition.append("idComprtition , Libelle , idCountry , Prize , idSeason , idTeamWin\n");
//			csvParticiper.append("idParticiper , idTeam , idCompetition\n");
//			
			csvSignature.append("idSign ,dateSignature , dateExpiration , Montant , idTeam , idPerson\n");

			for (int j = 1; j <= 80; j++) {
				Address address = faker.address();
				csvCountry.append(String.format("%d,%s\n", j , address.country()));
 				csvSeason.append(String.format("%d,%s,%s\n", j , dateDebut++ , dateDebut++));
 				csvCompetition.append(String.format("%d,"));
 				for (int i = 1; i <= 10 ; i++) {
 					
					csvCity.append(String.format("%d,%s,%d\n", primaryKeyCity++ , address.city() , j ));
					
	 				csvStadium.append(String.format("%d,%s,%s,%s,%d\n" , primarykeyStadium++ , address.city() + " Stade" ,
	 						faker.number().numberBetween(0, 100000) , address.lastName()+ address.city() + address.country() ,
	 						primaryKeyCity-1));
	 				
	 				int numberOfPlayers = 0 ;
	 				while ( numberOfPlayers++ <= 15) {
	 					Name name = faker.name();
						csvJoueur.append(String.format("%d,%s,%s,%s,%d,%d\n" , primaryKeyJoueur++ , name.firstName() , name.lastName() ,
								dateFormat.format(faker.date().birthday(15, 41 )) , j , faker.number().numberBetween(1, 7)));
						DateAndTime dateSignExp = faker.date();
	 					csvSignature.append(String.format("%d,%s,%s,%d,%d,%d\n", idSignature++ , dateSignExp.birthday(0,4) ,
	 							dateSignExp.future(700, java.util.concurrent.TimeUnit.DAYS) , faker.number().numberBetween(2000 , 7000000) , primaryKeyTeam , primaryKeyJoueur));
					}
	 				IdCaptain+=15;
	 				
					csvEntraineur.append(String.format("%d,%s,%s,%s,%d,%d\n", primaryKeyEntaineur++ , faker.name().firstName() , faker.name().lastName() ,
							dateFormat.format(faker.date().birthday(39, 70 )) , j , 1));
					DateAndTime dateSignExp = faker.date();
					csvSignature.append(String.format("%d,%s,%s,%d,%d,%d\n", idSignature++ , dateSignExp.birthday(0,4) ,
 							dateSignExp.future(700, java.util.concurrent.TimeUnit.DAYS) , faker.number().numberBetween(2000 , 7000000) , primaryKeyTeam , primaryKeyEntaineur));
			
					
	 				int numberOfCoachInTeam = 0 ;
	 				while (numberOfCoachInTeam++ <= 4) {
						csvEntraineur.append(String.format("%d,%s,%s,%s,%d,%d\n", primaryKeyEntaineur++ , faker.name().firstName() , faker.name().lastName() ,
								dateFormat.format(faker.date().birthday(39, 70 )) ,faker.number().numberBetween(1, 80)  , faker.number().numberBetween(1, 7)));
						
						DateAndTime dateSignExp2 = faker.date();
						csvSignature.append(String.format("%d,%s,%s,%d,%d,%d\n", idSignature++ , dateSignExp2.birthday(0,4) ,
	 							dateSignExp2.future(700, java.util.concurrent.TimeUnit.DAYS) , faker.number().numberBetween(2000 , 7000000) , primaryKeyTeam , primaryKeyEntaineur));
				
					}
	 				IdCoach+=4;
	 				
	 				Date dateCreateAt = faker.date().birthday(23, 200) ;
	 				
	 				csvTeam.append(String.format("%d,%s,%s,%d,%d\n",primaryKeyTeam++,faker.team().name() + " football Club " + dateformatyear.format(dateCreateAt) 
	 				, dateFormat.format(dateCreateAt) , IdCaptain , IdCoach  ));
	 				
				}
				
			}

			
            System.out.println("Fake data generation complete. Check fake_data.csv");

		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
