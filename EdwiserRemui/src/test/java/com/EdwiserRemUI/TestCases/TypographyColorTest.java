package com.EdwiserRemUI.TestCases;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.EdwiserRemUI.BaseTest.BaseClass;
import com.EdwiserRemUI.PageObjects.BrandColorPage;
import com.EdwiserRemUI.PageObjects.ColorConversion;
import com.EdwiserRemUI.PageObjects.TypogrphyColorPage;

public class TypographyColorTest extends BaseClass {

	BrandColorPage bcp;
	ColorConversion cc;
	TypogrphyColorPage tcp;

	@BeforeClass
	public void Before_class() {
		System.out.println("In Typography Color Test Class : TypographyColorTest");
		bcp = new BrandColorPage(driver);
		cc = new ColorConversion();
		tcp = new TypogrphyColorPage(driver);
	}

	@Test(priority = 1)
	public void verifylinkcolor() throws InterruptedException {
		String primarycolor = "#17A2B8";
		driver.get(customizer);
		bcp.globalmenu.click();
		tcp.typographymenu.click();
		tcp.textlinkmenu.click();
		tcp.linkcolor.click();
		bcp.colorinputfield.clear();
		bcp.colorinputfield.sendKeys(primarycolor);
		bcp.save.click();
		Thread.sleep(2000);
		driver.get(siteadminurl);
		String Expected = ColorConversion.Color(tcp.linkcolorelement.getCssValue("color"));
		Assert.assertEquals(primarycolor, Expected, "The selected link color is not getting applied on the element");
	}

	@Test(priority = 2)
	public void verifylinkhovercolor() throws InterruptedException {
		String linkhovercolor = "#28A745";
		driver.get(customizer);
		bcp.globalmenu.click();
		tcp.typographymenu.click();
		tcp.textlinkmenu.click();
		tcp.linkhovercolor.click();
		bcp.colorinputfield.clear();
		bcp.colorinputfield.sendKeys(linkhovercolor);
		bcp.save.click();
		Thread.sleep(2000);
		driver.get(siteadminurl);
		Actions act = new Actions(driver);
		act.moveToElement(tcp.linkcolorelement).build().perform();
		Thread.sleep(2000);
		String Expected = ColorConversion.Color(tcp.linkcolorelement.getCssValue("color"));
		Assert.assertEquals(linkhovercolor, Expected,
				"The selected link hover color is not getting applied on the element");
	}

}
