package com.EdwiserRemUI.TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.EdwiserRemUI.BaseTest.BaseClass;
import com.EdwiserRemUI.PageObjects.ColorConversion;
import com.EdwiserRemUI.PageObjects.CustomizerCustomCSS;

public class CustomCSS_Test extends BaseClass {

	CustomizerCustomCSS CC;

	@BeforeClass
	public void Before_class() throws InterruptedException {
		CC = new CustomizerCustomCSS(driver);
	}

	@Test(priority = 1)
	public void Set_Custom_CSS() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		driver.get(siteurl + "theme/remui/customizer.php?url=" + dashboard);
		Thread.sleep(1500);

		// Visit Custom CSS Page
		CC.CustomCSS_Menu.click();
		Thread.sleep(1000);

		// Add Custom CSS
		CC.CustomCSS_Input.clear();
		String CSS = "li[title='Dashboard'] {\r\n" + "    color: #BB8FCE; \r\n" + "    background-color: #A6004E;\r\n"
				+ "    font-weight: 800; \r\n" + "}\r\n" + "li[title='Dashboard'] a {\r\n" + "            \r\n"
				+ "            color: #F9EFC1 !important; \r\n" + "          \r\n" + "}\r\n"
				+ "button.btn.btn-primary.btn-floating.d-none.d-md-flex.moodlehelpbtn {\r\n" + "            \r\n"
				+ "            background-color: #950048;\r\n" + "            color: #D6EAF8; \r\n" + "        }";
		CC.CustomCSS_Input.sendKeys(CSS);

		Thread.sleep(500);
		CC.save.click();
		Thread.sleep(2000);
		driver.get(dashboard);
		Thread.sleep(1000);
		String DashLinkList_BC = ColorConversion.Color(CC.DashboardInList.getCssValue("background-color")); // #A6004E
		String Dash_F_Weight = CC.DashboardInList.getCssValue("font-weight"); // 800
		String DashLink_C = ColorConversion.Color(CC.DashboardLink.getCssValue("color")); // #F9EFC1
		String HelpButton_BC = ColorConversion.Color(CC.Footer_HelpIcon.getCssValue("background-color")); // #950048
		String HelpButton_C = ColorConversion.Color(CC.Footer_HelpIcon.getCssValue("color")); // #D6EAF8

		softAssert.assertEquals(DashLinkList_BC, "#A6004E",
				"Custom CSS for Dashboard menu Background Color Not applied");
		softAssert.assertEquals(Dash_F_Weight, "800", "Custom CSS for Dashboard menu Font Weight Not applied");
		softAssert.assertEquals(DashLink_C, "#F9EFC1", "Custom CSS for Dashboard menu link Color Not applied");
		softAssert.assertEquals(HelpButton_BC, "#950048",
				"Custom CSS for Foopter Help Icon Background Color Not applied");
		softAssert.assertEquals(HelpButton_C, "#D6EAF8", "Custom CSS for Foopter Help Icon Color Not applied");

		softAssert.assertAll();

	}

	@Test(priority = 2)
	public void Remove_Custom_CSS() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		driver.get(siteurl + "theme/remui/customizer.php?url=" + dashboard);
		Thread.sleep(1500);

		// Visit Custom CSS Page
		CC.CustomCSS_Menu.click();
		Thread.sleep(1000);

		// Add Custom CSS
		CC.CustomCSS_Input.clear();
		Thread.sleep(500);

		CC.save.click();
		Thread.sleep(2000);

		driver.get(dashboard);
		Thread.sleep(1000);
		String DashLinkList_BC = ColorConversion.Color(CC.DashboardInList.getCssValue("background-color")); // #A6004E
		String Dash_F_Weight = CC.DashboardInList.getCssValue("font-weight"); // 800
		String DashLink_C = ColorConversion.Color(CC.DashboardLink.getCssValue("color")); // #F9EFC1
		String HelpButton_BC = ColorConversion.Color(CC.DashboardInList.getCssValue("background-color")); // #950048
		String HelpButton_C = ColorConversion.Color(CC.DashboardLink.getCssValue("color")); // #D6EAF8

		softAssert.assertNotEquals(DashLinkList_BC, "#A6004E",
				"Custom CSS Not removed for Dashboard menu Background Color");
		softAssert.assertNotEquals(Dash_F_Weight, "800", "Custom CSS Not removed for Dashboard menu Font Weight");
		softAssert.assertNotEquals(DashLink_C, "#F9EFC1", "Custom CSS Not removed for Dashboard menu link Color");
		softAssert.assertNotEquals(HelpButton_BC, "#950048",
				"Custom CSS Not removed for Foopter Help Icon Background Color");
		softAssert.assertNotEquals(HelpButton_C, "#D6EAF8", "Custom CSS Not removed for Foopter Help Icon Color");

		softAssert.assertAll();

	}

}
