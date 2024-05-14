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

	@FindBy(xpath = "(//span[contains(@class,'dashboard-stats-coursesenrolled')])[1]")
	public WebElement courseenrolleddp;

	@FindBy(xpath = "(//span[contains(@class,'dashboard-stats-coursescompleted')])[1]")
	public WebElement coursecompleted;

	@FindBy(xpath = "(//span[contains(@class,'dashboard-stats-activitiescompleted')])[1]")
	public WebElement activitiescompleted;

	@FindBy(xpath = "(//span[contains(@class,'dashboard-stats-activitiesdue')])[1]")
	public WebElement activitiesdue;
	
	@FindBy(xpath = "//a[@aria-controls='usercourses']")
	public WebElement CoursesTab;
	

	@FindBy(xpath = "//div[contains(@class,'edw-course-list-container')]//div[contains(@class,'edw-course-list')]")
	public List<WebElement> coursesfromprofilepage;

	@FindBy(xpath = "//div[contains(@class,'progress-data-wrapper')]/span")
	List<WebElement> actcompletedfrompp;

	@FindBy(xpath = "//div[contains(@class,'progress-text')]/span")
	List<WebElement> coursecompletedperct;

	// Actions

//	public boolean dashboardstatsstatus() {
//		String present = dashboardstatschbk.getAttribute("checked");
//		// System.out.println("present "+present);
//		boolean status = Boolean.parseBoolean(present);
//		// System.out.println("present "+status);
//		return status;
//	}

//	public String coursecountfrompp() {
//		int count = coursesfromprofilepage.size();
//		String coursecount = String.valueOf(count);
//		// System.out.println("coursecount "+coursecount);
//		return coursecount;
//
//	}

	public String CompletedActivities() {
		String Totalactcount = null;
		int sum = 0;
		for (WebElement ele : actcompletedfrompp) {
			String innerHTML = ele.getAttribute("title");
			String[] splited = innerHTML.split(" ");
			if (!splited[0].contains("No")) {
				sum = sum + Integer.parseInt(splited[0]);
			}
		}
		Totalactcount = Integer.toString(sum);
		return Totalactcount;
	}


//	public String additionofactivitiescompleted() {
//		int sum = 0;
//		String Totalactcount;
//		for (int i = 0; i < actcompletedfrompp.size(); i++) {
//			WebElement ele = actcompletedfrompp.get(i);
//			String innerHTML = ele.getAttribute("title");
//			String[] splited = innerHTML.split(" ");
//			// System.out.println(splited[0]);
//			String actual = (splited[0]);
//			int a = Integer.parseInt(actual);
//			sum = a + sum;
//		}
//		// System.out.println("sum "+sum);
//		Totalactcount = Integer.toString(sum);
//		System.out.println("Totalactcount  " + Totalactcount);
//		return Totalactcount;
//	}
	
	public String TotalActivities() {
		String Totalactcount = null;
		int sum = 0;
		for (WebElement ele : actcompletedfrompp) {
			String innerHTML = ele.getAttribute("title");
			String[] splited = innerHTML.split(" ");
			if (!splited[3].contains("the")) {
				sum = sum + Integer.parseInt(splited[3]);
			}
		}
		Totalactcount = Integer.toString(sum);
		return Totalactcount;
	}
//	public String totalfactivitiescount() {
//		int sum = 0;
//		String Totalactcount;
//		for (int i = 0; i < actcompletedfrompp.size(); i++) {
//			WebElement ele = actcompletedfrompp.get(i);
//			String innerHTML = ele.getAttribute("title");
//			String[] splited = innerHTML.split(" ");
//			// System.out.println(splited[0]);
//			String actual = (splited[3]);
//			int a = Integer.parseInt(actual);
//			sum = a + sum;
//		}
//		// System.out.println("sum "+sum);
//		Totalactcount = Integer.toString(sum);
//		System.out.println("Totalactcount  " + Totalactcount);
//		return Totalactcount;
//	}

	public int Completed_Course_Count() {
		int cnt = 0;
		for (WebElement pgr : coursecompletedperct) {
			if(pgr.getText().equals("100")) {
				cnt++;
			}
		}
		return cnt;
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


}
