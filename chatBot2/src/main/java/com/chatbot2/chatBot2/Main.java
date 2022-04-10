import java.io.IOException;
import java.text.ParseException;

public class Main {
	public static void main(String[] args) throws IOException, ParseException {
		
		// Create the aiml file from the citylist.txt file
		AIMLCreator newFile = new AIMLCreator("citylist.txt");
		newFile.readFile(); 
		newFile.writeFile();
		
		// Create the bot
		ChatBot bot = new ChatBot(); 
		int i = 0; 
		
		// Run the greeting method
		if(bot.greeting()) {
			do {
				bot.runBot();
			} while (!bot.runBot()); 
		}
//		System.out.println("Show the list of locations and dates: ");
//		bot.displayList(); 
		// Run the askBot method
	}

}
