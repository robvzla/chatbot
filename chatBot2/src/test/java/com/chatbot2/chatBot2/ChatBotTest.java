package com.chatbot2.chatBot2;

import static org.junit.Assert.*;

import org.junit.Test;

import com.chatbot1.chatBot1.chatBot;

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




}
