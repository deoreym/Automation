package com.EdwiserRemUI.PageObjects;

import java.util.List;
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

	@FindBy(xpath = "//div[contains(@class,'course-cards')]")
	public WebElement CourseCardsFrame;

	@FindBy(xpath = "//div[contains(@class,'course-cards')]/*")
	public WebElement CourseCards;

	@FindBy(xpath = "//span[@class='edw-icon edw-icon-Card-View']")
	public WebElement CardViewIcon;

	@FindBy(xpath = "//span[@class='edw-icon edw-icon-List-View-08']")
	public WebElement ListViewIcon;

	@FindBy(xpath = "edw-icon edw-icon-Topic-View")
	public WebElement SummaryViewIcon;

	@FindBy(xpath = "(//div[contains(@class,'enrolled-users-count')])[1]")
	public List<WebElement> EnrolledUserOptionList;

	@FindBy(xpath = "(//div[contains(@class,'enrolled-users-count')])[1]")
	public WebElement EnrolledUserOption;

	@FindBy(xpath = "(//div[contains(@class,'lesson-count')])[1]")
	public List<WebElement> LessonsOptionList;

	@FindBy(xpath = "(//div[contains(@class,'lesson-count')])[1]")
	public WebElement LessonsOption;

	@FindBy(xpath = "(//div[contains(@class,'updated-date')])[1]")
	public List<WebElement> UpdatedDateOptionList;

	@FindBy(xpath = "(//div[contains(@class,'updated-date')])[1]")
	public WebElement UpdatedDateOption;

	@FindBy(xpath = "//input[@aria-label='Search courses']")
	public WebElement Search_Courses;

	@FindBy(xpath = "(//button[contains(@class,'categoryfilter')])[1]")
	public WebElement CategoryFilter;

	@FindBy(xpath = "(//button[contains(@class,'sortfilter')])[1]")
	public WebElement SortingFilter;

	@FindBy(xpath = "//span[contains(@class,'categoryname')]")
	public WebElement CourseCard_Category_Name;

	@FindBy(xpath = "//a[contains(@class,'coursename')]")
	public WebElement CourseCard_Course_Name;

	@FindBy(xpath = "//a[contains(@class,'view-course-btn')]")
	public WebElement CourseCard_ViewCourse_Button;

	
	
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
}
