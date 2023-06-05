package IR;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageClasses.FCC_Settings;
import pageClasses.OverviewSettings;
import setUp.projectSetUp;

public class IR_Settings_FCC_Settings {

	WebDriver driver;
	OverviewSettings OS_OB;
	FCC_Settings FCCS_OB;
	String baseURL;
	String adminU;
	String adminP;
	String IRU;
	String IRP;

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
	public void DriverSetUp(String siteURL, String username, String password, String InstructorU, String InstructorP)
			throws Exception {
		driver = projectSetUp.driver;

		// Initializing Overview Settings Object
		OS_OB = new OverviewSettings(driver);

		// Initializing FCC Settings Object
		FCCS_OB = new FCC_Settings(driver);

		// Setting User Details
		baseURL = siteURL;
		adminU = username;
		adminP = password;
		IRU = InstructorU;
		IRP = InstructorP;

		OS_OB.loginToDashboard(driver, baseURL, adminU, adminP);
	}

	/**
	 * Disable FCC and Check Add / Edit Course Options
	 * 
	 * @throws Exception
	 */
	@Test(priority = 1)
	public void Disable_FCC_and_Check_Add_Edit_Course_Options() throws Exception {

		// Visit_FCC_Settings_Tab in Settings
		FCCS_OB.Visit_FCC_Settings_Tab(baseURL);

		SoftAssert softAssert = new SoftAssert();

		// Disable FCC If Enabled from Settings
		if (FCCS_OB.Enable_FCC.isSelected()) {
			FCCS_OB.Enable_FCC_Slider.click();
		}
		// Save Settings
		FCCS_OB.save_Settings.click();

		// Visit Courses Listing in dashboard
		driver.get(baseURL + "wp-admin/edit.php?post_type=sfwd-courses");

		// Check Add New Course via FCC Button
		softAssert.assertTrue(FCCS_OB.Add_New_Via_FCC.size() == 0,
				"When FCC is Disbaled Add New Course Via FCC Button is Visible to Admin ");

		// Check Edit Via FCC Link
		softAssert.assertTrue(FCCS_OB.Edit_Via_FCC.size() == 0,
				"When FCC is Disbaled Edit Course Via FCC Link is Visible to Admin ");

		// Assert All
		softAssert.assertAll();
	}

	/**
	 * Enable FCC and Check Add / Edit Course Options
	 * 
	 * @throws Exception
	 */
	@Test(priority = 2)
	public void Enable_FCC_and_Check_Add_Edit_Course_Options() throws Exception {

		// Visit_FCC_Settings_Tab in Settings
		FCCS_OB.Visit_FCC_Settings_Tab(baseURL);

		SoftAssert softAssert = new SoftAssert();

		// Enable FCC If Disabled from Settings
		if (!FCCS_OB.Enable_FCC.isSelected()) {
			FCCS_OB.Enable_FCC_Slider.click();
		}
		// Save Settings
		FCCS_OB.save_Settings.click();

		// Visit Courses Listing in dashboard
		driver.get(baseURL + "wp-admin/edit.php?post_type=sfwd-courses");

		// Check Add New Course via FCC Button
		softAssert.assertTrue(FCCS_OB.Add_New_Via_FCC.size() > 0,
				"When FCC is Enabled Add New Course Via FCC Button is not Visible to Admin ");

		// Check Edit Via FCC Link
		softAssert.assertTrue(FCCS_OB.Edit_Via_FCC.size() > 0,
				"When FCC is Enbaled Edit Course Via FCC Link is not Visible to Admin ");

		// Instructor Login
		OS_OB.loginToDashboard(driver, baseURL, IRU, IRP);

		// Visit Courses Listing in dashboard
		driver.get(baseURL + "wp-admin/edit.php?post_type=sfwd-courses");

		// Check Add New Course via FCC Button
		softAssert.assertTrue(FCCS_OB.Add_New_Via_FCC.size() > 0,
				"When FCC is Enabled Add New Course Via FCC Button is not Visible to Admin ");

		// Check Edit Via FCC Link
		softAssert.assertTrue(FCCS_OB.Edit_Via_FCC.size() > 0,
				"When FCC is Enbaled Edit Course Via FCC Link is not Visible to Admin ");

		// Assert All
		softAssert.assertAll();
	}

	/**
	 * Disable LearnDash’s backend course creator for instructors
	 * 
	 * @throws Exception
	 */
	@Test(priority = 3)
	public void Disable_LD_Edit_Option_For_Instructor_and_Check_Add_Edit_Course_Options() throws Exception {
		// Admin Login
		OS_OB.loginToDashboard(driver, baseURL, adminU, adminP);

		// Visit_FCC_Settings_Tab in Settings
		FCCS_OB.Visit_FCC_Settings_Tab(baseURL);

		SoftAssert softAssert = new SoftAssert();

		// Enable FCC If Disabled from Settings
		if (!FCCS_OB.Enable_FCC.isSelected()) {
			FCCS_OB.Enable_FCC_Slider.click();
		}

		// Disable LearnDash’s backend course creator for instructors
		if (!FCCS_OB.Disable_LD_Edit.isSelected()) {
			FCCS_OB.Disable_LD_Edit_Slider.click();
		}

		// Save Settings
		FCCS_OB.save_Settings.click();

		// Visit Courses Listing in dashboard
		driver.get(baseURL + "wp-admin/edit.php?post_type=sfwd-courses");

		// Check Add New Course via FCC Button
		softAssert.assertTrue(FCCS_OB.LD_Add_New_Course.size() > 0,
				"When LD Edit Option is Disbaled for Instructors then LD Add New Course Button is not Visible to Admin.");

		// Check Edit Via FCC Link
		softAssert.assertTrue(FCCS_OB.Edit_Via_LD.size() > 0,
				"When LD Edit Option is Disbaled for Instructors then LD Edit Course link is not Visible to Admin");

		// Instructor Login
		OS_OB.loginToDashboard(driver, baseURL, IRU, IRP);

		// Visit Courses Listing in dashboard
		driver.get(baseURL + "wp-admin/edit.php?post_type=sfwd-courses");

		// Check Add New Course via FCC Button
		softAssert.assertTrue(FCCS_OB.LD_Add_New_Course.size() == 0,
				"When LD Edit Option is Disbaled for Instructors then LD Add New Course Button is Visible to Instructors.");

		// Check Edit Via FCC Link
		softAssert.assertTrue(FCCS_OB.Edit_Via_LD.size() == 0,
				"When LD Edit Option is Disbaled for Instructors then LD  Edit Course link is Visible to Instructors.");

		// Assert All
		softAssert.assertAll();
	}

}
