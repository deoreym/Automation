package com.EdwiserRemUI.TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.EdwiserRemUI.BaseTest.BaseClass;
import com.EdwiserRemUI.PageObjects.CustomizerPage;

public class CustomizerTest extends BaseClass {
	String expected = "personalizer";

	CustomizerPage cpp;

	@BeforeClass
	public void Before_class() {
		System.out.println("In Customizer Option Check Class - CustomizerTest");
		cpp = new CustomizerPage(driver);
	}

	@Test
	public void verifyonclickingvisualpersonalizer() {
		driver.get(remuisetting);
		cpp.customizertab.click();
		boolean status = cpp.customizerbutton.isDisplayed();
		if (status == true) {
			cpp.customizerbutton.click();
			String actual = driver.getTitle();
			System.out.println(actual);
			Assert.assertTrue(actual.contains(expected),
					"On clicking the button it is not redirecting to the expected page");
			driver.get(dashboard);
		}
	}
}
