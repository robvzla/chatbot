package com.chatbot2.chatBot2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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

	// Get Resources Path Method
	public static String getResourcesPath() 
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


	// Method to validate the cities
	public Boolean cityValidation(String userInput) throws IOException 
	{
		File citiesText = new File(".");
		String path = citiesText.getAbsolutePath();
		path = path.substring(0, path.length() - 2);
		//	Location to where the city list text is saved in the Java Project
		String resourcesPath = path + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "bots" + File.separator + "super" + File.separator + "config" + File.separator + "citylist.txt";
		File readCityList = new File(resourcesPath);
		//	Buffer will read every single city in the text file
		BufferedReader br = new BufferedReader(new FileReader(readCityList));
		String str;
		//	Loops through the whole city list text to find a match, if return false it means user input is not a valid city
		while ((str = br.readLine()) != null) 
		{
			if (str.equalsIgnoreCase(userInput)) 
			{
				return true;
			}
		}
		br.close();
		return false;
	}


	//	Method gets the input holidays (location & date) from user and store it in a hashmap
	public HashMap<String, String> extractInformation(String response, String request) 
	{
		//	Extracting user's location
		if (response.contains("Noted, what date will you visit?")) 
		{
			location = request;
			/*
			 * 	Disabling the validation of user input for Milestone 1
			 * 	Team is still deciding were to handle wrong/invalid data
			 */
			//			if (cityValidation(request)) 
			//			{
			//				location = request;
			//			}
			//			else 
			//			{
			//				request = "FALSE";
			//				//	Update conversation
			//				response = chatSession.multisentenceRespond(request);
			//			}

		}
		//	Extracting user's date
		if (response.contains("Noted, is there any other place?")) 
		{
			date = request;
			holidays.put(location, date);
		}
		return holidays;
	}


	public String wildCharactersValidation(String response)
	{
		/*	Loops checks if response contains any wild characters that is not readable for the user
		 * 	The AIML file response template is full of wild characters, before displaying bot's response
		 * 	to the user we first check for those characters and replace it with appropriate meaning
		 */	
		while (response.contains("&lt;"))
		{
			response = response.replace("&lt;", "<");
		}
		while (response.contains("&gt;"))
		{
			response = response.replace("&gt;", ">");
		}
		while (response.contains("slash"))
		{
			response = response.replace("slash", "/");
		}
		while (response.contains("dash"))
		{
			response = response.replace("dash", "-");
		}
		return response;
	}

	
	//	Bot takes user input and goes through it AIML document to find an answer, then send back a response
	public String AskBot() throws IOException 
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

			// Check to see if the response has a location, given in the city.txt
			// If it does then change the resources path to the specific aiml file that we want to use to get responses from that

			// Add a setter for the resources path to change it




			//	This connects to the AIML doc and sends back a response based on what user asks

			String response = chatSession.multisentenceRespond(request);

			//	Removes any wild characters in the bot's response and replace it with a more human readable word or symbol. E.g. "&gt;", "&lt;", "slash"
			response = wildCharactersValidation(response);
			/*	Stores location and date from user. This will later be used by the Weather Class to request weather information
			 * 	from the extracted location and date
			 */
			extractInformation(response, request);

			botAnswer = response;
			System.out.println("Robot : " + response);

			/*	Final transition in the AIML file.
			 * 	The string inside contains activates the final template in the AIML file, this
			 * 	displays location and dates collected from the interaction between bot and user.
			 */
			if (response.contains("Just to confirm, you will visit")) 
			{
				for (String i : getHolidays().keySet()) 
				{
					System.out.println("Robot : " + i + " on " + getHolidays().get(i));
				}
				System.out.println("Robot : " + "Right ?");
			}
		}
		return botAnswer;
	}
















}
