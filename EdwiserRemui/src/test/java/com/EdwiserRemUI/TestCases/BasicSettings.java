package com.EdwiserRemUI.TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
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
		System.out.println("In Basic Settings Test Class : BasicSettings");
		sp = new SettingsPage(driver);
		hsp = new HeaderHideShowMenuPage(driver);
		cc = new ColorConversion();
	}

	@Test(priority = 1)
	public void Enable_Site_Wide_Announcement() throws InterruptedException {
		driver.get(remuisetting);
		Thread.sleep(2000);
		sp.basictab.click();
		Thread.sleep(2000);
		if (!sp.siteannouncementchbk.isSelected()) {
			sp.SiteAnnouncementLabel.click();
		}
		sp.siteannouncementtextbx.clear();
		sp.siteannouncementtextbx.sendKeys("This is Site Announcement By Edwiser RemUI");
		sp.savebutton.click();
		Assert.assertTrue(sp.alert.size() == 1, "Alert is not getting visible even when enabled from settings ");

	}

	@Test(priority = 2)
	public void Verify_Dismiss_Announcement_Icon_When_Enabled() throws InterruptedException {
		driver.get(remuisetting);
		Thread.sleep(2000);
		sp.basictab.click();
		if (!sp.siteannouncementchbk.isSelected()) {
			sp.SiteAnnouncementLabel.click();
		}
		if (!sp.dismisschbk.isSelected()) {
			sp.enabledismissicon.click();
		}
		sp.siteannouncementtextbx.clear();
		sp.siteannouncementtextbx.sendKeys("This is Site Announcement By Edwiser RemUI");
		sp.savebutton.click();

		Assert.assertTrue(sp.dismissbutton.size() == 1, "Dismiss icon is not visible even when enabled from setting ");

	}

	@Test(priority = 3)
	public void verifydismissannouncementwhendisabled() throws InterruptedException {
		driver.get(remuisetting);
		Thread.sleep(2000);
		sp.basictab.click();
		if (!sp.siteannouncementchbk.isSelected()) {
			sp.SiteAnnouncementLabel.click();
		}
		if (sp.dismisschbk.isSelected()) {
			sp.enabledismissicon.click();
		}
		sp.siteannouncementtextbx.clear();
		sp.siteannouncementtextbx.sendKeys("This is Site Announcement By Edwiser RemUI");
		sp.savebutton.click();

		Assert.assertTrue(sp.dismissbutton.size() == 0, "Dismiss icon is  visible even when disabled from setting ");
	}

	@Test(priority = 4)
	public void verifyfeedbackisenabled() throws InterruptedException {
		driver.get(remuisetting);
		Thread.sleep(2000);
		sp.basictab.click();
		if (!sp.chbk_feedback.isSelected()) {
			sp.labelfeedback.click();
		}
		sp.savebutton.click();
		Thread.sleep(2000);
		Assert.assertTrue(sp.icon_feedback.size() == 1,
				"Feedback floating icon is not present even when enabled from setting");

	}

	@Test(priority = 5)
	public void verifyfeedbackwhendisabled() throws InterruptedException {
		driver.get(remuisetting);
		Thread.sleep(2000);
		sp.basictab.click();
		if (sp.chbk_feedback.isSelected()) {
			sp.labelfeedback.click();
		}
		sp.savebutton.click();
		Thread.sleep(2000);
		Assert.assertTrue(sp.icon_feedback.size() == 0,
				"Feedback floating icon is still present even when disabled from setting");

	}

	@Test(priority = 6)
	public void verifysitename() throws InterruptedException {
		String SiteNameColor = "#698DFC";
		driver.get(remuisetting);
		sp.basictab.click();
		sp.colorinput.clear();
		sp.colorinput.sendKeys(SiteNameColor);
		sp.savebutton.click();
		Thread.sleep(2000);
		driver.get(dashboard);
		Thread.sleep(2000);
		Assert.assertEquals(ColorConversion.Color(sp.sitename.getCssValue("color")), SiteNameColor,
				"the colorcode didnt matched");
	}

	@Test(priority = 7)
	public void Disable_Site_Wide_Announcement() throws InterruptedException {
		driver.get(remuisetting);
		Thread.sleep(2000);
		sp.basictab.click();
		if (sp.siteannouncementchbk.isSelected()) {
			sp.SiteAnnouncementLabel.click();
		}
		sp.savebutton.click();
		Assert.assertTrue(sp.alert.size() == 0, "Alert is  getting visible even when disabled from settings ");

	}

}
