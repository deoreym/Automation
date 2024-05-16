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
	
		
	@FindBy(xpath="//span[contains(@class,'categoryname')]")
	public WebElement elementbgelement;
	
	@FindBy(xpath="//div[@id='fitem_id_global-colors-ascentbackgroundcolor']//div[@class='sp-preview-inner']")
	public WebElement ascentbgcolor;
	
	@FindBy(xpath="//div[@class='btn-group bootstrap-select categoryfiltermenu']//button")
	public WebElement categoryfilter;
	
	@FindBy(xpath="//div[@class='dropdown-menu open show']//ul//li[2]//a")
	public WebElement tags;
	
	@FindBy(xpath="//*[contains(@class,'tag_list')]/li")
	public WebElement ascentbgelement;
	
	@FindBy(xpath="//select[@id='id_global-colors-pagebackground']//option[text()='Color']")
	public WebElement colormenu;
	
	@FindBy(xpath="//div[@id='fitem_id_global-colors-pagebackgroundcolor']//div[@class='sp-preview-inner']")
	public WebElement pagebgcolor;
	
	@FindBy(xpath="//select[@id='id_global-colors-pagebackground']//option[text()='Color']")
	public WebElement coloroptionselect;

	@FindBy(id="page")
	public WebElement pagebgcolorelement;
	
	@FindBy(xpath = "//div[@class='sp-container sp-light sp-palette-buttons-disabled sp-initial-disabled border-secondary']//button[@type='button'][normalize-space()='Choose']")
	public WebElement chooseButton;
}
