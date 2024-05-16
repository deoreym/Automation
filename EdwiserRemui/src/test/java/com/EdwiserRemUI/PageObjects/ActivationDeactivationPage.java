package com.EdwiserRemUI.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ActivationDeactivationPage extends BasePage {

	public ActivationDeactivationPage(WebDriver driver) {
		super(driver);
		
	}
	
	//elements
	@FindBy(xpath="//ul[@role='tablist']//li//a[text()='Information Center']")
	public WebElement infotab;
	
	@FindBy(xpath="//div[@class='col-12 text p-0']//p")
	WebElement status;
	
	@FindBy(xpath="//div[@class='alert alert-success form-group license-alert alert-dismissible']")
	public List<WebElement> successalert;
	
	@FindBy(xpath="//body/div[@id='page-wrapper']/div[contains(@class,'alert-dismissible site-announcement mb-0 alert-danger')]/strong[1]")
	public List<WebElement> dangeralert;
	
	@FindBy(xpath="//input[@placeholder='Enter license key...']")
	public WebElement licensekey;
	
	@FindBy(xpath="//input[@name='edd_remui_license_activate']")
	public WebElement activatebutton;
	
	@FindBy(xpath="//input[@name='edd_remui_license_deactivate']")
	public WebElement deactivatebutton;
	
	//Actions
	
	public String checkstatus() {
		String statusofremui=status.getText();
		return statusofremui;
	}
	
	public boolean checkvalueattribute() {
		String present=licensekey.getAttribute("value");
		boolean status = Boolean.parseBoolean(present);
		return status;
	}
}
