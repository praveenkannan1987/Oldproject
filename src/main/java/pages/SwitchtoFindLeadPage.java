package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LeafTapsWrappers;

public class SwitchtoFindLeadPage extends LeafTapsWrappers{

	public SwitchtoFindLeadPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
		if(!verifyTitle("Find Leads")){
			reportStep("This in not Find Leads Page", "FAIL");
		}		
	}
	public SwitchtoFindLeadPage enterFname(String data){
		enterByXpath("(//label[contains(text(),'First name:')])[3]/following::input",data);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}
	public SwitchtoFindLeadPage clickFindLead(){
		clickByXpath("//button[text()='Find Leads']");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}
	public MergeLeadPage clickFirstLeadList(){
		clickByXpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a");
		switchToParentWindow();
		return new MergeLeadPage(driver, test);
	}
	public SwitchtoFindLeadPage enterLeadID(String data){
		enterByXpath("(//label[contains(text(),'Lead ID:')])/following::input",data);
		return this;
	}
	public SwitchtoFindLeadPage verifyNoRecordMsg(){
		verifyTextContainsByXpath("//div[contains(text(),'No records to display')]","No records to display");
		return this;
	}
	
}
