package com.EdwiserRemUI.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class FooterSettingsPage extends BasePage {

	public FooterSettingsPage(WebDriver driver) {
		super(driver);
	}

	// Visit Settings tab
	public void siteVisit(String BaseURL) {
		driver.get(BaseURL + "admin/settings.php?section=themesettingremui");
	}

	// DropDown
	public Select DropDown(WebElement e) {
		return new Select(e);
	}

	// Editor
	@FindBy(tagName = "body")
	public WebElement editor;

	// Save Settings
	@FindBy(xpath = "//button[text()='Save changes']")
	public WebElement savebutton;

	// Footer Tab in RemUI Settings
	@FindBy(xpath = "//a[@href='#theme_remui_footer']")
	public WebElement footerTab;

	// Footer Column DropDown (Adjust widget width)
	@FindBy(id = "id_s_theme_remui_footercolumn")
	public WebElement footerColumn;

	// Footer Column 1 - Type
	@FindBy(id = "id_s_theme_remui_footercolumn1type")
	public WebElement footerColumn_1_Type;

	// Footer Column 2 - Type
	@FindBy(id = "id_s_theme_remui_footercolumn2type")
	public WebElement footerColumn_2_Type;

	// Footer Column 3 - Type
	@FindBy(id = "id_s_theme_remui_footercolumn3type")
	public WebElement footerColumn_3_Type;

	// Footer Column 4 - Type
	@FindBy(id = "id_s_theme_remui_footercolumn4type")
	public WebElement footerColumn_4_Type;

	// Footer Column 1 - Title
	@FindBy(id = "id_s_theme_remui_footercolumn1title")
	public WebElement footerColumn_1_Title;

	// Footer Column 2 - Title
	@FindBy(id = "id_s_theme_remui_footercolumn2title")
	public WebElement footerColumn_2_Title;

	// Footer Column 3 - Title
	@FindBy(id = "id_s_theme_remui_footercolumn3title")
	public WebElement footerColumn_3_Title;

	// Footer Column 4 - Title
	@FindBy(id = "id_s_theme_remui_footercolumn4title")
	public WebElement footerColumn_4_Title;

	// Footer Content 1 iFrame
	@FindBy(xpath = "//iframe[@id='id_s_theme_remui_footercolumn1customhtml_ifr']")
	public WebElement FooterColumn_1_iFrame;

	// Footer Content 2 iFrame
	@FindBy(xpath = "//iframe[@id='id_s_theme_remui_footercolumn2customhtml_ifr']")
	public WebElement FooterColumn_2_iFrame;

	// Footer Content 3 iFrame
	@FindBy(xpath = "//iframe[@id='id_s_theme_remui_footercolumn3customhtml_ifr']")
	public WebElement FooterColumn_3_iFrame;

	// Footer Content 4 iFrame
	@FindBy(xpath = "//iframe[@id='id_s_theme_remui_footercolumn4customhtml_ifr']")
	public WebElement FooterColumn_4_iFrame;

	// Footer Content 1
	@FindBy(id = "id_s_theme_remui_footercolumn1customhtmleditable")
	public WebElement FooterColumn_1_Div;

	// Footer Content 2
	@FindBy(id = "id_s_theme_remui_footercolumn2customhtmleditable")
	public WebElement FooterColumn_2_Div;

	// Footer Content 3
	@FindBy(id = "id_s_theme_remui_footercolumn3customhtmleditable")
	public WebElement FooterColumn_3_Div;

	// Footer Content 4
	@FindBy(id = "id_s_theme_remui_footercolumn4customhtmleditable")
	public WebElement FooterColumn_4_Div;

	// Footer Content 1 Menu Text Area
	@FindBy(xpath = "//textarea[@id='id_s_theme_remui_footercolumn1menu']")
	public WebElement FooterColumn_1_TextArea;

	// Footer Content 2 Menu Text Area
	@FindBy(xpath = "//textarea[@id='id_s_theme_remui_footercolumn2menu']")
	public WebElement FooterColumn_2_TextArea;

	// Footer Content 3 Menu Text Area
	@FindBy(xpath = "//textarea[@id='id_s_theme_remui_footercolumn3menu']")
	public WebElement FooterColumn_3_TextArea;

	// Footer Content 4 Menu Text Area
	@FindBy(xpath = "//textarea[@id='id_s_theme_remui_footercolumn4menu']")
	public WebElement FooterColumn_4_TextArea;

	/**
	 * Bottom Footer Setting
	 */

	// Footer Bottom-Left Text
	@FindBy(id = "id_s_theme_remui_footerbottomtext")
	public WebElement FooterBottomLeftText;

	// Footer Bottom-Left Link
	@FindBy(id = "id_s_theme_remui_footerbottomlink")
	public WebElement FooterBottomLeftLink;

	// Show Copyrights Content - Checkbox
	@FindBy(id = "id_s_theme_remui_footercopyrightsshow")
	public WebElement Show_Copyrights_Content_Checkbox;

	@FindBy(xpath = "//input[@id='id_s_theme_remui_footercopyrightsshow']/..")
	public WebElement Show_Copyrights_Content_Checkbox_ele;

	// Show Copyrights Content - Content
	@FindBy(id = "id_s_theme_remui_footercopyrights")
	public WebElement Show_Copyrights_Content_Content;

	// Show Logo -Checkbox
	@FindBy(id = "id_s_theme_remui_footershowlogo")
	public WebElement ShowLogo_Checkbox;

	@FindBy(xpath = "//input[@id='id_s_theme_remui_footershowlogo']/..")
	public WebElement ShowLogo_Checkbox_ele;

	// Show Terms & Conditions - Checkbox
	@FindBy(id = "id_s_theme_remui_footertermsandconditionsshow")
	public WebElement Show_TermsConditions;

	@FindBy(xpath = "//input[@id='id_s_theme_remui_footertermsandconditionsshow']/..")
	public WebElement Show_TermsConditions_ele;

	// Show Terms & Conditions - Link
	@FindBy(id = "id_s_theme_remui_footertermsandconditions")
	public WebElement Show_TermsConditions_Link;

	// Show Privacy Policy - Checkbox
	@FindBy(id = "id_s_theme_remui_footerprivacypolicyshow")
	public WebElement Show_PrivacyPolicy;
	@FindBy(xpath = "//input[@id='id_s_theme_remui_footerprivacypolicyshow']/..")
	public WebElement Show_PrivacyPolicy_ele;

	// Show Privacy Policy - Link
	@FindBy(id = "id_s_theme_remui_footerprivacypolicy")
	public WebElement Show_PrivacyPolicy_link;

	// Powered by Edwiser
	@FindBy(id = "id_s_theme_remui_poweredbyedwiser")
	public WebElement Show_PoweredByEdwiser;

	@FindBy(xpath = "//input[@id='id_s_theme_remui_poweredbyedwiser']/..")
	public WebElement Show_PoweredByEdwiser_ele;

	/**
	 * Social Media Links Settings
	 */
	@FindBy(id = "id_s_theme_remui_facebooksetting")
	public WebElement Facebook;

	@FindBy(id = "id_s_theme_remui_twittersetting")
	public WebElement Twitter;

	@FindBy(id = "id_s_theme_remui_linkedinsetting")
	public WebElement Linkedin;

	@FindBy(id = "id_s_theme_remui_gplussetting")
	public WebElement Google_Plus;

	@FindBy(id = "id_s_theme_remui_youtubesetting")
	public WebElement YouTube;

	@FindBy(id = "id_s_theme_remui_instagramsetting")
	public WebElement Instagram;

	@FindBy(id = "id_s_theme_remui_pinterestsetting")
	public WebElement Pinterest;

	@FindBy(id = "id_s_theme_remui_quorasetting")
	public WebElement Quora;

	/**
	 * FrontEnd Footer Elements
	 */
	// Footer Column 1 - Title
	@FindBy(xpath = "(//div[@id='footer-column-1']//h6[contains(@class,'ftr-column-title')])[2]")
	public WebElement FC_1_Title;

	// Footer Column 2 - Title
	@FindBy(xpath = "(//div[@id='footer-column-2']//h6[contains(@class,'ftr-column-title')])[2]")
	public WebElement FC_2_Title;

	// Footer Column 3 - Title
	@FindBy(xpath = "(//div[@id='footer-column-3']//h6[contains(@class,'ftr-column-title')])[2]")
	public WebElement FC_3_Title;

	// Footer Column 4 - Title
	@FindBy(xpath = "(//div[@id='footer-column-4']//h6[contains(@class,'ftr-column-title')])[1]")
	public WebElement FC_4_Title;

	// Footer 1 Content
	@FindBy(xpath = "//div[@id='footer-column-1']//*[@class='section-html-content']")
	public WebElement FC_1_Content_D;

	// Footer 1 Content
	@FindBy(xpath = "//div[@id='footer-column-1']//*[@class='section-html-content']//p")
	public WebElement FC_1_Content;

	// Footer 2 Content
	@FindBy(xpath = "//div[@id='footer-column-2']//*[@class='section-html-content']//p")
	public WebElement FC_2_Content;

	// Footer 3 Content
	@FindBy(xpath = "//div[@id='footer-column-3']//*[@class='section-html-content']//p")
	public WebElement FC_3_Content;

	// Footer 4 Content
	@FindBy(xpath = "//div[@id='footer-column-4']//*[@class='section-html-content']//p")
	public WebElement FC_4_Content;

	// Footer 4 Content - Menu Link 1
	@FindBy(xpath = "(//div[@id='footer-column-4']//*[@class='footer-menu-list']//a)[1]")
	public WebElement FC_4_Content_Menu_1;

	// Footer 4 Content - Menu Link 2
	@FindBy(xpath = "(//div[@id='footer-column-4']//*[@class='footer-menu-list']//a)[2]")
	public WebElement FC_4_Content_Menu_2;

	/**
	 * Bottom Footer
	 */
	// Footer Bottom Left Link
	@FindBy(xpath = "//a[@class='footer-bottomtext']")
	public WebElement F_Bottom_Left_Link;

	// Footer Bottom Left Text
	@FindBy(xpath = "//a[@class='footer-bottomtext']/div")
	public WebElement F_Bottom_Left_Text;

	// Footer Bottom Left Text
	@FindBy(xpath = "//a[@class='footer-bottomtext']/div")
	public List<WebElement> F_Bottom_Left_Text_size;

//	@FindBy(xpath = "//div[@class='copyright-content secondary-footer-copyright ']/p")
//	public WebElement c_copyrighttext;
//
//	@FindBy(xpath = "//div[@class='d-flex align-items-center flex-gap-d5']//label[@for='id_poweredbyedwiser']")
//	public WebElement c_poweredbyed;
//
//	@FindBy(xpath = "//a[text()='Privacy Policy']")
//	public List<WebElement> f_privacypolicy;
//
//	@FindBy(linkText = "Privacy Policy")
//	public WebElement f_privacypolicy1;

	// Footer Terms and Condition
	@FindBy(xpath = "//a[contains(@class,'footer-terms-and-conditions')]")
	public List<WebElement> Footer_Terms_Conditions;

	// Footer Terms and Condition Link
	@FindBy(xpath = "//a[contains(@class,'footer-terms-and-conditions')]")
	public WebElement Footer_Terms_Conditions_link;

	// Footer Privacy Policy
	@FindBy(xpath = "//a[contains(@class,'footer-privacy-policy')]")
	public List<WebElement> Footer_Privacy_Policy;

	// Footer Privacy Policy Link
	@FindBy(xpath = "//a[contains(@class,'footer-privacy-policy')]")
	public WebElement Footer_Privacy_Policy_link;

	// Copyrights Content -Text
	@FindBy(xpath = "//div[contains(@class,'copyright-content')]/p")
	public WebElement Copyrights_Content_Text;

	// Copyrights Content
	@FindBy(xpath = "//div[contains(@class,'copyright-content')]")
	public WebElement Copyrights_Content;

	// Footer Logo
	@FindBy(xpath = "//*[contains(@class,' secondary-footer-logo')]//div[1]")
	public WebElement Footer_Logo_img;

	// Footer Logo
	@FindBy(xpath = "//*[contains(@class,' secondary-footer-logo')]")
	public List<WebElement> Footer_Logo;

	// Footer Help Icon
	@FindBy(xpath = "//span[@class='edw-icon edw-icon-Help']")
	public WebElement f_helpicon;

	// Footer Powered By Edwiser Remui
	@FindBy(xpath = "//div[@class='popover-body']//a[normalize-space()='Edwiser RemUI']")
	public List<WebElement> Powered_By_Edwiser;

	// Footer Powered By Edwiser Remui - Link
	@FindBy(xpath = "//div[@class='popover-body']//a[normalize-space()='Edwiser RemUI']")
	public WebElement Powered_By_Edwiser_link;
}
