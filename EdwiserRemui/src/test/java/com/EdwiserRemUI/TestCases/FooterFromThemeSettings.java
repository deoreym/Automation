package com.EdwiserRemUI.TestCases;

import org.openqa.selenium.Alert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.EdwiserRemUI.BaseTest.BaseClass;
import com.EdwiserRemUI.PageObjects.FooterSettingsPage;

public class FooterFromThemeSettings extends BaseClass {

	FooterSettingsPage FSP;

	@BeforeClass
	public void Before_class() {
		FSP = new FooterSettingsPage(driver);
	}

	/**
	 * Test Footer Column With Content and Menus
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 1)
	public void Test_Footer_Columns_With_Content_And_Menu() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		// Visit Footer Settings
		FSP.siteVisit(siteurl);
		FSP.footerTab.click();
		Thread.sleep(1000);

		// Set 4 Column in Footer Width
		FSP.DropDown(FSP.footerColumn).selectByValue("4");

		// Set First Column
		FSP.DropDown(FSP.footerColumn_1_Type).selectByValue("customhtml");
		FSP.footerColumn_1_Title.clear();
		FSP.footerColumn_1_Title.sendKeys("Footer Column 01");
		
		FSP.FooterColumn_1_Div.clear();
		FSP.FooterColumn_1_Div.sendKeys("Content For Footer Column 01.");

//		// Switch to the iframe
//		driver.switchTo().frame(FSP.FooterColumn_1_iFrame);
//		Thread.sleep(1000);
//		// Clear existing content (optional) and Type in content
//		FSP.editor.clear();
//		FSP.editor.sendKeys("Content For Footer Column 01.");
//
//		// Switch back to the main frame (outside the iframe)
//		driver.switchTo().defaultContent();

		// Set Second Column
		FSP.DropDown(FSP.footerColumn_2_Type).selectByValue("customhtml");
		FSP.footerColumn_2_Title.clear();
		FSP.footerColumn_2_Title.sendKeys("Footer Column 02");

		FSP.FooterColumn_2_Div.clear();
		FSP.FooterColumn_2_Div.sendKeys("Content For Footer Column 02.");
		
//		// Switch to the iframe
//		driver.switchTo().frame(FSP.FooterColumn_2_iFrame);
//		Thread.sleep(1000);
//		// Clear existing content (optional) and Type in content
//		FSP.editor.clear();
//		FSP.editor.sendKeys("Content For Footer Column 02.");
//
//		// Switch back to the main frame (outside the iframe)
//		driver.switchTo().defaultContent();

		// Set Third Column
		FSP.DropDown(FSP.footerColumn_3_Type).selectByValue("customhtml");
		FSP.footerColumn_3_Title.clear();
		FSP.footerColumn_3_Title.sendKeys("Footer Column 03");

		FSP.FooterColumn_3_Div.clear();
		FSP.FooterColumn_3_Div.sendKeys("Content For Footer Column 03.");
//		// Switch to the iframe
//		driver.switchTo().frame(FSP.FooterColumn_3_iFrame);
//		Thread.sleep(1000);
//		// Clear existing content (optional) and Type in content
//		FSP.editor.clear();
//		FSP.editor.sendKeys("Content For Footer Column 03.");
//
//		// Switch back to the main frame (outside the iframe)
//		driver.switchTo().defaultContent();

		// Set Fourth Column with Menu
		FSP.DropDown(FSP.footerColumn_4_Type).selectByValue("menu");
		FSP.footerColumn_4_Title.clear();
		FSP.footerColumn_4_Title.sendKeys("Footer Column 04 with Menu");

		FSP.FooterColumn_4_TextArea.clear();
		FSP.FooterColumn_4_TextArea.sendKeys(
				"[ { \"text\": \"ABC\", \"address\": \"http://abc.abc/\" }, { \"text\": \"XYZ\", \"address\": \"http://xyz.abc/\" } ]");
		Thread.sleep(500);
		FSP.savebutton.click();
		try {
			// Check for the unexpected alert
			Alert alert = driver.switchTo().alert();

			// Handle the alert (accept or dismiss)
			alert.accept();
		} catch (Exception e) {
			// No unexpected alert, continue with other actions
			System.out.println("No unexpected alert present");
		}
		driver.get(profilepage);
		// Check Footer Column Titles
		softAssert.assertEquals(FSP.FC_1_Title.getText(), "Footer Column 01",
				"Footer first column title is not getting changed");
		softAssert.assertEquals(FSP.FC_2_Title.getText(), "Footer Column 02",
				"Footer second column title is not getting changed");
		softAssert.assertEquals(FSP.FC_3_Title.getText(), "Footer Column 03",
				"Footer third column title is not getting changed");
		softAssert.assertEquals(FSP.FC_4_Title.getText(), "Footer Column 04 with Menu",
				"Footer fourth column title is not getting changed");
		// Check Footer Column Content
		System.out.println("FC_1_Content_D: " + FSP.FC_1_Content_D.getText());
		softAssert.assertEquals(FSP.FC_1_Content.getText(), "Content For Footer Column 01.",
				"Footer first column content is not getting changed");
		softAssert.assertEquals(FSP.FC_2_Content.getText(), "Content For Footer Column 02.",
				"Footer second column content is not getting changed");
		softAssert.assertEquals(FSP.FC_3_Content.getText(), "Content For Footer Column 03.",
				"Footer third column content is not getting changed");

		// Check Footer column 4 with Menus
		softAssert.assertEquals(FSP.FC_4_Content_Menu_1.getText(), "ABC",
				"Footer 4 column Menu 1 Text is not getting changed");
		softAssert.assertEquals(FSP.FC_4_Content_Menu_1.getAttribute("href"), "http://abc.abc/",
				"Footer 4 column Menu 1 link Address is not getting changed");

		softAssert.assertEquals(FSP.FC_4_Content_Menu_2.getText(), "XYZ",
				"Footer 4 column Menu 2 Text is not getting changed");
		softAssert.assertEquals(FSP.FC_4_Content_Menu_2.getAttribute("href"), "http://xyz.abc/",
				"Footer 4 column Menu 2 link Address is not getting changed");

		softAssert.assertAll();

	}

	/**
	 * Test Bottom Footer Setting - Diabled All
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 2)
	public void Test_Bottom_Footer_Setting_All_Disabled() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		// Visit Footer Settings
		FSP.siteVisit(siteurl);
		FSP.footerTab.click();
		Thread.sleep(1000);

		// Set Footer Bottom Left as Empty
		FSP.FooterBottomLeftText.clear();
		FSP.FooterBottomLeftLink.clear();

		// hide Copyrights Content
		if (FSP.Show_Copyrights_Content_Checkbox.isSelected()) {
			FSP.Show_Copyrights_Content_Checkbox_ele.click();
		}

		// hide Show Logo
		if (FSP.ShowLogo_Checkbox.isSelected()) {
			FSP.ShowLogo_Checkbox_ele.click();
		}

		// Hide Show Terms & Conditions
		if (FSP.Show_TermsConditions.isSelected()) {
			FSP.Show_TermsConditions_ele.click();
		}

		// Hide Privacy Policy
		if (FSP.Show_PrivacyPolicy.isSelected()) {
			FSP.Show_PrivacyPolicy_ele.click();
		}

		// Disable Powered by Edwiser
		if (FSP.Show_PoweredByEdwiser.isSelected()) {
			FSP.Show_PoweredByEdwiser_ele.click();
		}

		Thread.sleep(500);
		FSP.savebutton.click();
		try {
			// Check for the unexpected alert
			Alert alert = driver.switchTo().alert();

			// Handle the alert (accept or dismiss)
			alert.accept();
		} catch (Exception e) {
			// No unexpected alert, continue with other actions
			System.out.println("No unexpected alert present");
		}
		driver.get(profilepage);

		softAssert.assertTrue(FSP.F_Bottom_Left_Text_size.size()==0, "Footer Bottom Left Text is not getting removed");
		softAssert.assertTrue(FSP.Copyrights_Content.getAttribute("class").contains("d-none"),
				"Footer Bottom CopyRight Content is Visible when disabled ");
		softAssert.assertTrue(FSP.Footer_Logo_img.getAttribute("class").contains("d-none"),
				"Footer Bottom Logo Visible when disabled ");
		softAssert.assertTrue(FSP.Footer_Terms_Conditions_link.getAttribute("class").contains("d-none"),
				"Footer Terms and Condition Visible when disabled  ");

		softAssert.assertTrue(FSP.Footer_Privacy_Policy_link.getAttribute("class").contains("d-none"),
				"Footer Terms and Condition Visible when disabled ");

		FSP.f_helpicon.click();
		softAssert.assertTrue(FSP.Powered_By_Edwiser.size() == 0,
				"Footer Powered By Edwiser is Visible when disabled ");

		softAssert.assertAll();
	}

	/**
	 * Test Bottom Footer Setting - Enabled All
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 3)
	public void Test_Bottom_Footer_Setting_All_Enabled() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		// Visit Footer Settings
		FSP.siteVisit(siteurl);
		FSP.footerTab.click();
		Thread.sleep(1000);

		// Set Footer Bottom Left
		FSP.FooterBottomLeftText.clear();
		FSP.FooterBottomLeftText.sendKeys("Footer Bottom-Left Text");
		FSP.FooterBottomLeftLink.clear();
		FSP.FooterBottomLeftLink.sendKeys("http://localhost/v43/FBL/");

		// Show Copyrights Content
		if (!FSP.Show_Copyrights_Content_Checkbox.isSelected()) {
			Thread.sleep(500);
			FSP.Show_Copyrights_Content_Checkbox_ele.click();
		}
		FSP.Show_Copyrights_Content_Content.clear();
		FSP.Show_Copyrights_Content_Content.sendKeys("[site] © [year]. All rights reserved.");

		// Enable Show Logo
		if (!FSP.ShowLogo_Checkbox.isSelected()) {
			Thread.sleep(500);
			FSP.ShowLogo_Checkbox_ele.click();
		}

		// Enable Show Terms & Conditions
		if (!FSP.Show_TermsConditions.isSelected()) {
			Thread.sleep(500);
			FSP.Show_TermsConditions_ele.click();
		}
		FSP.Show_TermsConditions_Link.clear();
		String Tnc = "http://localhost/v43/TnC";
		FSP.Show_TermsConditions_Link.sendKeys(Tnc);

		// Show Privacy Policy
		if (!FSP.Show_PrivacyPolicy.isSelected()) {
			Thread.sleep(500);
			FSP.Show_PrivacyPolicy_ele.click();
		}
		FSP.Show_PrivacyPolicy_link.clear();
		String PP = "http://localhost/v43/PP";
		FSP.Show_PrivacyPolicy_link.sendKeys(PP);

		// Enable Powered by Edwiser
		if (!FSP.Show_PoweredByEdwiser.isSelected()) {
			Thread.sleep(500);
			FSP.Show_PoweredByEdwiser_ele.click();
		}

		Thread.sleep(500);
		FSP.savebutton.click();
		try {
			// Check for the unexpected alert
			Alert alert = driver.switchTo().alert();

			// Handle the alert (accept or dismiss)
			alert.accept();
		} catch (Exception e) {
			// No unexpected alert, continue with other actions
			System.out.println("No unexpected alert present");
		}
		driver.get(profilepage);

		softAssert.assertEquals(FSP.F_Bottom_Left_Text.getText(), "Footer Bottom-Left Text",
				"Footer Bottom Left Text is not getting changed");
		softAssert.assertEquals(FSP.F_Bottom_Left_Link.getAttribute("href"), "http://localhost/v43/FBL/",
				"Footer Bottom Left Link Address is not getting changed");
		softAssert.assertEquals(FSP.Copyrights_Content_Text.getText(), CopyRightText,
				"Footer Bottom CopyRight Content Not Matching ");
		softAssert.assertTrue(FSP.Footer_Logo.size() > 0, "Footer Bottom Logo Not Visible ");

		softAssert.assertTrue(FSP.Footer_Terms_Conditions_link.getAttribute("href").contains(Tnc),
				"Footer Terms and Condition Link address not matching");

		softAssert.assertTrue(FSP.Footer_Privacy_Policy_link.getAttribute("href").contains(PP),
				"Footer Privacy Policy Link address not matching");

		FSP.f_helpicon.click();
		softAssert.assertTrue(FSP.Powered_By_Edwiser.size() > 0, "Footer Powered By Edwiser Not Visible ");
		softAssert.assertTrue(FSP.Powered_By_Edwiser_link.getAttribute("href").contains("https://edwiser.org/remui/"),
				"Footer Privacy Policy Link address not matching");

		softAssert.assertAll();
	}

}
