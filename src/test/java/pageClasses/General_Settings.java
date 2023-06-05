package pageClasses;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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
	@FindBy(id = "wdmir_review_product")
	public WebElement reviewProduct;

	// Review Course Checkbox
	@FindBy(id = "wdmir_review_course")
	public WebElement reviewCourse;

	// Quiz Completion Email Checkbox
	@FindBy(id = "wdm_enable_instructor_mail")
	public WebElement QuizCompletionEmail;

	// Course Purchase Emails Checkbox
	@FindBy(id = "wdm_enable_instructor_course_mail")
	public WebElement coursePurchaseEmail;

	// Instructor Commission Checkbox
	@FindBy(id = "wdm_enable_instructor_commission")
	public WebElement InstructorCommission;

	// LearnDash Category New Creation Checkbox
	@FindBy(id = "ir_ld_category_check")
	public WebElement NewLDCategory;

	// Student Communication Checkbox
	@FindBy(id = "ir_student_communication_check")
	public WebElement studentCommunication;

	// Enable Permalinks Checkbox
	@FindBy(id = "enable_permalinks")
	public WebElement Permalinks;

	// Enable LearnDash Categories Checkbox
	@FindBy(id = "enable_ld_category")
	public WebElement LDCategories;

	// Pricing Type : Open
	@FindBy(id = "enable_open_pricing")
	public WebElement Open;

	// Pricing Type : Free
	@FindBy(id = "enable_free_pricing")
	public WebElement Free;

	// Pricing Type : Buy Now
	@FindBy(id = "enable_buy_pricing")
	public WebElement BuyNow;

	// Pricing Type : Recurring
	@FindBy(id = "enable_recurring_pricing")
	public WebElement Recurring;

	// Pricing Type : Closed
	@FindBy(id = "enable_closed_pricing")
	public WebElement Closed;

	// Instructor Login Redirect
	@FindBy(id = "wdm_login_redirect")
	public WebElement Instructor_login_redirect;

	// Add the Instructor Dashboard Link to the Primary Header Menu for Instructors
	@FindBy(id = "wdm_id_ir_dash_pri_menu")
	public WebElement IR_Dash_Link_to_Pri_Menu;

//	// wdm_login_redirect_page :Select Login Redirect Page:
//	public Select RedirectPage = new Select(driver.findElement(By.id("wdm_login_redirect_page")));

	// IR Dashboard Menu Item
	@FindBy(xpath = "//li[contains(@class,'menu-item')]//a[text()='Instructor Dashboard']")
	public WebElement IR_Dash_Menu_Item;

	// IR Dashboard Menu Item in List
	@FindBy(xpath = "//li[contains(@class,'menu-item')]//a[text()='Instructor Dashboard']")
	public List <WebElement> IR_Dash_Menu_Item_inList;

	// Save Changes Button
	@FindBy(id = "submit")
	public WebElement submit;

	// Post Title
	@FindBy(xpath = "//input[@name='post_title']")
	public WebElement postTitle;

	// Course Title
	@FindBy(xpath = "//h1[contains(@class,'editor-post-title')]")
	public WebElement CourseTitle;

	// Publish Button
	@FindBy(id = "publish")
	public WebElement publish;

	// New Category Button
	@FindBy(xpath = "//button[text()='Add New Course Category']")
	public List<WebElement> NewCategory;

	@FindBy(xpath = "//button[text()='Add New Course Category']")
	public WebElement NewCategoryButton;
	
	@FindBy(xpath = "//button[text()='Add New Course Category']")
	public List <WebElement> NewCategoryButtonList; 
	
	// Course Category Section
	@FindBy(xpath = "//button[contains(text(),'Course Categories')]")
	public List<WebElement> CourseCategorySection;

	// Lesson Category Section
	@FindBy(xpath = "//button[contains(text(),'Lesson Categories')]")
	public List<WebElement> LessonCategorySection;

	// Topic Category Section
	@FindBy(xpath = "//button[contains(text(),'Topic Categories')]")
	public List<WebElement> TopicCategorySection;

	// Quiz Category Section
	@FindBy(xpath = "//button[contains(text(),'Quiz Categories')]")
	public List<WebElement> QuizCategorySection;

	// Update URL Option
	@FindBy(xpath = "//button[contains(@class,'edit-post-post-url__toggle')]")
	public List<WebElement> changePermalink;

	/**
	 * ================================================**
	 * 
	 ** Pricing Options on Course Add/Edit Page **
	 * 
	 * =================================================
	 **/
	@FindBy(id = "tab-sfwd-courses-settings")
	public WebElement CourseSettingsTab;

	@FindBy(id = "learndash-course-access-settings_course_price_type-open")
	public List<WebElement> CP_Open;
	@FindBy(id = "learndash-course-access-settings_course_price_type-free")
	public List<WebElement> CP_Free;
	@FindBy(id = "learndash-course-access-settings_course_price_type-paynow")
	public List<WebElement> CP_BuyNow;
	@FindBy(id = "learndash-course-access-settings_course_price_type-subscribe")
	public List<WebElement> CP_Recurring;
	@FindBy(id = "learndash-course-access-settings_course_price_type-closed")
	public List<WebElement> CP_Closed;

}
