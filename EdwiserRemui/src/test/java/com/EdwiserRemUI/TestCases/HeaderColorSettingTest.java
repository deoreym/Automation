package com.EdwiserRemUI.TestCases;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.EdwiserRemUI.BaseTest.BaseClass;
import com.EdwiserRemUI.PageObjects.BrandColorPage;
import com.EdwiserRemUI.PageObjects.ColorConversion;
import com.EdwiserRemUI.PageObjects.HeaderColorSettingPage;

public class HeaderColorSettingTest extends BaseClass {

	public String logobgcolor = "#CEF7FD";

	BrandColorPage bcp;

	HeaderColorSettingPage hcsp;

	@BeforeClass
	public void Before_class() {

		bcp = new BrandColorPage(driver);

		hcsp = new HeaderColorSettingPage(driver);
	}

	/**
	 * Set Site Logo Format To Logo Only
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 1)
	public void SetLogoFormat_Logo_Only() throws InterruptedException {
		// Visit Customizer
		driver.get(customizer);
		Thread.sleep(1500);
		// Visit Header logo settings
		hcsp.headermenu.click();
		hcsp.headerlogosetting.click();

		// Set Logo Type to "Logo Only"
		hcsp.LogoType(hcsp.LogoType).selectByValue("logo");

		// Save Settings
		bcp.save.click();
		Thread.sleep(2000);

		// Visit Site
		driver.get(dashboard);

		// Check Logo on Site
		String LogoClass = hcsp.SiteLogoFormat.getAttribute("class");

		Assert.assertTrue(LogoClass.contains("navbar-brand-logo logo"),
				"The selected site logo format (Logo Only) is not getting applied on the Header");
	}

	/**
	 * Set Site Logo Format To Logo Mini
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 2)
	public void SetLogoFormat_Logo_Mini() throws InterruptedException {
		// Visit Customizer
		driver.get(customizer);
		Thread.sleep(1500);
		// Visit Header logo settings
		hcsp.headermenu.click();
		hcsp.headerlogosetting.click();

		// Set Logo Type to "Logo Mini"
		hcsp.LogoType(hcsp.LogoType).selectByValue("logomini");

		// Save Settings
		bcp.save.click();
		Thread.sleep(2000);

		// Visit Site
		driver.get(dashboard);

		// Check Logo on Site
		String LogoClass = hcsp.SiteLogoFormat.getAttribute("class");

		Assert.assertTrue(LogoClass.contains("navbar-brand-logo logomini"),
				"The selected site logo format (Logo Mini) is not getting applied on the Header");
	}

	/**
	 * Set Site Logo Format To Icon Only
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 3)
	public void SetLogoFormat_Icon_Only() throws InterruptedException {
		// Visit Customizer
		driver.get(customizer);
		Thread.sleep(1500);
		// Visit Header logo settings
		hcsp.headermenu.click();
		hcsp.headerlogosetting.click();

		// Set Logo Type to "Icon Only"
		hcsp.LogoType(hcsp.LogoType).selectByValue("icononly");

		// Save Settings
		bcp.save.click();
		Thread.sleep(2000);

		// Visit Site
		driver.get(dashboard);

		// Check Logo on Site
		String LogoClass = hcsp.SiteLogoFormat.getAttribute("class");

		Assert.assertTrue(LogoClass.contains("navbar-brand-logo icononly"),
				"The selected site logo format (Icon Only) is not getting applied on the Header");
	}

	/**
	 * Set Site Logo Format To Icon and sitename
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 4)
	public void SetLogoFormat_Icon_and_Sitename() throws InterruptedException {
		// Visit Customizer
		driver.get(customizer);
		Thread.sleep(1500);
		// Visit Header logo settings
		hcsp.headermenu.click();
		hcsp.headerlogosetting.click();

		// Set Logo Type to "Icon and sitename"
		hcsp.LogoType(hcsp.LogoType).selectByValue("iconsitename");

		// Save Settings
		bcp.save.click();
		Thread.sleep(2000);

		// Visit Site
		driver.get(dashboard);

		// Check Logo on Site
		String LogoClass = hcsp.SiteLogoFormat.getAttribute("class");

		Assert.assertTrue(LogoClass.contains("navbar-brand-logo iconsitename"),
				"The selected site logo format (Icon and Sitename) is not getting applied on the Header");
	}

	/**
	 * Verify Logo Background And Site Name Color
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 5)
	public void Verify_Logo_Background_And_Site_Name_Icon_Settings() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();

		String sitenamecolor = "#2471A3";
		String Site_fa_Icon = "book";
		String SiteNameFontSize = "1.2";

		// http://localhost/v43/theme/remui/customizer.php?url=http://localhost/v43/my/
		driver.get(customizer);
		Thread.sleep(1500);
		hcsp.headermenu.click();
		hcsp.headerlogosetting.click();
		hcsp.logobgcolor.click();
		bcp.colorinputfield.clear();
		bcp.colorinputfield.sendKeys(logobgcolor);

		// Set Logo Type to "Icon and sitename"
		hcsp.LogoType(hcsp.LogoType).selectByValue("iconsitename");
		hcsp.sitenamecolor.click();
		bcp.colorinputfield.clear();
		bcp.colorinputfield.sendKeys(sitenamecolor);

		hcsp.SiteIconInput.clear();
		hcsp.SiteIconInput.sendKeys(Site_fa_Icon);

		hcsp.HeaderIconFontSize.clear();
		hcsp.HeaderIconFontSize.sendKeys(SiteNameFontSize);

		hcsp.HeaderIconFontSizeTablet.clear();
		hcsp.HeaderIconFontSizeTablet.sendKeys(SiteNameFontSize);

		// Save Settings
		bcp.save.click();
		Thread.sleep(2000);

		// Visit Site
		driver.get(dashboard);

		softAssert.assertEquals(ColorConversion.Color(hcsp.logobgcolorelement.getCssValue("background-color")),
				logobgcolor, "The selected logo bg color is not getting applied on the element");

		softAssert.assertEquals(ColorConversion.Color(hcsp.sitenamecolorelement.getCssValue("color")), sitenamecolor,
				"The selected SiteName Color is not getting applied on the element");

		String FontSize = hcsp.SiteLogoFormat.getCssValue("font-size");
		String convetedRM = ColorConversion.convertPxToRem(FontSize);

		softAssert.assertEquals(convetedRM, SiteNameFontSize, "The selected SiteName Font Size is not getting applied");

		softAssert.assertTrue(hcsp.SiteIcon.getAttribute("class").contains(Site_fa_Icon),
				"The selected Site Icon is not getting applied");

		softAssert.assertAll();
	}

	/**
	 * Verify HeaderBackground Color When Same As Logo_Background Color is Enabeld
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 6)
	public void Verify_HeaderBackground_Color_When_Same_As_Logo_Background_Color() throws InterruptedException {
		// http://localhost/v43/theme/remui/customizer.php?url=http://localhost/v43/my/
		driver.get(customizer);
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
	@Test(priority = 7)
	public void Verify_Header_Colors_From_Customizer() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		String headerbgcolor1 = "#D6EAF8";
		String menuitemcolor = "#85929E";
		String menuitemhovercolor = "#E59866";
		String menuitemactivecolor = "#2C3E50";
		String elementbgcolor = "#C3F7FF";
		String elementdividercolor = "#34495E";
		// http://localhost/v43/theme/remui/customizer.php?url=http://localhost/v43/my/
		driver.get(customizer);
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
	@Test(priority = 8)
	public void Verify_Header_Icon_Color_Settings() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		String iconcolor = "#28A745";
		String iconhovercolor = "#7FB3D5";
		String iconactivecolor = "#9432B9";

		// http://localhost/v43/theme/remui/customizer.php?url=http://localhost/v43/my/
		driver.get(customizer);
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
	@Test(priority = 9)
	public void Verify_Header_box_shadow() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		String BoxShadowColor = "#D1F2EB";
		String Box_shadow_size = "0.7";
		String Box_shadow_blur = "1.2";

		driver.get(profilepage);
		System.out.println("Box Shadow before settings: " + hcsp.SiteHeaderNav.getCssValue("box-shadow"));
		// http://localhost/v43/theme/remui/customizer.php?url=http://localhost/v43/my/
		driver.get(customizer);
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

		Assert.assertFalse(hcsp.SiteHeaderNav.getCssValue("box-shadow").contains("none"),
				"Header Box Shadow is not getting Set");
		softAssert.assertAll();
	}

}
