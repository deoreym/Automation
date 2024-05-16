package com.EdwiserRemUI.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FooterBottomAreaPage extends BasePage {
	
	public FooterBottomAreaPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath = "//button[@id='publish-settings']")
	public WebElement saveButton;
	
	@FindBy(xpath = "//h6[normalize-space()='Footer']")
	public WebElement footerMenu;
	
	@FindBy(xpath = "//h6[normalize-space()='Footer bottom area']")
	public WebElement footerBottomArea;
	
	@FindBy(xpath = "//input[@name='footershowlogo']")		//isSelected method is used, in this xpath's css checked key should be present
	public WebElement showLogo;
	
	@FindBy(xpath = "//div[@id='fitem_id_footershowlogo']//div[@data-fieldtype='checkbox']")		// used to toggle the button
	public WebElement showLogoToggle;
	
	@FindBy(xpath = "//input[@name='useheaderlogo']")		//verification
	public WebElement useTheSameLogoFromHeader;
	
	@FindBy(xpath = "//div[@id='fitem_id_useheaderlogo']//div[@data-fieldtype='checkbox']")		//toggle
	public WebElement useTheSameLogoFromHeaderToggle;
	
	@FindBy(xpath = "//input[@name='footerprivacypolicyshow']")		//verification
	public WebElement showPrivacyPolicy;
	
	@FindBy(xpath = "//div[@id='fitem_id_footerprivacypolicyshow']//div[@data-fieldtype='checkbox']")		//toggle
	public WebElement showPrivacyPolicyToggle;
	
	@FindBy(xpath = "//input[@id='id_footerprivacypolicy']")
	public WebElement privacyPolicyLink;
	
	@FindBy(xpath = "//input[@name='privacypolicynewtab']")		//verification
	public WebElement openInNewTab;
	
	@FindBy(xpath = "//div[@id='fitem_id_privacypolicynewtab']//div[@data-fieldtype='checkbox']")		//toggle
	public WebElement openInNewTabToggle;
	
	@FindBy(xpath = "//input[@name='footertermsandconditionsshow']")		//verification
	public WebElement showTermsAndConditions;
	
	@FindBy(xpath = "//div[@id='fitem_id_footertermsandconditionsshow']//div[@data-fieldtype='checkbox']")		//toggle
	public WebElement showTermsAndConditionsToggle;
	
	@FindBy(xpath = "//input[@name='footertermsandconditions']")
	public WebElement termsAndConditionContent;
	
	@FindBy(xpath = "//input[@name='footercopyrightsshow']")		//verification
	public WebElement showCopyrightContent;
	
	@FindBy(xpath = "//div[@id='fitem_id_footercopyrightsshow']//div[@data-fieldtype='checkbox']")		//toggle
	public WebElement showCopyrightContentToggle;
	
	@FindBy(xpath = "//textarea[@name='footercopyrights']")
	public WebElement copyrightContent;
	
	@FindBy(xpath = "//textarea[@id='id_footercopyrights']")		//toggle
	public WebElement copyrightContentToggle;
	
	@FindBy(xpath = "//input[@name='poweredbyedwiser']")		//verification
	public WebElement poweredByEdwiser;
	
	@FindBy(xpath = "//div[@id='fitem_id_poweredbyedwiser']//div[@data-fieldtype='checkbox']")		//toggle
	public WebElement poweredByEdwiserToggle;
	
	@FindBy(xpath="//a[contains(@class,'footer-privacy-policy')]")
	public WebElement f_privacypolicy;
	
	@FindBy(xpath="//a[contains(@class,'footer-terms-and-conditions')]")
	public WebElement f_TnC;

	
	//Home Page
	
	@FindBy(xpath = "//div[contains(@class,'secondary-footer-logo')]//*[contains(@class,'navbar-brand-logo')]/i")
	public WebElement sameFooterIconAsHeader;
	
	@FindBy(xpath = "//div[@class='footer-diff-logo ']//a//img")
	public WebElement differentFooterLogo;
	
	@FindBy(xpath = "//a[normalize-space()='Privacy Policy']")
	public WebElement privacyPoilcy;
	
	@FindBy(xpath = "//a[normalize-space()='Terms & Conditions']")
	public WebElement TermsandConditons;
	
	@FindBy(xpath = "//div[contains(@class,'copyright-content')]")
	public WebElement CopyrightDiv;
	
	@FindBy(xpath = "//div[contains(@class,'copyright-content')]//p")
	public WebElement Copyright;
	
	@FindBy(xpath = "//button[@aria-label='Show footer']")
	public WebElement footerIcon;
	
	@FindBy(xpath = "//div[@class='popover-body']//div[@class='footer-poweredby']")
	public WebElement poweredByEdwiserFrontend;
	
}
