package com.EdwiserRemUI.TestCases;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.EdwiserRemUI.BaseTest.BaseClass;
import com.EdwiserRemUI.PageObjects.ColorConversion;
import com.EdwiserRemUI.PageObjects.LoginSettingsPage;

public class LoginSettingsTest extends BaseClass {

	LoginSettingsPage lsp;
	Select dropdown;
	String User;
	String Pass;

	@Parameters({ "username", "password" })
	@BeforeClass
	public void Before_class(String username, String password) {

		lsp = new LoginSettingsPage(driver);
		User = username;
		Pass = password;
	}

	@AfterClass
	public void After_class() throws InterruptedException {
		adminbackendLogin(User, Pass);
	}

	@Test(priority = 1)
	public void showLogo_disable() throws InterruptedException {

		driver.get(customizer);
		lsp.loginMenu.click();
		lsp.loginSetting.click();

		dropdown = new Select(lsp.showLogoOnLoginPage);
		dropdown.selectByValue("0");
		lsp.saveButton.click();
		Thread.sleep(3000);
		driver.get(siteurl);
		adminbackendlogout();
		driver.get(loginpage);

		Assert.assertTrue(lsp.logoOnLoginPage.size() <= 0,
				"After disabling the show logo on login page still logo is getting displayed");
	}

	@Test(priority = 2)
	public void showLogo_OnLoginCard() throws InterruptedException {
		adminbackendLogin(User, Pass);
		driver.get(customizer);
		lsp.loginMenu.click();
		lsp.loginSetting.click();

		dropdown = new Select(lsp.showLogoOnLoginPage);
		dropdown.selectByValue("1");
		lsp.saveButton.click();
		Thread.sleep(3000);
		driver.get(siteurl);
		adminbackendlogout();
		driver.get(loginpage);

		Assert.assertTrue(lsp.logoOnLoginCard.size() > 0,
				"After selecting the Show Logo on the login card the logo is not getting displayed on the login card");
	}

	@Test(priority = 3)
	public void showLogo_OnCentralRegion() throws InterruptedException {
		adminbackendLogin(User, Pass);
		driver.get(customizer);
		lsp.loginMenu.click();
		lsp.loginSetting.click();

		dropdown = new Select(lsp.showLogoOnLoginPage);
		dropdown.selectByValue("2");
		lsp.saveButton.click();
		Thread.sleep(3000);
		driver.get(siteurl);
		adminbackendlogout();
		driver.get(loginpage);

		Assert.assertTrue(lsp.logoOnCentralRegion.size() > 0,
				"After selecting the Show Logo on the central region the logo is not getting displayed in the central region");
	}

	@Test(priority = 4)
	public void loginFormPosition_Center() throws InterruptedException {
		adminbackendLogin(User, Pass);
		driver.get(customizer);
		lsp.loginMenu.click();
		lsp.loginFromSettings.click();

		dropdown = new Select(lsp.loginFormPosition);
		dropdown.selectByValue("logincenter");
		lsp.saveButton.click();
		Thread.sleep(3000);
		driver.get(siteurl);
		adminbackendlogout();
		driver.get(loginpage);

		Assert.assertTrue(lsp.loginFormPositionFrontend.getAttribute("class").contains("logincenter"),
				"Login Form Position is set to Center in customization but the login form is not getting displayed in center on Frontend");
	}

	@Test(priority = 5)
	public void loginFormPosition_LeftSide() throws InterruptedException {
		adminbackendLogin(User, Pass);
		driver.get(customizer);
		lsp.loginMenu.click();
		lsp.loginFromSettings.click();

		dropdown = new Select(lsp.loginFormPosition);
		dropdown.selectByValue("loginleft");
		lsp.saveButton.click();
		Thread.sleep(3000);
		driver.get(siteurl);
		adminbackendlogout();
		driver.get(loginpage);

		Assert.assertTrue(lsp.loginFormPositionFrontend.getAttribute("class").contains("loginleft"),
				"Login Form Position is set to left in customization but the login form is not getting displayed on leftside on Frontend");
	}

	@Test(priority = 6)
	public void loginFormPosition_RightSide() throws InterruptedException {
		adminbackendLogin(User, Pass);
		driver.get(customizer);
		lsp.loginMenu.click();
		lsp.loginFromSettings.click();

		dropdown = new Select(lsp.loginFormPosition);
		dropdown.selectByValue("loginright");
		lsp.saveButton.click();
		Thread.sleep(3000);
		driver.get(siteurl);
		adminbackendlogout();
		driver.get(loginpage);

		Assert.assertTrue(lsp.loginFormPositionFrontend.getAttribute("class").contains("loginright"),
				"Login Form Position is set to right in customization but the login form is not getting displayed on rightside on Frontend");
	}

