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
	
	@FindBy(xpath="//button[@id='publish-settings']")
	public WebElement save;
}
