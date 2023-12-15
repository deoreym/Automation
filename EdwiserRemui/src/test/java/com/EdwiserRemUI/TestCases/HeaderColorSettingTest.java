package com.EdwiserRemUI.TestCases;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.EdwiserRemUI.BaseTest.BaseClass;
import com.EdwiserRemUI.PageObjects.BrandColorPage;
import com.EdwiserRemUI.PageObjects.ColorConversion;
import com.EdwiserRemUI.PageObjects.CustomizerPage;
import com.EdwiserRemUI.PageObjects.DashBoardPage;
import com.EdwiserRemUI.PageObjects.HeaderColorSettingPage;
import com.EdwiserRemUI.PageObjects.PrimaryButtonColorPage;
import com.EdwiserRemUI.PageObjects.SecondaryButtonColorPage;

public class HeaderColorSettingTest extends BaseClass {

	public String logobgcolor = "#CEF7FD";

	DashBoardPage dp;
	CustomizerPage cpp;
	BrandColorPage bcp;
	ColorConversion cc;
	PrimaryButtonColorPage pbcp;
	SecondaryButtonColorPage sbcp;
	HeaderColorSettingPage hcsp;

	@BeforeClass
	public void Before_class() {
		dp = new DashBoardPage(driver);
		cpp = new CustomizerPage(driver);
		bcp = new BrandColorPage(driver);
		cc = new ColorConversion();
		pbcp = new PrimaryButtonColorPage(driver);
		sbcp = new SecondaryButtonColorPage(driver);
		hcsp = new HeaderColorSettingPage(driver);
	}

