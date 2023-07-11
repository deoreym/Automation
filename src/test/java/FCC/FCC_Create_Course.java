package FCC;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;

import pageClasses.OverviewSettings;
import setUp.projectSetUp;
import pageClasses.FCC_Course;

public class FCC_Create_Course {
	WebDriver driver;
	OverviewSettings OS_OB;
	FCC_Course FCC_Course;
	String baseURL;
	String adminU;
	String adminP;
	String IRU;
	String IRP;
	String CourseTitle = "Automation Course";

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

		// Initializing FCC_Course Page Object
		FCC_Course = new FCC_Course(driver);

		// Setting User Details
		baseURL = siteURL;
		adminU = username;
		adminP = password;
		IRU = InstructorU;
		IRP = InstructorP;

		// Admin Login
		OS_OB.loginToDashboard(driver, baseURL, adminU, adminP);
	}

	/**
	 * Create New Course Via FCC
	 * 
	 * @throws Exception
	 */
	@Test(priority = 1)
	public void Create_New_Course() throws Exception {

		// Visit_Profile_Tabin Settings
		FCC_Course.Visit_Courses_List(baseURL);
		SoftAssert softAssert = new SoftAssert();
		JavascriptExecutor executor = (JavascriptExecutor) driver;

		// Click add New Course
		FCC_Course.Add_New_FCC_Course.click();
		Thread.sleep(2000);
		// Add Course Title
		FCC_Course.Course_Title_Input.clear();
		FCC_Course.Course_Title_Input.clear();
		FCC_Course.Course_Title_Input.sendKeys(CourseTitle);
		FCC_Course.Course_Page.click();
		Thread.sleep(1000);

		// Select Tag
		FCC_Course.TagAccordion.click();
		FCC_Course.SearchTag.clear();
		FCC_Course.SearchTag.sendKeys("Course Tag");
		FCC_Course.SelectTag("Course Tag 01").click();
		Thread.sleep(1000);
		FCC_Course.TagAccordion.click();
		Thread.sleep(1000);
		// Select Category
		FCC_Course.CategoryAccordion.click();
		FCC_Course.SelectCategory("Course Category 01").click();
		Thread.sleep(1000);
		FCC_Course.Course_Title_Input.clear();
		FCC_Course.Course_Title_Input.sendKeys(CourseTitle);
		FCC_Course.Course_Page.click();
		Thread.sleep(1000);
		// Select Group
		FCC_Course.Course_Group_Tab.click();
		FCC_Course.Search_Group.clear();
		FCC_Course.Search_Group.sendKeys("Automation");
		Thread.sleep(1000);

		// Perform the click action on the element
		executor.executeScript("arguments[0].click();", FCC_Course.SelectGroup("Automation Group 01"));
		Thread.sleep(1000);

		// Visit FCC Settings Tab
		FCC_Course.Course_Settings_Tab.click();
		// Course Access Settings
		FCC_Course.CourseAccessSettingAcco.click();
		FCC_Course.CP_Free.click();
		FCC_Course.CoursePrerequistiesSlider.click();
		FCC_Course.PrerequisiteAllSelected.click();
		FCC_Course.Search_Pre_Course.click();
		FCC_Course.SelectPreCourse("Biology").click();
		FCC_Course.PrerequisiteAllSelected.click();
		FCC_Course.CoursePointsSlider.click();
		FCC_Course.PointsForAccess.clear();
		FCC_Course.PointsForAccess.sendKeys("10");
		FCC_Course.PointsOnCompletion.clear();
		FCC_Course.PointsOnCompletion.sendKeys("20");
		FCC_Course.CourseAccessExpirationSlider.click();
		FCC_Course.Access_Period.clear();
		FCC_Course.Access_Period.sendKeys("20");
		FCC_Course.dataDeletion.click();

		// Course Navigation Settings
		FCC_Course.CourseNavigationSettingAcco.click();
		FCC_Course.CP_FreeForm.click();

		// Course Display and content options
		FCC_Course.CourseDispContentOptionAcco.click();
		FCC_Course.CourseMaterialSwitch.click();
		FCC_Course.SearchCertificates.click();
		FCC_Course.SelectCertificate("Math Certificate").click();
		FCC_Course.Only_visible_to_enrollees.click();
		FCC_Course.CustomPaginationSwitch.click();
		FCC_Course.Lessons_PP.clear();
		FCC_Course.Lessons_PP.sendKeys("15");
		FCC_Course.Topics_PP.clear();
		FCC_Course.Topics_PP.sendKeys("15");

		Actions actions = new Actions(driver);
		actions.moveToElement(FCC_Course.Course_Publish_Button);
		Thread.sleep(1000);
		// Click Published
//		FCC_Course.Course_Publish_Button.click();
		executor.executeScript("arguments[0].click();", FCC_Course.Course_Publish_Button);
		Thread.sleep(15000);
		softAssert.assertTrue(FCC_Course.Course_Published_Text.size() == 1, "Course Not Published");

		softAssert.assertAll();
	}

}
