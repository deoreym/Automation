package com.EdwiserRemUI.TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.EdwiserRemUI.BaseTest.BaseClass;
import com.EdwiserRemUI.PageObjects.ActivationDeactivationPage;

public class ActivationDeactivationTest extends BaseClass {

	ActivationDeactivationPage adp;

	@BeforeClass
	public void Before_class() {
		System.out.println("In Activation Deactivation Test Class - ActivationDeactivationTest");
		adp = new ActivationDeactivationPage(driver);
	}

	// Check the status of remui license key
	@Test(priority = 1)
	public void verifystatusofremui() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		if (adp.dangeralert.size() == 1) {
			driver.get(remuisetting);
			adp.infotab.click();
			Assert.assertEquals(adp.checkstatus(), "Deactivated", "plugin status is still active");
			adp.licensekey.click();
			adp.licensekey.clear();
			adp.licensekey.sendKeys(LisenceKey);
			adp.activatebutton.click();
			Assert.assertEquals(adp.checkstatus(), "Active", "plugin status is still deactive");

		}

		else {
			driver.get(remuisetting);
			adp.infotab.click();
			Assert.assertEquals(adp.checkstatus(), "Active", "plugin status is still deactive");
		}
		softAssert.assertAll();
	}

	// Check when invalid license key is entered
	@Test(priority = 2)
	public void verifywheninvalidlicensekeyisentered() {
		if (adp.dangeralert.size() == 1) {
			driver.get(remuisetting);
			adp.infotab.click();
			adp.licensekey.click();
			adp.licensekey.clear();
			adp.licensekey.sendKeys("6d09466f915996ae572c156eeeb2a0eef");
			adp.activatebutton.click();
			Assert.assertEquals(adp.checkstatus(), "Invalid", "plugin status is still deactive");
		} else {
			System.out.println("Edwiser remui license key is active");
		}
	}

	// Check when license key is deactivated
	@Test(priority = 3)
	public void verifybydeactivatingthelicensekey() throws Exception {
		if (adp.dangeralert.size() == 0) {
			driver.get(remuisetting);
			adp.infotab.click();
			Thread.sleep(1000);
			adp.deactivatebutton.click();
			Assert.assertEquals(adp.checkstatus(), "Deactivated", "plugin status is still active");
		} else {
			System.out.println("Edwiser remui license key is deactivated");
		}
	}

	// Check when license key is activated

	@Test(priority = 4)
	public void verifybyactivatingthelicensekey() throws InterruptedException {
		if (adp.dangeralert.size() == 1) {
			driver.get(remuisetting);
			adp.infotab.click();
			adp.licensekey.click();
			adp.licensekey.clear();
			adp.licensekey.sendKeys(LisenceKey);
			adp.activatebutton.click();
			Thread.sleep(3000);
			Assert.assertEquals(adp.checkstatus(), "Active", "plugin status is still deactive");
		}
		else {
			System.out.println("Edwiser remui license key is deactivated");
		}
	}

}
