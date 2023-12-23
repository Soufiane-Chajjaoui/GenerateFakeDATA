package com.DW.group.DWProject;

import com.github.javafaker.Faker;

public class Main {

	public static void main(String[] args) {
		Faker faker = new Faker();
		for (int i = 0; i < 30; i++) {
			System.out.println(faker.esports().league());
		}
	}

}
