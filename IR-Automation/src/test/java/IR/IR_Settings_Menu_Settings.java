package IR;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageClasses.Menu_Settings;
import pageClasses.OverviewSettings;
import setUp.projectSetUp;

public class IR_Settings_Menu_Settings {

	WebDriver driver;
	OverviewSettings OS_OB;
	Menu_Settings MS_OB;
	String baseURL;
	String adminU;
	String adminP;
	String IRU;
	String IRP;
	String Menu;
	String Menu_URL;
	String Sub_Menu;
	String Sub_Menu_URL;
	String Custom_Menu;
	String Custom_Sub_Menu_1;
	String Custom_Sub_Menu_2;
	String Custom_Menu_URL;
	String Custom_Sub_Menu_1_URL;
	String Custom_Sub_Menu_2_URL;

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

		// Initializing Menu Settings Object
		MS_OB = new Menu_Settings(driver);

		// Setting User Details
		baseURL = siteURL;
		adminU = username;
		adminP = password;
		IRU = InstructorU;
		IRP = InstructorP;
		Menu = "Profile";
		Menu_URL = baseURL + "wp-admin/profile.php";
		Sub_Menu = "Groups";
		Sub_Menu_URL = baseURL + "wp-admin/edit.php?post_type=groups";
		Custom_Menu = "All Courses";
		Custom_Menu_URL = baseURL + "courses/";
		Custom_Sub_Menu_1 = "My Account";
		Custom_Sub_Menu_1_URL = baseURL + "my-account/";
		Custom_Sub_Menu_2 = "Shop";
		Custom_Sub_Menu_2_URL = baseURL + "shop/";
		// Login As Admin
		OS_OB.loginToDashboard(driver, baseURL, adminU, adminP);

