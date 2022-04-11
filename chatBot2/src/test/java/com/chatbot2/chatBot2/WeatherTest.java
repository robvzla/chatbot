package com.chatbot2.chatBot2;

import static org.junit.Assert.*;

import java.net.MalformedURLException;

import org.junit.Test;


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

}
