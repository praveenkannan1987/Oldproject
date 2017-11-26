package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LeafTapsWrappers;

public class ViewLeadPage extends LeafTapsWrappers{

	public ViewLeadPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
		if(!verifyTitle("View Lead | opentaps CRM")){
			reportStep("This in not View Lead Page", "FAIL");
		}		
	}
	String leadid1;
	public ViewLeadPage(RemoteWebDriver driver, ExtentTest test,String leadid){
		this.driver = driver;
		this.test = test;
		this.leadid1=leadid;
		if(!verifyTitle("View Lead | opentaps CRM")){
			reportStep("This in not View Lead Page", "FAIL");
		}		
	}
	
	public ViewLeadPage verifyFirstNameMsg(String text){
		verifyTextById("viewLead_firstName_sp", text);
		return this;
	}
	public ViewLeadPage verifyLeadId(){
		verifyTextContainsById("viewLead_companyName_sp", leadid1);
		return this;
	}
	public ViewLeadPage verifyCompanyNameMsg(String text){
		verifyTextContainsById("viewLead_companyName_sp", text);
		return this;
	}
	public EditLeadPage ClickEditLeadPage(){
		clickByLink("Edit");
		return new EditLeadPage(driver, test);
	}
	public DuplicateLeadPage ClickDuplicateLeadPage(){
		clickByLink("Duplicate Lead");
		return new DuplicateLeadPage(driver, test);
	}
	public MyLeadsPage ClickDeleteLeadPage(){
		clickByLink("Delete");
		return new MyLeadsPage(driver, test);
	}
	public FindLeadPage clickFindLeadsPage(){
		clickByLink("Find Leads");
		return new FindLeadPage(driver, test);
	}
}