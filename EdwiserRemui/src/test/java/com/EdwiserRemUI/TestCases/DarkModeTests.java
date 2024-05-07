package com.EdwiserRemUI.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.EdwiserRemUI.BaseTest.BaseClass;
import com.EdwiserRemUI.PageObjects.DarkMode;

public class DarkModeTests extends BaseClass {

	DarkMode DM;

	@BeforeClass
	public void Before_class() throws InterruptedException {
		DM = new DarkMode(driver);
	}

	/**
	 * Enable Dark Node On Specific Pages
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 1)
	public void Enable_Dark_Mode_Specific_On_Pages_From_Settings() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();

		driver.get(remuisetting);
		DM.DarkModeSetting("includepages");

		DM.IncludePagesTestArea.clear();
		DM.IncludePagesTestArea.sendKeys("/course/view.php%,\n" + "/my/%");

		DM.savechanges.click();
		Thread.sleep(1000);

		// Check Dark Mode menu on Course Page
		driver.get(coursepage);
		softAssert.assertTrue(DM.DarkModeNavMenu.size() > 0,
				"When Dark Mode is Enabled On Course View Pages then Dark Mode Option is not visible on View Course Page");

		// Check Dark Mode menu on Dashboard
		driver.get(dashboard);
		softAssert.assertTrue(DM.DarkModeNavMenu.size() > 0,
				"When Dark Mode is Enabled On Dashboard then Dark Mode Option is not visible on Dashboard");

		// Enable Dark mode and Navigate to Non Dark Mode Pages
		DM.DarkModeIcon.click();
		Thread.sleep(500);

		softAssert.assertTrue(DM.DarkModeMenu.getAttribute("class").contains("enabled"),
				"Dark Mode is not Getting Enabled on Click of Dark Mode Icon - Nav Menu");
		softAssert.assertTrue(DM.HTML.getAttribute("nighteyeplgn").contains("active"),
				"Dark Mode is not Getting Enabled on Click of Dark Mode Icon - DOM HTML");

		// Not Selected Pages
		driver.get(profilepage);
		softAssert.assertFalse(DM.DarkModeNavMenu.size() > 0,
				"Dark Mode Enabled on Specific Pages Still visible on Profile Page");
		Assert.assertNull(DM.HTML.getAttribute("nighteyeplgn"),
				"Dark Mode CSS Present On Non Selected Page - DOM HTML");

		driver.get(siteadminurl);
		softAssert.assertFalse(DM.DarkModeNavMenu.size() > 0,
				"Dark Mode Enabled on Specific Pages Still visible on Site Administration Pages");

		// Return to Dark Mode Enabled Page Check Dark Mode is Still Enabled
		driver.get(dashboard);
		softAssert.assertTrue(DM.DarkModeMenu.getAttribute("class").contains("enabled"),
				"Check Dark mode is still enabled after navigating to Other Pages - Nav Menu");
		softAssert.assertTrue(DM.HTML.getAttribute("nighteyeplgn").contains("active"),
				"Check Dark mode is still enabled after navigating to Other Pages - DOM HTML");

		// Enable Light Mode
		DM.LightModeIcon.click();
		Thread.sleep(1500);

		// Check If Light Mode is Enabled OR Not
		softAssert.assertFalse(DM.DarkModeMenu.getAttribute("class").contains("enabled"),
				"Light Mode is not Getting Enabled on Click of Light Mode Icon  - Nav Menu");
		softAssert.assertTrue(DM.HTML.getAttribute("nighteyeplgn").contains("disabled"),
				"Light Mode is not Getting Enabled on Click of Dark Mode Icon - DOM HTML");

		softAssert.assertAll();
	}

	/**
	 * Disable Dark Mode On Specific Pages
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 2)
	public void Disable_Dark_Mode_Specific_On_Pages_From_Settings() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();

		driver.get(remuisetting);
		DM.DarkModeSetting("excludepages");

		DM.ExcludePagesTestArea.clear();
		DM.ExcludePagesTestArea.sendKeys("/course/view.php%,\n" + "/my/%");

		DM.savechanges.click();
		Thread.sleep(1000);

		// Check Dark Mode menu on Dashboard
		driver.get(dashboard);
		softAssert.assertFalse(DM.DarkModeNavMenu.size() > 0,
				"When Dark Mode is Disabled On Dashboard then Dark Mode Option is still visible on Dashboard");

		// Check Dark Mode menu on Course Page
		driver.get(coursepage);
		softAssert.assertFalse(DM.DarkModeNavMenu.size() > 0,
				"When Dark Mode is Disabled On Course View Pages then Dark Mode Option is still visible on View Course Page");

		// Not Selected Pages
		driver.get(profilepage);
		softAssert.assertTrue(DM.DarkModeNavMenu.size() > 0,
				"When Dark Mode Disabled on Specific Pages then Dark Mode not visible on Profile Page");

		// Enable Dark mode and Navigate to Non Dark Mode Pages
		DM.DarkModeIcon.click();
		Thread.sleep(1000);

		softAssert.assertTrue(DM.DarkModeMenu.getAttribute("class").contains("enabled"),
				"Dark Mode is not Getting Enabled on Click of Dark Mode Icon - Nav Menu");
		softAssert.assertTrue(DM.HTML.getAttribute("nighteyeplgn").contains("active"),
				"Dark Mode is not Getting Enabled on Click of Dark Mode Icon - DOM HTML");

		// Not Selected Pages
		driver.get(dashboard);
		Assert.assertNull(DM.HTML.getAttribute("nighteyeplgn"),
				"Dark Mode CSS Present On Non Selected Page - DOM HTML");

		driver.get(coursepage);
		Assert.assertNull(DM.HTML.getAttribute("nighteyeplgn"),
				"Dark Mode CSS Present On Non Selected Page - DOM HTML");

		// Return to Dark Mode Enabled Page Check Dark Mode is Still Enabled
		driver.get(profilepage);
		softAssert.assertTrue(DM.DarkModeMenu.getAttribute("class").contains("enabled"),
				"Check Dark mode is still enabled after navigating to Other Pages - Nav Menu");
		softAssert.assertTrue(DM.HTML.getAttribute("nighteyeplgn").contains("active"),
				"Check Dark mode is still enabled after navigating to Other Pages - DOM HTML");

		// Enable Light Mode
		DM.LightModeIcon.click();
		Thread.sleep(1500);

		// Check If Light Mode is Enabled OR Not
		softAssert.assertFalse(DM.DarkModeMenu.getAttribute("class").contains("enabled"),
				"Light Mode is not Getting Enabled on Click of Light Mode Icon  - Nav Menu");
		softAssert.assertTrue(DM.HTML.getAttribute("nighteyeplgn").contains("disabled"),
				"Light Mode is not Getting Enabled on Click of Dark Mode Icon - DOM HTML");

		softAssert.assertAll();
	}

	/**
	 * Disable Dark Mode Feature on Entire Site
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 3)
	public void Disable_Dark_Mode_From_Settings() throws InterruptedException {
		driver.get(remuisetting);
		DM.DarkModeSetting("disable");
		DM.savechanges.click();
		Thread.sleep(1000);

		// Check Dark Mode menu on Dashboard
		driver.get(dashboard);
		Assert.assertTrue(DM.DarkModeNavMenu.size() == 0,
				"When Dark Mode is disabled From Settings Then Dark Mode Option is still visible on Dashboard - Nav Menu");
		Assert.assertNull(DM.HTML.getAttribute("nighteyeplgn"),
				"When Dark Mode is disabled From Settings Then Dark Mode Option is still visible on Dashboard - DOM HTML");

		// Check Dark Mode menu on Course Page
		driver.get(coursepage);
		Assert.assertTrue(DM.DarkModeNavMenu.size() == 0,
				"When Dark Mode is disabled Dark Mode Option is still visible on Course Page");

	}

	/**
	 * Enable Dark Mode on All Pages
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 4)
	public void Enable_Dark_Mode_All_Pages_From_Settings() throws InterruptedException {

		SoftAssert softAssert = new SoftAssert();
		driver.get(remuisetting);
		DM.DarkModeSetting("allowonallpages");
		DM.savechanges.click();
		Thread.sleep(1000);

		// Check Dark Mode menu on Course Page
		driver.get(coursepage);
		softAssert.assertTrue(DM.DarkModeNavMenu.size() > 0,
				"When Dark Mode is Enabled On all Pages then Dark Mode Option is not visible on Course Page");

		// Check Dark Mode menu on Dashboard
		driver.get(dashboard);
		softAssert.assertTrue(DM.DarkModeNavMenu.size() > 0,
				"When Dark Mode is Enabled On all Pages then Dark Mode Option is not visible on Dashboard");
		Assert.assertNotNull(DM.HTML.getAttribute("nighteyeplgn"),
				"When Dark Mode is Enabled On all Pages then Dark Mode Attribute not present in - DOM HTML");

		if (DM.DarkModeMenu.getAttribute("class").contains("enabled")) {
			DM.LightModeIcon.click();
			Thread.sleep(1000);
		}
		// Enable Dark Mode
		DM.DarkModeIcon.click();
		Thread.sleep(500);

		// Check If Dark Mode is Enabled OR Not
		softAssert.assertTrue(DM.DarkModeMenu.getAttribute("class").contains("enabled"),
				"Dark Mode is not Getting Enabled on Click of Dark Mode Icon - Nav Menu");
		softAssert.assertTrue(DM.HTML.getAttribute("nighteyeplgn").contains("active"),
				"Dark Mode is not Getting Enabled on Click of Dark Mode Icon - DOM HTML");

		// Check On Other Pages when Dark Mode Is active
		driver.get(coursepage);
		softAssert.assertTrue(DM.DarkModeMenu.getAttribute("class").contains("enabled"),
				"Dark Mode State Not Maintained After Navigating to Other Pages - Course View Page");

		driver.get(profilepage);
		softAssert.assertTrue(DM.DarkModeMenu.getAttribute("class").contains("enabled"),
				"Dark Mode State Not Maintained After Navigating to Other Pages - Profile Page");
		softAssert.assertTrue(DM.HTML.getAttribute("nighteyeplgn").contains("active"),
				"Dark Mode is not Getting Enabled on Click of Dark Mode Icon - DOM HTML");

		driver.get(siteadminurl);
		softAssert.assertTrue(DM.DarkModeMenu.getAttribute("class").contains("enabled"),
				"Dark Mode State Not Maintained After Navigating to Other Pages - Site Admin Page");
		softAssert.assertTrue(DM.HTML.getAttribute("nighteyeplgn").contains("active"),
				"Dark Mode is not Getting Enabled on Click of Dark Mode Icon - DOM HTML");

		// Enable Light Mode
		DM.LightModeIcon.click();
		Thread.sleep(1000);

		// Check If Light Mode is Enabled OR Not
		softAssert.assertFalse(DM.DarkModeMenu.getAttribute("class").contains("enabled"),
				"Light Mode is not Getting Enabled on Click of Light Mode Icon  - Nav Menu");
		softAssert.assertTrue(DM.HTML.getAttribute("nighteyeplgn").contains("disabled"),
				"Light Mode is not Getting Enabled on Click of Dark Mode Icon - DOM HTML");

		// Check On Other Pages when Light Mode Is active
		driver.get(coursepage);
		softAssert.assertFalse(DM.DarkModeMenu.getAttribute("class").contains("enabled"),
				"Light Mode State Not Maintained After Navigating to Other Pages - Course View Page");

		driver.get(profilepage);
		softAssert.assertFalse(DM.DarkModeMenu.getAttribute("class").contains("enabled"),
				"Light Mode State Not Maintained After Navigating to Other Pages - Profile Page");

		softAssert.assertAll();
	}

	/**
	 * Check Dark Mode with non Logged In User
	 * 
	 * @throws InterruptedException
	 */
	@Parameters({ "siteURL", "username", "password" })
	@Test(priority = 5)
	public void Check_Dark_Mode_Option_with_Non_LoggedIn_User(String siteURL, String username, String password)
			throws InterruptedException {
		// LogOut From Site
		adminbackendlogout();
		Thread.sleep(1500);

		// Check Dark Mode menu on HomePage
		Assert.assertTrue(DM.DarkModeNavMenu.size() == 0, "Dark Mode Option Present for Non Logged In User - Nav Menu");
		Assert.assertNull(DM.HTML.getAttribute("nighteyeplgn"),
				"Dark Mode Option Present for Non Logged In User - DOM HTML");

		// Check Dark Mode menu on Course Archive (Category) Page
		driver.get(coursearchive);
		Assert.assertTrue(DM.DarkModeNavMenu.size() == 0,
				"Dark Mode Option Present for Non Logged In User - Course Archive Page");
		
		// Login to Admin
		studentLogin(siteURL, username, password);

	}

