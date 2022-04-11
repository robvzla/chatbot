package com.chatbot2.chatBot2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class GeoLocator 
{
	// Attributes
	private final String BODY = "http://api.openweathermap.org/geo/1.0/direct?q=";
	private final String API_KEY = "&appid=8fe0a86b1d08f7b8246e13ca39cf3b4e";
	private final String LIMIT = "&limit=1";
	private String LOCATION;
	private URL url;
	private StringBuilder result;
	
	//	Constructor
	public GeoLocator(String location) throws MalformedURLException 
	{
		this.LOCATION = location;
		this.url = new URL(BODY+LOCATION+LIMIT+API_KEY);
	}
	
	public StringBuilder DataRequest() 
	{
		try 
		{
			result = new StringBuilder();
			//			URL url = new URL(urlString);
			URLConnection connection = url.openConnection();
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;


			while ((line = reader.readLine()) != null) 
			{
				result.append(line);
			}
			reader.close();
		} 
		catch (Exception e) 
		{
			System.out.println("Error = " + e);
		}
		return result;
	}
}
