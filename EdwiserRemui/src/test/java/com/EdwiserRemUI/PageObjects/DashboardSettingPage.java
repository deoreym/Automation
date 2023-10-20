package com.EdwiserRemUI.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardSettingPage extends BasePage {

	public DashboardSettingPage(WebDriver driver) {
		super(driver);
		
	}
	
	//Elements
	@FindBy(xpath="//li[contains(@title,'Site administration')]//a[contains(@role,'menuitem')]")
	WebElement clicksiteadmin;
	
	@FindBy(xpath="//a[normalize-space()='Appearance']")
	WebElement clickappearence;
	
	@FindBy(xpath="//div[@id='linkappearance']//div[2]//div[2]//ul[1]//li[5]//a[1]")
	WebElement clickremui;
	
	@FindBy(xpath="//ul[@role='tablist']//li//a[text()='Dashboard']")
	WebElement dashboardmenu;
	
	@FindBy(xpath="//input[@id='id_s_theme_remui_enabledashboardcoursestats']")
	WebElement enabledashboardcs;
	
	@FindBy(xpath="//div[@id='wdm_dashboard-stats']")
    WebElement statsondashboard;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	WebElement savechanges;
	
	@FindBy(xpath="//label[@for='id_s_theme_remui_enabledashboardcoursestats']")
	WebElement clickonlabel;
	
	
	//Actions
	public void clickondashboard() {
		clicksiteadmin.click();
		clickappearence.click();
		if(clickremui.isDisplayed()) {
		clickremui.click();
		}
		else {
			System.out.println("Edwiser Remui menu is not present");
		}
		if(dashboardmenu.isDisplayed()) {
			dashboardmenu.click();
		}
		else {
			System.out.println("Dashboard menu is not present");
		}
	}
	
	public boolean enablecoursestatus() {
		String present=enabledashboardcs.getAttribute("checked");
		//System.out.println("present "+present);
		boolean status = Boolean.parseBoolean(present);
		System.out.println("present "+status);
		return status;
	}
	
	public boolean statsondashboard() {
		boolean status=statsondashboard.isDisplayed();
		//System.out.println("statsondashboard "+status);
		return status;
	}
	public void clickoncheckbox() {
		clickonlabel.click();
		savechanges.click();
	}
}