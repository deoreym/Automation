package LD;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageClasses.FCC_Settings;
import pageClasses.LD_Course_Builder_POM;
import pageClasses.OverviewSettings;
import setUp.projectSetUp;

public class LD_Create_Course {

	WebDriver driver;
	FCC_Settings FCCS_OB;
	OverviewSettings OS_OB;
	LD_Course_Builder_POM LD_CB;
	String baseURL;
	String adminU;
	String adminP;
	String IRU;
	String IRP;
	String CourseTitle = "IR_Automation_LD_Course";

	@Parameters({ "siteURL", "username", "password", "Instructor1", "Instructor1Password" })
	@BeforeClass
	public void DriverSetUp(String siteURL, String username, String password, String InstructorU, String InstructorP)
			throws Exception {
		driver = projectSetUp.driver;

		// Initializing Overview Settings Object
		OS_OB = new OverviewSettings(driver);

		// Initializing LD_Course Page Object
		LD_CB = new LD_Course_Builder_POM(driver);

		// Setting User Details
		baseURL = siteURL;
		adminU = username;
		adminP = password;
		IRU = InstructorU;
		IRP = InstructorP;

		// Admin Login
		OS_OB.loginToDashboard(driver, baseURL, adminU, adminP);

		// Initializing FCC Settings Object    
		FCCS_OB = new FCC_Settings(driver);

		// Visit_FCC_Settings_Tab in Settings    
		FCCS_OB.Visit_FCC_Settings_Tab(baseURL);
		// Enable FCC If Disabled from Settings
		if (!FCCS_OB.Enable_FCC.isSelected()) {
			FCCS_OB.Enable_FCC_Slider.click();
		}
		// Disable LearnDash’s backend course creator for instructors    
		if (FCCS_OB.Disable_LD_Edit.isSelected()) {
			FCCS_OB.Disable_LD_Edit_Slider.click();
		}
		// Save Settings
		FCCS_OB.save_Settings.click();

	}

