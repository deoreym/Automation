package com.EdwiserRemUI.TestCases;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.EdwiserRemUI.BaseTest.BaseClass;
import com.EdwiserRemUI.PageObjects.DashBoardPage;
import com.EdwiserRemUI.PageObjects.HeaderHideShowMenuPage;
import com.EdwiserRemUI.PageObjects.SettingsPage;

public class LayoutTest extends BaseClass {
	SettingsPage sp;
	DashBoardPage dp; 
	HeaderHideShowMenuPage hsp;
	
	@BeforeClass
	public void Before_class() {
		sp =new SettingsPage(driver);
		dp=new DashBoardPage(driver);
		hsp= new HeaderHideShowMenuPage(driver);
	}
	
	//Check when narrow width layout is getting applied on page 
	@Test
	public void verifywhennarrowwidthisselected() throws InterruptedException {
		dp.remuimenu();
		sp.basictab.click();
		Thread.sleep(2000);
		for (int i = 0; i < sp.layout_option.size(); i++) {
			WebElement ele = sp.layout_option.get(i);
			String innerHTML = ele.getAttribute("value");
			if (innerHTML.equals("default")) {
				ele.click();
				sp.savebutton.click();
				}
			}
		driver.get(mycourses);
		boolean status=sp.layoutid.getAttribute("class").contains("limitedwidth");
		System.out.println(status);
		Assert.assertTrue(status,"On selecting narrow width layout , narrow width is not getting applied");
	}
	
	//Check when full width layout is getting applied on page 
	@Test
	public void verifywhenfullwidthisselected() throws InterruptedException {
		dp.remuimenu();
		sp.basictab.click();
		Thread.sleep(2000);
		for (int i = 0; i < sp.layout_option.size(); i++) {
			WebElement ele = sp.layout_option.get(i);
			String innerHTML = ele.getAttribute("value");
			if (innerHTML.equals("fullwidth")) {
				ele.click();
				sp.savebutton.click();
				}
			}
		driver.get(mycourses);
		boolean status=sp.layoutid.getAttribute("class").contains("limitedwidth");
		System.out.println(status);
		Assert.assertFalse(status, "On selecting full width layout , full width is not getting applied");
	}
}
