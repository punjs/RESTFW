package com.sandeep.RESTFW.Utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public final class JSONUtils {
	
	
	
	private static ObjectMapper objectmapper = new ObjectMapper();

	private JSONUtils()
	{
		
	}
	
	/* Convert an object to its JSON representation.
	 * 
	 * @param o The object to convert.
	 * 
	 * @return The JSON string representation of specified objects.
	 * 
	 * @throws Json ProcessingException
	 * */
	
	
	public static String toJSON(final Object o)
	{
		try
		{
			return objectmapper.writeValueAsString(o);
		}catch(JsonProcessingException e )
		{
			e.printStackTrace();
		}
		return null;
	}
	
	
	
}
