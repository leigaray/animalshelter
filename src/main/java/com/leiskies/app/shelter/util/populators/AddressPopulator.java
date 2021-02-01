package com.leiskies.app.shelter.util.populators;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import com.leiskies.app.shelter.enums.US_State;
import com.leiskies.app.shelter.model.Address;

public class AddressPopulator {
	static StringBuilder sb = null;
	static Random random = null; 
	private AddressPopulator() {}
	
	private static String bldg() {
		sb = new StringBuilder();
		random = new Random();
		return sb.append(String.valueOf(random.nextInt(125-1)+1) + "-" + String.valueOf(random.nextInt(99-10)+10)).toString();
	}
	
	private static String street() {
		sb = new StringBuilder();
		random = new Random();
		String[] types = new String[] 
			{"Alley", "Avenue", "Boulevard", "Causeway", "Circle", "Court", "Drive", "Expressway", "Freeway", "Highway", "Plaza", "Road", "Route", "Street", "Terrace" };
		String[] suffixes = new String[]
			{"land","","ville","","son","","zan","","town","","bourg",""};
		String[] names = new String[]
			{"George", "Franklin", "Hill", "Penny", "Baldos", "Cien-Fuegos", "Wolf", "Dawning", "Mercer", "Saint-Peter", "Indigo", 
					"Cavutto", "Boldrick", "Santa Ana", String.valueOf((char)(random.nextInt(90 - 65) + 65)),
					"Lucius", "Gremlink", "Woodside", "Elmhurst", "Codomoro", "Thousand-Island", "Grieger", "Donaherst", "Judemi", "Sunny", "Oglior", "Nevada", "Nebrask", "Matata",
						"Pandoras", "Shoemaker", "Los Astros", "Cardigan", "Dos-Mesas", "Triside", "Forgollia", "Sentinels", "Private Drumpf", "Ash", "Casa-Nueva", "Nebrask", "Matata"
			};
		
		int typeIndex = random.nextInt(types.length-1);
		sb.append(" " + types[typeIndex]);
		if(types[typeIndex].equalsIgnoreCase("Street") || types[typeIndex].equalsIgnoreCase("Avenue")) {
			int how = random.nextInt(3 - 1) + 1;
			switch(how) {
			case 1:
				int nameIndex = random.nextInt(names.length);
				int suffixIndex = random.nextInt(suffixes.length);
				sb.insert(0,names[nameIndex] + suffixes[suffixIndex]);
			break;
			case 2:
				if(types[typeIndex].equalsIgnoreCase("Avenue")) {
					int beg = random.nextInt(50);
					int end = random.nextInt(8)+1;
					if(end!=0) {
						switch(end) {
						case 1:
							sb.insert(0, "First");
							break;
						case 2:
							sb.insert(0, "Second");
							break;
						case 3:
							sb.insert(0, "Third");
							break;
						case 4:
							sb.insert(0, "Fourth");
							break;
						case 5:
							sb.insert(0, "Fifth");
							break;
						case 6:
							sb.insert(0, "Sixth");
						case 7:
							sb.insert(0, "Seventh");
							break;
						case 8:
							sb.insert(0, "Ninth");
							break;
						case 9:
							sb.insert(0, "Tenth");
							break;
						case 10:
							sb.insert(0, "Eleventh");
							break;
						case 11:
							sb.insert(0, "Twelfth");
							break;
						default:
							sb.insert(0, end + "th");
							break;
						}
					}	else {
						switch(beg) {
						case 1:
							sb.append(beg + "" + end + "st");
							break;
						case 2:
							sb.append(beg + "" + end + "nd");
							break;
						case 3:
							sb.append(beg + "" + end + "rd");
							break;
						case 4:
							sb.append(beg + "" + end + "th");
							break;
						}
					}
				}	else {
					int beg = random.nextInt(24);
					int end = random.nextInt(8)+1;
					switch(beg) {
					case 1:
						sb.insert(0, beg + "" + end + "st");
						break;
					case 2:
						sb.insert(0, beg + "" + end + "nd");
						break;
					case 3:
						sb.insert(0, beg + "" + end + "rd");
						break;
					default:
						sb.insert(0, beg + "" + end + "th");
						break;
					}
				}
				break;
			}	
		}	else {;
			int nameIndex = random.nextInt(names.length);
			int suffixIndex = random.nextInt(suffixes.length);
			sb.insert(0,names[nameIndex] + suffixes[suffixIndex]);
		}
		
		return sb.toString();
	}
	
