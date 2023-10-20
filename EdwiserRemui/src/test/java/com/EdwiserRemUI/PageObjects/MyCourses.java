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

	@FindBy(xpath = "//div[contains(@class,'btn-group')]")
	public WebElement ShowIcon;

	@FindBy(xpath = "//a[@data-limit='0']")
	public WebElement AllCourses;

	@FindBy(xpath = "//a[@data-limit='12']")
	public WebElement Courses12;

	@FindBy(xpath = "//*[contains(@data-region,'course-content')]")
	public List <WebElement> CourseCards;


}
