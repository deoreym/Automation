package com.EdwiserRemUI.TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.EdwiserRemUI.BaseTest.BaseClass;
import com.EdwiserRemUI.PageObjects.SettingsPage;

public class LayoutTest extends BaseClass {
	SettingsPage sp;

	@BeforeClass
	public void Before_class() {
		System.out.println("In Layout Test Class : LayoutTest");
		sp = new SettingsPage(driver);
	}

	/**
	 * Test Theme Narrow Width Layout On My Courses Page
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 1)
	public void Test_Narrow_Width_Layout() throws InterruptedException {
		driver.get(remuisetting);
		Thread.sleep(1000);
		sp.ThemeLayout().selectByValue("default");
		sp.savebutton.click();
		driver.get(mycourses);
		Assert.assertTrue(sp.layoutid.getAttribute("class").contains("limitedwidth"),
				"On selecting narrow width layout , narrow width is not getting applied");
	}

	/**
	 * Test Theme Full Width Layout On My Courses Page
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 2)
	public void Test_Full_Width_Layout() throws InterruptedException {
		driver.get(remuisetting);
		Thread.sleep(1000);
		sp.ThemeLayout().selectByValue("fullwidth");
		sp.savebutton.click();
		driver.get(mycourses);
		Assert.assertFalse(sp.layoutid.getAttribute("class").contains("limitedwidth"),
				"On selecting full width layout , full width is not getting applied");
	}
}
