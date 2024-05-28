package com.EdwiserRemUI.TestCases;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.EdwiserRemUI.BaseTest.BaseClass;
import com.EdwiserRemUI.PageObjects.BrandColorPage;
import com.EdwiserRemUI.PageObjects.CustomizerCustomCSS;
import com.EdwiserRemUI.PageObjects.FooterBottomAreaPage;
import com.EdwiserRemUI.PageObjects.FooterSocialMediaLinkPage;
import com.EdwiserRemUI.PageObjects.LoginSettingsPage;
import com.EdwiserRemUI.PageObjects.TypogrphyColorPage;

public class Customizer_Reset_Test extends BaseClass {

	CustomizerCustomCSS CC;
	FooterSocialMediaLinkPage fsmlp;
	FooterBottomAreaPage fbap;
	LoginSettingsPage lsp;
	BrandColorPage bcp;
	TypogrphyColorPage tcp;
	String URL = "https://www.example.com/";
	String Login_Message = "Welcome! to Edwiser site.";
	String CSS;
	String PPLink = "https://example.com.com/privacy-policy/";
	String TCLink = "https://example.com.com/terms-and-conditions/";
	String title = "Title 1";
	String content = "Footer Column 1 Text";

	@BeforeClass
	public void Before_class() throws InterruptedException {
		System.out.println("In Customizer Reset Test Class : Customizer_Reset_Test");
		CC = new CustomizerCustomCSS(driver);
		fsmlp = new FooterSocialMediaLinkPage(driver);
		fbap = new FooterBottomAreaPage(driver);
		lsp = new LoginSettingsPage(driver);
		bcp = new BrandColorPage(driver);
		tcp = new TypogrphyColorPage(driver);

		CSS = "li[title='Dashboard'] {\r\n" + "    color: #BB8FCE; \r\n" + "    background-color: #A6004E;\r\n"
				+ "    font-weight: 800; \r\n" + "}\r\n" + "li[title='Dashboard'] a {\r\n" + "            \r\n"
				+ "            color: #F9EFC1 !important; \r\n" + "          \r\n" + "}\r\n"
				+ "button.btn.btn-primary.btn-floating.d-none.d-md-flex.moodlehelpbtn {\r\n" + "            \r\n"
				+ "            background-color: #950048;\r\n" + "            color: #D6EAF8; \r\n" + "        }";
	}

