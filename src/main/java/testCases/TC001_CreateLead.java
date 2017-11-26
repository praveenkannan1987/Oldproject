package testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.LeafTapsWrappers;

public class TC001_CreateLead extends LeafTapsWrappers{
	
	@BeforeClass
	public void setValues(){
		browserName = "chrome";
		dataSheetName = "TC001_CreateLead";
		testCaseName = "Login-Create";
		testDescription = "Login to LeafTaps and Create Lead";
		category = "smoke";
		authors = "Praveen Kannan";		
	}
	
	@Test(dataProvider = "fetchData")
	public void createLead(String uName, String pwd,String fName,String lName,String cName){
		new LoginPage(driver, test)
		.enterUserName(uName)
		.enterPassword(pwd)
		.clickLogin()
		.clickCrmSFa()
		.clickLeads()
		.clickCreateLeadsPage()
		.enterFName(fName)
		.enterlName(lName)
		.enterCName(cName)
		.clickCreateLead()
		.verifyFirstNameMsg(fName);
	}
}
