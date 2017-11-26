package pages;

import org.openqa.selenium.remote.RemoteWebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import wrappers.LeafTapsWrappers;

public class MergeLeadPage extends LeafTapsWrappers{

	public MergeLeadPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
		if(!verifyTitle("Merge Leads | opentaps CRM")){
			reportStep("This in not Merge Lead Page", "FAIL");
		}		
	}
	public SwitchtoFindLeadPage clickFromLead(){
		clickByXpathNoSnap("(//img[@alt='Lookup'])[1]");
		switchToLastWindow();
		return new SwitchtoFindLeadPage(driver, test);
	}
	public SwitchtoFindLeadPage clickToLead(){
		clickByXpathNoSnap("(//img[@alt='Lookup'])[2]");
		switchToLastWindow();
		return new SwitchtoFindLeadPage(driver, test);
	}
	
	public ViewLeadPage clickMergeLead(){
		clickByLink("Merge");
		acceptAlert();
		return new ViewLeadPage(driver, test);
	}
}