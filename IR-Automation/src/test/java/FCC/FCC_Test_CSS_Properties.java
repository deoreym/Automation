package FCC;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageClasses.OverviewSettings;
import setUp.projectSetUp;

import org.openqa.selenium.By;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FCC_Test_CSS_Properties {
	WebDriver driver;
	OverviewSettings OS_OB;
	String baseURL;
	String adminU;
	String adminP;

	@Parameters({ "siteURL", "username", "password", "Instructor1", "Instructor1Password", "Lesson", "Topic", "Quiz",
			"Section" })
	@BeforeClass
	public void DriverSetUp(String siteURL, String username, String password, String InstructorU, String InstructorP,
			String ex_lesson, String ex_topic, String ex_quiz, String section) throws Exception {
		driver = projectSetUp.driver;

// Initializing Overview Settings Object
		OS_OB = new OverviewSettings(driver);


// Setting User Details
		baseURL = siteURL;
		adminU = username;
		adminP = password;

// Admin Login
		OS_OB.loginToDashboard(driver, baseURL, adminU, adminP);
	}

	@Test
	public void IFrame_Test() throws Exception {
		driver.get("https://qa-ir.wisdmlabs.net/quiz-builder/3074/");
Thread.sleep(2000);
		try {
			// Locate the iframe containing the editor
			WebElement iframe = driver.findElement(By.xpath("//iframe[@id='ir-quiz-content-editor_ifr']"));

			// Switch to the iframe
			driver.switchTo().frame(iframe);

			// Now you're inside the iframe, interact with the editor
			WebElement editor = driver.findElement(By.tagName("body"));

			// Clear existing content (optional)
			editor.clear();

			// Type in content
			editor.sendKeys("Hello, this is content typed using Selenium!");

			// Switch back to the main frame (outside the iframe)
			driver.switchTo().defaultContent();
			WebElement title = driver.findElement(By.xpath("//label[text()='Quiz title']/..//input"));
			
			title.clear();
			title.sendKeys("TynyMCE");
			
			Thread.sleep(15000);
			System.out.println("Added to TynyMCE");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// @Test(priority = 1)
	public void CSS_Property_Test() throws Exception {

		driver.get("https://qa-remui.edwiser.org/m41/login/index.php");
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("admin");

		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("Golden0-");

		driver.findElement(By.id("loginbtn")).click();
		Thread.sleep(2000);
		driver.get("https://qa-remui.edwiser.org/m41/my/");

		WebElement FT2 = driver.findElement(By.xpath("//*[@id='footer-column-2']"));
		WebElement PB = driver.findElement(By.xpath("(//a[contains(@class,'btn-primary')])[1]"));

		WebElement HeaderMenu = driver.findElement(By.xpath("(//a[contains(text(),'Dashboard')])[1]"));
		WebElement HeaderMenuSite = driver.findElement(By.xpath("(//a[contains(text(),'Site administration')])[1]"));

		System.out.println("HeaderMenuDash BC = " + HeaderMenu.getCssValue("background-color"));
		System.out.println("HeaderMenuDash color = " + HeaderMenu.getCssValue("color"));
		System.out.println("HeaderMenuDash padding = " + HeaderMenu.getCssValue("padding"));
		System.out.println("HeaderMenuDash font-family = " + HeaderMenu.getCssValue("font-family"));
		System.out.println("HeaderMenuDash font-size = " + HeaderMenu.getCssValue("font-size"));
		System.out.println("HeaderMenuDash font-weight = " + HeaderMenu.getCssValue("font-weight"));
		System.out.println("HeaderMenuDash line-height = " + HeaderMenu.getCssValue("line-height"));
		System.out.println("HeaderMenuDash border-bottom-color = " + HeaderMenu.getCssValue("border-bottom-color"));

		System.out.println("HeaderMenuSite BC = " + HeaderMenuSite.getCssValue("background-color"));
		System.out.println("HeaderMenuSite color = " + HeaderMenuSite.getCssValue("color"));
		System.out.println("HeaderMenuSite padding = " + HeaderMenuSite.getCssValue("padding"));
		System.out.println("HeaderMenuSite font-family = " + HeaderMenuSite.getCssValue("font-family"));
		System.out.println("HeaderMenuSite font-size = " + HeaderMenuSite.getCssValue("font-size"));
		System.out.println("HeaderMenuSite font-weight = " + HeaderMenuSite.getCssValue("font-weight"));
		System.out.println("HeaderMenuSite line-height = " + HeaderMenuSite.getCssValue("line-height"));
		System.out.println("HeaderMenuSite border-bottom-color = " + HeaderMenuSite.getCssValue("border-bottom-color"));

		System.out.println("FT2BC = " + FT2.getCssValue("background-color"));
		System.out.println("PB BC = " + PB.getCssValue("background-color"));
		WebElement headerlogo = driver.findElement(By.xpath("(//nav//a[@aria-label='qaremui - Brand Name'])[1]"));
		String background_color = headerlogo.getCssValue("background-color");
		System.out.println("BC = " + background_color);

		// Converted
		System.out.println("Hex of Menu Color Dash " + Color(HeaderMenu.getCssValue("color")));
		System.out.println("Hex of Menu Color SA " + Color(HeaderMenuSite.getCssValue("color")));

	}

	public static String rgbToHex(int red, int green, int blue) {
		// Validate input values
		if (red < 0 || red > 255 || green < 0 || green > 255 || blue < 0 || blue > 255) {
			throw new IllegalArgumentException("Invalid RGB values");
		}

		// Combine components into a single integer value
		int rgb = (red << 16) | (green << 8) | blue;

		// Convert the integer value to hexadecimal string
		String hexColor = Integer.toHexString(rgb).toUpperCase();

		// Pad with zeros if necessary
		while (hexColor.length() < 6) {
			hexColor = "0" + hexColor;
		}

		return "#" + hexColor; // Add hash symbol
	}

	public static String Color(String rgbaString) {
//        String rgbaString = "rgba(15, 200, 188, 1)";
		String Hex = "";
		int[] rgbaValues = extractRGBAValues(rgbaString);

		if (rgbaValues != null) {
			int red = rgbaValues[0];
			int green = rgbaValues[1];
			int blue = rgbaValues[2];

			System.out.println("Red: " + red);
			System.out.println("Green: " + green);
			System.out.println("Blue: " + blue);
			Hex = rgbToHex(red, green, blue);
		} else {
			System.out.println("Invalid RGBA string format.");
		}
		return Hex;
	}

	public static int[] extractRGBAValues(String rgbaString) {
		int[] rgbaValues = new int[4];

		// Regular expression pattern to match rgba values
		String regex = "rgba\\((\\d+),\\s*(\\d+),\\s*(\\d+),\\s*(\\d*\\.?\\d+)\\)";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(rgbaString);

		if (matcher.matches()) {
			rgbaValues[0] = Integer.parseInt(matcher.group(1));
			rgbaValues[1] = Integer.parseInt(matcher.group(2));
			rgbaValues[2] = Integer.parseInt(matcher.group(3));
			return rgbaValues;
		}

		return null; // Return null if no match
	}
	/*
	 * HeaderMenuDash BC = rgba(0, 0, 0, 0) HeaderMenuDash color = rgba(15, 200,
	 * 188, 1) HeaderMenuDash padding = 8px 0px HeaderMenuDash font-family = Alata
	 * HeaderMenuDash font-size = 18px HeaderMenuDash font-weight = 600
	 * HeaderMenuDash line-height = 17px HeaderMenuDash border-bottom-color =
	 * rgba(15, 200, 188, 1) HeaderMenuSite BC = rgba(0, 0, 0, 0) HeaderMenuSite
	 * color = rgba(220, 53, 69, 1) HeaderMenuSite padding = 8px 0px HeaderMenuSite
	 * font-family = Alata HeaderMenuSite font-size = 18px HeaderMenuSite
	 * font-weight = 600 HeaderMenuSite line-height = 17px HeaderMenuSite
	 * border-bottom-color = rgba(220, 53, 69, 1) FT2BC = rgba(0, 0, 0, 0) PB BC =
	 * rgba(15, 200, 188, 1) BC = rgba(255, 193, 7, 1) Red: 15 Green: 200 Blue: 188
	 * Hex of Menu Color Dash #0FC8BC Red: 220 Green: 53 Blue: 69 Hex of Menu Color
	 * SA #DC3545
	 */

}