	private static String city() {
		sb = new StringBuilder();
		random = new Random();
		String[] types = new String[] 
				{"City", "Heights", "", "", "Burgo", "", "Bay", "", "Burg", "", "Town", "", "Park", "", "Terrace","", "Crest", "", 
						"Beach","","Point", "", "Manor", "", "Hills", "", "Woods", "", "Gardens", "West", "", "East", "", "South", "", "North",
							"Kills", "", "Meadows", "", "Pass", "", "Canyon", "", "Rock", "", "Circle", "", "District", "", "Vista", "", "Village", "", "Center",
								"Square", "", "Air", "", "Grove", "", "Knowlls", ""};
		String[] suffixes = new String[]
				{"land","","ville","","son","","zan","","mark","bourg","", "dela","","dor","","wood","", "view","","side","","way", "","chester","", "town"};
		String[] names = new String[]
				{"George", "Franklin", "Hill", "Penny", "Baldos", "New", "Wolf", "Dawning", "Mercer", "Old", "Indigo", 
					"Corona", "Boldrick", "Santa Ana","Gleason", "Gremlink", "Wood", "Elm", "Korean", "East", "West", "North", "South",
						"Codomoro", "Island", "Grieger", "Donaherst", "Judemi", "Sunny", "Oglior", "Nevada", "Nebrask", "Matata",
							"Novacosta", "Mill", "Serenity", "Cardigan", "Flores", "Tri", "Forgollia", "Rustic", "Rose", "Ash", "Casa-Nueva", "Nebraska"
				};
		
		int typeIndex = random.nextInt(types.length-1);
		sb.append(types[typeIndex]);
		
		int nameIndex = random.nextInt(names.length);
		
		if(types[typeIndex].equalsIgnoreCase("")){
			while((names[nameIndex].equalsIgnoreCase("New") || names[nameIndex].equalsIgnoreCase("Old") ||
					names[nameIndex].equalsIgnoreCase("North") || names[nameIndex].equalsIgnoreCase("South") ||
						names[nameIndex].equalsIgnoreCase("West") || names[nameIndex].equalsIgnoreCase("East")) &&
							(types[typeIndex].equalsIgnoreCase("") || names[nameIndex].equalsIgnoreCase(types[typeIndex]))) {
				typeIndex = random.nextInt(types.length-1);
			} 
			sb.delete(0, sb.length());
			sb.append(names[nameIndex] + " " + types[typeIndex]);
		} 	else {
			int suffixIndex = random.nextInt(suffixes.length);
			sb.insert(0,names[nameIndex] + suffixes[suffixIndex] +" ");
		}	return sb.toString().trim();
	}
	
	public static String unit() {
		sb = new StringBuilder();
		int beg;
		int end;
		switch(random.nextInt(6)) {
		 
			case 0:
				beg = random.nextInt(11)+1;
				end = random.nextInt(19)+1;
				sb.append("APT#" + beg + "" + end);
				break;
			case 1:
				beg = random.nextInt(4)+1;
				end = random.nextInt(8)+1;
				switch(end) {
				
				case 1:
					if(beg==1) {
						sb.insert(0, beg + "" + end + "th Floor");
					}	else {
						sb.insert(0, beg + "" + end + "st Floor");
					}
					
					break;
				case 2:
					sb.insert(0, beg + "" + end + "nd Floor");
					break;
				case 3:
					sb.insert(0, beg + "" + end + "rd Floor");
					break;
				default:
					sb.insert(0, beg + "" + end + "th Floor");
					break;
				}
				break;
			case 2:
				beg = random.nextInt(3)+1;
				end = random.nextInt(9)+1;
				sb.append("Suite No." + beg + "" + end);
				break;
			case 3:
				beg = random.nextInt(18)+1;
				end = random.nextInt(18)+1;
				sb.append("Unit#" + beg + "" + end);
				break;
			default:
				break;
		}	return sb.toString().trim();
	}
	
	private static String bldgAndStreet() {
		return bldg() + " " + street(); 
	}
	
	private static String zipcode() {
		sb = new StringBuilder();
		random = new Random();
		IntStream.range(0, 5).forEach(i -> sb.append(random.nextInt(8)+1));
		return sb.toString();
	}
	
	private static US_State state() {
		random = new Random();
		return US_State.values()[random.nextInt(US_State.values().length-1)];
	}
	
	public static List<Address> createAddressList(int quantity) {
		List<Address> addressList = new ArrayList<Address>();
		if(quantity > 0) {
			IntStream.range(0, quantity)
			.forEach(i -> addressList.add(new Address(bldgAndStreet(), unit(), city(), state(),zipcode())));
		}	return	addressList;
	}
}
