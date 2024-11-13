package com.EdwiserRemUI.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BorderColorPage extends BasePage {

	public BorderColorPage(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(xpath="//h6[text()='Borders settings']")
	public WebElement bordermenu;
	
	@FindBy(xpath="//div[@id='fitem_id_themecolors-lightbordercolor']//div[@class='sp-preview-inner']")
	public WebElement lightborder;
	
	@FindBy(xpath="//div[@class='course_card-0 card-wrapper card dashboard-card edwanimate-none'][1]")
	public WebElement lightborderelement;
	
	
	@FindBy(xpath="//div[@id='fitem_id_themecolors-mediumbordercolor']//div[@class='sp-preview-inner']")
	public WebElement mediumborder;
	
	@FindBy(xpath="//div[@class='d-flex  all-filters-wrapper']")
	public WebElement mediumborderelement;

}
