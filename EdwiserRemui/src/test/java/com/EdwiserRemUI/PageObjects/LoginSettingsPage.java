package com.EdwiserRemUI.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginSettingsPage extends BasePage {

	public LoginSettingsPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//h6[text()='Login']")
	public WebElement loginMenu;

	@FindBy(xpath = "//button[@id='publish-settings']")
	public WebElement saveButton;

	// LogoSettings

	@FindBy(xpath = "//h6[text()='Logo settings']")
	public WebElement loginSetting;

	@FindBy(xpath = "//select[@id='id_brandlogopos']") // Use this while using select
	public WebElement showLogoOnLoginPage;

	// LoginFromSettings

	@FindBy(xpath = "//h6[text()='Login form settings']")
	public WebElement loginFromSettings;

	@FindBy(xpath = "//select[@id='id_loginpagelayout']") // Use this while using select
	public WebElement loginFormPosition;

	@FindBy(xpath = "//div[@id='fitem_id_loginpaneltextcolor']//div[@class='sp-preview-inner']")
	public WebElement welcomeTextColor;

	@FindBy(xpath = "//div[@id='fitem_id_loginpanelcontentcolor']//div[@class='sp-preview-inner']")
	public WebElement textColor;

	@FindBy(xpath = "//div[@id='fitem_id_loginpanellinkcolor']//div[@class='sp-preview-inner']")
	public WebElement linkColor;

	@FindBy(xpath = "//div[@id='fitem_id_loginpanellinkhovercolor']//div[@class='sp-preview-inner']")
	public WebElement linkHoverColor;

	@FindBy(xpath = "//div[@id='fitem_id_loginpanelbackgroundcolor']//div[@class='sp-preview-inner']")
	public WebElement pageBackgroundColor;

	@FindBy(xpath = "//div[@class='sp-container sp-light sp-palette-buttons-disabled sp-initial-disabled border-secondary']//input[@type='text']")
	public WebElement colorTextField;

	@FindBy(xpath = "//div[@class='sp-container sp-light sp-palette-buttons-disabled sp-initial-disabled border-secondary']//button[@type='button'][normalize-space()='Choose']")
	public WebElement chooseButton;

	
	// LoginPageSettings

	@FindBy(xpath = "//h6[text()='Login page settings']")
	public WebElement loginPageSettings;

	@FindBy(xpath = "//select[@id='id_login-page-setting']") // Use this while using select
	public WebElement pageBackgroundStyle;

	@FindBy(xpath = "//div[@id='fitem_id_loginpagebackgroundcolor']//div[@class='sp-preview-inner']")
	public WebElement seletcBackgroundColor;

	@FindBy(xpath = "//div[@id = 'fitem_id_login-page-backgroundgradient1']//div[@class = 'color-input']")
	public WebElement gradientColor1;

	@FindBy(xpath = "//div[@id = 'fitem_id_login-page-backgroundgradient2']//div[@class = 'color-input']")
	public WebElement gradientColor2;
	
	@FindBy(xpath = "//div[@id='fitem_id_loginpagebackgroundcolor']//div[@class='sp-preview-inner']")
	public WebElement pageColor;

	@FindBy(xpath = "//iframe[@id='id_brandlogotext_ifr']")
	public WebElement siteDescription;
	
	@FindBy(id = "id_brandlogotexteditable")
	public WebElement siteDescriptionInput;

	@FindBy(id = "id_brandlogotexteditable")
	public WebElement siteLoginDescription;

	@FindBy(xpath = "//div[@id='id_brandlogotexteditable']/p")
	public WebElement siteLoginDescriptionText;

	@FindBy(xpath = "//body//p[1]")
	public WebElement siteDescriptionText;

	@FindBy(xpath = "//div[@id='fitem_id_signuptextcolor']//div[@class='sp-preview-inner']")
	public WebElement siteDescriptionColor;

	// Frontend

	@FindBy(xpath = "//a[@id='user-menu-toggle']")
	public WebElement menuExpand;

	@FindBy(xpath = "//a[@title='Log out']")
	public WebElement logout;

	@FindBy(xpath = "//div[@class='login-container']//*[contains(@class,'navbar-brand-logo')]")
	public List<WebElement> logoOnLoginCard;

	@FindBy(xpath = "//*[contains(@class,'navbar-brand-logo')]")
	public List<WebElement> logoOnLoginPage;

	@FindBy(xpath = "//div[@class='login-description-container']//*[contains(@class,'navbar-brand-logo')]")
	public List<WebElement> logoOnCentralRegion;

	@FindBy(xpath = "//body")
	public WebElement loginFormPositionFrontend; // Need to verify - logincenter, loginright, loginleft

	@FindBy(xpath = "//div[@class='login-welcome-wrapper d-flex flex-column flex-gap-1 text-center']//h2")
	public WebElement welcomeTextFrontend;

	@FindBy(xpath = "//label[@class='text-link-semibold form-label-color'][normalize-space()='Username']")
	public WebElement textColorFrontend;

	@FindBy(xpath = "//a[normalize-space()='Forgot your password?']") // Same can be used for link hover color
	public WebElement linkColorFrontend;

	@FindBy(xpath = "//div[@class='login-container']")
	public WebElement pageBackgroundColorFrontend;

	@FindBy(xpath = "//div[@id='page']")
	public WebElement loginPageBackground;

	@FindBy(xpath = "//div[@class='login-description']")
	public WebElement loginDescriptionText;

	@FindBy(xpath = "//div[@class='login-description']")
	public WebElement siteDescriptionTextColor;

}
