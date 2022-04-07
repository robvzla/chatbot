package com.chatbot2.chatBot2;

import static org.junit.Assert.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;


public class AIMLCreatorTest {

	/*
	 Test One: 
	 Ensure that there is no file (in this case called locations) in the aiml directory
	 Note - if the main class has been run then the file will be created and this test will fail
	 But before the class was created this location file did not exist which makes this a valid test case
	 */
	@Test
	public void test() {
		// Create the new bot
		ChatBot bot = new ChatBot(); 
		// File that I will use to create the AIML file will be part of the AIMLCreator constructor
		AIMLCreator file = new AIMLCreator("locations.txt"); 
		
		// Path to where the file should be
		file.setFileName();
		Path path = Paths.get(file.getPrintFileToPath() + file.getFileName() + ".aiml"); 
		boolean isTrue = Files.notExists(path); 
		assertTrue(isTrue); 
	}
	
	

}
