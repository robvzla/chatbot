package com.chatbot2.chatBot2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class AIMLCreator {

	/*
	 This class is going to use .txt files to generate AIML files 
	 The .txt files will be stored in the config directory in the resources directory
	 This class will be primarily used to generate an AIML file of locations for the chatbot
	 */



	// Attributes

	// This is where the file given to the constructor is found - the path will not change
	private final String getFromFilePath = ChatBot.getResourcesPath() + File.separator + "bots" 
			+ File.separator + "super" + File.separator + "config" 
			+ File.separator;

	// This is where the new aiml file will be written to - the path will not change
	private final String printFileToPath = ChatBot.getResourcesPath() + File.separator + "bots" 
			+ File.separator + "super" + File.separator + "aiml" 
			+ File.separator;

	private String fileLocation; 
	private String fileName; 

	// An arrayList to hold all the information that will be read from the file given in the constructor
	private ArrayList<String> list = new ArrayList<String>();

	// A Scanner object to read the file
	Scanner fileIn; 




	// Constructor
	public AIMLCreator(String fileName) {
		this.fileName = fileName;  
		//System.out.println(fileName + ".txt");
		this.fileLocation = getFromFilePath + fileName;
	}



	// Required setters and getters - will not do one of each for all attribute, only those required for the testing and the code
	// Getters
	public String getFileName() {
		return this.fileName; 
	}

	public String getPrintFileToPath() {
		return this.printFileToPath; 
	}

	// Setters
	// This setter will remove the .txt from the file given in the constructor
	public void setFileName() {
		this.fileName = fileName.substring(0, fileName.length() - 4); 
		System.out.println(fileName);
	}


	// Methods
	// The file given in the constructor is read and all the information will be stored into the arrayList 
	public void readFile(){
		try { // Put this in a try catch in case of a file not found exception
			// Get the file
			fileIn = new Scanner(new FileReader(fileLocation)); 
			// Start reading the file
			while(fileIn.hasNextLine()) {
				// Current String
				String current = fileIn.nextLine(); 
				// Use if else statement to decide what to do with the data
				//		System.out.println(current);
				list.add(current); 
			}
			// Close the Scanner object
			fileIn.close(); 
		} catch (FileNotFoundException e) {
			System.out.println("Error: " + e.getMessage());
		}		
	}

}
