package LD;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageClasses.FCC_Settings;
import pageClasses.LD_Quiz_Builder_POM;
import pageClasses.OverviewSettings;
import setUp.projectSetUp;

public class LD_Create_Quiz {
	
	WebDriver driver;
	LD_Quiz_Builder_POM LD_QB;
	OverviewSettings OS_OB;
	FCC_Settings FCCS_OB;
	String baseURL;
	String adminU;
	String adminP;
	String IRU;
	String IRP;
	String CourseTitle = "IR_Automation_LD_Course";
	String LessonTitle = "IR_Automation_Lesson 1";
	String TopicTitle = "IR_Automation_LD_Topic";
	String QuizTitle = "IR_Automation_LD_Quiz";

	@Parameters({ "siteURL", "username", "password", "Instructor1", "Instructor1Password" })
	@BeforeClass
	public void DriverSetUp(String siteURL, String username, String password, String InstructorU, String InstructorP) 
			throws Exception {
		driver = projectSetUp.driver;

		// Initializing Overview Settings Object
		OS_OB = new OverviewSettings(driver);

		// Initializing LD_Lesson Page Object
		LD_QB = new LD_Quiz_Builder_POM(driver);

		// Setting User Details
		baseURL = siteURL;
		adminU = username;
		adminP = password;
		IRU = InstructorU;
		IRP = InstructorP;
	
	}
	
