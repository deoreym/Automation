package com.EdwiserRemUI.TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.EdwiserRemUI.BaseTest.BaseClass;
import com.EdwiserRemUI.PageObjects.ProfilePage;

import com.EdwiserRemUI.PageObjects.MyCourses;

public class MyCoursesTest extends BaseClass {

	MyCourses MC;
	ProfilePage pp;

	@Parameters({ "StudentUser", "StudentPassword" })
	@BeforeClass
	public void Before_class(String username, String password) throws InterruptedException {
		System.out.println("In My Courses Test Class : MyCoursesTest");
		MC = new MyCourses(driver);
		pp = new ProfilePage(driver);
		adminbackendlogout();
		studentLogin(username, password);
	}

	/**
	 * Test Total Enrolled Courses Count on My courses Page
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 1)
	public void TestTotalEnrolledCoursesCount() throws InterruptedException {
		driver.get(profilepage + "#usercourses");
		Thread.sleep(1500);
		int Courses = pp.CoursesCards.size();
		driver.get(mycourses);
		Thread.sleep(3000);
		MC.ShowIcon.click();
		MC.AllCourses.click();
		Thread.sleep(7000);
		Assert.assertEquals(MC.CourseCards.size(), Courses,
				"Courses Count not matching on Profile and My Course Pages");
	}

	/**
	 * Test Courses Per Page Filter
	 * 
	 * @throws InterruptedException
	 */
	//@Test(priority = 2)
	public void TestCoursesPerPageFilter() throws InterruptedException {
		driver.get(mycourses);
		Thread.sleep(5000);
		MC.ShowIcon.click();
		MC.Courses12.click();
		Thread.sleep(5000);
		Assert.assertEquals(MC.CourseCards.size(), 12,
				"Courses Count not matching as per selected filter on My Course Pages");
	}

	/**
	 * Test Course Search on My Courses Page
	 * 
	 * @throws InterruptedException
	 */
	//@Test(priority = 3)
	public void SearchCourses() throws InterruptedException {
		driver.get(mycourses);
		Thread.sleep(5000);
		MC.SearchCourse.clear();
		MC.SearchCourse.sendKeys("Testing Course - 18 - Automation Course - 1");
		Thread.sleep(5000);
		Assert.assertEquals(MC.CourseCards.size(), 1, "Course is Not getting Searched");
	}

	/**
	 * Check View Course Link
	 * 
	 * @throws InterruptedException
	 */
	//@Test(priority = 4)
	public void CheckViewCourseLink() throws InterruptedException {
		driver.get(mycourses);
		Thread.sleep(5000);
		MC.SearchCourse.clear();
		MC.SearchCourse.sendKeys(courseName);
		Thread.sleep(5000);
		Assert.assertEquals(MC.CourseCards.size(), 1, "Course is Not getting Searched");
		MC.ViewCourseButton(courseName).click();
		Thread.sleep(3000);
		Assert.assertEquals(driver.getCurrentUrl(), coursepage, "View Course button is not working.");
	}

}
