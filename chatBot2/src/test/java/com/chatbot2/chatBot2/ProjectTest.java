package com.chatbot2.chatBot2;

import static org.junit.Assert.assertNotNull;

import java.net.MalformedURLException;
import java.util.ArrayList;

import org.junit.Test;

public class ProjectTest {

	@Test
	public void testIntegration() throws MalformedURLException
	{
		String location = "Dublin";
		
		GeoLocator geoLocator = new GeoLocator(location);
		ArrayList<String> coordinates = geoLocator.Coordinates();

		Weather weather = new Weather(coordinates.get(0), coordinates.get(1));
		int temperature = weather.RequestedTemperature(1);

		assertNotNull(temperature);
	}

}
