package testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.LeafTapsWrappers;

public class TC001_DuplicateLead extends LeafTapsWrappers{
	@BeforeClass
	public void setValues(){
		browserName = "chrome";
		dataSheetName = "TC001_DuplicateLead";
		testCaseName = "Duplicate Lead";
		testDescription = "Login to LeafTaps and Duplicate Lead";
		category = "smoke";
		authors = "Praveen Kannan";		
	}
	@Test(dataProvider = "fetchData")
	public void DuplicateLead(String uName, String pwd,String fName){
		new LoginPage(driver, test)
		.enterUserName(uName)
		.enterPassword(pwd)
		.clickLogin()
		.clickCrmSFa()
		.clickLeads()
		.clickFindLeadsPage()
		.enterFname(fName)
		.clickFindLead()
		.clickFirstLeadList()
		.ClickDuplicateLeadPage()
		.verifyDuplicateMsg()
		.clickCreateLead()
		.verifyFirstNameMsg(fName);
	}

}
