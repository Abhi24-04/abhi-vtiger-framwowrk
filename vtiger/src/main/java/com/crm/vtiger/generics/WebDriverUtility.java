package com.crm.vtiger.generics;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/*
 * this class contains webdriver specific generic methods
 * 
 */

public class WebDriverUtility 
{
	public void waitUntilPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public void waitForElementVisibility(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/*
	 * this method wait for the element to be clicked
	 * @param element
	 * @throws Throwable
	 */
	
	public void waitAndClick(WebElement element) throws InterruptedException
	{
		int count =0;
		while(count<40)
		{
			try {
			element.click();
			break;
			}
			catch(Throwable e)
			{
				Thread.sleep(5000);
				count++;
			}
		}
	}
	
	public void javaScriptClick(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("argument[0].click();", element);
	}
	
	/*
	 * This method is used to handle the dropdownlist by value
	 * @param element
	 * @param value
	 */
	public void selectOption(WebElement element, String value)
	{
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	
	/*
	 * This method is used to handle the dropdownlist by index
	 * @param element
	 * @param index
	 */
	public void selectOption(WebElement element, int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	
	/*
	 * This method is used to mouseover to an element
	 * @param driver
	 * @param element
	 */
	public void mouseOver(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	/*
	 * This method is used for Right click on an webelement
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	
	/*
	 * this method is used to switch from one window to another
	 * @param driver
	 * @param partialWinTitle
	 * 
	 */
	public void switchToWindow(WebDriver driver, String partialWinTitle)
	{
		Set<String> window = driver.getWindowHandles();
		Iterator<String> it = window.iterator();
		while(it.hasNext())
		{
			String winId = it.next();
			String title = driver.switchTo().window(winId).getTitle();
			if(title.contains(partialWinTitle))
			{
				break;
			}
			
		}
	}
	
	/*
	 * This method is using to accept alert pop up
	 * @param driver 
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/*
	 * This method is to cancel alert
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/*
	 * This method is used to scrolldown window till perticular webelement
	 * @param driver
	 * @param element
	 */
	public void scrollToWebElement(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		int yaxis = element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+yaxis+")", element);
	}
	
	/*
	 *  This method is used to switch frame by index
	 *  @param driver
	 *  @param index
	 */
	public void switchFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	
	/*
	 *  This method is used to switch frame by webelement reference
	 *  @param driver
	 *  @param element
	 */
	public void switchFrame(WebDriver driver, WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	/*
	 *  This method is used to switch frame by id or name
	 *  @param driver
	 *  @param idOrName
	 */
	public void switchFrame(WebDriver driver, String idOrName)
	{
		driver.switchTo().frame(idOrName);
	}
	
	/*
	 * This method is used to take screenshots
	 * @param driver
	 * @param screenshotname
	 */
	public void takeScreenShot(WebDriver driver, String screenshotname) throws Throwable
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshots/"+screenshotname+".PNG");
		Files.copy(src, dest);		
	}
	
	/*
	 * This method is used for keyboard action
	 * @param key
	 * 
	 */
	public void pressEnterKey(KeyEvent key) throws Throwable
	{
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);	
	}

}
