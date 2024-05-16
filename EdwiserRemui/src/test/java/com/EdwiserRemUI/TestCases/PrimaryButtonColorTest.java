package com.EdwiserRemUI.TestCases;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.EdwiserRemUI.BaseTest.BaseClass;
import com.EdwiserRemUI.PageObjects.BrandColorPage;
import com.EdwiserRemUI.PageObjects.ColorConversion;
import com.EdwiserRemUI.PageObjects.PrimaryButtonColorPage;

public class PrimaryButtonColorTest extends BaseClass {

	BrandColorPage bcp;
	ColorConversion cc;
	PrimaryButtonColorPage pbcp;

	@BeforeClass
	public void Before_class() {
		System.out.println("In Primary Button Color Test Class : PrimaryButtonColorTest");
		bcp = new BrandColorPage(driver);
		cc = new ColorConversion();
		pbcp = new PrimaryButtonColorPage(driver);
	}

	@Test(priority = 1)
	public void verifyprimarybuttontextcolor() throws InterruptedException {
		String Textcolor = "#FFC107";
		driver.get(customizer);
		bcp.globalmenu.click();
		pbcp.buttonmenu.click();
		pbcp.buttoncolorsettingmenu.click();
		pbcp.primarybuttonmenu.click();
		pbcp.textcolor.click();
		bcp.colorinputfield.clear();
		bcp.colorinputfield.sendKeys(Textcolor);
		bcp.save.click();
		Thread.sleep(2000);
		driver.get(remuisetting);
		String Expected = ColorConversion.Color(pbcp.primarybutton.getCssValue("color"));
		Assert.assertEquals(Textcolor, Expected, "The selected link hover color is not getting applied on the element");
	}

	@Test(priority = 2)
	public void verifyprimarybuttontexthovercolor() throws InterruptedException {
		String Texthovercolor = "#000000";
		driver.get(customizer);
		bcp.globalmenu.click();
		pbcp.buttonmenu.click();
		pbcp.buttoncolorsettingmenu.click();
		pbcp.primarybuttonmenu.click();
		pbcp.texthovercolor.click();
		bcp.colorinputfield.clear();
		bcp.colorinputfield.sendKeys(Texthovercolor);
		bcp.save.click();
		Thread.sleep(2000);
		driver.get(remuisetting);
		Actions act = new Actions(driver);
		act.moveToElement(pbcp.primarybutton).build().perform();
		Thread.sleep(2000);
		String Expected = ColorConversion.Color(pbcp.primarybutton.getCssValue("color"));
		Assert.assertEquals(Texthovercolor, Expected,
				"The selected link hover color is not getting applied on the element");
	}

	@Test(priority = 3)
	public void verifyprimaryiconcolor() throws InterruptedException {
		String iconcolor = "#EB4949";
		driver.get(customizer);
		bcp.globalmenu.click();
		pbcp.buttonmenu.click();
		pbcp.buttoncolorsettingmenu.click();
		pbcp.primarybuttonmenu.click();
		pbcp.iconcolor.click();
		bcp.colorinputfield.clear();
		bcp.colorinputfield.sendKeys(iconcolor);
		bcp.save.click();
		Thread.sleep(2000);
		driver.get(remuisetting);
		String Expected = ColorConversion.Color(pbcp.primaryiconelement.getCssValue("color"));
		Assert.assertEquals(iconcolor, Expected, "The selected icon color is not getting applied on the element");
	}

	@Test(priority = 4)
	public void verifyprimaryiconhovercolor() throws InterruptedException {
		String iconhovercolor = "#000000";
		driver.get(customizer);
		bcp.globalmenu.click();
		pbcp.buttonmenu.click();
		pbcp.buttoncolorsettingmenu.click();
		pbcp.primarybuttonmenu.click();
		pbcp.iconhovercolor.click();
		bcp.colorinputfield.clear();
		bcp.colorinputfield.sendKeys(iconhovercolor);
		bcp.save.click();
		Thread.sleep(2000);
		driver.get(remuisetting);
		Actions act = new Actions(driver);
		act.moveToElement(pbcp.primaryiconelement).build().perform();
		Thread.sleep(2000);
		String Expected = ColorConversion.Color(pbcp.primaryiconelement.getCssValue("color"));
		Assert.assertEquals(iconhovercolor, Expected,
				"The selected icon hover color is not getting applied on the element");
	}

