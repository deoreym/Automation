package FCC;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.interactions.Actions;

import pageClasses.FCC_Questions;
import pageClasses.FCC_Quiz;
import pageClasses.OverviewSettings;

import setUp.projectSetUp;

public class FCC_Create_Questions {

	WebDriver driver;
	OverviewSettings OS_OB;
	FCC_Quiz FCC_Quiz;
	FCC_Questions Question;
	String baseURL;
	String adminU;
	String adminP;
	String IRU;
	String IRP;
	String QuizTitle = "IR_Automation Quiz";
	Actions actions;

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
		Question = new FCC_Questions(driver);
		actions = new Actions(driver);

		// Setting User Details
		baseURL = siteURL;
		adminU = username;
		adminP = password;
		IRU = InstructorU;
		IRP = InstructorP;

		// Admin Login
		OS_OB.loginToDashboard(driver, baseURL, InstructorU, InstructorP);
		// Visit Quiz Listing
		FCC_Quiz.Visit_Quiz_List(baseURL);

		actions.moveToElement(Question.QuizEdit(QuizTitle)).build().perform();
		Question.FQB_QuizEdit(QuizTitle).click();
	}

	/**
	 * Create Single Choice Question
	 * 
	 * @throws Exception
	 */
	@Test(priority = 1)
	public void Create_New_Single_Choice_Question() throws Exception {
		SoftAssert softAssert = new SoftAssert();
		driver.navigate().refresh();
		Thread.sleep(1500);
		actions.moveToElement(FCC_Quiz.Quiz_Builder_Tab).build().perform();
		FCC_Quiz.Quiz_Builder_Tab.click();
		Thread.sleep(500);
		Question.Add_New_Question.click();
		Question.Question_Title_Input.clear();
		Question.Question_Title_Input.sendKeys("IR_Automation : Single Choice");
		Question.Question_Type.click();
		Question.Select_Question_Type("Single Choice");

		Question.points.clear();
		Question.points.sendKeys("5");

		Question.HintSwitch.click();
		Question.HintInput.sendKeys("This is Hint: Answer is 2");

		// Switch to the iframe
		driver.switchTo().frame(Question.QuestionTextIframe);
		Thread.sleep(1000);
		// Clear existing content (optional) and Type in content
		Question.editor.clear();
		Question.editor.sendKeys("This is Single Choice Question 1 + 1 = ?");

		// Switch back to the main frame (outside the iframe)
		driver.switchTo().defaultContent();

		Question.Answer_Tab.click();
		Thread.sleep(2000);

		Question.Add_New_Answer.click();
		Question.AnswerText.clear();
		Question.AnswerText.sendKeys("11");
		Question.SaveAnswer.click();

		Thread.sleep(1000);
		Question.Add_New_Answer.click();
		Question.AnswerText.clear();
		Question.AnswerText.sendKeys("2");
		Question.CorrectAnswer.click();
		Question.SaveAnswer.click();

		Thread.sleep(1000);
		Question.Add_New_Answer.click();
		Question.AnswerText.clear();
		Question.AnswerText.sendKeys("21");
		Question.SaveAnswer.click();

		Thread.sleep(1000);
		Question.Question_Publish_Button.click();

		Thread.sleep(5000);
		// Check Published Modal
		softAssert.assertTrue(Question.Question_Published_Text.size() > 0, "Question is not getting created");
		FCC_Quiz.Quiz_Publish_Button.click();
		Thread.sleep(5000);
		softAssert.assertTrue(FCC_Quiz.Quiz_Updated_Text.size() > 0, "Quiz Is Not Getting Updated");
		softAssert.assertAll();

	}

	/**
	 * Create Multiple Choice Question
	 * 
	 * @throws Exception
	 */
	@Test(priority = 2)
	public void Create_New_Multiple_Choice_Question() throws Exception {
		SoftAssert softAssert = new SoftAssert();
		driver.navigate().refresh();
		Thread.sleep(1500);
		actions.moveToElement(FCC_Quiz.Quiz_Builder_Tab).build().perform();
		FCC_Quiz.Quiz_Builder_Tab.click();
		Thread.sleep(500);
		Question.Add_New_Question.click();
		Question.Question_Title_Input.clear();
		Question.Question_Title_Input.sendKeys("IR_Automation : Multiple Choice");
		Question.Question_Type.click();
		Question.Select_Question_Type("Multiple Choice");

		Question.points.clear();
		Question.points.sendKeys("5");

		Question.HintSwitch.click();
		Question.HintInput.sendKeys("This is Hint: 2, 4, 6, . .");

		// Switch to the iframe
		driver.switchTo().frame(Question.QuestionTextIframe);
		Thread.sleep(1000);
		// Clear existing content (optional) and Type in content
		Question.editor.clear();
		Question.editor.sendKeys("This is Multiple Choice Question : Select Even Numbers..");

		// Switch back to the main frame (outside the iframe)
		driver.switchTo().defaultContent();

		Question.Answer_Tab.click();
		Thread.sleep(2000);

		Question.Add_New_Answer.click();
		Question.AnswerText.clear();
		Question.AnswerText.sendKeys("11");
		Question.SaveAnswer.click();

		Thread.sleep(1000);
		Question.Add_New_Answer.click();
		Question.AnswerText.clear();
		Question.AnswerText.sendKeys("2");
		Question.CorrectAnswer.click();
		Question.SaveAnswer.click();

		Thread.sleep(1000);
		Question.Add_New_Answer.click();
		Question.AnswerText.clear();
		Question.AnswerText.sendKeys("24");
		Question.CorrectAnswer.click();
		Question.SaveAnswer.click();

		Thread.sleep(1000);
		Question.Add_New_Answer.click();
		Question.AnswerText.clear();
		Question.AnswerText.sendKeys("33");
		Question.SaveAnswer.click();

		Thread.sleep(1000);
		Question.Question_Publish_Button.click();

		Thread.sleep(5000);
		// Check Published Modal
		softAssert.assertTrue(Question.Question_Published_Text.size() > 0, "Question is not getting created");
		FCC_Quiz.Quiz_Publish_Button.click();
		Thread.sleep(5000);
		softAssert.assertTrue(FCC_Quiz.Quiz_Updated_Text.size() > 0, "Quiz Is Not Getting Updated");
		softAssert.assertAll();

	}

	/**
	 * Create Free Choice Question
	 * 
	 * @throws Exception
	 */
	@Test(priority = 3)
	public void Create_New_Free_Choice_Question() throws Exception {
		SoftAssert softAssert = new SoftAssert();
		driver.navigate().refresh();
		Thread.sleep(1500);
		actions.moveToElement(FCC_Quiz.Quiz_Builder_Tab).build().perform();
		FCC_Quiz.Quiz_Builder_Tab.click();
		Thread.sleep(500);
		Question.Add_New_Question.click();
		Question.Question_Title_Input.clear();
		Question.Question_Title_Input.sendKeys("IR_Automation : Free Choice");
		Question.Question_Type.click();
		Question.Select_Question_Type("Free Choice");

		Question.points.clear();
		Question.points.sendKeys("5");

		Question.HintSwitch.click();
		Question.HintInput.sendKeys("This is Hint: Awesome");

		// Switch to the iframe
		driver.switchTo().frame(Question.QuestionTextIframe);
		Thread.sleep(1000);
		// Clear existing content (optional) and Type in content
		Question.editor.clear();
		Question.editor.sendKeys("This is Free Choice Question : WisdmLabs is ....?");

		// Switch back to the main frame (outside the iframe)
		driver.switchTo().defaultContent();

		Question.Answer_Tab.click();
		Thread.sleep(2000);

		String Que = "Awesome" + "/n" + "Good";
		Question.FreeAnswer.sendKeys(Que);

		Thread.sleep(1000);
		Question.Question_Publish_Button.click();

		Thread.sleep(5000);
		// Check Published Modal
		softAssert.assertTrue(Question.Question_Published_Text.size() > 0, "Question is not getting created");
		FCC_Quiz.Quiz_Publish_Button.click();
		Thread.sleep(5000);
		softAssert.assertTrue(FCC_Quiz.Quiz_Updated_Text.size() > 0, "Quiz Is Not Getting Updated");
		softAssert.assertAll();

	}

	/**
	 * Create Matrix Sorting Choice Question
	 * 
	 * @throws Exception
	 */
	@Test(priority = 4)
	public void Create_New_Matrix_Sorting_Choice_Question() throws Exception {
		SoftAssert softAssert = new SoftAssert();
		driver.navigate().refresh();
		Thread.sleep(1500);
		actions.moveToElement(FCC_Quiz.Quiz_Builder_Tab).build().perform();
		FCC_Quiz.Quiz_Builder_Tab.click();
		Thread.sleep(500);
		Question.Add_New_Question.click();
		Question.Question_Title_Input.clear();
		Question.Question_Title_Input.sendKeys("IR_Automation : Matrix Sorting Choice");
		Question.Question_Type.click();
		Question.Select_Question_Type("Matrix Sorting Choice");

		Question.points.clear();
		Question.points.sendKeys("5");

		// Switch to the iframe
		driver.switchTo().frame(Question.QuestionTextIframe);
		Thread.sleep(1000);
		// Clear existing content (optional) and Type in content
		Question.editor.clear();
		Question.editor.sendKeys("This is Matrix Sorting Choice : Match the following.");

		// Switch back to the main frame (outside the iframe)
		driver.switchTo().defaultContent();

		Question.Answer_Tab.click();
		Thread.sleep(2000);

		Question.MatrixWidth.sendKeys("30");

		Question.Add_New_Answer.click();
		Question.Criterion.clear();
		Question.Criterion.sendKeys("A");
		Question.Sort_Elements.clear();
		Question.Sort_Elements.sendKeys("a");
		Question.SaveAnswer.click();

		Thread.sleep(1000);
		Question.Add_New_Answer.click();
		Question.Criterion.clear();
		Question.Criterion.sendKeys("B");
		Question.Sort_Elements.clear();
		Question.Sort_Elements.sendKeys("b");
		Question.SaveAnswer.click();

		Thread.sleep(1000);
		Question.Add_New_Answer.click();
		Question.Criterion.clear();
		Question.Criterion.sendKeys("C");
		Question.Sort_Elements.clear();
		Question.Sort_Elements.sendKeys("c");
		Question.SaveAnswer.click();

		Thread.sleep(1000);
		Question.Question_Publish_Button.click();

		Thread.sleep(5000);
		// Check Published Modal
		softAssert.assertTrue(Question.Question_Published_Text.size() > 0, "Question is not getting created");
		FCC_Quiz.Quiz_Publish_Button.click();
		Thread.sleep(5000);
		softAssert.assertTrue(FCC_Quiz.Quiz_Updated_Text.size() > 0, "Quiz Is Not Getting Updated");
		softAssert.assertAll();

	}

	/**
	 * Create Sorting Choice Question
	 * 
	 * @throws Exception
	 */
	@Test(priority = 5)
	public void Create_New_Sorting_Choice_Question() throws Exception {
		SoftAssert softAssert = new SoftAssert();
		driver.navigate().refresh();
		Thread.sleep(1500);
		actions.moveToElement(FCC_Quiz.Quiz_Builder_Tab).build().perform();
		FCC_Quiz.Quiz_Builder_Tab.click();
		Thread.sleep(500);
		Question.Add_New_Question.click();
		Question.Question_Title_Input.clear();
		Question.Question_Title_Input.sendKeys("IR_Automation : Sorting Choice");
		Question.Question_Type.click();
		Question.Select_Question_Type("Sorting Choice");

		Question.points.clear();
		Question.points.sendKeys("5");

		Question.HintSwitch.click();
		Question.HintInput.sendKeys("This is Hint: A E I O U");

		// Switch to the iframe
		driver.switchTo().frame(Question.QuestionTextIframe);
		Thread.sleep(1000);
		// Clear existing content (optional) and Type in content
		Question.editor.clear();
		Question.editor.sendKeys("This is Sorting Choice Question : Sort Following Elements");

		// Switch back to the main frame (outside the iframe)
		driver.switchTo().defaultContent();

		Question.Answer_Tab.click();
		Thread.sleep(2000);

		Question.Add_New_Answer.click();
		Question.AnswerText.clear();
		Question.AnswerText.sendKeys("A");
		Question.SaveAnswer.click();

		Thread.sleep(1000);
		Question.Add_New_Answer.click();
		Question.AnswerText.clear();
		Question.AnswerText.sendKeys("E");
		Question.SaveAnswer.click();

		Thread.sleep(1000);
		Question.Add_New_Answer.click();
		Question.AnswerText.clear();
		Question.AnswerText.sendKeys("I");
		Question.SaveAnswer.click();

		Thread.sleep(1000);
		Question.Add_New_Answer.click();
		Question.AnswerText.clear();
		Question.AnswerText.sendKeys("O");
		Question.SaveAnswer.click();

		Thread.sleep(1000);
		Question.Add_New_Answer.click();
		Question.AnswerText.clear();
		Question.AnswerText.sendKeys("U");
		Question.SaveAnswer.click();

		Thread.sleep(1000);
		Question.Question_Publish_Button.click();

		Thread.sleep(5000);
		// Check Published Modal
		softAssert.assertTrue(Question.Question_Published_Text.size() > 0, "Question is not getting created");
		FCC_Quiz.Quiz_Publish_Button.click();
		Thread.sleep(5000);
		softAssert.assertTrue(FCC_Quiz.Quiz_Updated_Text.size() > 0, "Quiz Is Not Getting Updated");
		softAssert.assertAll();

	}

	/**
	 * Create Fill in the blanks Question
	 * 
	 * @throws Exception
	 */
	@Test(priority = 6)
	public void Create_New_Fill_in_the_blanks_Question() throws Exception {
		SoftAssert softAssert = new SoftAssert();
		driver.navigate().refresh();
		Thread.sleep(1500);
		actions.moveToElement(FCC_Quiz.Quiz_Builder_Tab).build().perform();
		FCC_Quiz.Quiz_Builder_Tab.click();
		Thread.sleep(500);
		Question.Add_New_Question.click();
		Question.Question_Title_Input.clear();
		Question.Question_Title_Input.sendKeys("IR_Automation : Fill in the blanks");
		Question.Question_Type.click();
		Question.Select_Question_Type("Fill in the blanks");

		Question.points.clear();
		Question.points.sendKeys("5");

		Question.HintSwitch.click();
		Question.HintInput.sendKeys("This is Hint: Play, Love, Hate");

		// Switch to the iframe
		driver.switchTo().frame(Question.QuestionTextIframe);
		Thread.sleep(1000);
		// Clear existing content (optional) and Type in content
		Question.editor.clear();
		Question.editor.sendKeys("This is Fill in the blanks Question: I {[play][love][hate]} soccer. ");

		// Switch back to the main frame (outside the iframe)
		driver.switchTo().defaultContent();

		Question.Answer_Tab.click();
		Thread.sleep(2000);

		// Switch to the iframe
		driver.switchTo().frame(Question.FillInTheBlanks);
		Thread.sleep(1000);
		// Clear existing content (optional) and Type in content
		Question.editor.clear();
		Question.editor.sendKeys("I {[play][love][hate]} soccer.");

		// Switch back to the main frame (outside the iframe)
		driver.switchTo().defaultContent();

		Thread.sleep(1000);
		Question.Question_Publish_Button.click();

		Thread.sleep(5000);
		// Check Published Modal
		softAssert.assertTrue(Question.Question_Published_Text.size() > 0, "Question is not getting created");
		FCC_Quiz.Quiz_Publish_Button.click();
		Thread.sleep(5000);
		softAssert.assertTrue(FCC_Quiz.Quiz_Updated_Text.size() > 0, "Quiz Is Not Getting Updated");
		softAssert.assertAll();

	}

	/**
	 * Create Assessment Question
	 * 
	 * @throws Exception
	 */
	@Test(priority = 7)
	public void Create_New_Assessment_Question() throws Exception {
		SoftAssert softAssert = new SoftAssert();
		driver.navigate().refresh();
		Thread.sleep(1500);
		actions.moveToElement(FCC_Quiz.Quiz_Builder_Tab).build().perform();
		FCC_Quiz.Quiz_Builder_Tab.click();
		Thread.sleep(500);
		Question.Add_New_Question.click();
		Question.Question_Title_Input.clear();
		Question.Question_Title_Input.sendKeys("IR_Automation : Assessment");
		Question.Question_Type.click();
		Question.Select_Question_Type("Assessment");

		// Switch to the iframe
		driver.switchTo().frame(Question.QuestionTextIframe);
		Thread.sleep(1000);
		// Clear existing content (optional) and Type in content
		Question.editor.clear();
		Question.editor.sendKeys("This is Assessment Type Question : Select Your ratting");

		// Switch back to the main frame (outside the iframe)
		driver.switchTo().defaultContent();

		Question.HintSwitch.click();
		Question.HintInput.sendKeys("This is Hint: Select Largest");

		Question.Answer_Tab.click();
		Thread.sleep(2000);

		// Switch to the iframe
		driver.switchTo().frame(Question.Assessment);
		Thread.sleep(1000);
		// Clear existing content (optional) and Type in content
		Question.editor.clear();
		Question.editor.sendKeys("* less true { [1] [2] [3] [4] [5] } more true");

		// Switch back to the main frame (outside the iframe)
		driver.switchTo().defaultContent();

		Thread.sleep(1000);
		Question.Question_Publish_Button.click();

		Thread.sleep(5000);
		// Check Published Modal
		softAssert.assertTrue(Question.Question_Published_Text.size() > 0, "Question is not getting created");
		FCC_Quiz.Quiz_Publish_Button.click();
		Thread.sleep(5000);
		softAssert.assertTrue(FCC_Quiz.Quiz_Updated_Text.size() > 0, "Quiz Is Not Getting Updated");
		softAssert.assertAll();
	}

	/**
	 * Create Essay Question - Open Answer
	 * 
	 * @throws Exception
	 */
	@Test(priority = 8)
	public void Create_New_Essay_Open_Answer_Question() throws Exception {
		SoftAssert softAssert = new SoftAssert();
		driver.navigate().refresh();
		Thread.sleep(1500);
		actions.moveToElement(FCC_Quiz.Quiz_Builder_Tab).build().perform();
		FCC_Quiz.Quiz_Builder_Tab.click();
		Thread.sleep(500);
		Question.Add_New_Question.click();
		Question.Question_Title_Input.clear();
		Question.Question_Title_Input.sendKeys("IR_Automation : Essay/Open Answer");
		Question.Question_Type.click();
		Question.Select_Question_Type("Essay/Open Answer");

		Question.points.clear();
		Question.points.sendKeys("5");

		// Switch to the iframe
		driver.switchTo().frame(Question.QuestionTextIframe);
		Thread.sleep(1000);
		// Clear existing content (optional) and Type in content
		Question.editor.clear();
		Question.editor.sendKeys("This is Essay/Open Answer Question : Write essay on AI");

		// Switch back to the main frame (outside the iframe)
		driver.switchTo().defaultContent();

		Question.Answer_Tab.click();
		Thread.sleep(2000);

		Question.SubmissionType.click();
		Question.OpenAnswer.click();

		Question.GraddingType.click();
		Question.Not_Graded_Full_Points.click();

		Thread.sleep(1000);
		Question.Question_Publish_Button.click();

		Thread.sleep(5000);
		// Check Published Modal
		softAssert.assertTrue(Question.Question_Published_Text.size() > 0, "Question is not getting created");
		FCC_Quiz.Quiz_Publish_Button.click();
		Thread.sleep(5000);
		softAssert.assertTrue(FCC_Quiz.Quiz_Updated_Text.size() > 0, "Quiz Is Not Getting Updated");
		softAssert.assertAll();
	}

	/**
	 * Create Essay Question - Upload
	 * 
	 * @throws Exception
	 */
	@Test(priority = 9)
	public void Create_New_Essay_Upload_Question() throws Exception {
		SoftAssert softAssert = new SoftAssert();
		driver.navigate().refresh();
		Thread.sleep(1500);
		actions.moveToElement(FCC_Quiz.Quiz_Builder_Tab).build().perform();
		FCC_Quiz.Quiz_Builder_Tab.click();
		Thread.sleep(500);
		Question.Add_New_Question.click();
		Question.Question_Title_Input.clear();
		Question.Question_Title_Input.sendKeys("IR_Automation : Essay Upload");
		Question.Question_Type.click();
		Question.Select_Question_Type("Essay/Open Answer");

		Question.points.clear();
		Question.points.sendKeys("5");

		// Switch to the iframe
		driver.switchTo().frame(Question.QuestionTextIframe);
		Thread.sleep(1000);
		// Clear existing content (optional) and Type in content
		Question.editor.clear();
		Question.editor.sendKeys("This is Essay Upload Question : Upload essay on AI");

		// Switch back to the main frame (outside the iframe)
		driver.switchTo().defaultContent();

		Question.Answer_Tab.click();
		Thread.sleep(2000);

		Question.SubmissionType.click();
		Question.Upload.click();

		Question.GraddingType.click();
		Question.Graded_Full_Points.click();

		Thread.sleep(1000);
		Question.Question_Publish_Button.click();

		Thread.sleep(5000);
		// Check Published Modal
		softAssert.assertTrue(Question.Question_Published_Text.size() > 0, "Question is not getting created");
		FCC_Quiz.Quiz_Publish_Button.click();
		Thread.sleep(5000);
		softAssert.assertTrue(FCC_Quiz.Quiz_Updated_Text.size() > 0, "Quiz Is Not Getting Updated");
		softAssert.assertAll();
	}

}
