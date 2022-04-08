package com.chatbot2.chatBot2;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		
		// Main class for the chatbot
		
		
		// Create the new AIML file
		AIMLCreator newFile = new AIMLCreator("citylist.txt"); 
		newFile.readFile();
		newFile.writeFile();
		
		// Create the Chat Bot
		ChatBot bot = new ChatBot(); 
		
		// Run the greeting method
		bot.greeting(); 
		
		// Then run the askBot Method - this is where all the user input will be taken and stored
		bot.AskBot(); 
		
	}
}