	@Test(priority = 5)
	public void verifyprimarybuttonbackgroundcolor() throws InterruptedException {
		String backgroundcolor = "#BC61DE";
		driver.get(customizer);
		bcp.globalmenu.click();
		pbcp.buttonmenu.click();
		pbcp.buttoncolorsettingmenu.click();
		pbcp.primarybuttonmenu.click();
		pbcp.backgroundcolor.click();
		bcp.colorinputfield.clear();
		bcp.colorinputfield.sendKeys(backgroundcolor);
		bcp.save.click();
		Thread.sleep(2000);
		driver.get(remuisetting);
		String Expected = ColorConversion.Color(pbcp.primarybutton.getCssValue("background-color"));
		Assert.assertEquals(backgroundcolor, Expected,
				"The selected background color is not getting applied on the element");
	}

	@Test(priority = 6)
	public void verifyprimarybuttonbackgroundhovercolor() throws InterruptedException {
		String backgroundhovercolor = "#CB8312";
		driver.get(customizer);
		bcp.globalmenu.click();
		pbcp.buttonmenu.click();
		pbcp.buttoncolorsettingmenu.click();
		pbcp.primarybuttonmenu.click();
		pbcp.backgroundhovercolor.click();
		bcp.colorinputfield.clear();
		bcp.colorinputfield.sendKeys(backgroundhovercolor);
		Thread.sleep(2000);
		bcp.save.click();
		Thread.sleep(2000);
		driver.get(remuisetting);
		Actions act = new Actions(driver);
		act.moveToElement(pbcp.primarybutton).build().perform();
		Thread.sleep(2000);
		String Expected = ColorConversion.Color(pbcp.primarybutton.getCssValue("background-color"));
		Assert.assertEquals(backgroundhovercolor, Expected,
				"The selected background hover color is not getting applied on the element");
	}

	@Test(priority = 7)
	public void verifyprimarybuttonbordercolor() throws InterruptedException {
		String bordercolor = "#BC61DE";
		driver.get(customizer);
		bcp.globalmenu.click();
		pbcp.buttonmenu.click();
		pbcp.buttoncolorsettingmenu.click();
		pbcp.primarybuttonmenu.click();
		pbcp.bordercolor.click();
		bcp.colorinputfield.clear();
		bcp.colorinputfield.sendKeys(bordercolor);
		bcp.save.click();
		Thread.sleep(2000);
		driver.get(remuisetting);
		String Expected = ColorConversion.Color(pbcp.primarybutton.getCssValue("border-top-color"));
		Assert.assertEquals(bordercolor, Expected, "The selected border color is not getting applied on the element");
	}

	@Test(priority = 8)
	public void verifyprimarybuttonborderhovercolor() throws InterruptedException {
		String borderhovercolor = "#CB8312";
		driver.get(customizer);
		bcp.globalmenu.click();
		pbcp.buttonmenu.click();
		pbcp.buttoncolorsettingmenu.click();
		pbcp.primarybuttonmenu.click();
		pbcp.borderhovercolor.click();
		bcp.colorinputfield.clear();
		bcp.colorinputfield.sendKeys(borderhovercolor);
		Thread.sleep(2000);
		bcp.save.click();
		Thread.sleep(2000);
		driver.get(remuisetting);
		Actions act = new Actions(driver);
		act.moveToElement(pbcp.primarybutton).build().perform();
		Thread.sleep(2000);
		String Expected = ColorConversion.Color(pbcp.primarybutton.getCssValue("border-top-color"));
		Assert.assertEquals(borderhovercolor, Expected,
				"The selected border hover color is not getting applied on the element");
	}
}
