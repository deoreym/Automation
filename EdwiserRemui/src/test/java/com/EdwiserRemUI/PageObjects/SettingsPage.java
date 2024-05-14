package com.EdwiserRemUI.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SettingsPage extends BasePage {

	public SettingsPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//a[normalize-space()='Basic']")
	public WebElement basictab;

	@FindBy(xpath = "//input[@id='id_s_theme_remui_enableannouncement']")
	public WebElement siteannouncementchbk;

	@FindBy(xpath = "//div[@id='id_s_theme_remui_announcementtexteditable']")
	public WebElement siteannouncementtextbx;

	@FindBy(xpath = "//button[text()='Save changes']")
	public WebElement savebutton;

	@FindBy(xpath = "//div[@class='alert alert-success site-announcement mb-0 show-more']")
	public List<WebElement> alert;

	@FindBy(xpath = "//input[@id='id_s_theme_remui_enableannouncement']")
	public WebElement enablesiteannouncement;

	@FindBy(id = "id_s_theme_remui_enabledismissannouncement")
	public WebElement dismisschbk;

	@FindBy(xpath = "//button[@id='dismiss_announcement']")
	public List<WebElement> dismissbutton;

	@FindBy(xpath = "//label[@for='id_s_theme_remui_enabledismissannouncement']")
	public WebElement enabledismissicon;

	@FindBy(xpath = "//label[@for='id_s_theme_remui_enableedwfeedback']")
	public WebElement labelfeedback;

	@FindBy(id = "id_s_theme_remui_enableedwfeedback")
	public WebElement chbk_feedback;

	@FindBy(xpath = "//button[@class='btn btn-floating d-none d-md-flex send-remui-feedback']")
	public List<WebElement> icon_feedback;

	@FindBy(xpath = "//label[@for='id_s_theme_remui_enablequickmenu']")
	public WebElement label_quicklink;

	@FindBy(id = "id_s_theme_remui_enablequickmenu")
	public WebElement chbk_quicklink;

	@FindBy(id = "edw-quick-menu")
	public List<WebElement> icon_quicklink;


	@FindBy(xpath="(//span[@class='navbar-brand-logo iconsitename'])[1]")
	public WebElement sitename;
	
	@FindBy(id="id_s_theme_remui_sitenamecolor")
	public WebElement colorinput;
	
	@FindBy(id="id_s_theme_remui_pagewidth")
	public WebElement Theme_Layout;
	
	public Select ThemeLayout() {
		Select TL = new Select(Theme_Layout);
		return TL;
	}
	
	@FindBy(xpath = "//select[@name='s_theme_remui_pagewidth']//option")
	public List<WebElement> layout_option;
	

	@FindBy(xpath = "//select[@id='id_s_theme_remui_pagewidth']")
	public WebElement themelayout;
	
	@FindBy(id="page-my-index")
	public WebElement layoutid;
	
	

}
