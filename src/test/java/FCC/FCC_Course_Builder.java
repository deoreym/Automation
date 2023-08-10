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
import pageClasses.FCC_Course_Builder_POM;

public class FCC_Course_Builder {
	WebDriver driver;
	OverviewSettings OS_OB;
	FCC_Course_Builder_POM FCC_CB;
	String baseURL;
	String adminU;
	String adminP;
	String IRU;
	String IRP;
	String CourseTitle = "Automation Course";
	String Lesson;
	String Topic;
	String Quiz;
	String Section;

	/**
	 * Before Class: This Method does Admin Login
	 * 
	 * @param siteURL
	 * @param username
	 * @param password
	 * @throws Exception
	 */
	@Parameters({ "siteURL", "username", "password", "Instructor1", "Instructor1Password", "Lesson", "Topic", "Quiz",
			"Section" })
	@BeforeClass
	public void DriverSetUp(String siteURL, String username, String password, String InstructorU, String InstructorP,
			String ex_lesson, String ex_topic, String ex_quiz, String section) throws Exception {
		driver = projectSetUp.driver;

		// Initializing Overview Settings Object
		OS_OB = new OverviewSettings(driver);

		// Initializing FCC_CB Builder Page Object
		FCC_CB = new FCC_Course_Builder_POM(driver);

		// Setting User Details
		baseURL = siteURL;
		adminU = username;
		adminP = password;
		IRU = InstructorU;
		IRP = InstructorP;
		Lesson = ex_lesson;
		Topic = ex_topic;
		Quiz = ex_quiz;
		Section = section;

		// Admin Login
		OS_OB.loginToDashboard(driver, baseURL, adminU, adminP);
	}

	/**
	 * Add Existing Content To Course Using Builder
	 * 
	 * @throws Exception
	 */
//	@Test(priority = 1)
	public void Add_Existing_Content_To_Builder() throws Exception {

		// Visit_Profile_Tabin Settings
		FCC_CB.Visit_Courses_List(baseURL);
		SoftAssert softAssert = new SoftAssert();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		Actions actions = new Actions(driver);

		// Click add New Course
		FCC_CB.Add_New_FCC_Course.click();
		Thread.sleep(4000);
		// Add Course Title
		FCC_CB.Course_Title_Input.clear();
		FCC_CB.Course_Title_Input.sendKeys(CourseTitle);
		Thread.sleep(1000);
		FCC_CB.Course_Page.click();
		Thread.sleep(1000);

		FCC_CB.Course_Builder_Tab.click();
		Thread.sleep(3000);
		FCC_CB.LessonsAccordion.click();
		FCC_CB.SearchLessons.clear();
		FCC_CB.SearchLessons.sendKeys(Lesson);
		Thread.sleep(500);
		actions.moveToElement(FCC_CB.SearchedItem(Lesson)).build().perform();
		Thread.sleep(500);
		FCC_CB.AddButton(Lesson).click();
		FCC_CB.LessonsAccordion.click();

		softAssert.assertTrue(FCC_CB.FindAddedContent(Lesson) > 0, "Lesson not added to builder");
		Thread.sleep(1000);

		FCC_CB.ExpandAll.click();
		FCC_CB.TopicsAccordion.click();
		FCC_CB.SearchTopics.clear();
		FCC_CB.SearchTopics.sendKeys(Topic);
		Thread.sleep(1000);
		actions.moveToElement(FCC_CB.SearchedItem(Topic)).build().perform();
		FCC_CB.AddButton(Topic).click();
		FCC_CB.TopicsAccordion.click();
		softAssert.assertTrue(FCC_CB.FindAddedContent(Topic) > 0, "Topic not added to builder");
		Thread.sleep(1000);

		FCC_CB.QuizzesAccordion.click();
		FCC_CB.SearchQuizzes.clear();
		FCC_CB.SearchQuizzes.sendKeys(Quiz);
		Thread.sleep(1000);
		actions.moveToElement(FCC_CB.SearchedItem(Quiz)).build().perform();
		FCC_CB.AddButton(Quiz).click();
		FCC_CB.QuizzesAccordion.click();
		softAssert.assertTrue(FCC_CB.FindAddedContent(Quiz) > 0, "Quiz not added to builder");

		// Remove Quiz
		if (FCC_CB.FindAddedContent(Quiz) > 0) {
			FCC_CB.RemoveQuizIcon.click();
			FCC_CB.RemoveButton.click();
			softAssert.assertFalse(FCC_CB.FindAddedContent(Quiz) > 0, "Quiz is not getting removed from builder.");
		} else {
			softAssert.assertTrue(true, "Quiz For Removal Not Found.");
		}

		// Remove Topic
		if (FCC_CB.FindAddedContent(Topic) > 0) {
			FCC_CB.RemoveTopicIcon.click();
			FCC_CB.RemoveButton.click();
			softAssert.assertFalse(FCC_CB.FindAddedContent(Topic) > 0, "Topic is not getting removed from builder.");
		} else {
			softAssert.assertTrue(true, "Topic For Removal Not Found.");
		}

		// Remove Lesson
		if (FCC_CB.FindAddedContent(Lesson) > 0) {
			FCC_CB.RemoveLessonIcon.click();
			FCC_CB.RemoveButton.click();
			softAssert.assertFalse(FCC_CB.FindAddedContent(Lesson) > 0, "Lesson is not getting removed from builder.");
		} else {
			softAssert.assertTrue(true, "Lesson For Removal Not Found.");
		}

		Thread.sleep(1000);
		// Click Published
		// FCC_CB.Course_Publish_Button.click();
		executor.executeScript("arguments[0].click();", FCC_CB.Course_Publish_Button);
		Thread.sleep(15000);
		softAssert.assertTrue(FCC_CB.Course_Published_Text.size() == 1, "Course Not Published");

		softAssert.assertAll();
	}

