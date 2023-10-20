package pageClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FCC_Questions {

	WebDriver driver;
	WebDriverWait wait;

	// Constructor
	public FCC_Questions(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Quiz on Listing Edit - //a[text()='Science Quiz – by Automation']
	public WebElement QuizEdit(String QuizName) {
		return driver.findElement(By.xpath("//a[text()='" + QuizName + "']"));
	}

	// FQB Quiz Edit Link
	public WebElement FQB_QuizEdit(String QuizName) {
		return driver.findElement(
				By.xpath("//a[text()='" + QuizName + "']/../..//a[text()='Edit via Frontend Quiz Creator']"));
	}

	// Add New Question Button
	@FindBy(xpath = "//button//span[text()='Add new question']")
	public WebElement Add_New_Question;

	// Publish / Update Button
	@FindBy(xpath = "//button[@type='submit']")
	public WebElement PublishQue;

	// Question Created / Published Text
	@FindBy(xpath = "//div[text()='Question Created!']")
	public List<WebElement> Question_Created_Text;

	// Question Tab
	@FindBy(xpath = "//button[contains(@id,'tab-Question')]")
	public WebElement Question_Tab;

	// Answer Tab
	@FindBy(xpath = "//button[contains(@id,'tab-Answer')]")
	public WebElement Answer_Tab;

	/**
	 * Question Tab
	 */
	// Question Title Input
	@FindBy(xpath = "//label[text()='Question title']/..//input")
	public WebElement Question_Title_Input;

	// Question Publish Button
	@FindBy(xpath = "//span[text()='Publish']/../..")
	public WebElement Question_Publish_Button;

	// Question Published Text
	@FindBy(xpath = "//div[text()='Your Question has successfully been created']")
	public List<WebElement> Question_Published_Text;

	// Question Type
	@FindBy(xpath = "(//input[@placeholder='Question Type'])[1]")
	public WebElement Question_Type;

	// Select Question Type
	// (Options are as follow : Single Choice / Multiple Choice / Free Choice /
	// Matrix Sorting Choice / Sorting Choice / Fill in the blanks / Assessment /
	// Essay/Open Answer )
	public void Select_Question_Type(String Type) {
		driver.findElement(By.xpath("//div[contains(@id,'items')]//div[text()='" + Type + "']")).click();
	}

	// Question Text Iframe
	@FindBy(xpath = "//iframe[contains(@id,'question-content_ifr')]")
	public WebElement QuestionTextIframe;

	// Editor
	@FindBy(tagName = "body")
	public WebElement editor;

	// Points input
	@FindBy(xpath = "//label[text()='Points']/..//input")
	public WebElement points;

	// Different points for each answer
	@FindBy(xpath = "//label[text()='Different points for each answer']/../..//input")
	public WebElement DifferentPoints;

	// Show reached points in the correct- and incorrect message?
	@FindBy(xpath = "//label[text()='Show reached points in the correct- and incorrect message?']/../..//input")
	public WebElement ShowReachedPoints;

	// Hint Toggle
	@FindBy(xpath = "//*[text()='Hint']/../..//label[contains(@class,'mantine-Switch-track')]")
	public WebElement HintSwitch;

	// Hint Switch Input
	@FindBy(xpath = "//*[text()='Hint']/../..//input")
	public WebElement HintSwitchinput;

	// Hint Input
	@FindBy(id = "ir-hint-message")
	public WebElement HintInput;

	/*
	 * Answers Tab
	 * 
	 */

	// Question Type on Answer Tab
	@FindBy(xpath = "(//input[@placeholder='Question Type'])[2]")
	public WebElement Question_Type_in_Answer;

	// Description iFrame ID = ir-content-editor_ifr
	// Wrong Answer Message Toggle
	@FindBy(xpath = "//*[text()='Wrong Answer message']/../..//label[contains(@class,'mantine-Switch-track')]")
	public WebElement WrongAnsMessageSwitch;

	// Wrong Answer Message Switch Input
	@FindBy(xpath = "//*[text()='Wrong Answer message']/../..//input")
	public WebElement WrongAnsMessageSwitchinput;

	// Wrong Answer Message Input
	@FindBy(id = "ir-wrong-message")
	public WebElement WrongAnsMessageInput;

	// Right Answer Message Toggle
	@FindBy(xpath = "//*[text()='Right Answer message']/../..//label[contains(@class,'mantine-Switch-track')]")
	public WebElement RightAnsMessageSwitch;

	// Right Answer Message Switch Input
	@FindBy(xpath = "//*[text()='Right Answer message']/../..//input")
	public WebElement RightAnsMessageSwitchinput;

	// Right Answer Message Input
	@FindBy(id = "ir-right-message")
	public WebElement RightAnsMessageInput;

	// Add New Answer Button
	@FindBy(xpath = "//button//span[text()='Add new Answer']")
	public WebElement Add_New_Answer;

	// Answer text
	@FindBy(xpath = "//*[contains(@class,'ir-sortable-answers')]/..//textarea")
	public WebElement AnswerText;

	public WebElement AnswerText(String Index) {
		return driver
				.findElement(By.xpath("(//*[contains(@class,'ir-sortable-answers')]/..//textarea)[" + Index + "]"));
	}

	// Save Answer
	@FindBy(xpath = "//*[contains(@class,'ir-sortable-answers')]/..//span[text()='Save']")
	public WebElement SaveAnswer;

	public WebElement SaveAnswer(String Index) {
		return driver.findElement(
				By.xpath("(//*[contains(@class,'ir-sortable-answers')]/..//span[text()='Save'])[" + Index + "]"));
	}

	// Mark as Correct Answer
	@FindBy(xpath = "//*[text()='Mark as correct answer']/../..//input")
	public WebElement CorrectAnswer;

	public WebElement CorrectAnswer(String Index) {
		return driver.findElement(By.xpath("(//*[text()='Mark as correct answer']/../..//input)[" + Index + "]"));
	}

	// Free Type Answer
	@FindBy(xpath = "//*[@id='ir-sort-answer']")
	public WebElement FreeAnswer;

	// Matrix Sorting Width Percentage
	@FindBy(xpath = "//*[text()='Width percentage']/..//input")
	public WebElement MatrixWidth;

	// Matrix Sorting Criterion
	@FindBy(xpath = "//*[text()='Criterion']/..//textarea")
	public WebElement Criterion;

	// Matrix Sorting Sort_Elements
	@FindBy(xpath = "//*[text()='Sort elements']/..//textarea")
	public WebElement Sort_Elements;

	// Fill In the Blanks iFrame - ir-cloze-content_ifr
	@FindBy(xpath = "//iframe[contains(@id,'ir-cloze-content_ifr')]")
	public WebElement FillInTheBlanks;

	// Assessment Question Iframe - ir-assessment-content_ifr
	@FindBy(xpath = "//iframe[contains(@id,'ir-assessment-content_ifr')]")
	public WebElement Assessment;

	// Essay Submission type
	@FindBy(xpath = "//input[@placeholder='Submission Type']")
	public WebElement SubmissionType;

	// Essay Submission type - Open Answer
	@FindBy(xpath = "//div[text()='Open Answer']")
	public WebElement OpenAnswer;

	// Essay Submission type - Upload
	@FindBy(xpath = "//div[text()='Upload']")
	public WebElement Upload;

	// Essay Gradding Type
	@FindBy(xpath = "//input[@placeholder='Grading Type']")
	public WebElement GraddingType;

	// Essay Gradding Type - Not Graded, No Points Awarded
	@FindBy(xpath = "//div[text()='Not Graded, No Points Awarded']")
	public WebElement Not_Graded_No_Points;

	// Essay Gradding Type - Not Graded, Full Points Awarded
	@FindBy(xpath = "//div[text()='Not Graded, Full Points Awarded']")
	public WebElement Not_Graded_Full_Points;

	// Essay Gradding Type - //div[text()='Graded, Full Points Awarded']
	@FindBy(xpath = "//div[text()='Graded, Full Points Awarded']")
	public WebElement Graded_Full_Points;

}
