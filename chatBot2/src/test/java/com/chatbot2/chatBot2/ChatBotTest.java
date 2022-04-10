package com.chatbot2.chatBot2;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.junit.Test;

public class ChatBotTest 
{
	// Test greeting method

	// Test One: 
	// Test the greeting string. 
	@Test
	public void greetingTest1() {
		String s1 = "Hi, I heard you're going on holiday? Do you want some help planning your wardrobe?";
		ChatBot bot = new ChatBot();
		assertEquals(s1, bot.getGreeting());
	}

	// Test Two: 
	// Test to check that yes is accepted, boolean should return true
	// The greeting method gives the user an option to proceed with the bot
	@Test
	public void greetingMethodTestForYesOrY() {
		ChatBot bot = new ChatBot();
		boolean b = bot.greeting(); // type yes or y for the boolean to be true
		assertTrue(b);
	}

	// Test Three: 
	// Test to check that no is accepted, boolean should return false
	@Test
	public void greetingMethodTestForNoOrN() {
		ChatBot bot = new ChatBot();
		boolean b = bot.greeting(); // type anything but yes or y for a false or for immediate false type no or n
		assertFalse(b);
	}

	/*
	 * This has been made redundant as we are no longer using a HashMap but are using a 2d ArrayList instead
	// Test Four: 
	// Test the HashMap - RETURNING FALSE AND SHOULD NOT BE, CHANGE LATER
	@Test
	public void hashMapTest() {
		ChatBot bot = new ChatBot();
		assertTrue(bot.getHolidays() instanceof HashMap);
	}
	*/

	/*	
	 * Test Five: 
	 * Test Case: Checks if bot gives an answer after typing something
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
	 * Test Six: 
	 * 	Test Case: Checks if path to the bot's resource folder exists
	 */
	@Test
	public void testGetResourcePath() throws IOException 
	{
		ChatBot bot = new ChatBot();
		File file = new File(bot.getResourcesPath());
		assertTrue(file.exists());
	}
	
	/* Test Seven: 
	 * Test Case: Checks whether user inputs a valid city or not
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
	
	/* Test Eight: 
	 * If a input city contains a number, then is not valid 
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
	
	/* Test Nine: 
	 * If a input city does not exits, it returns false 
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
	
	
	
	
	/*	This has been made redunandant as we are now using a 2d ArrayList
	 * Test Ten: 
	 * The hashmap starts collecting information only in a given pattern
	 * 	In this case, holiday topic is the context. The questions in the AIML file
	 * 	conducts the user to input location and date in an order, the string pattern
	 * 	that activates the hashmap to store information is when the user responds
	 * 	to the specific question the bot is asking her/him. 
	 */
	/*
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
	*/
	
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
	
	/*
	 * 	Test case checks that the data (location and date) stored in the hashmap are
	 * 	stored as a key > value pair
	 */
	@Test
	public void testExtractInformation3()
	{
		ChatBot bot = new ChatBot();
		HashMap<String, String> test = new HashMap<>();
		String userInput = "Rome";
		String botResponse = "Noted, what date will you visit?";
		String userInput2 = "22/04/2022";
		String botResponse2 = "Noted, is there any other place?";
		test = bot.extractInformation(botResponse, userInput);
		test = bot.extractInformation(botResponse2, userInput2);
		String value = bot.getHolidays().get("Rome");
		String  expected = "22/04/2022";
		assertEquals(expected, value);
	}
	
	@Test
	public void testWildCharactersValidation()
	{
		ChatBot bot = new ChatBot();
		String botResponse = "slash";
		botResponse = bot.wildCharactersValidation(botResponse);
		String  expected = "/";
		assertEquals(expected, botResponse);
	}
	
	
	// Tests for Milestone 2
	/*
	 * I reduced the code in the AskBot() method so it is not trying to loop through one page of AIML.
	 * It will return the userInput if the user does not type q or wq (they exit the program). 
	 * If the user types q or wq then the program terminates with a System.exit(); 
	 * The runBot() method uses the String return value to validate it as a location and then add it to a 2d ArrayList
	 * in order to store it for use with the Weather API. 
	 */
	

