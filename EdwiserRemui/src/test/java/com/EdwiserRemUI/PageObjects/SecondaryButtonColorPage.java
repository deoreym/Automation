package com.EdwiserRemUI.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SecondaryButtonColorPage extends BasePage{

	public SecondaryButtonColorPage(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(xpath="//h6[text()='Secondary']")
	public WebElement secondarybuttonmenu;
	
	@FindBy(xpath="//a[normalize-space()='Create new category']")
	public WebElement secondarybutton;
	
	@FindBy(xpath="//div[@id='fitem_id_button-secondary-color-text']//div[@class='sp-preview-inner']")
	public WebElement textcolor;
	
	@FindBy(xpath="//div[@id='fitem_id_button-secondary-color-text-hover']//div[@class='sp-preview-inner']")
	public WebElement texthovercolor;
	
	@FindBy(xpath="//div[@id='fitem_id_button-secondary-color-icon']//div[@class='sp-preview-inner']")
	public WebElement iconcolor;
	
	@FindBy(xpath="//div[@id='fitem_id_button-secondary-color-icon-hover']//div[@class='sp-preview']")
	public WebElement iconhovercolor;
	
	@FindBy(xpath="//div[@id='fitem_id_button-secondary-color-background']//div[@class='sp-preview-inner']")
	public WebElement backgroundcolor;
	
	@FindBy(xpath="//div[@id='fitem_id_button-secondary-color-background-hover']//div[@class='sp-preview-inner']")
	public WebElement backgroundhovercolor;
	
	@FindBy(xpath="//div[@id='fitem_id_button-secondary-border-color']//div[@class='sp-preview-inner']")
	public WebElement bordercolor;
	
	@FindBy(xpath="//div[@id='fitem_id_button-secondary-border-color-hover']//div[@class='sp-preview-inner']")
	public WebElement borderhovercolor;
}
