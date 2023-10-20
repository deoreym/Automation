package pageClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FCC_Course_Builder_POM {

	WebDriver driver;
	WebDriverWait wait;

	// Constructor
	public FCC_Course_Builder_POM(WebDriver driver) {
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

	/**
	 * Builder Tab
	 */
	// Add New Section Button
	@FindBy(xpath = "//Button//span[text()='Add New Section']")
	public WebElement AddNewSection;

	// Add New Lesson Button
	@FindBy(xpath = "//Button//span[text()='Add New Lesson']")
	public WebElement AddNewLesson;

	// Add New Topic Button
	@FindBy(xpath = "(//Button//span[text()='Add New Topic'])[1]")
	public WebElement AddNewTopic;

	// Add New Quiz Button
	@FindBy(xpath = "(//Button//span[text()='Add New Quiz'])[1]")
	public WebElement AddNewQuiz;
	@FindBy(xpath = "(//Button//span[text()='Add New Quiz'])[1]")
	public WebElement AddNewQuiz1;

	// Add Section Name Input
	@FindBy(xpath = "//input[@placeholder='Add section name here']")
	public WebElement Add_Section_name;

	// Add Section Button
	@FindBy(xpath = "//input[@placeholder='Add section name here']/../../../button")
	public WebElement Add_Button_For_Section;

	// Find Section
	public List<WebElement> CheckSection(String SectionName) {
		return driver.findElements(By.xpath("//div[text()='" + SectionName + "']"));
	}

	// Exisitng Lessons Accordion
	@FindBy(xpath = "//button[contains(@id,'ir_other_lessons')]")
	public WebElement LessonsAccordion;
	// Exisitng Topics Accordion
	@FindBy(xpath = "//button[contains(@id,'ir_other_topics')]")
	public WebElement TopicsAccordion;
	// Exisitng Quizzes Accordion
	@FindBy(xpath = "//button[contains(@id,'ir_other_quizzes')]")
	public WebElement QuizzesAccordion;

	// Search Exisitng Lessons
	@FindBy(xpath = "//input[@placeholder='Search Lessons']")
	public WebElement SearchLessons;
	// Search Exisitng Topics
	@FindBy(xpath = "//input[@placeholder='Search Topics']")
	public WebElement SearchTopics;
	// Search Exisitng Quizzes
	@FindBy(xpath = "//input[@placeholder='Search Quizzes']")
	public WebElement SearchQuizzes;

	// Add Button for Searched Lesson Topic and Quiz
	public WebElement SearchedItem(String Name) {
		return driver.findElement(By.xpath("//label[text()='" + Name + "']"));
	}

	// Add Button for Searched Lesson Topic and Quiz
	public WebElement AddButton(String Name) {
		return driver.findElement(By.xpath("//label[text()='" + Name + "']/../../../..//span[text()='Add']"));
	}

	// Added Lesson Topic and Quiz to Course
	public int FindAddedContent(String Name) {
		return driver.findElements(By.xpath("//div[text()='" + Name + "']")).size();
	}

	// Remove Quiz
	@FindBy(xpath = "//div[contains(@class,'ir-sortable-quizzes')]//*[contains(@class,'icon-tabler-x')]")
	public WebElement RemoveQuizIcon;

	// Remove Topic
	@FindBy(xpath = "//div[contains(@class,'ir-sortable-topics')]//*[contains(@class,'icon-tabler-x')]")
	public WebElement RemoveTopicIcon;

	// Remove Lesson
	@FindBy(xpath = "//div[contains(@class,'ir-lessons-left')]//*[contains(@class,'icon-tabler-x')]")
	public WebElement RemoveLessonIcon;

	// Remove Button
	@FindBy(xpath = "//button//span[text()='Remove']")
	public WebElement RemoveButton;

	// Trash Button
	@FindBy(xpath = "//button//span[text()='Trash']")
	public WebElement TrashButton;

	// Edit Quiz
	@FindBy(xpath = "//div[contains(@class,'ir-sortable-quizzes')]//*[contains(@class,'icon-tabler-pencil-minus')]")
	public WebElement EditQuizIcon;

	// Edit Topic
	@FindBy(xpath = "//div[contains(@class,'ir-sortable-topics')]//*[contains(@class,'icon-tabler-pencil-minus')]")
	public WebElement EditTopicIcon;

	// Edit Lesson
	@FindBy(xpath = "//div[contains(@class,'ir-lessons-left')]//*[contains(@class,'icon-tabler-pencil-minus')]")
	public WebElement EditLessonIcon;

	// Expand All Course Steps
	@FindBy(xpath = "//span[text()='Expand All']")
	public WebElement ExpandAll;

	// Collapse All Course Steps
	@FindBy(xpath = "//span[text()='Collapse All']")
	public WebElement CollapseAll;

	/**
	 * Lesson modal
	 */
	// Mantin Modal Title Input
	@FindBy(xpath = "//div[contains(@class,'mantine-Modal-inner')]//input[@placeholder='Write title here']")
	public WebElement Title_Input;

	// Content Tab
	@FindBy(xpath = "//button[contains(@id,'tab-Content')]")
	public WebElement Content_Tab;
	// Material Tab
	@FindBy(xpath = "//button[contains(@id,'tab-Material')]")
	public WebElement Material_Tab;
	// Settings Tab
	@FindBy(xpath = "//button[contains(@id,'tab-settings')]")
	public WebElement Settings_Tab;

	/**
	 * Video Progression
	 */
	// Video Progression Switch
	@FindBy(xpath = "//button[contains(@id,'video_enabled')]")
	public WebElement Video_Progression;

	// Video URL
	@FindBy(xpath = "//input[@placeholder='Enter your video link/URL here']")
	public WebElement Video_URL;

	// Display Timing - BEFORE
	@FindBy(xpath = "//input[@value='BEFORE']")
	public WebElement Display_Timing_BEFORE;

	// Display Timing - AFTER
	@FindBy(xpath = "//input[@value='AFTER']")
	public WebElement Display_Timing_AFTER;

	// Lesson Auto Complete
	@FindBy(xpath = "//*[text()='Lesson auto-completion']/..//label[contains(@class,'mantine-Switch-track')]")
	public WebElement Lesson_Auto_Complete;
	
	// Topic Auto Complete
		@FindBy(xpath = "//*[text()='Topic auto-completion']/..//label[contains(@class,'mantine-Switch-track')]")
		public WebElement Topic_Auto_Complete;

	// Completion delay Input
	@FindBy(xpath = "//*[text()='Completion delay']/..//input")
	public WebElement Completion_delay;

	// Mark Complete Button
	@FindBy(xpath = "//*[text()='Mark Complete Button']/..//label[contains(@class,'mantine-Switch-track')]")
	public WebElement Mark_Complete_Button;

	// Autostart
	@FindBy(xpath = "//*[text()='Autostart']/../..//label[contains(@class,'mantine-Switch-track')]")
	public WebElement Autostart;

	// Video Controls Display
	@FindBy(xpath = "//*[text()='Video Controls Display']/../..//label[contains(@class,'mantine-Switch-track')]")
	public WebElement Video_Controls_Display;

	// Video Pause on Window Unfocused
	@FindBy(xpath = "//*[text()='Video Pause on Window Unfocused']/../..//label[contains(@class,'mantine-Switch-track')]")
	public WebElement Video_Unfocused;

	// Video resume
	@FindBy(xpath = "//*[text()='Video resume']/../..//label[contains(@class,'mantine-Switch-track')]")
	public WebElement Video_Resume;

	/**
	 * Assignment Upload
	 */

	// Assignment Upload Switch
	@FindBy(xpath = "//button[contains(@id,'assignment_upload_enabled')]")
	public WebElement Assignment_Upload;

	// File Extensions
	@FindBy(xpath = "//*[text()='File Extensions']/..//input")
	public WebElement File_Extensions;

	// File Size Limit
	@FindBy(xpath = "//*[text()='File Size Limit']/..//input")
	public WebElement File_Size;

	// Points Switch
	@FindBy(xpath = "//*[text()='Points']/../..//label[contains(@class,'mantine-Switch-track')]")
	public WebElement Points_Switch;

	// Points
	@FindBy(xpath = "//*[text()='available point(s)']/..//input")
	public WebElement Points;

	// Auto_Aprove_Grading
	@FindBy(xpath = "//input[@value='auto_approve']")
	public WebElement Auto_Aprove_Grading;

	// Manual Grading
	@FindBy(xpath = "//input[@value='manual_grade']")
	public WebElement Manual_Grading;

	// Number Of Files
	@FindBy(xpath = "//*[text()='Limit number of uploaded files']/..//input")
	public WebElement Number_Of_Files;

	// Allow File Deletion
	@FindBy(xpath = "//*[text()='Allow file deletion']/../..//label[contains(@class,'mantine-Switch-track')]")
	public WebElement Allow_File_Deletion;

	/**
	 * Timer
	 */

	// Timer Switch
	@FindBy(xpath = "//button[contains(@id,'timer_enabled')]")
	public WebElement Timer;

	// Timer Hours
	@FindBy(xpath = "//button[contains(@id,'timer_enabled')]/../..//input[@placeholder='HH']")
	public WebElement Hours;

	// Timer Minutes
	@FindBy(xpath = "//button[contains(@id,'timer_enabled')]/../..//input[@placeholder='MM']")
	public WebElement Minutes;

	// Timer Seconds
	@FindBy(xpath = "//button[contains(@id,'timer_enabled')]/../..//input[@placeholder='SS']")
	public WebElement Seconds;

	// Check If Section is Expanded
	public boolean checkSwitch(WebElement e) {
		if (e.getAttribute("aria-expanded").equals("false")) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Extra
	 */

	// Lesson Tag Accordion
	@FindBy(xpath = "//button[contains(@id,'ld_lesson_tag')]")
	public WebElement LessonTagAccordion;
	// Lesson Category Accordion
	@FindBy(xpath = "//button[contains(@id,'ld_lesson_category')]")
	public WebElement LessonCategoryAccordion;

	// Topic Tag Accordion
	@FindBy(xpath = "//button[contains(@id,'ld_topic_tag')]")
	public WebElement TopicTagAccordion;

	// Topic Category Accordion
	@FindBy(xpath = "//button[contains(@id,'ld_topic_category')]")
	public WebElement TopicCategoryAccordion;

	// Permalink Accordion
	@FindBy(xpath = "//button[contains(@id,'control-permalink')]")
	public WebElement permalinkAccordion;

	// Permalink Slug Input
	@FindBy(xpath = "//label[text()='URL Slug ']/..//input")
	public WebElement permalinkInput;

	// Search Tag input
	@FindBy(xpath = "//input[@placeholder='Select items']")
	public WebElement SearchTag;
	
	// Search Tag input -Lesson
		@FindBy(xpath = "//button[contains(@id,'ld_lesson_tag')]/..//input[@placeholder='Select items']")
		public WebElement Lesson_SearchTag;
		
		// Search Tag input -Topic
		@FindBy(xpath = "//button[contains(@id,'ld_topic_tag')]/..//input[@placeholder='Select items']")
		public WebElement Topic_SearchTag;
		

	// Select Tag
	public WebElement SelectTag(String TagName) {
		return driver.findElement(
				By.xpath("//div[contains(@class,'mantine-MultiSelect-item') and text()='" + TagName + "']"));
	}

	// Select Category
	public WebElement SelectCategory(String Category) {
		return driver.findElement(By.xpath("//label[text()='" + Category + "']"));
	}

	// View Lesson
	@FindBy(xpath = "//span[text()='View Lesson']")
	public WebElement ViewLesson;

	// Switch To Draft
	@FindBy(xpath = "//span[text()='Switch to draft']")
	public WebElement Switch_To_Draft;

	// Save To Draft
	@FindBy(xpath = "//span[text()='Save to draft']")
	public WebElement Save_To_Draft;

	// Publish / Update button	
	@FindBy(xpath = "//button[@type='submit']//span[text()='Publish']")
	public WebElement publish;

	/**
	 * Settings Tab
	 * 
	 */
	// Sample Lesson
	@FindBy(xpath = "//*[text()='Sample Lesson']/../../label[contains(@class,'mantine-Switch-track')]")
	public WebElement SampleLesson;
	
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
	
	// Specific Date - Month 	//div[text()='Jan']
	public WebElement Specific_Date_Month(String M) {
		return driver.findElement(By.xpath("//div[text()='"+M+"']"));
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
	@FindBy(xpath = "//input[@placeholder='MN']")
	public WebElement Specific_Date_Minute;
	
// Lesson Published Note
	@FindBy(xpath="//div[contains(text(),'Your lesson is successfully published and live now')]")
	public List<WebElement> LessonPublished;
	
	// Topic Published Note
		@FindBy(xpath="//div[contains(text(),'Your topic is successfully published and live now')]")
		public List<WebElement> TopicPublished;
	
	
}
