package com.crm.vtiger.generics;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;


public class ListImgClass implements ITestListener
{
	public void onTestFailure(ITestResult result)
	{
		String currentdate = new Date().toString().replace(":", "_").replace(" ", "_");
	     String failedtestName = result.getMethod().getMethodName();
		
		EventFiringWebDriver ed = new EventFiringWebDriver(BaseClass.sdriver);
		File src = ed.getScreenshotAs(OutputType.FILE);
		File des = new File("./screenshots/"+failedtestName+".png");
		try {
		FileUtils.copyFile(src, des);
		}
		catch(IOException e){}	
	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