	/**
	 * Test Simple Reset from customizer
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 1)
	public void Test_Simple_Reset_From_Custumizer() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		// Set Data
		Set_Non_Reset_Field_Data();

		// Reset customizer
		CC.ResetCustomizer.click();
		Thread.sleep(500);

		// Only Reset
		CC.Reset.click();
		Thread.sleep(2000);

		driver.get(customizer);

		// Check Login Description
		lsp.loginMenu.click();
		lsp.loginPageSettings.click();
		softAssert.assertTrue(lsp.siteLoginDescription.getText() != null,
				"On Simple Reset Login Description is Getting Removed");

		CC.CustomizerHome.click();
		Thread.sleep(500);

		// Check Footer TnC and Privacy Policy Link
		fbap.footerMenu.click();
		fbap.footerBottomArea.click();
		softAssert.assertTrue(fbap.privacyPolicyLink.getAttribute("value").contains(PPLink),
				"On Simple Reset Privacy Policy Link is Changed");
		softAssert.assertTrue(fbap.termsAndConditionContent.getAttribute("value").contains(TCLink),
				"On Simple Reset Terms and Condition Link is Changed");

		CC.CustomizerHome.click();
		Thread.sleep(500);

		// Check Footer Column Text
		fsmlp.footermenu.click();
		fsmlp.mainfooterareamenu.click();
		fsmlp.widget1menu.click();
		Thread.sleep(1500);
		softAssert.assertTrue(fsmlp.footercolumtitle.getAttribute("value").contains(title),
				"On Simple Reset Footer Column Title Text got Removed");
		softAssert.assertTrue(fsmlp.footercontenteditor.getText().contains(content),
				"On Simple Reset Footer Column Content Text got Removed");

		CC.CustomizerHome.click();
		Thread.sleep(500);
		// Check Social Media Links
		fsmlp.footermenu.click();
		fsmlp.socialmedialink.click();
		softAssert.assertTrue(fsmlp.fb.getAttribute("value").contains(URL),
				"On Simple Reset Social Media Links 'Facebook' got Removed");
		softAssert.assertTrue(fsmlp.twitter.getAttribute("value").contains(URL),
				"On Simple Reset Social Media Links 'Twitter' got Removed");
		softAssert.assertTrue(fsmlp.linkedin.getAttribute("value").contains(URL),
				"On Simple Reset Social Media Links 'LinkedIn' got Removed");
		softAssert.assertTrue(fsmlp.youtube.getAttribute("value").contains(URL),
				"On Simple Reset Social Media Links 'YouTube' got Removed");
		softAssert.assertTrue(fsmlp.instagram.getAttribute("value").contains(URL),
				"On Simple Reset Social Media Links 'Instagram' got Removed");

		CC.CustomizerHome.click();
		Thread.sleep(500);
		// Check Custom CSS
		CC.CustomCSS_Menu.click();

		softAssert.assertTrue(CC.CustomCSS_Input.getText() != null, "On Simple Reset Custom CSS is Getting Removed");
		softAssert.assertTrue(CC.CustomCSS_Input.getText().contains("li[title='Dashboard']"),
				"On Simple Reset Custom CSS is Getting Removed");

		softAssert.assertAll();

		// Check Default Site Colors and Typography
		Check_Default_Theme_Values();
	}

	/**
	 * Test Reset All From customizer
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 2)
	public void Reset_All_From_customizer() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();

		// Set Data
		Set_Non_Reset_Field_Data();

		// Reset customizer
		CC.ResetCustomizer.click();
		Thread.sleep(500);

		// Reset All
		CC.Reset_All.click();
		Thread.sleep(2000);

		driver.get(customizer);

		// Check Login Description
		lsp.loginMenu.click();
		lsp.loginPageSettings.click();
		softAssert.assertFalse(lsp.siteLoginDescription.getText().contains(Login_Message),
				"On Reset All Login Description is not Getting Removed");

		CC.CustomizerHome.click();
		Thread.sleep(500);

		// Check Footer TnC and Privacy Policy Link
		fbap.footerMenu.click();
		fbap.footerBottomArea.click();
		softAssert.assertFalse(fbap.privacyPolicyLink.getAttribute("value").contains(PPLink),
				"On Reset All Privacy Policy Link is not getting removed");
		softAssert.assertFalse(fbap.termsAndConditionContent.getAttribute("value").contains(TCLink),
				"On Reset All Terms and Condition Link is not getting removed");

		CC.CustomizerHome.click();
		Thread.sleep(500);

		// Check Footer Column Text
		fsmlp.footermenu.click();
		fsmlp.mainfooterareamenu.click();
		fsmlp.widget1menu.click();
		softAssert.assertFalse(fsmlp.footercolumtitle.getAttribute("value").contains(title),
				"On Reset All Footer Column Title Text is not getting removed");
		softAssert.assertFalse(fsmlp.footercontenteditor.getText().contains(content),
				"On Reset All Footer Column Content Text not getting removed");

		CC.CustomizerHome.click();
		Thread.sleep(500);
		// Check Social Media Links
		fsmlp.footermenu.click();
		fsmlp.socialmedialink.click();
		softAssert.assertFalse(fsmlp.fb.getAttribute("value").contains(URL),
				"On Reset All Social Media Links 'Facebook' not getting removed");
		softAssert.assertFalse(fsmlp.twitter.getAttribute("value").contains(URL),
				"On Reset All Social Media Links 'Twitter' not getting removed");
		softAssert.assertFalse(fsmlp.linkedin.getAttribute("value").contains(URL),
				"On Reset All Social Media Links 'LinkedIn' not getting removed");
		softAssert.assertFalse(fsmlp.youtube.getAttribute("value").contains(URL),
				"On Reset All Social Media Links 'YouTube' not getting removed");
		softAssert.assertFalse(fsmlp.instagram.getAttribute("value").contains(URL),
				"On Reset All Social Media Links 'Instagram' not getting removed");

		CC.CustomizerHome.click();
		Thread.sleep(500);
		// Check Custom CSS
		CC.CustomCSS_Menu.click();

		softAssert.assertFalse(CC.CustomCSS_Input.getText().contains("li[title='Dashboard']"),
				"On Reset All Custom CSS is Not Getting Removed 2");

		softAssert.assertAll();

		// Check Default Site Colors and Typography
		Check_Default_Theme_Values();
	}

	/**
	 * Check Theme Default Values on customizer Reset.
	 * 
	 * @throws InterruptedException
	 */
	public void Check_Default_Theme_Values() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();

		driver.get(customizer);
		bcp.globalmenu.click();
		bcp.themecolorsmenu.click();

