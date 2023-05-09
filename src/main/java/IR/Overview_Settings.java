package IR;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	GeneralSettings GSobj;
	ProjectSetUpOperations projectOperationObject;
	GeneralisedProjectOperations generalisedOps;

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
	public void connectionSettingsSetUp(String siteURL, String username, String password, String InstructorU,
			String InstructorP) throws Exception {
		driver = projectSetUp.driver;
		// Initializing ProjectSetUpOperations Object
		projectOperationObject = new ProjectSetUpOperations();

		// Initializing GeneralisedProjectOperations Object
		generalisedOps = new GeneralisedProjectOperations();

		// Initializing EdwiserSettings Object
		GSobj = new GeneralSettings(driver);

		// Setting Admin Details
		baseURL = siteURL;
		adminU = username;
		adminP = password;
		IRU = InstructorU;
		IRP = InstructorP;
	}

	/**
	 * Enable Course Block
	 * 
	 * @throws Exception
	 */
	@Test(priority = 2)
	public void EnableCourseBlock() throws Exception {
		projectOperationObject.loginToAdminDashboard(driver, baseURL, adminU, adminP);
		// Visit Settings
		GSobj.visitInstructorSettings(baseURL);

		GSobj.overviewSettings.click();

		if (!GSobj.courseBlock.isSelected()) {
			GSobj.courseBlockSlider.click();
		}
		GSobj.overviewSaveSettings.click();

		// Instructor Login
		projectOperationObject.loginToAdminDashboard(driver, baseURL, IRU, IRP);

		Assert.assertTrue(GSobj.checkinsightBlock("Courses"), "Course Block Not Visible");
		// Check response
	}

	/**
	 * Enable Student Block
	 * 
	 * @throws Exception
	 */
	@Test(priority = 3)
	public void EnableStudentBlock() throws Exception {
		projectOperationObject.loginToAdminDashboard(driver, baseURL, adminU, adminP);

		// Visit Settings
		GSobj.visitInstructorSettings(baseURL);

		GSobj.overviewSettings.click();

		if (!GSobj.studentBlock.isSelected()) {
			GSobj.studentBlockSlider.click();
		}
		GSobj.overviewSaveSettings.click();

		// Instructor Login
		projectOperationObject.loginToAdminDashboard(driver, baseURL, IRU, IRP);

		Assert.assertTrue(GSobj.checkinsightBlock("Students"), "Student Block Not Visible");

	}

	/**
	 * Enable Products Block
	 * 
	 * @throws Exception
	 */
	@Test(priority = 4)
	public void EnableProductsBlock() throws Exception {
		projectOperationObject.loginToAdminDashboard(driver, baseURL, adminU, adminP);

		// Visit Settings
		GSobj.visitInstructorSettings(baseURL);

		GSobj.overviewSettings.click();

		if (!GSobj.productBlock.isSelected()) {
			GSobj.productBlockSlider.click();
		}
		GSobj.overviewSaveSettings.click();

		// Instructor Login
		projectOperationObject.loginToAdminDashboard(driver, baseURL, IRU, IRP);

		Assert.assertTrue(GSobj.checkinsightBlock("Products"), "Products Block Not Visible");

	}

	/**
	 * Enable Earnings Block
	 * 
	 * @throws Exception
	 */
	@Test(priority = 5)
	public void EnableEarningsBlock() throws Exception {
		projectOperationObject.loginToAdminDashboard(driver, baseURL, adminU, adminP);

		// Visit Settings
		GSobj.visitInstructorSettings(baseURL);

		GSobj.overviewSettings.click();

		if (!GSobj.earningBlock.isSelected()) {
			GSobj.earningBlockSlider.click();
		}
		GSobj.overviewSaveSettings.click();

		// Instructor Login
		projectOperationObject.loginToAdminDashboard(driver, baseURL, IRU, IRP);

		Assert.assertTrue(GSobj.checkOverviewBlock("Earnings"), "Earnings Block Not Visible");

	}

	/**
	 * Enable Course Report Block
	 * 
	 * @throws Exception
	 */
	@Test(priority = 6)
	public void EnableCourseReportBlock() throws Exception {
		projectOperationObject.loginToAdminDashboard(driver, baseURL, adminU, adminP);

		// Visit Settings
		GSobj.visitInstructorSettings(baseURL);

		GSobj.overviewSettings.click();

		if (!GSobj.courseReportBlock.isSelected()) {
			GSobj.courseReportBlockSlider.click();
		}
		GSobj.overviewSaveSettings.click();

		// Instructor Login
		projectOperationObject.loginToAdminDashboard(driver, baseURL, IRU, IRP);

		Assert.assertTrue(GSobj.checkOverviewBlock("Course Reports"), "Course Reports Block Not Visible");

	}

	/**
	 * Enable Earnings Block
	 * 
	 * @throws Exception
	 */
	@Test(priority = 7)
	public void EnableSubmissionsBlock() throws Exception {
		projectOperationObject.loginToAdminDashboard(driver, baseURL, adminU, adminP);

		// Visit Settings
		GSobj.visitInstructorSettings(baseURL);

		GSobj.overviewSettings.click();

		if (!GSobj.SubmissionsBlock.isSelected()) {
			GSobj.SubmissionsBlockSlider.click();
		}
		GSobj.overviewSaveSettings.click();

		// Instructor Login
		projectOperationObject.loginToAdminDashboard(driver, baseURL, IRU, IRP);

		Assert.assertTrue(GSobj.checkOverviewBlock("Submissions"), "Submissions Block Not Visible");

	}
	
	/**
	 * Set No Blocks Message
	 * 
	 * @throws Exception
	 */
	@Test(priority = 1)
	public void noBlocksMessage() throws Exception {
		projectOperationObject.loginToAdminDashboard(driver, baseURL, adminU, adminP);

		// Visit Settings
		GSobj.visitInstructorSettings(baseURL);

		GSobj.overviewSettings.click();

		if (GSobj.SubmissionsBlock.isSelected()) {
			GSobj.SubmissionsBlockSlider.click();
		}
		if (GSobj.courseReportBlock.isSelected()) {
			GSobj.courseReportBlockSlider.click();
		}
		if (GSobj.earningBlock.isSelected()) {
			GSobj.earningBlockSlider.click();
		}
		if (GSobj.productBlock.isSelected()) {
			GSobj.productBlockSlider.click();
		}
		if (GSobj.studentBlock.isSelected()) {
			GSobj.studentBlockSlider.click();
		}
		if (GSobj.courseBlock.isSelected()) {
			GSobj.courseBlockSlider.click();
		}
		String NoBlocksMessage ="No Overview Blocks are enabled for instructors";
		GSobj.noBlockMessage.clear();
		GSobj.noBlockMessage.sendKeys(NoBlocksMessage);
		
		GSobj.overviewSaveSettings.click();

		// Instructor Login
		projectOperationObject.loginToAdminDashboard(driver, baseURL, IRU, IRP);

		Assert.assertTrue(GSobj.overviewNoBlocks.getText().equals(NoBlocksMessage), "Submissions Block Not Visible");

	}

}
