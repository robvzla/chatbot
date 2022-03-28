package com.chatbot2.chatBot2;

import java.io.File;
import java.util.HashMap;

import org.alicebot.ab.utils.IOUtils;

public class ChatBot 
{
	// Attributes
	private static final String greeting = "Hi, I heard you're going on holiday? Do you want some help planning your wardrobe?";
	String userInput;
	// HashMap holds the location and date (given by user) as a key > value pair so the Weather Class can request
	// weather information to the API on the specified location and date.
	// May consider changing the HashMap to a <String, ArrayList<String>> HashMap to make interaction easier with
	// the weather API
	private HashMap<String, String> holidays;

	// Add getters for testing purposes
	public String getGreeting() {
		return this.greeting;
	}

	public HashMap<String, String> getHolidays(){
		return this.holidays;
	}



	// Methods
	// Greeting method - to give the user the option to use the chat bot or not
	public boolean greeting(){
		System.out.println(greeting);
		userInput = IOUtils.readInputTextLine().trim();
		if (userInput.equalsIgnoreCase("yes") || userInput.equalsIgnoreCase("y")) {
			System.out.println("That's great! Where would you like to go first?");
			return true;
		} else if (userInput.equalsIgnoreCase("no") || userInput.equalsIgnoreCase("n")){
			System.out.println("Hopefully I can help another time. Chat later!");
			return false;
		} else {
			System.out.println("Are you sure you don't want help? If you do, please answer yes or y.");
			userInput = IOUtils.readInputTextLine().trim();
			if (userInput.equalsIgnoreCase("yes") || userInput.equalsIgnoreCase("y")) {
				System.out.println("That's great! Where would you like to go first?");
				return true;
			}
			System.out.println("Hopefully I can help another time. Chat later!");
			return false;
		}
	}

	public String AskBot() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String getResourcesPath() 
	{
		File currentDirectory = new File(".");
		//	Gets the full path of the current directory
		String path = currentDirectory.getAbsolutePath();
		path = path.substring(0, path.length() - 2);
		System.out.println(path);
		//	Location to where the Bot's resources are saved in the Java Project
		String resourcesPath = path + File.separator + "src" + File.separator + "main" + File.separator + "resources";
		return resourcesPath;

	}

	public static void main(String[] args) {
		// This is just for testing so the class can run. 
		System.out.println("Hello");
	}
}
