package com.EdwiserRemUI.TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.EdwiserRemUI.BaseTest.BaseClass;
import com.EdwiserRemUI.PageObjects.DashBoardPage;

public class DashBoardTest extends BaseClass {

	DashBoardPage dp;

	@BeforeClass
	public void Before_class() {
		System.out.println("In Dashboard Stats Test Class : DashBoardTest");
		dp = new DashBoardPage(driver);

	}

	@Test(priority = 1)
	public void Disable_Course_Stats_From_RemUi_Settings() {

		driver.get(remuisetting);
		dp.dashboardmenu.click();

		if (dp.dashboardstatschbk.isSelected()) {
			dp.dashboardstatslabel.click();
			dp.savechanges.click();
		}
		driver.get(dashboard);
		Assert.assertTrue(dp.dashboardstatsondp.size() == 0,
				"Dashboard stats is present on dashboard even if setting is disabled.");

	}

	@Test(priority = 2)
	public void Enable_Course_Stats_From_RemUi_Settings() {

		driver.get(remuisetting);
		dp.dashboardmenu.click();

		if (!dp.dashboardstatschbk.isSelected()) {
			dp.dashboardstatslabel.click();
			dp.savechanges.click();
		}
		driver.get(dashboard);
		Assert.assertTrue(dp.dashboardstatsondp.size() == 1,
				"dashboard stats  is not present on dashboard even if setting is enabled  ");

	}

	/**
	 * Verify courses enrolled count from dashboard page w.r.t profile page
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 3)
	public void Verify_Course_Enrolled_Count_on_Dashboard_Stats() throws InterruptedException {
		driver.get(dashboard);
		Thread.sleep(1500);
		String DP_Enrolled_Count = dp.courseenrolleddp.getText();
		driver.get(profilepage + "#usercourses");
		Thread.sleep(500);
		String ProfilePage_Enroled = String.valueOf(dp.coursesfromprofilepage.size());
		Assert.assertEquals(DP_Enrolled_Count, ProfilePage_Enroled,
				"The courses enrolled count from dashboard and profile page didnt matched ");
	}

	/**
	 * Verify activities completed count from dashboard page w.r.t profile page
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 4)
	public void Verify_Activities_Completed_Count_on_Dashboard_Stats() throws InterruptedException {
		driver.get(dashboard);
		Thread.sleep(1500);
		String DP_Activities_Completed = dp.activitiescompleted.getText();
		driver.get(profilepage + "#usercourses");
		Thread.sleep(500);
		String PP_ComptedActivities = dp.CompletedActivities();
		Assert.assertEquals(DP_Activities_Completed, PP_ComptedActivities,
				"Completed Activities count from dashboard stats and profilepage didnt matched");
	}

	/**
	 * Verify course completed count from dashboard page stats w.r.t profile page
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 5)
	public void Verify_Completed_Course_Count_on_Dashboard_Stats() throws InterruptedException {

		driver.get(dashboard);
		Thread.sleep(1500);
		String DP_Completed_Course = dp.coursecompleted.getText();
		driver.get(profilepage + "#usercourses");
		Thread.sleep(5000);
		String PP_ComptedCourses = Integer.toString(dp.Completed_Course_Count());
		Assert.assertEquals(DP_Completed_Course, PP_ComptedCourses,
				"The course completed count from dashboard stats and profile page didnt matched");
	}

	/**
	 * Verify activities due count from dashboard page stats w.r.t profile page
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 6)
	public void Verify_Activities_Due_Count_on_Dashboard_Stats() throws InterruptedException {
		driver.get(dashboard);
		Thread.sleep(2000);
		int DP_Due_Activities = Integer.parseInt(dp.activitiesdue.getText());
		driver.get(profilepage + "#usercourses");
		int PP_ComptedActivities = Integer.parseInt(dp.CompletedActivities());
		int PP_Total_Activities = Integer.parseInt(dp.TotalActivities());
		int PP_Due_Activities = (PP_Total_Activities - PP_ComptedActivities);

		Assert.assertEquals(DP_Due_Activities, PP_Due_Activities,
				"Due Activities count from dashboard stats and profilepage didnt matched");
	}
}
