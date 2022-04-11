package com.chatbot2.chatBot2;

import static org.junit.Assert.*;

import java.net.MalformedURLException;

import org.junit.Test;


public class GeoLocatorTest {

	@Test
	public void testDataRequest() throws MalformedURLException
	{
		//	Dublin coordinates
		GeoLocator geoLocator = new GeoLocator("Dublin");
		StringBuilder  actual = geoLocator.DataRequest();
		boolean isEmpty = actual.toString().isEmpty();
		assertFalse(isEmpty);
	}
	
	

}
