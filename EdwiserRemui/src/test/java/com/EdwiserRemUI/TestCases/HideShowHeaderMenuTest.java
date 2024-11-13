package com.EdwiserRemUI.TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.EdwiserRemUI.BaseTest.BaseClass;
import com.EdwiserRemUI.PageObjects.HeaderHideShowMenuPage;

public class HideShowHeaderMenuTest extends BaseClass {

	HeaderHideShowMenuPage hsp;
	String Categories_Title = "Course Cat";

	@BeforeClass
	public void Before_class() {
		System.out.println("In Hide Show Header Menu Test Class : HideShowHeaderMenuTest");
		hsp = new HeaderHideShowMenuPage(driver);
	}

	/**
	 * Hide All Header Menus From Customizer and Check on Site Header
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 1)
	public void Hide_All_Default_Menus_From_Header() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		driver.get(customizer);
		hsp.headermenu.click();
		hsp.hideshowmenu.click();

		if (!hsp.homemenu.isSelected()) {
			hsp.homemenulabel.click();
		}
		if (!hsp.mycoursesmenu.isSelected()) {
			hsp.mycourseslabel.click();
		}
		if (!hsp.dashboardmenu.isSelected()) {
			hsp.DashboardMenuLabel.click();
		}
		if (!hsp.siteAdminMenu.isSelected()) {
			hsp.siteAdminMenulabel.click();
		}
		if (hsp.recentmenu.isSelected()) {
			hsp.recentmenulabel.click();
		}
		if (hsp.CategoryDropDown.isSelected()) {
			hsp.CategoryDropDownLabel.click();
		}
		hsp.savebutton.click();
		Thread.sleep(2000);

		driver.get(dashboard);
		Thread.sleep(2000);

		// Check All Hidden Menus on Site Header
		softAssert.assertEquals(hsp.Home_Menu.getCssValue("display"), "none",
				"Home menu is still visible even when hidden from customizer setting ");
		softAssert.assertEquals(hsp.Dashboard_Menu.getCssValue("display"), "none",
				"Dashboard menu is still visible even when hidden from customizer setting ");
		softAssert.assertEquals(hsp.Mycourses_Menu.getCssValue("display"), "none",
				"MyCourses menu is still visible even when hidden from customizer setting ");
		softAssert.assertEquals(hsp.Site_Admin_Menu.getCssValue("display"), "none",
				"Site Administration menu is still visible even when hidden from customizer setting ");
		softAssert.assertEquals(hsp.Recent_Courses.getCssValue("display"), "none",
				"Recent Courses menu is still visible even when hidden from customizer setting ");
		softAssert.assertEquals(hsp.Categories_Menu.getCssValue("display"), "none",
				"Categories DropDown menu is still visible even when hidden from customizer setting ");

		softAssert.assertAll();
	}

	/**
	 * Show All Header Menus From Customizer and Check on Site Header
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 2)
	public void Show_All_Default_Menus_From_Header() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		driver.get(customizer);
		hsp.headermenu.click();
		hsp.hideshowmenu.click();

		if (hsp.homemenu.isSelected()) {
			hsp.homemenulabel.click();
		}
		if (hsp.mycoursesmenu.isSelected()) {
			hsp.mycourseslabel.click();
		}
		if (hsp.dashboardmenu.isSelected()) {
			hsp.DashboardMenuLabel.click();
		}
		if (hsp.siteAdminMenu.isSelected()) {
			hsp.siteAdminMenulabel.click();
		}
		if (!hsp.recentmenu.isSelected()) {
			hsp.recentmenulabel.click();
		}
		if (!hsp.CategoryDropDown.isSelected()) {
			hsp.CategoryDropDownLabel.click();
			hsp.CategoryDropDownText.clear();
			hsp.CategoryDropDownText.sendKeys(Categories_Title);
		}
		hsp.savebutton.click();
		Thread.sleep(2000);

		driver.get(dashboard);
		Thread.sleep(2000);

		// Check All Hidden Menus on Site Header
		softAssert.assertEquals(hsp.Home_Menu.getCssValue("display"), "block",
				"Home menu is not visible even when enabled from customizer setting ");
		softAssert.assertEquals(hsp.Dashboard_Menu.getCssValue("display"), "block",
				"Dashboard menu is not visible even when enabled from customizer setting ");
		softAssert.assertEquals(hsp.Mycourses_Menu.getCssValue("display"), "block",
				"MyCourses menu is not visible even when enabled from customizer setting ");
		softAssert.assertEquals(hsp.Site_Admin_Menu.getCssValue("display"), "block",
				"Site Administration menu is not visible even when enabled from customizer setting ");
		softAssert.assertEquals(hsp.Recent_Courses.getCssValue("display"), "block",
				"Recent Courses menu is not visible even when enabled from customizer setting ");
		softAssert.assertEquals(hsp.Categories_Menu.getCssValue("display"), "block",
				"Categories DropDown menu is not visible even when enabled from customizer setting ");
		softAssert.assertTrue(hsp.Categories_Menu.getText().contains(Categories_Title),
				"Categories DropDown menu is still visible even when hidden from customizer setting ");

		softAssert.assertAll();

	}

}
