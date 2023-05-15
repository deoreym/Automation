package pageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class General_Settings {

	WebDriver driver;
	WebDriverWait wait;

	// Constructor
	public General_Settings(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Review Products Checkbox
	@FindBy(xpath = "wdmir_review_product")
	public WebElement reviewProduct;

	// Review Course Checkbox
	@FindBy(xpath = "wdmir_review_course")
	public WebElement reviewCourse;

	// Quiz Completion Email Checkbox
	@FindBy(xpath = "wdm_enable_instructor_mail")
	public WebElement QuizCompletionEmail;

	// Course Purchase Emails Checkbox
	@FindBy(xpath = "wdm_enable_instructor_course_mail")
	public WebElement coursePurchaseEmail;

	// Instructor Commission Checkbox
	@FindBy(xpath = "wdm_enable_instructor_commission")
	public WebElement InstructorCommission;

	// LearnDash Category New Creation Checkbox
	@FindBy(xpath = "ir_ld_category_check")
	public WebElement NewLDCategory;

	// Student Communication Checkbox
	@FindBy(xpath = "ir_student_communication_check")
	public WebElement studentCommunication;

	// Enable Permalinks Checkbox
	@FindBy(xpath = "enable_permalinks")
	public WebElement Permalinks;

	// Enable LearnDash Categories Checkbox
	@FindBy(xpath = "enable_ld_category")
	public WebElement LDCategories;

	// Pricing Type : Open
	@FindBy(xpath = "enable_open_pricing")
	public WebElement Open;

	// Pricing Type : Free
	@FindBy(xpath = "enable_free_pricing")
	public WebElement Free;

	// Pricing Type : Buy Now
	@FindBy(xpath = "enable_buy_pricing")
	public WebElement BuyNow;

	// Pricing Type : Recurring
	@FindBy(xpath = "enable_recurring_pricing")
	public WebElement Recurring;

	// Pricing Type : Closed
	@FindBy(xpath = "enable_closed_pricing")
	public WebElement Closed;

	// Instructor Login Redirect
	@FindBy(id = "wdm_login_redirect")
	public WebElement Instructor_login_redirect;

	// Add the Instructor Dashboard Link to the Primary Header Menu for Instructors
	@FindBy(id = "wdm_id_ir_dash_pri_menu")
	public WebElement IR_Dash_Link_to_Pri_Menu;

	// wdm_login_redirect_page :Select Login Redirect Page:
	public Select RedirectPage = new Select(driver.findElement(By.id("wdm_login_redirect_page")));

	// Save Changes Button
	@FindBy(id = "submit")
	public WebElement submit;

}
