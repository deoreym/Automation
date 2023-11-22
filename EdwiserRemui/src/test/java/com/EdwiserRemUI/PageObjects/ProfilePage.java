package com.EdwiserRemUI.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasePage {

	public ProfilePage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//a[@data-text='General']")
	public WebElement generaltab;

	@FindBy(xpath = "//a[@href='#usercourses']")
	public WebElement CoursesTab;

	@FindBy(xpath = "//div[contains(@class,'course-card')]")
	public List<WebElement> CoursesCards;

	@FindBy(xpath = "//a[text()='Advanced features']")
	public WebElement advancedfeaturemenu;

	@FindBy(id = "id_s__enableblogs")
	public WebElement blogchbk;

	@FindBy(id = "id_s__enablebadges")
	public WebElement badgechbk;

	@FindBy(xpath = "//a[text()='Blog Entries']")
	public List<WebElement> blogentriesonpp;

	@FindBy(xpath = "//a[text()='Badges']")
	public List<WebElement> badgeentriesonpp;

	@FindBy(xpath = "//label[@for='id_s__enableblogs']")
	public WebElement lablelblog;

	@FindBy(xpath = "//label[@for='id_s__enablebadges']")
	public WebElement lablelbadge;

	@FindBy(xpath = "//div[@class='forumpost blog_entry blog clearfix site']")
	public List<WebElement> blogsize;

	@FindBy(xpath = "//a[text()='Blog Entries']//preceding::strong[@class='profile-stat-count h-exbold-2 m-0'][1]")
	public WebElement blogcount;

	@FindBy(xpath = "//a[text()='Blog Entries']")
	public WebElement blogentrieslink;

	@FindBy(xpath = "//a[text()='Badges']//preceding::strong[@class='profile-stat-count h-exbold-2 m-0'][1]")
	public WebElement badgecount;

	@FindBy(xpath = "//a[@class='badge-item text-decoration-none']")
	public List<WebElement> badgesize;

	@FindBy(xpath = "//a[text()='Discussions']/..//*[contains(@class,'profile-stat-count')]")
	public WebElement discussioncount;

	@FindBy(xpath = "//article[@data-region='post']")
	public List<WebElement> discussionsize;

	@FindBy(xpath = "//a[text()='Contacts']//preceding::strong[@class='profile-stat-count h-exbold-2 m-0'][1]")
	public WebElement contactcount;

	@FindBy(xpath = "//a[text()='Contacts']")
	public WebElement contactlink;

	@FindBy(xpath = "//div[@id='drawer-6501a6b07b5706501a6b0587c723']//div//div[@data-region='body-container']//div[2]//div//div//ul//li//a[@id='contacts-tab-6501a6b07b5706501a6b0587c723']//span")
	public WebElement countactcountonmsgpanel;

	// Profile About Me Fields Data
	@FindBy(xpath = "//div[@class='edit-profile-icon-wrapper']//span[contains(@class,'edw-icon-Edit')]")
	public WebElement EditIcon;
	
	@FindBy(xpath = "//p[contains(@class,'prof-user-firstname')]")
	public WebElement FirstNameText;

	@FindBy(xpath = "//p[contains(@class,'prof-user-lastname')]")
	public WebElement LastNameText;

	@FindBy(xpath = "//p[contains(@class,'prof-user-email')]")
	public WebElement EmailText;

	@FindBy(xpath = "//p[contains(@class,'prof-user-phone')]")
	public WebElement PhoneNumberText;

	@FindBy(xpath = "//p[contains(@class,'prof-user-department')]")
	public WebElement DepartmentText;

	@FindBy(xpath = "//p[contains(@class,'prof-user-country')]")
	public WebElement CountryText;

	@FindBy(xpath = "//p[contains(@class,'prof-user-city')]")
	public WebElement CityText;

	@FindBy(xpath = "//p[contains(@class,'prof-user-desc')]")
	public WebElement DescriptionText;

	@FindBy(xpath = "//p[contains(@class,'prof-user-address')]")
	public WebElement AddressText;

	// Profile About Me Fields Data Edit
	@FindBy(id = "first_name")
	public WebElement FirstName;

	@FindBy(id = "surname")
	public WebElement LastName;

	@FindBy(id = "standard_email")
	public WebElement Email;

	@FindBy(id = "phone_number")
	public WebElement PhoneNumber;

	@FindBy(id = "department")
	public WebElement Department;

	@FindBy(id = "country")
	public WebElement Country;

	@FindBy(id = "city")
	public WebElement City;

	@FindBy(id = "description")
	public WebElement Description;

	@FindBy(id = "address")
	public WebElement Address;
	
	@FindBy(id = "btn-save-changes")
	public WebElement SaveChanges;
	
}
