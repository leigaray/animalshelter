package com.leiskies.app.shelter.util.populators;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.leiskies.app.shelter.enums.AnimalStatus;
import com.leiskies.app.shelter.enums.AnimalType;
import com.leiskies.app.shelter.enums.Color;
import com.leiskies.app.shelter.enums.Shelter;
import com.leiskies.app.shelter.model.Animal;



public class AnimalPopulator {
	static StringBuilder sb = null;
	public static Random random = null;
	private AnimalPopulator() {}
	
	public static Date admitted(int monthsBack) {
		random = new Random();
		LocalDateTime today = LocalDateTime.now();
		today = today.minus(random.nextInt(monthsBack), ChronoUnit.MONTHS);
		today = today.minus(random.nextInt(28), ChronoUnit.DAYS);
		
		return Date.valueOf(today.toLocalDate());
	}
	
	public static String name() {
		sb = new StringBuilder();
		random = new Random();
		File file = new File("src\\main\\resources\\animal_name_list.txt");
		int nameIndex = random.nextInt(1200 - 1 + 1) + 1;
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    for (int i = 0; i < nameIndex; i++) {
		    	
		    	if(i == nameIndex - 1) {
		    		sb.append(br.readLine().trim());
		    	}	else {
		    		br.readLine();
		    	} 
		    }
		} 	catch (FileNotFoundException e) {
			e.printStackTrace();
		} 	catch (IOException e) {
			e.printStackTrace();
		}	return sb.substring(0,1).toUpperCase() + sb.toString().substring(1).toLowerCase();
	}
	

	
	public static List<Animal> createAnimalList(int quantity){
		List<Animal> animalList = new ArrayList<Animal>();
		random = new Random();
		
		//Animal animal = 
				//new Animal
				//(status, age, name, type, color, weight, admitted, adopted, location, user)
		if(quantity > 0) {
			
			for (int i = 0; i < AnimalType.values().length; i++) {
				for (int j = 0; j <quantity; j++) {
					
					for (int k = 0; k < Shelter.values().length; k++) {
						
						Color color = null;
						Double weight = 0.0D;
						if(AnimalType.values()[i].getName().equalsIgnoreCase("Parrot")) {
							weight = 0.5 + (8.0 - 0.5) * random.nextDouble();
							weight = Math.round(weight * 100.0) / 100.0;
							int colorIndex = random.nextInt(Color.values().length-1);
							color = Color.values()[colorIndex];	
						} else if(AnimalType.values()[i].getName().equalsIgnoreCase("Hamster")){
							weight = 0.05 + (0.5 - 0.05) * random.nextDouble();
							weight = Math.round(weight * 100.0) / 100.0;
							int colorIndex = random.nextInt(Color.values().length-1);
							color = Color.values()[colorIndex];	
							while(color.equals(Color.GREEN)) {
								colorIndex = random.nextInt(Color.values().length-1);
								color = Color.values()[colorIndex];	
							}
						}	else if(AnimalType.values()[i].getName().equalsIgnoreCase("Cat")){
							weight = 5.0 + (10.0 - 5.0) * random.nextDouble();
							weight = Math.round(weight * 100.0) / 100.0;
							int colorIndex = random.nextInt(Color.values().length-1);
							color = Color.values()[colorIndex];	
							while(color.equals(Color.GREEN)) {
								colorIndex = random.nextInt(Color.values().length-1);
								color = Color.values()[colorIndex];	
							}
						}	else if(AnimalType.values()[i].getName().equalsIgnoreCase("Dog")){
							weight = 5.0 + (30.0 - 5.0) * random.nextDouble();
							weight = Math.round(weight * 100.0) / 100.0;
							int colorIndex = random.nextInt(Color.values().length-1);
							color = Color.values()[colorIndex];	
							while(color.equals(Color.GREEN)) {
								colorIndex = random.nextInt(Color.values().length-1);
								color = Color.values()[colorIndex];	
							}
						}
						animalList.add(
							
							new Animal(AnimalStatus.AVAILABLE, random.nextInt(10)+2, name(), AnimalType.values()[i],
									color, weight, admitted(12), null, Shelter.values()[k].getCode(), null));
					}
					
				
				}
			}
		}
		
		return animalList;
	}
	
}
