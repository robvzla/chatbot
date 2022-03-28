package com.chatbot2.chatBot2;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.junit.Test;


public class ChatBotTest 
{
	// Test greeting method

	// Test the greeting string. 
	@Test
	public void greetingTest1() {
		String s1 = "Hi, I heard you're going on holiday? Do you want some help planning your wardrobe?";
		ChatBot bot = new ChatBot();
		assertEquals(s1, bot.getGreeting());
	}

	// Test to check that yes is accepted, boolean should return true
	// The greeting method gives the user an option to proceed with the bot
	@Test
	public void greetingMethodTestForYesOrY() {
		ChatBot bot = new ChatBot();
		boolean b = bot.greeting(); // type yes or y for the boolean to be true
		assertTrue(b);
	}

	// Test to check that no is accepted, boolean should return false
	@Test
	public void greetingMethodTestForNoOrN() {
		ChatBot bot = new ChatBot();
		boolean b = bot.greeting(); // type anything but yes or y for a false or for immediate false type no or n
		assertFalse(b);
	}

	// Test the HashMap
	@Test
	public void hashMapTest() {
		ChatBot bot = new ChatBot();
		assertTrue(bot.getHolidays() instanceof HashMap);
	}

	/*	
	 * 	Test Case: Checks if bot gives an answer after typing something
	 */
	@Test
	public void testAskBot() throws IOException 
	{
		ChatBot bot = new ChatBot();
		String botResponse = bot.AskBot();
		Boolean actual = botResponse.isEmpty();
		Boolean expected = false;
		assertEquals(expected, actual);
	}
	
	/*	
	 * 	Test Case: Checks if path to the bot's resource folder exists
	 */
	@Test
	public void testGetResourcePath() throws IOException 
	{
		ChatBot bot = new ChatBot();
		File file = new File(bot.getResourcesPath());
		assertTrue(file.exists());
	}
	
	/* Test Case: Checks whether user inputs a valid city or not
	 * It uses a list of city (text) we created to check if the location is valid or not
	 * if it fails it either means the location is not valid (e.g. Dublinnn23) or the city 
	 * does not exist in the text file
	 */
	@Test
	public void testCityValidation1() throws IOException 
	{
		ChatBot bot = new ChatBot();
		String userInput = "Paris";
		Boolean actual = bot.cityValidation(userInput);
		Boolean expected = true;
		assertEquals(expected, actual);
	}
	
	/*	If a input city contains a number, then is not valid 
	 * 	and it will return false
	 */
	@Test
	public void testCityValidation2() throws IOException 
	{
		ChatBot bot = new ChatBot();
		String userInput = "London123";
		Boolean actual = bot.cityValidation(userInput);
		Boolean expected = false;
		assertEquals(expected, actual);
	}

}
