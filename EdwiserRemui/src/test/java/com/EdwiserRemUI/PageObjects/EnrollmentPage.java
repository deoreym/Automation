package com.EdwiserRemUI.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.EdwiserRemUI.BaseTest.BaseClass;

public class EnrollmentPage extends BaseClass {
	WebDriver driver;

	public EnrollmentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Duration
	@FindBy(xpath = "//span[contains(@class,'edw-icon-Length-01')]/../..//*[contains(@class,'sub-label')]")
	public WebElement Duration;

	// Skill Level
	@FindBy(xpath = "//span[contains(@class,'edw-icon-Skill-level-01')]/../..//*[contains(@class,'sub-label')]")
	public WebElement Skill_Level;

	// Intro Video Frame
	@FindBy(xpath = "//iframe[@class='videoframe']")
	public WebElement Intro_Video_Frame;

	// Enrol Now Button
	@FindBy(xpath = "//a[text()='Enrol Now']")
	public WebElement Enrol_Now;

	// Course Category
	@FindBy(xpath = "//div[contains(@class,'category-details')]//*[contains(@class,'categoryname')]")
	public WebElement Category;

	// Lesson Count
	@FindBy(xpath = "//span[contains(@class,'edw-icon-Book')]/../..//*[contains(@class,'sub-label')]")
	public WebElement LessonsCount;

	// Student Count
	@FindBy(xpath = "//span[contains(@class,'edw-icon-Group-user')]/../..//span[contains(@class,'sub-label')]")
	public WebElement StudentsCount;

	// Lecture Count
	@FindBy(xpath = "//*[text()='Lecture']/../..//*[contains(@class,'sub-label')]")
	public WebElement Lecture;

	// Start Date
	@FindBy(xpath = "//span[contains(@class,'edw-icon-Calendar')]/../..//*[contains(@class,'sub-label')]")
	public WebElement Course_Start_Date;

	// Language
	@FindBy(xpath = "//span[contains(@class,'edw-icon-Language')]/../..//*[contains(@class,'sub-label')]")
	public WebElement Course_Language;

	// Instructor Tab
	@FindBy(xpath = "//a[@data-text='instructors']")
	public WebElement InstructorTab;

	// Instructor List
	@FindBy(xpath = "//a[contains(@class,'instructor-name-url')]")
	public List<WebElement> InstructorList;
	
	// Overview text
	@FindBy(xpath = "//div[@id='linkcourseoverview']//*[contains(@class,'tab-pane-area')]")
	public WebElement Course_Overview;
	

}
