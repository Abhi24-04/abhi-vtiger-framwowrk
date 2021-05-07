package com.crm.vtiger.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOrganizationPage
{
	WebDriver driver;
	public CreateNewOrganizationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="accountname")
	private WebElement orgName;
	
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public WebElement getOrgName() {
		return orgName;
	}
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	/**
	 * Use this method to create organization by entering mandatory field
	 * @param organizationName
	 */
	public OrganizationInfoPage createOrganization(String organizationName)
	{
		orgName.sendKeys(organizationName);
		saveBtn.click();
		return new OrganizationInfoPage(driver);
	}

}
