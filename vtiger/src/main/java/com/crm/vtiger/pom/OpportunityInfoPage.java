package com.crm.vtiger.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunityInfoPage 
{
	public OpportunityInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement opportunityInfo;
	
	@FindBy(id="mouseArea_Opportunity Name")
	private WebElement opportunityName;
	
	public WebElement getOpportunityName() {
		return opportunityName;
	}
	@FindBy(id="dtlview_Sales Stage")
	private WebElement salesstageInfo;

	public WebElement getOpportunityInfo() {
		return opportunityInfo;
	}

	public WebElement getSalesstageInfo() {
		return salesstageInfo;
	}
	
	//Business methods
	public String getOpportunityText()
	{
		return opportunityInfo.getText();
	}
	
	public String getSalesStageInfoText()
	{
		return salesstageInfo.getText();
	}

}
