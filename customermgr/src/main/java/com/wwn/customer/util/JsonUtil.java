package com.wwn.customer.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {

	public static String objectToStr(Object object)
	{
		ObjectMapper mapper = new ObjectMapper();
		String str = "";
		try {
			str = mapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return str;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Object strToObject(String str,Class clazz)
	{
		Object object = new Object();
		ObjectMapper mapper = new ObjectMapper();
		try {
			object = mapper.readValue(str, clazz);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return object;
	}
}
