package com.EdwiserRemUI.TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.EdwiserRemUI.BaseTest.BaseClass;
import com.EdwiserRemUI.PageObjects.ActivationDeactivationPage;
import com.EdwiserRemUI.PageObjects.DashBoardPage;

public class ActivationDeactivationTest extends BaseClass{

	DashBoardPage dp;
	ActivationDeactivationPage adp;
	
	@BeforeClass
	public void Before_class() {
		adp= new ActivationDeactivationPage(driver);
		dp =new DashBoardPage(driver);
	}
	
	//Check the status of remui license key
	@Test(priority=1)
	public void verifystatusofremui() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		if(adp.dangeralert.size()==1) {
			dp.remuimenu();
			adp.infotab.click();
			Assert.assertEquals(adp.checkstatus(), "Deactivated", "plugin status is still active");
			adp.licensekey.click();	
			adp.licensekey.clear();
				adp.licensekey.sendKeys("6d09466f915996ae572c156eeeb2a0ee");
				adp.activatebutton.click();
				Assert.assertEquals(adp.checkstatus(), "Active", "plugin status is still deactive");
				
			}
		
		else {
			dp.remuimenu();
			adp.infotab.click();
			Assert.assertEquals(adp.checkstatus(), "Active", "plugin status is still deactive");
			}
		softAssert.assertAll();	
	}
	
	//Check when invalid license key is entered
	@Test(priority=2)
	public void verifywheninvalidlicensekeyisentered() {
		if(adp.dangeralert.size()==1) {
		dp.remuimenu();
		adp.infotab.click();
		adp.licensekey.click();	
		adp.licensekey.clear();
			adp.licensekey.sendKeys("6d09466f915996ae572c156eeeb2a0eef");
			adp.activatebutton.click();
			Assert.assertEquals(adp.checkstatus(), "Invalid", "plugin status is still deactive");
		}	
		else {
			System.out.println("Edwiser remui license key is active");
		}
	}
	
	//Check when license key is deactivated
	@Test(priority=3)
	public void verifybydeactivatingthelicensekey() {
		if(adp.dangeralert.size()==0) {
			dp.remuimenu();
			adp.infotab.click();
			adp.deactivatebutton.click();
			Assert.assertEquals(adp.checkstatus(), "Deactivated", "plugin status is still active");
		}
		else {
			System.out.println("Edwiser remui license key is deactivated");
		}
	}
	
	//Check when license key is activated 
	
	@Test(priority=4)
	public void verifybyactivatingthelicensekey() {
		if(adp.dangeralert.size()==1) {
			dp.remuimenu();
			adp.infotab.click();
			adp.licensekey.click();	
			adp.licensekey.clear();
				adp.licensekey.sendKeys("6d09466f915996ae572c156eeeb2a0ee");
				adp.activatebutton.click();
				Assert.assertEquals(adp.checkstatus(), "Active", "plugin status is still deactive");
			}
		else {
			System.out.println("Edwiser remui license key is deactivated");
		}
	}
	
}
