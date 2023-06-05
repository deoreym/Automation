package IR;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageClasses.Other_Extensions;
import pageClasses.OverviewSettings;
import setUp.projectSetUp;

public class IR_Settings_Other_Extensions {

	WebDriver driver;
	OverviewSettings OS_OB;
	Other_Extensions OE_OB;
	String baseURL;

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
	public void DriverSetUP(String siteURL, String username, String password) throws Exception {
		driver = projectSetUp.driver;

		// Initializing Overview Settings Object
		OS_OB = new OverviewSettings(driver);

		// Initializing Other Extensions Object
		OE_OB = new Other_Extensions(driver);
		// Setting Admin Details
		baseURL = siteURL;
		OS_OB.loginToDashboard(driver, baseURL, username, password);
	}

	/**
	 * Make Commission Payment
	 * 
	 * @throws Exception
	 */
	@Test(priority = 1)
	public void Check_Other_Extensions_Tab_Links() throws Exception {

		// Visit Visit_Other_Extensions_Tab in Settings
		OE_OB.Visit_Other_Extensions_Tab(baseURL);

		SoftAssert softAssert = new SoftAssert();

		// Check number of cards present
		softAssert.assertTrue(OE_OB.Other_Extensions_List.size() == 5,
				"All 5 product cards not visible on other extensions Tab");

		// Check Browse all our extensions Button Link
		softAssert.assertTrue(
				OE_OB.Browse_All.getAttribute("href").equals("https://wisdmlabs.com/learndash-extensions/"),
				"Browse all our extensions Button Link is not redirecting to Learndash Extensions page on WisdmLabs.com");

		// Check Ratings, Reviews, and Feedback product card link
		softAssert.assertTrue(
				OE_OB.RRF_Card_link.getAttribute("href")
						.contains("https://wisdmlabs.com/learndash-ratings-reviews-feedback/"),
				"Ratings, Reviews, and Feedback product card link is incorrect");

		// Check Group Registration Product card Link
		softAssert.assertTrue(
				OE_OB.LDGR_Card_link.getAttribute("href")
						.contains("https://wisdmlabs.com/group-registration-for-learndash/"),
				"Group Registration product card link is incorrect");

		// Check Quiz Reporting product card link
		softAssert.assertTrue(
				OE_OB.QRE_Card_link.getAttribute("href")
						.contains("https://wisdmlabs.com/quiz-reporting-extension-learndash/"),
				"Quiz Reporting product card link is incorrect");

		// Check Content Cloner product card link
		softAssert.assertTrue(
				OE_OB.LDCC_Card_link.getAttribute("href")
						.contains("https://wisdmlabs.com/course-content-cloner-for-learndash/"),
				"Content Cloner product card link is incorrect");

		// Check eLumine - Theme product card link
		softAssert.assertTrue(OE_OB.eLumine_Card_link.getAttribute("href").contains("https://wisdmlabs.com/elumine/"),
				"eLumine - Theme product card link is incorrect");
		
		// Assert All
		softAssert.assertAll();
	}

}
