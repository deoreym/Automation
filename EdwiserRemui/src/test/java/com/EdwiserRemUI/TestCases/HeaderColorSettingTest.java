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
	
	public String logobgcolor="#FFC107";

	DashBoardPage dp;
	CustomizerPage cpp;
	BrandColorPage bcp;
	ColorConversion cc;
	PrimaryButtonColorPage pbcp;
	SecondaryButtonColorPage sbcp;
	HeaderColorSettingPage hcsp;
	
	@BeforeClass
	public void Before_class() {
		dp =new DashBoardPage(driver);
		cpp= new CustomizerPage(driver);
		bcp=new BrandColorPage(driver);
		cc=new ColorConversion();
		pbcp=new PrimaryButtonColorPage(driver);
		sbcp=new SecondaryButtonColorPage(driver);
		hcsp=new HeaderColorSettingPage(driver);
	}	
	
	@Test(priority=1)
	public void verifyheadercolorsetting() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
	
		String sitenamecolor="#17A2B8";
		dp.remuimenu();
		cpp.customizertab.click();
		cpp.customizerbutton.click();
		hcsp.headermenu.click();
		hcsp.headerlogosetting.click();
		hcsp.logobgcolor.click();
		bcp.colorinputfield.clear();
		bcp.colorinputfield.sendKeys(logobgcolor);
		String present=hcsp.iconsiteformat.getAttribute("selected");
		boolean status = Boolean.parseBoolean(present) ;
		System.out.println(status);
		if(status==true) {
			hcsp.sitenamecolor.click();
			bcp.colorinputfield.clear();
			bcp.colorinputfield.sendKeys(sitenamecolor);
			
		
		bcp.save.click();
		Thread.sleep(2000);
		driver.get(dashboard);
		String Expected=ColorConversion.Color(hcsp.logobgcolorelement.getCssValue("background-color"));
		System.out.println(Expected);
		Assert.assertEquals(logobgcolor, Expected, "The selected logo bg color is not getting applied on the element");
		
		String Expectedsitenamecolor=ColorConversion.Color(hcsp.sitenamecolorelement.getCssValue("color"));
		System.out.println(Expectedsitenamecolor);
		
		softAssert.assertAll();	
		}
		else {
			bcp.save.click();
			Thread.sleep(2000);
			driver.get(dashboard);
			String Expected=ColorConversion.Color(hcsp.logobgcolorelement.getCssValue("background-color"));
			System.out.println(Expected);
			Assert.assertEquals(logobgcolor, Expected, "The selected logo bg color is not getting applied on the element");
			
		}
		
	}
	
	@Test(priority=2)
	public void verifyheaderdesigncolorsetting() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		dp.remuimenu();
		cpp.customizertab.click();
		cpp.customizerbutton.click();
		hcsp.headermenu.click();
		hcsp.headerdesignsettingmenu.click();
		hcsp.headercolormenu.click();
		String present=hcsp.bgcolorcheckbox.getAttribute("checked");
		boolean status = Boolean.parseBoolean(present) ;
		System.out.println(status);
		if(status==true) {
			driver.get(dashboard);
			String Expected=ColorConversion.Color(hcsp.navsubbarelement.getCssValue("background-color"));
			System.out.println(Expected);
			Assert.assertEquals(logobgcolor, Expected, "The selected logo bg color is not getting applied on the nav sub bar of header");
			
		}
		else {
			hcsp.enableheaderbgcoloraslogobgcolor.click();
			bcp.save.click();
			Thread.sleep(2000);
			driver.get(dashboard);
			String Expected=ColorConversion.Color(hcsp.navsubbarelement.getCssValue("background-color"));
			System.out.println(Expected);
			Assert.assertEquals(logobgcolor, Expected, "The selected logo bg color is not getting applied on the nav sub bar of header");
		
		}
		softAssert.assertAll();	
		}
	
	@Test(priority=3)
	public void verifyheaderdesigncolorsettingwhenheaderbackgroundsetaslogobgcolorisdisabled() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
//		String headerbgcolor1="#EAC2B8";
		String menuitemcolor="#101620";
		String menuitemhovercolor="#B3A225";
		String menuitemactivecolor="#101620";
