package setUp;

import java.time.Duration;
import java.util.ArrayList;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

/**
 * Prerequisites : 1.The plugin is installed and active 2.Store URL should be
 * set properly and the key should be of same store URL 4.Number of products to
 * be listed on product listing page should be more enough to display all the
 * products so that we can compare them directly 5.The correct course
 * names(which are synchronized) to be supplied from testng.xml file
 */
public class projectSetUp {

	public static WebDriver driver;
	static ArrayList<String> cliArgsCap = new ArrayList<String>();

	/*
	 * This method is used for first setup of the project here we will login to the
	 * system, create some products, etc.
	 */
	@Parameters({ "browser", "DriverPath" })
	@BeforeSuite
	public void DriverSetUp(String browser, String DriverPath) {

		// Now initiate the webdriver
		if (browser.equals("Firefox")) {
			// Set the gecko property so that it will not give security warning
			System.setProperty("webdriver.gecko.driver", DriverPath);
			driver = new FirefoxDriver();
		} else if (browser.equals("Chrome")) {
			// Set the chrome driver system property
//			System.setProperty("webdriver.chrome.driver", DriverPath);
			// driver = new ChromeDriver();
			WebDriverManager.chromedriver().setup();

			ChromeOptions options = new ChromeOptions();

			options.addArguments("--no-sandbox");

			options.addArguments("--disable-dev-shm-usage");

//			options.addArguments("--headless");

			options.addArguments("window-size=1400,900");

			driver = new ChromeDriver(options);
		}

		// Set the implicit wait time now so that system will run smoothly
		Duration d = Duration.ofSeconds(10);
		driver.manage().timeouts().implicitlyWait(d);

		// maximize the window
		driver.manage().window().maximize();

	}

	/**
	 * Close the Driver
	 */
	@AfterSuite
	public void AfterClass() {
		driver.quit();

	}
}