package com.EdwiserRemUI.TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.EdwiserRemUI.BaseTest.BaseClass;
import com.EdwiserRemUI.PageObjects.BorderColorPage;
import com.EdwiserRemUI.PageObjects.BrandColorPage;
import com.EdwiserRemUI.PageObjects.ColorConversion;

public class BorderColorTest extends BaseClass {
	BrandColorPage bcp;
	BorderColorPage bcp1;

	@BeforeClass
	public void Before_class() {
		System.out.println("In Border Color Test Class : BorderColorTest");
		bcp = new BrandColorPage(driver);
		bcp1 = new BorderColorPage(driver);
	}

	@Test
	public void verifylightbordercolor() throws InterruptedException {
		String lightbordercolor = "#28A745";
		driver.get(customizer);
		Thread.sleep(3000);
		bcp.globalmenu.click();
		bcp.themecolorsmenu.click();
		bcp1.bordermenu.click();
		Thread.sleep(1000);
		bcp1.lightborder.click();
		bcp.colorinputfield.clear();
		bcp.colorinputfield.sendKeys(lightbordercolor);
		bcp.save.click();
		Thread.sleep(2000);
		driver.get(coursearchive);
		String Expected = ColorConversion.Color(bcp1.lightborderelement.getCssValue("border-top-color"));
		Assert.assertEquals(lightbordercolor, Expected,
				"The selected light border color is not getting applied on the element");
	}

	@Test
	public void verifymediumbordercolor() throws InterruptedException {
		String mediumbordercolor = "#C12986";
		driver.get(customizer);
		Thread.sleep(3000);
		bcp.globalmenu.click();
		bcp.themecolorsmenu.click();
		bcp1.bordermenu.click();
		Thread.sleep(1000);
		bcp1.mediumborder.click();
		bcp.colorinputfield.clear();
		bcp.colorinputfield.sendKeys(mediumbordercolor);
		bcp.save.click();
		Thread.sleep(2000);
		driver.get(coursearchive);
		String Expected = ColorConversion.Color(bcp1.mediumborderelement.getCssValue("border-bottom-color"));
		Assert.assertEquals(mediumbordercolor, Expected,
				"The selected medium border color is not getting applied on the element");
	}

}
