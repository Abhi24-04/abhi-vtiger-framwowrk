package com.crm.vtiger.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.vtiger.generics.WebDriverUtility;

public class CreateOpportunityPage extends WebDriverUtility
{
	WebDriver driver;
	public CreateOpportunityPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="potentialname")
	private WebElement opportunityNameTF;
	
	@FindBy(name="sales_stage")
	private WebElement salesstgdrp;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement orgSelectBTN;
	
	public WebElement getOrgSelectBTN() {
		return orgSelectBTN;
	}

	public WebElement getOpportunityNameTF() {
		return opportunityNameTF;
	}

	public WebElement getSalesstgdrp() {
		return salesstgdrp;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public OpportunityInfoPage createOpportunity(String oppName, String organizationName,String childWindowText,String parentWindowText, String option) throws Throwable
	{
		opportunityNameTF.sendKeys(oppName);
		orgSelectBTN.click();
		switchToWindow(driver, childWindowText);
		OrganizationPage orgPage = new OrganizationPage(driver);
		orgPage.getSearchTextField().sendKeys(organizationName);
		orgPage.getSearchButton().click();
		driver.findElement(By.linkText(organizationName)).click();
		switchToWindow(driver, parentWindowText);
		selectOption(salesstgdrp, option);
		waitAndClick(saveBtn);
		//saveBtn.click();
		return new OpportunityInfoPage(driver);
	}

}
