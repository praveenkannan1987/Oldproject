package testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.LeafTapsWrappers;

public class TC001_MergeLead extends LeafTapsWrappers{
	@BeforeClass
	public void setValues(){
		browserName = "chrome";
		dataSheetName = "TC001_MergeLead";
		testCaseName = "Merge Lead";
		testDescription = "Login to LeafTaps and Merge Lead";
		category = "smoke";
		authors = "Praveen Kannan";		
	}
	@Test(dataProvider = "fetchData")
	public void DuplicateLead(String uName, String pwd,String fLeadid,String tLeadid){
		new LoginPage(driver, test)
		.enterUserName(uName)
		.enterPassword(pwd)
		.clickLogin()
		.clickCrmSFa()
		.clickLeads()
		.clickMergeLeadsPage()
		.clickFromLead()
		.enterLeadID(fLeadid)
		.clickFindLead()
		.clickFirstLeadList()
		.clickToLead()
		.enterLeadID(tLeadid)
		.clickFindLead()
		.clickFirstLeadList()
		.clickMergeLead()
		.clickFindLeadsPage()
		.enterLeadID(fLeadid)
		.clickFindLead()
		.verifyNoRecordMsg();
	}

}
