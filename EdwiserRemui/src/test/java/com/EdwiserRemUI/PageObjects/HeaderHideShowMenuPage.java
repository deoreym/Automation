package com.EdwiserRemUI.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderHideShowMenuPage extends BasePage {

	public HeaderHideShowMenuPage(WebDriver driver) {
		super(driver);
	}

	// elements

	@FindBy(xpath = "//input[@id='id_hide-home']")
	public WebElement homemenu;

	@FindBy(xpath = "(//label[@for='id_hide-home'])[1]")
	public WebElement homemenulabel;

	@FindBy(xpath = "//input[@id='id_hide-my-courses']")
	public WebElement mycoursesmenu;

	@FindBy(xpath = "(//label[@for='id_hide-my-courses'])[1]")
	public WebElement mycourseslabel;

	@FindBy(xpath = "//input[@id='id_enablerecentcourses']")
	public WebElement recentmenu;

	@FindBy(xpath = "(//label[@for='id_enablerecentcourses'])[1]")
	public WebElement recentmenulabel;

	@FindBy(xpath = "//input[@id='id_hide-dashboard']")
	public WebElement dashboardmenu;

	@FindBy(xpath = "(//label[@for='id_hide-dashboard'])[1]")
	public WebElement DashboardMenuLabel;

	@FindBy(xpath = "//input[@id='id_hide-site-admin']")
	public WebElement siteAdminMenu;

	@FindBy(xpath = "(//label[@for='id_hide-site-admin'])[1]")
	public WebElement siteAdminMenulabel;

	@FindBy(xpath = "//input[@id='id_enabledisablecoursecategorymenu']")
	public WebElement CategoryDropDown;

	@FindBy(xpath = "(//label[@for='id_enabledisablecoursecategorymenu'])[1]")
	public WebElement CategoryDropDownLabel;

	@FindBy(id = "id_coursecategoriestext")
	public WebElement CategoryDropDownText;

	@FindBy(xpath = "//li[@data-key='coursecat']")
	public WebElement Categories_Menu;

	@FindBy(xpath = "//li[@data-key='coursecat']/a")
	public WebElement Categories_Menu_Text;

	@FindBy(xpath = "//li[@data-key='home']")
	public WebElement Home_Menu;

	@FindBy(xpath = "//li[@data-key='myhome']")
	public WebElement Dashboard_Menu;

	@FindBy(xpath = "//li[@data-key='mycourses']")
	public WebElement Mycourses_Menu;

	@FindBy(xpath = "//li[@data-key='siteadminnode']")
	public WebElement Site_Admin_Menu;

	@FindBy(xpath = "//li[@data-key='recentcourses']")
	public WebElement Recent_Courses;

	@FindBy(xpath = "//div[@class='group-item edw-nav-border']//h6[text()='Header']")
	public WebElement headermenu;

	@FindBy(xpath = "//div[@class='group-item edw-nav-border']//h6[text()='Hide/Show menu item']")
	public WebElement hideshowmenu;

	@FindBy(id = "publish-settings")
	public WebElement savebutton;

}
