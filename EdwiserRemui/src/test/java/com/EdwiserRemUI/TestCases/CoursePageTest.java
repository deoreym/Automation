package com.EdwiserRemUI.TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.EdwiserRemUI.BaseTest.BaseClass;
import com.EdwiserRemUI.PageObjects.CoursePage;
import com.EdwiserRemUI.PageObjects.DashboardSettingPage;

public class CoursePageTest extends BaseClass {

	DashboardSettingPage dsp;
	CoursePage cp;

	@BeforeClass
	public void Before_class() {
		System.out.println("In Course Page Test Class : CoursePageTest");
		dsp = new DashboardSettingPage(driver);
		cp = new CoursePage(driver);
	}

	@Test(priority = 1)
	public void Verify_Course_Stats_Disabled() {
		driver.get(remuisetting);
		cp.coursepagemenu.click();

		if (cp.coursestatsonsp.isSelected()) {
			cp.coursestatlabel.click();
		}
		cp.savechanges.click();
		driver.get(coursepage);
		Assert.assertTrue(cp.coursestatsoncp.size() == 0, "Course stat option is present even if setting is disabled ");
	}

	@Test(priority = 2)
	public void Enable_Course_Stats_for_Course_Page_From_RemUi_Settings() {
		driver.get(remuisetting);
		cp.coursepagemenu.click();

		if (!cp.coursestatsonsp.isSelected()) {
			cp.coursestatlabel.click();

		}
		cp.savechanges.click();
		driver.get(coursepage);
		Assert.assertTrue(cp.coursestatsoncp.size() == 1,
				"Course stat option is not present even if setting is enabled ");
	}

	@Test(priority = 3)
	public void verifycourseselectedcount() throws InterruptedException {
		driver.get(remuisetting);
		cp.coursepagemenu.click();
		
		cp.SelectOption(cp.CoursesPerPage).selectByValue("9");
		cp.savechanges.click();
		
		driver.get(coursearchive);
		Thread.sleep(2000);
		Assert.assertEquals(String.valueOf(cp.countonap.size()), "9",
				"The Number of Courses to be Displayed Per Pages on Course Archive Page did not matched.");
	}

	@Test(priority = 4)
	public void Set_Default_Design_For_Course_Header() throws InterruptedException {

		driver.get(remuisetting);
		cp.coursepagemenu.click();
		cp.SelectOption(cp.courseheader).selectByVisibleText("Default");
		;
		cp.savechanges.click();
		Thread.sleep(2000);
		driver.get(coursepage1);

		Assert.assertTrue(cp.headerdesignoncp.size() == 0,
				"default design on course page is not getting visible even if default design  is selected");

	}

	@Test(priority = 5)
	public void Set_Header_1_Design_For_Course_Header() throws InterruptedException {
		driver.get(remuisetting);
		cp.coursepagemenu.click();
		cp.SelectOption(cp.courseheader).selectByVisibleText("Header design 1");
		;
		cp.savechanges.click();
		Thread.sleep(2000);
		driver.get(coursepage1);
		Assert.assertTrue(cp.headerdesignoncp.size() == 1,
				"Header design 1 on course page is not getting visible even if header design 1 is selected");
	}

	@Test(priority = 6)
	public void Enable_Next_Previous_activity_button() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		driver.get(remuisetting);
		cp.coursepagemenu.click();
		cp.SelectOption(cp.NextPrevActivity).selectByVisibleText("Enable");
		cp.savechanges.click();
		driver.get(coursepage1);
		cp.clickonanyactivity.click();
		softAssert.assertTrue(cp.prevactivity.size() == 1,
				"prevactivity button is not getting visible even if setting is enabled");

		softAssert.assertTrue(cp.nextactivity.size() == 1,
				"nextactivity button is not getting visible even if setting is enabled");
		softAssert.assertAll();
	}

	@Test(priority = 7)
	public void Disable_Next_Previous_activity_button() {
		SoftAssert softAssert = new SoftAssert();
		driver.get(remuisetting);
		cp.coursepagemenu.click();
		cp.SelectOption(cp.NextPrevActivity).selectByVisibleText("Disable");
		cp.savechanges.click();
		driver.get(coursepage1);
		cp.clickonanyactivity.click();
		softAssert.assertTrue(cp.prevactivity.size() == 0,
				"prevactivity button is  getting visible even if setting is disabled");

		softAssert.assertTrue(cp.nextactivity.size() == 0,
				"nextactivity button is  getting visible even if setting is disabled");
		softAssert.assertAll();
	}

	@Test(priority = 8)
	public void Enable_Next_Previous_activity_button_with_Activity_Name() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		driver.get(remuisetting);
		cp.coursepagemenu.click();
		cp.SelectOption(cp.NextPrevActivity).selectByVisibleText("Enable with Activity name");
		cp.savechanges.click();
		driver.get(coursepage1);
		String actnameprev = cp.prevactivityname.getText().replaceAll("\\s", "");
		String actnamenext = cp.nextactivityname.getText().replaceAll("\\s", "");

		Thread.sleep(1000);
		cp.clickonanyactivity.click();
		softAssert.assertTrue(cp.prevactivity.size() == 1,
				"prevactivity button is not getting visible even if setting is enabled");

		softAssert.assertTrue(cp.nextactivity.size() == 1,
				"nextactivity button is not getting visible even if setting is enabled");

		softAssert.assertEquals(actnameprev, cp.prevactivitynameap.getText().replaceAll("\\s", ""),
				"The activity name on previous button didnt matched ");

		softAssert.assertEquals(actnamenext, cp.nextactivitynameap.getText().replaceAll("\\s", ""),
				"The activity name on next button didnt matched ");

		// verify previous button on activity page is clickable and is redirecting to
		// expected activity
		String currenturl = driver.getCurrentUrl();
		cp.prevactivitynameap.click();
		Thread.sleep(1000);
		String prevactivitytitle = cp.activitytitle.getText().replaceAll("\\s", "");

		softAssert.assertEquals(prevactivitytitle, actnameprev,
				"On clicking the previous activity button it is not redirecting to expected activity");

		// verify next button on activity page is clickable and is redirecting to
		// expected activity
		driver.get(currenturl);
		cp.nextactivitynameap.click();
		Thread.sleep(1000);
		String nextactivitytitle = cp.activitytitle.getText().replaceAll("\\s", "");
		softAssert.assertEquals(nextactivitytitle, actnamenext,
				"On clicking the next activity button it is not redirecting to expected activity");

		softAssert.assertAll();
	}
}
