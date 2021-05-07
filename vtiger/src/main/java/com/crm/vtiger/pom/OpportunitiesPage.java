package com.crm.vtiger.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunitiesPage 
{
	
	WebDriver driver;
	public OpportunitiesPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//img[@title='Create Opportunity...']")
	private WebElement createOpportunityIMG;
	
	@FindBy(name="search_text")
	private WebElement searchTF;
	
	@FindBy(name="submit")
	private WebElement searchBTN;

	public WebElement getCreateOpportunityIMG() {
		return createOpportunityIMG;
	}

	public WebElement getSearchTF() {
		return searchTF;
	}

	public WebElement getSearchBTN() {
		return searchBTN;
	}
	
	// Business methods
	public CreateOpportunityPage clickOnCreateOpportunityIMG()
	{
		createOpportunityIMG.click();
		return new CreateOpportunityPage(driver);
	}
	
}
