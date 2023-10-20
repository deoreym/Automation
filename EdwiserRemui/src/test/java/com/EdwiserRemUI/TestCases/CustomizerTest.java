package com.EdwiserRemUI.TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.EdwiserRemUI.BaseTest.BaseClass;
import com.EdwiserRemUI.PageObjects.CustomizerPage;
import com.EdwiserRemUI.PageObjects.DashBoardPage;

public class CustomizerTest extends BaseClass {
	String expected = "Customizer";
	DashBoardPage dp;
	CustomizerPage cpp;

	@BeforeClass
	public void Before_class() {
		dp = new DashBoardPage(driver);
		cpp = new CustomizerPage(driver);
	}

	@Test
	public void verifyonclickingvisualpersonalizer() {
		dp.remuimenu();
		cpp.customizertab.click();
		boolean status = cpp.customizerbutton.isDisplayed();
		if (status == true) {
			cpp.customizerbutton.click();
			System.out.println(driver.getTitle());
			String actual = driver.getTitle();
			// System.out.println(actual);
			Assert.assertTrue(actual.contains(expected),
					"On clicking the button it is not redirecting to the expected page");
			driver.get(dashboard);
		}
	}
}
