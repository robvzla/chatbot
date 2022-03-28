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

	@Test
	public void testAskBot() throws IOException 
	{
		ChatBot bot = new ChatBot();
		String botResponse = bot.AskBot();
		Boolean actual = botResponse.isEmpty();
		Boolean expected = false;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetResourcePath() throws IOException 
	{
		ChatBot bot = new ChatBot();
		File file = new File(bot.getResourcesPath());
		assertTrue(file.exists());
	}



}
