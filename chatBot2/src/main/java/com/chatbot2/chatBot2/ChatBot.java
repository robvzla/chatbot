package com.chatbot2.chatBot2;

import java.io.File;
import java.util.HashMap;

import org.alicebot.ab.Bot;
import org.alicebot.ab.Chat;
import org.alicebot.ab.History;
import org.alicebot.ab.MagicBooleans;
import org.alicebot.ab.MagicStrings;
import org.alicebot.ab.utils.IOUtils;

public class ChatBot 
{
	// Attributes
	private static final boolean TRACE_MODE = false;
	private static String botName;
	private String resourcesPath;
	private Bot bot;
	private Chat chatSession;
	String userInput;
	private String location;
	private String date;
	private static final String greeting = "Hi, I heard you're going on holiday? Do you want some help planning your wardrobe?";
	// HashMap holds the location and date (given by user) as a key > value pair so the Weather Class can request
	// weather information to the API on the specified location and date.
	// May consider changing the HashMap to a <String, ArrayList<String>> HashMap to make interaction easier with
	// the weather API
	private HashMap<String, String> holidays;
	
	//	Constructor set up the bot
	public ChatBot() 
	{
		botName = "super";
		resourcesPath = getResourcesPath();
		MagicBooleans.trace_mode = TRACE_MODE;
		bot = new Bot("super", resourcesPath);
		chatSession = new Chat(bot);
		bot.brain.nodeStats();
		this.location = "";
		this.date = "";
		this.holidays = new HashMap<String, String>();
	}


	// Add getters for testing purposes
	public String getGreeting() {
		return this.greeting;
	}

	public HashMap<String, String> getHolidays(){
		return this.holidays;
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

	public String AskBot() 
	{
		String botAnswer ="";
		System.out.print("Human : ");

		userInput = IOUtils.readInputTextLine();

		//	Checks if input is empty or null. If it is, then do not let the Bot send a response
		if ((userInput == null) || (userInput.length() < 1))
		{
			userInput = MagicStrings.null_input;
		}

		//	Condition to exit the loop/chat session based on user's input
		if (userInput.equals("q")) 
		{
			System.exit(0);
		} 
		else if (userInput.equals("wq")) 
		{
			bot.writeQuit();
			System.exit(0);
		} 
		else 
		{
			String request = userInput;
			//	Prints what is being talked between user and the Bot
			if (MagicBooleans.trace_mode)
			{
				System.out.println(
						"STATE=" + request + ":THAT=" + ((History) chatSession.thatHistory.get(0)).get(0)
						+ ":TOPIC=" + chatSession.predicates.get("topic"));
			}
			//	This connects to the AIML doc and sends back a response based on what user asks 
			String response = chatSession.multisentenceRespond(request);

			botAnswer = response;
			System.out.println("Robot : " + response);
		}
		return botAnswer;
	}
	
	public String getResourcesPath() 
	{
		File currentDirectory = new File(".");
		//	Gets the full path of the current directory
		String path = currentDirectory.getAbsolutePath();
		path = path.substring(0, path.length() - 2);
		System.out.println(path);
		//	Location to where the Bot's resources are saved in the Java Project
		String resourcesPath = path + File.separator + "src" + File.separator + "main" + File.separator + "resources";
		return resourcesPath;
	}

	public static void main(String[] args) {
		// This is just for testing so the class can run. 
		ChatBot bot = new ChatBot();
		
		while (true) 
		{
			bot.AskBot();
		}
	}
}
