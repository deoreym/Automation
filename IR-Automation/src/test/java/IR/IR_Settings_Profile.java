package IR;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageClasses.Instructor_Profile;
import pageClasses.OverviewSettings;
import setUp.projectSetUp;

public class IR_Settings_Profile {

	WebDriver driver;
	OverviewSettings OS_OB;
	Instructor_Profile IP_OB;
	String baseURL;
	String adminU;
	String adminP;
	String IRU;
	String IRP;
	String IR_Pro_Field = "IR_Pro_Field";
	String IR_Pro_Field_Meta = "IR_Pro_Field_Meta";

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

		// Initializing Other Extensions Object
		IP_OB = new Instructor_Profile(driver);
		// Setting User Details
		baseURL = siteURL;
		adminU = username;
		adminP = password;
		IRU = InstructorU;
		IRP = InstructorP;
		// Admin Login
		OS_OB.loginToDashboard(driver, baseURL, adminU, adminP);
	}

	// ir-profile-update-image
	// ir-profile-update-datatype
	// ir-profile-update-icon

	/**
	 * Enable_Disable_Profile_Links
	 * 
	 * @throws Exception
	 */
	@Test(priority = 1)
	public void Enable_Disable_Profile_Links() throws Exception {

		// Visit_Profile_Tabin Settings
		IP_OB.Visit_Profile_Tab(baseURL);
		SoftAssert softAssert = new SoftAssert();

		// Disable Profile Links
		if (IP_OB.Profile_Links.isSelected()) {
			IP_OB.Profile_Links.click();
		}
		IP_OB.SaveProfileSettings.click();
		Thread.sleep(500);

		softAssert.assertFalse(IP_OB.Profile_Links.isSelected(), "Profile Links Setting is Not getting Disabled");

		// Enable Profile Links
		if (!IP_OB.Profile_Links.isSelected()) {
			IP_OB.Profile_Links.click();
		}
		IP_OB.SaveProfileSettings.click();
		Thread.sleep(500);

		softAssert.assertTrue(IP_OB.Profile_Links.isSelected(), "Profile Links Setting is Not getting Enabled");

		// Assert All
		softAssert.assertAll();
	}

	/**
	 * Create_New_Profile_Section
	 * 
	 * @throws Exception
	 */
	@Test(priority = 2)
	public void Create_New_Profile_Section() throws Exception {

		// Visit_Profile_Tabin Settings
		IP_OB.Visit_Profile_Tab(baseURL);

		// Click Add New
		IP_OB.AddNewSection.click();

		// Set Field Setion Details
		IP_OB.Title.clear();
		IP_OB.Title.sendKeys(IR_Pro_Field);
		IP_OB.Select_Image().selectByValue("irp-achievements-list");
		IP_OB.MetaKey.clear();
		IP_OB.MetaKey.sendKeys(IR_Pro_Field_Meta);
		IP_OB.Select_DataType().selectByValue("paragraph");
		IP_OB.Select_Icon().selectByValue("ir-icon-Trophy");
		IP_OB.AddSectionButton.click();
		Thread.sleep(500);
		SoftAssert softAssert = new SoftAssert();

		// Check Profile Field Setion getting added in Settings Tab
		softAssert.assertTrue(IP_OB.Profile_Field_in_Settings(IR_Pro_Field).size() > 0,
				"Profile Field Setion not getting added in Settings Tab");

		IP_OB.SaveProfileSettings.click();
		Thread.sleep(500);

		// Instructor Login
		OS_OB.loginToDashboard(driver, baseURL, IRU, IRP);

		// Visit Instructor Profile Edit Page
		IP_OB.Visit_Profile_Edit_Page(baseURL);

		// Check Newly Added Section in Instructor Profile Edit Page
		softAssert.assertTrue(IP_OB.Profile_Field_Title(IR_Pro_Field).size() > 0,
				"Profile Field Setion not getting added in Edit Instructor Profile");

		// Assert All
		softAssert.assertAll();
	}

	/**
	 * Delete_New_Profile_Section
	 * 
	 * @throws Exception
	 */
	@Test(priority = 3)
	public void Delete_New_Profile_Section() throws Exception {
		// Admin Login
		OS_OB.loginToDashboard(driver, baseURL, adminU, adminP);

		// Visit_Profile_Tabin Settings
		IP_OB.Visit_Profile_Tab(baseURL);
		SoftAssert softAssert = new SoftAssert();
		Assert.assertTrue(IP_OB.Profile_Field_in_Settings(IR_Pro_Field).size() > 0,
				"Profile Field Setion not Available For Deletion in Settings Tab");

		IP_OB.Profile_Field_Delete_in_Settings(IR_Pro_Field).click();
		IP_OB.SaveProfileSettings.click();
		Thread.sleep(500);
		IP_OB.Visit_Profile_Tab(baseURL);

		softAssert.assertTrue(IP_OB.Profile_Field_in_Settings(IR_Pro_Field).size() == 0,
				"Profile Field Setion not geting deleted from Settings Tab");

		// Assert All
		softAssert.assertAll();
	}

}
