package com.crm.vtiger.generics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.crm.vtiger.pom.HomePage;
import com.crm.vtiger.pom.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
	public WebDriver driver;
	public ExcelUtility exUtil=new ExcelUtility();
	public FileUtility fUtil=new FileUtility();
	public WebDriverUtility wdu=new WebDriverUtility();
	public JavaUtility ju=new JavaUtility();
	public static WebDriver sdriver;
	public HomePage homepage;
	
	@BeforeSuite(groups = {"smokeTest" , "regressionTest"})
	public void configBeforSuite() {
		//connect to DB
	}
	
	@BeforeTest(groups = {"smokeTest" , "regressionTest"})
	public void configBeforTest() {
		//launch browser in parallel mode
	}
	
	@BeforeClass(groups = {"smokeTest" , "regressionTest"})
	public void configBeforeClass() throws Throwable 
	{
		String browserName=fUtil.getPropertyKeyValue("browser");
		if(browserName.equalsIgnoreCase("firefox")) 
		{
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}
		else if(browserName.equalsIgnoreCase("IE")) {
			driver=new InternetExplorerDriver();
		}
		else
		{
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}
		sdriver=driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		
	}
	
	/*@BeforeClass(groups = {"smokeTest" , "regressionTest"})
	public void configBC()
	{
		driver = new ChromeDriver();
		wdu.waitUntilPageLoad(driver);
		driver.manage().window().maximize();
		sdriver=driver;
	}*/
	@BeforeMethod(groups = {"smokeTest" , "regressionTest"})
	public void setUp() throws Throwable 
	{
		String url=fUtil.getPropertyKeyValue("url");
		String username=fUtil.getPropertyKeyValue("username");
		String password=fUtil.getPropertyKeyValue("password");
		driver.get(url);
		LoginPage loginpage = new LoginPage(driver);
		homepage=loginpage.login(username, password);
	}
	@AfterMethod(groups = {"smokeTest" , "regressionTest"})
	public void tearDown() throws Throwable
	{
		HomePage homepage = new HomePage(driver);
		homepage.singnOut();
	}
	
	@AfterClass(groups = {"smokeTest" , "regressionTest"})
	public void configAfterClass()
	{
		driver.quit();
	}
	
	@AfterTest(groups = {"smokeTest" , "regressionTest"})
	public void configAfterTest() {
		//close driver ref in parallel mode
	}
	
	@AfterSuite(groups = {"smokeTest" , "regressionTest"})
	public void configAfterSuite() {
		// close DB connection
	}

}

