package com.chatbot2.chatBot2;

import java.net.MalformedURLException;
import java.net.URL;

public class Weather 
{
	//	Attributes
	private final String BODY = "https://api.openweathermap.org/data/2.5/onecall?lat=";
	private final String LATITUDE;
	private final String LONGITUDE;
	private final String EXCLUDE = "&exclude=current,minutely,hourly,alerts";
	private final String API_KEY = "&appid=8fe0a86b1d08f7b8246e13ca39cf3b4e";
	private final String UNITS = "&units=metric";
	private URL url;
	private StringBuilder result;

	//	constructor
	public Weather(String latitude, String longitude) throws MalformedURLException 
	{
		this.LATITUDE = latitude;
		this.LONGITUDE = "&lon="+longitude;
		this.url = new URL(BODY+LATITUDE+LONGITUDE+EXCLUDE+API_KEY+UNITS);
	}
}
