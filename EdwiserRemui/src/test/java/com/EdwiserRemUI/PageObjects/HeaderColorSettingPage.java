package com.EdwiserRemUI.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderColorSettingPage extends BasePage {

	public HeaderColorSettingPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//h6[text()='Header']")
	public WebElement headermenu;
	
	@FindBy(xpath="//h6[text()='Header logo settings']")
	public WebElement headerlogosetting;

	@FindBy(xpath="//div[@id='fitem_id_logo-bg-color']//div[@class='sp-preview-inner']")
	public WebElement logobgcolor;
	
	@FindBy(xpath="//select[@id='id_logoorsitename']//option[@value='iconsitename']")
	public WebElement iconsiteformat;
	
	@FindBy(xpath="//a[@class='navbar-brand d-none d-md-flex align-items-center m-0 aabtn']")
	public WebElement logobgcolorelement;
	
	@FindBy(xpath="//div[@id='fitem_id_sitenamecolor']//div[@class='sp-preview-inner']")
	public WebElement sitenamecolor;
	
	@FindBy(xpath="//nav[@class='navbar fixed-top navbar-expand left  ']//a//span[@class='navbar-brand-logo iconsitename']")
	public WebElement sitenamecolorelement;
	
	@FindBy(xpath="//h6[text()='Header design settings']")
	public WebElement headerdesignsettingmenu;
	
	@FindBy(xpath="//h6[text()='Header colors']")
	public WebElement headercolormenu;
	
	@FindBy(xpath="//input[@id='id_navbarinverse']")
	public WebElement bgcolorcheckbox;
	
	@FindBy(xpath="//div[@class='sub-nav']")
	public WebElement navsubbarelement;
	
	@FindBy(xpath="//div[@class='sp-container sp-light sp-palette-buttons-disabled sp-initial-disabled border-secondary']//button[@type='button'][normalize-space()='Choose']")
	public WebElement choosebutton;
	
	@FindBy(xpath="//label[contains(text(),'Set Header Background color same as logo backgroun')]")
	public WebElement enableheaderbgcoloraslogobgcolor;
	
	@FindBy(xpath="//div[@id='fitem_id_header-menu-background-color']//div[@class='sp-preview-inner']")
	public WebElement headerbgcolor;
	
	@FindBy(xpath="//div[@id='fitem_id_header-menu-text-color']//div[@class='sp-preview-inner']")
	public WebElement menuitemcolor;
	
	@FindBy(xpath="//div[@id='fitem_id_header-menu-text-hover-color']//div[@class='sp-preview-inner']")
	public WebElement menuitemhovercolor;
	
	@FindBy(xpath="//div[@id='fitem_id_header-menu-text-active-color']//div[@class='sp-preview-inner']")
	public WebElement menuitemactivecolor;
	
	@FindBy(xpath="//div[@id='fitem_id_header-menu-element-bg-color']//div[@class='sp-preview-inner']")
	public WebElement elementbgcolor;
	
	@FindBy(xpath="//div[@id='fitem_id_header-menu-divider-bg-color']//div[@class='sp-preview-inner']")
	public WebElement elementdividercolor;
	
	@FindBy(xpath="//a[contains(@role,'menuitem')][normalize-space()='Home']")
	public WebElement headermenuelement;
	
	@FindBy(xpath="//a[contains(@role,'menuitem')][normalize-space()='Dashboard']")
	public WebElement dashboardmenuelement;
	
	@FindBy(xpath="//h6[text()='Header icon color']")
	public WebElement headericonmenu;
	
	@FindBy(xpath="//div[@id='fitem_id_hds-icon-color']//div[@class='sp-preview-inner']")
	public WebElement iconcolor;
	
	@FindBy(xpath="//div[@id='fitem_id_hds-icon-hover-color']//div[@class='sp-preview-inner']")
	public WebElement iconhovercolor;
	
	@FindBy(xpath="//div[@id='fitem_id_hds-icon-active-color']//div[@class='sp-preview-inner']")
	public WebElement iconactivecolor;
	
	@FindBy(xpath="//i[@title='Toggle notifications menu']")
	public WebElement headericonelement;
}
