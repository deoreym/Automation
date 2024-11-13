package com.EdwiserRemUI.TestCases;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.EdwiserRemUI.BaseTest.BaseClass;
import com.EdwiserRemUI.PageObjects.CoursesArchivePage;

public class CourseArchivePageTest extends BaseClass {
	CoursesArchivePage CAP;

	@BeforeClass
	public void Before_class() {
		System.out.println("In Course Archive Page Test Class : CourseArchivePageTest");
		CAP = new CoursesArchivePage(driver);

	}

	@Test(priority = 1)
	public void Select_Number_Of_Courses_PerPage() throws InterruptedException {

		// Click Course Page Settings
		driver.get(remuisetting);
		Thread.sleep(1000);
		CAP.RemUICourseSettings.click();
		Thread.sleep(500);

		// Select Number of Courses per Page
		Select NC = new Select(CAP.courseselectcount);
		NC.selectByValue("6");
		CAP.savechanges.click();

		// Visit Course Archive (Categories) Page
		driver.get(coursearchive);
		Assert.assertTrue(CAP.CourseCards.size() == 8, "Selected Number Of Courses per page is not getting Applied");
	}

	@Test(priority = 2)
	public void Enable_Disable_Course_Date_On_Archive_Page() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();

		// Click Course Page Settings
		driver.get(remuisetting);
		Thread.sleep(1000);
		CAP.RemUICourseSettings.click();
		Thread.sleep(500);

		// Select "Do Not Show" Date on Course Archive
		Select ShowDate = new Select(CAP.ShowDate);
		ShowDate.selectByValue("hidedate");
		CAP.savechanges.click();

		// Visit Course Archive (Categories) Page
		driver.get(coursearchive);

		softAssert.assertTrue(CAP.UpdatedDateOptionList.size() == 0,
				"Course Date is not getting Hidden from Course Archive Page");

		// Click Course Page Settings
		driver.get(remuisetting);
		Thread.sleep(1000);
		CAP.RemUICourseSettings.click();
		Thread.sleep(500);

		// Select "Shoe Updated Date" on Course Archive Page
		Select ShowDate1 = new Select(CAP.ShowDate);
		ShowDate1.selectByValue("showupdatedate");
		CAP.savechanges.click();

		// Visit Course Archive (Categories) Page
		driver.get(coursearchive);

		softAssert.assertTrue(CAP.UpdatedDateOptionList.size() > 0,
				"Course Date is not getting Visible on Course Archive Page");

