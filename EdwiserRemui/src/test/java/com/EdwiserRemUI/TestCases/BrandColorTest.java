package com.EdwiserRemUI.TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.EdwiserRemUI.BaseTest.BaseClass;
import com.EdwiserRemUI.PageObjects.BrandColorPage;
import com.EdwiserRemUI.PageObjects.ColorConversion;
import com.EdwiserRemUI.PageObjects.CustomizerPage;
import com.EdwiserRemUI.PageObjects.DashBoardPage;
import com.EdwiserRemUI.PageObjects.FootercustomizerPage;
import com.EdwiserRemUI.PageObjects.HeaderHideShowMenuPage;

public class BrandColorTest extends BaseClass{


	DashBoardPage dp;
	CustomizerPage cpp;
	HeaderHideShowMenuPage hsp;
	FootercustomizerPage fcp;
	BrandColorPage bcp;
	ColorConversion cc;
	
	@BeforeClass
	public void Before_class() {
		dp =new DashBoardPage(driver);
		cpp= new CustomizerPage(driver);
		hsp= new HeaderHideShowMenuPage(driver);
		fcp= new FootercustomizerPage(driver);
		bcp=new BrandColorPage(driver);
		cc=new ColorConversion();
	}
	
	@Test(priority=1)
	public void verifybrandPrimarycolor() throws InterruptedException {
		String primarycolor="#FFE5B4";
		driver.get(customizer);
		bcp.globalmenu.click();
		bcp.themecolorsmenu.click();
		bcp.primarycolor.click();
		bcp.colorinputfield.clear();
		bcp.colorinputfield.sendKeys(primarycolor);
		bcp.save.click();
		Thread.sleep(2000);
		driver.get(siteadminurl);
		String Expected=ColorConversion.Color(bcp.primarycolortext.getCssValue("color"));
		System.out.println(Expected);
		Assert.assertEquals(primarycolor, Expected, "The selected primary color is not getting applied on the element");
		
	}
	
	@Test(priority=2)
	public void verifyAscentColor() throws InterruptedException {
		String ascentcolor="#FFFF00";
		driver.get(customizer);
		bcp.globalmenu.click();
		bcp.themecolorsmenu.click();
		bcp.ascentcolor.click();
		bcp.colorinputfield.clear();
		bcp.colorinputfield.sendKeys(ascentcolor);
		bcp.save.click();
		Thread.sleep(2000);
		driver.get(dashboard);
		String Expected=ColorConversion.Color(bcp.ascentcolorelement.getCssValue("color"));
		System.out.println(Expected);
		Assert.assertEquals(ascentcolor, Expected,"The selected Ascent color is not getting applied on the element");
	}
	
	
	
	@Test(priority=3)
	public void VerifyTextColor() throws InterruptedException {
		String textcolor="#FFC0CB";
		driver.get(customizer);
		bcp.globalmenu.click();
		bcp.themecolorsmenu.click();
		bcp.textcolor.click();
		bcp.colorinputfield.clear();
		bcp.colorinputfield.sendKeys(textcolor);
		bcp.save.click();
		Thread.sleep(2000);
		driver.get(coursearchive);
		String Expected=ColorConversion.Color(bcp.textcolorelement.getCssValue("color"));
		System.out.println(Expected);
		Assert.assertEquals(textcolor, Expected,"The selected text color is not getting applied on the element");
	
	}
	
	
}
