package com.leiskies.app.shelter.util.populators;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Random;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.leiskies.app.shelter.dao.ModelDAO;
import com.leiskies.app.shelter.model.Animal;
import com.leiskies.app.shelter.util.managers.ConnectionManager;

public class AnimalImagePathPopulator {
	
	
	
	public static String myGetRequest(String type) throws IOException{
		String outString = null;
		URL url = null; 
		String urlString = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		StringBuffer response = null;
		switch(type) {
		case "Dog":
			urlString = "https://dog.ceo/api/breeds/image/random";
			url = new URL(urlString);
			String readLine = null; 
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			
			int responseCode = connection.getResponseCode();
			
			if(responseCode == HttpURLConnection.HTTP_OK) {
				isr = new InputStreamReader(connection.getInputStream());
				br = new BufferedReader(isr);
				response = new StringBuffer();
				
				while((readLine = br.readLine()) != null) {
					if(readLine.substring(0,1).equalsIgnoreCase("[")) {
						readLine = readLine.substring(1,readLine.length()-1);
					}
					JSONParser parser = new JSONParser();
					JSONObject json = null;
					try {
						json = (JSONObject) parser.parse(readLine);
					} catch (ParseException e) {
						e.printStackTrace();
					}
					outString = json.get("message").toString();
				}
			}
			
			break;
		case "Cat":
			urlString = "https://api.thecatapi.com/v1/images/search";
			url = new URL(urlString);
			readLine = null; 
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			
			responseCode = connection.getResponseCode();
			
			if(responseCode == HttpURLConnection.HTTP_OK) {
				isr = new InputStreamReader(connection.getInputStream());
				br = new BufferedReader(isr);
				response = new StringBuffer();
				
				while((readLine = br.readLine()) != null) {
					if(readLine.substring(0,1).equalsIgnoreCase("[")) {
						readLine = readLine.substring(1,readLine.length()-1);
					}
					JSONParser parser = new JSONParser();
					JSONObject json = null;
					try {
						json = (JSONObject) parser.parse(readLine);
					} catch (ParseException e) {
						e.printStackTrace();
					}
					outString = json.get("url").toString();
				}
			}
			
			break;
		case "Hamster": 
			Random random = new Random();
			
			int urlIndex = random.nextInt(59) + 1;
			File file = new File("src/main/resources/hamster_list.txt");
			
			br = new BufferedReader(new FileReader(file));
			for (int i = 0; i < urlIndex; i++) {
				if(i==urlIndex-1) {
					outString = br.readLine().split("=")[1];
				}	else {
					br.readLine();
				}
			}
			break;
		case "Parrot":
			random = new Random();
			
			urlIndex = random.nextInt(59) + 1;
		
			file = new File("src/main/resources/parrot_list.txt");
			
			br = new BufferedReader(new FileReader(file));
			for (int i = 0; i < urlIndex; i++) {
				if(i==urlIndex-1) {
					outString = br.readLine().split("=")[1];
				}	else {
					br.readLine();
				}
			}
			break;
		
		}	
		return outString;
	}
	
	public static void main(String[] args) {
	
	}
		
}
