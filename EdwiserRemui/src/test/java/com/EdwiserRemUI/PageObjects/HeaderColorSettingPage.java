package com.EdwiserRemUI.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HeaderColorSettingPage extends BasePage {

	public HeaderColorSettingPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//h6[text()='Header']")
	public WebElement headermenu;

	@FindBy(xpath = "//h6[text()='Header logo settings']")
	public WebElement headerlogosetting;

	@FindBy(xpath = "//div[@id='fitem_id_logo-bg-color']//div[@class='sp-preview-inner']")
	public WebElement logobgcolor;

	@FindBy(id = "id_logoorsitename")
	public WebElement LogoType;

	public Select LogoType(WebElement LogoType) {
		Select type = new Select(LogoType);
		return type;
	}
	
	@FindBy(xpath="//nav[contains(@class,'navbar fixed-top')]//*[contains(@class,'navbar-brand-logo')]")
	public WebElement SiteLogoFormat;
	
	@FindBy(xpath="//*[@class='navbar-brand-logo iconsitename']/i")
	public WebElement SiteIcon;
	

	@FindBy(xpath = "//select[@id='id_logoorsitename']//option[@value='iconsitename']")
	public WebElement iconsiteformat;

	@FindBy(id = "id_siteicon")
	public WebElement SiteIconInput;

	@FindBy(id = "id_header-site-identity-fontsize")
	public WebElement HeaderIconFontSize;

	@FindBy(id = "id_header-site-identity-fontsize-tablet")
	public WebElement HeaderIconFontSizeTablet;

	@FindBy(xpath = "//a[@class='navbar-brand d-none d-md-flex align-items-center m-0 aabtn']")
	public WebElement logobgcolorelement;

	@FindBy(xpath = "//div[@id='fitem_id_sitenamecolor']//div[@class='sp-preview-inner']")
	public WebElement sitenamecolor;

	@FindBy(xpath = "//nav[@class='navbar fixed-top navbar-expand left  ']//a//span[@class='navbar-brand-logo iconsitename']")
	public WebElement sitenamecolorelement;

	@FindBy(xpath = "//h6[text()='Header design settings']")
	public WebElement headerdesignsettingmenu;

	@FindBy(xpath = "//h6[text()='Header colors']")
	public WebElement headercolormenu;

	@FindBy(xpath = "//input[@id='id_navbarinverse']")
	public WebElement bgcolorcheckbox;

	@FindBy(xpath = "//div[@class='sub-nav']")
	public WebElement navsubbarelement;

	@FindBy(xpath = "//div[@class='sp-container sp-light sp-palette-buttons-disabled sp-initial-disabled border-secondary']//button[@type='button'][normalize-space()='Choose']")
	public WebElement choosebutton;

	@FindBy(xpath = "//div[@class='sp-container sp-light sp-alpha-enabled sp-palette-buttons-disabled sp-initial-disabled border-secondary']//button[@type='button'][normalize-space()='Choose']")
	public WebElement choosebutton_2;

	@FindBy(xpath = "//label[contains(text(),'Set Header Background color same as logo backgroun')]")
	public WebElement enableheaderbgcoloraslogobgcolor;

	@FindBy(xpath = "//div[@id='fitem_id_header-menu-background-color']//div[@class='sp-preview-inner']")
	public WebElement headerbgcolor;

	@FindBy(xpath = "//div[@class='sp-container sp-light sp-alpha-enabled sp-palette-buttons-disabled sp-initial-disabled border-secondary']//input[@type='text']")
	public WebElement color_input_2;

	@FindBy(xpath = "//div[@id='fitem_id_header-menu-text-color']//div[@class='sp-preview-inner']")
	public WebElement menuitemcolor;

	@FindBy(xpath = "//div[@id='fitem_id_header-menu-text-hover-color']//div[@class='sp-preview-inner']")
	public WebElement menuitemhovercolor;

	@FindBy(xpath = "//div[@id='fitem_id_header-menu-text-active-color']//div[@class='sp-preview-inner']")
	public WebElement menuitemactivecolor;

	@FindBy(xpath = "//div[@id='fitem_id_header-menu-element-bg-color']//div[@class='sp-preview-inner']")
	public WebElement elementbgcolor;

	@FindBy(xpath = "//div[@id='fitem_id_header-menu-divider-bg-color']//div[@class='sp-preview-inner']")
	public WebElement elementdividercolor;

	@FindBy(xpath = "//a[contains(@role,'menuitem')][normalize-space()='Home']")
	public WebElement headermenuelement;

	@FindBy(xpath = "//a[contains(@role,'menuitem')][normalize-space()='Dashboard']")
	public WebElement dashboardmenuelement;

	@FindBy(xpath = "//span[@class='custom-control-label']")
	public WebElement EditModeSwitch;

	@FindBy(xpath = "//a[contains(@class,'catselector-menu')]")
	public WebElement CategoryMenu;

	@FindBy(xpath = "(//div[contains(@class,'usermenu-wrapper')]//div[contains(@class,'divider')])[1]")
	public WebElement H_ElementDivider;

	@FindBy(xpath = "//h6[text()='Header icon color']")
	public WebElement headericonmenu;

	@FindBy(xpath = "//div[@id='fitem_id_hds-icon-color']//div[@class='sp-preview-inner']")
	public WebElement iconcolor;

	@FindBy(xpath = "//div[@id='fitem_id_hds-icon-hover-color']//div[@class='sp-preview-inner']")
	public WebElement iconhovercolor;

	@FindBy(xpath = "//div[@id='fitem_id_hds-icon-active-color']//div[@class='sp-preview-inner']")
	public WebElement iconactivecolor;

	@FindBy(xpath = "//i[@title='Toggle notifications menu']")
	public WebElement headericonelement;

	@FindBy(xpath = "//nav[@aria-label='Site navigation']")
	public WebElement SiteHeaderNav;

	@FindBy(xpath = "//h6[text()='Header box shadow']")
	public WebElement headerBoxShadowmenu;

	@FindBy(id = "id_hds-boxshadow-enable")
	public WebElement headerBoxShadowCheckbox;

	@FindBy(xpath = "(//label[@for='id_hds-boxshadow-enable'])[1]")
	public WebElement EnableHeaderBoxShadowLabel;

	@FindBy(id = "id_header-primary-border-bottom-size")
	public WebElement headerBoxShadowBottomSize;

	@FindBy(id = "id_header-primary-border-bottom-blur")
	public WebElement headerBoxShadowBlur;

	@FindBy(xpath = "//div[@id='fitem_id_header-primary-border-bottom-color']//div[@class='sp-preview-inner']")
	public WebElement HeaderBorderShadowColor;

	@FindBy(id = "edw-quick-menu")
	public WebElement QuickMenu;

	@FindBy(xpath = "//div[@id='edw-quick-menu' and contains(@class,'collapsed')]")
	public List<WebElement> QuickMenuCollapsed;

}
