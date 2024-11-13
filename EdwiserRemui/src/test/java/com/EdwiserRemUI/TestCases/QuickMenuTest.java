package com.EdwiserRemUI.TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.EdwiserRemUI.BaseTest.BaseClass;
import com.EdwiserRemUI.PageObjects.QuickMenu;
import com.EdwiserRemUI.PageObjects.SettingsPage;

public class QuickMenuTest extends BaseClass {

	QuickMenu QM;
	SettingsPage sp;

	@BeforeClass
	public void Before_class() throws InterruptedException {
		System.out.println("In Quick Menu Test Class : QuickMenuTest");
		QM = new QuickMenu(driver);
		sp = new SettingsPage(driver);
		driver.get(remuisetting);
		sp.basictab.click();
		Thread.sleep(2000);

		boolean status = Boolean.parseBoolean(QM.chbk_quicklink.getAttribute("Checked"));
		if (status != true) {
			sp.label_quicklink.click();
			sp.savebutton.click();
			Thread.sleep(2000);
		}
	}

	@Test(priority = 1)
	public void TestUserListQuickMenu() throws InterruptedException {
		driver.get(dashboard);
		if (QM.QuickMenuCollapsed.size() > 0) {
			QM.QuickMenu.click();
		}
		QM.UserListIcon.click();
		Thread.sleep(500);
		Assert.assertEquals(driver.getCurrentUrl(), siteurl + "admin/user.php",
				"User List Quick Menu not redirecting to Users List page");

	}

	@Test(priority = 2)
	public void TestCoursesArchiveQuickMenu() throws InterruptedException {
		driver.get(dashboard);
		if (QM.QuickMenuCollapsed.size() > 0) {
			QM.QuickMenu.click();
		}
		QM.CourseArchiveIcon.click();
		Thread.sleep(500);
		Assert.assertEquals(driver.getCurrentUrl(), siteurl + "course/index.php",
				"Courses Quick Menu not redirecting to Courses Archive Page");

	}

	@Test(priority = 3)
	public void TestCreateCourseQuickMenu() throws InterruptedException {
		driver.get(dashboard);
		if (QM.QuickMenuCollapsed.size() > 0) {
			QM.QuickMenu.click();
		}
		QM.NewCourseIcon.click();
		Thread.sleep(500);
		Assert.assertEquals(driver.getCurrentUrl(), siteurl + "course/edit.php?category=1",
				"Create New Course Quick Menu not redirecting to Create New Course page");

	}

	@Test(priority = 4)
	public void TestRemUiSettingsQuickMenu() throws InterruptedException {
		driver.get(dashboard);
		if (QM.QuickMenuCollapsed.size() > 0) {
			QM.QuickMenu.click();
		}
		QM.EdwiserSettingsIcon.click();
		Thread.sleep(500);
		Assert.assertEquals(driver.getCurrentUrl(), siteurl + "admin/settings.php?section=themesettingremui",
				"RemUI Settings Quick Menu not redirecting to RemUi Settings page");

	}

	@Test(priority = 5)
	public void TestCustomizerQuickMenu() throws InterruptedException {
		driver.get(dashboard);
		if (QM.QuickMenuCollapsed.size() > 0) {
			QM.QuickMenu.click();
		}
		QM.CustomizerIcon.click();
		Thread.sleep(500);

		Assert.assertTrue(driver.getTitle().contains("Visual personalizer"),
				"Customizer Quick Menu not redirecting to Customizer page");

	}

}
