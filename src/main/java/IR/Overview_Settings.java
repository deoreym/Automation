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
	String adminU;
	String adminP;
	String IRU;
	String IRP;
	String response; // Server response o Connection

	/**
	 * Before Class: THis Method does Admin Login
	 * 
	 * @param siteURL
	 * @param username
	 * @param password
	 * @throws Exception
	 */
	@Parameters({ "siteURL", "username", "password", "Instructor1", "Instructor1Password" })
	@BeforeClass
	public void connectionSettingsSetUp(String siteURL, String username, String password, String InstructorU, String InstructorP) throws Exception {
		driver = projectSetUp.driver;
		// Initializing ProjectSetUpOperations Object
		projectOperationObject = new ProjectSetUpOperations();

		// Initializing GeneralisedProjectOperations Object
		generalisedOps = new GeneralisedProjectOperations();

		// Initializing EdwiserSettings Object
		GSobj = new GeneralSettings(driver);

		// Setting Admin Details
		baseURL = siteURL;
		adminU=username;
		adminP=password;
		IRU= InstructorU;
		IRP= InstructorP;
	}

	/**
	 * Enable Course Block
	 * 
	 * @throws Exception
	 */
	@Test(priority = 1)
	public void EnableCourseBlock() throws Exception {
		projectOperationObject.loginToAdminDashboard(driver, baseURL, adminU, adminP);
		// Visit Settings
		GSobj.visitInstructorSettings(baseURL);
		
		GSobj.overviewSettings.click();

		if(!GSobj.courseBlock.isSelected()){
			GSobj.courseBlockSlider.click();
		}
		GSobj.overviewSaveSettings.click();
		
		//Instructor Login
		projectOperationObject.loginToAdminDashboard(driver, baseURL, IRU, IRP);
		
		boolean t = GSobj.OvCourseBlock.isDisplayed();
		System.out.println(t);
		Assert.assertTrue(GSobj.OvCourseBlock.isDisplayed(), "Course Block Not Visible");
		// Check response
	}
	
	/**
	 * Enable Course Block
	 * 
	 * @throws Exception
	 */
	@Test(priority = 2)
	public void EnableStudentBlock() throws Exception {
		projectOperationObject.loginToAdminDashboard(driver, baseURL, adminU, adminP);
		
		// Visit Settings
		GSobj.visitInstructorSettings(baseURL);
		
		GSobj.overviewSettings.click();

		if(!GSobj.studentBlock.isSelected()){
			GSobj.studentBlockSlider.click();
		}
		GSobj.overviewSaveSettings.click();
		
		//Instructor Login
		projectOperationObject.loginToAdminDashboard(driver, baseURL, IRU, IRP);
		
		boolean t = GSobj.OvCourseBlock.isDisplayed();
		System.out.println(t);
		Assert.assertFalse(GSobj.OvCourseBlock.isDisplayed(), "Course Block Not Visible");
		// Check response

	}

	
}
