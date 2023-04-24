package pageClasses;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import setUp.GeneralisedProjectOperations;

public class GeneralSettings {

	WebDriver driver;
	GeneralisedProjectOperations generalisedOps = new GeneralisedProjectOperations();
	WebDriverWait wait;

	// Constructor
	public GeneralSettings(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// General Settings Tab
	@FindBy(xpath = "//*[@class='nav-tab-wrapper']//a[@href='?page=instuctor&tab=settings']")
	public WebElement generalSettings;

	// Menu Settings Tab
	@FindBy(xpath = "//*[@class='nav-tab-wrapper']//a[@href='?page=instuctor&tab=menu_settings']")
	public WebElement menuSettings;

	// Overview Settings Tab
	@FindBy(xpath = "//*[@class='nav-tab-wrapper']//a[@href='?page=instuctor&tab=overview_settings']")
	public WebElement overviewSettings;

	// Overview Course Block
	@FindBy(xpath = "//input[@name='ir_overview_settings[course_block]']")
	public WebElement courseBlock;
	
	// Course Block Slider
	@FindBy(xpath = "//td[text()='Course block']/..//span[@class='wdm-slider round']")
	public WebElement  courseBlockSlider;
	
	// Overview Course Block
	@FindBy(xpath = "//input[@name='ir_overview_settings[student_block]']")
	public WebElement studentBlock;
	
	// Student Block Slider
	@FindBy(xpath = "//td[text()='Student block']/..//span[@class='wdm-slider round']")
	public WebElement  studentBlockSlider;


	// Overview Setting Save Button
	@FindBy(id = "ir-save-overview-settings")
	public WebElement overviewSaveSettings;

	
	//Overview course Block
	@FindBy(xpath = "//*[@class='irbn-tiles-wrap']//span[@class='irbn-text' and text()='Courses']")
	public WebElement  OvCourseBlock;
	
	
	
	// Enable Redirect To My Courses
	@FindBy(id = "eb_enable_my_courses")
	public WebElement redirectToMyCourses;

	// My Courses Page Select
	@FindBy(id = "eb_my_courses_page_id")
	public WebElement myCoursesPage;

	// Enable User Registration
	@FindBy(id = "eb_enable_registration")
	public WebElement userRegistration;

	// UserAccount Page Select
	@FindBy(id = "eb_useraccount_page_id")
	public WebElement userAccountPage;

	// Edwiser Language Code
	@FindBy(id = "eb_language_code")
	public WebElement ebLanguageCode;

	// My Course Page Redirect Link
	@FindBy(id = "eb_my_course_link")
	public WebElement emptyMyCourseLink;

	// Courses Per Row
	@FindBy(id = "courses_per_row")
	public WebElement coursesPerRow;

//	public Select CoursePerRow = new Select(coursesPerRow);

	// Enable Tearms and Conditions
	@FindBy(id = "eb_enable_terms_and_cond")
	public WebElement enableTerms;

	// Tearms and Conditions
	@FindBy(id = "eb_terms_and_cond")
	public WebElement TermsAndConditions;

	// Enable Recommented Courses On My Courses Page
	@FindBy(id = "eb_enable_recmnd_courses")
	public WebElement EnableRecommendedCourses;

	// Enable Default Recommented Courses On My Courses Page
	@FindBy(id = "eb_show_default_recmnd_courses")
	public WebElement EnableDefaultRecommendedCourses;

	// Selct Course Input
	@FindBy(xpath = "//*[@class='select2-search__field']")
	public WebElement SearchCourse;

	// Select Course Selction Option
	@FindBy(xpath = "//*[@class='select2-results__option select2-results__option--highlighted']")
	public WebElement selectResultCourse;

	// Moodle URL
	@FindBy(id = "eb_url")
	public WebElement moodleUrl;

	// Moodle Access Token
	@FindBy(id = "eb_access_token")
	public WebElement moodleAccessToken;

	// Test Connection Button
	@FindBy(id = "eb_test_connection_button")
	public WebElement testConnection;

	// Test Connection Response Message
	@FindBy(xpath = "//*[@class='response-box']/div")
	public WebElement connectionResponse;
	////*[@class='eb_test_connection_response']/div

	// Courses Tab In Synchronization Setting
	@FindBy(xpath = "//*[@class='form-content']//a[text()='Courses']")
	public WebElement coursesTab;

	// Users Tab In Synchronization Setting
	@FindBy(xpath = "//*[@class='form-content']//a[text()='Users']")
	public WebElement usersTab;

	// Synchronize Categories CheckBox
	@FindBy(id = "eb_synchronize_categories")
	public WebElement synchronizeCategories;

	// Synchronize Previous Courses CheckBox
	@FindBy(id = "eb_synchronize_previous")
	public WebElement synchronizePrevious;

	// Synchronize Courses ad Draft CheckBox
	@FindBy(id = "eb_synchronize_draft")
	public WebElement synchronizeDraft;

	// Start Courses Synchronization Button
	@FindBy(id = "eb_synchronize_courses_button")
	public WebElement startCourseSynchronization;

	// Start User Synchronization Button
	@FindBy(id = "eb_synchronize_users_button")
	public WebElement startUserSynchronization;

	// Start User Synchronization Button
	@FindBy(id = "eb_synchronize_user_courses")
	public WebElement synchronizeUserCourses;

	// PayPal Email
	@FindBy(id = "eb_paypal_email")
	public WebElement paypalEmail;

	// PayPal SandBox CheckBox
	@FindBy(id = "eb_paypal_sandbox")
	public WebElement paypalSandbox;

	// PayPal Currency DropDown
	@FindBy(id = "eb_paypal_currency")
	public WebElement paypalCurrency;

	// PayPal Country Code
	@FindBy(id = "eb_paypal_country_code")
	public WebElement paypalCountryCode;

	// Extension Link
	@FindBy(xpath = "//div[@class='form-content']//a")
	public WebElement extensionLink;

	// Edwiser Courses Admin Menu
	@FindBy(xpath = "//*[@id='toplevel_page_edwiserbridge_lms']//a[text()='Courses']")
	public WebElement coursesMenu;

	// Edwiser Course Categories Admin Menu
	@FindBy(xpath = "//*[@id='toplevel_page_edwiserbridge_lms']//a[text()='Course Categories']")
	public WebElement courseCategoriesMenu;

	// Edwiser Orders Admin Menu
	@FindBy(xpath = "//*[@id='toplevel_page_edwiserbridge_lms']//a[text()='Orders']")
	public WebElement ordersMenu;

	// Edwiser Settings Admin Menu
	@FindBy(xpath = "//*[@id='toplevel_page_edwiserbridge_lms']//a[text()='Settings']")
	public WebElement settingsMenu;

	// Edwiser Manage Email Templates Admin Menu
	@FindBy(xpath = "//*[@id='toplevel_page_edwiserbridge_lms']//a[text()='Manage Email Templates']")
	public WebElement manageEmailTemplatesMenu;

	// Edwiser Manage Enrollment Admin Menu
	@FindBy(xpath = "//*[@id='toplevel_page_edwiserbridge_lms']//a[text()='Manage Enrollment']")
	public WebElement manageEnrollmentMenu;

	// Edwiser Extensions Admin Menu
	@FindBy(xpath = "//*[@id='toplevel_page_edwiserbridge_lms']//a[text()='Extensions']")
	public WebElement extensionsMenu;

	// Edwiser Help Admin Menu
	@FindBy(xpath = "//*[@id='toplevel_page_edwiserbridge_lms']//div[text()='Help']/..")
	public WebElement helpMenu;

	// Extensions Page Browse all extensions Link
	@FindBy(xpath = "//a[contains(text(),'Browse all extensions')]")
	public WebElement browseAllExtensions;

	// Extensions Page Browse All Our extensions Link
	@FindBy(xpath = "//a[@class='browse-all']")
	public WebElement browseAllOurExtensions;

	// All Extensions List
	@FindBy(xpath = "//ul[@class='extensions']//li")
	public List<WebElement> allExtensionsList;

	// Rate Us Link
	@FindBy(xpath = "//*[@class='eb_settings_rate_btn_wrap']/a")
	public WebElement RateUsLink;

	// Get Help Link
	@FindBy(xpath = "//*[@class='eb_settings_help_btn_wrap']/button")
	public WebElement GetHelpLink;

	// Edwiser Bridge Documentation Link
	@FindBy(xpath = "//*[@class='eb-setting-help-accordion']//a[text()=' Edwiser Bridge']")
	public WebElement ebDocumentation;

	// Help FAQ Link
	@FindBy(xpath = "//*[@class='eb-setting-help-accordion']//div[2]/a")
	public WebElement helpFAQ;

	// Help Contact Us (Chat) Link
	@FindBy(xpath = "//*[@class='eb-setting-help-accordion']//div[3]/a")
	public WebElement chatWithUs;

	/**
	 * Visit Edwiser Bridge General Settings
	 * 
	 * @param baseURL
	 */
	public void visitInstructorSettings(String baseURL) {
		driver.get(baseURL + "wp-admin/admin.php?page=instuctor");
	}

	/**
	 * Test Connection Settings
	 * 
	 * @param baseURL
	 */
	public String testConnectionSettings(String moodleSiteURL, String moodleToken) {
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Visit Connection Settings
//		connectionSettings.click();

		// Wait For Moodle URL Field Visible
		wait.until(ExpectedConditions.visibilityOf(moodleUrl));

		// Fill Moodle URL
		moodleUrl.clear();
		moodleUrl.sendKeys(moodleSiteURL);

		// Fill Moodle Token
		moodleAccessToken.clear();
		moodleAccessToken.sendKeys(moodleToken);

		// Click Test Connection Button
		testConnection.click();

		// Wait For Response
		wait.until(ExpectedConditions.visibilityOf(connectionResponse));

		// Return Response Message
		return connectionResponse.getText();

	}

	/**
	 * Test Connection Settings
	 * 
	 * @param baseURL
	 */
	public String courseSynchronizationSettings(boolean courseCategory, boolean update, boolean draft) {
		wait = new WebDriverWait(driver, null);

		// Wait For Setting Visible
//		wait.until(ExpectedConditions.elementToBeClickable(synchronizationSettings));

		// Visit Synchronization Settings
//		synchronizationSettings.click();

		// Wait For Course tab Visibility
		wait.until(ExpectedConditions.visibilityOf(coursesTab));

		// Synchronize Categories
		if (courseCategory) {
			if (!synchronizeCategories.isSelected()) {
				synchronizeCategories.click();
			}
		} else if (synchronizeCategories.isSelected()) {
			synchronizeCategories.click();
		}

		// Update Synchronized Courses
		if (update) {
			if (!synchronizePrevious.isSelected()) {
				synchronizePrevious.click();
			}
		} else if (synchronizePrevious.isSelected()) {
			synchronizePrevious.click();
		}

		// Make Synchronized Courses as Draft
		if (draft) {
			if (!synchronizeDraft.isSelected()) {
				synchronizeDraft.click();
			}
		} else if (synchronizeDraft.isSelected()) {
			synchronizeDraft.click();
		}

		// Click Start Synchronization Button
		startCourseSynchronization.click();

		// Wait For Response
		wait.until(ExpectedConditions.visibilityOf(connectionResponse));

		// Return Response Message
		return connectionResponse.getText();
	}

	/* Enrollment Management Page */

	// Bulk Action Select
	public Select bulkActionsSelect() {
		return new Select(bulkActions);
	}

	// Bulk Actions Select
	@FindBy(id = "bulk-action-selector-top")
	public WebElement bulkActions;

	// List of Course Links on Product Listing Page
	@FindBy(xpath = "//tbody[@id='the-list']//*[@data-colname='User']")
	public List<WebElement> allCoursessLinksListingPage;

	// Select All From Listing Page
	@FindBy(id = "cb-select-all-1")
	public WebElement selectAllFromListing;

	@FindBy(id = "doaction")
	public WebElement bulkActionsApply;

	// Admin Notice
	@FindBy(xpath = "//*[contains(@class,'notice')]/p/strong")
	public WebElement EnrollmentPageAdminNotice;

	public WebElement UserCourseUnEnrollmentRow(String UserName, String Course) {
		return driver.findElement(By.xpath("//td[contains(@class,'column-user')]/a[text()='" + UserName
				+ "']/../..//td[contains(@class,'column-course')]/a[text()='" + Course
				+ "']/../..//a[text()='Unenroll']"));
	}

	/**
	 * Delete
	 */
	public void deleteEnrollments(String baseURL) {

		driver.get(baseURL + "wp-admin/admin.php?page=mucp-manage-enrollment");

		if (allCoursessLinksListingPage.size() > 0) {

			// Select All Course
			selectAllFromListing.click();
			// Select Trash From Bulk Actions
			bulkActionsSelect().selectByValue("unenroll");
			// Apply
			bulkActionsApply.click();

		}
	}

}
