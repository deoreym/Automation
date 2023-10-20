package com.EdwiserRemUI.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.EdwiserRemUI.BaseTest.BaseClass;

public class DashBoardPage extends BaseClass {
	WebDriver driver;

	public DashBoardPage(WebDriver driver) {
//		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Elements
	@FindBy(xpath = "//li[contains(@title,'Site administration')]//a[contains(@role,'menuitem')]")
	public WebElement clicksiteadmin;

	@FindBy(xpath = "//li[contains(@title,'Site administration')]//a[contains(@role,'menuitem')]")
	public List<WebElement> siteadmin;

	@FindBy(xpath = "//a[normalize-space()='Appearance']")
	public WebElement clickappearence;

	@FindBy(xpath = "//div[@id='linkappearance']//div[2]//div[2]//ul[1]//li[5]//a[1]")
	public WebElement clickremui;

	@FindBy(xpath = "//ul[@role='tablist']//li//a[text()='Dashboard']")
	public WebElement dashboardmenu;

	@FindBy(id = "id_s_theme_remui_enabledashboardcoursestats")
	public WebElement dashboardstatschbk;

	@FindBy(id = "wdm_dashboard-stats")
	public List<WebElement> dashboardstatsondp;

	@FindBy(xpath = "//label[@for='id_s_theme_remui_enabledashboardcoursestats']")
	public WebElement dashboardstatslabel;

	@FindBy(xpath = "//button[@class='btn btn-primary']")
	public WebElement savechanges;

	@FindBy(xpath = "//div[@class='stats-mb-devices']//span[@class='h-exbold-2 dashboard-stats-coursesenrolled']")
	public WebElement courseenrolleddp;

	@FindBy(xpath = "//div[@class='stats-mb-devices']//span[@class='h-exbold-2 dashboard-stats-coursescompleted']")
	public WebElement coursecompleted;

	@FindBy(xpath = "//div[@class='stats-mb-devices']//span[@class='h-exbold-2 dashboard-stats-activitiescompleted']")
	public WebElement activitiescompleted;

	@FindBy(xpath = "//div[@class='stats-mb-devices']//span[@class='h-exbold-2 dashboard-stats-activitiesdue']")
	public WebElement activitiesdue;

	@FindBy(xpath = "//div[@class='course-card hor-1 list-group-item course-listitem  d-flex edw-course-list ']")
	public List<WebElement> coursesfromprofilepage;

	@FindBy(xpath = "//div[@class='course-card hor-1 list-group-item course-listitem  d-flex edw-course-list ']//div[2]//div[@class='edw-card-design-ft d-flex justify-content-between flex-gap-4']//div[1]//span[@class='small-info-regular m-0']")
	List<WebElement> actcompletedfrompp;

	@FindBy(xpath = "//div[@class='progress-text h-regular-6']//span")
	List<WebElement> coursecompletedperct;

	// Actions

	public void remuimenu() {
		driver.get(remuisetting);
//		clicksiteadmin.click();
//		clickappearence.click();
//		clickremui.click();

	}

	public boolean dashboardstatsstatus() {
		String present = dashboardstatschbk.getAttribute("checked");
		// System.out.println("present "+present);
		boolean status = Boolean.parseBoolean(present);
		// System.out.println("present "+status);
		return status;
	}

	public String coursecountfrompp() {
		int count = coursesfromprofilepage.size();
		String coursecount = String.valueOf(count);
		// System.out.println("coursecount "+coursecount);
		return coursecount;

	}

	public String additionofactivitiescompleted() {
		int sum = 0;
		String Totalactcount;
		for (int i = 0; i < actcompletedfrompp.size(); i++) {
			WebElement ele = actcompletedfrompp.get(i);
			String innerHTML = ele.getAttribute("title");
			String[] splited = innerHTML.split(" ");
			// System.out.println(splited[0]);
			String actual = (splited[0]);
			int a = Integer.parseInt(actual);
			sum = a + sum;
		}
		// System.out.println("sum "+sum);
		Totalactcount = Integer.toString(sum);
		System.out.println("Totalactcount  " + Totalactcount);
		return Totalactcount;
	}

	public int coursecompletedcount() {
		int counter = 0;
		String innerHTML;
		int percent = 100;
		for (int i = 0; i < coursecompletedperct.size(); i++) {
			WebElement ele = coursecompletedperct.get(i);
			innerHTML = ele.getText();
			int perc = Integer.parseInt(innerHTML);
			System.out.println(innerHTML);
			if (perc == percent) {
				counter = counter + 1;
				System.out.println("test");
			}

		}
		System.out.println("counter " + counter);
		return counter;
	}

	public String totalfactivitiescount() {
		int sum = 0;
		String Totalactcount;
		for (int i = 0; i < actcompletedfrompp.size(); i++) {
			WebElement ele = actcompletedfrompp.get(i);
			String innerHTML = ele.getAttribute("title");
			String[] splited = innerHTML.split(" ");
			// System.out.println(splited[0]);
			String actual = (splited[3]);
			int a = Integer.parseInt(actual);
			sum = a + sum;
		}
		// System.out.println("sum "+sum);
		Totalactcount = Integer.toString(sum);
		System.out.println("Totalactcount  " + Totalactcount);
		return Totalactcount;
	}
}