	@Test(priority = 1)
	public void Create_LD_New_Quiz() throws Exception {
		
		// Instructor Login
		OS_OB.loginToDashboard(driver, baseURL, IRU, IRP);

		// Visit_Profile_Tab in Settings
		LD_QB.Visit_Quiz_List(baseURL);
		SoftAssert softAssert = new SoftAssert();
		driver.get(baseURL + "wp-admin/edit.php?post_type=sfwd-quiz");
		
		LD_QB.Add_New_LD_Quiz.click();
		Thread.sleep(2000);

		LD_QB.LD_Quiz_Title_Input.sendKeys(QuizTitle);
		LD_QB.LD_Quiz_Content.sendKeys("This is Quiz Content");
		
		LD_QB.LD_Quiz_Settings_Tab.click();
		
		/*****Quiz Access Settings*****/
		
		//Associate Course
		LD_QB.LD_Quiz_Associated_Course.click();
		LD_QB.LD_Search_Quiz_Associated_Course.sendKeys(CourseTitle);
		LD_QB.LD_SelectSearched_Quiz_Associated_Course(CourseTitle).click();
		Thread.sleep(2000);
		
		//Associate Lesson/Topic
		LD_QB.LD_Quiz_Associated_Lesson.click();
		LD_QB.LD_Search_Quiz_Associated_Lesson.sendKeys(LessonTitle);
		LD_QB.LD_SelectSearched_Quiz_Associated_Lesson(LessonTitle).click();
		
		//Quiz Release Schedule
		LD_QB.LD_Quiz_Enrollment_Based.click();
		LD_QB.LD_Quiz_Enrollment_Based_days.sendKeys("30");
		
		//Quiz Prerequisites
		LD_QB.LD_Quiz_Prerequisite.click();
		LD_QB.LD_Quiz_Prerequisite.sendKeys("Inst q1");
		LD_QB.LD_SelectSearched_Quiz_Prerequisite("Inst q1").click();
		
		//Allowed Users
		LD_QB.LD_Quiz_Allow_Users.click();
		
		/*****Progression and Restriction Settings*****/
		
		//Passing Score
		Thread.sleep(500);
		LD_QB.LD_Quiz_Passing_Score.clear();
		LD_QB.LD_Quiz_Passing_Score.sendKeys("75");
		
		//Quiz Certificate
		LD_QB.LD_QuizCertificate.click();
		LD_QB.LD_SearchQuizCertificate.sendKeys("Quiz Certificate 2");
		LD_QB.LD_SelectSearchedQuizCertificate("Quiz Certificate 2").click();
		
		//Enabling Quiz Saving
		LD_QB.LD_Quiz_EnableQuizSaving.click();
		LD_QB.LD_Quiz_SaveQuizAfter.clear();
		LD_QB.LD_Quiz_SaveQuizAfter.sendKeys("30");
		
		//Restrict Quiz Retakes
		LD_QB.LD_Quiz_RestrictQuizRetake.click();
		LD_QB.LD_Quiz_NumberofRetries.sendKeys("2");
		LD_QB.LD_Quiz_RetriesApplicabletoDropdown.click();
		LD_QB.LD_SelectSearchedRetriesOption("Registered users only").click();
		
		//Question Completion
		LD_QB.LD_Quiz_QuestionCompletion.click();
		
		//Time Limit
		LD_QB.LD_Quiz_TimeLimit.click();
		LD_QB.LD_QLT_Hours.sendKeys("01");
		LD_QB.LD_QLT_Minutes.sendKeys("30");
		LD_QB.LD_QLT_Seconds.sendKeys("00");
		
		/*****Display and Content Option*****/
		
		//Quiz Material
		LD_QB.LD_Quiz_Material.click();
		LD_QB.LD_Quiz_MaterialArea.sendKeys("This is Quiz Material");
		
		//AutoStart
		LD_QB.LD_Topic_AutoStart.click();
		
		//Question Display
		LD_QB.LD_Question_Display.click();
		LD_QB.LD_One_Question_At_Once.click();
		LD_QB.LD_DisplayResultatEndOnly.click();
		LD_QB.LD_DisplayBackButton.click();
		LD_QB.LD_DisplayResultaftersumbittion.click();
		
		//Question Overview Table
		LD_QB.LD_Overview_Table.click();
		LD_QB.LD_Quiz_Summary.click();
		LD_QB.LD_Skip_Question.click();
		
		//Custom Question Ordering
		LD_QB.LD_Custom_Question_Ordering.click();
		Thread.sleep(1000);
		LD_QB.LD_Sort_By_Category.click();
		LD_QB.LD_Randomize_Order.click();
		LD_QB.LD_Display_all_Questions.click();
		
		//Additional Question Options
		LD_QB.LD_Additional_Question_Options.click();
		LD_QB.LD_Point_Value.click();
		LD_QB.LD_Question_Category.click();
		LD_QB.LD_Question_Position.click();
		LD_QB.LD_Question_Numbering.click();
		LD_QB.LD_Number_Answers.click();
		LD_QB.LD_Randomize_Answers.click();
		
		//Question Title
		LD_QB.LD_Quiz_Title.click();
		
		/*****Results Page Display*****/
		
		//Result Messages
		LD_QB.LD_Result_Messages.click();
		Thread.sleep(1000);
		
		//Restart Quiz Button
		LD_QB.LD_Restart_Quiz_Button.click();
		
		//Custom Results Display
		//LD_QB.LD_Custom_Results_Display.click();			// Default Enabled
		LD_QB.LD_Average_Score.click();
		LD_QB.LD_Category_Score.click();
		//LD_QB.LD_Overall_Score.click();					// Default Enabled
		//LD_QB.LD_No_of_Correct_Answers.click();			// Default Enabled
		//LD_QB.LD_Time_Spent.click();						// Default Enabled
		
		//Custom Answer FeedBack
		LD_QB.LD_Custom_Answers_FeedBack.click();		//By clicking the Custom Answers Feedback it will disable it as Default Enabled
		//LD_QB.LD_Correct_Incorrect_Messages.click();
		//LD_QB.LD_Correct_Incorrect_Answers_Marks.click();
		//LD_QB.LD_View_Question_Button.click();
		
		//Publish Quiz
		LD_QB.LD_Quiz_Publish_Button.click();
		Thread.sleep(1000);
		LD_QB.LD_Quiz_Publish_Button2.click();
		Thread.sleep(2500);
		softAssert.assertTrue(LD_QB.Quiz_Live_Text.size() == 1, "Quiz Not Published");
		
		LD_QB.Visit_Quiz_List(baseURL);
			
		//Confirm if the created new Quiz is added to Quiz list
		LD_QB.LD_Search_Quiz.sendKeys(QuizTitle);
		LD_QB.LD_Search_Quiz_Button.click();
		Thread.sleep(1500);
						
		softAssert.assertTrue(LD_QB.LD_QuizList(QuizTitle).size() == 1, "Quiz Not Present in the Quiz List");
		
		softAssert.assertAll();		
			
		
	}
	
}