		/**
		 * Reset Menu Settings
		 */
		// Visit_Menu_Settings_Tab in Settings
		MS_OB.visitBackendSettings(baseURL);
		MS_OB.Reset_Menu_Setting.click();
		driver.switchTo().alert().accept();
		Thread.sleep(500);

	}

	/**
	 * Create Custom Menu
	 * 
	 * @throws Exception
	 */
	@Test(priority = 1)
	public void Create_Custom_Menu() throws Exception {
		// Login As Admin
		OS_OB.loginToDashboard(driver, baseURL, adminU, adminP);
		// Visit_Menu_Settings_Tab in Settings
		MS_OB.visitBackendSettings(baseURL);

		SoftAssert softAssert = new SoftAssert();
		MS_OB.Custom_Menu_Title.clear();
		MS_OB.Custom_Menu_Title.sendKeys(Custom_Menu);

		MS_OB.Custom_Menu_URL.clear();
		MS_OB.Custom_Menu_URL.sendKeys(Custom_Menu_URL);

		MS_OB.save_Custom_Menu.click();
		softAssert.assertTrue(MS_OB.Custom_Menu_In_Settings(Custom_Menu).size() > 0,
				"Custom Menu is not getting added");
		MS_OB.save_Menu_Setting.click();
		Thread.sleep(500);

		// Instructor Login
		OS_OB.loginToDashboard(driver, baseURL, IRU, IRP);

		driver.get(baseURL + "wp-admin/admin.php?page=ir_instructor_overview");

		// Check Menu Item On IR Dashboard
		softAssert.assertTrue(MS_OB.IR_Dash_Menu_in_List(Custom_Menu).size() > 0,
				"Custom Menu is Visible on Instructor's Dashboard");

		// Click On Custom Menu Menu
		MS_OB.IR_Dash_Menu(Custom_Menu).click();
		Thread.sleep(500);

		// Check Custom Menu URL
		softAssert.assertEquals(driver.getCurrentUrl(), Custom_Menu_URL, "Custom Menu URL Not Matching");

		softAssert.assertAll();
	}

	/**
	 * Delete Custom Menu
	 * 
	 * @throws Exception
	 */
	@Test(priority = 2)
	public void Delete_Custom_Menu() throws Exception {
		// Login As Admin
		OS_OB.loginToDashboard(driver, baseURL, adminU, adminP);
		// Visit_Menu_Settings_Tab in Settings
		MS_OB.visitBackendSettings(baseURL);

		SoftAssert softAssert = new SoftAssert();
		// Check if Custom Menu is Present
		softAssert.assertTrue(MS_OB.Custom_Menu_In_Settings(Custom_Menu).size() > 0,
				"Custom Menu for deletion not Available");

		// Delete Custom Menu
		MS_OB.Delete_Custom_Menu(Custom_Menu).click();
		driver.switchTo().alert().accept();
		Thread.sleep(500);

		// Check if Menu is delete or not
		softAssert.assertFalse(MS_OB.Custom_Menu_In_Settings(Custom_Menu).size() > 0,
				"Custom Menu is not getting deleted");

		MS_OB.save_Menu_Setting.click();
		Thread.sleep(500);

		// Instructor Login
		OS_OB.loginToDashboard(driver, baseURL, IRU, IRP);

		driver.get(baseURL + "wp-admin/admin.php?page=ir_instructor_overview");

		// Check Menu Item On IR Dashboard
		softAssert.assertFalse(MS_OB.IR_Dash_Menu_in_List(Custom_Menu).size() > 0,
				"Deleted Custom Menu is still Visible on Instructor's Dashboard");

		softAssert.assertAll();
	}

	/**
	 * Create Custom Sub Menu to Existing Menu
	 * 
	 * @throws Exception
	 */
	@Test(priority = 3)
	public void Create_Custom_Sub_Menu_To_Exising_Default_Menu() throws Exception {
		// Login As Admin
		OS_OB.loginToDashboard(driver, baseURL, adminU, adminP);

		// Visit_Menu_Settings_Tab in Settings
		MS_OB.visitBackendSettings(baseURL);

		SoftAssert softAssert = new SoftAssert();

		// Click Add Sub Menu Icon
		MS_OB.Add_Sub_Menu(Menu).click();
		Thread.sleep(500);

		// Add Sub Menu Title
		MS_OB.Custom_Sub_Menu_Title(Menu).clear();
		MS_OB.Custom_Sub_Menu_Title(Menu).sendKeys(Custom_Sub_Menu_1);

		// Add Sub Menu URL
		MS_OB.Custom_Sub_Menu_URL(Menu).clear();
		MS_OB.Custom_Sub_Menu_URL(Menu).sendKeys(Custom_Sub_Menu_1_URL);

		// Save Sub Menu
		MS_OB.Save_Custom_Sub_Menu(Menu).click();
		Thread.sleep(1500);

		softAssert.assertTrue(MS_OB.Custom_Sub_Menu_In_Settings(Custom_Sub_Menu_1).size() > 0,
				"Custom Sub Menu is not getting added in Selected Main menu");

		// Save Menu Settings
		MS_OB.save_Menu_Setting.click();
		Thread.sleep(500);

		// Instructor Login
		OS_OB.loginToDashboard(driver, baseURL, IRU, IRP);

		driver.get(baseURL + "wp-admin/admin.php?page=ir_instructor_overview");

		// Check Sub Menu Item On IR Dashboard
		softAssert.assertTrue(MS_OB.IR_Dash_Sub_Menu_in_List(Custom_Sub_Menu_1).size() > 0,
				"Custom Sub Menu is not Visible on Instructor's Dashboard");

		// Creating object of an Actions class
		Actions action = new Actions(driver);

		// Performing the mouse hover action on the main menu.
		action.moveToElement(MS_OB.IR_Dash_Menu(Menu)).perform();

		// Click On Custom Menu Menu
		MS_OB.IR_Dash_Sub_Menu(Custom_Sub_Menu_1).click();
		Thread.sleep(500);

		// Check Custom Menu URL
		softAssert.assertEquals(driver.getCurrentUrl(), Custom_Sub_Menu_1_URL, "Custom Sub Menu URL Not Matching");

		softAssert.assertAll();
	}

	/**
	 * Delete Custom Sub Menu From Existing Menu
	 * 
	 * @throws Exception
	 */
	@Test(priority = 4)
	public void Delete_Custom_Sub_Menu_From_Exising_Default_Menu() throws Exception {
		// Login As Admin
		OS_OB.loginToDashboard(driver, baseURL, adminU, adminP);

		// Visit_Menu_Settings_Tab in Settings
		MS_OB.visitBackendSettings(baseURL);

		SoftAssert softAssert = new SoftAssert();
		// Check Sub Menu is Present
		softAssert.assertTrue(MS_OB.Custom_Sub_Menu_In_Settings(Custom_Sub_Menu_1).size() > 0,
				"Custom Sub Menu is not available for deletion");

		// Click Expand Menu Icon
		MS_OB.Expand_Menu(Menu).click();
		Thread.sleep(500);

		// Delete Sub Menu Title
		MS_OB.Delete_Custom_Sub_Menu(Custom_Sub_Menu_1).click();
		driver.switchTo().alert().accept();
		Thread.sleep(500);

		softAssert.assertFalse(MS_OB.Custom_Sub_Menu_In_Settings(Custom_Sub_Menu_1).size() > 0,
				"Custom Sub Menu is not getting Deleted from Selected Main menu");

		// Save Menu Settings
		MS_OB.save_Menu_Setting.click();
		Thread.sleep(500);

		// Instructor Login
		OS_OB.loginToDashboard(driver, baseURL, IRU, IRP);

		driver.get(baseURL + "wp-admin/admin.php?page=ir_instructor_overview");

		// Check Sub Menu Item On IR Dashboard
		softAssert.assertFalse(MS_OB.IR_Dash_Sub_Menu_in_List(Custom_Sub_Menu_1).size() > 0,
				"Deleted Sub Menu is Visible on Instructor's Dashboard");

		softAssert.assertAll();
	}

	/**
	 * Hide Main Menu From Existing Menu
	 * 
	 * @throws Exception
	 */
	@Test(priority = 5)
	public void Hide_Main_Menu() throws Exception {
		// Login As Admin
		OS_OB.loginToDashboard(driver, baseURL, adminU, adminP);

		// Visit_Menu_Settings_Tab in Settings
		MS_OB.visitBackendSettings(baseURL);

		SoftAssert softAssert = new SoftAssert();

		// Open Menu Options
		MS_OB.Menu_Options(Menu).click();

		// Hide Menu Item
		if (!MS_OB.Hide_Menu(Menu).isSelected()) {
			MS_OB.Hide_Menu_slider(Menu).click();
		}

		// Save Menu Settings
		MS_OB.save_Menu_Setting.click();
		Thread.sleep(500);

		// Instructor Login
		OS_OB.loginToDashboard(driver, baseURL, IRU, IRP);

		driver.get(baseURL + "wp-admin/admin.php?page=ir_instructor_overview");

		// Check Sub Menu Item On IR Dashboard
		softAssert.assertFalse(MS_OB.IR_Dash_Menu_in_List(Menu).size() > 0,
				"Hiden Menu is Visible on Instructor's Dashboard");

		// Visit hiden Page
		driver.get(Menu_URL);

		// Check Hiden Page is Accesible or Not
		softAssert.assertFalse(MS_OB.Restricted_Message.size() > 0, "Hiden Menu Page is not accesible to Instructor");

		softAssert.assertAll();
	}

	/**
	 * Hide and Restrict Menu From Existing Menu
	 * 
	 * @throws Exception
	 */
	@Test(priority = 6)
	public void Hide_And_Restrict_Main_Menu() throws Exception {
		// Login As Admin
		OS_OB.loginToDashboard(driver, baseURL, adminU, adminP);

		// Visit_Menu_Settings_Tab in Settings
		MS_OB.visitBackendSettings(baseURL);

		// Reset Menus
		MS_OB.Reset_Menu_Setting.click();
		driver.switchTo().alert().accept();
		Thread.sleep(500);

		SoftAssert softAssert = new SoftAssert();

		// Open Menu Options
		MS_OB.Menu_Options(Menu).click();

		// Hide Menu Item
		if (!MS_OB.Hide_and_Restrict_Menu(Menu).isSelected()) {
			MS_OB.Hide_and_Restrict_Menu_slider(Menu).click();
		}

		// Save Menu Settings
		MS_OB.save_Menu_Setting.click();
		Thread.sleep(500);

		// Instructor Login
		OS_OB.loginToDashboard(driver, baseURL, IRU, IRP);

		driver.get(baseURL + "wp-admin/admin.php?page=ir_instructor_overview");

		// Check Sub Menu Item On IR Dashboard
		softAssert.assertFalse(MS_OB.IR_Dash_Menu_in_List(Menu).size() > 0,
				"Hide and Restricted Menu is Visible on Instructor's Dashboard");

		// Visit hiden Page
		driver.get(Menu_URL);

		// Check Hiden Page is Accesible or Not
		softAssert.assertTrue(MS_OB.Restricted_Message.size() > 0,
				"Restricted Menu Page is still accesible to Instructor");

		softAssert.assertAll();
	}

	/**
	 * Hide Sub Menu From Existing Menu
	 * 
	 * @throws Exception
	 */
	@Test(priority = 7)
	public void Hide_Sub_Menu() throws Exception {
		// Login As Admin
		OS_OB.loginToDashboard(driver, baseURL, adminU, adminP);

		// Visit_Menu_Settings_Tab in Settings
		MS_OB.visitBackendSettings(baseURL);

		SoftAssert softAssert = new SoftAssert();

		MS_OB.Expand_Menu("LearnDash LMS").click();

		// Open Menu Options
		MS_OB.LD_Menu_Options(Sub_Menu).click();

		// Hide Menu Item
		if (!MS_OB.Hide_LD_Sub_Menu(Sub_Menu).isSelected()) {
			MS_OB.Hide_LD_Sub_Menu_slider(Sub_Menu).click();
		}

		// Save Menu Settings
		MS_OB.save_Menu_Setting.click();
		Thread.sleep(500);

		// Instructor Login
		OS_OB.loginToDashboard(driver, baseURL, IRU, IRP);

		driver.get(baseURL + "wp-admin/admin.php?page=ir_instructor_overview");

		// Check Sub Menu Item On IR Dashboard
		softAssert.assertFalse(MS_OB.IR_Dash_Sub_Menu_in_List(Sub_Menu).size() > 0,
				"Hiden Sub Menu is Visible on Instructor's Dashboard");

		// Visit hiden Page
		driver.get(Sub_Menu_URL);

		// Check Hiden Page is Accesible or Not
		softAssert.assertFalse(MS_OB.Restricted_Message.size() > 0,
				"Hiden Sub Menu Page is not accesible to Instructor");

		softAssert.assertAll();
	}

	/**
	 * Hide and Restrict Sub Menu From Existing Menu
	 * 
	 * @throws Exception
	 */
	@Test(priority = 8)
	public void Hide_And_Restrict_Sub_Menu() throws Exception {
		// Login As Admin
		OS_OB.loginToDashboard(driver, baseURL, adminU, adminP);

		// Visit_Menu_Settings_Tab in Settings
		MS_OB.visitBackendSettings(baseURL);

		// Reset Menus
		MS_OB.Reset_Menu_Setting.click();
		driver.switchTo().alert().accept();
		Thread.sleep(500);

		SoftAssert softAssert = new SoftAssert();

		MS_OB.Expand_Menu("LearnDash LMS").click();

		// Open Menu Options
		MS_OB.LD_Menu_Options(Sub_Menu).click();

		// li[contains(text(),'Groups')]//*[contains(@class,'dashicons-ellipsis')]
		// li[contains(text(),'Groups')]//ul[@class='ir-action-submenu']//input[contains(@name,'[hide_restrict]')]

		// Hide Menu Item
		if (!MS_OB.Hide_and_Restrict_LD_Sub_Menu(Sub_Menu).isSelected()) {
			MS_OB.Hide_and_Restrict_LD_Sub_Menu_slider(Sub_Menu).click();
		}

		// Save Menu Settings
		MS_OB.save_Menu_Setting.click();
		Thread.sleep(500);

		// Instructor Login
		OS_OB.loginToDashboard(driver, baseURL, IRU, IRP);

		driver.get(baseURL + "wp-admin/admin.php?page=ir_instructor_overview");

		// Check Sub Menu Item On IR Dashboard
		softAssert.assertFalse(MS_OB.IR_Dash_Sub_Menu_in_List(Sub_Menu).size() > 0,
				"Hide and Restricted Sub Menu is Visible on Instructor's Dashboard");

		// Visit hiden Page
		driver.get(Sub_Menu_URL);

		// Check Hiden Page is Accesible or Not
		softAssert.assertTrue(MS_OB.Restricted_Message.size() > 0,
				"Restricted Sub Menu Page is still accesible to Instructor");

		softAssert.assertAll();
	}
}
