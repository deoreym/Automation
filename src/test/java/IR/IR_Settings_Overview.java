package IR;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageClasses.OverviewSettings;
import setUp.projectSetUp;

public class IR_Settings_Overview {

	WebDriver driver;
	OverviewSettings OS_OB;

	String baseURL;
	String adminU;
	String adminP;
	String IRU;
	String IRP;

	/**
	 * Before Class: This Method does Admin Login
	 * 
	 * @param siteURL
	 * @param username
	 * @param password
	 * @throws Exception
	 */
	@Parameters({ "siteURL", "username", "password", "Instructor1", "Instructor1Password" })
	@BeforeClass
	public void DriverSetUp(String siteURL, String username, String password, String InstructorU, String InstructorP)
			throws Exception {
		driver = projectSetUp.driver;

		// Initializing Overview Settings Object
		OS_OB = new OverviewSettings(driver);

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
		OS_OB.loginToDashboard(driver, baseURL, adminU, adminP);
		// Visit Settings
		OS_OB.visitBackendSettings(baseURL);

		OS_OB.overviewSettings.click();

		if (!OS_OB.courseBlock.isSelected()) {
			OS_OB.courseBlockSlider.click();
		}
		OS_OB.overviewSaveSettings.click();

		// Instructor Login
		OS_OB.loginToDashboard(driver, baseURL, IRU, IRP);

		driver.get(baseURL + "wp-admin/admin.php?page=ir_instructor_overview");

		Assert.assertTrue(OS_OB.checkinsightBlock("Courses"), "Course Block Not Visible");
		// Check response
	}

	/**
	 * Enable Student Block
	 * 
	 * @throws Exception
	 */
	@Test(priority = 3)
	public void EnableStudentBlock() throws Exception {
		OS_OB.loginToDashboard(driver, baseURL, adminU, adminP);

		// Visit Settings
		OS_OB.visitBackendSettings(baseURL);

		OS_OB.overviewSettings.click();

		if (!OS_OB.studentBlock.isSelected()) {
			OS_OB.studentBlockSlider.click();
		}
		OS_OB.overviewSaveSettings.click();

		// Instructor Login
		OS_OB.loginToDashboard(driver, baseURL, IRU, IRP);

		driver.get(baseURL + "wp-admin/admin.php?page=ir_instructor_overview");

		Assert.assertTrue(OS_OB.checkinsightBlock("Students"), "Student Block Not Visible");

	}

	/**
	 * Enable Products Block
	 * 
	 * @throws Exception
	 */
	@Test(priority = 4)
	public void EnableProductsBlock() throws Exception {
		OS_OB.loginToDashboard(driver, baseURL, adminU, adminP);

		// Visit Settings
		OS_OB.visitBackendSettings(baseURL);

		OS_OB.overviewSettings.click();

		if (!OS_OB.productBlock.isSelected()) {
			OS_OB.productBlockSlider.click();
		}
		OS_OB.overviewSaveSettings.click();

		// Instructor Login
		OS_OB.loginToDashboard(driver, baseURL, IRU, IRP);

		driver.get(baseURL + "wp-admin/admin.php?page=ir_instructor_overview");

		Assert.assertTrue(OS_OB.checkinsightBlock("Products"), "Products Block Not Visible");

	}

	/**
	 * Enable Earnings Block
	 * 
	 * @throws Exception
	 */
	@Test(priority = 5)
	public void EnableEarningsBlock() throws Exception {
		OS_OB.loginToDashboard(driver, baseURL, adminU, adminP);

		// Visit Settings
		OS_OB.visitBackendSettings(baseURL);

		OS_OB.overviewSettings.click();

		if (!OS_OB.earningBlock.isSelected()) {
			OS_OB.earningBlockSlider.click();
		}
		OS_OB.overviewSaveSettings.click();

		// Instructor Login
		OS_OB.loginToDashboard(driver, baseURL, IRU, IRP);

		driver.get(baseURL + "wp-admin/admin.php?page=ir_instructor_overview");

		Assert.assertTrue(OS_OB.checkOverviewBlock("Earnings"), "Earnings Block Not Visible");

	}

	/**
	 * Enable Course Report Block
	 * 
	 * @throws Exception
	 */
	@Test(priority = 6)
	public void EnableCourseReportBlock() throws Exception {
		OS_OB.loginToDashboard(driver, baseURL, adminU, adminP);

		// Visit Settings
		OS_OB.visitBackendSettings(baseURL);

		OS_OB.overviewSettings.click();

		if (!OS_OB.courseReportBlock.isSelected()) {
			OS_OB.courseReportBlockSlider.click();
		}
		OS_OB.overviewSaveSettings.click();

		// Instructor Login
		OS_OB.loginToDashboard(driver, baseURL, IRU, IRP);

		driver.get(baseURL + "wp-admin/admin.php?page=ir_instructor_overview");

		Assert.assertTrue(OS_OB.checkOverviewBlock("Course Reports"), "Course Reports Block Not Visible");

	}

	/**
	 * Enable Earnings Block
	 * 
	 * @throws Exception
	 */
	@Test(priority = 7)
	public void EnableSubmissionsBlock() throws Exception {
		OS_OB.loginToDashboard(driver, baseURL, adminU, adminP);

		// Visit Settings
		OS_OB.visitBackendSettings(baseURL);

		OS_OB.overviewSettings.click();

		if (!OS_OB.SubmissionsBlock.isSelected()) {
			OS_OB.SubmissionsBlockSlider.click();
		}
		OS_OB.overviewSaveSettings.click();

		// Instructor Login
		OS_OB.loginToDashboard(driver, baseURL, IRU, IRP);

		driver.get(baseURL + "wp-admin/admin.php?page=ir_instructor_overview");

		Assert.assertTrue(OS_OB.checkOverviewBlock("Submissions"), "Submissions Block Not Visible");

	}

	/**
	 * Set No Blocks Message
	 * 
	 * @throws Exception
	 */
	@Test(priority = 1)
	public void noBlocksMessage() throws Exception {
		OS_OB.loginToDashboard(driver, baseURL, adminU, adminP);

		// Visit Settings
		OS_OB.visitBackendSettings(baseURL);

		OS_OB.overviewSettings.click();

		if (OS_OB.SubmissionsBlock.isSelected()) {
			OS_OB.SubmissionsBlockSlider.click();
		}
		if (OS_OB.courseReportBlock.isSelected()) {
			OS_OB.courseReportBlockSlider.click();
		}
		if (OS_OB.earningBlock.isSelected()) {
			OS_OB.earningBlockSlider.click();
		}
		if (OS_OB.productBlock.isSelected()) {
			OS_OB.productBlockSlider.click();
		}
		if (OS_OB.studentBlock.isSelected()) {
			OS_OB.studentBlockSlider.click();
		}
		if (OS_OB.courseBlock.isSelected()) {
			OS_OB.courseBlockSlider.click();
		}
		String NoBlocksMessage = "No Overview Blocks are enabled for instructors";
		OS_OB.noBlockMessage.clear();
		OS_OB.noBlockMessage.sendKeys(NoBlocksMessage);

		OS_OB.overviewSaveSettings.click();

		// Instructor Login
		OS_OB.loginToDashboard(driver, baseURL, IRU, IRP);

		driver.get(baseURL + "wp-admin/admin.php?page=ir_instructor_overview");

		Assert.assertTrue(OS_OB.overviewNoBlocks.getText().equals(NoBlocksMessage), "Submissions Block Not Visible");

	}

}
