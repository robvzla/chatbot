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
	
	/*	If a input city does not exits, it returns false 
	 */
	@Test
	public void testCityValidation3() throws IOException 
	{
		ChatBot bot = new ChatBot();
		String userInput = "Gotham";
		Boolean actual = bot.cityValidation(userInput);
		Boolean expected = false;
		assertEquals(expected, actual);
	}
	
	/*	The hashmap starts collecting information only in a given pattern
	 * 	In this case, holiday topic is the context. The questions in the AIML file
	 * 	conducts the user to input location and date in an order, the string pattern
	 * 	that activates the hashmap to store information is when the user responds
	 * 	to the specific question the bot is asking her/him. 
	 */
	@Test
	public void testExtractInformation1()
	{
		ChatBot bot = new ChatBot();
		HashMap<String, String> test = new HashMap<>();
		String userInput = "Rome";
		String botResponse = "Noted, what date will you visit?";
		String userInput2 = "22/04/2022";
		String botResponse2 = "Noted, is there any other place?";
		test = bot.extractInformation(botResponse, userInput);
		test = bot.extractInformation(botResponse2, userInput2);
		int actual = test.size();
		int expected = 1;
		assertEquals(expected, actual);
	}
	
	/*
	 * 	In this case, the string pattern that exits in the AIML file does not
	 * 	match with the one that activates the method to collect information in the
	 * 	hashmap. Therefore, no value is stored and size of the hashmap remains zero
	 */
	@Test
	public void testExtractInformation2()
	{
		ChatBot bot = new ChatBot();
		HashMap<String, String> test = new HashMap<>();
		String userInput = "Rome";
		String botResponse = "Where would you like to go";
		String userInput2 = "22/04/2022";
		String botResponse2 = "Nice, when you visit?";
		test = bot.extractInformation(botResponse, userInput);
		test = bot.extractInformation(botResponse2, userInput2);
		int actual = test.size();
		int expected = 0;
		assertEquals(expected, actual);
	}

}
