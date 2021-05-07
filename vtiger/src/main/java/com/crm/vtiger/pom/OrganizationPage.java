package com.crm.vtiger.pom;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * @author Abhishek
 *
 */

public class OrganizationPage 
{
	WebDriver driver;
	public OrganizationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement createOrgLink;
	
	@FindBy(name="search_text")
	private WebElement searchTextField;
	
	@FindBy(name="search")
	private WebElement searchButton;
	
	@FindBy(xpath="//td[@class='moduleName']")
	private WebElement orgText;
	
	public WebElement getOrgText() {
		return orgText;
	}

	public WebElement getCreateOrgLink() {
		return createOrgLink;
	}

	public WebElement getSearchTextField() {
		return searchTextField;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}
	
	/**
	 * click on create organization image
	 */
	public CreateNewOrganizationPage clickOnCreateOrganizationIMG() {
		createOrgLink.click();
		return new CreateNewOrganizationPage(driver);
	}

}
