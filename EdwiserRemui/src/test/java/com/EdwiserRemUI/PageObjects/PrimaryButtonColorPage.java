package com.EdwiserRemUI.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PrimaryButtonColorPage extends BasePage {

	public PrimaryButtonColorPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//h6[text()='Buttons']")
	public WebElement buttonmenu;
	
	@FindBy(xpath="//h6[text()='Button Color Settings']")
	public WebElement buttoncolorsettingmenu;
	
	@FindBy(xpath="//h6[text()='Primary']")
	public WebElement primarybuttonmenu;
	
	@FindBy(xpath="//div[@id='fitem_id_button-primary-color-text']//div[@class='sp-preview-inner']")
	public WebElement textcolor;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	public WebElement primarybutton;
	
	@FindBy(xpath="//div[@id='fitem_id_button-primary-color-text-hover']//div[@class='sp-preview-inner']")
	public WebElement texthovercolor;
	
	@FindBy(xpath="//div[@id='fitem_id_button-primary-color-icon']//div[@class='sp-preview-inner']")
	public WebElement iconcolor;
	
	@FindBy(xpath="//div[@id='fitem_id_button-primary-color-icon-hover']//div[@class='sp-preview']")
	public WebElement iconhovercolor;
	
	@FindBy(xpath="//button[@class='btn btn-primary icon-no-margin p-0']//span//span")
	public WebElement primaryiconelement;
	
	@FindBy(xpath="//div[@id='fitem_id_button-primary-color-background']//div[@class='sp-preview-inner']")
	public WebElement backgroundcolor;
	
	@FindBy(xpath="//div[@id='fitem_id_button-primary-color-background-hover']//div[@class='sp-preview-inner']")
	public WebElement backgroundhovercolor;
	
	@FindBy(xpath="//div[@id='fitem_id_button-primary-border-color']//div[@class='sp-preview-inner']")
	public WebElement bordercolor;
	
	@FindBy(xpath="//div[@id='fitem_id_button-primary-border-color-hover']//div[@class='sp-preview-inner']")
	public WebElement borderhovercolor;
}

