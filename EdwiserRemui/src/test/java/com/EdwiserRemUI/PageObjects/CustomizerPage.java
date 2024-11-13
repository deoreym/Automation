package com.EdwiserRemUI.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomizerPage extends BasePage {

	public CustomizerPage(WebDriver driver) {
		super(driver);
		
	}
	
	//elements
	
	@FindBy(xpath="//ul[@role='tablist']//li//a[text()='Visual Personalizer']")
	public WebElement customizertab;
	
	@FindBy(xpath="//a[@class='btn btn-primary activatepersonalizer']")
	public WebElement customizerbutton;
	
	@FindBy(xpath="//div[@id='edw-quick-menu']//a[@class='close-quick-menu d-flex']")
	public  WebElement customizerfromqm;
	
	@FindBy(xpath="//div[@id='edw-quick-menu']")
	public WebElement quickmenu;
	
	//Actions

	public void selectcustomizerfromquickmenu() {
		customizerfromqm.click();
	}
}
