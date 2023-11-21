package com.EdwiserRemUI.BaseTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.EdwiserRemUI.PageObjects.LoginLogoutPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public String siteurl = "http://localhost/v43/";
	public String profilepage = siteurl + "user/profile.php#usercourses";
	public String blogpage = siteurl + "blog/index.php?userid=2";
	public String forumpage = siteurl + "mod/forum/discuss.php?d=1#p2";
	public String siteadminurl = siteurl + "admin/search.php";
	public String dashboard = siteurl + "my/";
	public String coursearchive = siteurl + "course/index.php?categoryid=all";
	public String remuisetting = siteurl + "admin/settings.php?section=themesettingremui";
	public String managecoursecategory = siteurl + "course/management.php";
	public String remuifootersetting = siteurl + "admin/settings.php?section=themesettingremui#theme_remui_footer";
	public String mycourses = siteurl + "my/courses.php";
	public String coursepage = siteurl + "course/view.php?id=21";
	public String courseName = "Testing Course - 18 - Automation Course - 1";
	public String coursepage1 = siteurl + "course/view.php?id=22";
	public String EnrolmentTestCourse = siteurl + "course/view.php?id=40";
	public String CourseEnrolmentPage = siteurl + "enrol/index.php?id=40";
	public String CourseIntroVideo = "https://www.youtube.com/embed/MIWu2FCPnIQ";
	public String homepage = siteurl + "?redirect=0";
//	public String RemUISettings = siteurl + "admin/settings.php?section=themesettingremui";

	public static WebDriver driver;

	@Parameters({ "siteURL", "username", "password" })
	@BeforeTest
	public void adminbackendLogin(String siteURL, String username, String password) throws InterruptedException {

		driver.get(siteurl);
		Thread.sleep(1500);
		LoginLogoutPage ll = new LoginLogoutPage(driver);
		ll.clickonlogin.click();

		ll.username.sendKeys(username);
		ll.password.sendKeys(password);
		ll.loginbtn.click();
		Thread.sleep(2000);
	}

	public void studentLogin(String siteURL, String username, String password) throws InterruptedException {

		driver.get(siteurl);
		Thread.sleep(1500);
		LoginLogoutPage ll = new LoginLogoutPage(driver);
		ll.clickonlogin.click();
		ll.username.sendKeys(username);
		ll.password.sendKeys(password);
		ll.loginbtn.click();
		Thread.sleep(2000);
	}

	@AfterTest
	public void adminbackendlogout() throws InterruptedException {
		driver.get(dashboard);
		Thread.sleep(1500);
		LoginLogoutPage ll = new LoginLogoutPage(driver);
		ll.clickonlogin.click();
		ll.logout.click();
	}

	@BeforeSuite
	public void setup() throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();

		options.addArguments("--no-sandbox");

		options.addArguments("--disable-dev-shm-usage");

		// options.addArguments("--headless");

		options.addArguments("window-size=1400,900");

		driver = new ChromeDriver(options);

		// Set the implicit wait time now so that system will run smoothly
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		// maximize the window
		driver.manage().window().maximize();
	}

	@AfterSuite
	public void tearDown() {
		driver.quit();
	}

}