	/**
	 * Code For Testing Not Used
	 * 
	 * @throws InterruptedException
	 */
//	@Test(priority = 1)
	public void TestUserListQuickMenu() throws InterruptedException {
		driver.get(dashboard);
		// Find the target element
		WebElement Dark = driver.findElement(By.xpath("//span[contains(@class,'darkmodeicon')]"));
		WebElement Light = driver.findElement(By.xpath("//span[contains(@class,'lightmodeicon')]"));

		// Check if Dark mode Icons is shown
		System.out.println("Dark Mode Present : " + CheckElementBefore(Dark));

		// Check Light mode Icons is not shown
		System.out.println("Light Mode Present : " + CheckElementBefore(Light));

		Dark.click();
		Thread.sleep(10000);

		// Check if Dark mode Icons is not shown
		System.out.println(" After Click Dark Mode Present : " + CheckElementBefore(Dark));

		// Check Light mode Icons is shown
		System.out.println("After Click Light Mode Present : " + CheckElementBefore(Light));

		Light.click();
		Thread.sleep(10000);

		// Check if Dark mode Icons is shown
		System.out.println("2 Dark Mode Present : " + CheckElementBefore(Dark));

		// Check Light mode Icons is not shown
		System.out.println("2 Light Mode Present : " + CheckElementBefore(Light));

	}

	public boolean CheckElementBefore(WebElement element) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try {
			String beforeContent = (String) js.executeScript(
					"return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", element);

			// Check if the ::before pseudo-element has content
			if (beforeContent != null && !beforeContent.trim().isEmpty() && !"none".equals(beforeContent)) {
				System.out.println("The element contains a ::before pseudo-element with content: " + beforeContent);
				return true;
			} else {
				System.out.println("The element does not contain a ::before pseudo-element or its content is empty.");
			}
		} catch (Exception e) {
			System.out.println("In Catch");
			return false;
		}
		return false;
	}

}