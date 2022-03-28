package com.chatbot2.chatBot2;

import java.util.HashMap;

import org.alicebot.ab.utils.IOUtils;

public class ChatBot 
{
	// Attributes
	private static final String greeting = "Hi, I heard you're going on holiday? Do you want some help planning your wardrobe?";
	String userInput;
	
	// Add getters for testing purposes
	public String getGreeting() {
		return this.greeting;
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
	
	
	public static void main(String[] args) {
		// This is just for testing so the class can run. 
		System.out.println("Hello");
	}
	


}
