package com.EdwiserRemUI.TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.EdwiserRemUI.BaseTest.BaseClass;
import com.EdwiserRemUI.PageObjects.BackgroundColorSettingPage;
import com.EdwiserRemUI.PageObjects.BrandColorPage;
import com.EdwiserRemUI.PageObjects.ColorConversion;

public class BackgroundColorSettingTest extends BaseClass {

	BrandColorPage bcp;
	ColorConversion cc;
	BackgroundColorSettingPage bcp2;

	@BeforeClass
	public void Before_class() {

		bcp = new BrandColorPage(driver);
		cc = new ColorConversion();
		bcp2 = new BackgroundColorSettingPage(driver);
	}

	@Test
	public void verifyelementbgcolor() throws InterruptedException {
		String elementcolor = "#F26441";
		driver.get(customizer);
		bcp.globalmenu.click();
		bcp.themecolorsmenu.click();
		bcp2.backgroundcolorsmenu.click();
		bcp2.elementbgcolor.click();
		bcp.colorinputfield.clear();
		bcp.colorinputfield.sendKeys(elementcolor);
		bcp.save.click();
		Thread.sleep(2000);
		driver.get(dashboard);
		String Expected = ColorConversion.Color(bcp2.elementbgelement.getCssValue("background-color"));
		System.out.println(Expected);
		Assert.assertEquals(elementcolor, Expected,
				"The selected element background color is not getting applied on the element");

	}

	@Test
	public void verifyAscentbgcolor() throws InterruptedException {
		String ascentbgcolor = "#DA33DA";
		driver.get(customizer);
		bcp.globalmenu.click();
		bcp.themecolorsmenu.click();
		bcp2.backgroundcolorsmenu.click();
		bcp2.ascentbgcolor.click();
		bcp.colorinputfield.clear();
		bcp.colorinputfield.sendKeys(ascentbgcolor);
		bcp.save.click();
		Thread.sleep(2000);
		driver.get(coursearchive);
		bcp2.categoryfilter.click();
		bcp2.tags.click();
		String Expected = ColorConversion.Color(bcp2.ascentbgelement.getCssValue("background-color"));
		System.out.println(Expected);
		Assert.assertEquals(ascentbgcolor, Expected,
				"The selected element background color is not getting applied on the element");

	}

	@Test
	public void verifybackgroundcolor() throws InterruptedException {
		String pagebgcolor = "#D4F1F6";
		driver.get(customizer);
		bcp.globalmenu.click();
		bcp.themecolorsmenu.click();
		bcp2.backgroundcolorsmenu.click();
		String present = bcp2.colormenu.getAttribute("selected");
		boolean status = Boolean.parseBoolean(present);
		System.out.println(status);
		if (status == true) {
			bcp2.pagebgcolor.click();
			bcp.colorinputfield.clear();
			bcp.colorinputfield.sendKeys(pagebgcolor);
			bcp.save.click();
			Thread.sleep(2000);
			driver.get(coursearchive);
			String Expected = ColorConversion.Color(bcp2.pagebgcolorelement.getCssValue("background-color"));
			System.out.println(Expected);
			Assert.assertEquals(pagebgcolor, Expected,
					"The selected page background color is not getting applied on the element");
		} else {
			bcp2.coloroptionselect.click();
			bcp.save.click();
			bcp.globalmenu.click();
			bcp.themecolorsmenu.click();
			bcp2.backgroundcolorsmenu.click();
			bcp2.pagebgcolor.click();
			bcp.colorinputfield.clear();
			bcp.colorinputfield.sendKeys(pagebgcolor);
			bcp.save.click();
			Thread.sleep(2000);
			driver.get(coursearchive);
			String Expected = ColorConversion.Color(bcp2.pagebgcolorelement.getCssValue("background-color"));
			System.out.println(Expected);
			Assert.assertEquals(pagebgcolor, Expected,
					"The selected page background color is not getting applied on the element");

		}
	}
}