		softAssert.assertAll();
	}

	@Test(priority = 3)
	public void Disable_Enrolled_Students_and_Number_Of_Sections_Visibility_On_Archive_Page()
			throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();

		// Click Course Page Settings
		driver.get(remuisetting);
		Thread.sleep(1000);
		CAP.RemUICourseSettings.click();
		Thread.sleep(500);

		// Disable Enrolled Students Visibility
		if (CAP.EnrolledStudentsVisibilityCheckbox.isSelected()) {
			CAP.EnrolledStudentsVisibility.click();
		}

		// Disable Lesson Count Visibility
		if (CAP.LessonsVisibilityCheckbox.isSelected()) {
			CAP.LessonsVisibility.click();
		}
		CAP.savechanges.click();

		// Visit Course Archive (Categories) Page
		driver.get(coursearchive);

		softAssert.assertTrue(CAP.EnrolledUserOptionList.size() == 0,
				"Enrolled Students is not getting Hidden from Course Archive Page");

		softAssert.assertTrue(CAP.LessonsOptionList.size() == 0,
				"Number Of Lessons is not getting Hidden from Course Archive Page");

		softAssert.assertAll();
	}

	@Test(priority = 4)
	public void Enable_Enrolled_Students_Visibility_On_Archive_Page() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();

		// Click Course Page Settings
		driver.get(remuisetting);
		Thread.sleep(1000);
		CAP.RemUICourseSettings.click();
		Thread.sleep(500);

		// Enable Enrolled Students Visibility
		if (!CAP.EnrolledStudentsVisibilityCheckbox.isSelected()) {
			CAP.EnrolledStudentsVisibility.click();
		}
		// Set Text for Enrolled Students Visibility
		CAP.EnrolledStudentsText.clear();
		CAP.EnrolledStudentsText.sendKeys("Students");
		CAP.savechanges.click();

		// Visit Course Archive (Categories) Page
		driver.get(coursearchive);

		softAssert.assertTrue(CAP.EnrolledUserOptionList.size() > 0,
				"Enrolled Students is not getting Visible On Course Archive Page");

		softAssert.assertTrue(CAP.EnrolledUserOptionText.getText().contains("Students"),
				"Alternet Text for Enrolled Students is not Maching with Added Text On Course Archive Page");

		softAssert.assertAll();
	}

	@Test(priority = 5)
	public void Enable_Number_of_Lessons_On_Archive_Page() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();

		// Click Course Page Settings
		driver.get(remuisetting);
		Thread.sleep(1000);
		CAP.RemUICourseSettings.click();
		Thread.sleep(500);

		// Enable Enrolled Students Visibility
		if (!CAP.LessonsVisibilityCheckbox.isSelected()) {
			CAP.LessonsVisibility.click();
		}
		// Set Text for Enrolled Students Visibility
		CAP.LessonsVisibilityText.clear();
		CAP.LessonsVisibilityText.sendKeys("Sections");
		CAP.savechanges.click();

		// Visit Course Archive (Categories) Page
		driver.get(coursearchive);
		CAP.ListViewIcon.click();
		softAssert.assertTrue(CAP.LessonsOptionList.size() > 0,
				"Number Of Lessons is not getting Visible On Course Archive Page");
		softAssert.assertTrue(CAP.LessonsOptionText.getText().contains("Sections"),
				"Alternet Text for Lessons is not Maching with Added Text On Course Archive Page");
		CAP.CardViewIcon.click();
		softAssert.assertAll();
	}

	@Test(priority = 6)
	public void SearchCourse_and_Check_All_Options() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		// Visit Course Archive (Categories) Page
		driver.get(coursearchive);
		Thread.sleep(2500);
		// Search for Course
		CAP.Search_Courses.click();
		CAP.Search_Courses.sendKeys(courseName);
		CAP.Search_Courses_Icon.click();
		Thread.sleep(2000);

		softAssert.assertTrue(CAP.CourseCards.size() == 1, "Searched Course Not Found");
		softAssert.assertAll();

	}

	@Test(priority = 7)
	public void Category_Filter() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		// Visit Course Archive (Categories) Page
		driver.get(coursearchive);

		// Select Category From Filter
		CAP.CategoryFilter.click();
		String Category = CAP.FirstCategoryFromFilter.getText();
		CAP.FirstCategoryFromFilter.click();
		Thread.sleep(500);

		softAssert.assertTrue(CAP.CourseCard_Category_Name.getText().contains(Category),
				"Courses of Selected Category Not Filtered");
		softAssert.assertAll();

	}

	@Test(priority = 8)
	public void Check_All_Course_Card_Views() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		// Visit Course Archive (Categories) Page
		driver.get(coursearchive);

		// Card View : grid-view edw-course-card-grid
		// List View : list-view list-group edw-course-list-container
		// Summary View : summary-view edw-course-summary-container

		// Select List View
		CAP.ListViewIcon.click();

		// Check List View Is applied Or Not
		softAssert.assertTrue(
				CAP.CourseCardsFrame.getAttribute("class").contains("list-view list-group edw-course-list-container"),
				"List View is not getting applied");

		// Select Summary View
		CAP.SummaryViewIcon.click();

		// Check Summary View Is applied Or Not
		softAssert.assertTrue(
				CAP.CourseCardsFrame.getAttribute("class").contains("summary-view edw-course-summary-container"),
				"Summary View is not getting applied");
		softAssert.assertTrue(CAP.CourseSummary.isDisplayed(), "Course Description is Not visible in Summary View ");

		// Select Grid View
		CAP.CardViewIcon.click();

		// Check Grid View Is applied Or Not
		softAssert.assertTrue(CAP.CourseCardsFrame.getAttribute("class").contains("grid-view edw-course-card-grid"),
				"Grid View is not getting applied");

		softAssert.assertAll();

	}
	
	@Test(priority=9)
	public void Check_courses_count_on_site() throws InterruptedException {
		int sum = 0;
		
		//visit courses and category page
		driver.get(CourseCategoryPage);
		int value=CAP.coursescountfrommoodle.size();
		System.out.println(value);
		Thread.sleep(2000);
		for (WebElement element : CAP.coursescountfrommoodle) {
            // Get the text of the element and convert it to an integer
            String text = element.getText();
            int value1 = Integer.parseInt(text);
            sum += value;
        }
		
	}
	
	

}
