package IR;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageClasses.General_Settings;
import pageClasses.OverviewSettings;
import setUp.projectSetUp;

public class IR_Settings_General_Settings {

	WebDriver driver;
	General_Settings GS_OB;
	OverviewSettings OS_OB;
	String baseURL;
	String adminU;
	String adminP;
	String IRU;
	String IRP;
	String GeneralSettings_Tab_URL;

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
		// Initializing General_Settings Object
		GS_OB = new General_Settings(driver);

		// Initializing Overview Settings Object
		OS_OB = new OverviewSettings(driver);

		// Setting Admin Details
		baseURL = siteURL;

		adminU = username;
		adminP = password;
		IRU = InstructorU;
		IRP = InstructorP;
		GeneralSettings_Tab_URL = baseURL + "wp-admin/admin.php?page=instuctor&tab=settings";
		// Admin Login
		OS_OB.loginToDashboard(driver, baseURL, adminU, adminP);
	}

	/**
	 * Enable Course Review
	 * 
	 * @throws Exception
	 */
	@Test(priority = 1)
	public void Enable_Course_Review() throws Exception {

		// Visit General Settings Tab in Settings
		driver.get(GeneralSettings_Tab_URL);
		if (!GS_OB.reviewCourse.isSelected()) {
			GS_OB.reviewCourse.click();
		}

		GS_OB.submit.click();
		Thread.sleep(500);

		driver.get(GeneralSettings_Tab_URL);
		Assert.assertTrue(GS_OB.reviewCourse.isSelected(), "Course Review Setting is not getting saved");

		// Disable Setting
		if (GS_OB.reviewCourse.isSelected()) {
			GS_OB.reviewCourse.click();
		}

		GS_OB.submit.click();
	}

	/**
	 * Enable Quiz Completion Email
	 * 
	 * @throws Exception
	 */
	@Test(priority = 2)
	public void Enable_Quiz_Completion_Email() throws Exception {

		// Visit General Settings Tab in Settings
		driver.get(GeneralSettings_Tab_URL);
		if (!GS_OB.QuizCompletionEmail.isSelected()) {
			GS_OB.QuizCompletionEmail.click();
		}

		GS_OB.submit.click();
		Thread.sleep(500);
		driver.get(GeneralSettings_Tab_URL);
		Assert.assertTrue(GS_OB.QuizCompletionEmail.isSelected(), "Quiz Completion Email Setting is not getting saved");

		// Disable Setting
		if (GS_OB.QuizCompletionEmail.isSelected()) {
			GS_OB.QuizCompletionEmail.click();
		}

		GS_OB.submit.click();
	}

	/**
	 * Enable Course Purchase Emails
	 * 
	 * @throws Exception
	 */
	@Test(priority = 3)
	public void Enable_Course_Purchase_Email() throws Exception {

		// Visit General Settings Tab in Settings
		driver.get(GeneralSettings_Tab_URL);
		if (!GS_OB.coursePurchaseEmail.isSelected()) {
			GS_OB.coursePurchaseEmail.click();
		}

		GS_OB.submit.click();
		Thread.sleep(500);
		driver.get(GeneralSettings_Tab_URL);
		Assert.assertTrue(GS_OB.coursePurchaseEmail.isSelected(), "Course Purchase Setting is not getting saved");
		driver.get(GeneralSettings_Tab_URL);

		// Disable Setting
		if (GS_OB.coursePurchaseEmail.isSelected()) {
			GS_OB.coursePurchaseEmail.click();
		}

		GS_OB.submit.click();
	}

	/**
	 * Enable Instructor Commission
	 * 
	 * @throws Exception
	 */
	@Test(priority = 4)
	public void Enable_Instructor_Commission() throws Exception {

		// Visit General Settings Tab in Settings
		driver.get(GeneralSettings_Tab_URL);
		if (!GS_OB.InstructorCommission.isSelected()) {
			GS_OB.InstructorCommission.click();
		}

		GS_OB.submit.click();
		Thread.sleep(500);
		driver.get(GeneralSettings_Tab_URL);
		Assert.assertTrue(GS_OB.InstructorCommission.isSelected(),
				"Instructor Commission Setting is not getting saved");

		// Disable Setting
		if (GS_OB.InstructorCommission.isSelected()) {
			GS_OB.InstructorCommission.click();
		}

		GS_OB.submit.click();

	}

	/**
	 * Enable Student Communication
	 * 
	 * @throws Exception
	 */
	@Test(priority = 5)
	public void Enable_Student_Communication() throws Exception {
		// Visit General Settings Tab in Settings
		driver.get(GeneralSettings_Tab_URL);
		if (!GS_OB.studentCommunication.isSelected()) {
			GS_OB.studentCommunication.click();
		}

		GS_OB.submit.click();
		Thread.sleep(500);

		driver.get(GeneralSettings_Tab_URL);
		Assert.assertTrue(GS_OB.studentCommunication.isSelected(),
				"Student Communication Setting is not getting saved");

		// Disable Setting
		if (GS_OB.studentCommunication.isSelected()) {
			GS_OB.studentCommunication.click();
		}

		GS_OB.submit.click();

	}

	/**
	 * LearnDash Category Disable Create New
	 * 
	 * @throws Exception
	 */
	@Test(priority = 6)
	public void LearnDash_Category_Disable_Create_New() throws Exception {
		// Visit General Settings Tab in Settings
		driver.get(GeneralSettings_Tab_URL);

		if (!GS_OB.NewLDCategory.isSelected()) {
			GS_OB.NewLDCategory.click();
		}

		GS_OB.submit.click();
		Thread.sleep(500);

		driver.get(GeneralSettings_Tab_URL);
		Assert.assertTrue(GS_OB.NewLDCategory.isSelected(),
				"Instructor Create New Category Setting is not getting saved");

		// Instructor Login
		OS_OB.loginToDashboard(driver, baseURL, IRU, IRP);

		driver.get(baseURL + "wp-admin/post-new.php?post_type=sfwd-courses");

		Assert.assertTrue(!GS_OB.NewCategoryButton.isDisplayed(),
				"Add New Category Option is Present Even If Disbaled From IR Settings");
		// Admin Login
		OS_OB.loginToDashboard(driver, baseURL, adminU, adminP);

		// Disable Setting
		driver.get(GeneralSettings_Tab_URL);
		if (GS_OB.NewLDCategory.isSelected()) {
			GS_OB.NewLDCategory.click();
		}

		GS_OB.submit.click();

	}

	/**
	 * Additional Settings : LearnDash Category Disable
	 * 
	 * @throws Exception
	 */
	@Test(priority = 7)
	public void LearnDash_Category_Disable() throws Exception {
		// Admin Login
		OS_OB.loginToDashboard(driver, baseURL, adminU, adminP);
		// Visit General Settings Tab in Settings
		driver.get(GeneralSettings_Tab_URL);
		if (GS_OB.LDCategories.isSelected()) {
			GS_OB.LDCategories.click();
		}

		GS_OB.submit.click();
		Thread.sleep(500);
		SoftAssert softAssert = new SoftAssert();
		driver.get(GeneralSettings_Tab_URL);
		softAssert.assertFalse(GS_OB.LDCategories.isSelected(),
				"Instructor Disable LD Categories Setting is not getting saved");

		// Instructor Login
		OS_OB.loginToDashboard(driver, baseURL, IRU, IRP);

		// Check Categories Section on Create New Course Page
		driver.get(baseURL + "wp-admin/post-new.php?post_type=sfwd-courses");
		softAssert.assertTrue(GS_OB.CourseCategorySection.size() == 0,
				"Course Categories Option is Present Even If Disbaled From IR Settings");

		// Check Categories Section on Create New Lesson Page
		driver.get(baseURL + "wp-admin/post-new.php?post_type=sfwd-lessons");
		softAssert.assertTrue(GS_OB.LessonCategorySection.size() == 0,
				"Lesson Categories Option is Present Even If Disbaled From IR Settings");

		// Check Categories Section on Create New Topic Page
		driver.get(baseURL + "wp-admin/post-new.php?post_type=sfwd-topic");
		softAssert.assertTrue(GS_OB.TopicCategorySection.size() == 0,
				"Topic Categories Option is Present Even If Disbaled From IR Settings");

		// Check Categories Section on Create New Quiz Page
		driver.get(baseURL + "wp-admin/post-new.php?post_type=sfwd-quiz");
		softAssert.assertTrue(GS_OB.QuizCategorySection.size() == 0,
				"Quiz Categories Option is Present Even If Disbaled From IR Settings");

		// Admin Login
		OS_OB.loginToDashboard(driver, baseURL, adminU, adminP);

		// Enable Again
		driver.get(GeneralSettings_Tab_URL);
		if (!GS_OB.LDCategories.isSelected()) {
			GS_OB.LDCategories.click();
		}

		GS_OB.submit.click();
		softAssert.assertAll();

	}

	/**
	 * Additional Settings : Permalinks Disable
	 * 
	 * @throws Exception
	 */
	@Test(priority = 8)
	public void Permalinks_Disable() throws Exception {
		// Admin Login
		OS_OB.loginToDashboard(driver, baseURL, adminU, adminP);
		// Visit General Settings Tab in Settings
		driver.get(GeneralSettings_Tab_URL);
		if (GS_OB.Permalinks.isSelected()) {
			GS_OB.Permalinks.click();
		}

		GS_OB.submit.click();
		Thread.sleep(500);
		SoftAssert softAssert = new SoftAssert();

		driver.get(GeneralSettings_Tab_URL);
		softAssert.assertFalse(GS_OB.Permalinks.isSelected(),
				"Instructor Disable Permalinks Setting is not getting saved");

		// Instructor Login
		OS_OB.loginToDashboard(driver, baseURL, IRU, IRP);

		// Check Change URL Section on Create New Course Page
		driver.get(baseURL + "wp-admin/post-new.php?post_type=sfwd-courses");
		softAssert.assertTrue(GS_OB.changePermalink.size() == 0,
				"Course Permalink Option is Present Even If Disbaled From IR Settings");

		// Check Change URL Section on Create New Lesson Page
		driver.get(baseURL + "wp-admin/post-new.php?post_type=sfwd-lessons");
		softAssert.assertTrue(GS_OB.changePermalink.size() == 0,
				"Lesson Permalink Option is Present Even If Disbaled From IR Settings");

		// Check Change URL Section on Create New Topic Page
		driver.get(baseURL + "wp-admin/post-new.php?post_type=sfwd-topic");
		softAssert.assertTrue(GS_OB.changePermalink.size() == 0,
				"Topic Permalink Option is Present Even If Disbaled From IR Settings");

		// Check Change URL Section on Create New Quiz Page
		driver.get(baseURL + "wp-admin/post-new.php?post_type=sfwd-quiz");
		softAssert.assertTrue(GS_OB.changePermalink.size() == 0,
				"Quiz Permalink Option is Present Even If Disbaled From IR Settings");

		// Admin Login
		OS_OB.loginToDashboard(driver, baseURL, adminU, adminP);

		// Enable Again
		driver.get(GeneralSettings_Tab_URL);
		if (!GS_OB.Permalinks.isSelected()) {
			GS_OB.Permalinks.click();
		}

		GS_OB.submit.click();
		softAssert.assertAll();

	}

	/**
	 * Additional Settings : Enable/Disable Course Pricing Options
	 * 
	 * @throws Exception
	 */
	@Test(priority = 9)
	public void Enable_Disable_Course_Pricing() throws Exception {
		// Admin Login
		OS_OB.loginToDashboard(driver, baseURL, adminU, adminP);
		// Visit General Settings Tab in Settings
		driver.get(GeneralSettings_Tab_URL);

		if (GS_OB.Open.isSelected()) {
			GS_OB.Open.click();
		}
		if (GS_OB.Free.isSelected()) {
			GS_OB.Free.click();
		}
		if (GS_OB.BuyNow.isSelected()) {
			GS_OB.BuyNow.click();
		}
		if (GS_OB.Recurring.isSelected()) {
			GS_OB.Recurring.click();
		}
		if (GS_OB.Closed.isSelected()) {
			GS_OB.Closed.click();
		}

		GS_OB.submit.click();
		Thread.sleep(500);
		SoftAssert softAssert = new SoftAssert();
		// Instructor Login
		OS_OB.loginToDashboard(driver, baseURL, IRU, IRP);

		// Check Pricing Options on Create New Course Page
		driver.get(baseURL + "wp-admin/post-new.php?post_type=sfwd-courses");
		GS_OB.CourseSettingsTab.click();
		softAssert.assertTrue(GS_OB.CP_Open.size() == 0,
				"Open Price Type is Visible to Instructor Even If Disbaled From IR Settings");
		softAssert.assertTrue(GS_OB.CP_Free.size() == 0,
				"Free Price Type is Visible to Instructor Even If Disbaled From IR Settings");
		softAssert.assertTrue(GS_OB.CP_BuyNow.size() == 0,
				"Buy Now Price Type is Visible to Instructor Even If Disbaled From IR Settings");
		softAssert.assertTrue(GS_OB.CP_Recurring.size() == 0,
				"Recurring Price Type is Visible to Instructor Even If Disbaled From IR Settings");
		softAssert.assertTrue(GS_OB.CP_Closed.size() == 0,
				"Closed Price Type is Visible to Instructor Even If Disbaled From IR Settings");

		// Admin Login
		OS_OB.loginToDashboard(driver, baseURL, adminU, adminP);

		// Enable Again
		driver.get(GeneralSettings_Tab_URL);
		if (!GS_OB.Open.isSelected()) {
			GS_OB.Open.click();
		}
		if (!GS_OB.Free.isSelected()) {
			GS_OB.Free.click();
		}
		if (!GS_OB.BuyNow.isSelected()) {
			GS_OB.BuyNow.click();
		}
		if (!GS_OB.Recurring.isSelected()) {
			GS_OB.Recurring.click();
		}
		if (!GS_OB.Closed.isSelected()) {
			GS_OB.Closed.click();
		}
		GS_OB.submit.click();
		Thread.sleep(500);
		// Instructor Login
		OS_OB.loginToDashboard(driver, baseURL, IRU, IRP);

		// Check Pricing Options on Create New Course Page
		driver.get(baseURL + "wp-admin/post-new.php?post_type=sfwd-courses");
		GS_OB.CourseSettingsTab.click();
		softAssert.assertTrue(GS_OB.CP_Open.size() != 0,
				"Open Price Type is Not Visible to Instructor Even If Enabled From IR Settings");
		softAssert.assertTrue(GS_OB.CP_Free.size() != 0,
				"Free Price Type is Not Visible to Instructor Even If Enabled From IR Settings");
		softAssert.assertTrue(GS_OB.CP_BuyNow.size() != 0,
				"Buy Now Price Type is Not Visible to Instructor Even If Enabled From IR Settings");
		softAssert.assertTrue(GS_OB.CP_Recurring.size() != 0,
				"Recurring Price Type is Not Visible to Instructor Even If Enabled From IR Settings");
		softAssert.assertTrue(GS_OB.CP_Closed.size() != 0,
				"Closed Price Type is Not Visible to Instructor Even If Enabled From IR Settings");
		softAssert.assertAll();
	}

	/**
	 * Enable Instructor Login Redirect
	 * 
	 * @throws Exception
	 */
	@Test(priority = 10)
	public void Enable_Instructor_Login_Redirect() throws Exception {
		// Admin Login
		OS_OB.loginToDashboard(driver, baseURL, adminU, adminP);

		// Visit General Settings Tab in Settings
		driver.get(GeneralSettings_Tab_URL);

		// Enable Instructor Login Redirect
		if (!GS_OB.Instructor_login_redirect.isSelected()) {
			GS_OB.Instructor_login_redirect.click();
		}

		// Set Redirection page
//		GS_OB.RedirectPage.selectByVisibleText("Instructor Dashboard");
//		// wdm_login_redirect_page :Select Login Redirect Page:
		Select RedirectPage = new Select(driver.findElement(By.id("wdm_login_redirect_page")));
		RedirectPage.selectByVisibleText("Instructor Dashboard");

		GS_OB.submit.click();
		Thread.sleep(500);

		// Instructor Login
		OS_OB.loginToDashboard(driver, baseURL, IRU, IRP);
		String Instructor_Dashboard_URL = baseURL + "instructor-dashboard/";

		Assert.assertEquals(driver.getCurrentUrl(), Instructor_Dashboard_URL, "Instructor Login Redirect Not Working");

	}

	/**
	 * Add the Instructor Dashboard Link to the Primary Header Menu for Instructors
	 * 
	 * @throws Exception
	 */
	@Test(priority = 11)
	public void Enable_Instructor_Dashboard_Link_to_Primary_Menu() throws Exception {
		// Admin Login
		OS_OB.loginToDashboard(driver, baseURL, adminU, adminP);

		// Visit General Settings Tab in Settings
		driver.get(GeneralSettings_Tab_URL);

		// Enable Instructor Dashboard Link to the Primary Header Menu for Instructors
		if (!GS_OB.IR_Dash_Link_to_Pri_Menu.isSelected()) {
			GS_OB.IR_Dash_Link_to_Pri_Menu.click();
		}

		GS_OB.submit.click();
		Thread.sleep(500);

		// Instructor Login
		OS_OB.loginToDashboard(driver, baseURL, IRU, IRP);
		driver.get(baseURL);

		Assert.assertTrue(GS_OB.IR_Dash_Menu_Item_inList.size() > 0,
				"Instructor Dashboard link not added to Primary Header Menu");
		GS_OB.IR_Dash_Menu_Item.click();
		Thread.sleep(500);

		String Instructor_Dashboard_URL = baseURL + "wp-admin/admin.php?page=ir_instructor_overview";

		Assert.assertEquals(driver.getCurrentUrl(), Instructor_Dashboard_URL,
				"Instructor Dashboard link is not redirecting to correct page.");

	}

	/**
	 * Enable Product Review
	 * 
	 * @throws Exception
	 */
	@Test(priority = 12)
	public void Enable_Product_Review() throws Exception {
		// Admin Login
		OS_OB.loginToDashboard(driver, baseURL, adminU, adminP);
		// Visit General Settings Tab in Settings
		driver.get(GeneralSettings_Tab_URL);
		if (!GS_OB.reviewProduct.isSelected()) {
			GS_OB.reviewProduct.click();
		}

		GS_OB.submit.click();
		Thread.sleep(500);

		// Instructor Login
		OS_OB.loginToDashboard(driver, baseURL, IRU, IRP);

		driver.get(baseURL + "wp-admin/post-new.php?post_type=product");

		GS_OB.postTitle.clear();
		GS_OB.postTitle.sendKeys("New Review Product");
		GS_OB.publish.click();
		Thread.sleep(500);

		Assert.assertEquals(GS_OB.publish.getAttribute("value"), "Publish",
				"Product is Published when Review Product is Enabled");

		/* Reset Review Prodcuct Settings. */
		// Admin Login
		OS_OB.loginToDashboard(driver, baseURL, adminU, adminP);
		driver.get(GeneralSettings_Tab_URL);
		Thread.sleep(500);
		if (GS_OB.reviewProduct.isSelected()) {
			GS_OB.reviewProduct.click();
		}

		GS_OB.submit.click();
		Thread.sleep(500);
		driver.get(GeneralSettings_Tab_URL);
		Assert.assertFalse(GS_OB.reviewProduct.isSelected(), "Product Review Setting is not getting Disabled");
	}
}
