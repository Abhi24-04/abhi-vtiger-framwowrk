package com.crm.vtiger.generics;

import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Properties;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * @author Abhi
 * 
 */
public class FileUtility 
{
	/**
	 * This method is used to read data from properties and return the value from based on specified key
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String getPropertyKeyValue(String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstant.PROPERTY_FILEPATH);
		Properties prop = new Properties();
		prop.load(fis);
		return prop.getProperty(key);
	}
	
	public String getDataFromJson(String jsonKey) throws Throwable
	{
		  FileReader reader = new FileReader(IPathConstant.JSON_FILEPATH);
		  JsonParser parser = new JsonParser();
		 Object object = parser.parse(reader);
		  JsonObject jsonobject = (JsonObject)object;
		  String value = jsonobject.get(jsonKey).toString();
		  return value;
	}

}
