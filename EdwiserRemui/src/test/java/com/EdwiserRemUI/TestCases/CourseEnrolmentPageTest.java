package com.EdwiserRemUI.TestCases;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.EdwiserRemUI.BaseTest.BaseClass;
import com.EdwiserRemUI.PageObjects.CoursePage;
import com.EdwiserRemUI.PageObjects.EnrollmentPage;

public class CourseEnrolmentPageTest extends BaseClass {

	CoursePage CP;
	EnrollmentPage EP;

	@BeforeClass
	public void Before_class() throws InterruptedException {
		CP = new CoursePage(driver);
		EP = new EnrollmentPage(driver);
	}

	/**
	 * Test RemUI Custom Fields on Course ENrolment
	 * 
	 * @throws InterruptedException
	 */
//	@Test(priority = 1)
	public void Set_RemUI_CutomFields_Data() throws InterruptedException {
		SoftAssert sf = new SoftAssert();
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
		driver.get(EnrolmentTestCourse);
		Thread.sleep(500);
		String Enrolled_Students = CP.EnrolledStudents.getText();
		String Course_Category = CP.CourseCategory.getText();
		CP.CourseSettings.click();
		String Overview_Text = CP.Course_Summary.getAttribute("data-initial-value");
		System.out.println("CP : StartDate Day" + CP.StartDate_Day.getAttribute("data-initial-value"));

		String StartDate = CP.StartDate_Day.getAttribute("data-initial-value") + " " + CP.GetStartMonth() + " "
				+ CP.StartDate_Year.getAttribute("data-initial-value");
		System.out.println("CP : StartDate " + StartDate);
		
		driver.get(CourseEnrolmentPage);
		Thread.sleep(500);
		
		sf.assertTrue(EP.Course_Overview.getText().contains(Overview_Text),
				"Course Overview Text not Available OR Not Matching");
		sf.assertEquals(EP.StudentsCount.getText(), Enrolled_Students,
				"Course Enrolled Students Count not Matching on Enrolment Page");
		sf.assertEquals(EP.Category.getText(), Course_Category,
				"Course Category not Matching on Enrolment Page");
		sf.assertEquals(EP.LessonsCount.getText(), "2",
				"Course Lesson Count not Matching on Enrolment Page");
		sf.assertEquals(EP.Lecture.getText(), "2",
				"Course Lecture Count not Matching on Enrolment Page");
		System.out.println("EP : StartDate " + EP.Course_Start_Date.getText());
		sf.assertEquals(EP.Course_Start_Date.getText(), StartDate,
				"Course Start Date not Matching on Enrolment Page");
		sf.assertTrue(EP.Course_Language.getText().contains("English"),
				"Course Language not Available OR Not Matching");
		
		EP.InstructorTab.click();
		Thread.sleep(500);
		sf.assertEquals(EP.InstructorList.size(), 2,
				"Course Category not Matching on Enrolment Page");
		sf.assertAll();
	}

}
