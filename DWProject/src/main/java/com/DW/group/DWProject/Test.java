package com.DW.group.DWProject;

import java.util.Locale;

import com.github.javafaker.Faker;

public class Test {

	public static void main(String[] args) {
		
		Faker faker = new Faker(new Locale("en"));
		System.out.println(java.util.concurrent.TimeUnit.DAYS);
 		System.out.println(faker.date().birthday().toString());
 		System.out.println(faker.date().birthday(0, 4));
  		System.out.println(faker.date().past(29200 , java.util.concurrent.TimeUnit.DAYS));
 		System.out.println(faker.number().numberBetween(2000 , 7000000));
 		System.out.println(faker.address().fullAddress());
// 		int j = 0 ;
// 		while (j <= 16) {
//			System.out.println(j +" mmm");
//			j++;
//			
//		}
	}

}
