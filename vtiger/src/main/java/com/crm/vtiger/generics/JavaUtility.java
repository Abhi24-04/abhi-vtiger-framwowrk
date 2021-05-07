package com.crm.vtiger.generics;

import java.util.Date;
import java.util.Random;

public class JavaUtility 
{
	/*
	 * generate random number
	 */
	
	public String getRandomData()
	{
		Random random = new Random();
		int ran = random.nextInt(1000);
		return ""+ran;
	}
	
	public String getCurrentSystemDate()
	{
		Date date = new Date();
		String currentdate = date.toString();
		return currentdate;
	}

}
