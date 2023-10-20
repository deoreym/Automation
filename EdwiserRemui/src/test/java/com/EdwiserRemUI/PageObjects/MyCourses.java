package com.EdwiserRemUI.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.EdwiserRemUI.BaseTest.BaseClass;

public class MyCourses extends BaseClass {
	WebDriver driver;

	public MyCourses(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Elements
	@FindBy(xpath = "//li[@data-key='mycourses']/a")
	public WebElement MyCoursesMenu;

	@FindBy(id = "searchinput")
	public WebElement SearchCourse;


	public WebElement ViewCourseButton(String Course) {
		return driver.findElement(By.xpath("//span[contains(@title,'"+Course+"')]/../../../../..//a[contains(@class,'view-course-btn')]"));
	};
	
	public WebElement ActivityCompletedCount(String Course) {
		return driver.findElement(By.xpath("//span[contains(@title,'"+Course+"')]/../../../../..//a[contains(@class,'view-course-btn')]"));
	};
	
	public WebElement ActivityTotalCount(String Course) {
		return driver.findElement(By.xpath("//span[contains(@title,'"+Course+"')]/../../../../..//a[contains(@class,'view-course-btn')]"));
	};

	@FindBy(xpath = "//a[@title='Course Archive Page']")
	public WebElement CourseArchiveIcon;

	@FindBy(xpath = "//a[@title='Create A New Course']")
	public WebElement NewCourseIcon;

	@FindBy(xpath = "//a[@title='Customizer']")
	public WebElement CustomizerIcon;

	@FindBy(xpath = "//a[@title='RemUI Settings']")
	public WebElement EdwiserSettingsIcon;

	@FindBy(xpath = "//label[@for='id_s_theme_remui_enablequickmenu']")
	public WebElement label_quicklink;

	@FindBy(id = "id_s_theme_remui_enablequickmenu")
	public WebElement chbk_quicklink;
}
