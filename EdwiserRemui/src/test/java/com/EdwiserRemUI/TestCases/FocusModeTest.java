package com.EdwiserRemUI.TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.EdwiserRemUI.BaseTest.BaseClass;
import com.EdwiserRemUI.PageObjects.FocusMode;

public class FocusModeTest extends BaseClass {

	FocusMode FM;

	@BeforeClass
	public void Before_class() throws InterruptedException {
		FM = new FocusMode(driver);
	}

	@Test(priority = 1)
	public void DisableFocusMode() throws InterruptedException {

		// Visit RemUi Settings
		driver.get(remuisetting);
		Thread.sleep(1000);

		// Click Course Page Settings
		FM.CourseSettings.click();
		Thread.sleep(1000);

		if (FM.FocusModeSetting.isSelected()) {
			FM.FocusModeSettingCB.click();
		}
		// Save Settings
		FM.SaveSettings.click();
		Thread.sleep(1500);

		// Visit Course
		driver.get(FocusModeCoursePage);
		Assert.assertTrue(FM.EnableFMButtonList.size() == 0, "Focus Mode Button Not Present on Course Page");
	}

	@Test(priority = 2)
	public void EnableFocusMode() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		// Visit RemUi Settings
		driver.get(remuisetting);
		Thread.sleep(1000);

		// Click Course Page Settings
		FM.CourseSettings.click();
		Thread.sleep(1000);

		if (!FM.FocusModeSetting.isSelected()) {
			FM.FocusModeSettingCB.click();
		}
		// Save Settings
		FM.SaveSettings.click();
		Thread.sleep(1500);

		// Visit Course
		driver.get(FocusModeCoursePage);
		softAssert.assertTrue(FM.EnableFMButtonList.size() > 0, "Focus Mode Button Not Present on Course Page");

		// Visit Activity
		FM.Activity(2).click();
		softAssert.assertTrue(FM.EnableFMButtonList.size() > 0, "Focus Mode Button Not Present on Activity Page");