	/*
	 * Test One: 
	 * Test to see if I get back the correct string that I type in 
	 */
	@Test
	public void testAskMethodGetCorrectStringReturned() {
		ChatBot bot = new ChatBot(); 
		String actual = ""; 
		try {
			actual = bot.AskBot();  // Type Hello into the console and then go back to see if it is a green/red bar result
		} catch (IOException e) {
			fail(); 
		}
		String expected = "Hello"; 
		assertEquals(actual, expected); 

	}
	
	/*
	 * checkArrayLocation()
	 * This method loops through the 2d ArrayList to check if the location
	 * has already been added to a nested ArrayList. 
	 * If it has it will return true. 
	 * If it hasn't it will return false. 
	 */
	

	/*
	 * Test Two: 
	 * Test to see if it will return false if the location has not been added.
	 */
	@Test
	public void testCheckArrayLocationReturnFalse() {
		ChatBot bot = new ChatBot(); 
		String location = "Ahascragh"; 
		assertFalse(bot.checkArrayLocation(location)); 
	}

	
	/*
	 * Test Three: 
	 * Test to see if it will return true with a location added.
	 */
	@Test
	public void testCheckArrayLocationReturnTrue() {
		ChatBot bot = new ChatBot(); 
		String location = "Caracas"; 
		bot.addLocationToList(location);
		assertTrue(bot.checkArrayLocation(location)); 
	}
	
	/*
	 * findArrayLocation()
	 * This method will return the index value of the string it is searching for. 
	 * Test to get an index value for a location that you know the value of. 
	 */

	
	/*
	 * Test Four: 
	 * Test to see if the method can find a location
	 */
	@Test
	public void testFindArrayLocation1() {
		ChatBot bot = new ChatBot(); 
		bot.addLocationToList("Caracas"); 
		bot.addLocationToList("Ahascragh"); 
		bot.addLocationToList("Dublin"); 
		assertEquals(0, bot.findArrayLocation("Caracas")); 
	}
	
	/*
	 * Test Five: 
	 * Test to see if the method can find a location
	 */
	@Test
	public void testFindArrayLocation2() {
		ChatBot bot = new ChatBot(); 
		bot.addLocationToList("Caracas"); 
		bot.addLocationToList("Ahascragh"); 
		bot.addLocationToList("Dublin"); 
		assertEquals(1, bot.findArrayLocation("Ahascragh")); 
	}

	/*
	 * Test Six: 
	 * Test to see if the method can find a location
	 */
	@Test
	public void testFindArrayLocation3() {
		ChatBot bot = new ChatBot(); 
		bot.addLocationToList("Caracas"); 
		bot.addLocationToList("Ahascragh"); 
		bot.addLocationToList("Dublin"); 
		assertEquals(2, bot.findArrayLocation("Dublin")); 
	}
	
	/*
	 * addLocationToList()
	 * This method adds a new nested ArrayList to the outer ArrayList if checkArrayLocation() returns false. 
	 * If a new nested ArrayList is added, the method returns true, else returns false; 
	 * It will also add the location passed as the first element of the new ArrayList.
	 */
	
	
	/*
	 * Test Seven: 
	 * Test by adding a new location (should return true). 
	 */
	@Test
	public void testAddLocationToListReturnTrue() {
		ChatBot bot = new ChatBot(); 
		assertTrue(bot.addLocationToList("Caracas")); 
	}
	
	/*
	 * Test Eight: 
	 * Test by adding a location twice. AssertFalse the second time the same location is added. 
	 */
	@Test 
	public void testAddLocationToListReturnFalse() {
		ChatBot bot = new ChatBot(); 
		bot.addLocationToList("Caracas"); 
		assertFalse(bot.addLocationToList("Caracas")); 
	}
	

	/*
	 * whatDate()
	 * This is a simple method that will just return the userInput given. 
	 */
	
	
	/*
	 * Test Nine: 
	 */
	@Test
	public void testWhatDate() {
		ChatBot bot = new ChatBot(); 
		String actual = bot.whatDate(); // Type 15/11/2022 to get a green bar
		String expected = "15/11/2022";
		assertEquals(actual, expected); 
	}
	
	
	/*
	 * dateValidation()
	 * Takes in dates in different formats and validates the date is in the correct format and returns a boolean. 
	 */


