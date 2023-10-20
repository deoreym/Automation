package com.EdwiserRemUI.TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.EdwiserRemUI.BaseTest.BaseClass;
import com.EdwiserRemUI.PageObjects.DashBoardPage;


public class DashBoardTest extends BaseClass {

	DashBoardPage dp;
	@BeforeClass
	public void Before_class() {
		dp =new DashBoardPage(driver);
		
	}
	
	@Test(priority=1)
	public void verifydashboardsettingisenabled() throws InterruptedException {
		dp.remuimenu();
		dp.dashboardmenu.click();
		boolean status=dp.dashboardstatsstatus();
		Assert.assertEquals(status, true,"Dashboard Course Stats setting is not enabled by default");
		}
	
	@Test(priority=2)
	public void verifydashboardcheckboxstatusandenablecheckbox() {
		SoftAssert softAssert = new SoftAssert();
		dp.remuimenu();
		dp.dashboardmenu.click();
		boolean status=dp.dashboardstatsstatus();
		if(status==true) {
			driver.get(dashboard);
			softAssert.assertTrue(dp.dashboardstatsondp.size() == 1,
					"dashboard stats option is not present on dashboard even if setting is enabled ");
			
			}
		else {
			dp.dashboardstatslabel.click();
			dp.savechanges.click();
			driver.get(dashboard);
			softAssert.assertTrue(dp.dashboardstatsondp.size() == 1,
					"dashboard stats  is not present on dashboard even if setting is enabled  ");
		softAssert.assertAll();	
	}
}
	
	@Test(priority=3)
	public void verifydashboardstatswhendisabled() throws InterruptedException {
		Thread.sleep(2000);
		SoftAssert softAssert = new SoftAssert();
		dp.remuimenu();
		dp.dashboardmenu.click();
		dp.dashboardstatslabel.click();
		dp.savechanges.click();
		driver.get(dashboard);
		softAssert.assertTrue(dp.dashboardstatsondp.size() == 0,
				"Dashboard stats  is present even if setting is disabled ");
		softAssert.assertAll();	
	}
	
	//verify courses enrolled count from dashboard page w.r.t profile page 
	@Test(priority=4)
	public void verifycourseenrolledcount() throws InterruptedException {
		
		SoftAssert softAssert = new SoftAssert();
		//driver.get("http://localhost/moodle/my/");
		if(dp.dashboardstatsondp.size() == 1) {
			Thread.sleep(2000);
			String actual=dp.courseenrolleddp.getText();
			System.out.println("actual "+actual);
			driver.get(profilepage);
			String expected =dp.coursecountfrompp();
			System.out.println("expected "+expected);
			softAssert.assertEquals(actual, expected, "The courses enrolled count from dashboard and profile page didnt matched ");
		}
		else {
			dp.remuimenu();
			dp.dashboardmenu.click();
			dp.dashboardstatslabel.click();
			dp.savechanges.click();
			driver.get(dashboard);
			softAssert.assertTrue(dp.dashboardstatsondp.size() == 1,
					"Dashboard stats  is present even if setting is disabled ");
			String actual=dp.courseenrolleddp.getText();
			System.out.println("actual "+actual);
			driver.get(profilepage);
			String expected =dp.coursecountfrompp();
			System.out.println("expected "+expected);
			softAssert.assertEquals(actual, expected, "The courses enrolled count from dashboard and profile page didnt matched ");
			
		}
		softAssert.assertAll();	
	}
	@Test(priority=5)
	//verify activities completed count from dashboard page w.r.t profile page 
	public void verifyactivitiescompleted() throws InterruptedException {
		Thread.sleep(2000);
		SoftAssert softAssert = new SoftAssert();
		if(dp.dashboardstatsondp.size() == 1) {
			String actual=dp.activitiescompleted.getText();
			driver.get(profilepage);
			String expected=dp.additionofactivitiescompleted();
			softAssert.assertEquals(actual, expected," the completed activities count from dashboard and profilepage didnt matched");
			}
		else {
			dp.remuimenu();
			dp.dashboardmenu.click();
			dp.dashboardstatslabel.click();
			dp.savechanges.click();
			driver.get(dashboard);
			softAssert.assertTrue(dp.dashboardstatsondp.size() == 1,
					"Dashboard stats  is present even if setting is disabled ");
			String actual=dp.activitiescompleted.getText();
			driver.get(profilepage);
			String expected=dp.additionofactivitiescompleted();
			softAssert.assertEquals(actual, expected," the completed activities count from dashboard and profilepage didnt matched");
			}
		softAssert.assertAll();	
		}
	