		// Check Primary Color
		softAssert.assertEquals(bcp.primarycolor.getCssValue("background-color"), "rgba(0, 81, 249, 1)",
				"After Reset Default Primary Color Not set");
		// Check Accent Color
		softAssert.assertEquals(bcp.ascentcolor.getCssValue("background-color"), "rgba(55, 190, 113, 1)",
				"After Reset Default Accent Color Not set");
		// Check Text Color
		softAssert.assertEquals(bcp.textcolor.getCssValue("background-color"), "rgba(76, 90, 115, 1)",
				"After Reset Default Text Color Not set");
		// Check Border Color
		softAssert.assertEquals(bcp.bordercolor.getCssValue("background-color"), "rgba(213, 221, 234, 1)",
				"After Reset Default Border Color Not set");

		CC.CustomizerHome.click();
		bcp.globalmenu.click();
		tcp.typographymenu.click();
		tcp.BodyTypography.click();

		softAssert.assertEquals(tcp.FontFamily().getFirstSelectedOption().getText(), "Standard",
				"After Reset Default Font Family Not set as Standard");

		driver.get(FocusModeCoursePage);
		Thread.sleep(1500);

		softAssert.assertEquals(CC.primarycolortext.getCssValue("color"), "rgba(0, 81, 249, 1)",
				"After Reset Default Primary Color not Applied to Site Primary Elements - Admin Links");

		softAssert.assertEquals(CC.Accsent_Color.getCssValue("color"), "rgba(55, 190, 113, 1)",
				"After Reset Default Accent Color not Applied to Site");

		softAssert.assertEquals(CC.TextColorText.getCssValue("color"), "rgba(76, 90, 115, 1)",
				"After Reset Default Text Color not Applied to Site");

		softAssert.assertEquals(CC.Border_Color.getCssValue("border-bottom-color"), "rgba(213, 221, 234, 1)",
				"After Reset Default Border Color not Applied to Site");

		softAssert.assertAll();
	}

	/**
	 * Set Fields data which should not get reset on Simple Reset.
	 * 
	 * @throws InterruptedException
	 */
	public void Set_Non_Reset_Field_Data() throws InterruptedException {
		// Set Custom CSS
		driver.get(customizer);
		Thread.sleep(1500);

		// Visit Custom CSS Page
		CC.CustomCSS_Menu.click();
		Thread.sleep(1000);

		// Add Custom CSS
		CC.CustomCSS_Input.clear();

		CC.CustomCSS_Input.sendKeys(CSS);

		CC.CustomizerHome.click();
		Thread.sleep(500);

		// Set Social Links
		fsmlp.footermenu.click();
		fsmlp.socialmedialink.click();
		fsmlp.fb.clear();
		fsmlp.fb.sendKeys(URL);
		fsmlp.twitter.clear();
		fsmlp.twitter.sendKeys(URL);
		fsmlp.linkedin.clear();
		fsmlp.linkedin.sendKeys(URL);
		fsmlp.youtube.clear();
		fsmlp.youtube.sendKeys(URL);
		fsmlp.instagram.clear();
		fsmlp.instagram.sendKeys(URL);

		CC.CustomizerHome.click();
		Thread.sleep(500);

		// Save Privacy Policy and TnC links

		fbap.footerMenu.click();
		fbap.footerBottomArea.click();

		if (!fbap.showPrivacyPolicy.isSelected()) {
			fbap.showPrivacyPolicyToggle.click();
		}

		fbap.privacyPolicyLink.clear();
		fbap.privacyPolicyLink.sendKeys(PPLink);

		if (!fbap.showTermsAndConditions.isSelected()) {
			fbap.showTermsAndConditionsToggle.click();
		}

		fbap.termsAndConditionContent.clear();
		fbap.termsAndConditionContent.sendKeys(TCLink);

		CC.CustomizerHome.click();
		Thread.sleep(500);

		// Set Footer Column

		fsmlp.footermenu.click();
		fsmlp.mainfooterareamenu.click();
		fsmlp.widget1menu.click();
		fsmlp.selectdropdownoption();
		fsmlp.footercolumtitle.clear();
		fsmlp.footercolumtitle.sendKeys(title);
		fsmlp.footercontenteditor.clear();
		fsmlp.footercontenteditor.sendKeys(content);
		Actions act = new Actions(driver);
		act.moveToElement(fsmlp.outsideelement).click().build().perform();

		CC.CustomizerHome.click();
		Thread.sleep(500);
		// Set Login Description
		lsp.loginMenu.click();
		lsp.loginPageSettings.click();
		lsp.siteLoginDescription.clear();
		lsp.siteLoginDescription.sendKeys(Login_Message);

		CC.save.click();
		Thread.sleep(2000);

	}

}
