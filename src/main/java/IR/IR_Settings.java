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

public class IR_Settings {

	WebDriver driver;
	ProjectSetUpOperations projectOperationObject;
	GeneralisedProjectOperations generalisedOps;
	GeneralSettings edwiserSettingObj;
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
		edwiserSettingObj = new GeneralSettings(driver);

		// Setting Admin Details
		baseURL = siteURL;
		projectOperationObject.loginToAdminDashboard(driver, baseURL, username, password);
	}

	/**
	 * Test with Empty Moodle URL and Empty Access Token
	 * 
	 * @throws Exception
	 */
	@Test(priority = 1)
	public void emptyURLandToken() throws Exception {
		// Visit Settings
		edwiserSettingObj.visitInstructorSettings(baseURL);

		// Send Empty URL and Token
		response = edwiserSettingObj.testConnectionSettings("", "");

		// Check response
		Assert.assertEquals(response, "A valid URL was not provided. : to know more about this error click here",
				"Error Message not matched on empty Moodle URL and Token");
	}

	
}
