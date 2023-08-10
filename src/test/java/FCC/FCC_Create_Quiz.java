package FCC;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageClasses.FCC_Quiz;
import pageClasses.OverviewSettings;

import setUp.projectSetUp;

public class FCC_Create_Quiz {

	WebDriver driver;
	OverviewSettings OS_OB;
	FCC_Quiz FCC_Quiz;
	String baseURL;
	String adminU;
	String adminP;
	String IRU;
	String IRP;
	String QuizTitle = "Automation Quiz";

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

		// Initializing FCC_Quiz Page Object
		FCC_Quiz = new FCC_Quiz(driver);

		// Setting User Details
		baseURL = siteURL;
		adminU = username;
		adminP = password;
		IRU = InstructorU;
		IRP = InstructorP;

		// Admin Login
		OS_OB.loginToDashboard(driver, baseURL, InstructorU, InstructorP);
	}

	/**
	 * Create New Quiz Via FCC
	 * 
	 * @throws Exception
	 */
	@Test(priority = 1)
	public void Create_New_Quiz() throws Exception {
		SoftAssert softAssert = new SoftAssert();
		JavascriptExecutor executor = (JavascriptExecutor) driver;

		FCC_Quiz.Visit_Quiz_List(baseURL);

		FCC_Quiz.Add_New_FCC_Quiz.click();
		Thread.sleep(1000);

		// Quiz Page
		FCC_Quiz.Quiz_Title_Input.clear();
		FCC_Quiz.Quiz_Title_Input.sendKeys(QuizTitle);
		FCC_Quiz.Quiz_Page.click();
		Thread.sleep(1000);

		// Select Tag
		FCC_Quiz.TagAccordion.click();
		FCC_Quiz.SearchTag.clear();
		FCC_Quiz.SearchTag.sendKeys("Science");
		FCC_Quiz.SelectTag("Science").click();
		Thread.sleep(1000);
		FCC_Quiz.TagAccordion.click();
		Thread.sleep(1000);
		// Select Category
		FCC_Quiz.CategoryAccordion.click();
		FCC_Quiz.SelectCategory("Quiz Cat 01").click();
		FCC_Quiz.SelectCategory("Quiz Cat Child 01").click();
		Thread.sleep(1000);

		// Visit Settings Tab
		executor.executeScript("arguments[0].scrollIntoView();", FCC_Quiz.Quiz_Settings_Tab);
		executor.executeScript("arguments[0].click();", FCC_Quiz.Quiz_Settings_Tab);

//		FCC_Quiz.Quiz_Settings_Tab.click();

		/**
		 *  Quiz Access Settings
		 */
		FCC_Quiz.Quiz_access_settings.click();
		FCC_Quiz.Enrollment_based.click();
		FCC_Quiz.Enrollment_Days.clear();
		FCC_Quiz.Enrollment_Days.sendKeys("10");
		FCC_Quiz.Quiz_prerequisites.click();
		FCC_Quiz.SelectPreQuiz("Biology Quiz By IR").click();
		FCC_Quiz.prerequisites.click();
		FCC_Quiz.Allowed_users.click();
		Thread.sleep(1000);

		/**
		 *  Progression and restriction settings
		 */
		FCC_Quiz.Progression_and_restriction_settings.click();
		FCC_Quiz.Passing_score.clear();
		FCC_Quiz.Passing_score.sendKeys("40");
		FCC_Quiz.Certificate_Select.click();
		FCC_Quiz.SelectCertificate("Quiz Certificate").click();
		FCC_Quiz.Certificate_awarded_for.clear();
		FCC_Quiz.Certificate_awarded_for.sendKeys("60");
		FCC_Quiz.Enable_Quiz_Saving.click();
		FCC_Quiz.Quiz_Saving_Second.clear();
		FCC_Quiz.Quiz_Saving_Second.sendKeys("15");
		FCC_Quiz.Restrict_quiz_retakes.click();
		FCC_Quiz.Quiz_Retakes.clear();
		FCC_Quiz.Quiz_Retakes.sendKeys("3");
		FCC_Quiz.Retries_Applicable_To.click();
		FCC_Quiz.Select_Retries_Applicable_To("All Users").click();
		FCC_Quiz.Question_Completion.click();
		FCC_Quiz.Time_limit.click();
		FCC_Quiz.Time_limit_HH.clear();
		FCC_Quiz.Time_limit_HH.sendKeys("01");
		FCC_Quiz.Time_limit_MM.clear();
		FCC_Quiz.Time_limit_MM.sendKeys("15");
		FCC_Quiz.Time_limit_SS.clear();
		FCC_Quiz.Time_limit_SS.sendKeys("30");
		Thread.sleep(1000);

		/**
		 *  Display and Content Options
		 */
		FCC_Quiz.Quiz_material.click();
		FCC_Quiz.Auto_start.click();
		FCC_Quiz.Question_display_Select.click();
		FCC_Quiz.Select_Question_display("One question at a time").click();
		FCC_Quiz.Display_Back_Button.click();
		FCC_Quiz.Display_Result_After_Each_Que.click();
		FCC_Quiz.Question_Overview_Table.click();
		FCC_Quiz.Quiz_summary.click();
		FCC_Quiz.Skip_Question.click();
		FCC_Quiz.Custom_question_ordering.click();
		FCC_Quiz.Sort_by_category.click();
		FCC_Quiz.Randomize_order.click();
		FCC_Quiz.Additional_question_options.click();
		FCC_Quiz.Point_value.click();
		FCC_Quiz.Question_category.click();
		FCC_Quiz.Question_position.click();
		FCC_Quiz.Question_numbering.click();
		FCC_Quiz.Number_Answers.click();
		FCC_Quiz.Randomize_answers.click();
		FCC_Quiz.Quiz_title_Toggle.click();

		/**
		 *  Result page Display
		 */
		FCC_Quiz.Result_Message.click();
		FCC_Quiz.Restart_quiz_button.click();
		if (FCC_Quiz.Custom_results_Checked.size() == 0) {
			FCC_Quiz.Custom_results_display.click();
		}
		FCC_Quiz.Average_score.click();
		FCC_Quiz.Category_score.click();
		FCC_Quiz.Overall_score.click();
		FCC_Quiz.No_Of_Correct_Answers.click();
		FCC_Quiz.Time_spent.click();
		if (FCC_Quiz.Custom_answer_feedback_Checked.size() > 0) {
			FCC_Quiz.View_question_button.click();
			FCC_Quiz.Correct_Incorrect_Marks.click();
			FCC_Quiz.Correct_Incorrect_Messages.click();
			FCC_Quiz.Custom_answer_feedback.click();
		}

		/**
		 * Administrative and data handling
		 */
		FCC_Quiz.Administrative_and_data_handling.click();
		
		FCC_Quiz.Quiz_Publish_Button.click();
		Thread.sleep(10000);
		softAssert.assertTrue(FCC_Quiz.Quiz_Published_Text.size() > 0, "Quiz Is Not getting published");

	}

}
