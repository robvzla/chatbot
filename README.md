# ChatBot

This is the initial documentation page for the ChatBot project.
A developer branch was created, it contains the initial ChatBot structure for the team to start developing the methods and classes needed to achieve the project's goal. Below is a UML Class Diagram that displays the overview of the project.
The project will consist of four classes, below is a brief of each class:

## WeatherAPI:
The class will be responsible for establishing a connection with the Open Weather Map API by taking a location as a string. Once a connection has been established (PIN == 200), it will then proceed to get the data from the Open Weather Map page. The obtained data from the website is of type Object, the class will have a method that converts the Object data into a String data type so the team can easily extract the specific data needed (Minimum temperature, Maximum temperature, etc..). The class will have all relevant methods to extract the information needed.

## ChatBot:
The class will be responsible for setting up a Bot and a Chat session for the user to be able to communicate with the Bot. AskBot() method takes the user's input for the Bot to check on its AIML documentation folder, if a match is made, it then proceeds to send back a response to the user. This method will be inside a loop in the MainExecute class and will terminate once the user types the following letters: "q" or "wq".

## GUI:
The class will be responsible for setting up a Chat window for the user to easily interact with the bot instead of the console. The GUI will have a Chat field, text input field, and a send button. The design for the GUI is in the GUI Design section of this wiki. This class will also implement a sound that will play() whenever the bot sends a response back to the user.

## MainExecute:
This will be the main class and it will be responsible for creating an instance of the WeatherAPI, ChatBot, and GUI. Once the instance is created, it will execute the program in an infinite loop ( while(true) ) than can be exited only by user input (letter "q" or "wq").

# UML Class Diagram of the project

![UML_Class_Diagram](https://github.com/robvzla/chatbot/assets/74016825/2fb39979-5578-4481-81e5-8467e2b203ad)



