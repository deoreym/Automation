package pageClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FCC_Quiz {

	WebDriver driver;
	WebDriverWait wait;

	// Constructor
	public FCC_Quiz(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Visit Courses List
	public void Visit_Quiz_List(String BaseURL) {
		driver.get(BaseURL + "wp-admin/edit.php?post_type=sfwd-quiz");
	}

	// Add New Quiz via Frontend Quiz Creator Button
	@FindBy(id = "ir-fqb-create-new-quiz")
	public WebElement Add_New_FCC_Quiz;

	// Quiz Page Tab
	@FindBy(xpath = "//button[contains(@id,'ir-quiz-page')]")
	public WebElement Quiz_QuizPage_Tab;
	// Quiz Builder Tab
	@FindBy(xpath = "//button[contains(@id,'ir-quiz-builder')]")
	public WebElement Quiz_Builder_Tab;
	// Quiz Settings Tab
	@FindBy(xpath = "//button[contains(@id,'ir-quiz-settings')]")
	public WebElement Quiz_Settings_Tab;

	/**
	 * Quiz Page Tab
	 */
	// Quiz Title Input
	@FindBy(xpath = "//label[text()='Quiz title']/..//input")
	public WebElement Quiz_Title_Input;

	// Quiz Page Container
	@FindBy(xpath = "//div[contains(@class,'ir-fed-course-page')]")
	public WebElement Quiz_Page;

	// Quiz Publish Button
	@FindBy(xpath = "//button[contains(@class,'ir-publish')]")
	public WebElement Quiz_Publish_Button;

	// Quiz Published Text
	@FindBy(xpath = "//div[text()='Congratulations your Quiz is published!']")
	public List<WebElement> Quiz_Published_Text;

	// Published Modal View Quiz Button
	@FindBy(xpath = "//div[text()='Congratulations your Quiz is published!']/../..//span[text()='View Quiz']")
	public WebElement View_Quiz;

	// Author Accordion
	@FindBy(id = "mantine-r5-control-quiz-author")
	public WebElement Author_Accordion;

	// Author List
	@FindBy(xpath = "//button[@id='mantine-r5-control-quiz-author']/..//input[@type='search']")
	public WebElement Author_List;

	// Tag Accordion
	@FindBy(xpath = "//button[contains(@id,'ld_quiz_tag')]")
	public WebElement TagAccordion;

	// Search Tag input
	@FindBy(xpath = "//input[@placeholder='Select items']")
	public WebElement SearchTag;

	// Select Tag
	public WebElement SelectTag(String TagName) {
		return driver.findElement(
				By.xpath("//div[contains(@class,'mantine-MultiSelect-item') and text()='" + TagName + "']"));
	}

	// Select Category
	public WebElement SelectCategory(String Category) {
		return driver.findElement(By.xpath("//label[text()='" + Category + "']"));
	}

	// Category Accordion
	@FindBy(xpath = "//button[contains(@id,'ld_quiz_category')]")
	public WebElement CategoryAccordion;

	// Description iFrame ID = ir-content-editor_ifr

	/**
	 * Settings Tab
	 */

	/**
	 * * * * * * * * * * Quiz access settings * * * * * * * * * *
	 */

	// Progression and restriction settings - Accordion
	@FindBy(xpath = "//button[contains(@id,'quiz-access-settings')]")
	public WebElement Quiz_access_settings;
	// Immediately
	@FindBy(xpath = "//label[text()='Immediately']/../..//input[@type='radio']")
	public WebElement Immediately;

	// Enrollment-based
	@FindBy(xpath = "//input[@value='visible_after']")
	public WebElement Enrollment_based;

	@FindBy(xpath = "//*[text()='days(s)']/..//input")
	public WebElement Enrollment_Days;

	// Specific date
	@FindBy(xpath = "//input[@value='visible_after_specific_date']")
	public WebElement Specific_Date;

	// Specific Date - Month Select
	@FindBy(xpath = "//input[@value='visible_after_specific_date']/../../../..//input[@placeholder='MM']")
	public WebElement Specific_Date_Month_Select;

	// Specific Date - Month //div[text()='Jan']
	public WebElement Specific_Date_Month(String M) {
		return driver.findElement(By.xpath("//div[text()='" + M + "']"));
	}

	// Specific Date - Date
	@FindBy(xpath = "//input[@placeholder='DD']")
	public WebElement Specific_Date_Date;

	// Specific Date - Year
	@FindBy(xpath = "//input[@placeholder='YYYY']")
	public WebElement Specific_Date_Year;

	// Specific Date - Hour
	@FindBy(xpath = "//input[@value='visible_after_specific_date']/../../../..//input[@placeholder='HH']")
	public WebElement Specific_Date_Hour;

	// Specific Date - Minute
	@FindBy(xpath = "(//input[@value='visible_after_specific_date']/../../../..//input[@placeholder='MM'])[2]")
	public WebElement Specific_Date_Minute;

	// Quiz prerequisites
	@FindBy(xpath = "//*[text()='Quiz prerequisites']/..//input[@placeholder='Select an option']")
	public WebElement Quiz_prerequisites;

	// Select Prerequisite Quiz
	public WebElement SelectPreQuiz(String Quiz) {
		return driver.findElement(By.xpath("//div[text()='" + Quiz + "']"));
	}

	@FindBy(xpath = "//*[text()='Quiz prerequisites']")
	public WebElement prerequisites;

	// Allowed users
	@FindBy(xpath = "//*[text()='Allowed users']/..//input")
	public WebElement Allowed_users;

	/**
	 * * * * * * * * Progression and restriction settings * * * * * * * *
	 */

	// Progression and restriction settings - Accordion
	@FindBy(xpath = "//button[contains(@id,'Progression-and-restriction-settings')]")
	public WebElement Progression_and_restriction_settings;

	// Passing score - input
	@FindBy(xpath = "//*[text()='Passing score']/..//input")
	public WebElement Passing_score;

	// Quiz Certificate - Select
	@FindBy(xpath = "//*[text()='Quiz certificate']/..//input[@placeholder='Select a Certificate']")
	public WebElement Certificate_Select;

	// Select Certificate
	public WebElement SelectCertificate(String Certificate) {
		return driver.findElement(By.xpath("//div[text()='" + Certificate + "']"));
	}

	// Certificate awarded for
	@FindBy(xpath = "//*[text()='Certificate awarded for']/..//input")
	public WebElement Certificate_awarded_for;

	// Unchecked "Enable quiz saving"
	@FindBy(xpath = "//*[text()='Enable quiz saving']/../div[contains(@class,'unchecked')]")
	public List<WebElement> Quiz_Saving_Unchecked;

	// Enable quiz saving - Toggle
	@FindBy(xpath = "//*[text()='Enable quiz saving']/..//label[contains(@class,'mantine-Switch-track')]")
	public WebElement Enable_Quiz_Saving;

	// Save quiz data to the server every x Seconds
	@FindBy(xpath = "//*[text()='Save quiz data to the server every']/..//input")
	public WebElement Quiz_Saving_Second;

	// Unchecked "Restrict quiz retakes"
	@FindBy(xpath = "//div[contains(@class,'ir-unchecked')]//*[text()='Restrict quiz retakes']")
	public List<WebElement> quiz_retakes_Unchecked;

	// Restrict quiz retakes - Toggle
	@FindBy(xpath = "//*[text()='Restrict quiz retakes']/../..//label[contains(@class,'mantine-Switch-track')]")
	public WebElement Restrict_quiz_retakes;

	// Number of retries allowed
	@FindBy(xpath = "//*[contains(text(),'Number of retries allowed')]/..//input")
	public WebElement Quiz_Retakes;

	// Retries applicable to
	@FindBy(xpath = "//*[text()='Retries applicable to']/..//div[contains(@class,'ir-select')]")
	public WebElement Retries_Applicable_To;

	// Select Retries applicable to
	public WebElement Select_Retries_Applicable_To(String option) {
		return driver.findElement(By.xpath("//div[text()='" + option + "']"));
	}

	// Question completion
	@FindBy(xpath = "//*[text()='Question completion']/..//input")
	public WebElement Question_Completion;

	// Unchecked "Time limit"
	@FindBy(xpath = "//div[contains(@class,'ir-unchecked')]//*[text()='Time limit']")
	public List<WebElement> Time_limit_Unchecked;

	// Time limit - Toggle
	@FindBy(xpath = "//*[text()='Time limit']/../..//label[contains(@class,'mantine-Switch-track')]")
	public WebElement Time_limit;

	// Time limit - Hour
	@FindBy(xpath = "//*[text()='Automatically submit after']/..//input[@placeholder='HH']")
	public WebElement Time_limit_HH;

	// Time limit - Minutes
	@FindBy(xpath = "//*[text()='Automatically submit after']/..//input[@placeholder='MM']")
	public WebElement Time_limit_MM;

	// Time limit - Seconds
	@FindBy(xpath = "//*[text()='Automatically submit after']/..//input[@placeholder='SS']")
	public WebElement Time_limit_SS;

	/**
	 * * * * * * * * Display and Content Options * * * * * * * *
	 */
	// Progression and restriction settings - Accordion
	@FindBy(xpath = "//button[contains(@id,'display-and-content-options')]")
	public WebElement Display_and_Content_Option;

	// Unchecked "Quiz material"
	@FindBy(xpath = "//*[text()='Quiz material']/../div[contains(@class,'ir-unchecked')]")
	public List<WebElement> Quiz_material_Unchecked;

	// Quiz material - Toggle
	@FindBy(xpath = "//*[text()='Quiz material']/..//label[contains(@class,'mantine-Switch-track')]")
	public WebElement Quiz_material;

	// Radio "Auto start"
	@FindBy(xpath = "//*[text()='Auto start']/..//input")
	public List<WebElement> Auto_start_Unchecked;

	// Quiz material - Toggle
	@FindBy(xpath = "//*[text()='Auto start']/..//label[contains(@class,'mantine-Switch-track')]")
	public WebElement Auto_start;

	// Question display - Select
	@FindBy(xpath = "//*[text()='Question display']/..//input[@placeholder='Select an option']")
	public WebElement Question_display_Select;

	// Select Certificate
	public WebElement Select_Question_display(String Option) {
		return driver.findElement(By.xpath("//div[text()='" + Option + "']"));
	}

	// Display results at the end only - Radio
	@FindBy(xpath = "//*[text()='Display results at the end only']/../..//input")
	public WebElement Display_Result_At_End;

	// Display back button - Checkbox
	@FindBy(xpath = "//*[text()='Display back button']/../..//input")
	public WebElement Display_Back_Button;

	// Display results after each submitted answer - Radio
	@FindBy(xpath = "//*[text()='Display results after each submitted answer']/../..//input")
	public WebElement Display_Result_After_Each_Que;

	// Question overview table - Toggle
	@FindBy(xpath = "//*[text()='Question overview table']/../..//label[contains(@class,'mantine-Switch-track')]")
	public WebElement Question_Overview_Table;

	// Quiz summary - Toggle
	@FindBy(xpath = "//*[text()='Quiz summary']/..//label[contains(@class,'mantine-Switch-track')]")
	public WebElement Quiz_summary;

	// Skip question - Toggle
	@FindBy(xpath = "//*[text()='Skip question']/..//label[contains(@class,'mantine-Switch-track')]")
	public WebElement Skip_Question;

	// Custom question ordering - Toggle
	@FindBy(xpath = "//*[text()='Custom question ordering']/../..//label[contains(@class,'mantine-Switch-track')]")
	public WebElement Custom_question_ordering;

	// Sort by category - Toggle
	@FindBy(xpath = "//*[text()='Sort by category']/..//label[contains(@class,'mantine-Switch-track')]")
	public WebElement Sort_by_category;

	// Randomize order - Toggle
	@FindBy(xpath = "//*[text()='Randomize order']/..//label[contains(@class,'mantine-Switch-track')]")
	public WebElement Randomize_order;

	// Display all Questions
	@FindBy(xpath = "//*[text()='Display all Questions']/../..//input")
	public WebElement Display_all_Questions;

	// Display subset of Questions
	@FindBy(xpath = "//*[text()='Display subset of Questions']/../..//input")
	public WebElement Display_subset_of_Questions;

	// Out of 0 Questions
	@FindBy(xpath = "//*[text()='Out of 0 Questions']/..//input")
	public WebElement Out_of_Questions;

	// Additional question options - Toggle
	@FindBy(xpath = "//*[text()='Additional question options']/../..//label[contains(@class,'mantine-Switch-track')]")
	public WebElement Additional_question_options;

	// Point value - Toggle
	@FindBy(xpath = "//*[text()='Point value']/..//label[contains(@class,'mantine-Switch-track')]")
	public WebElement Point_value;

	// Question category - Toggle
	@FindBy(xpath = "//*[text()='Question category']/..//label[contains(@class,'mantine-Switch-track')]")
	public WebElement Question_category;

	// Question position - Toggle
	@FindBy(xpath = "//*[text()='Question position']/..//label[contains(@class,'mantine-Switch-track')]")
	public WebElement Question_position;

	// Question numbering - Toggle
	@FindBy(xpath = "//*[text()='Question numbering']/..//label[contains(@class,'mantine-Switch-track')]")
	public WebElement Question_numbering;

	// Number answers - Toggle
	@FindBy(xpath = "//*[text()='Number answers']/..//label[contains(@class,'mantine-Switch-track')]")
	public WebElement Number_Answers;

	// Randomize answers - Toggle
	@FindBy(xpath = "//*[text()='Randomize answers']/..//label[contains(@class,'mantine-Switch-track')]")
	public WebElement Randomize_answers;

	// Quiz title - Toggle
	@FindBy(xpath = "//*[text()='Quiz title']/..//label[contains(@class,'mantine-Switch-track')]")
	public WebElement Quiz_title_Toggle;

	/**
	 * * * * * * * * Result page display * * * * * * * *
	 */
	// Result page display - Accordion
	@FindBy(xpath = "//button[contains(@id,'result-page-display')]")
	public WebElement Result_page_display;

	// Result message(s) - Toggle
	@FindBy(xpath = "//*[text()='Result message(s)']/..//label[contains(@class,'mantine-Switch-track')]")
	public WebElement Result_Message;

	// Add Graduation
	@FindBy(xpath = "//span[text()='Add graduation']")
	public WebElement Add_Graduation;

	// Restart quiz button - Toggle
	@FindBy(xpath = "//*[text()='Restart quiz button']/../..//label[contains(@class,'mantine-Switch-track')]")
	public WebElement Restart_quiz_button;

	// Custom results display - Toggle
	@FindBy(xpath = "//*[text()='Custom results display']/../..//label[contains(@class,'mantine-Switch-track')]")
	public WebElement Custom_results_display;

	// Checked "Custom results display"
	@FindBy(xpath = "//div[contains(@class,'ir-checked')]//*[text()='Custom results display']")
	public List<WebElement> Custom_results_Checked;

	// Average score - Toggle
	@FindBy(xpath = "//*[text()='Average score']/..//label[contains(@class,'mantine-Switch-track')]")
	public WebElement Average_score;

	// Category score - Toggle
	@FindBy(xpath = "//*[text()='Category score']/..//label[contains(@class,'mantine-Switch-track')]")
	public WebElement Category_score;

	// Overall score - Toggle
	@FindBy(xpath = "//*[text()='Overall score']/../..//label[contains(@class,'mantine-Switch-track')]")
	public WebElement Overall_score;

	// No. of correct answers - Toggle
	@FindBy(xpath = "//*[text()='No. of correct answers']/../..//label[contains(@class,'mantine-Switch-track')]")
	public WebElement No_Of_Correct_Answers;

	// Time spent - Toggle
	@FindBy(xpath = "//*[text()='Time spent']/..//label[contains(@class,'mantine-Switch-track')]")
	public WebElement Time_spent;

	// Custom answer feedback - Toggle
	@FindBy(xpath = "//*[text()='Custom answer feedback']/../..//label[contains(@class,'mantine-Switch-track')]")
	public WebElement Custom_answer_feedback;

	// Checked "Custom answer feedback"
	@FindBy(xpath = "//div[contains(@class,'ir-checked')]//*[text()='Custom answer feedback']")
	public List<WebElement> Custom_answer_feedback_Checked;

	// Correct / Incorrect messages - Toggle
	@FindBy(xpath = "//*[text()='Correct / Incorrect messages']/..//label[contains(@class,'mantine-Switch-track')]")
	public WebElement Correct_Incorrect_Messages;

	// Correct / Incorrect answer marks - Toggle
	@FindBy(xpath = "//*[text()='Correct / Incorrect answer marks']/..//label[contains(@class,'mantine-Switch-track')]")
	public WebElement Correct_Incorrect_Marks;

	// View question button - Toggle
	@FindBy(xpath = "//*[text()='View question button']/..//label[contains(@class,'mantine-Switch-track')]")
	public WebElement View_question_button;

	/**
	 * * * * * * * * Administrative and data handling * * * * * * * *
	 */
	// Administrative and data handling - Accordion
	@FindBy(xpath = "//button[contains(@id,'Administrative-and-data-handling')]")
	public WebElement Administrative_and_data_handling;

	// Custom fields - Toggle
	@FindBy(xpath = "//*[text()='Custom fields']/../..//label[contains(@class,'mantine-Switch-track')]")
	public WebElement Custom_fields;

	// Leaderboard - Toggle
	@FindBy(xpath = "//*[text()='Leaderboard']/../..//label[contains(@class,'mantine-Switch-track')]")
	public WebElement Leaderboard;

	// Who can apply - Select
	@FindBy(xpath = "//*[text()='Who can apply']/..//input[@placeholder='Select an option']")
	public WebElement Who_can_apply_Select;

	// Select Who can apply
	public WebElement Select_Who_can_apply(String Option) {
		return driver.findElement(By.xpath("//div[text()='" + Option + "']"));
	}

	// Multiple Applications per user - Toggle
	@FindBy(xpath = "//*[text()='Multiple Applications per user']/..//label[contains(@class,'mantine-Switch-track')]")
	public WebElement Multiple_Applications_per_user;

	// Re-apply after
	@FindBy(xpath = "//*[text()='Re-apply after']/..//input")
	public WebElement Re_apply_after;

	// Automatic user entry
	@FindBy(xpath = "//*[text()='Automatic user entry']/..//input")
	public WebElement Automatic_user_entry;

	// Number of displayed entries
	@FindBy(xpath = "//*[text()='Number of displayed entries ']/..//input")
	public WebElement Number_of_displayed_entries;

	// Sort list by? - Select
	@FindBy(xpath = "//*[text()='Sort list by?']/..//input[@placeholder='Select an option']")
	public WebElement Sort_list_by;

	// Select Sort list by?
	public WebElement Select_Sort_list_by(String Option) {
		return driver.findElement(By.xpath("//div[text()='" + Option + "']"));
	}

	// Display on quiz results page - Toggle
	@FindBy(xpath = "//*[text()='Display on quiz results page']/..//label[contains(@class,'mantine-Switch-track')]")
	public WebElement Display_on_quiz_results_page;

	// Below the result text
	@FindBy(xpath = "//*[text()='Below the result text']/../..//input")
	public WebElement Below_the_result_text;

	// In a button
	@FindBy(xpath = "//*[text()='In a button']/../..//input")
	public WebElement In_a_button;

	// Really simple CAPTCHA
	@FindBy(xpath = "//*[text()='Really simple CAPTCHA']/..//input")
	public WebElement CATPCHA;

	// Quiz statistics - Toggle
	@FindBy(xpath = "//*[text()='Quiz statistics']/../..//label[contains(@class,'mantine-Switch-track')]")
	public WebElement Quiz_statistics;

	// Front-end profile display - Toggle
	@FindBy(xpath = "//*[text()='Front-end profile display']/..//label[contains(@class,'mantine-Switch-track')]")
	public WebElement Frontend_profile_display;

	// Statistics IP-lock - Toggle
	@FindBy(xpath = "//*[text()='Statistics IP-lock']/..//label[contains(@class,'mantine-Switch-track')]")
	public WebElement Statistics_IP_lock;

	// IP-lock time limit
	@FindBy(xpath = "//*[text()='IP-lock time limit']/..//input")
	public WebElement IP_lock_time_limit;

	// Email notifications - Toggle
	@FindBy(xpath = "//*[text()='Email notifications']/../..//label[contains(@class,'mantine-Switch-track')]")
	public WebElement Email_notifications;

	// Admin - Toggle
	@FindBy(xpath = "//*[text()='Admin']/..//label[contains(@class,'mantine-Switch-track')]")
	public WebElement Admin;

	// User - Toggle
	@FindBy(xpath = "//*[text()='User']/..//label[contains(@class,'mantine-Switch-track')]")
	public WebElement User;

	// Email trigger - Select
	@FindBy(xpath = "//*[text()='Email trigger']/..//input[@placeholder='Select an option']")
	public WebElement Email_trigger;

	// Select Sort list by?
	public WebElement Select_Email_trigger(String Option) {
		return driver.findElement(By.xpath("//div[text()='" + Option + "']"));
	}

	// Quiz templates - Toggle
	@FindBy(xpath = "//*[text()='Quiz templates']/../..//label[contains(@class,'mantine-Switch-track')]")
	public WebElement Quiz_templates;

	// Advanced settings - Toggle
	@FindBy(xpath = "//*[text()='Advanced settings']/../..//label[contains(@class,'mantine-Switch-track')]")
	public WebElement Advanced_settings;

	// Browser cookie answer protection - Toggle
	@FindBy(xpath = "//*[text()='Browser cookie answer protection']/..//label[contains(@class,'mantine-Switch-track')]")
	public WebElement Browser_cookie_answer_protection;

	// Cookie time limit
	@FindBy(xpath = "//*[text()='Cookie time limit']/..//input")
	public WebElement Cookie_time_limit;

}
