package com.EdwiserRemUI.TestCases;

import java.util.Iterator;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.EdwiserRemUI.BaseTest.BaseClass;
import com.EdwiserRemUI.PageObjects.FootercustomizerPage;
import com.EdwiserRemUI.PageObjects.HeaderHideShowMenuPage;

public class FooterCustomizerTest extends BaseClass {

	String a_ppl = "https://www.google.com/";
	String a_copyrights = "Copyrights@2023";
	String expected_remuititle = "New RemUI Moodle Theme: Engaging and Customizable Moodle Template 2023";

	HeaderHideShowMenuPage hsp;
	FootercustomizerPage fcp;

	@BeforeClass
	public void Before_class() {
		hsp = new HeaderHideShowMenuPage(driver);
		fcp = new FootercustomizerPage(driver);
	}

	// Check when privacy policy is enabled from customizer and redirecting to the
	// expexted url entered
	@Test(priority = 1)
	public void verifyprivacypolicywhenenabled() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		driver.get(customizer);
		fcp.footermenu.click();
		Thread.sleep(2000);
		fcp.fbottomareamenu.click();
		Thread.sleep(2000);
		boolean status = fcp.c_privacypolicytext.isDisplayed();
		System.out.println(status);
		if (status == true) {
			fcp.c_privacypolicytext.clear();
			fcp.c_privacypolicytext.sendKeys(a_ppl);
			Thread.sleep(2000);
			hsp.savebutton.click();
			Thread.sleep(2000);
			driver.get(homepage);
			softAssert.assertTrue(fcp.f_privacypolicy.size() == 1,
					"Privacy policy  is not visible even when shown from customizer setting ");
			Thread.sleep(2000);
			;
			fcp.f_privacypolicy1.click();
			String actualurl = driver.getCurrentUrl();
			softAssert.assertEquals(actualurl, a_ppl,
					" ON clicking privacy link it is not redirecting to expected url ");
			driver.get(homepage);
		} else {
			if (status == false) {
				fcp.c_privacypolicy.click();
				fcp.c_privacypolicytext.clear();
				fcp.c_privacypolicytext.sendKeys(a_ppl);
				Thread.sleep(2000);
				hsp.savebutton.click();
				Thread.sleep(2000);
				driver.get(homepage);
				softAssert.assertTrue(fcp.f_privacypolicy.size() == 1,
						"Privacy policy  is not visible even when shown from customizer setting ");

				fcp.f_privacypolicy1.click();
				String actualurl = driver.getCurrentUrl();
				softAssert.assertEquals(actualurl, a_ppl,
						" ON clicking privacy link it is not redirecting to expected url ");
			}
			driver.get(homepage);
		}
		softAssert.assertAll();
	}

	// Check when privacy policy is disabled from customizer
	@Test(priority = 2)
	public void verifyprivacypolicywhendisabled() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		driver.get(customizer);
		fcp.footermenu.click();
		Thread.sleep(2000);
		fcp.fbottomareamenu.click();
		Thread.sleep(2000);
		boolean status = fcp.c_privacypolicytext.isDisplayed();
		System.out.println(status);
		if (status == true) {
			fcp.c_privacypolicy.click();
			Thread.sleep(2000);
			hsp.savebutton.click();
			Thread.sleep(2000);
			driver.get(homepage);
			softAssert.assertTrue(fcp.f_privacypolicy.size() == 0,
					"Privacy policy  is  visible even when hidden from customizer setting ");
		} else {
			if (status == false) {
				driver.get(homepage);
				softAssert.assertTrue(fcp.f_privacypolicy.size() == 0,
						"Privacy policy  is  visible even when hidden from customizer setting ");
			}
			driver.get(homepage);
		}
		softAssert.assertAll();
	}

	// Check when terms and condition is enabled from customizer and redirecting to
	// the expexted url entered
	@Test(priority = 3)
	public void verifyverifytermsandconditionwhenenabled() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		driver.get(customizer);
		fcp.footermenu.click();
		Thread.sleep(2000);
		fcp.fbottomareamenu.click();
		Thread.sleep(2000);
		boolean status = fcp.c_tcshowtext.isDisplayed();
		System.out.println(status);
		if (status == true) {
			fcp.c_tcshowtext.clear();
			fcp.c_tcshowtext.sendKeys(a_ppl);
			Thread.sleep(2000);
			hsp.savebutton.click();
			Thread.sleep(2000);
			driver.get(homepage);
			softAssert.assertTrue(fcp.f_tc.size() == 1,
					"Terms and condition is not visible even when shown from customizer setting ");

			fcp.f_termsandcond.click();
			String actualurl = driver.getCurrentUrl();
			softAssert.assertEquals(actualurl, a_ppl,
					" ON clicking terms and condition  link it is not redirecting to expected url ");
			driver.get(homepage);
		} else {
			if (status == false) {
				fcp.c_tcshow.click();
				fcp.c_tcshowtext.clear();
				fcp.c_tcshowtext.sendKeys(a_ppl);
				Thread.sleep(2000);
				hsp.savebutton.click();
				Thread.sleep(2000);
				driver.get(homepage);
				softAssert.assertTrue(fcp.f_tc.size() == 1,
						"Terms and condition is not visible even when shown from customizer setting ");

				fcp.f_termsandcond.click();
				String actualurl = driver.getCurrentUrl();
				softAssert.assertEquals(actualurl, a_ppl,
						" ON clicking terms and condition it is not redirecting to expected url ");
			}
			driver.get(homepage);
		}
		softAssert.assertAll();
	}

	// check when terms and condition is disabled
	@Test(priority = 4)
	public void verifytermsandconditionwhendisabled() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		driver.get(customizer);
		fcp.footermenu.click();
		Thread.sleep(2000);
		fcp.fbottomareamenu.click();
		Thread.sleep(2000);
		boolean status = fcp.c_tcshowtext.isDisplayed();
		System.out.println(status);
		if (status == true) {
			fcp.c_tcshow.click();
			Thread.sleep(2000);
			hsp.savebutton.click();
			Thread.sleep(2000);
			driver.get(homepage);
			softAssert.assertTrue(fcp.f_tc.size() == 0,
					"Terms and condition  is  visible even when hidden from customizer setting ");
		} else {
			if (status == false) {
				driver.get(homepage);
				softAssert.assertTrue(fcp.f_tc.size() == 0,
						"Terms and condition   is  visible even when hidden from customizer setting ");
			}
			driver.get(homepage);
		}
		softAssert.assertAll();
	}

	// Check when copywrights is enabled from customizer and check the expected text

	@Test(priority = 5)
	public void verifycopyrightswhenenabled() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		driver.get(customizer);
		fcp.footermenu.click();
		Thread.sleep(2000);
		fcp.fbottomareamenu.click();
		Thread.sleep(2000);
		boolean status = fcp.c_copyrighttext.isDisplayed();
		System.out.println(status);
		if (status == true) {
			fcp.c_copyrighttext.clear();
			fcp.c_copyrighttext.sendKeys(a_copyrights);
			Thread.sleep(2000);
			hsp.savebutton.click();
			Thread.sleep(2000);
			driver.get(homepage);
			softAssert.assertTrue(fcp.f_copyright.size() == 1,
					"Copyrights is not visible even when shown from customizer setting ");

			String copyright_text = fcp.copyrighttext.getText();
			softAssert.assertEquals(copyright_text, a_copyrights,
					" The copyright text is not getting matched with expected text ");
			driver.get(homepage);
		} else {
			if (status == false) {
				fcp.c_copyright.click();
				fcp.c_copyrighttext.clear();
				fcp.c_copyrighttext.sendKeys(a_copyrights);
				Thread.sleep(2000);
				hsp.savebutton.click();
				Thread.sleep(2000);
				driver.get(homepage);
				softAssert.assertTrue(fcp.f_copyright.size() == 1,
						"Copyrights is not visible even when shown from customizer setting");

				String copyright_text = fcp.copyrighttext.getText();
				softAssert.assertEquals(copyright_text, a_copyrights,
						" The copyright text is not getting matched with expected text ");
			}
			driver.get(homepage);
		}
		softAssert.assertAll();
	}

	// check when copyrights is disabled
	@Test(priority = 6)
	public void verifycopyrightswhendisabled() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		driver.get(customizer);
		fcp.footermenu.click();
		Thread.sleep(2000);
		fcp.fbottomareamenu.click();
		Thread.sleep(2000);
		boolean status = fcp.c_copyrighttext.isDisplayed();
		System.out.println(status);
		if (status == true) {
			fcp.c_copyright.click();
			Thread.sleep(2000);
			hsp.savebutton.click();
			Thread.sleep(2000);
			driver.get(homepage);
			softAssert.assertTrue(fcp.f_copyright.size() == 0,
					"Copyrights  is  visible even when hidden from customizer setting ");
		} else {
			if (status == false) {
				driver.get(homepage);
				softAssert.assertTrue(fcp.f_copyright.size() == 0,
						"Copyrights is  visible even when hidden from customizer setting ");
			}
			driver.get(homepage);
		}
		softAssert.assertAll();
	}

	// Check when poweredby is enabled from customizer and redirecting to the
	// expexted url entered

	@Test(priority = 7)
	public void verifypoweredbywhenenabled() throws InterruptedException {
		fcp.f_helpicon.click();
		if (fcp.f_poweredby.size() == 1) {
			fcp.f_poweredbylink.click();
			Set<String> handle = driver.getWindowHandles();
			Iterator<String> it = handle.iterator();
			String parent = it.next();

			String child = it.next();
			driver.switchTo().window(child);
			String actualTitle = driver.getTitle();
			System.out.println(actualTitle);
			driver.switchTo().window(parent);
			Assert.assertEquals(actualTitle, expected_remuititle,
					"on clicking edwiser remui link it is not redirecting to the expected page");
		} else {
			driver.get(customizer);
			Thread.sleep(1500);
			fcp.footermenu.click();
			Thread.sleep(2000);
			fcp.fbottomareamenu.click();
			Thread.sleep(2000);
			fcp.c_poweredbyed.click();
			hsp.savebutton.click();
			Thread.sleep(2000);
			driver.get(dashboard);
			fcp.f_helpicon.click();
			fcp.f_poweredbylink.click();
			Set<String> handle = driver.getWindowHandles();
			Iterator<String> it = handle.iterator();
			String parent = it.next();

			String child = it.next();
			driver.switchTo().window(child);
			String actualTitle = driver.getTitle();
			System.out.println(actualTitle);
			driver.switchTo().window(parent);
			Assert.assertEquals(actualTitle, expected_remuititle,
					"on clicking edwiser remui link it is not redirecting to the expected page");

		}

	}

	// Check when poweredby is disabled from customizer
	@Test(priority = 8)
	public void verifypoweredbywhendisabled() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		fcp.f_helpicon.click();
		if (fcp.f_poweredby.size() == 1) {
			driver.get(customizer);
			fcp.footermenu.click();
			Thread.sleep(2000);
			fcp.fbottomareamenu.click();
			Thread.sleep(2000);
			fcp.c_poweredbyed.click();
			hsp.savebutton.click();
			Thread.sleep(2000);
			driver.get(dashboard);
			fcp.f_helpicon.click();
			softAssert.assertTrue(fcp.f_poweredby.size() == 0,
					"Copyrights is  visible even when hidden from customizer setting ");
		} else {
			softAssert.assertTrue(fcp.f_poweredby.size() == 0,
					"Copyrights is  visible even when hidden from customizer setting ");

		}
		softAssert.assertAll();
	}

}
