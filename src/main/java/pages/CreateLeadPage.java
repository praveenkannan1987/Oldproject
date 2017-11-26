package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LeafTapsWrappers;

public class CreateLeadPage extends LeafTapsWrappers{

	public CreateLeadPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
		if(!verifyTitle("Create Lead | opentaps CRM")){
			reportStep("This is not Create Lead Page", "FAIL");
		}		
	}

	public CreateLeadPage enterCName(String data){
		enterById("createLeadForm_companyName", data);
		return this;
	}
	
	public CreateLeadPage enterFName(String data){
		enterById("createLeadForm_firstName", data);
		return this;
	}
	
	public CreateLeadPage enterlName(String data){
		enterById("createLeadForm_lastName", data);
		return this;
	}
	
	public ViewLeadPage clickCreateLead(){
		clickByClassName("smallSubmit");
		return new ViewLeadPage(driver, test);
	}
}