package pageClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FCC_Course {

	WebDriver driver;
	WebDriverWait wait;

	// Constructor
	public FCC_Course(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Visit Courses List
	public void Visit_Courses_List(String BaseURL) {
		driver.get(BaseURL + "wp-admin/edit.php?post_type=sfwd-courses");
	}

	// Add New Course via Frontend Course Creator Button
	@FindBy(id = "ir-fcb-create-new")
	public WebElement Add_New_FCC_Course;

	// Course Page Tab
	@FindBy(xpath = "//button[contains(@id,'ir-course-page')]")
	public WebElement Course_CoursePage_Tab;
	// Course Builder Tab
	@FindBy(xpath = "//button[contains(@id,'ir-builder')]")
	public WebElement Course_Builder_Tab;
	// Course Settings Tab
	@FindBy(xpath = "//button[contains(@id,'ir-settings')]")
	public WebElement Course_Settings_Tab;
	// Course Group Tab
	@FindBy(xpath = "//button[contains(@id,'ir-group-settings')]")
	public WebElement Course_Group_Tab;

	/**
	 * Course Page Tab
	 */
	// Course Title Input
	@FindBy(xpath = "//label[text()='Course Title']/..//input")
	public WebElement Course_Title_Input;

	// Course Page Container
	@FindBy(xpath = "//div[contains(@class,'ir-fed-course-page')]")
	public WebElement Course_Page;

	// Course Publish Button
	@FindBy(xpath = "//button[contains(@class,'ir-publish')]")
	public WebElement Course_Publish_Button;

	// Course Published Text
	@FindBy(xpath = "//div[text()='Congratulations your Course is published!']")
	public List<WebElement> Course_Published_Text;

	// Author Accordion
	@FindBy(id = "mantine-r5-control-course-author")
	public WebElement Author_Accordion;

	// Author List
	@FindBy(xpath = "//button[@id='mantine-r5-control-course-author']/..//input[@type='search']")
	public WebElement Author_List;

	// Tag Accordion
	@FindBy(xpath = "//button[contains(@id,'ld_course_tag')]")
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
	@FindBy(xpath = "//button[contains(@id,'ld_course_category')]")
	public WebElement CategoryAccordion;

	// Description iFrame ID = ir-content-editor_ifr

	/**
	 * Course Groups Tab
	 */
	// Search Groups Input
	@FindBy(xpath = "//input[@placeholder='Search all Groups']")
	public WebElement Search_Group;

	// Select Group
	public WebElement SelectGroup(String Group) {
		return driver.findElement(By.xpath("//label[text()='" + Group + "']/../../.."));
	}

	/**
	 * Settings Tab
	 */
	@FindBy(xpath = "//button[contains(@id,'course-access-settings')]")
	public WebElement CourseAccessSettingAcco;

	@FindBy(xpath = "//button[contains(@id,'course-navigation-settings')]")
	public WebElement CourseNavigationSettingAcco;

	@FindBy(xpath = "//button[contains(@id,'control-display-and-content-options')]")
	public WebElement CourseDispContentOptionAcco;

	@FindBy(id = "//button[contains(@id,'course-user')]")
	public WebElement CourseUsersAcco;

	@FindBy(id = "//button[contains(@id,'course-sharing')]")
	public WebElement SharedCourseSettingAcco;

	/**
	 * * * * * * * * * * Course Access Setting Accordion * * * * * * * * * *
	 */
	@FindBy(xpath = "//input[@value='open']")
	public WebElement CP_Open;
	@FindBy(xpath = "//input[@value='free']")
	public WebElement CP_Free;
	@FindBy(xpath = "//input[@value='paynow']")
	public WebElement CP_BuyNow;
	@FindBy(xpath = "//input[@value='subscribe']")
	public WebElement CP_Recurring;
	@FindBy(xpath = "//input[@value='closed']")
	public WebElement CP_Closed;

	// Course Prerequisties
	@FindBy(xpath = "//*[text()='Course prerequisties']/../..//label[contains(@class,'mantine-Switch-track')]")
	public WebElement CoursePrerequistiesSlider;

	// Prerequisite Any Selected
	@FindBy(xpath = "//input[@value='ANY']")
	public WebElement PrerequisiteAnySelected;
	// Prerequisite All Selected
	@FindBy(xpath = "//input[@value='ALL']")
	public WebElement PrerequisiteAllSelected;

	// Search Prerequisite Course
	@FindBy(xpath = "//input[@placeholder='Select a Course']")
	public WebElement Search_Pre_Course;

	// Select Prerequisite Course
	public WebElement SelectPreCourse(String Course) {
		return driver.findElement(By.xpath("//div[text()='" + Course + "']"));
	}

	// Course Points
	@FindBy(xpath = "//*[text()='Course points']/../..//label[contains(@class,'mantine-Switch-track')]")
	public WebElement CoursePointsSlider;

	// Points Required for access
	@FindBy(xpath = "//div[text()='Required for access']/..//input")
	public WebElement PointsForAccess;

	// Points Awarded on completion
	@FindBy(xpath = "//div[text()='Awarded on completion']/..//input")
	public WebElement PointsOnCompletion;

	// Course Access Expiration
	@FindBy(xpath = "//*[text()='Course access expiration']/../..//label[contains(@class,'mantine-Switch-track')]")
	public WebElement CourseAccessExpirationSlider;

	// Access Period
	@FindBy(xpath = "//div[text()='Access Period']/..//input")
	public WebElement Access_Period;

	// Course Data Deletion
	@FindBy(xpath = "//*[text()='Data deletion']/../..//label[contains(@class,'mantine-Switch-track')]")
	public WebElement dataDeletion;

	/**
	 * * * * * * * * Course Navigation Setting Accordion * * * * * * * *
	 */

	// Course Progression Linear
	@FindBy(xpath = "//div[text()='Course Progression']/..//input[@value='linear']")
	public WebElement CP_Linear;

	// Course Progression Free Form
	@FindBy(xpath = "//div[text()='Course Progression']/..//input[@value='free']")
	public WebElement CP_FreeForm;

	/**
	 * * * * * * * * Display and Content Options Accordion * * * * * * * *
	 */

	// Search Cerificate for Course
	@FindBy(xpath = "//input[@placeholder='Select a certificates']")
	public WebElement SearchCertificates;

	// Select Certificate Course
	public WebElement SelectCertificate(String Certificate) {
		return driver.findElement(By.xpath("//div[text()='" + Certificate + "']"));
	}

	// Course content visibility - Always visible
	@FindBy(xpath = "//input[@value='visible']")
	public WebElement Always_visible;

	// Course content visibility - Only visible to enrollees
	@FindBy(xpath = "//input[@value='enrollees']")
	public WebElement Only_visible_to_enrollees;

	// Course Custom Pagination Switch
	@FindBy(xpath = "//*[text()='Custom Pagination']/../../label[contains(@class,'mantine-Switch-track')]")
	public WebElement CustomPaginationSwitch;

	// 
	@FindBy(xpath = "//*[text()='Course Material']/../..//label[contains(@class,'mantine-Switch-track')][1]")
	public WebElement CourseMaterialSwitch;
	
	// Custom Pagination - Lessons Per Page
	@FindBy(xpath = "//div[text()='Lessons']/..//input")
	public WebElement Lessons_PP;
	
	// Custom Pagination - Topics Per Page
	@FindBy(xpath = "//div[text()='Topics']/..//input")
	public WebElement Topics_PP;

}
