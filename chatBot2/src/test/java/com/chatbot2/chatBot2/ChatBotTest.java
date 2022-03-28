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
		chatBot bot = new chatBot();
		assertEquals(s1, bot.getGreeting());
	}




}
