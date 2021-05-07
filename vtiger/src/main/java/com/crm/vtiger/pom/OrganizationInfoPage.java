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
public class OrganizationInfoPage 
{
	WebDriver driver;
	public OrganizationInfoPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement organizationInfo;
	
	@FindBy(id="dtlview_Organization Name")
	private WebElement orgNameEDtInfo;
	public WebElement getOrganizationInfo() {
		return organizationInfo;
	}

	public WebElement getOrgNameEDtInfo() {
		return orgNameEDtInfo;
	}
	
	public String getOrganizationText() {
		return organizationInfo.getText();
	}

}
