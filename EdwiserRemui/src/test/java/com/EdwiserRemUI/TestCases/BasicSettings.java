package com.EdwiserRemUI.TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.EdwiserRemUI.BaseTest.BaseClass;
import com.EdwiserRemUI.PageObjects.ColorConversion;

import com.EdwiserRemUI.PageObjects.HeaderHideShowMenuPage;
import com.EdwiserRemUI.PageObjects.SettingsPage;

public class BasicSettings extends BaseClass {

	SettingsPage sp;
	HeaderHideShowMenuPage hsp;
	ColorConversion cc;

	@BeforeClass
	public void Before_class() {
		sp = new SettingsPage(driver);
		hsp = new HeaderHideShowMenuPage(driver);
		cc = new ColorConversion();
	}

	@Test(priority = 1)
	public void verifysitewideannouncementwhenenabled() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		driver.get(remuisetting);
		sp.basictab.click();
		Thread.sleep(2000);
		String present = sp.siteannouncementchbk.getAttribute("Checked");
		boolean status = Boolean.parseBoolean(present);
		System.out.println(status);
		if (status == true) {
			sp.siteannouncementtextbx.clear();
			sp.siteannouncementtextbx.sendKeys("lorem ipsum");
			sp.savebutton.click();
			softAssert.assertTrue(sp.alert.size() == 1,
					"Alert is not getting visible even when enabled from settings ");
		} else {
			sp.enablesiteannouncement.click();
			sp.siteannouncementtextbx.clear();
			sp.siteannouncementtextbx.sendKeys("lorem ipsum");
			sp.savebutton.click();
			softAssert.assertTrue(sp.alert.size() == 1,
					"Alert is not getting visible even when enabled from settings ");

		}
		softAssert.assertAll();
	}

	@Test(priority = 2)
	public void verifysitewideannouncementwhendisabled() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		driver.get(remuisetting);
		sp.basictab.click();
		Thread.sleep(2000);
		String present = sp.siteannouncementchbk.getAttribute("Checked");
		boolean status = Boolean.parseBoolean(present);
		System.out.println(status);
		if (status == true) {
			sp.enablesiteannouncement.click();
			sp.savebutton.click();
			softAssert.assertTrue(sp.alert.size() == 0, "Alert is  getting visible even when disabled from settings ");
		} else {
			softAssert.assertTrue(sp.alert.size() == 0, "Alert is  getting visible even when disabled from settings ");

		}
		softAssert.assertAll();
	}

	@Test(priority = 3)
	public void verifydismissannouncementwhenenabled() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		driver.get(remuisetting);
		sp.basictab.click();
		Thread.sleep(2000);
		String present = sp.siteannouncementchbk.getAttribute("Checked");
		boolean status = Boolean.parseBoolean(present);
		System.out.println(status);
		if (status == true) {
			String present1 = sp.dismisschbk.getAttribute("Checked");
			boolean status1 = Boolean.parseBoolean(present1);
			System.out.println("status1 " + status1);
			if (status1 == true) {
				softAssert.assertTrue(sp.dismissbutton.size() == 1,
						"Dismiss icon is not visible even when enabled from setting ");
			} else {
				sp.enabledismissicon.click();
				sp.savebutton.click();
				softAssert.assertTrue(sp.dismissbutton.size() == 1,
						"Dismiss icon is not visible even when enabled from setting ");

			}
		} else {
			sp.enablesiteannouncement.click();
//			sp.siteannouncementtextbx.clear();
//			sp.siteannouncementtextbx.sendKeys("lorem ipsum1");
			Thread.sleep(2000);
			sp.enabledismissicon.click();
			sp.savebutton.click();
			softAssert.assertTrue(sp.dismissbutton.size() == 1,
					"Dismiss icon is not visible even when enabled from setting ");
		}
		softAssert.assertAll();
	}