//		String elementbgcolor="#FF7272";
//		String elementdividercolor="#343A40";
		dp.remuimenu();
		cpp.customizertab.click();
		cpp.customizerbutton.click();
		hcsp.headermenu.click();
		hcsp.headerdesignsettingmenu.click();
		hcsp.headercolormenu.click();
		String present=hcsp.bgcolorcheckbox.getAttribute("checked");
		boolean status = Boolean.parseBoolean(present) ;
		System.out.println(status);
		if(status==true) {
			hcsp.enableheaderbgcoloraslogobgcolor.click();
			hcsp.menuitemcolor.click();
			bcp.colorinputfield.clear();
			bcp.colorinputfield.sendKeys(menuitemcolor);
			hcsp.choosebutton.click();
			hcsp.menuitemhovercolor.click();
			bcp.colorinputfield.clear();
			bcp.colorinputfield.sendKeys(menuitemhovercolor);
			hcsp.choosebutton.click();
			hcsp.menuitemactivecolor.click();
			bcp.colorinputfield.clear();
			bcp.colorinputfield.sendKeys(menuitemactivecolor);
			hcsp.choosebutton.click();
					
			Thread.sleep(2000);
			bcp.save.click();
			Thread.sleep(2000);
			driver.get(dashboard);
			String Expectedmenuitemcolor=ColorConversion.Color(hcsp.headermenuelement.getCssValue("color"));
			System.out.println(Expectedmenuitemcolor);
			softAssert.assertEquals(menuitemcolor, Expectedmenuitemcolor, "The  selected menu item color is not getting applied on the nav sub bar of header");
		
			Actions act=new Actions(driver);
			act.moveToElement(hcsp.headermenuelement).build().perform();
			Thread.sleep(2000);
			String Expectedmenuitemhovercolor=ColorConversion.Color(hcsp.headermenuelement.getCssValue("color"));
			System.out.println(Expectedmenuitemhovercolor);
			softAssert.assertEquals(menuitemhovercolor, Expectedmenuitemhovercolor, "The selected menu item hover  color is not getting applied on the nav sub bar of header");
			
			hcsp.dashboardmenuelement.click();
			String Expectedmenuitemactivecolor=ColorConversion.Color(hcsp.dashboardmenuelement.getCssValue("color"));
			System.out.println(Expectedmenuitemcolor);
			softAssert.assertEquals(menuitemactivecolor, Expectedmenuitemactivecolor, "The selected menu item active color is not getting applied on the nav sub bar of header");
			
			softAssert.assertAll();	
			}
		else {
			hcsp.menuitemcolor.click();
			bcp.colorinputfield.clear();
			bcp.colorinputfield.sendKeys(menuitemcolor);
			hcsp.choosebutton.click();
			hcsp.menuitemhovercolor.click();
			bcp.colorinputfield.clear();
			bcp.colorinputfield.sendKeys(menuitemhovercolor);
			hcsp.choosebutton.click();
			hcsp.menuitemactivecolor.click();
			bcp.colorinputfield.clear();
			bcp.colorinputfield.sendKeys(menuitemactivecolor);
			hcsp.choosebutton.click();
			Thread.sleep(2000);
			bcp.save.click();
			Thread.sleep(2000);
			driver.get(dashboard);
			String Expectedmenuitemcolor=ColorConversion.Color(hcsp.headermenuelement.getCssValue("color"));
			System.out.println(Expectedmenuitemcolor);
			softAssert.assertEquals(menuitemcolor, Expectedmenuitemcolor, "The  selected menu item color is not getting applied on the nav sub bar of header");
		
			Actions act=new Actions(driver);
			act.moveToElement(hcsp.headermenuelement).build().perform();
			Thread.sleep(2000);
			String Expectedmenuitemhovercolor=ColorConversion.Color(hcsp.headermenuelement.getCssValue("color"));
			System.out.println(Expectedmenuitemhovercolor);
			softAssert.assertEquals(menuitemhovercolor, Expectedmenuitemhovercolor, "The selected menu item hover  color is not getting applied on the nav sub bar of header");
			
			hcsp.dashboardmenuelement.click();
			String Expectedmenuitemactivecolor=ColorConversion.Color(hcsp.dashboardmenuelement.getCssValue("color"));
			System.out.println(Expectedmenuitemcolor);
			softAssert.assertEquals(menuitemactivecolor, Expectedmenuitemactivecolor, "The selected menu item active color is not getting applied on the nav sub bar of header");
			
			softAssert.assertAll();	
		}
		
		
		}
	@Test(priority=4)
	public void verifyheadericoncolors() throws InterruptedException  {
		SoftAssert softAssert = new SoftAssert();
		String iconcolor="#28A745";
		String iconhovercolor="#07FDFF";
		String iconactivecolor="#9432B9";
		
		dp.remuimenu();
		cpp.customizertab.click();
		cpp.customizerbutton.click();
		hcsp.headermenu.click();
		hcsp.headerdesignsettingmenu.click();
		hcsp.headericonmenu.click();
		hcsp.iconcolor.click();
		bcp.colorinputfield.clear();
		bcp.colorinputfield.sendKeys(iconcolor);
		hcsp.choosebutton.click();
		
		hcsp.iconhovercolor.click();
		bcp.colorinputfield.clear();
		bcp.colorinputfield.sendKeys(iconhovercolor);
		hcsp.choosebutton.click();
		
		hcsp.iconactivecolor.click();
		bcp.colorinputfield.clear();
		bcp.colorinputfield.sendKeys(iconactivecolor);
		hcsp.choosebutton.click();
		
		Thread.sleep(2000);
		bcp.save.click();
		Thread.sleep(2000);
		driver.get(dashboard);
		String Expectediconcolor=ColorConversion.Color(hcsp.headericonelement.getCssValue("color"));
		System.out.println(Expectediconcolor);
		softAssert.assertEquals(iconcolor, Expectediconcolor, "The  selected menu item color is not getting applied on the nav sub bar of header");
	
		Actions act=new Actions(driver);
		act.moveToElement(hcsp.headericonelement).build().perform();
		Thread.sleep(2000);
		String Expectediconhovercolor=ColorConversion.Color(hcsp.headericonelement.getCssValue("color"));
		System.out.println(Expectediconhovercolor);
		softAssert.assertEquals(iconhovercolor, Expectediconhovercolor, "The selected menu item hover  color is not getting applied on the nav sub bar of header");
		
		hcsp.headericonelement.click();
		String Expectediconactivecolor=ColorConversion.Color(hcsp.headericonelement.getCssValue("color"));
		System.out.println(Expectediconactivecolor);
		softAssert.assertEquals(iconactivecolor, Expectediconactivecolor, "The selected menu item active color is not getting applied on the nav sub bar of header");
		
		softAssert.assertAll();	
	}
	
}
