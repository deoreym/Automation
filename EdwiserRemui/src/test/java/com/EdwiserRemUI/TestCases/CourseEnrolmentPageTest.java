package com.EdwiserRemUI.TestCases;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.EdwiserRemUI.BaseTest.BaseClass;
import com.EdwiserRemUI.PageObjects.CoursePage;
import com.EdwiserRemUI.PageObjects.EnrollmentPage;

public class CourseEnrolmentPageTest extends BaseClass {

	CoursePage CP;
	EnrollmentPage EP;

	@Parameters({ "siteURL", "username", "password" })
	@BeforeClass
	public void Before_class(String siteURL, String username, String password) throws InterruptedException {
		System.out.println("In Course Enrolment Page Test Class : CourseEnrolmentPageTest");
		CP = new CoursePage(driver);
		EP = new EnrollmentPage(driver);
	}

	/**
	 * Test RemUI Custom Fields on Course ENrolment
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 1)
	public void Set_RemUI_CutomFields_Data() throws InterruptedException {
		SoftAssert sf = new SoftAssert();
		Thread.sleep(2000);
		driver.get(EnrolmentTestCourse);
		Thread.sleep(500);
		CP.CourseSettings.click();
		CP.RemUI_CF.click();
		Thread.sleep(500);
		CP.Duration.clear();
		CP.Duration.sendKeys("25 Hours");
		CP.IntroVideo.clear();
		CP.IntroVideo.sendKeys(CourseIntroVideo);
		Select SkillLevel = new Select(CP.Skill_Level);
		SkillLevel.selectByVisibleText("Advanced");
		CP.Save_and_Display.click();
		Thread.sleep(1000);
		driver.get(CourseEnrolmentPage);
		Thread.sleep(500);
		sf.assertEquals(EP.Duration.getText(), "25 Hours",
				"Course Duartion is not matching on 'Course Edit page' and 'Course Enrolment page'");
		sf.assertEquals(EP.Skill_Level.getText(), "Advanced",
				"Course Skill Level is not matching on 'Course Edit page' and 'Course Enrolment page'");
		sf.assertEquals(EP.Intro_Video_Frame.getAttribute("src"), CourseIntroVideo,
				"Course Intro video URL is not matching on 'Course Edit page' and 'Course Enrolment page'");
		sf.assertAll();
	}

	/**
	 * Check Enrolment Page Data
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 2)
	public void Check_Enrolment_Page_Data() throws InterruptedException {
		SoftAssert sf = new SoftAssert();
		Thread.sleep(1000);
		driver.get(EnrolmentTestCourse);
		Thread.sleep(500);
		String Enrolled_Students = CP.EnrolledStudents.getText();
		String Course_Category = CP.CourseCategory.getText();
		CP.CourseSettings.click();
		Thread.sleep(1000);

		String Overview_Text = "The human body is a complex, highly organized structure made up of unique cells that work together to accomplish the specific functions necessary for sustaining life.";

		CP.Course_Summary.clear();
		CP.Course_Summary.sendKeys(Overview_Text);

		Select dropdownDay = new Select(CP.StartDate_Day);
		// Get the selected option
		String Day = dropdownDay.getFirstSelectedOption().getText();

		Select dropdownMonth = new Select(CP.StartDate_Month);
		// Get the selected option
		String Month = dropdownMonth.getFirstSelectedOption().getText();

		Select dropdownYear = new Select(CP.StartDate_Year);
		// Get the selected option
		String Year = dropdownYear.getFirstSelectedOption().getText();

		String StartDate = Day + " " + Month + " " + Year;
		System.out.println("CP : StartDate : " + StartDate);

		CP.Save_and_Display.click();
		driver.get(CourseEnrolmentPage);
		Thread.sleep(500);

		sf.assertTrue(EP.Course_Overview.getText().contains(Overview_Text),
				"Course Overview Text not Available OR Not Matching");
		sf.assertEquals(EP.StudentsCount.getText(), Enrolled_Students,
				"Course Enrolled Students Count not Matching on Enrolment Page");
		sf.assertEquals(EP.Category.getText(), Course_Category, "Course Category not Matching on Enrolment Page");
		sf.assertEquals(EP.LessonsCount.getText(), "4", "Course Lesson Count not Matching on Enrolment Page");

		System.out.println("EP : StartDate : " + EP.Course_Start_Date.getText());
//		sf.assertEquals(EP.Course_Start_Date.getText(), StartDate, "Course Start Date not Matching on Enrolment Page");
		sf.assertTrue(EP.Course_Language.getText().contains("English"),
				"Course Language not Available OR Not Matching");

		EP.InstructorTab.click();
		Thread.sleep(500);
		sf.assertEquals(EP.InstructorList.size(), 2, "Course Category not Matching on Enrolment Page");
		sf.assertAll();
	}

}