	//verify course completed count from dashboard page w.r.t profile page 
	@Test(priority=6)
	public void verifycoursecompletedcount() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		Thread.sleep(2000);
		if(dp.dashboardstatsondp.size() == 1) {
			
			String act=dp.coursecompleted.getText();
			int actual=Integer.parseInt(act); 
			driver.get(profilepage);
			int expected=dp.coursecompletedcount();	
			softAssert.assertEquals(actual, expected,"THe course completed count from dashboard and profile page didnt matched");
			
		}
		else {
			dp.remuimenu();
			dp.dashboardmenu.click();
			dp.dashboardstatslabel.click();
			dp.savechanges.click();
			driver.get(dashboard);
			softAssert.assertTrue(dp.dashboardstatsondp.size() == 1,
					"Dashboard stats  is present even if setting is disabled ");
			String act=dp.coursecompleted.getText();
			int actual=Integer.parseInt(act); 
			driver.get(profilepage);
			int expected=dp.coursecompletedcount();	
			softAssert.assertEquals(actual, expected,"THe course completed count from dashboard and profile page didnt matched");
			
		}
		softAssert.assertAll();	
	}
		
	////verify activities due count from dashboard page w.r.t profile page 	
	@Test(priority=7)
	public void verifyactivitiesduecount() throws InterruptedException {
		Thread.sleep(2000);
		SoftAssert softAssert = new SoftAssert();
		int activitiesdue;
		if(dp.dashboardstatsondp.size() == 1) {
			String actdue=dp.activitiesdue.getText();
			int activitiesduecount=Integer.parseInt(actdue);
			System.out.println("activitiesduecount "+activitiesduecount);
			String actcomplted1=dp.activitiescompleted.getText();
			int actcomplted=Integer.parseInt(actcomplted1);
			driver.get(profilepage);
			String totalactivitiescount1=dp.totalfactivitiescount();
			int totalactivitiescount=Integer.parseInt(totalactivitiescount1);
			activitiesdue=totalactivitiescount-actcomplted;
			System.out.println("activitiesdue "+activitiesdue);
			//System.out.println("activitiesdue "+activitiesdue);
			softAssert.assertEquals(activitiesduecount, activitiesdue,"THe activities due count didn matched");
			
			}
		else {
			dp.remuimenu();
			dp.dashboardmenu.click();
			dp.dashboardstatslabel.click();
			dp.savechanges.click();
			driver.get(dashboard);
			softAssert.assertTrue(dp.dashboardstatsondp.size() == 1,
					"Dashboard stats  is present even if setting is disabled ");
			String actdue=dp.activitiesdue.getText();
			int activitiesduecount=Integer.parseInt(actdue);
			String actcomplted1=dp.activitiescompleted.getText();
			int actcomplted=Integer.parseInt(actcomplted1);
			driver.get(profilepage);
			String totalactivitiescount1=dp.totalfactivitiescount();
			int totalactivitiescount=Integer.parseInt(totalactivitiescount1);
			activitiesdue=totalactivitiescount-actcomplted;
			//System.out.println("activitiesdue "+activitiesdue);
			softAssert.assertEquals(activitiesduecount, activitiesdue,"THe activities due count didn matched");
			
		}
		
		softAssert.assertAll();	
	}
}
