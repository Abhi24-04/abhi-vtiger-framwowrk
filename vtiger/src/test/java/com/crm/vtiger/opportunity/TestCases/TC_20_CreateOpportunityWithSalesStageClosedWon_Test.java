package com.crm.vtiger.opportunity.TestCases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.vtiger.generics.BaseClass;
import com.crm.vtiger.pom.CreateNewOrganizationPage;
import com.crm.vtiger.pom.CreateOpportunityPage;
import com.crm.vtiger.pom.OpportunitiesPage;
import com.crm.vtiger.pom.OpportunityInfoPage;
import com.crm.vtiger.pom.OrganizationInfoPage;
import com.crm.vtiger.pom.OrganizationPage;
@Listeners(com.crm.vtiger.generics.ListImgClass.class)
public class TC_20_CreateOpportunityWithSalesStageClosedWon_Test extends BaseClass
{
	@Test(groups = "smokeTest")
	public void A_createOrganization() throws Throwable
	{
		String orgName = exUtil.getExcelData("Organization", "tc_20", "OrganizationName")+"_"+ju.getRandomData();
		 // Navigate to organization page
	     OrganizationPage orgpage =homepage.clickOnOrganizationLink();
	     
	     // Navigate to create organization page
	     CreateNewOrganizationPage crorgpg = orgpage.clickOnCreateOrganizationIMG();
	     
	     // Navigate to organizationinfo page
	     OrganizationInfoPage orginfopg = crorgpg.createOrganization(orgName);
	     
	     // varify page
	     String actualmsg = orginfopg.getOrganizationInfo().getText();
	     Assert.assertTrue(actualmsg.contains(orgName));
	     Assert.assertEquals(orgName, orginfopg.getOrgNameEDtInfo().getText());
	}
	
	@Test(groups = "regressionTest")
	public void createOpportunity_05() throws Throwable
	{
		    // Read data from excelsheet
	        String oppName = exUtil.getExcelData("Opportunities", "tc_20", "OpportumityName")+"_"+ju.getRandomData();
	        String salstg = exUtil.getExcelData("Opportunities", "tc_20", "Sales Stage");
	        String orgName = exUtil.getExcelData("Opportunities", "tc_20", "Related to");
	   
	        // Navigate to opportunities page
		    OpportunitiesPage opppage = homepage.clickOnOpportunityLink();
			
		    // Navigate to create opportunity page
			CreateOpportunityPage createoppage = opppage.clickOnCreateOpportunityIMG();
			
			// Fill all the mandatory fields and create opportunity
			String childWindowText = "Accounts";
			String parentWindowText ="Potentials&action";
			OpportunityInfoPage oip = createoppage.createOpportunity(oppName, orgName, childWindowText, parentWindowText, salstg);
			
			// Verify page
			String actualmsg = oip.getOpportunityText();
			Assert.assertTrue(actualmsg.contains(oppName));
			Assert.assertEquals(salstg, oip.getSalesStageInfoText());
	}

}