	/*
	 * Test Ten: 
	 * Test Format: dd/MM/yyyy
	 */
	@Test
	public void testDateValidation1() {
		ChatBot bot = new ChatBot(); 
		assertTrue(bot.dateValidation("16/06/2022")); 
	}
	
	
	/*
	 * Test Eleven: 
	 * Test Format: dd-MM-yyyy
	 */
	@Test
	public void testDateValidation2() {
		ChatBot bot = new ChatBot(); 
		assertTrue(bot.dateValidation("16-06-2022")); 
	}
	
	/*
	 * Test Twelve: 
	 * Test Format: dd.MM.yyyy
	 */
	@Test
	public void testDateValidation3() {
		ChatBot bot = new ChatBot(); 
		assertTrue(bot.dateValidation("16.06.2022")); 
	}
	
	/*
	 * Test Thirteen: 
	 * Test Format: dd/MM.yyyy
	 */
	@Test
	public void testDateValidation4() {
		ChatBot bot = new ChatBot(); 
		assertTrue(bot.dateValidation("16/06.2022")); 
	}
	
	/*
	 * Test Fourteen: 
	 * Test Format: dd-MM.yyyy
	 */
	@Test
	public void testDateValidation5() {
		ChatBot bot = new ChatBot(); 
		assertTrue(bot.dateValidation("16-06/2022")); 
	}
	
	/*
	 * Test Fifteen: 
	 * Test Format: dd.MM-yyyy
	 */
	@Test
	public void testDateValidation6() {
		ChatBot bot = new ChatBot(); 
		assertTrue(bot.dateValidation("16.06-2022")); 
	}
	
	
	/*
	 * Test Sixteen: 
	 * Test Format: dd/MM-yyyy
	 */
	@Test
	public void testDateValidation7() {
		ChatBot bot = new ChatBot(); 
		assertTrue(bot.dateValidation("16/06-2022")); 
	}
	
	/*
	 * returnValidDate()
	 * Takes a date and converts it to correct format and then returns the formatted date as a 
	 * String so it can be passed correctly to another method.
	 */
	
	
	/*
	 * Test Seventeen: 
	 * Test Format: dd/MM/yyyy
	 */
	@Test
	public void testReturnValidDate1() {
		ChatBot bot = new ChatBot(); 
		assertTrue(bot.dateValidation("16/06/2022")); 
	}
	
	/*
	 * Test Eighteen: 
	 * Test Format: dd-MM-yyyy
	 */
	@Test
	public void testReturnValidDate2() {
		ChatBot bot = new ChatBot(); 
		assertTrue(bot.dateValidation("16-06-2022")); 
	}
	
	/*
	 * Test Nineteen: 
	 * Test Format: dd.MM.yyyy
	 */
	@Test
	public void testReturnValidDate3() {
		ChatBot bot = new ChatBot(); 
		assertTrue(bot.dateValidation("16.06.2022")); 
	}
	
	/*
	 * Test Twenty: 
	 * Test Format: dd/MM.yyyy
	 */
	@Test
	public void testReturnValidDate4() {
		ChatBot bot = new ChatBot(); 
		assertTrue(bot.dateValidation("16/06.2022")); 
	}
	
	/*
	 * Test Twenty-One: 
	 * Test Format: dd-MM.yyyy
	 */
	@Test
	public void testReturnValidDate5() {
		ChatBot bot = new ChatBot(); 
		assertTrue(bot.dateValidation("16-06.2022")); 
	}
	
	/*
	 * Test Twenty-Two: 
	 * Test Format: dd.MM-yyyy
	 */
	@Test
	public void testReturnValidDate6() {
		ChatBot bot = new ChatBot(); 
		assertTrue(bot.dateValidation("16.06-2022")); 
	}
	
	/*
	 * Test Twenty-Three: 
	 * Test Format: dd/MM-yyyy
	 */
	@Test
	public void testReturnValidDate7() {
		ChatBot bot = new ChatBot(); 
		assertTrue(bot.dateValidation("16/06-2022")); 
	}
	
	
}
