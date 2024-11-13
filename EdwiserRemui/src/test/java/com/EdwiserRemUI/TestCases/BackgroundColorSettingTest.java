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
	BackgroundColorSettingPage BCS;

	@BeforeClass
	public void Before_class() {
		System.out.println("In Background Color Setting Test Class - BackgroundColorSettingTest");
		bcp = new BrandColorPage(driver);
		cc = new ColorConversion();
		BCS = new BackgroundColorSettingPage(driver);
	}

	@Test
	public void Set_Element_Background_Color() throws InterruptedException {
		String elementcolor = "#F26441";
		driver.get(customizer);
		bcp.globalmenu.click();
		bcp.themecolorsmenu.click();
		BCS.backgroundcolorsmenu.click();
		BCS.elementbgcolor.click();
		bcp.colorinputfield.clear();
		bcp.colorinputfield.sendKeys(elementcolor);
		bcp.chooseButton.click();
		bcp.save.click();
		Thread.sleep(2000);
		driver.get(coursearchive);
		String Expected = ColorConversion.Color(BCS.elementbgelement.getCssValue("background-color"));
		Assert.assertEquals(elementcolor, Expected,
				"The selected element background color is not getting applied on the element");

	}

	@Test
	public void Verify_Accent_Background_Color() throws InterruptedException {
		String ascentbgcolor = "#DA33DA";
		driver.get(customizer);
		bcp.globalmenu.click();
		bcp.themecolorsmenu.click();
		BCS.backgroundcolorsmenu.click();
		BCS.ascentbgcolor.click();
		bcp.colorinputfield.clear();
		bcp.colorinputfield.sendKeys(ascentbgcolor);
		bcp.chooseButton.click();
		bcp.save.click();
		Thread.sleep(2000);
		driver.get(siteurl+"course/index.php?categoryid=1");
		String Expected = ColorConversion.Color(BCS.ascentbgelement.getCssValue("background-color"));
		Assert.assertEquals(ascentbgcolor, Expected,
				"The selected element background color is not getting applied on the element");

	}

	@Test
	public void verifybackgroundcolor() throws InterruptedException {
		String pagebgcolor = "#D4F1F6";
		driver.get(customizer);
		bcp.globalmenu.click();
		bcp.themecolorsmenu.click();
		BCS.backgroundcolorsmenu.click();
		String present = BCS.colormenu.getAttribute("selected");
		boolean status = Boolean.parseBoolean(present);
		if (status == true) {
			BCS.pagebgcolor.click();
			bcp.colorinputfield.clear();
			bcp.colorinputfield.sendKeys(pagebgcolor);
			bcp.chooseButton.click();
			bcp.save.click();
			Thread.sleep(2000);
			driver.get(coursearchive);
			String Expected = ColorConversion.Color(BCS.pagebgcolorelement.getCssValue("background-color"));
			Assert.assertEquals(pagebgcolor, Expected,
					"The selected page background color is not getting applied on the element");
		} else {
			BCS.coloroptionselect.click();
			bcp.save.click();
			bcp.globalmenu.click();
			bcp.themecolorsmenu.click();
			BCS.backgroundcolorsmenu.click();
			BCS.pagebgcolor.click();
			bcp.colorinputfield.clear();
			bcp.colorinputfield.sendKeys(pagebgcolor);
			bcp.chooseButton.click();
			bcp.save.click();
			Thread.sleep(2000);
			driver.get(coursearchive);
			String Expected = ColorConversion.Color(BCS.pagebgcolorelement.getCssValue("background-color"));
			Assert.assertEquals(pagebgcolor, Expected,
					"The selected page background color is not getting applied on the element");

		}
	}
}
