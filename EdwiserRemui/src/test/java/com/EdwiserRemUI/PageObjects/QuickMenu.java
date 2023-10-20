package com.EdwiserRemUI.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.EdwiserRemUI.BaseTest.BaseClass;

public class QuickMenu extends BaseClass {
	WebDriver driver;

	public QuickMenu(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Elements
	@FindBy(id = "edw-quick-menu")
	public WebElement QuickMenu;

	@FindBy(xpath = "//div[@id='edw-quick-menu' and contains(@class,'collapsed')]")
	public List<WebElement> QuickMenuCollapsed;

	@FindBy(xpath = "//a[@title='User list']")
	public WebElement UserListIcon;

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
