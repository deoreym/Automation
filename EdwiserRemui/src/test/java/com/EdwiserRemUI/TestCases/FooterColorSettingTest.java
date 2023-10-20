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
import com.EdwiserRemUI.PageObjects.FooterColorSettingPage;
import com.EdwiserRemUI.PageObjects.FooterSocialMediaLinkPage;
import com.EdwiserRemUI.PageObjects.HeaderColorSettingPage;
import com.EdwiserRemUI.PageObjects.PrimaryButtonColorPage;
import com.EdwiserRemUI.PageObjects.SecondaryButtonColorPage;

public class FooterColorSettingTest extends BaseClass {

	DashBoardPage dp;
	CustomizerPage cpp;
	BrandColorPage bcp;
	ColorConversion cc;
	PrimaryButtonColorPage pbcp;
	SecondaryButtonColorPage sbcp;
	HeaderColorSettingPage hcsp;
	FooterSocialMediaLinkPage fsmlp;
	FooterColorSettingPage fcsp ;
	
	@BeforeClass
	public void Before_class() {
		dp =new DashBoardPage(driver);
		cpp= new CustomizerPage(driver);
		bcp=new BrandColorPage(driver);
		cc=new ColorConversion();
		pbcp=new PrimaryButtonColorPage(driver);
		sbcp=new SecondaryButtonColorPage(driver);
		hcsp=new HeaderColorSettingPage(driver);
		fsmlp=new FooterSocialMediaLinkPage(driver);
		fcsp=new FooterColorSettingPage(driver);
		
	}	
	
	@Test
	public void Verifyfootercolorssettings() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		String footerbgcolor="#D2DE5D";
		String textcolor="#180C0C";
		String footerdividercolor="#C8573B";
		String linktextcolor="#41A9B9";
		String linkhovertextcolor="#28A745";
		String iconcolor="#9432B9";
		String iconhovercolor="#E42EBD";
		dp.remuimenu();
		cpp.customizertab.click();
		cpp.customizerbutton.click();
		fsmlp.footermenu.click();
		fcsp.footerdesignmenu.click();
		fcsp.colorsmenu.click();
		fcsp.footercolorsmenu.click();
		fcsp.footerbgcolor.click();
		bcp.colorinputfield.clear();
		bcp.colorinputfield.sendKeys(footerbgcolor);
		hcsp.choosebutton.click();
		fcsp.footertextcolor.click();
		bcp.colorinputfield.clear();
		bcp.colorinputfield.sendKeys(textcolor);
		hcsp.choosebutton.click();
		fcsp.footerdividercolor.click();
		bcp.colorinputfield.clear();
		bcp.colorinputfield.sendKeys(footerdividercolor);
		hcsp.choosebutton.click();
		fcsp.footerlinkmenu.click();
		fcsp.linktextcolor.click();
		bcp.colorinputfield.clear();
		bcp.colorinputfield.sendKeys(linktextcolor);
		hcsp.choosebutton.click();
		fcsp.linkhovertextcolor.click();
		bcp.colorinputfield.clear();
		bcp.colorinputfield.sendKeys(linkhovertextcolor);
		hcsp.choosebutton.click();
		fcsp.footericonmenu.click();
		fcsp.iconcolor.click();
		bcp.colorinputfield.clear();
		bcp.colorinputfield.sendKeys(iconcolor);
		hcsp.choosebutton.click();
		fcsp.iconhovercolor.click();
		bcp.colorinputfield.clear();
		bcp.colorinputfield.sendKeys(iconhovercolor);
		hcsp.choosebutton.click();
		bcp.save.click();
		Thread.sleep(2000);
		driver.get(dashboard);
		
		String Expectedfooterbgcolor=ColorConversion.Color(fcsp.footerbgelement.getCssValue("background-color"));
		System.out.println(Expectedfooterbgcolor);
		softAssert.assertEquals(footerbgcolor, Expectedfooterbgcolor, "The  selected footer bg color is not getting applied ");
	
		String Expecteddividercolor=ColorConversion.Color(fcsp.dividercolorelement.getCssValue("border-top-color"));
		System.out.println(Expecteddividercolor);
		softAssert.assertEquals(footerdividercolor, Expecteddividercolor, "The  selected divider color is not getting applied ");
	
		String Expectedtextcolor=ColorConversion.Color(fcsp.textcolorelement.getCssValue("color"));
		System.out.println(Expectedtextcolor);
		softAssert.assertEquals(textcolor, Expectedtextcolor, "The  selected text color is not getting applied ");
	
		String Expectedlinkcolor=ColorConversion.Color(fcsp.linkcolorelement.getCssValue("color"));
		System.out.println(Expectedtextcolor);
		softAssert.assertEquals(linktextcolor, Expectedlinkcolor, "The  selected link color is not getting applied ");
	
		Actions act=new Actions(driver);
		act.moveToElement(fcsp.linkcolorelement).build().perform();
		String Expectedlinkhovercolor=ColorConversion.Color(fcsp.linkcolorelement.getCssValue("color"));
		System.out.println(Expectedlinkhovercolor);
		softAssert.assertEquals(linkhovertextcolor, Expectedlinkhovercolor, "The  selected link color is not getting applied ");
		
		String Expectedsocialiconcolor=ColorConversion.Color(fcsp.socialiconelement.getCssValue("color"));
		System.out.println(Expectedsocialiconcolor);
		softAssert.assertEquals(iconcolor, Expectedsocialiconcolor, "The  selected social icon color is not getting applied ");
	
		Actions act1=new Actions(driver);
		act1.moveToElement(fcsp.socialiconelement).build().perform();
		String Expectediconhovercolor=ColorConversion.Color(fcsp.socialiconelement.getCssValue("color"));
		System.out.println(Expectediconhovercolor);
		softAssert.assertEquals(iconhovercolor, Expectediconhovercolor, "The  selected social icon color is not getting applied ");
		
		softAssert.assertAll();	
	
	}
	@Test(priority=2)
	public void verifyfootercolumntitlecolor() throws InterruptedException {
		String columncolor="#9432B9";
		dp.remuimenu();
		cpp.customizertab.click();
		cpp.customizerbutton.click();
		fsmlp.footermenu.click();
		fcsp.footerdesignmenu.click();
		fcsp.columntitlemenu.click();
		fcsp.columntitlecolor.click();
		bcp.colorinputfield.clear();
		bcp.colorinputfield.sendKeys(columncolor);
		hcsp.choosebutton.click();
		bcp.save.click();
		Thread.sleep(2000);
		driver.get(dashboard);
		String Expectedcolumncolor=ColorConversion.Color(fcsp.columntitlecolorelement.getCssValue("color"));
		System.out.println(Expectedcolumncolor);
		Assert.assertEquals(columncolor, Expectedcolumncolor, "The  selected text color is not getting applied ");
	
	}
	
}