	/**
	 * Add New Content To Course Using Builder
	 * 
	 * @throws Exception
	 */
	@Parameters({ "Course", "Lesson1", "Topic1", "Quiz1", "Section1" })
	@Test(priority = 2)
	public void Add_New_Content_To_Builder(String N_Course, String N_lesson, String N_topic, String N_quiz,
			String N_Section) throws Exception {

		// Visit_Profile_Tabin Settings
		FCC_CB.Visit_Courses_List(baseURL);
		SoftAssert softAssert = new SoftAssert();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
//		Actions actions = new Actions(driver);

		// Click add New Course
		FCC_CB.Add_New_FCC_Course.click();
		Thread.sleep(4000);
		// Add Course Title
		FCC_CB.Course_Title_Input.clear();
		FCC_CB.Course_Title_Input.sendKeys(N_Course);
		Thread.sleep(1000);
		FCC_CB.Course_Page.click();
		Thread.sleep(1000);

		FCC_CB.Course_Builder_Tab.click();
		Thread.sleep(3000);
		FCC_CB.AddNewSection.click();
		FCC_CB.Add_Section_name.clear();
		FCC_CB.Add_Section_name.sendKeys(N_Section);
		FCC_CB.Add_Button_For_Section.click();

		// Your section has successfully been updated!!
		Thread.sleep(1000);
		softAssert.assertTrue(FCC_CB.FindAddedContent(N_Section) > 0, "New Section is not getting added to Builder");
		Thread.sleep(1000);
		/**
		 * Video Progression Lesson
		 */
		String Video_Lesson = N_lesson + " : Video";
		FCC_CB.AddNewLesson.click();
		FCC_CB.Title_Input.clear();
		FCC_CB.Title_Input.sendKeys(Video_Lesson);

		FCC_CB.Video_Progression.click();
		FCC_CB.Video_URL.clear();
		FCC_CB.Video_URL.sendKeys("https://www.youtube.com/embed/4Fu_gXdOMWM"); // https://youtu.be/4Fu_gXdOMWM
		FCC_CB.Display_Timing_AFTER.click();
		FCC_CB.Lesson_Auto_Complete.click();
		FCC_CB.Completion_delay.sendKeys("10");
		FCC_CB.Mark_Complete_Button.click();
		FCC_CB.Autostart.click();
		FCC_CB.Video_Controls_Display.click();
		FCC_CB.Video_Unfocused.click();
		FCC_CB.Video_Resume.click();

		FCC_CB.LessonTagAccordion.click();
		FCC_CB.Lesson_SearchTag.clear();
		FCC_CB.Lesson_SearchTag.sendKeys("LT01");
		FCC_CB.SelectTag("LT01");
		FCC_CB.LessonTagAccordion.click();

		FCC_CB.LessonCategoryAccordion.click();
		FCC_CB.SelectCategory("LC 01");
		FCC_CB.LessonCategoryAccordion.click();
		
		Thread.sleep(1000);
		
		FCC_CB.Settings_Tab.click();
		FCC_CB.SampleLesson.click();
		FCC_CB.Immediately.click();

		FCC_CB.publish.click();
		Thread.sleep(5000);
		softAssert.assertTrue(FCC_CB.FindAddedContent(Video_Lesson) > 0, "New Lesson is not getting added to Builder");
		softAssert.assertTrue(FCC_CB.LessonPublished.size() > 0, "New Lesson is Not Published");

		/**
		 * Assignment Upload Lesson
		 */
		String Assignment_Lesson = N_lesson + " : Assignment";
		FCC_CB.AddNewLesson.click();
		FCC_CB.Title_Input.clear();
		FCC_CB.Title_Input.sendKeys(Assignment_Lesson);

		FCC_CB.Assignment_Upload.click();
		FCC_CB.File_Extensions.clear();
		FCC_CB.File_Extensions.sendKeys("PDF, CSV, XLS");
		FCC_CB.File_Size.clear();
		FCC_CB.File_Size.sendKeys("5MB");
		FCC_CB.Points_Switch.click();
		FCC_CB.Points.clear();
		FCC_CB.Points.sendKeys("10");
		FCC_CB.Manual_Grading.click();
		FCC_CB.Number_Of_Files.clear();
		FCC_CB.Number_Of_Files.sendKeys("3");
		FCC_CB.Allow_File_Deletion.click();
		
		Thread.sleep(1000);
		FCC_CB.Settings_Tab.click();
		FCC_CB.Enrollment_based.click();
		FCC_CB.Enrollment_Days.clear();
		FCC_CB.Enrollment_Days.sendKeys("10");
		FCC_CB.publish.click();
		Thread.sleep(5000);
		softAssert.assertTrue(FCC_CB.FindAddedContent(Assignment_Lesson) > 0,
				"New Lesson is not getting added to Builder");
		softAssert.assertTrue(FCC_CB.LessonPublished.size() > 0, "New Lesson is Not Published");

		/**
		 * Timer Lesson
		 */
		String Timer_Lesson = N_lesson + " : Timer";
		FCC_CB.AddNewLesson.click();
		FCC_CB.Title_Input.clear();
		FCC_CB.Title_Input.sendKeys(Timer_Lesson);
		FCC_CB.Timer.click();
		FCC_CB.Hours.clear();
		FCC_CB.Hours.sendKeys("01"); // https://youtu.be/4Fu_gXdOMWM
		FCC_CB.Minutes.clear();
		FCC_CB.Minutes.sendKeys("02");
		FCC_CB.Seconds.clear();
		FCC_CB.Seconds.sendKeys("03");

		Thread.sleep(1000);
		FCC_CB.Settings_Tab.click();
		FCC_CB.Specific_Date.click();
		
		FCC_CB.Specific_Date_Month_Select.click();
		FCC_CB.Specific_Date_Month("Jan").click();
		Thread.sleep(500);
		FCC_CB.Specific_Date_Date.clear();
		FCC_CB.Specific_Date_Date.sendKeys("12");
		FCC_CB.Specific_Date_Year.clear();
		FCC_CB.Specific_Date_Year.sendKeys("2024");
		FCC_CB.Specific_Date_Hour.clear();
		FCC_CB.Specific_Date_Hour.sendKeys("11");
		FCC_CB.Specific_Date_Minute.clear();
		FCC_CB.Specific_Date_Minute.sendKeys("30");

		FCC_CB.publish.click();
		Thread.sleep(5000);
		softAssert.assertTrue(FCC_CB.FindAddedContent(Timer_Lesson) > 0, "New Lesson is not getting added to Builder");
		softAssert.assertTrue(FCC_CB.LessonPublished.size() > 0, "New Lesson is Not Published");
		Thread.sleep(1000);

		/**
		 * Expannd all Content
		 */
		FCC_CB.ExpandAll.click();

		/**
		 * Add Topic - Video Progression
		 */

		String Video_Topic = N_topic + " : Video";
		FCC_CB.AddNewTopic.click();
		FCC_CB.Title_Input.clear();
		FCC_CB.Title_Input.sendKeys(Video_Topic);

		FCC_CB.Video_Progression.click();
		FCC_CB.Video_URL.clear();
		FCC_CB.Video_URL.sendKeys("https://www.youtube.com/embed/4Fu_gXdOMWM"); // https://youtu.be/4Fu_gXdOMWM
		FCC_CB.Display_Timing_AFTER.click();
		FCC_CB.Topic_Auto_Complete.click();
		FCC_CB.Completion_delay.sendKeys("10");
		FCC_CB.Mark_Complete_Button.click();
		FCC_CB.Autostart.click();
		FCC_CB.Video_Controls_Display.click();
		FCC_CB.Video_Unfocused.click();
		FCC_CB.Video_Resume.click();

		FCC_CB.TopicTagAccordion.click();
		FCC_CB.Topic_SearchTag.clear();
		FCC_CB.Topic_SearchTag.sendKeys("TT 01");
		FCC_CB.SelectTag("TT 01");
		FCC_CB.TopicTagAccordion.click();

		FCC_CB.TopicCategoryAccordion.click();
		FCC_CB.SelectCategory("TC 01");
		FCC_CB.TopicCategoryAccordion.click();
		 
		Thread.sleep(500);
		FCC_CB.Settings_Tab.click();
		FCC_CB.Immediately.click();

		FCC_CB.publish.click();
		Thread.sleep(5000);
		softAssert.assertTrue(FCC_CB.FindAddedContent(Video_Topic) > 0, "New Topic is not getting added to Builder");
		softAssert.assertTrue(FCC_CB.TopicPublished.size() > 0, "New Topic is Not Published");

		/**
		 * Add Topic - Assignment Upload
		 */
		String Assignment_Topic = N_topic + " : Assignment";
		FCC_CB.AddNewTopic.click();
		FCC_CB.Title_Input.clear();
		FCC_CB.Title_Input.sendKeys(Assignment_Topic);

		FCC_CB.Assignment_Upload.click();
		FCC_CB.File_Extensions.clear();
		FCC_CB.File_Extensions.sendKeys("PDF, CSV, XLS");
		FCC_CB.File_Size.clear();
		FCC_CB.File_Size.sendKeys("5MB");
		FCC_CB.Points_Switch.click();
		FCC_CB.Points.clear();
		FCC_CB.Points.sendKeys("10");
		FCC_CB.Manual_Grading.click();
		FCC_CB.Number_Of_Files.clear();
		FCC_CB.Number_Of_Files.sendKeys("3");
		FCC_CB.Allow_File_Deletion.click();
		
		Thread.sleep(1000);
		FCC_CB.Settings_Tab.click();
		FCC_CB.Enrollment_based.click();
		FCC_CB.Enrollment_Days.clear();
		FCC_CB.Enrollment_Days.sendKeys("10");
		
		FCC_CB.publish.click();
		Thread.sleep(5000);
		softAssert.assertTrue(FCC_CB.FindAddedContent(Assignment_Topic) > 0,
				"New Topic is not getting added to Builder");
		softAssert.assertTrue(FCC_CB.TopicPublished.size() > 0, "New Topic is Not Published");

		/**
		 * Add Topic - Timer
		 */
		String Timer_Topic = N_topic + " : Timer";
		FCC_CB.AddNewTopic.click();
		FCC_CB.Title_Input.clear();
		FCC_CB.Title_Input.sendKeys(Timer_Topic);
		FCC_CB.Timer.click();
		FCC_CB.Hours.clear();
		FCC_CB.Hours.sendKeys("01"); // https://youtu.be/4Fu_gXdOMWM
		FCC_CB.Minutes.clear();
		FCC_CB.Minutes.sendKeys("02");
		FCC_CB.Seconds.clear();
		FCC_CB.Seconds.sendKeys("03");
		
		Thread.sleep(1000);
		FCC_CB.Settings_Tab.click();
		FCC_CB.Specific_Date.click();
		
		FCC_CB.Specific_Date_Month_Select.click();
		FCC_CB.Specific_Date_Month("Jan").click();
		Thread.sleep(500);
		FCC_CB.Specific_Date_Date.clear();
		FCC_CB.Specific_Date_Date.sendKeys("12");
		FCC_CB.Specific_Date_Year.clear();
		FCC_CB.Specific_Date_Year.sendKeys("2024");
		FCC_CB.Specific_Date_Hour.clear();
		FCC_CB.Specific_Date_Hour.sendKeys("11");
		FCC_CB.Specific_Date_Minute.clear();
		FCC_CB.Specific_Date_Minute.sendKeys("30");

		FCC_CB.publish.click();
		Thread.sleep(5000);
		softAssert.assertTrue(FCC_CB.FindAddedContent(Timer_Topic) > 0, "New Topic is not getting added to Builder");
		softAssert.assertTrue(FCC_CB.TopicPublished.size() > 0, "New Topic is Not Published");
		Thread.sleep(1000);

		// Click Published
		// actions.moveToElement(FCC_CB.Course_CoursePage_Tab).build().perform();
		executor.executeScript("arguments[0].scrollIntoView();", FCC_CB.Course_CoursePage_Tab);
		FCC_CB.Course_CoursePage_Tab.click();
		FCC_CB.Course_Title_Input.clear();
		FCC_CB.Course_Title_Input.sendKeys(N_Course);
		Thread.sleep(1000);
		FCC_CB.Course_Page.click();
		Thread.sleep(2000);
		// FCC_CB.Course_Publish_Button.click()
		executor.executeScript("arguments[0].scrollIntoView();", FCC_CB.Course_Publish_Button);
		executor.executeScript("arguments[0].click();", FCC_CB.Course_Publish_Button);
		Thread.sleep(15000);
		softAssert.assertTrue(FCC_CB.Course_Published_Text.size() == 1, "Course Not Published");

		softAssert.assertAll();
	}

}
