package com.EdwiserRemUI.TestCases;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.EdwiserRemUI.BaseTest.BaseClass;
import com.EdwiserRemUI.PageObjects.BrandColorPage;
import com.EdwiserRemUI.PageObjects.ColorConversion;
import com.EdwiserRemUI.PageObjects.PrimaryButtonColorPage;
import com.EdwiserRemUI.PageObjects.SecondaryButtonColorPage;

public class SecondaryButtonColorTest extends BaseClass {

	BrandColorPage bcp;
	ColorConversion cc;
	PrimaryButtonColorPage pbcp;
	SecondaryButtonColorPage sbcp;

	@BeforeClass
	public void Before_class() {
		System.out.println("In  Secondary Button Color Test Class : SecondaryButtonColorTest");
		bcp = new BrandColorPage(driver);
		cc = new ColorConversion();
		pbcp = new PrimaryButtonColorPage(driver);
		sbcp = new SecondaryButtonColorPage(driver);
	}

	@Test(priority = 1)
	public void verifysecondarybuttontextcolor() throws InterruptedException {
		String Textcolor = "#FFC107";
		driver.get(customizer);
		bcp.globalmenu.click();
		pbcp.buttonmenu.click();
		pbcp.buttoncolorsettingmenu.click();
		sbcp.secondarybuttonmenu.click();
		sbcp.textcolor.click();
		bcp.colorinputfield.clear();
		bcp.colorinputfield.sendKeys(Textcolor);
		bcp.save.click();
		Thread.sleep(2000);
		driver.get(managecoursecategory);
		String Expected = ColorConversion.Color(sbcp.secondarybutton.getCssValue("color"));
		Assert.assertEquals(Textcolor, Expected, "The selected text color is not getting applied on the element");
	}

	@Test(priority = 2)
	public void verifysecondarybuttontexthovercolor() throws InterruptedException {
		String Texthovercolor = "#000000";
		driver.get(customizer);
		bcp.globalmenu.click();
		pbcp.buttonmenu.click();
		pbcp.buttoncolorsettingmenu.click();
		sbcp.secondarybuttonmenu.click();
		sbcp.texthovercolor.click();
		bcp.colorinputfield.clear();
		bcp.colorinputfield.sendKeys(Texthovercolor);
		bcp.save.click();
		Thread.sleep(2000);
		driver.get(managecoursecategory);
		Actions act = new Actions(driver);
		act.moveToElement(sbcp.secondarybutton).build().perform();
		Thread.sleep(2000);
		String Expected = ColorConversion.Color(sbcp.secondarybutton.getCssValue("color"));
		Assert.assertEquals(Texthovercolor, Expected,
				"The selected text hover color is not getting applied on the element");
	}

	@Test(priority = 3)
	public void verifyprimarybuttonbackgroundcolor() throws InterruptedException {
		String backgroundcolor = "#BC61DE";
		driver.get(customizer);
		bcp.globalmenu.click();
		pbcp.buttonmenu.click();
		pbcp.buttoncolorsettingmenu.click();
		sbcp.secondarybuttonmenu.click();
		sbcp.backgroundcolor.click();
		bcp.colorinputfield.clear();
		bcp.colorinputfield.sendKeys(backgroundcolor);
		bcp.save.click();
		Thread.sleep(2000);
		driver.get(managecoursecategory);
		String Expected = ColorConversion.Color(sbcp.secondarybutton.getCssValue("background-color"));
		Assert.assertEquals(backgroundcolor, Expected,
				"The selected background color is not getting applied on the element");
	}

	@Test(priority = 4)
	public void verifyprimarybuttonbackgroundhovercolor() throws InterruptedException {
		String backgroundhovercolor = "#CB8312";
		driver.get(customizer);
		bcp.globalmenu.click();
		pbcp.buttonmenu.click();
		pbcp.buttoncolorsettingmenu.click();
		sbcp.secondarybuttonmenu.click();
		sbcp.backgroundhovercolor.click();
		bcp.colorinputfield.clear();
		bcp.colorinputfield.sendKeys(backgroundhovercolor);
		Thread.sleep(2000);
		bcp.save.click();
		Thread.sleep(2000);
		driver.get(managecoursecategory);
		Actions act = new Actions(driver);
		act.moveToElement(sbcp.secondarybutton).build().perform();
		Thread.sleep(2000);
		String Expected = ColorConversion.Color(sbcp.secondarybutton.getCssValue("background-color"));
		Assert.assertEquals(backgroundhovercolor, Expected,
				"The selected background hover color is not getting applied on the element");
	}

	@Test(priority = 5)
	public void verifyprimarybuttonbordercolor() throws InterruptedException {
		String bordercolor = "#BC61DE";
		driver.get(customizer);
		bcp.globalmenu.click();
		pbcp.buttonmenu.click();
		pbcp.buttoncolorsettingmenu.click();
		sbcp.secondarybuttonmenu.click();
		sbcp.bordercolor.click();
		bcp.colorinputfield.clear();
		bcp.colorinputfield.sendKeys(bordercolor);
		bcp.save.click();
		Thread.sleep(2000);
		driver.get(managecoursecategory);
		String Expected = ColorConversion.Color(sbcp.secondarybutton.getCssValue("border-top-color"));
		Assert.assertEquals(bordercolor, Expected, "The selected border color is not getting applied on the element");
	}

	@Test(priority = 6)
	public void verifyprimarybuttonborderhovercolor() throws InterruptedException {
		String borderhovercolor = "#CB8312";
		driver.get(customizer);
		bcp.globalmenu.click();
		pbcp.buttonmenu.click();
		pbcp.buttoncolorsettingmenu.click();
		sbcp.secondarybuttonmenu.click();
		sbcp.borderhovercolor.click();
		bcp.colorinputfield.clear();
		bcp.colorinputfield.sendKeys(borderhovercolor);
		Thread.sleep(2000);
		bcp.save.click();
		Thread.sleep(2000);
		driver.get(managecoursecategory);
		Actions act = new Actions(driver);
		act.moveToElement(sbcp.secondarybutton).build().perform();
		Thread.sleep(2000);
		String Expected = ColorConversion.Color(sbcp.secondarybutton.getCssValue("border-top-color"));
		Assert.assertEquals(borderhovercolor, Expected,
				"The selected border hover color is not getting applied on the element");
	}
}
