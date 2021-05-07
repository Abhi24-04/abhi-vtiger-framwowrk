package com.crm.vtiger.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.generics.WebDriverUtility;

public class HomePage extends WebDriverUtility
{
	WebDriver driver;
	public HomePage(WebDriver driver)
    {
		this.driver=driver;
    	PageFactory.initElements(driver, this);
    }
	
	@FindBy(linkText="Organizations")
	private WebElement organizationLink;
	
	@FindBy(linkText="Opportunities")
	private WebElement opportunityLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorIMG;
	
	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement signOutLink;
	
    public WebElement getAdministratorIMG() {
		return administratorIMG;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}

	public WebElement getOrganizationLink() {
		return organizationLink;
	}

	public WebElement getOpportunityLink() {
		return opportunityLink;
	}
	
	//Business methods
	/*
	 * Click on organization link
	 */
	public OrganizationPage clickOnOrganizationLink()
	{
		organizationLink.click();
		return new OrganizationPage(driver);
	}
    
	/*
	 * Click on opportunity link
	 */
	public OpportunitiesPage clickOnOpportunityLink()
	{
		opportunityLink.click();
		return new OpportunitiesPage(driver);
	}
	
	/*
	 * Signout from application
	 */
	public void singnOut()
	{
		mouseOver(driver, administratorIMG);
		signOutLink.click();
	}

}
