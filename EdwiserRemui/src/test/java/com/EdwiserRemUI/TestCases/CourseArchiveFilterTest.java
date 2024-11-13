package com.EdwiserRemUI.TestCases;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.EdwiserRemUI.BaseTest.BaseClass;
import com.EdwiserRemUI.PageObjects.CoursesArchivePage;

public class CourseArchiveFilterTest extends BaseClass{
	CoursesArchivePage CAP;

	@BeforeClass
	public void Before_class() {
		System.out.println("In Course Archive Filter Page Test Class : CourseArchivePageTest");
		CAP = new CoursesArchivePage(driver);

	}
	
	//@Test(priority=1)
	public void verify_Course_level_tag() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		//visit on course setting page
		driver.get(LevelTagCourse);
		//verify for beginner tag
		CAP.customfieldlink.click();
		Select Skill_Level = new Select(CAP.Skill_Level);
		//Check level tag for beginner
		Skill_Level.selectByValue("1");
		Thread.sleep(2000);
		CAP.Save_and_Display.click();
		driver.get(coursearchive);
		CAP.Search_Courses.sendKeys("Automation Level Tag course");
		Thread.sleep(2000);
		CAP.Search_Courses.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		String tag=CAP.Beginner_tag.getAttribute("innerHTML");
		System.out.println(tag);
		softAssert.assertEquals("Beginner", tag, "The Beginner level tag  selected for the course is not getting visible on course cards ");
         
		
		//visit on course setting page
				driver.get(LevelTagCourse);
				//verify for beginner tag
				CAP.customfieldlink.click();
				Select Skill_Level1 = new Select(CAP.Skill_Level);
				//Check level tag for Intermediate
				Skill_Level1.selectByValue("2");
				Thread.sleep(2000);
				CAP.Save_and_Display.click();
				driver.get(coursearchive);
				CAP.Search_Courses.sendKeys("Automation Level Tag course");
				Thread.sleep(2000);
				CAP.Search_Courses.sendKeys(Keys.ENTER);
				Thread.sleep(2000);
				String tag1=CAP.intermediate_tag.getAttribute("innerHTML");
				System.out.println(tag1);
				softAssert.assertEquals("Intermediate", tag1, "The Intermediate level tag  selected for the course is not getting visible on course cards ");
		        
				//visit on course setting page
				driver.get(LevelTagCourse);
				//verify for beginner tag
				CAP.customfieldlink.click();
				Select Skill_Level2 = new Select(CAP.Skill_Level);
				//Check level tag for Advanced
				Skill_Level2.selectByValue("3");
				Thread.sleep(2000);
				CAP.Save_and_Display.click();
				driver.get(coursearchive);
				CAP.Search_Courses.sendKeys("Automation Level Tag course");
				Thread.sleep(2000);
				CAP.Search_Courses.sendKeys(Keys.ENTER);
				Thread.sleep(2000);
				String tag2=CAP.advanced_tag.getAttribute("innerHTML");
				System.out.println(tag2);
				softAssert.assertEquals("Advanced", tag2, "The Advanced level tag  selected for the course is not getting visible on course cards ");
		      
		softAssert.assertAll();
		

	}
	
	//@Test
	public void verify_sorting_with_low_rating() throws InterruptedException {
		
		 List<String> courseNames= new ArrayList<>(); // Initialize the list;
		SoftAssert softAssert = new SoftAssert();
		//visit course archive page 
		driver.get(coursearchive);
		 // Create a list to hold item texts
		 List<String> itemTexts = new ArrayList<>();
		Thread.sleep(10000);
		
		  while (true) {
	            // Extract course names from the current page
	           
	            System.out.println("Course Names:");
	            for (WebElement course : CAP.coursename) {
	                String courseName = course.getText().trim();
	                System.out.println(courseName);
	                courseNames.add(courseName); // Add course name to the list
	            }
	            if (CAP.Next_page_buttons.size()==0) {
                    break; // No more pages, exit the loop
                }
	            // Click on the next page button
              CAP.Next_page_button.click();
	}
		  // Sort the list of course names
	        List<String> sortedCourseNames = new ArrayList<>(courseNames);
	        Collections.sort(sortedCourseNames);
	        System.out.println("=========================");
	        // Print the original and sorted course names for debugging
	        System.out.println("Original Course Names:");
	        for (String courseName : courseNames) {
	            System.out.println(courseName);
	        }

	        System.out.println("=========================");
	        // Print the sorted course names
	        System.out.println("Sorted Course Names:");
	        for (String courseName : sortedCourseNames) {
	            System.out.println(courseName);
	        }
	        // check courses name after applying sorting
	       CAP.sorting_dd.click();
	       CAP.ASC_Sorting.click();
	       Thread.sleep(3000);
	       List<String> AfterSorting= new ArrayList<>();
	       while (true) {
	            // Extract course names from the current page
	           
	            System.out.println("Course Names:");
	            for (WebElement course : CAP.coursename) {
	                String courseName = course.getText().trim();
	                System.out.println(courseName);
	                AfterSorting.add(courseName); // Add course name to the list
	            }
	            if (CAP.Next_page_buttons.size()==0) {
                   break; // No more pages, exit the loop
               }
	            // Click on the next page button
             CAP.Next_page_button.click();
             }
	       System.out.println("=========================");
	        // Print the course name on applying sorting filter
	        System.out.println("After sorting Course Names:");
	      //  for (String AfterSorting : courseNames) {
	            System.out.println(AfterSorting);
	        }

	        // Assert all
	       // softAssert.assertAll();
