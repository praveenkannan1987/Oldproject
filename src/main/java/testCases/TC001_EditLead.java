package testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.LeafTapsWrappers;
public class TC001_EditLead extends LeafTapsWrappers{
	@BeforeClass
	public void setValues(){
		browserName = "chrome";
		dataSheetName = "TC001_EditLead";
		testCaseName = "Edit Lead";
		testDescription = "Login to LeafTaps and Edit Lead";
		category = "smoke";
		authors = "Praveen Kannan";		
	}
	@Test(dataProvider = "fetchData")
	public void createLead(String uName, String pwd,String fName,String cName){
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
		.verifyLeadId()
		.ClickEditLeadPage()
		.enterCompanyName(cName)
		.clickUpdate()
		.verifyCompanyNameMsg(cName);
		
	}

}
