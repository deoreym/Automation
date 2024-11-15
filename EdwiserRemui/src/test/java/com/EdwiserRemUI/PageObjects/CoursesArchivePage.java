package com.EdwiserRemUI.PageObjects;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CoursesArchivePage extends BasePage {

	public CoursesArchivePage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//ul[@role='tablist']//li//a[text()='Course Page']")
	public WebElement coursepagemenu;

	@FindBy(xpath = "//select[@id='id_s_theme_remui_courseperpage']")
	public WebElement courseselectcount;

	@FindBy(id = "id_s_theme_remui_courseanimation")
	public WebElement courseanimation;

	@FindBy(xpath = "//button[@class='btn btn-primary']")
	public WebElement savechanges;

	// Course Cards Container
	@FindBy(xpath = "//div[contains(@class,'course-cards')]")
	public WebElement CourseCardsFrame;
	// Card View : grid-view edw-course-card-grid
	// List View : list-view list-group edw-course-list-container
	// Summary View : summary-view edw-course-summary-container
	
	// Course Summary Description
	@FindBy(xpath = "(//p[contains(@class,'coursesummary ')])[1]")
	public WebElement CourseSummary;
	

	@FindBy(xpath = "//div[contains(@class,'course-cards')]/*")
	public List<WebElement> CourseCards;

	@FindBy(xpath = "//span[@class='edw-icon edw-icon-Card-View']")
	public WebElement CardViewIcon;

	@FindBy(xpath = "//span[@class='edw-icon edw-icon-List-View-08']")
	public WebElement ListViewIcon;

	@FindBy(xpath = "//span[@class='edw-icon edw-icon-Topic-View']")
	public WebElement SummaryViewIcon;

	@FindBy(xpath = "//div[contains(@class,'enrolled-users-count')]")
	public List<WebElement> EnrolledUserOptionList;

	@FindBy(xpath = "(//div[contains(@class,'enrolled-users-count')])[1]")
	public WebElement EnrolledUserOption;

	@FindBy(xpath = "(//div[contains(@class,'enrolled-users-count')])[1]//span[2]")
	public WebElement EnrolledUserOptionText;

	@FindBy(xpath = "//div[contains(@class,'lesson-count')]")
	public List<WebElement> LessonsOptionList;

	@FindBy(xpath = "(//div[contains(@class,'lesson-count')])[1]")
	public WebElement LessonsOption;

	@FindBy(xpath = "(//div[contains(@class,'lesson-count')])[1]//span[2]")
	public WebElement LessonsOptionText;

	@FindBy(xpath = "//div[contains(@class,'updated-date')]")
	public List<WebElement> UpdatedDateOptionList;

	@FindBy(xpath = "(//div[contains(@class,'updated-date')])[1]")
	public WebElement UpdatedDateOption;

	@FindBy(xpath = "//input[@aria-label='Search courses']")
	public WebElement Search_Courses;

	@FindBy(xpath = "//input[@aria-label='Search courses']/..//span[contains(@class,'edw-icon-Search')]")
	public WebElement Search_Courses_Icon;

	@FindBy(xpath = "//div[contains(@class,'categoryfiltermenu')]//button[@id='dropdownMenuButton']")
	public WebElement CategoryFilter;

	@FindBy(xpath = "(//div[contains(@class,'categoryfiltermenu')]//a[contains(@class,'category-link')])[2]")
	public WebElement FirstCategoryFromFilter;

	@FindBy(xpath = "(//button[contains(@class,'sortfilter')])[1]")
	public WebElement SortingFilter;

	@FindBy(xpath = "(//span[contains(@class,'categoryname')])[1]")
	public WebElement CourseCard_Category_Name;

	@FindBy(xpath = "//a[contains(@class,'coursename')]")
	public WebElement CourseCard_Course_Name;

	@FindBy(xpath = "//a[contains(@class,'view-course-btn')]")
	public WebElement CourseCard_ViewCourse_Button;

	// Course Settings
	@FindBy(xpath = "//a[@href='#theme_remui_course']")
	public WebElement RemUICourseSettings;

	// Show ‘Date’ on the course DropDown
	@FindBy(id = "id_s_theme_remui_coursedatevisibility")
	public WebElement ShowDate;

	// Show ‘Enrolled students’ information : Checkbox
	@FindBy(id = "id_s_theme_remui_enrolleduserscountvisibility")
	public WebElement EnrolledStudentsVisibilityCheckbox;

	@FindBy(xpath = "//input[@id='id_s_theme_remui_enrolleduserscountvisibility']/..")
	public WebElement EnrolledStudentsVisibility;

	// Show ‘Enrolled students’ information : Text Imput
	@FindBy(id = "id_s_theme_remui_showenrolledtextinput")
	public WebElement EnrolledStudentsText;

	// Show ‘Lessons’ information : Checkbox
	@FindBy(id = "id_s_theme_remui_lessonsvisiblityoncoursecard")
	public WebElement LessonsVisibilityCheckbox;

	@FindBy(xpath = "//input[@id='id_s_theme_remui_lessonsvisiblityoncoursecard']/..")
	public WebElement LessonsVisibility;

	// Show ‘Lessons’ information : Text Input
	@FindBy(id = "id_s_theme_remui_showlessontextinput")
	public WebElement LessonsVisibilityText;

	/*** OLD ***/

	@FindBy(id = "next-activity-link")
	public List<WebElement> nextactivity;

	@FindBy(xpath = "//ul[@class='topics']//li[@id='section-0']//div//ul//li[2]//span[@class='instancename']")
	public WebElement clickonanyactivity;

	@FindBy(xpath = "//ul[@class='topics']//li[@id='section-0']//div//ul//li[1]//span[@class='instancename']")
	WebElement prevactivityname;

	@FindBy(xpath = "//ul[@class='topics']//li[@id='section-0']//div//ul//li[3]//span[@class='instancename']")
	WebElement nextactivityname;

	@FindBy(xpath = "(//a[@id='prev-activity-link'])[1]")
	public WebElement prevactivitynameap;

	@FindBy(xpath = "(//a[@id='next-activity-link'])[1]")
	public WebElement nextactivitynameap;

	@FindBy(xpath = "//h1[@class='h2 header-heading']")
	public WebElement activitytitle;

	// Header Category
	@FindBy(xpath = "//*[@class='category']//div")
	public WebElement CourseCategory;

	// Course Settings Tab
	@FindBy(xpath = "//li[@title='Settings']/a")
	public WebElement CourseSettings;

	// REMUI Custom Fields Accordion
	@FindBy(xpath = "//*[contains(text(),'RemUI Custom Fields')]/../a")
	public WebElement RemUI_CF;

	// Course Duration in Hours
	@FindBy(id = "id_customfield_edwcoursedurationinhours")
	public WebElement Duration;

	// Course Intro Video Url (Embedded)
	@FindBy(id = "id_customfield_edwcourseintrovideourlembedded")
	public WebElement IntroVideo;

	// Skill Level
	@FindBy(id = "id_customfield_edwskilllevel")
	public WebElement Skill_Level;

	// Course Summary - Take Attribute "data-initial-value" for value coparison on
	// Overview Page
	@FindBy(id = "id_summary_editor")
	public WebElement Course_Summary;

	// Start Date - DAY
	@FindBy(id = "id_startdate_day")
	public WebElement StartDate_Day;

	// Start Date - Month
	@FindBy(id = "id_startdate_month")
	public WebElement StartDate_Month;

	// Start Date - Year
	@FindBy(id = "id_startdate_year")
	public WebElement StartDate_Year;

	// Enrolled Student Count
	@FindBy(xpath = "//*[contains(@class,'stats-enrolledusers')]")
	public WebElement EnrolledStudents;

	// Save and display
	@FindBy(id = "id_saveanddisplay")
	public WebElement Save_and_Display;

	public String getprevactivityname() {
		String actnameprev1 = prevactivityname.getAttribute("data-activityname");
		String actnameprev = actnameprev1.replaceAll("\\s", "");
		return actnameprev;
	}

	public String getpreviousactivitynameap() {
		String prevactap1 = prevactivitynameap.getText();
		String prevactap = prevactap1.replaceAll("\\s", "");
		return prevactap;
	}

	public String getnextactivityname() {
		String actnamenext1 = nextactivityname.getAttribute("data-activityname");
		String actnamenext = actnamenext1.replaceAll("\\s", "");
		return actnamenext;
	}

	public String getnextactivitynameap() {
		String nextactap1 = nextactivitynameap.getText();
		String nextactap = nextactap1.replaceAll("\\s", "");
		return nextactap;
	}
	
	//inner html of course count from course and category page
	 @FindBy(xpath="//span[@class='course-count text-muted']/span[1]")
	    public List<WebElement> coursescountfrommoodle;
	 
	//Remui custum field link
	 @FindBy(xpath="//a[@id='collapseElement-8']")
	 public WebElement customfieldlink;
	 
	 //Skill tag on course card
	 @FindBy(xpath="//p[@class='skilltag m-0 badge badge-light']")
	 public WebElement Beginner_tag;
	 
	//Skill tag on course card
	 @FindBy(xpath="//p[@class='skilltag m-0 badge badge-info']")
	 public WebElement intermediate_tag;
		 
	//Skill tag on course card
	 @FindBy(xpath="//p[@class='skilltag m-0 badge badge-warning']")
	 public WebElement advanced_tag;
	
	// Extract the list of items
    @FindBy(xpath="//a[@class='coursename text-decoration-none ellipsis ellipsis-3 h-semibold-6']")
    public List<WebElement> coursename;
    
    //Next page button visibility
    @FindBy(xpath="//a[@aria-label='Next page']")
    public List<WebElement>  Next_page_buttons;
    
    //Next page button 
    @FindBy(xpath="//a[@aria-label='Next page']")
    public WebElement  Next_page_button;
    
    //sorting dropdown
    @FindBy(xpath="//div[@id='course-archive-main-container']//div//div[@class='btn-group edw-custom-dropdown-wrapper course-shorting']")
    public WebElement sorting_dd;
    
    //ASC sorting link
    @FindBy(xpath="//div[@class='p-py-2d5 d-flex flex-column flex-gap-d5 select-optgroup-wrapper']//div//p[@title='A to Z']")
    public WebElement ASC_Sorting;
    
    //DSC sorting link
    @FindBy(xpath="//div[@class='p-py-2d5 d-flex flex-column flex-gap-d5 select-optgroup-wrapper']//div//p[@title='Z to A']")
    public WebElement DSC_Sorting;
    
    
        
    
}
