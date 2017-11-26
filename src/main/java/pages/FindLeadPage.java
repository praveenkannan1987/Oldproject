package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LeafTapsWrappers;

public class FindLeadPage extends LeafTapsWrappers{

	public FindLeadPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
		if(!verifyTitle("Find Leads | opentaps CRM")){
			reportStep("This in not Find Leads Page", "FAIL");
		}		
	}
	public FindLeadPage enterFname(String data){
		enterByXpath("(//label[contains(text(),'First name:')])[3]/following::input",data);
		return this;
	}
	public FindLeadPage clickFindLead(){
		clickByXpath("//button[text()='Find Leads']");
		return this;
	}
	public ViewLeadPage clickFirstLeadList(){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String leadid=getTextByXpath("(//*[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a");
		clickByXpath("(//*[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a");
		return new ViewLeadPage(driver, test,leadid);
	}
	public FindLeadPage enterLeadID(String data){
		enterByXpath("(//label[contains(text(),'Lead ID:')])/following::input",data);
		return this;
	}
	public FindLeadPage verifyNoRecordMsg(){
		verifyTextContainsByXpath("//div[contains(text(),'No records to display')]","No records to display");
		return this;
	}	
}
