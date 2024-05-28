package com.EdwiserRemUI.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FooterColorSettingPage extends BasePage{

	public FooterColorSettingPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//h6[text()='Footer design']")
	public WebElement footerdesignmenu;
	
	@FindBy(xpath="//h6[text()='Colors']")
	public WebElement colorsmenu;
	
	@FindBy(xpath="//h6[text()='Footer colors']")
	public WebElement footercolorsmenu;
	
	@FindBy(xpath="//div[@id='fitem_id_footer-background-color']//div[@class='sp-preview-inner']")
	public WebElement footerbgcolor;
	
	@FindBy(xpath="//div[@id='fitem_id_footer-text-color']//div[@class='sp-preview-inner']")
	public WebElement footertextcolor;
	
	@FindBy(xpath="//div[@id='fitem_id_footer-divider-color']//div[@class='sp-preview-inner']")
	public WebElement footerdividercolor;
	
	@FindBy(xpath="//h6[text()='Footer links']")
	public WebElement footerlinkmenu;
	
	@FindBy(xpath="//h6[text()='Column title']")
	public WebElement columntitlemenu;
	
	@FindBy(xpath="//div[@id='fitem_id_footer-columntitle-color']//div[@class='sp-preview-inner']")
	public WebElement columntitlecolor;
	
	@FindBy(xpath="//div[@id='fitem_id_footer-link-text']//div[@class='sp-preview-inner']")
	public WebElement linktextcolor;
	
	@FindBy(xpath="//div[@id='fitem_id_footer-link-hover-text']//div[@class='sp-preview-inner']")
	public WebElement linkhovertextcolor;
	
	@FindBy(xpath="//h6[text()='Footer icons']")
	public WebElement footericonmenu;
	
	@FindBy(xpath="//div[@id='fitem_id_footer-icon-color']//div[@class='sp-preview-inner']")
	public WebElement iconcolor;
	
	@FindBy(xpath="//div[@id='fitem_id_footer-icon-hover-color']//div[@class='sp-preview-inner']")
	public WebElement iconhovercolor;
	
	@FindBy(id="page-footer")
	public WebElement footerbgelement;
	
	@FindBy(xpath="//div[@id='footer-column-1']//p[@class='p-0 m-0']")
	public WebElement textcolorelement;
	
	@FindBy(xpath="//hr[@class='d-block mb-0']")
	public WebElement dividercolorelement;
	
	@FindBy(xpath="(//footer[@id='page-footer']//div//div//a[contains(text(), 'Purge all caches')])")
	public WebElement linkcolorelement;
	
	@FindBy(xpath="//div[@class='contentsocial social-links ']//a[1]//i")
	public WebElement socialiconelement;
	
	@FindBy(xpath="(//div[@id='footer-column-1']//h6)[1]")
	public WebElement columntitlecolorelement;
	

}
