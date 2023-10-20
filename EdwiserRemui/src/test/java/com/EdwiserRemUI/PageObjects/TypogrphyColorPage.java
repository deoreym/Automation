package com.EdwiserRemUI.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TypogrphyColorPage extends BasePage {

	public TypogrphyColorPage(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(xpath="//h6[text()='Typography']")
	public WebElement typographymenu;
	
	@FindBy(xpath="//h6[text()='Text link']")
	public WebElement textlinkmenu;
	
	@FindBy(xpath="//div[@id='fitem_id_global-typography-body-linkcolor']//div[@class='sp-preview-inner']")
	public WebElement linkcolor;
	
	@FindBy(xpath="//div[@id='linkroot']//div[@class='container-fluid']//div[1]//div[2]//ul[1]//li[1]//a")
	public WebElement linkcolorelement;
	
	@FindBy(xpath="//div[@id='fitem_id_global-typography-body-linkhovercolor']//div[@class='sp-preview-inner']")
	public WebElement linkhovercolor;

}