	@Test(priority = 1)
	public void Create_LD_New_Course() throws Exception {

		// Instructor Login
		OS_OB.loginToDashboard(driver, baseURL, IRU, IRP);

		// Visit_Profile_Tabin Settings
		LD_CB.Visit_Courses_List(baseURL);
		SoftAssert softAssert = new SoftAssert();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		driver.get(baseURL + "wp-admin/edit.php?post_type=sfwd-courses");

		LD_CB.Add_New_LD_Course.click();
		Thread.sleep(2000);

		LD_CB.LD_Course_Title_Input.sendKeys(CourseTitle);
		LD_CB.LD_Course_Content.sendKeys("This is Course Content");

		//Add new Section to builder
		LD_CB.LD_Course_CourseBuilder_Tab.click();
		LD_CB.LD_AddNewSection.click();
		String Section = "IR_Automation_Section 1";
		LD_CB.LD_Add_name.sendKeys(Section);
		LD_CB.LD_Add_Button_For_Section.click();
		
		//Add new Lesson to builder
		LD_CB.LD_AddNewLesson.click();
		String Lesson = "IR_Automation_Lesson 1";
		LD_CB.LD_Add_name.sendKeys(Lesson);
		LD_CB.LD_Add_Button_For_Lesson.click();

		//Click Accordian of Newly created Lesson
		executor.executeScript("arguments[0].click();", LD_CB.LD_LessonAccordian(Lesson));
		Thread.sleep(1000);
		
		//Add new Topic to builder
		LD_CB.LD_AddNewTopic.click();
		String Topic = "IR_Automation_Topic 1";
		LD_CB.LD_Add_name.sendKeys(Topic);
		LD_CB.LD_Add_Button_For_Topic.click();
		
		//Add Final Quiz
		LD_CB.LD_Add_Final_Quiz_Button.click();
		String Final_Quiz = "IR_Automation_Final Quiz";
		Thread.sleep(1200);
		LD_CB.LD_Add_name.sendKeys(Final_Quiz);
		LD_CB.LD_Add_Button_For_Quiz.click();
		
		//Navigate to settings Tab
		LD_CB.LD_Course_Settings_Tab.click();
		
		//Setting access mode as BuyNow
		LD_CB.LD_AM_BuyNow.click();
		Thread.sleep(1500);
		LD_CB.LD_Course_Price.clear();
		LD_CB.LD_Course_Price.sendKeys("250");
		
		//Course Prerequisites
		LD_CB.LD_CoursePrerequistiesSlider.click();
		LD_CB.LD_PrerequisiteAllSelected.click();
		
		
		//Course Points
		LD_CB.LD_CoursePointsSlider.click();
		LD_CB.LD_PointsForAccess.clear();
		LD_CB.LD_PointsForAccess.sendKeys("5");
		LD_CB.LD_PointsOnCompletion.clear();
		LD_CB.LD_PointsOnCompletion.sendKeys("10");
		
		//Course Access Expiration
		LD_CB.LD_CourseAccessExpirationSlider.click();
		LD_CB.LD_Access_Period.clear();
		LD_CB.LD_Access_Period.sendKeys("30");
		LD_CB.LD_dataDeletion.click();
		
		//Course Material
		LD_CB.LD_CourseMaterial.click();
		// If need to add the content in the Course Material Area need to use iframe
		
		//Course Certificate
		executor.executeScript("arguments[0].scrollIntoView(true);", LD_CB.LD_CourseCertificate);
		LD_CB.LD_CourseCertificate.click();
		String Certificate = "Quiz Certificate";
		LD_CB.LD_SearchCourseCertificate.sendKeys(Certificate);
		//executor.executeScript("arguments[0].click();", LD_CB.LD_SelectSearchedCertificate(Certificate));
		LD_CB.LD_SelectSearchedCertificate(Certificate).click();
		
		//Course Content Visibility
		executor.executeScript("arguments[0].click();", LD_CB.LD_CourseContent_OnlyVisibletoEnroll);
		//LD_CB.LD_CourseContent_OnlyVisibletoEnroll.click();
		
		//Custom Pagination
		executor.executeScript("arguments[0].click();", LD_CB.LD_CustomPagination);
		//LD_CB.LD_CustomPagination.click();
		LD_CB.CP_Lessons.clear();
		LD_CB.CP_Lessons.sendKeys("10");
		LD_CB.CP_Topics.clear();
		LD_CB.CP_Topics.sendKeys("10");
		
		//Course Progression
		executor.executeScript("arguments[0].scrollIntoView(true);", LD_CB.CP_FreeForm);
		LD_CB.CP_FreeForm.click();
		
		LD_CB.LD_Course_Group_Tab.click();
		//Allocating Group to Course
		String Group = "Automation Group 01";
		LD_CB.LD_Search_Group.sendKeys(Group);
		Thread.sleep(3000);
		LD_CB.LD_SelectGroup(Group).click();
		LD_CB.LD_ArrowtoRight.click();
		Thread.sleep(2000);

		//Publish the course
		LD_CB.LD_Course_Publish_Button.click();
		Thread.sleep(1000);
		LD_CB.LD_Course_Publish_Button2.click();
		Thread.sleep(3000);
		softAssert.assertTrue(LD_CB.Course_Live_Text.size() == 1, "Course Not Published");
		
		//Navigate to Course List Page
		LD_CB.Visit_Courses_List(baseURL);
		
		//Confirm if the created new course is added to course list
		LD_CB.LD_Search_Course.sendKeys(CourseTitle);
		LD_CB.LD_Search_Course_Button.click();
		
		softAssert.assertTrue(LD_CB.LD_CourseList(CourseTitle).size() == 1, "Course Not Present in the Course List");

//		OS_OB.logOut(driver, baseURL);
//		OS_OB.loginToDashboard(driver, baseURL, adminU, adminP);
//		driver.get(baseURL + "wp-admin/edit.php?post_type=sfwd-courses");
//		
//		LD_CB.LD_Search_Course.sendKeys(CourseTitle);
//		LD_CB.LD_Search_Course_Button.click();
//		LD_CB.LD_CourseSelector(CourseTitle).click();
		
		
		softAssert.assertAll();

	}

}
