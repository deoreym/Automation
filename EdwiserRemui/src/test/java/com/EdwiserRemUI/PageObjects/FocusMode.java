package com.EdwiserRemUI.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FocusMode extends BasePage {

	public FocusMode(WebDriver driver) {
		super(driver);

	}

	// Course Settings
	@FindBy(xpath = "//a[@href='#theme_remui_course']")
	public WebElement CourseSettings;

	// Focus Mode Setting
	@FindBy(id = "id_s_theme_remui_enablefocusmode")
	public WebElement FocusModeSetting;

	// Focus Mode Setting Checkbox
	@FindBy(xpath = "//input[@id='id_s_theme_remui_enablefocusmode']/..")
	public WebElement FocusModeSettingCB;

	// Focus Mode Button On Course/Activity
	@FindBy(id = "focusmodebutton")
	public WebElement FocusModeButton;

	// Enable Focus Mode Button List
	@FindBy(xpath = "//button[@id='focusmodebutton' and contains(@class,'btn-primary')]")
	public List<WebElement> EnableFMButtonList;

	// Disable Focus Mode Button List
	@FindBy(xpath = "//button[@id='focusmodebutton' and contains(@class,'btn-danger')]")
	public List<WebElement> DisableFMButtonList;

	// Enable Focus Mode Button
	@FindBy(xpath = "//button[@id='focusmodebutton' and contains(@class,'btn-primary')]")
	public WebElement EnableFMButton;

	// Disable Focus Mode Button
	@FindBy(xpath = "//button[@id='focusmodebutton' and contains(@class,'btn-danger')]")
	public WebElement DisableFMButton;

	// Header Course Progress
	@FindBy(xpath = "//div[@class='progress mr-1']")
	public List<WebElement> HeaderCourseProgressBar;

	// ProgressPercentage
	@FindBy(xpath = "//span[@class='progress-text']")
	public WebElement ProgressPercentage;

	// Course Name on Focus Mode Header
	@FindBy(xpath = "(//div[contains(@class,'courseheaderbar')] //a)[1]")
	public WebElement FM_CourseName;

	// Course Name on Course Header
	@FindBy(xpath = "//h1[contains(@class,'header-heading coursepage')]")
	public WebElement CourseName;

	// Next Activity
	@FindBy(id = "courseNext")
	public WebElement NextButton;

	// Previous Activity
	@FindBy(id = "coursePrevious")
	public WebElement PreviousButton;

	// Disabled Previous Button
	@FindBy(xpath = "//li[@id='coursePrevious']//a[contains(@class,'disable')]")
	public List<WebElement> PrevButtonDisabled;

	// Disabled Next Button
	@FindBy(xpath = "//li[@id='courseNext']//a[contains(@class,'disable')]")
	public List<WebElement> NextButtonDisabled;

	// Acivities DropDown
	@FindBy(id = "courseActivities")
	public WebElement ActivitiesDropDown;

	// Number of Sections
	@FindBy(xpath = "//*[@id='courseActivities']//div[contains(@id,'headingSection')]")
	public List<WebElement> NumberOfSections;

	// Setions in Course Page
	@FindBy(xpath = "//h3[contains(@class,'sectionname')]")
	public List<WebElement> CourseSections;

	// Number of Activities (Get Size)
	@FindBy(xpath = "//*[@id='courseActivities']//div[@class='card-header d-flex activity-item']")
	public List<WebElement> NumberOfActivities;

	// Activities In Course
	@FindBy(xpath = "//div[contains(@class,'activity-grid')]")
	public List<WebElement> CourseActivities;

	public WebElement Activity(int n) {
		return driver.findElement(By.xpath("(//div[contains(@class,'activity-grid')]//a)[" + n + "]"));
	}

	// Mark as Done Button
	@FindBy(xpath = "(//div[@data-region='completion-info']//button)[2]")
	public WebElement MarkDone;

	// Activity Heading on Normal Mode(Get Text)
	@FindBy(xpath = "//*[@class='h2 header-heading']")
	public WebElement ActivityHeading;

	// Selected Activity Title/Name in Focus Mode DropDown
	@FindBy(xpath = "//li[@id='courseActivities']//span")
	public WebElement ActivityName;

	@FindBy(xpath = "//button[@type='submit' and text()='Save changes']")
	public WebElement SaveSettings;
}
