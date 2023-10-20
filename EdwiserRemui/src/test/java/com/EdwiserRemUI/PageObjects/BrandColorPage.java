package com.EdwiserRemUI.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BrandColorPage extends BasePage {

	public BrandColorPage(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(xpath="//h6[text()='Global']")
	public WebElement globalmenu;
	
	@FindBy(xpath="//h6[text()='Theme colors']")
	public WebElement themecolorsmenu;
	
	@FindBy(xpath="//div[@id='fitem_id_sitecolorhex']//div[@class='sp-preview-inner']")
	public WebElement primarycolor;
	
	@FindBy(xpath="//div[@class='sp-container sp-light sp-palette-buttons-disabled sp-initial-disabled border-secondary']//input[@type='text']")
	public WebElement colorinputfield;
	
	
	@FindBy(xpath="//button[@id='publish-settings']")
	public WebElement save;
	
	@FindBy(xpath="//a[normalize-space()='General']")
	public WebElement primarycolortext;
	
	@FindBy(xpath="//div[@id='fitem_id_secondarycolor']//div[@class='sp-preview-inner']")
	public WebElement ascentcolor;
	
	@FindBy(xpath="//body/div[@id='page-wrapper']/div[@id='page']/div[@id='topofscroll']/div[@class='container']/div[@id='wdm_dashboard-stats']/div[1]/div[1]/div[1]/span[1]")
	public WebElement ascentcolorelement;
	
	@FindBy(xpath="//div[@id='fitem_id_themecolors-textcolor']//div[@class='sp-preview-inner']")
	public WebElement textcolor;
	
	@FindBy(xpath="//span[normalize-space()='Courses']")
	public WebElement textcolorelement;
	
	
}
