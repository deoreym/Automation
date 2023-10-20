package com.EdwiserRemUI.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BackgroundColorSettingPage extends BasePage {

	public BackgroundColorSettingPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//h6[text()='Background settings']")
	public WebElement backgroundcolorsmenu;
	
	@FindBy(xpath="//div[@id='fitem_id_global-colors-elementbackgroundcolor']//div[@class='sp-preview-inner']")
	public WebElement elementbgcolor;
	
		
	@FindBy(xpath="//th[@class='header text-xs-center']")
	public WebElement elementbgelement;
	
	@FindBy(xpath="//div[@id='fitem_id_global-colors-ascentbackgroundcolor']//div[@class='sp-preview-inner']")
	public WebElement ascentbgcolor;
	
	@FindBy(xpath="//div[@class='btn-group bootstrap-select categoryfiltermenu']//button")
	public WebElement categoryfilter;
	
	@FindBy(xpath="//div[@class='dropdown-menu open show']//ul//li[2]//a")
	public WebElement tags;
	
	@FindBy(xpath="//li[@class='list-inline-item badge badge-primary py-1 px-2'][1]")
	public WebElement ascentbgelement;
	
	@FindBy(xpath="//select[@id='id_global-colors-pagebackground']//option[text()='Color']")
	public WebElement colormenu;
	
	@FindBy(xpath="//div[@id='fitem_id_global-colors-pagebackgroundcolor']//div[@class='sp-preview-inner']")
	public WebElement pagebgcolor;
	
	@FindBy(xpath="//select[@id='id_global-colors-pagebackground']//option[text()='Color']")
	public WebElement coloroptionselect;

	@FindBy(id="page")
	public WebElement pagebgcolorelement;
}
