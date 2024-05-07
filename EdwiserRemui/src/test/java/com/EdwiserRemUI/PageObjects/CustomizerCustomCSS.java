package com.EdwiserRemUI.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomizerCustomCSS extends BasePage {

	public CustomizerCustomCSS(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//div[@data-panel-id='additional-css-page']")
	public WebElement CustomCSS_Menu;

	@FindBy(id = "id_customcss")
	public WebElement CustomCSS_Input;

	@FindBy(xpath = "//li[@title='Dashboard']/a")
	public WebElement DashboardLink;

	@FindBy(xpath = "//li[@title='Dashboard']")
	public WebElement DashboardInList;

	@FindBy(xpath = "//button[@class='btn btn-primary btn-floating d-none d-md-flex moodlehelpbtn']")
	public WebElement Footer_HelpIcon;

	@FindBy(xpath = "//button[@id='publish-settings']")
	public WebElement save;

	@FindBy(xpath = "//div[contains(@class,'current')]//a[@data-panel-id='root']")
	public WebElement CustomizerHome;
	
	// Reset Header Button
	@FindBy(id = "reset-settings")
	public WebElement ResetCustomizer;
	
	// Reset Button From PopUp
	@FindBy(xpath = "//button[@data-action='reset-some']")
	public WebElement Reset;
	
	// Reset All Button From PopUp
	@FindBy(xpath = "//button[@data-action='reset-all']")
	public WebElement Reset_All;
	
	
	// Some Sample Elements for Site Color Testing
	
	@FindBy(xpath="(//a[@role='menuitem' and contains(text(),'Course')])[1]")
	public WebElement primarycolortext;
	
	@FindBy(xpath="//button[contains(@class,'moodlehelpbtn')]")
	public WebElement PrimaryColor;
	
	@FindBy(xpath="//a[@role='menuitem' and contains(text(),'Settings')]")
	public WebElement TextColorText;
	
	@FindBy(xpath="//div[@id='wdm_course-stats']/*/*/*/span[@class='edw-icon edw-icon-Group-user']")
	public WebElement Accsent_Color;
	
	@FindBy(xpath="//div[contains(@class,'secondary-navigation edw-tabs-navigation')]")
	public WebElement Border_Color;
	
	

}
