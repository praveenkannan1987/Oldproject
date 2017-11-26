package testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.LeafTapsWrappers;

public class TC001_DeleteLead extends LeafTapsWrappers{
	@BeforeClass
	public void setValues(){
		browserName = "chrome";
		dataSheetName = "TC001_DeleteLead";
		testCaseName = "Delete Lead";
		testDescription = "Login to LeafTaps and Delete Lead";
		category = "smoke";
		authors = "Praveen Kannan";		
	}
	@Test(dataProvider = "fetchData")
	public void createLead(String uName, String pwd,String fLeadId){
		new LoginPage(driver, test)
		.enterUserName(uName)
		.enterPassword(pwd)
		.clickLogin()
		.clickCrmSFa()
		.clickLeads()
		.clickFindLeadsPage()
		.enterLeadID(fLeadId)
		.clickFindLead()
		.clickFirstLeadList()
		.ClickDeleteLeadPage()
		.clickFindLeadsPage()
		.enterLeadID(fLeadId)
		.clickFindLead()
		.verifyNoRecordMsg();
	}

}
