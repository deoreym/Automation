package com.EdwiserRemUI.PageObjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CoursePage extends BasePage {

	public CoursePage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//li[contains(@title,'Site administration')]//a[contains(@role,'menuitem')]")
	WebElement clicksiteadmin;

	@FindBy(xpath = "//a[normalize-space()='Appearance']")
	WebElement clickappearence;

	@FindBy(xpath = "//div[@id='linkappearance']//div[2]//div[2]//ul[1]//li[5]//a[1]")
	WebElement clickremui;

	@FindBy(xpath = "//ul[@role='tablist']//li//a[text()='Course Page']")
	WebElement coursepagemenu;

	@FindBy(xpath = "//select[@id='id_s_theme_remui_courseperpage']//option")
	List<WebElement> courseselectcount;

	@FindBy(xpath = "//button[@class='btn btn-primary']")
	public WebElement savechanges;

	@FindBy(xpath = "//div[@class='course-cards list-view list-group edw-course-list-container']//li")
	List<WebElement> countonap;

	@FindBy(xpath = "//input[@id='id_s_theme_remui_enablecoursestats']")
	WebElement coursestatsonsp;

	@FindBy(xpath = "//label[@for='id_s_theme_remui_enablecoursestats']")
	public WebElement coursestatlabel;

	@FindBy(xpath = "//input[@id='id_s_theme_remui_enablefocusmode']")
	WebElement enablefocusmodechbx;

	@FindBy(xpath = "//label[@for='id_s_theme_remui_enablefocusmode']")
	public WebElement focusmodelabel;

	@FindBy(xpath = "//button[@id='focusmodebutton']")
	public List<WebElement> focusmodebuttononcp;

	@FindBy(xpath = "//div[@id='wdm_course-stats']")
	public List<WebElement> coursestatsoncp;

	@FindBy(xpath = "//span[@class='edw-icon edw-icon-List-View-08']")
	public WebElement selectlistview;

	@FindBy(xpath = "//select[@id='id_s_theme_remui_courseheaderdesign']//option")
	List<WebElement> courseheader;

	@FindBy(xpath = "//header[@id='page-header' and contains(@class,'design-1')]")
	public List<WebElement> headerdesignoncp;

	@FindBy(xpath = "//select[@id='id_s_theme_remui_activitynextpreviousbutton']//option")
	List<WebElement> activitybutton;

	@FindBy(id = "prev-activity-link")
	public List<WebElement> prevactivity;

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

	// Setions in Course Page
	@FindBy(xpath = "//h3[contains(@class,'sectionname')]")
	public List<WebElement> CourseSections;

	// Activities In Course
	@FindBy(xpath = "//div[contains(@class,'activity-grid')]")
	public List<WebElement> CourseActivities;

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

	// Click On Course Page Menu in RemUI Settings
	public void clickoncoursepagemenu() {
		clicksiteadmin.click();
		clickappearence.click();
		clickremui.click();
		coursepagemenu.click();
	}

	public String selectcoursecount() {
		String count = "9";
		coursepagemenu.click();
		for (int i = 0; i < courseselectcount.size(); i++) {
			WebElement ele = courseselectcount.get(i);
			String innerHTML = ele.getAttribute("innerHTML");
			if (innerHTML.equals(count)) {
				ele.click();
			}
		}
		savechanges.click();
		return count;
	}

	public String coursecountonap() {
		int coursecount = countonap.size();
		String s = String.valueOf(coursecount);
		return s;
	}

	public boolean coursestatsstatus() {
		String present = coursestatsonsp.getAttribute("checked");
		// System.out.println("present "+present);
		boolean status = Boolean.parseBoolean(present);
		// System.out.println("present "+status);
		return status;
	}

	public boolean focusmodestatus() {
		String present = enablefocusmodechbx.getAttribute("checked");
		// System.out.println("present "+present);
		boolean status = Boolean.parseBoolean(present);
		// System.out.println("present "+status);
		return status;
	}

	public String selectcourseheaderdesign1() {
		String design = "Header design 1";
		for (int i = 0; i < courseheader.size(); i++) {
			WebElement ele = courseheader.get(i);
			String innerHTML = ele.getAttribute("innerHTML");
			if (innerHTML.equals(design)) {
				ele.click();
			}
		}
		return design;

	}

	public String selectcourseheaderdefault() {
		String design1 = "Default";
		for (int i = 0; i < courseheader.size(); i++) {
			WebElement ele = courseheader.get(i);
			String innerHTML = ele.getAttribute("innerHTML");
			if (innerHTML.equals(design1)) {
				ele.click();
			}
		}
		return design1;

	}

	public String selectdisablebuttonoption() {
		String option = "Disable";
		for (int i = 0; i < activitybutton.size(); i++) {
			WebElement ele = activitybutton.get(i);
			String innerHTML = ele.getAttribute("innerHTML");
			if (innerHTML.equals(option)) {
				ele.click();
			}
		}
		return option;

	}

	public String selectenablebuttonoption() {
		String option = "Enable";
		for (int i = 0; i < activitybutton.size(); i++) {
			WebElement ele = activitybutton.get(i);
			String innerHTML = ele.getAttribute("innerHTML");
			if (innerHTML.equals(option)) {
				ele.click();
			}
		}
		return option;

	}

	public String selectenablewithactivitybuttonoption() {
		String option = "Enable with Activity name";
		for (int i = 0; i < activitybutton.size(); i++) {
			WebElement ele = activitybutton.get(i);
			String innerHTML = ele.getAttribute("innerHTML");
			if (innerHTML.equals(option)) {
				ele.click();
			}
		}
		return option;

	}

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