//	@Test(priority=4)
//	public void verifydismissannouncementwhendisabled() throws InterruptedException {
//		SoftAssert softAssert = new SoftAssert();
//		driver.get(remuisetting);
//		sp.basictab.click();
//		Thread.sleep(2000);
//		String present=sp.siteannouncementchbk.getAttribute("Checked");
//		boolean status = Boolean.parseBoolean(present);
//		System.out.println(status);
//		if(status==true) {
//			String present1=sp.dismisschbk.getAttribute("Checked");
//			boolean status1 = Boolean.parseBoolean(present1);
//			System.out.println("status1 "+status1);
//			if(status1==true) {
//				softAssert.assertTrue(sp.dismissbutton.size()==0,
//						"Dismiss icon is  visible even when disabled from setting ");
//			}
//			else {
//				sp.enabledismissicon.click();
//				sp.savebutton.click();
//				softAssert.assertTrue(sp.dismissbutton.size()==0,
//						"Dismiss icon is  visible even when disabled from setting ");
//			
//			}
//		}
//		else {
//			sp.enablesiteannouncement.click();
//			sp.siteannouncementtextbx.clear();
//			sp.siteannouncementtextbx.sendKeys("lorem ipsum1");
//			Thread.sleep(2000);
//			String present1=sp.dismisschbk.getAttribute("Checked");
//			boolean status1 = Boolean.parseBoolean(present1);
//			System.out.println("status1 "+status1);
//			if(status1==true) {
//				softAssert.assertTrue(sp.dismissbutton.size()==0,
//						"Dismiss icon is  visible even when disabled from setting ");
//			}
//			else {
//				sp.enabledismissicon.click();
//				sp.savebutton.click();
//				softAssert.assertTrue(sp.dismissbutton.size()==0,
//						"Dismiss icon is  visible even when disabled from setting ");
//			
//			}
//	}
//		
//}

	@Test(priority = 5)
	public void verifyfeedbackisenabled() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		driver.get(remuisetting);
		sp.basictab.click();
		Thread.sleep(2000);
		String present = sp.chbk_feedback.getAttribute("Checked");
		boolean status = Boolean.parseBoolean(present);
		System.out.println(status);
		if (status == true) {
			softAssert.assertTrue(sp.icon_feedback.size() == 1,
					"Feedback floating icon is not present even when enabled from setting");
		} else {
			sp.labelfeedback.click();
			sp.savebutton.click();
			Thread.sleep(2000);
			softAssert.assertTrue(sp.icon_feedback.size() == 1,
					"Feedback floating icon is not present even when enabled from setting");
		}
		softAssert.assertAll();
	}

	@Test(priority = 6)
	public void verifyfeedbackwhendisabled() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		driver.get(remuisetting);
		sp.basictab.click();
		Thread.sleep(2000);
		String present = sp.chbk_feedback.getAttribute("Checked");
		boolean status = Boolean.parseBoolean(present);
		System.out.println(status);
		if (status == true) {
			sp.labelfeedback.click();
			sp.savebutton.click();
			Thread.sleep(2000);
			softAssert.assertTrue(sp.icon_feedback.size() == 0,
					"Feedback floating icon is still present even when disabled from setting");
		} else {
			softAssert.assertTrue(sp.icon_feedback.size() == 0,
					"Feedback floating icon is still present even when disabled from setting");

		}
		softAssert.assertAll();
	}

	@Test(priority = 7)
	public void verifyQuicklinkwhenenabled() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		driver.get(remuisetting);
		sp.basictab.click();
		Thread.sleep(2000);
		String present = sp.chbk_quicklink.getAttribute("Checked");
		boolean status = Boolean.parseBoolean(present);
		System.out.println(status);
		if (status == true) {
			softAssert.assertTrue(sp.icon_quicklink.size() == 1,
					"Quick link icon is not present even when enabled from setting");
		} else {
			sp.label_quicklink.click();
			sp.savebutton.click();
			Thread.sleep(2000);
			softAssert.assertTrue(sp.icon_quicklink.size() == 1,
					"Quick link icon is not present even when enabled from setting");
		}
		softAssert.assertAll();
	}

	@Test(priority = 8)
	public void verifyQuickLinkwhendisabled() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		driver.get(remuisetting);
		sp.basictab.click();
		Thread.sleep(2000);
		String present = sp.chbk_quicklink.getAttribute("Checked");
		boolean status = Boolean.parseBoolean(present);
		System.out.println(status);
		if (status == true) {
			sp.label_quicklink.click();
			sp.savebutton.click();
			Thread.sleep(2000);
			softAssert.assertTrue(sp.icon_quicklink.size() == 0,
					"Quick link icon is  present even when disabled from setting");
		} else {
			softAssert.assertTrue(sp.icon_quicklink.size() == 0,
					"Quick link icon is  present even when disabled from setting");

		}
		softAssert.assertAll();
	}

	@Test(priority = 9)
	public void verifysitename() throws InterruptedException {
		String actual = "#698DFC";
		SoftAssert softAssert = new SoftAssert();
		driver.get(remuisetting);
		sp.basictab.click();
		sp.colorinput.clear();
		sp.colorinput.sendKeys(actual);
		sp.savebutton.click();
		Thread.sleep(2000);
		driver.get(mycourses);
		String expected = ColorConversion.Color(sp.sitename.getCssValue("color"));
		System.out.println(expected);
		softAssert.assertEquals(actual, expected, "the colorcode didnt matched");
		softAssert.assertAll();
	}

}
