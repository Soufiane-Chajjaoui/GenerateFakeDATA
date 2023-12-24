package com.DW.group.DWProject;

import java.util.Locale;

import com.github.javafaker.Faker;

public class Test {

	public static void main(String[] args) {
		
		Faker faker = new Faker(new Locale("en"));
		System.out.println(faker.zelda().game());
 		System.out.println(faker.date().birthday().toString());
 		int j = 0 ;
 		while (j <= 16) {
			System.out.println(j +" mmm");
			j++;
			
		}
	}

}
