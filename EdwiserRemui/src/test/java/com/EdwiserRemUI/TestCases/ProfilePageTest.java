package com.EdwiserRemUI.TestCases;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.EdwiserRemUI.BaseTest.BaseClass;
import com.EdwiserRemUI.PageObjects.ColorConversion;
import com.EdwiserRemUI.PageObjects.DashBoardPage;
import com.EdwiserRemUI.PageObjects.HeaderHideShowMenuPage;
import com.EdwiserRemUI.PageObjects.ProfilePage;
import com.EdwiserRemUI.PageObjects.SettingsPage;

public class ProfilePageTest extends BaseClass {

	SettingsPage sp;
	DashBoardPage dp;
	HeaderHideShowMenuPage hsp;
	ColorConversion cc;
	ProfilePage pp;

	@Parameters({ "siteURL", "username", "password" })
	@BeforeClass
	public void Before_class(String siteURL, String username, String password) throws InterruptedException {
		System.out.println("In Profile Page Test Class : ProfilePageTest");
		sp = new SettingsPage(driver);
		dp = new DashBoardPage(driver);
		hsp = new HeaderHideShowMenuPage(driver);
		cc = new ColorConversion();
		pp = new ProfilePage(driver);
	}

	@Test(priority = 1)
	public void verifyblogentrieswhenenabled() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		driver.get(siteadminurl);
		pp.generaltab.click();
		pp.advancedfeaturemenu.click();
		Thread.sleep(2000);
		String present = pp.blogchbk.getAttribute("Checked");
		boolean status = Boolean.parseBoolean(present);
		if (status == true) {
			driver.get(profilepage);
			softAssert.assertTrue(pp.blogentriesonpp.size() == 1,
					"Blog entries is not visible even when setting is enable from advanced feature");
			String actual = pp.blogcount.getAttribute("innerHTML");
			driver.get(blogpage);
			int count = pp.blogsize.size();
			String expected = Integer.toString(count);
			softAssert.assertEquals(actual, expected, "The blog entries count didnt matched ");

		} else {
			pp.lablelblog.click();
			sp.savebutton.click();
			driver.get(profilepage);
			softAssert.assertTrue(pp.blogentriesonpp.size() == 1,
					"Blog entries is not visible even when setting is enable from advanced feature");
			String actual = pp.blogcount.getAttribute("innerHTML");
			driver.get(blogpage);
			int count = pp.blogsize.size();
			String expected = Integer.toString(count);
			softAssert.assertEquals(actual, expected, "The blog entries count didnt matched ");

		}
		softAssert.assertAll();

	}

	@Test(priority = 2)
	public void verifyblogentrieswhendisabled() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		driver.get(siteadminurl);
		pp.generaltab.click();
		pp.advancedfeaturemenu.click();
		Thread.sleep(2000);
		String present = pp.blogchbk.getAttribute("Checked");
		boolean status = Boolean.parseBoolean(present);
		if (status == true) {
			pp.lablelblog.click();
			sp.savebutton.click();
			driver.get(profilepage);
			softAssert.assertTrue(pp.blogentriesonpp.size() == 0,
					"Blog entries is  visible even when setting is disabled from advanced feature");

		} else {
			driver.get(profilepage);
			softAssert.assertTrue(pp.blogentriesonpp.size() == 0,
					"Blog entries is  visible even when setting is disabled from advanced feature");

		}
		softAssert.assertAll();
	}

	@Test(priority = 3)
	public void VerifyBadgewhenenabled() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		driver.get(siteadminurl);
		pp.generaltab.click();
		pp.advancedfeaturemenu.click();
		Thread.sleep(2000);
		String present = pp.badgechbk.getAttribute("Checked");
		boolean status = Boolean.parseBoolean(present);
		if (status == true) {
			driver.get(profilepage);
			softAssert.assertTrue(pp.badgeentriesonpp.size() == 1,
					"Badge entries is not visible even when setting is enable from advanced feature");
			String actual = pp.badgecount.getAttribute("innerHTML");
			int count = pp.badgesize.size();
			String expected = Integer.toString(count);
			softAssert.assertEquals(actual, expected, "The badge entries count didnt matched ");

		} else {
			pp.lablelbadge.click();
			sp.savebutton.click();
			driver.get(profilepage);
			softAssert.assertTrue(pp.badgeentriesonpp.size() == 1,
					"Badge entries is not visible even when setting is enable from advanced feature");
			String actual = pp.badgecount.getAttribute("innerHTML");
			int count = pp.badgesize.size();
			String expected = Integer.toString(count);
			softAssert.assertEquals(actual, expected, "The badge entries count didnt matched ");

		}
		softAssert.assertAll();
	}

	@Test(priority = 4)
	public void verifybadgewhendisabled() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		driver.get(siteadminurl);
		pp.generaltab.click();
		pp.advancedfeaturemenu.click();
		Thread.sleep(2000);
		String present = pp.badgechbk.getAttribute("Checked");
		boolean status = Boolean.parseBoolean(present);
		if (status == true) {
			pp.lablelbadge.click();
			sp.savebutton.click();
			driver.get(profilepage);
			softAssert.assertTrue(pp.badgeentriesonpp.size() == 0,
					"Badge entries is  visible even when setting is disabled from advanced feature");

		} else {
			driver.get(profilepage);
			softAssert.assertTrue(pp.badgeentriesonpp.size() == 0,
					"Badge entries is  visible even when setting is disabled from advanced feature");

		}
		softAssert.assertAll();
	}

	
	
	@Test(priority = 5)
	public void verifydiscussioncount1() throws InterruptedException {
	    int totalCount = 0; // Initialize total discussion count
	    SoftAssert softAssert = new SoftAssert(); // SoftAssert to verify conditions without stopping the test on failure
	    List<String> discussion = new ArrayList<>(); // Initialize a list to hold discussion items (if needed)
	    
	    // Visit course profile page (assuming profile page URL is stored in 'profilepage')
	    driver.get(profilepage);

	    // Fetch the actual discussion count (this is presumably the text element displaying the count)
	    String actual = pp.discussioncount.getText();

	    // Visit the forum page (assuming forum page URL is stored in 'forumpage1')
	    driver.get(forumpage1);

	    // Get the current page discussion count (size of discussions on the current page)
	    int countOnCurrentPage = pp.discussionsize.size();
	    totalCount += countOnCurrentPage; // Add the current page's discussions to the total count

	    // Now, handle pagination and get discussion counts on subsequent pages
	    while (true) {
	    	if(pp.next_page.size() == 1) { // Check if the "next page" button exists (1 element means "next" page is available)
	        pp.next_page.get(0).click(); // Click the "next" button to go to the next page
	        Thread.sleep(2000); // Wait for the page to load (or use WebDriverWait for better synchronization)
	        
	        // Get the count of discussions on the current page after navigating
	        int discussionsOnNextPage = pp.discussionsize.size();
	        totalCount += discussionsOnNextPage; // Add the count of discussions on this page to the total count
	        
	        // Optionally, you can add each discussion to the list (if needed for further verification)
	        for (WebElement discussionElement : pp.discussionsize) {
	            discussion.add(discussionElement.getText());
	        }
	        break;
	    }
	    	

	    // After pagination, verify if the total discussion count is as expected (soft assertion for non-blocking checks)
	    softAssert.assertEquals(totalCount, Integer.parseInt(actual), "Total discussion count mismatch!");

	    // Call assertAll() to validate all soft assertions
	    softAssert.assertAll();
	    }
	}

	@Test(priority = 6)
	public void Edit_Profile_Fileds() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();

		driver.get(profilepage);
		Thread.sleep(1000);
		String FirstName = "Yogesh";
		String LastName = "Deore";
		String PhNumber = "9876543210";
		String Department = "eLearning";
		String Country = "India";
		String City = "Pune";
		String Description = "We're a team of 80+ developers, testers, designers, business development managers.. who become a part of your team when you work with us.";
		String Address = "202, Second Floor, Akshay Vaibhav, Survey Number:287/8, near Solaris Club, Riviresa Society, Baner, Pune, Maharashtra 411045";

		pp.EditIcon.click();

		pp.FirstName.clear();
		pp.FirstName.sendKeys(FirstName);

		pp.LastName.clear();
		pp.LastName.sendKeys(LastName);

		String Email = pp.Email.getAttribute("value");

		pp.PhoneNumber.clear();
		pp.PhoneNumber.sendKeys(PhNumber);

		pp.Department.clear();
		pp.Department.sendKeys(Department);

		Select country = new Select(pp.Country);
		country.selectByVisibleText(Country);

		pp.City.clear();
		pp.City.sendKeys(City);

		pp.Description.clear();
		pp.Description.sendKeys(Description);

		pp.Address.clear();
		pp.Address.sendKeys(Address);

		pp.SaveChanges.click();
		Thread.sleep(1500);

		softAssert.assertEquals(pp.FirstNameText.getText(), FirstName, "First name is not getting updated");
		softAssert.assertEquals(pp.LastNameText.getText(), LastName, "Last name is not getting updated");
		softAssert.assertEquals(pp.EmailText.getText(), Email, "Email is not Matching");
		softAssert.assertEquals(pp.PhoneNumberText.getText(), PhNumber, "Phone Number is not getting updated");
		softAssert.assertEquals(pp.DepartmentText.getText(), Department, "Department is not getting updated");
		softAssert.assertEquals(pp.CountryText.getText(), Country, "Country is not getting updated");
		softAssert.assertEquals(pp.CityText.getText(), City, "City is not getting updated");
		softAssert.assertEquals(pp.DescriptionText.getText(), Description, "Description is not getting updated");
		softAssert.assertEquals(pp.AddressText.getText(), Address, "Address is not getting updated");
		softAssert.assertAll();

	}
}