		softAssert.assertAll();
	}

	@Test(priority = 3)
	public void Check_Number_Of_Activities_and_Sections_in_FocusMode_Dropdown() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();

		// Visit Course
		driver.get(FocusModeCoursePage);
		Thread.sleep(1500);

		int NumberOfSectionC = FM.CourseSections.size();
		int NumberOfActivitiesC = FM.CourseActivities.size();

		// Enable Focus Mode
		FM.EnableFMButton.click();

		int NumberOfSection = FM.NumberOfSections.size();
		int NumberOfActivities = FM.NumberOfActivities.size();

		// Check Number of Sections in Focusmode Activity DropDown
		softAssert.assertEquals(NumberOfSectionC, NumberOfSection,
				"Total Number of Sections are Not Matching on Focus Mode Activity DropDown");

		// Check Number of Activities in Focusmode Activity DropDown
		softAssert.assertEquals(NumberOfActivitiesC, NumberOfActivities,
				"Total Number of Activities are Not Matching on Focus Mode Activity DropDown");

		// Check Next Previous Buttons Disabled on Course Page
		softAssert.assertTrue(FM.PrevButtonDisabled.size() > 0, "Previous Button is not Disabled on Course Page");
		softAssert.assertTrue(FM.NextButtonDisabled.size() > 0, "Next Button is not Disabled on Course Page");

		// Disable Focus Mode
		FM.DisableFMButton.click();

		softAssert.assertAll();
	}

	@Test(priority = 4)
	public void MoveFrom_FocustMode_NextPrev_Buttons() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		// Visit Course
		driver.get(FocusModeCoursePage);
		Thread.sleep(1000);

		// Store Activity Names
		String Activity1Name = FM.Activity(1).getText();
		String Activity2Name = FM.Activity(2).getText();

		// Visit Activity Number 2
		FM.Activity(2).click();
		Thread.sleep(1000);

		// Enable Focus Mode
		FM.EnableFMButton.click();
		Thread.sleep(500);

		// Click Prev Button
		FM.PreviousButton.click();
		Thread.sleep(1000);

		// Check if User Redirected to Previous Activity
		softAssert.assertEquals(FM.ActivityName.getText(), Activity1Name,
				"Usetr Not resirected to Previous Activity from Focus Mode Previous Button");

		// Click Next Button
		FM.NextButton.click();
		Thread.sleep(1000);

		// Check if User Redirected to Next Activity
		softAssert.assertEquals(FM.ActivityName.getText(), Activity2Name,
				"Usetr Not resirected to Next Activity from Focus Mode Next Button");

		// Disable Focus Mode
		FM.DisableFMButton.click();

		softAssert.assertAll();
	}

	@Test(priority = 5)
	public void Check_NextPrev_Buttons_Disbaled_First_and_Last_Activity() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		// Visit Course
		driver.get(FocusModeCoursePage);
		Thread.sleep(1000);
		int n = FM.NumberOfActivities.size();

		// Store Activity Names
		String Activity1Name = FM.Activity(1).getText();

		// Visit Activity Number 2
		FM.Activity(2).click();
		Thread.sleep(1000);

		// Enable Focus Mode
		FM.EnableFMButton.click();
		Thread.sleep(500);

		// Click Prev Button
		FM.PreviousButton.click();
		Thread.sleep(1000);

		// Check if User Redirected to Previous Activity
		softAssert.assertEquals(FM.ActivityName.getText(), Activity1Name,
				"Usetr Not resirected to Previous Activity from Focus Mode Previous Button");

		softAssert.assertTrue(FM.PrevButtonDisabled.size() > 0,
				"Previous Button is not getting Disabled on First Activity");

		// Disable Focus Mode
		FM.DisableFMButton.click();

		// Visit Course
		driver.get(FocusModeCoursePage);

		// Store Activity Names
		String LastActivityName = FM.Activity(n).getText();

		// Visit Second Last Activity
		FM.Activity(n - 1).click();
		Thread.sleep(1000);

		// Enable Focus Mode
		FM.EnableFMButton.click();
		Thread.sleep(500);

		// Click Next Button
		FM.NextButton.click();
		Thread.sleep(1000);

		// Check if User Redirected to Next Activity
		softAssert.assertEquals(FM.ActivityName.getText(), LastActivityName,
				"Usetr Not resirected to Next Activity from Focus Mode Next Button");
		softAssert.assertTrue(FM.NextButtonDisabled.size() > 0, "Next Button is not getting Disabled on Last Activity");

		// Disable Focus Mode
		FM.DisableFMButton.click();

		softAssert.assertAll();
	}

	@Test(priority = 6)
	public void CheckCourseProgress_in_FocusMode_Header() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();

		// Visit Course
		driver.get(FocusModeCoursePage);
		Thread.sleep(1500);
		String CourseName = FM.CourseName.getText();

		// Enable Focus Mode
		FM.EnableFMButton.click();
		Thread.sleep(1000);

		// Check Course Name is Focus Mode Header
		softAssert.assertEquals(FM.FM_CourseName.getText(), CourseName,
				"Course Name Not Matching on Focus Mode Header");

		String PrevProgress = FM.ProgressPercentage.getText();

		// Mark One Activity as Done (Complete)
		FM.MarkDone.click();
		Thread.sleep(1000);

		// Refresh Page
		driver.get(driver.getCurrentUrl());
		Thread.sleep(1200);

		String NewProgress = FM.ProgressPercentage.getText();

		// Check If Progress Changed Or Not
		softAssert.assertNotEquals(NewProgress, PrevProgress,
				"Course Progress is Not getting Updated on Activity Marked Done in Focus Mode Header");

		// Mark One Activity as not Done (Incomplete)
		FM.MarkDone.click();
		Thread.sleep(1000);

		// Refresh Page
		driver.get(driver.getCurrentUrl());
		Thread.sleep(1200);

		NewProgress = FM.ProgressPercentage.getText();

		// Check If Progress Changed Or Not
		softAssert.assertEquals(NewProgress, PrevProgress,
				"Course Progress is Not getting Updated on Activity Marked not Done in Focus Mode Header");

		// Disable Focus Mode
		FM.DisableFMButton.click();

		softAssert.assertAll();
	}

	@Test(priority = 7)
	public void Check_FocusMode_Prefrance_on_Other_Courses() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();

		// Visit Course
		driver.get(FocusModeCoursePage);
		Thread.sleep(1500);

		// Enable Focus Mode
		FM.EnableFMButton.click();
		Thread.sleep(1000);

		// Check if FocusMode is Getting Enabled
		softAssert.assertTrue(FM.DisableFMButtonList.size() > 0, "Focus Mode is not getting Enabled");

		// Visit Another Course
		driver.get(coursepage);
		Thread.sleep(1500);

		// Check Focus Mode is Enabled On Other Course
		softAssert.assertTrue(FM.DisableFMButtonList.size() > 0,
				"Focus Mode is Prefrence is not getting Enabled on Other Courses");

		// Disable Focus Mode
		FM.DisableFMButton.click();
		Thread.sleep(300);

		// Visit Course
		driver.get(FocusModeCoursePage);
		Thread.sleep(1500);

		// Check Focus Mode is Disbled On Other Course
		softAssert.assertTrue(FM.EnableFMButtonList.size() > 0,
				"Focus Mode is Prefrence is not getting Disabled on Other Courses");

		softAssert.assertAll();
	}

}