//}
	@Test
	public void Verify_Sorting_in_ASC_order() throws InterruptedException {
	    SoftAssert softAssert = new SoftAssert();
	    List<String> courseNamesListBeforeSorting = new ArrayList<>();

	    // Visit course archive page 
	    driver.get(coursearchive);

	    // Extract course names from all pages
	    while (true) {
	        System.out.println("Course Names:");
	        for (WebElement course : CAP.coursename) {
	            String courseName = course.getText().trim();
	            System.out.println(courseName);
	            courseNamesListBeforeSorting.add(courseName);
	        }
	        if (CAP.Next_page_buttons.size() == 0) {
	            break; // No more pages, exit the loop
	        }
	        CAP.Next_page_button.click();
	    }

	    // Sort the list of course names using a custom comparator
	    List<String> sortedCourseNames = new ArrayList<>(courseNamesListBeforeSorting);
	    Collections.sort(sortedCourseNames, new Comparator<String>() {
	        @Override
	        public int compare(String name1, String name2) {
	            // Primary case insensitive comparison
	            int result = name1.compareToIgnoreCase(name2);
	            if (result == 0) {
	                // If they are equal, compare the original strings
	                return name1.compareTo(name2);
	            }
	            return result;
	        }
	    });

	    System.out.println("Sorted Course Names:");
	    for (String courseName : sortedCourseNames) {
	        System.out.println(courseName);
	    }

	    // Click to sort on the page
	    CAP.sorting_dd.click();
	    CAP.ASC_Sorting.click();

	    // Use WebDriverWait instead of Thread.sleep
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfAllElements(CAP.coursename));

	    List<String> courseNamesAfterApplyingSorting = new ArrayList<>();

	    // Extract course names after sorting
	    while (true) {
	        System.out.println("Course Names after sorting:");
	        for (WebElement course : CAP.coursename) {
	            String courseNameAfterSorting = course.getText().trim();
	            System.out.println(courseNameAfterSorting);
	            courseNamesAfterApplyingSorting.add(courseNameAfterSorting);
	        }
	        if (CAP.Next_page_buttons.size() == 0) {
	            break; // No more pages, exit the loop
	        }
	        CAP.Next_page_button.click();
	        wait.until(ExpectedConditions.visibilityOfAllElements(CAP.coursename));
	    }

	    // Print both lists for comparison
	    System.out.println("Course Names After Applying Sorting: " + courseNamesAfterApplyingSorting);
	    System.out.println("Expected Sorted Course Names: " + sortedCourseNames);

	    // Compare the two lists
	    softAssert.assertEquals(courseNamesAfterApplyingSorting, sortedCourseNames, "The course names after sorting do not match the expected sorted list.");
	    
	    softAssert.assertAll();
	}






	
	//@Test
	public void Verify_Sorting_in_DESC_order() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		 List<String> courseNameslistbeforesorting= new ArrayList<>(); // Initialize the list;
		//visit course archive page 
		driver.get(coursearchive);
		
		while (true) {
            // Extract course names from the current page
           
            System.out.println("Course Names:");
            for (WebElement course : CAP.coursename) {
                String courseNameBeforesorting = course.getText().trim();
                System.out.println(courseNameBeforesorting);
                courseNameslistbeforesorting.add(courseNameBeforesorting); // Add course name to the list
            }
            if (CAP.Next_page_buttons.size()==0) {
                break; // No more pages, exit the loop
            }
            // Click on the next page button
          CAP.Next_page_button.click();
}
		// Sort the list of course names
        List<String> sortingCourseNames = new ArrayList<>(courseNameslistbeforesorting);
        Collections.sort(sortingCourseNames,  new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return extractNumericValue(o1) - extractNumericValue(o2);
            }

			private  int extractNumericValue(String sortingCourseNames) {
        Pattern pattern = Pattern.compile("[-]?\\d+");
        Matcher matcher = pattern.matcher(sortingCourseNames);
        if (matcher.find()) {
            return Integer.parseInt(matcher.group());
        }
        return 0; // Default value if no number found
    }
        });
        
        System.out.println("Sorted Course Names:");
        for (String courseName : sortingCourseNames) {
            System.out.println(courseName);
        }
     // check courses name after applying sorting
        Thread.sleep(3000);
	       CAP.sorting_dd.click();
	       CAP.ASC_Sorting.click();
	       Thread.sleep(3000);
	       List<String> CoursenameAfterapplyingSorting= new ArrayList<>();
		
	       while (true) {
	            // Extract course names from the current page
	           
	            System.out.println("Course Names after sorting :");
	            for (WebElement course : CAP.coursename) {
	                String courseNameaftersorting = course.getText().trim();
	                System.out.println(courseNameaftersorting);
	                courseNameslistbeforesorting.add(courseNameaftersorting); // Add course name to the list
	            }
	            if (CAP.Next_page_buttons.size()==0) {
	                break; // No more pages, exit the loop
	            }
	            // Click on the next page button
	          CAP.Next_page_button.click();
	}
		softAssert.assertAll();
		
	}
}
