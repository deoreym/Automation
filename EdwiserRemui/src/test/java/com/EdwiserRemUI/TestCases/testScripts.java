package com.EdwiserRemUI.TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.EdwiserRemUI.BaseTest.BaseClass;
import com.EdwiserRemUI.PageObjects.BrandColorPage;
import com.EdwiserRemUI.PageObjects.ColorConversion;
import com.EdwiserRemUI.PageObjects.DashBoardPage;
import com.EdwiserRemUI.PageObjects.HeaderColorSettingPage;

public class testScripts extends BaseClass {
	DashBoardPage dp;
	BrandColorPage bcp;
	ColorConversion cc;

	HeaderColorSettingPage hcsp;

	@BeforeClass
	public void Before_class() {
		dp = new DashBoardPage(driver);
		bcp = new BrandColorPage(driver);
		cc = new ColorConversion();
		hcsp = new HeaderColorSettingPage(driver);
	}

	@Test(priority = 1)
	public void Test() throws InterruptedException {
		driver.get(dashboard);
		Thread.sleep(2000);
		System.out.println("Logo Icon Class: " + hcsp.SiteIcon.getAttribute("class"));
		String FontSize = hcsp.SiteLogoFormat.getCssValue("font-size");
		System.out.println("FontSize: " + FontSize);

		String convetedRM = ColorConversion.convertPxToRem(FontSize);
		System.out.println("Font size in pixels: " + FontSize);
		System.out.println("Font size in rem: " + convetedRM);

	}

}
