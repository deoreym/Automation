package com.EdwiserRemUI.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderHideShowMenuPage extends BasePage {

	public HeaderHideShowMenuPage(WebDriver driver) {
		super(driver);
		
	}
	
	//elements
	
	@FindBy(xpath="//input[@id='id_hide-home']")
	public WebElement homemenu;
	
	@FindBy(xpath="(//label[@for='id_hide-home'])[1]")
	public WebElement homemenulabel;
	
	@FindBy(xpath="//input[@id='id_hide-my-courses']")
	public WebElement mycoursesmenu;
	
	@FindBy(xpath="(//label[@for='id_hide-my-courses'])[1]")
	public WebElement mycourseslabel;
	
	@FindBy(xpath="//input[@id='id_enablerecentcourses']")
	public WebElement recentmenu;
	
	@FindBy(xpath="(//label[@for='id_enablerecentcourses'])[1]")
	public WebElement recentmenulabel;
	
	@FindBy(xpath="//input[@id='id_hide-dashboard']")
	public WebElement dashboardmenu;
	
	@FindBy(xpath="(//label[@for='id_hide-dashboard'])[1]")
	public WebElement dashboardmenulabel;
	
	@FindBy(xpath="//li[@title='Home']//a")
	public List<WebElement> homemenuondp;
	
	@FindBy(xpath="//li[@title='My courses']//a")
	public List<WebElement> mycoursesondp;
	
	@FindBy(xpath="//li[@title='Site administration']//a")
	public List<WebElement> siteadminondp;
	
	@FindBy(xpath="//div[@id='usernavigation']//div//nav//ul//li//a[@id='drop-down-']")
	public List<WebElement> recentondp;
	
	@FindBy(xpath="//div[@class='primary-navigation']//nav//ul//li[@class='dropdown nav-item']")
	public List<WebElement> categoryondp;
	
	
	
	@FindBy(xpath="//div[@class='primary-navigation']//nav//ul//li[@title='Dashboard']//a")
	public List<WebElement> dashboardondp;
	
	@FindBy(xpath="//div[@class='primary-navigation']//nav//ul//li[@class='dropdown nav-item']//a[@id='drop-down-64c791f07678e']")
	public WebElement categorytitle;
	
	@FindBy(xpath="//div[@class='d-flex align-items-center flex-gap-d5']//label[@for='id_hide-home']")
	public WebElement hidehomemenu;
	
	@FindBy(xpath="//div[@class='d-flex align-items-center flex-gap-d5']//label[@for='id_hide-my-courses']")
	public WebElement hidemycoursesmenu;
	
	@FindBy(xpath="//div[@class='d-flex align-items-center flex-gap-d5']//label[@for='id_hide-site-admin']")
	public WebElement hidesiteadminmenu;
	
	@FindBy(xpath="//div[@class='d-flex align-items-center flex-gap-d5']//label[@for='id_enablerecentcourses']")
	public WebElement hiderecentcoursesmenu;
	
	@FindBy(xpath="//div[@class='d-flex align-items-center flex-gap-d5']//label[@for='id_enabledisablecoursecategorymenu']")
	public WebElement hidecategorydd;
	

	@FindBy(xpath="//div[@class='d-flex align-items-center flex-gap-d5']//label[@for='id_hide-dashboard']")
	public WebElement hidedashboard;
	
	@FindBy(xpath="//div[@class='group-item edw-nav-border']//h6[text()='Header']")
	public WebElement headermenu;
	
	@FindBy(xpath="//div[@class='group-item edw-nav-border']//h6[text()='Hide/Show menu item']")
	public  WebElement hideshowmenu;
	
	@FindBy(xpath="//input[@id='id_coursecategoriestext']")
	public WebElement categorytext;
	
	@FindBy(id="id_coursecategoriestext")
	public List<WebElement> categoryfield;
	
	@FindBy(id="publish-settings")
	public WebElement savebutton;
	
}