	@Test(priority = 7)
	public void welcomeTextColor() throws InterruptedException {
		adminbackendLogin(User, Pass);
		SoftAssert softassert = new SoftAssert();
		driver.get(customizer);
		lsp.loginMenu.click();
		lsp.loginFromSettings.click();
		Thread.sleep(1000);

		lsp.welcomeTextColor.click();
		lsp.colorTextField.clear();
		lsp.colorTextField.sendKeys("#FFC107");
		lsp.chooseButton.click();
		Thread.sleep(1000);
		lsp.textColor.click();
		lsp.colorTextField.clear();
		lsp.colorTextField.sendKeys("#DC3545");
		lsp.chooseButton.click();
		Thread.sleep(1000);
		lsp.linkColor.click();
		lsp.colorTextField.clear();
		lsp.colorTextField.sendKeys("#F2FA00");
		lsp.chooseButton.click();
		Thread.sleep(1000);
		lsp.linkHoverColor.click();
		lsp.colorTextField.clear();
		lsp.colorTextField.sendKeys("#EAC2B8");
		lsp.chooseButton.click();
		Thread.sleep(1000);
		lsp.pageBackgroundColor.click();
		lsp.colorTextField.clear();
		lsp.colorTextField.sendKeys("#00feff");
		lsp.chooseButton.click();
		Thread.sleep(1000);
		lsp.saveButton.click();

		Thread.sleep(3000);
		driver.get(siteurl);
		adminbackendlogout();
		driver.get(loginpage);

		softassert.assertEquals(ColorConversion.Color(lsp.welcomeTextFrontend.getCssValue("color")), "#FFC107",
				"The selected welcome text color for login form is not getting applied on the frontend login form");

		softassert.assertEquals(ColorConversion.Color(lsp.textColorFrontend.getCssValue("color")), "#DC3545",
				"The selected text color for login form is not getting applied on the frontend login form");

		softassert.assertEquals(ColorConversion.Color(lsp.linkColorFrontend.getCssValue("color")), "#F2FA00",
				"The selected link color for login form is not getting applied on the links on the frontend login form");

		Actions actions = new Actions(driver);
		actions.moveToElement(lsp.linkColorFrontend).perform();

		softassert.assertEquals(ColorConversion.Color(lsp.linkColorFrontend.getCssValue("color")), "#EAC2B8",
				"The selected text color for login form is not getting applied on the element");

		softassert.assertEquals(ColorConversion.Color(lsp.pageBackgroundColorFrontend.getCssValue("background-color")),
				"#00FEFF",
				"The selected background color for login form is not getting applied on the background of login form on frontend");
		Thread.sleep(1000);
		softassert.assertAll();
	}

	@Test(priority = 8)
	public void pageBackgroundStyle_Image() throws InterruptedException {
		adminbackendLogin(User, Pass);
		driver.get(customizer);
		lsp.loginMenu.click();
		lsp.loginPageSettings.click();
		Thread.sleep(1000);

		dropdown = new Select(lsp.pageBackgroundStyle);
		dropdown.selectByValue("image");
		lsp.saveButton.click();
		Thread.sleep(3000);
		driver.get(siteurl);
		adminbackendlogout();
		driver.get(loginpage);

		Boolean a = lsp.loginPageBackground.getCssValue("background-image").contains("login_bg");

		// url("https://qa-remui80.edwiser.org/m43/pluginfile.php/1/theme_remui/loginsettingpic/1714478861/90735-animated-landscape-2560x1440-wallpaper.png")
		Assert.assertTrue(a, "The image set as background for Login Page is not getting displayed on Frontend");
	}

	@Test(priority = 9)
	public void pageBackgroundStyle_Color() throws InterruptedException {
		adminbackendLogin(User, Pass);
		driver.get(customizer);
		lsp.loginMenu.click();
		lsp.loginPageSettings.click();
		Thread.sleep(1000);

		dropdown = new Select(lsp.pageBackgroundStyle);
		dropdown.selectByValue("color");

		lsp.pageColor.click();
		lsp.colorTextField.clear();
		lsp.colorTextField.sendKeys("#F6ECE9");
		lsp.chooseButton.click();

		lsp.saveButton.click();
		Thread.sleep(3000);
		driver.get(siteurl);
		adminbackendlogout();
		driver.get(loginpage);

		Assert.assertEquals(ColorConversion.Color(lsp.loginPageBackground.getCssValue("background-color")), "#F6ECE9",
				"The color set as background for Login Page is not getting displayed on Frontend");
	}

	@Test(priority = 10)
	public void pageBackgroundStyle_Gradient() throws InterruptedException {
		adminbackendLogin(User, Pass);
		driver.get(customizer);
		lsp.loginMenu.click();
		lsp.loginPageSettings.click();
		Thread.sleep(1000);

		dropdown = new Select(lsp.pageBackgroundStyle);
		dropdown.selectByValue("gradient");
		lsp.saveButton.click();
		Thread.sleep(3000);
		driver.get(siteurl);
		adminbackendlogout();
		driver.get(loginpage);
		Assert.assertTrue(lsp.loginPageBackground.getCssValue("background-image").contains("linear-gradient"),
				"The Gradient background for Login Page is not getting applied on Frontend");

	}

	@Test(priority = 11)
	public void siteDescription_siteDescriptionColor() throws InterruptedException {
		adminbackendLogin(User, Pass);
		SoftAssert softassert = new SoftAssert();
		driver.get(customizer);
		lsp.loginMenu.click();
		lsp.loginPageSettings.click();
		Thread.sleep(1000);

		lsp.siteDescriptionInput.clear();
		lsp.siteDescriptionInput.sendKeys("Welcome! to Edwiser site.");
//		driver.switchTo().frame(lsp.siteDescription);
//		lsp.siteDescriptionText.clear();
//		lsp.siteDescriptionText.sendKeys("Welcome! to Edwiser site.");
//		driver.switchTo().defaultContent();
		lsp.siteDescriptionColor.click();
		lsp.colorTextField.clear();
		lsp.colorTextField.sendKeys("#EFF209");
		lsp.chooseButton.click();
		lsp.saveButton.click();
		Thread.sleep(3000);
		driver.get(siteurl);
		adminbackendlogout();
		driver.get(loginpage);

		softassert.assertTrue(lsp.loginDescriptionText.getText().contains("Welcome! to Edwiser site."),
				"Site Description Texted Added in the customization is not getting displayed or is not correct");

		softassert.assertEquals(ColorConversion.Color(lsp.siteDescriptionTextColor.getCssValue("color")), "#EFF209",
				"The selected welcome text color for login form is not getting applied on the frontend login form");

		softassert.assertAll();
	}

}