	/**
	 * Verify Logo Background And Site Name Color
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 1)
	public void Verify_Logo_Background_And_Site_Name_Color() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();

		String sitenamecolor = "#2471A3";

		// http://localhost/v43/theme/remui/customizer.php?url=http://localhost/v43/my/
		driver.get(siteurl + "theme/remui/customizer.php?url=" + dashboard);
		Thread.sleep(1500);
//		dp.remuimenu();
//		cpp.customizertab.click();
//		if (hcsp.QuickMenuCollapsed.size() == 0) {
//			hcsp.QuickMenu.click();
//		}
//		Thread.sleep(500);
//		cpp.customizerbutton.click();
		hcsp.headermenu.click();
		hcsp.headerlogosetting.click();
		hcsp.logobgcolor.click();
		bcp.colorinputfield.clear();
		bcp.colorinputfield.sendKeys(logobgcolor);
		String present = hcsp.iconsiteformat.getAttribute("selected");
		boolean status = Boolean.parseBoolean(present);
		System.out.println(status);
		if (status == true) {
			hcsp.sitenamecolor.click();
			bcp.colorinputfield.clear();
			bcp.colorinputfield.sendKeys(sitenamecolor);

			bcp.save.click();
			Thread.sleep(2000);
			driver.get(dashboard);
			String Expected = ColorConversion.Color(hcsp.logobgcolorelement.getCssValue("background-color"));
			System.out.println(Expected);
			softAssert.assertEquals(logobgcolor, Expected,
					"The selected logo bg color is not getting applied on the element");

			String Expectedsitenamecolor = ColorConversion.Color(hcsp.sitenamecolorelement.getCssValue("color"));
			System.out.println(Expectedsitenamecolor);
			softAssert.assertEquals(sitenamecolor, Expectedsitenamecolor,
					"The selected SiteName Color is not getting applied on the element");

			softAssert.assertAll();
		} else {
			bcp.save.click();
			Thread.sleep(2000);
			driver.get(dashboard);
			String Expected = ColorConversion.Color(hcsp.logobgcolorelement.getCssValue("background-color"));
			System.out.println(Expected);
			Assert.assertEquals(logobgcolor, Expected,
					"The selected logo bg color is not getting applied on the element");
		}

	}

	/**
	 * Verify HeaderBackground Color When Same As Logo_Background Color is Enabeld
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 2)
	public void Verify_HeaderBackground_Color_When_Same_As_Logo_Background_Color() throws InterruptedException {
		// http://localhost/v43/theme/remui/customizer.php?url=http://localhost/v43/my/
		driver.get(siteurl + "theme/remui/customizer.php?url=" + dashboard);
		Thread.sleep(1500);
		hcsp.headermenu.click();
		hcsp.headerdesignsettingmenu.click();
		hcsp.headercolormenu.click();
		String present = hcsp.bgcolorcheckbox.getAttribute("checked");
		boolean status = Boolean.parseBoolean(present);
		System.out.println(status);
		if (status == true) {
			driver.get(dashboard);
			String Expected = ColorConversion.Color(hcsp.navsubbarelement.getCssValue("background-color"));
			System.out.println(Expected);
			Assert.assertEquals(logobgcolor, Expected,
					"The selected logo bg color is not getting applied on the nav sub bar of header");

		} else {
			hcsp.enableheaderbgcoloraslogobgcolor.click();
			bcp.save.click();
			Thread.sleep(2000);
			driver.get(dashboard);
			String Expected = ColorConversion.Color(hcsp.navsubbarelement.getCssValue("background-color"));
			System.out.println(Expected);
			Assert.assertEquals(logobgcolor, Expected,
					"The selected logo bg color is not getting applied on the nav sub bar of header");

		}

	}

	/**
	 * Verify Header Colors From Customizer
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 3)
	public void Verify_Header_Colors_From_Customizer() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		String headerbgcolor1 = "#D6EAF8";
		String menuitemcolor = "#85929E";
		String menuitemhovercolor = "#E59866";
		String menuitemactivecolor = "#2C3E50";
		String elementbgcolor = "#C3F7FF";
		String elementdividercolor = "#34495E";
		// http://localhost/v43/theme/remui/customizer.php?url=http://localhost/v43/my/
		driver.get(siteurl + "theme/remui/customizer.php?url=" + dashboard);
		Thread.sleep(1500);
		hcsp.headermenu.click();
		hcsp.headerdesignsettingmenu.click();
		hcsp.headercolormenu.click();
//		String present = hcsp.bgcolorcheckbox.getAttribute("checked");
//		boolean status = Boolean.parseBoolean(present);
//		System.out.println(status);
		if (hcsp.bgcolorcheckbox.isSelected()) {
			hcsp.enableheaderbgcoloraslogobgcolor.click();
		}
		// Set Header Background Color
		hcsp.headerbgcolor.click();
		hcsp.color_input_2.clear();
		hcsp.color_input_2.sendKeys(headerbgcolor1);
		hcsp.choosebutton_2.click();

		// Set Menu Item background Color
		hcsp.menuitemcolor.click();
		bcp.colorinputfield.clear();
		bcp.colorinputfield.sendKeys(menuitemcolor);
		hcsp.choosebutton.click();

		// Set Menu Item Hover Color
		hcsp.menuitemhovercolor.click();
		bcp.colorinputfield.clear();
		bcp.colorinputfield.sendKeys(menuitemhovercolor);
		hcsp.choosebutton.click();

		// Set Menu Item Active Color
		hcsp.menuitemactivecolor.click();
		bcp.colorinputfield.clear();
		bcp.colorinputfield.sendKeys(menuitemactivecolor);
		hcsp.choosebutton.click();

		// Set Menu Element Background Color
		hcsp.elementbgcolor.click();
		hcsp.color_input_2.clear();
		hcsp.color_input_2.sendKeys(elementbgcolor);
		hcsp.choosebutton_2.click();

		// Set Menu Element Divider Color
		hcsp.elementdividercolor.click();
		hcsp.color_input_2.clear();
		hcsp.color_input_2.sendKeys(elementdividercolor);
		hcsp.choosebutton_2.click();

		Thread.sleep(2000);
		bcp.save.click();
		Thread.sleep(2000);
		driver.get(dashboard);
		softAssert.assertEquals(headerbgcolor1,
				ColorConversion.Color(hcsp.navsubbarelement.getCssValue("background-color")),
				"The selected Header Background color is not getting applied to header");

		String Expectedmenuitemcolor = ColorConversion.Color(hcsp.headermenuelement.getCssValue("color"));
		System.out.println(Expectedmenuitemcolor);

		softAssert.assertEquals(menuitemcolor, ColorConversion.Color(hcsp.headermenuelement.getCssValue("color")),
				"The  selected menu item color is not getting applied on the header");

		Actions act = new Actions(driver);
		act.moveToElement(hcsp.headermenuelement).build().perform();
		Thread.sleep(2000);
		String Expectedmenuitemhovercolor = ColorConversion.Color(hcsp.headermenuelement.getCssValue("color"));
		System.out.println(Expectedmenuitemhovercolor);
		softAssert.assertEquals(menuitemhovercolor, ColorConversion.Color(hcsp.headermenuelement.getCssValue("color")),
				"The selected menu item hover  color is not getting applied on the header");

		hcsp.dashboardmenuelement.click();
		String Expectedmenuitemactivecolor = ColorConversion.Color(hcsp.dashboardmenuelement.getCssValue("color"));
		System.out.println(Expectedmenuitemactivecolor);
		softAssert.assertEquals(menuitemactivecolor,
				ColorConversion.Color(hcsp.dashboardmenuelement.getCssValue("color")),
				"The selected menu item active color is not getting applied on the header");

		// Get Enable Editor mode Switch Background color
//		String script = "return window.getComputedStyle(arguments[0], ':before').getPropertyValue('background-color');";
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        String E_BG_C = ColorConversion.convertRGBtoRGBA((String) js.executeScript(script, hcsp.EditModeSwitch));

		softAssert.assertEquals(elementbgcolor,
				ColorConversion.Color(hcsp.CategoryMenu.getCssValue("background-color")),
				"The selected Element background color is not getting applied on the header");

		softAssert.assertEquals(elementdividercolor,
				ColorConversion.Color(hcsp.H_ElementDivider.getCssValue("background-color")),
				"The selected Element divider color is not getting applied on the header");

		softAssert.assertAll();

	}

	/**
	 * Verify Header Icon Color Settings
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 4)
	public void Verify_Header_Icon_Color_Settings() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		String iconcolor = "#28A745";
		String iconhovercolor = "#7FB3D5";
		String iconactivecolor = "#9432B9";

		// http://localhost/v43/theme/remui/customizer.php?url=http://localhost/v43/my/
		driver.get(siteurl + "theme/remui/customizer.php?url=" + dashboard);
		Thread.sleep(1500);
		hcsp.headermenu.click();
		hcsp.headerdesignsettingmenu.click();
		hcsp.headericonmenu.click();

		// Set Menu Icon Color
		hcsp.iconcolor.click();
		bcp.colorinputfield.clear();
		bcp.colorinputfield.sendKeys(iconcolor);
		hcsp.choosebutton.click();

		// Set Menu Icon Hover Color
		hcsp.iconhovercolor.click();
		bcp.colorinputfield.clear();
		bcp.colorinputfield.sendKeys(iconhovercolor);
		hcsp.choosebutton.click();

		// Set Menu Icon Active Color
		hcsp.iconactivecolor.click();
		bcp.colorinputfield.clear();
		bcp.colorinputfield.sendKeys(iconactivecolor);
		hcsp.choosebutton.click();

		Thread.sleep(2000);
		bcp.save.click();

		Thread.sleep(2000);
		// Visit Dashboard
		driver.get(dashboard);

		// Check Menu Notification Icon Color
		softAssert.assertEquals(iconcolor, ColorConversion.Color(hcsp.headericonelement.getCssValue("color")),
				"The  selected menu item color is not getting applied on the header");
		// Hover on Notification Icon
		Actions act = new Actions(driver);
		act.moveToElement(hcsp.headericonelement).build().perform();
		Thread.sleep(500);

		// Check Menu Notification Icon Hover Color
		softAssert.assertEquals(iconhovercolor, ColorConversion.Color(hcsp.headericonelement.getCssValue("color")),
				"The selected menu item hover  color is not getting applied on the header");
		// Click Notification Icon
		hcsp.headericonelement.click();
		// Check Menu Notification Icon Active Color
		softAssert.assertEquals(iconactivecolor, ColorConversion.Color(hcsp.headericonelement.getCssValue("color")),
				"The selected menu item active color is not getting applied on the header");

		softAssert.assertAll();
	}

	/**
	 * Verify Header box shadow Settings
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 5)
	public void Verify_Header_box_shadow() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		String BoxShadowColor = "#D1F2EB";
		String Box_shadow_size = "0.7";
		String Box_shadow_blur = "1.2";

		driver.get(profilepage);
		System.out.println("Box Shadow before settings: " + hcsp.SiteHeaderNav.getCssValue("box-shadow"));
		// http://localhost/v43/theme/remui/customizer.php?url=http://localhost/v43/my/
		driver.get(siteurl + "theme/remui/customizer.php?url=" + dashboard);
		Thread.sleep(1500);
		hcsp.headermenu.click();
		hcsp.headerdesignsettingmenu.click();
		hcsp.headerBoxShadowmenu.click();

		if (!hcsp.headerBoxShadowCheckbox.isSelected()) {
			hcsp.EnableHeaderBoxShadowLabel.click();
		}

		// Set Box shadow size
		hcsp.headerBoxShadowBottomSize.clear();
		hcsp.headerBoxShadowBottomSize.sendKeys(Box_shadow_size);

		// Set Box shadow blur
		hcsp.headerBoxShadowBlur.clear();
		hcsp.headerBoxShadowBlur.sendKeys(Box_shadow_blur);

		// Set Border Shadow Color
		hcsp.HeaderBorderShadowColor.click();
		hcsp.color_input_2.clear();
		hcsp.color_input_2.sendKeys(BoxShadowColor);
		hcsp.choosebutton_2.click();

		Thread.sleep(2000);
		bcp.save.click();

		Thread.sleep(2000);
		// Visit Dashboard
		driver.get(dashboard);
		System.out.println("Box Shadow After settings: " + hcsp.SiteHeaderNav.getCssValue("box-shadow"));

		Assert.assertFalse(hcsp.SiteHeaderNav.getCssValue("box-shadow").contains("none"),"Header Box Shadow is not getting Set");
		softAssert.assertAll();
	}

}
