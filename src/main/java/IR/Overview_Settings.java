package IR;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageClasses.GeneralSettings;
import setUp.GeneralisedProjectOperations;
import setUp.ProjectSetUpOperations;
import setUp.projectSetUp;

public class Overview_Settings {

	WebDriver driver;
	ProjectSetUpOperations projectOperationObject;
	GeneralisedProjectOperations generalisedOps;
	GeneralSettings GSobj;
	WebDriverWait wait;
	String baseURL;
	String response; // Server response o Connection

	/**
	 * Before Class: THis Method does Admin Login
	 * 
	 * @param siteURL
	 * @param username
	 * @param password
	 * @throws Exception
	 */
	@Parameters({ "siteURL", "username", "password" })
	@BeforeClass
	public void connectionSettingsSetUp(String siteURL, String username, String password) throws Exception {
		driver = projectSetUp.driver;
		// Initializing ProjectSetUpOperations Object
		projectOperationObject = new ProjectSetUpOperations();

		// Initializing GeneralisedProjectOperations Object
		generalisedOps = new GeneralisedProjectOperations();

		// Initializing EdwiserSettings Object
		GSobj = new GeneralSettings(driver);

		// Setting Admin Details
		baseURL = siteURL;
		projectOperationObject.loginToAdminDashboard(driver, baseURL, username, password);
	}

	/**
	 * Test with Empty Moodle URL and Empty Access Token
	 * 
	 * @throws Exception
	 */
	@Parameters({ "Instructor1", "Instructor1Password" })
	@Test(priority = 1)
	public void EnableCourseBlock(String InstructorU, String InstructorP) throws Exception {
		// Visit Settings
		GSobj.visitInstructorSettings(baseURL);
		
		GSobj.overviewSettings.click();

		if(!GSobj.courseBlock.isSelected()){
			GSobj.courseBlockSlider.click();
		}
		GSobj.overviewSaveSettings.click();
		
		//Instructor Login
		projectOperationObject.loginToAdminDashboard(driver, baseURL, InstructorU, InstructorP);
		
		boolean t = GSobj.OvCourseBlock.isDisplayed();
		System.out.println(t);
		Assert.assertTrue(GSobj.OvCourseBlock.isDisplayed(), "Course Block Not Visible");
		// Check response

	}

	
}
