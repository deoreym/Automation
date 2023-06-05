package IR;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageClasses.OverviewSettings;

import java.util.ArrayList;

import setUp.projectSetUp;

public class IR_Settings_Instructors_Tab {

	WebDriver driver;
	OverviewSettings GS_OB;
	String baseURL;

	/**
	 * Before Class: This Method does Admin Login
	 * 
	 * @param siteURL
	 * @param username
	 * @param password
	 * @throws Exception
	 */
	@Parameters({ "siteURL", "username", "password" })
	@BeforeClass
	public void DriverSetUP(String siteURL, String username, String password) throws Exception {
		driver = projectSetUp.driver;

		// Initializing EdwiserSettings Object
		GS_OB = new OverviewSettings(driver);

		// Setting Admin Details
		baseURL = siteURL;
		GS_OB.loginToDashboard(driver, baseURL, username, password);
	}

	/**
	 * Test with Empty Moodle URL and Empty Access Token
	 * 
	 * @throws Exception
	 */
	@Test(priority = 1)
	public void Set_Commission_For_I_R() throws Exception {
		// Visit Istructors Tab in Settings
		String Instructors_Tab_URL = baseURL + "wp-admin/admin.php?page=instuctor&tab=instructor";
		driver.get(Instructors_Tab_URL);
		String Commission = "25";
		GS_OB.IRCommitionInput.clear();
		GS_OB.IRCommitionInput.sendKeys(Commission);
		GS_OB.IRCommitionUpdate.click();
		Thread.sleep(500);
		Assert.assertEquals(driver.switchTo().alert().getText(), "Updated successfully", "Commission not Updated");
		driver.switchTo().alert().accept();
		driver.get(Instructors_Tab_URL);

		// Check Saved Commission
		Assert.assertEquals(Commission, GS_OB.IRCommitionInput.getAttribute("value"),
				"Commision Set for I R Instructor is not Mating ");
	}

	@Test(priority = 2)
	public void Visit_Dashboard_I_R_User() throws Exception {
		// Visit Istructors Tab in Settings
		String Instructors_Tab_URL = baseURL + "wp-admin/admin.php?page=instuctor&tab=instructor";
		driver.get(Instructors_Tab_URL);

		GS_OB.IRDashboardVisit.click();
		Thread.sleep(500);
		// hold all window handles in array list
		ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
		// switch to new tab
		driver.switchTo().window(newTb.get(1));

		// Check Ir Dashboard Switch to admin link in New Tab
		Assert.assertTrue(GS_OB.SwitchToAdmin.isDisplayed(), "Switch To admin Link Not visible");
		// Back to Admin
		GS_OB.SwitchToAdmin.click();
		// Check If User is Back on IR Settings Instructors Tab
		Assert.assertTrue(driver.getCurrentUrl().equals(Instructors_Tab_URL),
				"Switch To admin no redirected to Instructors tab in IR Settings");
		driver.close();
		Thread.sleep(500);
		// switch to parent window
		driver.switchTo().window(newTb.get(0));
	}

	@Test(priority = 3)
	public void Visit_I_R_User_Profile() throws Exception {
		// Visit Istructors Tab in Settings
		String Instructors_Tab_URL = baseURL + "wp-admin/admin.php?page=instuctor&tab=instructor";
		driver.get(Instructors_Tab_URL);

		GS_OB.IRProfileVisit.click();
		Thread.sleep(500);
		// hold all window handles in array list
		ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
		// switch to new tab
		driver.switchTo().window(newTb.get(1));

		// Check Ir Dashboard Switch to admin link in New Tab
		Assert.assertTrue(GS_OB.PageTitle.isDisplayed(), "I R User Profile Not Visited");
		driver.close();
		Thread.sleep(500);
		// switch to parent window
		driver.switchTo().window(newTb.get(0));

	}
}
