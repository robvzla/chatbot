package com.chatbot2.chatBot2;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.util.ArrayList;

import org.junit.Test;

import com.chatbot1.chatBot1.Weather;


public class WeatherTest 
{

	@Test
	public void testDataRequest() throws MalformedURLException
	{
		//	Dublin coordinates
		Weather weather = new Weather("53.3498", "-6.2603");
		StringBuilder actual = weather.DataRequest();
		boolean isEmpty = actual.toString().isEmpty();
		assertFalse(isEmpty);
	}
	
	@Test
	public void testForecastTemperatures() throws MalformedURLException
	{
		//	Dublin coordinates
		Weather weather = new Weather("53.3498", "-6.2603");
		int  expected = 8;
		ArrayList<String> temperatures = weather.ForecastTemperatures();
		int actual = temperatures.size();
		assertEquals(expected, actual);
	}

}
